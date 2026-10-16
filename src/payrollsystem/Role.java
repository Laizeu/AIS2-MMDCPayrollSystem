package payrollsystem;

enum Role {
    EMPLOYEE("Employee"),
    HUMAN_RESOURCE("Human Resource"),
    PAYROLL_STAFF("Payroll Staff"),
    SUPERVISOR("Supervisor");

    private final String dbValue;

    Role(String dbValue){
        this.dbValue = dbValue;
    }

    // Unknown role text returns null, which is always denied
    static Role fromDb(String value){
        for(Role role : values()){
            if(role.dbValue.equals(value)){
                return role;
            }
        }
        return null;
    }

    String getDbValue(){
        return dbValue;
    }
}