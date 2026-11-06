package payrollsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// ONE-TIME tool for Control 1, step 2 of docs/database-migrations.md.
// Hashes every plaintext password in credentials with BCrypt (work factor 12) inside ONE transaction:
// either every row is converted or none is. Rows that are already hashes are skipped, so a second
// run changes nothing.
//
// This copy is kept OUTSIDE src/ on purpose so it cannot be run by accident. To use it:
//   1. take the backup (step 0), run V1 and V2;
//   2. copy this file into src/payrollsystem/, right-click -> Run File;
//   3. check the output "Hashed: N, already hashed: M", then DELETE the copy from src/payrollsystem/.
// (Reference copy written for the documentation; the original was deleted after the 2026-10-17 run.)
public class PasswordMigration {
    public static void main(String[] args) throws SQLException {
        Connection conn = new DatabaseConnection().getDBConnection();
        conn.setAutoCommit(false);
        int hashed = 0, skipped = 0;
        try{
            List<int[]> ids = new ArrayList<>();
            List<String> plain = new ArrayList<>();
            try(PreparedStatement read = conn.prepareStatement("SELECT credential_id, employee_password FROM credentials FOR UPDATE");
                ResultSet rows = read.executeQuery()){
                while(rows.next()){
                    String value = rows.getString(2);
                    if(PasswordUtil.isHash(value)){
                        skipped++;
                    }else{
                        ids.add(new int[]{rows.getInt(1)});
                        plain.add(value);
                    }
                }
            }
            try(PreparedStatement write = conn.prepareStatement("UPDATE credentials SET employee_password = ? WHERE credential_id = ?")){
                for(int i = 0; i < ids.size(); i++){
                    write.setString(1, PasswordUtil.hash(plain.get(i)));
                    write.setInt(2, ids.get(i)[0]);
                    write.executeUpdate();
                    hashed++;
                }
            }
            conn.commit();
            System.out.println("Hashed: " + hashed + ", already hashed: " + skipped);
        }catch(SQLException | RuntimeException e){
            conn.rollback(); // nothing is half-converted
            System.out.println("Migration failed, nothing was changed: " + e.getMessage());
            throw e;
        }finally{
            conn.setAutoCommit(true);
        }
    }
}
