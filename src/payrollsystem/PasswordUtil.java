package payrollsystem;

import java.nio.charset.StandardCharsets;
import org.mindrot.jbcrypt.BCrypt;

final class PasswordUtil {
    static final int WORK_FACTOR = 12;
    static final int MAX_PASSWORD_BYTES = 72; // BCrypt ignores everything after 72 bytes

    private PasswordUtil(){
    }

    static boolean isTooLong(String plainPassword){
        return plainPassword != null && plainPassword.getBytes(StandardCharsets.UTF_8).length > MAX_PASSWORD_BYTES;
    }

    static String hash(String plainPassword){
        if(isTooLong(plainPassword)){
            throw new IllegalArgumentException("Password is longer than " + MAX_PASSWORD_BYTES + " bytes");
        }
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(WORK_FACTOR));
    }

    static boolean verify(String plainPassword, String storedHash){
        if(plainPassword == null || isTooLong(plainPassword) || !isHash(storedHash)){
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