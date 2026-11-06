package payrollsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

// Control 1 assurance tests (feedback round): the same password rules on every path, BCrypt truncation,
// SQL injection at login, and a database integrity check. Run: right-click -> Run File.
// Uses the test accounts from the Implementation Log; it never changes any stored password.
public class PasswordPolicyCheck {
    static int passed = 0, failed = 0;
    static final String LONG_72 = "Aa1!".repeat(18);        // exactly 72 bytes
    static final String LONG_73 = LONG_72 + "X";            // 73 bytes: BCrypt would silently ignore the last one

    public static void main(String[] args) throws Exception {
        String before = checksum();

        // A. One rule set (PasswordPolicy) used by the change dialog, Login.changePassword and HR
        check("C1-P1 rejects 'test1234' (no uppercase / special)", PasswordPolicy.check("test1234", "10035", null) != null);
        check("C1-P2 rejects a 7-character password", PasswordPolicy.check("Ab1!xyz", "10035", null) != null);
        check("C1-P3 rejects the employee ID as password", PasswordPolicy.check("10035", "10035", null) != null);
        check("C1-P4 rejects a 73-byte password (truncation)", PasswordPolicy.check(LONG_73, "10035", null) != null);
        check("C1-P5 accepts a 72-byte strong password", PasswordPolicy.check(LONG_72, "10035", null) == null);
        check("C1-P6 accepts 'NewPass10!'", PasswordPolicy.check("NewPass10!", "10035", null) == null);
        check("C1-P7 change dialog uses the same rule", ChangePasswordDialog.checkNewPassword("test1234", "test1234", "10002", "10002") != null);

        // B. Backend paths enforce the rule even if a screen is skipped
        SessionContext.start("10010", Role.HUMAN_RESOURCE);
        int rowsBefore = count("SELECT COUNT(*) FROM credentials WHERE employee_id = 10005 AND role = 'Payroll Staff'");
        try{
            new HumanResource("10010").addNewCredentials(new ArrayList<>(Arrays.asList("10005", "test1234", "Payroll Staff")));
        }catch(java.awt.HeadlessException e){
            // the error pop-up cannot be shown when the test runs without a screen; the database is checked below
        }
        check("C1-P8 HR backend refuses weak password 'test1234' (no row added)",
                count("SELECT COUNT(*) FROM credentials WHERE employee_id = 10005 AND role = 'Payroll Staff'") == rowsBefore);
        SessionContext.end();

        // C1-P9: call changePassword() as if the login had succeeded (no real password needed).
        // The rule check runs before any SQL, so a refused password never touches the database (see C1-P17).
        Login login = new Login(10002, "not-used");
        java.lang.reflect.Field matched = Login.class.getDeclaredField("matchedRole");
        matched.setAccessible(true);
        matched.set(login, "Payroll Staff");
        check("C1-P9 Login.changePassword('abc') refused by the backend", !login.changePassword("abc"));

        // C. BCrypt truncation: the 72-byte limit is applied when checking, too
        String hash72 = PasswordUtil.hash(LONG_72);
        check("C1-P10 73-byte variant does not match the 72-byte hash", !PasswordUtil.verify(LONG_73, hash72));
        check("C1-P11 exact 72-byte password still matches", PasswordUtil.verify(LONG_72, hash72));

        // D. SQL injection at login (PreparedStatement + BCrypt, numeric ID)
        check("C1-P12 password ' OR '1'='1 does not log in", new Login(10001, "' OR '1'='1").checkCredentials().isEmpty());
        check("C1-P13 password ' OR 1=1 -- does not log in", new Login(10001, "' OR 1=1 -- ").checkCredentials().isEmpty());
        check("C1-P14 ID '10001 OR 1=1' is rejected as not a number", notNumber("10001 OR 1=1"));
        check("C1-P15 ID \"10001' --\" is rejected as not a number", notNumber("10001' --"));

        // E. Database integrity
        check("C1-P16 no plaintext password left (every row is a $2a$12$ hash)",
                count("SELECT COUNT(*) FROM credentials WHERE employee_password NOT LIKE '$2a$12$%' OR CHAR_LENGTH(employee_password) <> 60") == 0);
        String after = checksum();
        System.out.println("      credentials checksum before: " + before);
        System.out.println("      credentials checksum after:  " + after);
        check("C1-P17 credentials table unchanged by all the attacks above", before.equals(after));

        System.out.println("Control 1: " + passed + " passed, " + failed + " failed");
        System.exit(failed == 0 ? 0 : 1);
    }

    static boolean notNumber(String id){
        try{
            Integer.parseInt(id); // same conversion as LoginGUI, before any query
            return false;
        }catch(NumberFormatException e){
            return true;
        }
    }

    static int count(String sql) throws SQLException {
        Connection conn = new DatabaseConnection().getDBConnection();
        try(PreparedStatement statement = conn.prepareStatement(sql); ResultSet result = statement.executeQuery()){
            result.next();
            return result.getInt(1);
        }
    }

    static String checksum() throws SQLException {
        Connection conn = new DatabaseConnection().getDBConnection();
        try(Statement statement = conn.createStatement(); ResultSet result = statement.executeQuery("CHECKSUM TABLE credentials")){
            result.next();
            return result.getString(2);
        }
    }

    static void check(String name, boolean ok){
        System.out.println((ok ? "PASS  " : "FAIL  ") + name);
        if(ok) passed++; else failed++;
    }
}
