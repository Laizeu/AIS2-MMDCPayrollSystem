/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.sql.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.time.*;
import java.util.*;
import java.util.Date;
import javax.swing.JOptionPane;

public class Employee extends AccountDetails {
    AccountDetails accountDetails = new AccountDetails();                       //Calling the class AccountDetails
    private int employeeID;                                                     //Creating a variable for employee id
    protected int indexAttendance;
    private int numberOfDaysLeave, daysWorked, overtimeDays = 0;
    private String employee_id, firstName, lastName, birthday, phoneNumber, street, barangay, city, province, zipcode, sssNumber, philHealthNumber, tinNumber, 
            pagibigNumber, status, position, supervisor;
    private double basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, semiBasicSalary, hourlyRate;
  
    java.sql.Connection conn = dbConnection.getDBConnection();                  //Request Database Connection
    
    Employee(){
        
    }
    
    public Employee(String employeeID){
        this.employeeID = Integer.parseInt(employeeID);
        super();
    }
    
    //Method to get the date now
    java.sql.Date getDateNow(){
        Date date = new Date();
        java.sql.Date dateNow = new java.sql.Date(date.getTime());
        return dateNow;
    }
    
    //Method to get the time now with the format of "00:00:00"
    Time getTime(){
        Timestamp time = new Timestamp(System.currentTimeMillis());             //Get current time with seconds = 0, milliseconds = 0
        LocalTime localTime = time.toLocalDateTime().toLocalTime().withSecond(0).withNano(0);
        Time timeNow = Time.valueOf(localTime);                                 //Convert to java.sql.Time 
        return timeNow;                                                         //Return the current time now
    }
    
