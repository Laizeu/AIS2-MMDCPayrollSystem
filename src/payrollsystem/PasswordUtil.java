package payrollsystem;

import org.mindrot.jbcrypt.BCrypt;

final class PasswordUtil {
    static final int WORK_FACTOR = 12;

    private PasswordUtil(){
    }

    static String hash(String plainPassword){
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(WORK_FACTOR));
    }

    static boolean verify(String plainPassword, String storedHash){
        if(plainPassword == null || !isHash(storedHash)){
            return false;
        }
        try{
            return BCrypt.checkpw(plainPassword, storedHash);
        }catch(IllegalArgumentException e){
            return false;
        }
    }

    static boolean isHash(String value){
        return value != null && value.matches("\\$2[aby]?\\$\\d{2}\\$[./A-Za-z0-9]{53}");
    }
}