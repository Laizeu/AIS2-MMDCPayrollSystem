package payrollsystem;

final class SessionContext {
    private static String userID;
    private static Role role;

    private SessionContext(){
    }

    static void start(String id, Role userRole){
        userID = id;
        role = userRole;
    }

    static void end(){
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