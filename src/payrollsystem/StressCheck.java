package payrollsystem;

import java.nio.file.*;
import java.sql.*;
import java.util.*;

// Stress and adversarial runs for the SSEP (Run File; optional argument = number of login attempts, default 500).
// Prints measured numbers only. It reads data but never changes it (apart from adding lines to access_denied.log).
public class StressCheck {
    public static void main(String[] a) throws Exception {
        int n = Integer.parseInt(a.length > 0 ? a[0] : "500");
        // 1. Brute force: n rapid wrong-password logins on one account (Control 1)
        long t0 = System.nanoTime(); int rejected = 0, errors = 0;
        long min = Long.MAX_VALUE, max = 0;
        for (int i = 0; i < n; i++) {
            long s = System.nanoTime();
            try { if (new Login(10001, "Wrong" + i + "!x").checkCredentials().isEmpty()) rejected++; }
            catch (Throwable e) { errors++; if (errors == 1) System.out.println("first error at attempt " + (i + 1) + ": " + e); }
            long d = System.nanoTime() - s; min = Math.min(min, d); max = Math.max(max, d);
        }
        double total = (System.nanoTime() - t0) / 1e9;
        System.out.printf("C1-S1 %d wrong-password logins: rejected=%d errors=%d total=%.1fs avg=%.0fms min=%.0fms max=%.0fms%n",
                n, rejected, errors, total, total * 1000 / n, min / 1e6, max / 1e6);
        Connection c0 = new DatabaseConnection().getDBConnection(); try (Statement st = c0.createStatement();
             ResultSet r = st.executeQuery("SHOW STATUS LIKE 'Threads_connected'")) { r.next(); System.out.println("      MySQL Threads_connected after the run: " + r.getString(2)); }

        // 2. Offline attack on a stolen hash (Control 1): BCrypt cost 12 speed on this machine
        String hash = null;
        Connection c1 = new DatabaseConnection().getDBConnection();
        try (PreparedStatement ps = c1.prepareStatement("SELECT employee_password FROM credentials WHERE employee_id = 10003")) {
            ResultSet r = ps.executeQuery(); r.next(); hash = r.getString(1);
        }
        long s2 = System.nanoTime(); int tries = 0; String found = null;
        // attacker's list: guessable values from payslips/HR records (employee IDs 10001..10050), then common passwords
        List<String> words = new ArrayList<>();
        for (int id = 10001; id <= 10050; id++) words.add(String.valueOf(id));
        words.addAll(Arrays.asList("password", "123456", "12345678", "motorph", "MotorPH123", "Password1!", "qwerty"));
        for (String w : words) { tries++; if (PasswordUtil.verify(w, hash)) { found = w; break; } }
        double secs = (System.nanoTime() - s2) / 1e9;
        double rate = tries / secs;
        System.out.printf("C1-S2 offline guessing vs stolen hash of 10003 (still on initial password): %s after %d guesses in %.1fs (%.1f guesses/s on 1 CPU core)%n",
                found == null ? "NOT cracked" : "CRACKED ('" + found + "')", tries, secs, rate);
        System.out.printf("      at that speed a 14,344,391-word list (rockyou.txt) takes %.0f days per hash on 1 core%n", 14344391 / rate / 86400);
        String strong = PasswordUtil.hash("NewPass03!");
        int t2 = 0; boolean hit = false;
        for (String w : words) { t2++; if (PasswordUtil.verify(w, strong)) { hit = true; break; } }
        System.out.println("C1-S3 same list vs a changed, policy-compliant password: " + (hit ? "CRACKED" : "NOT cracked") + " (" + t2 + " guesses)");

        // 3. RBAC flood (Control 4): many denied calls, check overhead + log
        Path log = Paths.get(AccessControl.DENIED_LOG);
        long before = Files.exists(log) ? Files.readAllLines(log).size() : 0;
        SessionContext.start("10003", Role.EMPLOYEE);
        int denied = 0; long s3 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            try { new PdfGenerator().readEmployeeDetailsFromDB("10005", new java.util.Date(), new java.util.Date()); }
            catch (SecurityException e) { denied++; }
        }
        double ms = (System.nanoTime() - s3) / 1e6;
        long after = Files.readAllLines(log).size();
        System.out.printf("C4-S1 1000 rapid forbidden calls: denied=%d logged=%d total=%.0fms%n", denied, after - before, ms);
        long s4 = System.nanoTime();
        for (int i = 0; i < 100000; i++) AccessControl.isAllowed(Role.PAYROLL_STAFF, Action.VIEW_PAYROLL);
        System.out.printf("C4-S2 permission check cost: %.2f microseconds per check (100,000 checks)%n", (System.nanoTime() - s4) / 1e3 / 100000);
        SessionContext.end();
        Runtime.getRuntime().halt(0);
    }
}
