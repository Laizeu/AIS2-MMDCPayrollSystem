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
    // One shared connection for the whole app (stress test 2026-11-06: every object used to open its own
    // connection and none were closed, so about 30 wrong logins used up MySQL's 151 connections and
    // locked everyone out). It is opened on first use and reopened if it was lost.
    private static Connection sharedConnection = null;
    
    //Method for Creating Database Connection
    public DatabaseConnection(){ 
        // no connection is opened here any more; see getDBConnection()
    }
    
    //Method that return Database Connection
    public Connection getDBConnection(){ 
        synchronized (DatabaseConnection.class) {
            try {
                if (sharedConnection == null || !sharedConnection.isValid(2)) {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    sharedConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);   //Getting Database Connection
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database Connection Failed!", "Error", JOptionPane.ERROR_MESSAGE);  //Message Dialog for Database Connection Failed
            }
            return sharedConnection;                                                           //returns Database Connection
        }
    }
}
