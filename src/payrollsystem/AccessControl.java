package payrollsystem;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

final class AccessControl {
    static final String DENIED_LOG = "access_denied.log";

    private static final Map<Role, Set<Action>> PERMISSIONS = new EnumMap<>(Role.class);
    static {
        PERMISSIONS.put(Role.EMPLOYEE, EnumSet.noneOf(Action.class));
        PERMISSIONS.put(Role.HUMAN_RESOURCE, EnumSet.of(
                Action.VIEW_EMPLOYEE_RECORDS, Action.ADD_EMPLOYEE, Action.UPDATE_EMPLOYEE,
                Action.VIEW_CREDENTIALS, Action.ADD_CREDENTIALS, Action.VIEW_PAYROLL));
        PERMISSIONS.put(Role.SUPERVISOR, EnumSet.of(
                Action.VIEW_TEAM_REQUESTS, Action.APPROVE_REQUEST, Action.DISAPPROVE_REQUEST,
                Action.FORWARD_DTR, Action.VIEW_EMPLOYEE_DTR));
        PERMISSIONS.put(Role.PAYROLL_STAFF, EnumSet.of(
                Action.VIEW_EMPLOYEE_DTR, Action.VIEW_PAYROLL, Action.GENERATE_PAYSLIP));
    }

    private AccessControl(){
    }

    static boolean isAllowed(Role role, Action action){
        return role != null && PERMISSIONS.getOrDefault(role, EnumSet.noneOf(Action.class)).contains(action);
    }

    // First line of every sensitive method. Deny by default.
    static void require(Action action){
        Role role = SessionContext.getRole();
        if(!isAllowed(role, action)){
            logDenied(SessionContext.getUserID(), role, action);
            throw new SecurityException("Access denied: " + (role == null ? "no session" : role.getDbValue()) + " cannot " + action);
        }
    }

    private static void logDenied(String userID, Role role, Action action){
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        try(PrintWriter writer = new PrintWriter(new FileWriter(DENIED_LOG, true))){
            writer.println(time + " | DENIED | user=" + (userID == null ? "none" : userID)
                    + " | role=" + (role == null ? "none" : role.getDbValue()) + " | action=" + action);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}