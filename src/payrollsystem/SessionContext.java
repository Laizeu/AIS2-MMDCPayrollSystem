package payrollsystem;

final class SessionContext {
    private static String userID;
    private static Role role;

    private SessionContext(){
    }

    static void start(String id, Role userRole){
        userID = id;
        role = userRole;
        SecurityLog.event("SESSION_START", id, "role=" + (userRole == null ? "none" : userRole.getDbValue()));
    }

    static void end(){
        if(userID != null || role != null){
            SecurityLog.event("SESSION_END", userID, "logout or return to login screen");
        }
        userID = null;
        role = null;
    }

    static String getUserID(){
        return userID;
    }

    static Role getRole(){
        return role;
    }
}