package payrollsystem;

// Control 1: one set of password rules for every place a password is set
// (forced change at first login, Login.changePassword() and HR adding a credential).
// Keeping the rules in one class means the screens and the backend can never disagree.
final class PasswordPolicy {
    static final int MIN_LENGTH = 8;

    private PasswordPolicy(){
    }

    // Returns an error message, or null when the password is acceptable.
    // employeeID and currentPassword may be null when they do not apply.
    static String check(String newPassword, String employeeID, String currentPassword){
        if(newPassword == null || newPassword.isEmpty()){
            return "Please enter a password.";
        }
        if(newPassword.equals(currentPassword) || newPassword.equals(employeeID)){
            return "New password cannot be the same as your employee ID or your current password.";
        }
        if(newPassword.length() < MIN_LENGTH){
            return "Password must be at least " + MIN_LENGTH + " characters.";
        }
        if(PasswordUtil.isTooLong(newPassword)){ // BCrypt ignores everything after 72 bytes
            return "Password must be at most 72 characters.";
        }
        if(!newPassword.matches(".*[A-Z].*") || !newPassword.matches(".*[a-z].*")
                || !newPassword.matches(".*[0-9].*") || !newPassword.matches(".*[^A-Za-z0-9].*")){
            return "Password must include an uppercase letter, a lowercase letter, a number and a special character.";
        }
        return null;
    }
}
