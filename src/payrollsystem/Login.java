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
    private String matchedRole;                  // Control 1: role of the credential that matched
    private boolean mustChangePassword = false;  // Control 1: forced password change at first login
    
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
            String sql = "SELECT e.employee_id, CONCAT(e.last_name, ', ', e.first_name) AS full_name, c.role AS role, c.must_change_password, c.employee_password " +
                    "FROM employees e " +
                    "JOIN credentials c ON e.employee_id = c.employee_id " +
                    "WHERE c.employee_id = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID);
            for (ArrayList<String> row : accountDetails.retrivedDetails(statement)) {
                String storedHash = row.remove(4); // never pass the hash on to the screens
                String mustChange = row.remove(3);
                if (PasswordUtil.verify(this.password, storedHash)) {
                    if (data.isEmpty()) {
                        matchedRole = row.get(2);
                        mustChangePassword = "1".equals(mustChange) || "true".equalsIgnoreCase(mustChange);
                    }
                    data.add(row);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public boolean mustChangePassword() {
        return mustChangePassword;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    // Control 1: saves the new password as a BCrypt hash and clears the forced-change flag
    public boolean changePassword(String newPassword) {
        if (matchedRole == null) {
            return false; // only after a successful checkCredentials()
        }
        String sql = "UPDATE credentials SET employee_password = ?, must_change_password = 0 WHERE employee_id = ? AND role = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, PasswordUtil.hash(newPassword));
            statement.setInt(2, this.employeeID);
            statement.setString(3, matchedRole);
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}