/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.sql.*;
import java.time.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;


public class Supervisor extends Employee{
    private final String employeeID;
  
    public Supervisor(String employeeID){
        this.employeeID = employeeID;
        super();  
    }
    
   //Method for setting a query of retrieving all employee request
   public ArrayList<ArrayList<String>> employeeRequest(String selectedItem){
       AccessControl.require(Action.VIEW_TEAM_REQUESTS); // Control 4
       ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sqlForLeave = "SELECT e.employee_id, CONCAT(e.first_name, ' ', e.last_name) AS full_name, ll.date_filed, " +
                                "lt.leave_type, ll.leave_from, ll.leave_to, ll.number_of_days, ll.reason, rs.status " +
                                "FROM employees e " +
                                "JOIN leave_ledger ll ON e.employee_id = ll.employee_id " +
                                "JOIN leave_type lt ON ll.leave_type_id = lt.leave_type_id " +
                                "JOIN request_status rs ON ll.request_status_id = rs.request_status_id " +
                                "WHERE rs.status = ? AND e.immediate_supervisor = ? ORDER BY employee_id";
            
            String sqlForOvertime = "SELECT e.employee_id, CONCAT(e.first_name, ' ', e.last_name) AS full_name, eo.date_filed, " +
                                    "'Overtime' AS overtime, eo.overtime_from, eo.overtime_to, eo.number_of_days, eo.reason, rs.status " +
                                    "FROM employees e " +
                                    "JOIN overtime_requests eo ON e.employee_id = eo.employee_id " +
                                    "JOIN request_status rs ON eo.request_status_id = rs.request_status_id " +
                                    "WHERE rs.status = ? AND e.immediate_supervisor = ? ORDER BY employee_id";

             String combinedSql = "SELECT e.employee_id, CONCAT(e.first_name, ' ', e.last_name) AS full_name, ll.date_filed, lt.leave_type AS request_type, " +
                                    "ll.leave_from AS from_time, ll.leave_to AS to_time, ll.number_of_days, ll.reason, rs.status " +
                                    "FROM employees e " +
                                    "JOIN leave_ledger ll ON e.employee_id = ll.employee_id " +
                                    "JOIN leave_type lt ON ll.leave_type_id = lt.leave_type_id " +
                                    "JOIN request_status rs ON ll.request_status_id = rs.request_status_id " +
                                    "WHERE rs.status = ? AND e.immediate_supervisor = ? " +
                                    "UNION ALL " +
                                    "SELECT e.employee_id, CONCAT(e.first_name, ' ', e.last_name) AS full_name, eo.date_filed, 'Overtime' AS request_type, " +
                                    "eo.overtime_from AS from_time, eo.overtime_to AS to_time, eo.number_of_days, eo.reason, rs.status " +
                                    "FROM employees e " +
                                    "JOIN overtime_requests eo ON e.employee_id = eo.employee_id " +
                                    "JOIN request_status rs ON eo.request_status_id = rs.request_status_id " +
                                    "WHERE rs.status = ? AND e.immediate_supervisor = ? ORDER BY employee_id";
             
            switch (selectedItem){
                case "Leave Request":
                    PreparedStatement leaveStatement = conn.prepareStatement(sqlForLeave);
                    leaveStatement.setString(1, "Pending");
                    leaveStatement.setInt(2, Integer.parseInt(this.employeeID));
                    data = accountDetails.retrivedDetails(leaveStatement);
                    break;
                case "Overtime Request":
                    PreparedStatement overtimeStatement = conn.prepareStatement(sqlForOvertime);
                    overtimeStatement.setString(1, "Pending");
                    overtimeStatement.setInt(2, Integer.parseInt(this.employeeID));
                    data = accountDetails.retrivedDetails(overtimeStatement);
                    break;
                default :
                    PreparedStatement combineStatement = conn.prepareStatement(combinedSql);
                    combineStatement.setString(1, "Pending");
                    combineStatement.setInt(2, Integer.parseInt(this.employeeID));
                    combineStatement.setString(3, "Pending");
                    combineStatement.setInt(4, Integer.parseInt(this.employeeID));
                    data = accountDetails.retrivedDetails(combineStatement);
                    break;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to Retrieve Employee Request!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message 
        }
        return data;        //returns an arraylist from specified queries of possible employee requests
   }  
    
