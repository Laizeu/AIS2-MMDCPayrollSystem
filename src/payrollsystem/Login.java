/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends Credentials {
    private final int employeeID;
    private final String password;
    
    AccountDetails accountDetails = new AccountDetails();
    
    DatabaseConnection connection = new DatabaseConnection();
    Connection conn = connection.getDBConnection();
    
    
    public Login(int id, String password){
        this.employeeID = id;
        this.password = password;
    }
    
    @Override
    public ArrayList<ArrayList<String>> checkCredentials() { // Control 1: fetch the hash by ID, then verify with BCrypt
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sql = "SELECT e.employee_id, CONCAT(e.last_name, ', ', e.first_name) AS full_name, c.role AS role, c.employee_password " +
                    "FROM employees e " +
                    "JOIN credentials c ON e.employee_id = c.employee_id " +
                    "WHERE c.employee_id = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID);
            for (ArrayList<String> row : accountDetails.retrivedDetails(statement)) {
                String storedHash = row.remove(3); // never pass the hash on to the screens
                if (PasswordUtil.verify(this.password, storedHash)) {
                    data.add(row);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
