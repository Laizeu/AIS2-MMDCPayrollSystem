/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.*;
import java.time.format.DateTimeFormatter;


public class HumanResource extends Employee{
    private String employeeID, selectedName;
    private ArrayList <String> fullName = new ArrayList<>();
    
    public HumanResource(String employeeID){
        super();
        this.employeeID = employeeID;
    }
    
    public ArrayList<ArrayList<String>> displayAllDetails(){ //queries data for a specified employee; returns arraylist
        AccessControl.require(Action.VIEW_EMPLOYEE_RECORDS); // Control 4
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sql = "SELECT e.employee_id, e.last_name, e.first_name, e.birthdate, ad.street, ad.barangay, ad.municipality, ad.city, ad.province, ad.zipcode, \n" +
                        "e.phone_number, id.sss_number, id.philhealth_number, id.tin_number, id.pagibig_number, s.status_name, p.position_name, \n" +
                        "e.immediate_supervisor AS immediate_supervisor,\n" +
                        "sal.basic_salary, sal.rice_subsidy, sal.phone_allowance, sal.clothing_allowance \n" +
                        "FROM employees e JOIN employee_address ad ON e.employee_address_id = ad.employee_address_id \n" +
                        "JOIN compensation_details sal ON e.employee_id = sal.employee_id\n" +
                        "JOIN government_ids id ON e.employee_id = id.employee_id JOIN positions p ON e.position_id = p.position_id\n" +
                        "JOIN employee_statuses s ON e.status_id = s.status_id ORDER BY e.employee_id";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            data = accountDetails.retrivedDetails(statement);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to Display All Details!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message 
        }
        return data;
    }
    
    private static int getIdFromLookup(Connection conn, String query) throws SQLException {
        int lookUpID = 0;
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                lookUpID = rs.getInt(1);
            } else {
                throw new SQLException("Lookup failed: " + query);
            }
            stmt.close(); // to close the statement request
            rs.close(); //to close the resultSet request
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error to Generate Employee ID!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message 
        }
        return lookUpID;
    }
    
    public ArrayList<ArrayList<String>> nextEmployeeID(){ //returns last employee_id + 1; returns arraylist
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sql = "SELECT MAX(employee_id + 1) AS greatest_employee_id FROM employees";
            PreparedStatement statement = conn.prepareStatement(sql);
            data = accountDetails.retrivedDetails(statement);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to Get Last Employee Inserted!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message 
        }
        return data;
    }
    
    public Boolean addEmployeeDetails(ArrayList<String> data){
        AccessControl.require(Action.ADD_EMPLOYEE); // Control 4
        boolean isSuccess = false;
        try {
            // 1. Insert into employee_address
            String insertAddress = "INSERT INTO employee_address(street, barangay, municipality, city, province, zipcode) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement psAddress = conn.prepareStatement(insertAddress, Statement.RETURN_GENERATED_KEYS);
            psAddress.setString(1, data.get(5));
            psAddress.setString(2, data.get(6));
            psAddress.setString(3, data.get(7));
            psAddress.setString(4, data.get(8));
            psAddress.setString(5, data.get(9));
            psAddress.setInt(6, Integer.parseInt(data.get(10)));
            psAddress.executeUpdate();
            ResultSet rsAddress = psAddress.getGeneratedKeys();
                if (rsAddress.next()) {
                    int addressId = rsAddress.getInt(1);

                    // 2. Get status_id and position_id
                    int statusId = getIdFromLookup(conn, "SELECT status_id FROM employee_statuses WHERE status_name = 'Regular'");
                    int positionId = getIdFromLookup(conn, "SELECT position_id FROM positions WHERE position_name = 'Account Manager'");

                    // 3. Insert into employees
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                    LocalDate parsedDate = LocalDate.parse(data.get(3), formatter);
                    String insertEmployee = "INSERT INTO employees(status_id, position_id, immediate_supervisor, employee_address_id, first_name, last_name, birthdate, phone_number) " +
                                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement psEmployee = conn.prepareStatement(insertEmployee, Statement.RETURN_GENERATED_KEYS)) {
                        psEmployee.setInt(1, statusId);
                        psEmployee.setInt(2, positionId);
                        psEmployee.setInt(3, Integer.parseInt(data.get(21))); // Supervisor ID
                        psEmployee.setInt(4, addressId);
                        psEmployee.setString(5, data.get(1));
                        psEmployee.setString(6, data.get(2));
                        psEmployee.setDate(7, java.sql.Date.valueOf(parsedDate));
                        psEmployee.setString(8, data.get(4));
                        psEmployee.executeUpdate();
                        
                        ResultSet rsEmp = psEmployee.getGeneratedKeys();
                         if (rsEmp.next()) {
                            int employeeId = rsEmp.getInt(1);

                            // 4. Insert into compensation_details
                            String insertComp = "INSERT INTO compensation_details(employee_id, basic_salary, rice_subsidy, phone_allowance, clothing_allowance, hourly_rate) " +
                                                "VALUES (?, ?, ?, ?, ?, ?)";
                            try (PreparedStatement psComp = conn.prepareStatement(insertComp)) {
                                psComp.setInt(1, employeeId);
                                psComp.setDouble(2, Double.parseDouble(data.get(10)));
                                psComp.setDouble(3, Double.parseDouble(data.get(11)));
                                psComp.setDouble(4, Double.parseDouble(data.get(12)));
                                psComp.setDouble(5, Double.parseDouble(data.get(13)));
                                psComp.setDouble(6, Double.parseDouble(data.get(10))/2);
                                psComp.executeUpdate();
                                accountDetails.closeDBRequest(psComp);
                            }

                            // 5. Insert into government_ids
                            String insertGov = "INSERT INTO government_ids(employee_id, sss_number, philhealth_number, tin_number, pagibig_number) " +
                                               "VALUES (?, ?, ?, ?, ?)";
                            try (PreparedStatement psGov = conn.prepareStatement(insertGov)) {
                                psGov.setInt(1, employeeId);
                                psGov.setString(2, data.get(15));
                                psGov.setString(3, data.get(16));
                                psGov.setString(4, data.get(17));
                                psGov.setString(5, data.get(18));
                                psGov.executeUpdate();
                                accountDetails.closeDBRequest(psAddress);
                            }
                        }
                        accountDetails.closeDBRequest(rsEmp, psEmployee);   //to close request for adding employee request

                    }
                }
                isSuccess = true;
                JOptionPane.showMessageDialog(null, "Successfuly Added New Employee!", "Success", JOptionPane.INFORMATION_MESSAGE);
                accountDetails.closeDBRequest(rsAddress, psAddress);   //to close request for adding employee request
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to Insert New Employee Details!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message 
        }
        return isSuccess;
    }
    
    public  ArrayList<ArrayList<String>> retrievedEmploymentStatus(String request){ //queries either employee status or position; returns arraylist
            ArrayList<ArrayList<String>> data = new ArrayList<>();
            String sql;
        try {
            if(request.equals("status")){
                sql = "SELECT status_name FROM employee_statuses";
            }else{
                sql = "SELECT position_name FROM positions";
            }
           
            PreparedStatement statement = conn.prepareStatement(sql);
            data = accountDetails.retrivedDetails(statement);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to Retrieved Employee Status!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message 
        }
        return data;
     }
     
    public ArrayList<ArrayList<String>> retrievedAllCredentials(){ //queries all entries from credentials table; returns arraylist
        AccessControl.require(Action.VIEW_CREDENTIALS); // Control 4
        ArrayList<ArrayList<String>> data = new ArrayList<>();     
        try {
            String sql = "SELECT cr.employee_id, concat(e.last_name, ', ',first_name) as full_name, cr.role " +
                         "FROM credentials cr JOIN employees e ON cr.employee_id = e.employee_id order by employee_id";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            data = accountDetails.retrivedDetails(statement);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to Retrieved All Credentials!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message 
        }
        return data;
     }
     
    public Boolean addNewCredentials(ArrayList<String> data){ //inserts new credentials to credentials table; returns boolean
        AccessControl.require(Action.ADD_CREDENTIALS); // Control 4
        ArrayList<ArrayList<String>> credentialData = new ArrayList<>(); //To create new arraylist
        boolean isSuccess = false;
        if(PasswordUtil.isTooLong(data.get(1))){ // Control 1: max password length
            JOptionPane.showMessageDialog(null, "Password must be at most 72 characters.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        try {
            //To check if credentials already exist
            String checkCredentialSQL = "SELECT * FROM credentials WHERE employee_id = ? AND role = ? ";
            PreparedStatement checkStatement = conn.prepareStatement(checkCredentialSQL);
            checkStatement.setInt(1, Integer.parseInt(data.get(0)));
            checkStatement.setString(2, data.get(2));
            credentialData = accountDetails.retrivedDetails(checkStatement);
            
            //To insert new credentials
            if(credentialData.isEmpty()){  //To check if the arraylist has value retrieved from database
                String sql = "INSERT INTO credentials (employee_id, employee_password, role) VALUES (?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, Integer.parseInt(data.get(0)));
                statement.setString(2, PasswordUtil.hash(data.get(1))); // Control 1: store only the hash
                statement.setString(3, data.get(2));
                int update = statement.executeUpdate();
                if(update > 0){
                    isSuccess = true;
                    JOptionPane.showMessageDialog(null, "Successfuly Added New Credentials!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                accountDetails.closeDBRequest(statement);
            }else{
                 JOptionPane.showMessageDialog(null, "Cannot be Add New Credentials to Employee already exist with the same role!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to Add New Credentials!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message 
        }
        return isSuccess;
    }
     
    public boolean validateDateBirthday(Date dateBirthday){ //validation check for birthday input; returns boolean
        boolean isValid = true;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateBirthday);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int days = calendar.get(Calendar.DATE);

        
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();
        int currentDay = currentDate.getDayOfMonth();
        
        int legalAge = 18;
        int yearDifference = currentYear - year;
        int monthDifference = currentMonth - month;
        int daysDifference = currentDay -days;
        
        if(yearDifference >= legalAge){   // if  5 >= 5;
            if(yearDifference == legalAge){ // 5==5
                if(currentMonth >= month){    // 3>=3
                    if(currentMonth == month){ //3==3
                        if(currentDay >= days) //21 >= 20
                            isValid = true;
                        else
                            isValid = false;
                    }
                }else
                  isValid = true;  
                
            }
        }else
            isValid = false;
        
        return isValid;
    }

    public boolean updateEmployeeDetails(ArrayList<String> data){ //update specified employee details; returns boolean
        AccessControl.require(Action.UPDATE_EMPLOYEE); // Control 4
        boolean isSuccess = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate parsedDate = LocalDate.parse(data.get(3), formatter);
        try {
            String sql = "UPDATE employees e " +
                            "JOIN employee_address ad ON e.employee_address_id = ad.employee_address_id " +
                            "JOIN compensation_details sal ON e.employee_id = sal.employee_id " +
                            "JOIN government_ids id ON e.employee_id = id.employee_id " +
                            "JOIN positions p ON e.position_id = p.position_id " +
                            "JOIN employee_statuses s ON e.status_id = s.status_id " +
                            "SET e.first_name = ?, " +
                            "e.last_name = ?, " +
                            "e.birthdate = ?, " +
                            "e.phone_number = ?, " +
                            "ad.street = ?, " +
                            "ad.barangay = ?, " +
                            "ad.municipality = ?, " +
                            "ad.city = ?, " +
                            "ad.province = ?, " +
                            "ad.zipcode = ?, " +
                            "sal.basic_salary = ?, " +
                            "sal.rice_subsidy = ?, " +
                            "sal.phone_allowance = ?, " +
                            "sal.clothing_allowance = ?, " +
                            "id.sss_number = ?, " +
                            "id.philhealth_number = ?, " +
                            "id.tin_number = ?, " +
                            "id.pagibig_number = ?, " +
                            "e.position_id = (SELECT position_id FROM positions WHERE position_name = ?), " +
                            "e.status_id = (SELECT status_id FROM employee_statuses WHERE status_name = ?), " +
                            "e.immediate_supervisor = ? " +
                            "WHERE e.employee_id = ?";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, data.get(1));  //First Name
            statement.setString(2, data.get(2));  //Last Name
            statement.setDate(3, java.sql.Date.valueOf(parsedDate));  //Birthdate
            statement.setString(4, data.get(4));  //phone number
            statement.setString(5, data.get(5));  //Street
            statement.setString(6, data.get(6));  //Barangay
            statement.setString(7, data.get(7));  //municipality
            statement.setString(8, data.get(8));  //city    
            statement.setString(9, data.get(9));  //Province
            statement.setString(10, data.get(10));  //zipcode
            statement.setDouble(11, Double.parseDouble(data.get(11)));  //Basic Salary
            statement.setDouble(12, Double.parseDouble(data.get(12)));  //rice subsidy
            statement.setDouble(13, Double.parseDouble(data.get(13)));  //phone allowance
            statement.setDouble(14, Double.parseDouble(data.get(14)));  //clothing allowance
            statement.setString(15, data.get(15));  //id sss
            statement.setString(16, data.get(16));  //id philhealth
            statement.setString(17, data.get(17));  //id tin
            statement.setString(18, data.get(18));  //id pagibig
            statement.setString(19, data.get(19));  //position
            statement.setString(20, data.get(20));  //status
            String value = data.get(21).trim();
            if (value.isEmpty()) {  //if statement to catch null value for supervisor id
                statement.setNull(21, java.sql.Types.INTEGER); //supervisor id
            } else {
                statement.setInt(21, Integer.parseInt(value));  //supervisor id
            } 
            statement.setInt(22, Integer.parseInt(data.get(0)));  //employee ID
            int update = statement.executeUpdate();
            if(update > 0){
                isSuccess = true;
                JOptionPane.showMessageDialog(null, "Successfuly Updated Employee Details!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            accountDetails.closeDBRequest(statement);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to Update Employee!", "Error", JOptionPane.ERROR_MESSAGE);  //Error Message 
        }
        return isSuccess;
    }
   
   public void setSelectedName(String selectedName){
       this.selectedName = selectedName;
   }
      
}