    //Method to set query for retrieving of complete employee name
    public ArrayList<ArrayList<String>> employeeNames(){  
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sql = "SELECT CONCAT(last_name, ', ',first_name) AS full_name FROM employees WHERE immediate_supervisor = ? ORDER BY full_name";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(this.employeeID));
            data = accountDetails.retrivedDetails(statement);
            return data;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to Retrieve Employee Names!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message 
        }
        return data;    //returns all employee full names as an arraylist
    }
       
    //Method to set query for retrieving of all employee DTR
    public ArrayList<ArrayList<String>> getDataForDTRTable(String employeeName){
        AccessControl.require(Action.VIEW_EMPLOYEE_DTR); // Control 4
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sql = "SELECT e.employee_id, CONCAT(e.last_name, ' ', e.first_name) AS full_name, " +
                    "ar.attendance_date, ar.login, ar.logout, rs.status " +
                    "FROM attendance_records ar " +
                    "JOIN employees e ON ar.employee_id = e.employee_id " +
                    "JOIN request_status rs ON ar.request_status_id = rs.request_status_id " +
                    "WHERE e.immediate_supervisor = ? AND CONCAT(e.last_name, ', ', e.first_name) = ? AND rs.status = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(this.employeeID));
            statement.setString(2, employeeName);
            statement.setString(3, "Pending");
            data = accountDetails.retrivedDetails(statement);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to Retrieve DTR!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message 
        }
        return data;        //returns all dtr data from specified employee where status = pending
    }
    
    //Method to set query for updating of employee request to approved
    public void approvedEmployeeRequest(ArrayList<String> rowData){
        AccessControl.require(Action.APPROVE_REQUEST); // Control 4
        if(rowData.get(3).equals("Overtime")){
            try {
                String sql = "UPDATE overtime_requests orq JOIN request_status rs ON rs.status = ? "
                        + "SET orq.request_status_id = rs.request_status_id WHERE orq.employee_id = ? "
                        + "AND orq.overtime_from = ? AND orq.overtime_to = ? ";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, "Approved");
                statement.setInt(2, Integer.parseInt(rowData.get(0)));
                statement.setDate(3, java.sql.Date.valueOf(rowData.get(4)));
                statement.setDate(4, java.sql.Date.valueOf(rowData.get(5)));
                int update = statement.executeUpdate();
                if(update > 0){
                     JOptionPane.showMessageDialog(null, "Successfuly Approved Overtime Request!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                accountDetails.closeDBRequest(statement);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error to Retrieve Approved Employee Request!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message 
            }
            
        }else{
            try {
                String updateBalanceSql = "UPDATE leave_balances lb JOIN leave_type lt ON lb.leave_type_id = lt.leave_type_id "
                                           + "SET lb.balance = lb.balance - ? WHERE lb.employee_id = ? AND lt.leave_type = ? AND lb.balance >= ?";

                String updateStatusSql = "UPDATE leave_ledger lr JOIN request_status rs ON rs.status = ? JOIN leave_type lt ON lr.leave_type_id = lt.leave_type_id " +
                                        "SET lr.request_status_id = rs.request_status_id WHERE lr.employee_id = ? AND lt.leave_type = ? AND lr.leave_from = ? " +
                                        "AND lr.leave_to = ? AND lr.request_status_id != rs.request_status_id";

                PreparedStatement balanceStmt = conn.prepareStatement(updateBalanceSql);
                balanceStmt.setDouble(1, Double.parseDouble(rowData.get(6)));
                balanceStmt.setInt(2, Integer.parseInt(rowData.get(0)));
                balanceStmt.setString(3, rowData.get(3));
                balanceStmt.setDouble(4, Double.parseDouble(rowData.get(6)));

                 int rowsAffected = balanceStmt.executeUpdate();
                 if (rowsAffected > 0) {
                        PreparedStatement statusStmt = conn.prepareStatement(updateStatusSql);
                        statusStmt.setString(1, "Approved");
                        statusStmt.setInt(2, Integer.parseInt(rowData.get(0)));
                        statusStmt.setString(3, rowData.get(3));
                        statusStmt.setDate(4, java.sql.Date.valueOf(rowData.get(4)));
                        statusStmt.setDate(5, java.sql.Date.valueOf(rowData.get(5)));

                        statusStmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Successfuly Approved Leave Request!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        accountDetails.closeDBRequest(statusStmt);
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient leave balance!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                 accountDetails.closeDBRequest(balanceStmt);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error to Retrieve Approved Employee Request!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message 
            }
        }
     }
     
    //Method to set query for updating specified employee request status to 'disapproved'
    public void disapprovedEmployeeRequest(ArrayList<String> rowData){
        AccessControl.require(Action.DISAPPROVE_REQUEST); // Control 4
          String sql;
        try {
            
            if(rowData.get(3).equals("Overtime")){
                sql = "UPDATE overtime_requests eo JOIN request_status rs ON rs.status = ? " +
                        "SET eo.request_status_id = rs.request_status_id WHERE eo.employee_id = ? "+
                        "AND eo.overtime_from = ? AND eo.overtime_to = ? AND eo.request_status_id != rs.request_status_id";
            }else{
               
                sql = "UPDATE leave_ledger ll JOIN request_status rs ON rs.status = ? " +
                        "SET ll.request_status_id = rs.request_status_id WHERE ll.employee_id = ? "+
                        "AND ll.leave_from = ? AND ll.leave_to = ? AND ll.request_status_id != rs.request_status_id";
            }
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "Disapproved");
            statement.setInt(2, Integer.parseInt(rowData.get(0)));
            statement.setDate(3, java.sql.Date.valueOf(rowData.get(4)));
            statement.setDate(4, java.sql.Date.valueOf(rowData.get(5)));
            int update = statement.executeUpdate();
            if(update > 0){
                JOptionPane.showMessageDialog(null, "Successfuly Disapproved Request!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            accountDetails.closeDBRequest(statement);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to Retrieve Disapproved Employee Request!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message 
        }
      }
      
    //Method to set query for forwarding DTR
    public void forwardDTR(ArrayList<ArrayList <String>> rowData){
        AccessControl.require(Action.FORWARD_DTR); // Control 4
        int update = 0;
        try {
            String sql = "UPDATE attendance_records ar JOIN request_status rs ON rs.status = ? SET ar.request_status_id = rs.request_status_id " +
                    "WHERE ar.request_status_id != rs.request_status_id AND ar.attendance_date = ? AND ar.employee_id = ?";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            for(int i=0; i<rowData.size(); i++){
                statement.setString(1, "Approved");
                statement.setDate(2, java.sql.Date.valueOf(rowData.get(i).get(2)));
                statement.setInt(3, Integer.parseInt(rowData.get(i).get(0)));
                update = statement.executeUpdate();
            }
            if(update>0){
                JOptionPane.showMessageDialog(null, "Successfuly Forwarded DTR to Payroll Section!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            accountDetails.closeDBRequest(statement);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to Forward DTR!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message 
        }
    }
      
   public void setSelectedName(String selectedName){
       
   }

}
