package payrollsystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumSet;

// Control 4 assurance tests: calls the real backend methods directly (a bypass that skips the role screens).
// Allowed cases only call read-only methods, so the database is never changed.
public class RbacCheck {
    static int passed = 0, failed = 0;

    interface Call {
        void run();
    }

    public static void main(String[] args) throws Exception {
        String dbBefore = databaseChecksum();
        long logBefore = countLogLines();

        // 1. Permission matrix matches the design
        expectMatrix(1, Role.EMPLOYEE, EnumSet.noneOf(Action.class));
        expectMatrix(2, Role.HUMAN_RESOURCE, EnumSet.of(Action.VIEW_EMPLOYEE_RECORDS, Action.ADD_EMPLOYEE, Action.UPDATE_EMPLOYEE,
                Action.VIEW_CREDENTIALS, Action.ADD_CREDENTIALS, Action.VIEW_PAYROLL));
        expectMatrix(3, Role.SUPERVISOR, EnumSet.of(Action.VIEW_TEAM_REQUESTS, Action.APPROVE_REQUEST, Action.DISAPPROVE_REQUEST,
                Action.FORWARD_DTR, Action.VIEW_EMPLOYEE_DTR));
        expectMatrix(4, Role.PAYROLL_STAFF, EnumSet.of(Action.VIEW_EMPLOYEE_DTR, Action.VIEW_PAYROLL, Action.GENERATE_PAYSLIP));
        check("C4-T5 unknown role \"Admin\" gets no role (denied)", Role.fromDb("Admin") == null);

        // 2. Invalid cases: bypass attempts must be denied before touching the database
        ArrayList<String> fakeCredential = new ArrayList<>(Arrays.asList("10003", "hacked123", "Human Resource"));
        expectDenied("C4-T6 Employee adds an HR credential", "10003", Role.EMPLOYEE, () -> new HumanResource("10003").addNewCredentials(fakeCredential));
        expectDenied("C4-T7 Employee approves a request", "10003", Role.EMPLOYEE, () -> new Supervisor("10003").approvedEmployeeRequest(new ArrayList<>()));
        expectDenied("C4-T8 Employee generates a payslip", "10003", Role.EMPLOYEE, () -> new PdfGenerator().generatePayslipPDF("10003", new Date(), new Date()));
        expectDenied("C4-T9 Human Resource forwards DTR", "10010", Role.HUMAN_RESOURCE, () -> new Supervisor("10010").forwardDTR(new ArrayList<>()));
        expectDenied("C4-T10 Payroll Staff views all credentials", "10002", Role.PAYROLL_STAFF, () -> new HumanResource("10002").retrievedAllCredentials());
        expectDenied("C4-T11 Supervisor adds an employee", "10001", Role.SUPERVISOR, () -> new HumanResource("10001").addEmployeeDetails(new ArrayList<>()));
        expectDenied("C4-T12 Supervisor generates a payslip", "10001", Role.SUPERVISOR, () -> new PdfGenerator().generatePayslipPDF("10001", new Date(), new Date()));
        expectDenied("C4-T13 No login views employee records", null, null, () -> new HumanResource("0").displayAllDetails());

        // 3. Valid cases: each role can still use its own read-only functions
        expectAllowed("C4-T14 Human Resource views employee records", "10010", Role.HUMAN_RESOURCE, () -> new HumanResource("10010").displayAllDetails());
        expectAllowed("C4-T15 Human Resource views credentials", "10010", Role.HUMAN_RESOURCE, () -> new HumanResource("10010").retrievedAllCredentials());
        expectAllowed("C4-T16 Supervisor views leave requests", "10001", Role.SUPERVISOR, () -> new Supervisor("10001").employeeRequest("Leave Request"));
        expectAllowed("C4-T17 Payroll Staff views payroll", "10002", Role.PAYROLL_STAFF, () -> new PayrollStaff("10002").getEmployeeWithAttendance(new Date(0), new Date()));

        // 4. Evidence
        check("C4-T18 database unchanged during the tests", dbBefore.equals(databaseChecksum()));
        long newLines = countLogLines() - logBefore;
        check("C4-T19 access_denied.log got one line per denial (8 expected, got " + newLines + ")", newLines == 8);

        SessionContext.end();
        System.out.println("Control 4: " + passed + " passed, " + failed + " failed");
        System.exit(failed == 0 ? 0 : 1);
    }

    static void expectMatrix(int number, Role role, EnumSet<Action> allowed){
        boolean ok = true;
        for(Action action : Action.values()){
            if(AccessControl.isAllowed(role, action) != allowed.contains(action)){
                ok = false;
                System.out.println("  mismatch: " + role + " " + action);
            }
        }
        check("C4-T" + number + " " + role.getDbValue() + " allowed exactly " + allowed, ok);
    }

    static void expectDenied(String name, String id, Role role, Call call){
        SessionContext.start(id, role);
        try{
            call.run();
            check(name + " -> should be DENIED but was allowed", false);
        }catch(SecurityException e){
            check(name + " -> DENIED", true);
        }
    }

    static void expectAllowed(String name, String id, Role role, Call call){
        SessionContext.start(id, role);
        try{
            call.run();
            check(name + " -> ALLOWED", true);
        }catch(SecurityException e){
            check(name + " -> should be ALLOWED but was denied", false);
        }
    }

    static String databaseChecksum() throws SQLException {
        Connection conn = new DatabaseConnection().getDBConnection();
        StringBuilder all = new StringBuilder();
        try(Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("CHECKSUM TABLE credentials, employees, leave_ledger, attendance_records, payslip")){
            while(result.next()){
                all.append(result.getString(1)).append('=').append(result.getString(2)).append(';');
            }
        }
        return all.toString();
    }

    static long countLogLines() throws IOException {
        Path log = Paths.get(AccessControl.DENIED_LOG);
        return Files.exists(log) ? Files.readAllLines(log).size() : 0;
    }

    static void check(String name, boolean ok){
        System.out.println((ok ? "PASS  " : "FAIL  ") + name);
        if(ok) passed++; else failed++;
    }
}