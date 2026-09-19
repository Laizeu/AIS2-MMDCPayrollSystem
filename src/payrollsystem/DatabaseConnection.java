package payrollsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class DatabaseConnection {
    
    // Database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/payroll_system_db";        //Initializing Database URL
    private static final String DB_USER = "root";                                              //Initializing Database user
    private static final String DB_PASSWORD = "thisisg0spel";                                  //Initializing Database Password
    Connection connection = null;
    
    //Method for Creating Database Connection
    public DatabaseConnection(){ 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);                    //Getting Database Connection
        } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Connection Failed!", "Error", JOptionPane.ERROR_MESSAGE);  //Message Dialog for Database Connection Failed
        }
    }
    
    //Method that return Database Connection
    public Connection getDBConnection(){ 
        return this.connection;                                                                //returns Database Connection
    }
}