    //Method that set query to get the personal details
    public void viewPersonalDetails(){ 
        AccessControl.requireSelf(this.employeeID); // Control 4: own records only
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sql = "SELECT e.employee_id, e.first_name, e.last_name, e.birthdate, e.phone_number,ad.street, ad.barangay, ad.city, ad.province, "
                    + "ad.zipcode,sal.basic_salary, sal.rice_subsidy, sal.phone_allowance, sal.clothing_allowance,id.philhealth_number, id.sss_number, "
                    + "id.tin_number, id.pagibig_number, p.position_name, s.status_name, (SELECT CONCAT(es.last_name, ', ', es.first_name) "
                    + "FROM employees es WHERE es.employee_id = e.immediate_supervisor) AS supervisor_name "
                    + "FROM employees e JOIN employee_address ad "
                    + "ON e.employee_address_id = ad.employee_address_id JOIN compensation_details sal ON e.employee_id = sal.employee_id "
                    + "JOIN government_ids id ON e.employee_id = id.employee_id JOIN positions p ON e.position_id = p.position_id "
                    + "JOIN employee_statuses s ON e.status_id = s.status_id WHERE e.employee_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID);                               //Set employee id for retrieving data from database
            data = accountDetails.retrivedDetails(statement);                   //To call the method for retrieving all personal details
            this.employee_id = data.get(0).get(0);                              //Set employee ID
            this.firstName = data.get(0).get(1);                                //Set the first name
            this.lastName = data.get(0).get(2);                                 //Set the last name
            this.birthday = data.get(0).get(3);                                 //Set the birthday
            this.phoneNumber = data.get(0).get(4);                              //Set the phone number
            this.street = data.get(0).get(5);                                   //Set the stree name
            this.barangay = data.get(0).get(6);                                 //Set the barangay name
            this.city = data.get(0).get(7);                                     //Set the city name
            this.province = data.get(0).get(8);                                 //Set the province name
            this.zipcode = data.get(0).get(9);                                  //Set the zipcode
            this.basicSalary = Double.parseDouble(data.get(0).get(10));         //Set basic salary
            this.semiBasicSalary = this.basicSalary / 2;                        //Set semi basic salaryy
            this.hourlyRate = Math.round(((this.semiBasicSalary / 21.0) / 8.0) * 100.0) / 100.0;    //Set hourly rate
            this.riceSubsidy = Double.parseDouble(data.get(0).get(11));         //Set rice subsidy allowance
            this.phoneAllowance = Double.parseDouble(data.get(0).get(12));      //Set phone allowance
            this.clothingAllowance = Double.parseDouble(data.get(0).get(13));   //Set clothing allowance
            this.philHealthNumber = data.get(0).get(14);                        //Set philhealth ID No.
            this.sssNumber = data.get(0).get(15);                               //Set sss ID No.
            this.tinNumber = data.get(0).get(16);                               //Set TIN ID No.
            this.pagibigNumber = data.get(0).get(17);                           //Set Pagibig ID No.
            this.position = data.get(0).get(18);                                //Set position
            this.status = data.get(0).get(19);                                  //Set employee status
            this.supervisor = data.get(0).get(20);                              //Set employee supervisor
            accountDetails.closeDBRequest(statement);                           //Close the Database Request
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to Retrieved Employee Information!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message
        }
    }
    
    //Method that set query to get all employee request
    public ArrayList<ArrayList<String>> getDataAllRequests(){ 
        AccessControl.requireSelf(this.employeeID); // Control 4: own records only
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sql = "SELECT o.date_filed, 'Overtime' AS request_type, " +
                    "o.overtime_from AS leave_from, o.overtime_to AS leave_to, " +
                    "o.number_of_days, o.reason, r.status " +
                    "FROM overtime_requests o " +
                    "JOIN request_status r ON o.request_status_id = r.request_status_id " +
                    "WHERE o.employee_id = ? " +
                    "UNION ALL " +
                    "SELECT l.date_filed, t.leave_type AS request_type, " +
                    "l.leave_from, l.leave_to, l.number_of_days, l.reason, s.status " +
                    "FROM leave_ledger l " +
                    "JOIN leave_type t ON l.leave_type_id = t.leave_type_id " +
                    "JOIN request_status s ON l.request_status_id = s.request_status_id " +
                    "WHERE l.employee_id = ? AND status = ? ORDER BY date_filed ASC";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID);
            statement.setInt(2, this.employeeID);
            statement.setString(3, "Pending");
            data = accountDetails.retrivedDetails(statement);  
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to Retrieved All Employee Request!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message
        }
           return data;   //returns all overtime requests as an arraylist
    }
    
    //Method that set query to get DTR
    public ArrayList<ArrayList<String>> getDTR(Date dateFrom, Date dateTo){ //return all dtr of specified employee as an arraylist
        AccessControl.requireSelf(this.employeeID); // Control 4: own records only
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sql =  "SELECT ar.attendance_date, ar.login, ar.logout, rs.status AS request_status " +
                    "FROM attendance_records ar " +
                    "JOIN request_status rs ON ar.request_status_id = rs.request_status_id " +
                    "WHERE ar.employee_id = ? AND ar.attendance_date BETWEEN ? AND ?" +
                    "ORDER BY ar.attendance_date ASC";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID);
            statement.setDate(2, new java.sql.Date(dateFrom.getTime()));
            statement.setDate(3, new java.sql.Date(dateTo.getTime()));
            data = accountDetails.retrivedDetails(statement); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to Retrieved DTR!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message
        }
        return data;    //return DTR
    }
    
    //Method that set query to view personal ledger
    public ArrayList<ArrayList<String>> viewPersonalLeaveLedger() { 
        AccessControl.requireSelf(this.employeeID); // Control 4: own records only
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sql = "SELECT l.date_filed, t.leave_type, l.leave_from, l.leave_to, " +
                    "l.number_of_days, l.reason, s.status " +
                    "FROM leave_ledger l " +
                    "JOIN leave_type t ON t.leave_type_id = l.leave_type_id " +
                    "JOIN request_status s ON s.request_status_id = l.request_status_id " +
                    "WHERE l.employee_id = ? AND s.request_status_id IN (2, 3)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID);
            data = accountDetails.retrivedDetails(statement);
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error to Retrieved Personal Leave Ledger!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message
        }
        return data;    //returns leave ledgers of specified employee as an arraylist
    }
    
    //Method for filing overtime and insert new overtime request to overtime_requests table
    public Boolean fileOvertimeRequest(Date overtime_from, Date overtime_to, int number_of_days, String reason){
        AccessControl.requireSelf(this.employeeID); // Control 4: own records only
        try {
            String sql =  "INSERT INTO overtime_requests (" +
                    "employee_id, date_filed, overtime_from, overtime_to, " +
                    "number_of_days, reason, request_status_id" +
                    ") VALUES (?, ?, ?, ?, ?, ?, " +
                    "(SELECT request_status_id FROM request_status WHERE status = 'Pending' LIMIT 1))";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID);
            statement.setDate(2, getDateNow());
            statement.setDate(3, new java.sql.Date(overtime_from.getTime()));
            statement.setDate(4, new java.sql.Date(overtime_to.getTime()));
            statement.setInt(5, number_of_days);
            statement.setString(6, reason);
            if(accountDetails.addDetailsToDatabase(statement)){
                JOptionPane.showMessageDialog(null, "Successfully File Overtime!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Request Failed!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;   
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to Retrieved Overtime Request!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message

        }
        return false;
    }
    
    //Method for filing a request
    public Boolean fileLeaveRequest(Date leaveFrom, Date leaveTo, String leaveType, int numDays, String reason){ // insert new leave request to leave_ledger table; returns boolean
        AccessControl.requireSelf(this.employeeID); // Control 4: own records only
        try {
            String sql = "INSERT INTO payroll_system_db.leave_ledger " +
                    "(employee_id, date_filed, leave_type_id, leave_from, leave_to, number_of_days, reason, request_status_id) " +
                    "VALUES(?,?,(SELECT leave_type_id FROM leave_type WHERE leave_type = ? ),?,?,?,?," +
                    "(SELECT request_status_id FROM request_status WHERE status = 'Pending' LIMIT 1))";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID); //employee_id
            statement.setDate(2, getDateNow()); //date_filed
            statement.setString(3, leaveType); //leave type
            statement.setDate(4, new java.sql.Date(leaveFrom.getTime())); //leave_from
            statement.setDate(5, new java.sql.Date(leaveTo.getTime())); //leave_end
            statement.setInt(6, numDays); //number_of_days
            statement.setString(7, reason); //reason
            if(accountDetails.addDetailsToDatabase(statement)){
                JOptionPane.showMessageDialog(null, "Successfuly File A Leave Request!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Request Failed!", "Error", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to Retrieved Employee Leave Request!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message
        }
        return false;
    }
    
    //Method for Timein button
    public void userLogin(){ // inserts new attendance record into attendance_records table on login; returns boolean
        AccessControl.requireSelf(this.employeeID); // Control 4: own records only
        try {
            String sql = "INSERT INTO attendance_records (employee_id, attendance_date, login, request_status_id) " +
                    "SELECT ?, ?, ?, (SELECT request_status_id FROM request_status WHERE status = 'Pending' LIMIT 1) FROM DUAL " +
                    "WHERE NOT EXISTS (SELECT 1 FROM attendance_records WHERE employee_id = ? AND attendance_date = ?)";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID); // employee_id to insert
            statement.setDate(2, getDateNow()); // attendance_date to insert
            statement.setTime(3, getTime()); // login time
            
            statement.setInt(4, this.employeeID); // employee_id for existence check
            statement.setDate(5, getDateNow()); // attendance_date for existence check
            if(accountDetails.addDetailsToDatabase(statement)){
                JOptionPane.showMessageDialog(null, "Time in : "+getTime(), "Success", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Time in Failed! You already made your time-in.", "Error", JOptionPane.ERROR_MESSAGE);   
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Employee Time-in!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message
        }
    }
    
    //Method for Time-out button
    public void userLogout(){ //insert attendance record into attendance_records table with logout data; returns boolean
        AccessControl.requireSelf(this.employeeID); // Control 4: own records only
        try {
            String sql = "INSERT INTO attendance_records (employee_id, attendance_date, logout, request_status_id) " +
                    "VALUES (?, ?, ?, (SELECT request_status_id FROM request_status WHERE status = 'Pending' LIMIT 1)) " +
                    "ON DUPLICATE KEY UPDATE logout = VALUES(logout)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID); // employee_id
            statement.setDate(2, getDateNow()); // attendance_date
            statement.setTime(3, getTime()); // logout
            if(accountDetails.addDetailsToDatabase(statement)){
                JOptionPane.showMessageDialog(null, "Time out : "+getTime(), "Success", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Time out Failed!", "Error", JOptionPane.ERROR_MESSAGE);  
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Employee Time-out!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message
        }
    }
    
    //Method for queries leave balance information from database and assigns values to accountdetails instance
    public void leaveBalancesInformation(){ 
        AccessControl.requireSelf(this.employeeID); // Control 4: own records only
        try {
            String sql = "SELECT balance FROM leave_balances WHERE employee_id = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID);
            accountDetails.getLeaveBalance(statement);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to Retrieved Leave Balances!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message
        }
     }
     
    //Method that will count number of days applied each employee request
    public boolean countNumberOfDays(Date dateFrom, Date dateTo){ // New method to count the days for leave
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.setTime(dateFrom);
        endDate.setTime(dateTo);
        while(!startDate.after(endDate)){
            if (startDate.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                this.numberOfDaysLeave++; //To count the days of leave
            }
            // Move to the next day
            startDate.add(Calendar.DATE, 1);
        }
        if(getNumberOfDaysLeave() == 0){
            JOptionPane.showMessageDialog(null, "Invalid date applied!");
            return false;
        }
        return true;
    }
    
    //Method that retrieved days of work
    public int getDaysWorked(){ 
        AccessControl.requireSelf(this.employeeID); // Control 4: own records only
        try{
            String query = "SELECT * FROM payroll_system_db.attendance_records WHERE employee_id = ?;";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, this.employeeID);
            daysWorked = accountDetails.retrivedDetails(statement).size();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error to Retrieved Days Worked!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message
        }
        return daysWorked;      //returns the number of days worked by a specified employee
    }
    
    //Method to get Overtime details
    public int getOvertime(){ 
        AccessControl.requireSelf(this.employeeID); // Control 4: own records only
        try{
            String query = "SELECT * FROM payroll_system_db.overtime_requests WHERE employee_id = ? AND request_status_id = 2;";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, this.employeeID);
            overtimeDays = accountDetails.retrivedDetails(statement).size();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error to Retrieved Overtime!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message
        }
        return overtimeDays;    //returns number of approved overtime days
    }
    
    //Method for queries specified payslip pdf from database and saves to ./DownloadFiles
    public boolean downloadPayslip(Date date_from, Date date_to) { 
        AccessControl.requireSelf(this.employeeID); // Control 4: own records only
        boolean isSuccess = false;
        if (date_from == null || date_to == null) {
            JOptionPane.showMessageDialog(null, "Error: date_from or date_to is null.", "Error", JOptionPane.ERROR_MESSAGE);
            return isSuccess;
        }
        try{
            String sql = "SELECT payslip_file FROM payslip p " +
                    "JOIN payroll_period per ON p.period_id = per.period_id " +
                    "WHERE employee_id = ? AND period_from = ? AND period_to = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID);
            statement.setDate(2, new java.sql.Date(date_from.getTime()));
            statement.setDate(3, new java.sql.Date(date_to.getTime()));
            ResultSet result = statement.executeQuery();
            try{
                boolean fileFound = false;
                while (result.next()) {
                    Blob blob = result.getBlob("payslip_file");
                if (blob != null) {
                    InputStream inputStream = blob.getBinaryStream();
                    String folderPath = "DownloadFiles";
                    Files.createDirectories(Paths.get(folderPath)); // Create the folder if it doesn't exist

                    String filename = folderPath + "/" + this.employeeID + "_payslip.pdf";

                    try {
                        Files.copy(inputStream, Paths.get(filename), StandardCopyOption.REPLACE_EXISTING);
                        JOptionPane.showMessageDialog(null, "Payslip downloaded: " + filename, "Success", JOptionPane.INFORMATION_MESSAGE);
                        isSuccess = true;
                        fileFound = true;
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error to Download Payslip!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message
                }
            }
            }
                if (!fileFound) {
                    JOptionPane.showMessageDialog(null, "No payslip record found for the given period.", "Error", JOptionPane.ERROR_MESSAGE);
                    return isSuccess;
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error to Download Payslip!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message 
            }
            accountDetails.closeDBRequest(result, statement); //To close request
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error to Download Payslip!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message 
        }
        return isSuccess; 
    }
    
    int getNumberOfDaysLeave(){
        return numberOfDaysLeave;
    }

    void setNumberOfDaysLeave(){
        this.numberOfDaysLeave = 0;
    }
    
    //To getters and setters for viewing of persnal details
    public String getEmployee_id() {
        return this.employee_id;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getStreet() {
        return street;
    }
    public String getBarangay() {
        return barangay;
    }
    public String getCity() {
        return city;
    }
    public String getProvince() {
        return province;
    }
    public String getZipCode() {
        return zipcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSssNumber() {
        return sssNumber;
    }

    public String getPhilHealthNumber() {
        return philHealthNumber;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public String getPagibigNumber() {
        return pagibigNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getPosition() {
        return position;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getRiceSubsidy() {
        return riceSubsidy;
    }

    public double getPhoneAllowance() {
        return phoneAllowance;
    }

    public double getClothingAllowance() {
        return clothingAllowance;
    }

    public double getSemiBasicSalary() {
        return semiBasicSalary;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public String getBirthday() {
        return birthday;
    }
    String getEmployeeCompleteName(){
        return getLastName()+", "+getFirstName();
    }
}