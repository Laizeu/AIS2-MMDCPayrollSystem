/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package payrollsystem;

import java.awt.event.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Paul
 */
public class HumanResourceGUI extends javax.swing.JFrame {
    HumanResource humanResource;
    Employee employee;
    
    public HumanResourceGUI(ArrayList<ArrayList<String>> userDetails) {
        initComponents();
        lblIDSidebar.setText(userDetails.get(0).get(0));
        lblNameSidebar.setText(userDetails.get(0).get(1));
        
        humanResource = new HumanResource(userDetails.get(0).get(0));
        employee = new Employee(userDetails.get(0).get(0));
        employee.viewPersonalDetails();
        setClockText();
    }

    private HumanResourceGUI() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //To empty the fields of all employee details
    public void emptyFieldsEmployeeDetails(){
         txtID2.setText(humanResource.nextEmployeeID().get(0).get(0));txtFName2.setText("");txtLName2.setText("");jBDay2.setDate(null);txtPhoneNum2.setText("");
         textStreet.setText("");textBarangay.setText("");textMunicipality.setText("");textCity.setText("");textProvince.setText("");
         textZipCode.setText("");textBasicSalary.setText("");txtRiceSubsidy1.setText("");txtPhoneAllowance1.setText("");txtClothingAllowance1.setText("");
         txtPhilNum1.setText("");txtSSSNum1.setText("");txtTINNum1.setText("");txtPagIbigNum1.setText("");txtSupervisor1.setText("");
    }
    
    public ArrayList<String> employeDetails (){
        ArrayList<String> tempData = new ArrayList<>();
        if(jBDay2.getDate() == null){
            JOptionPane.showMessageDialog(null, "Please Provide BirthDate!");
        }else{
            tempData.add(txtID2.getText());
            tempData.add(txtFName2.getText());
            tempData.add(txtLName2.getText());
            tempData.add(new SimpleDateFormat("MM/dd/yyyy").format(jBDay2.getDate()));
            tempData.add(txtPhoneNum2.getText());
            tempData.add(textStreet.getText());
            tempData.add(textBarangay.getText());
            tempData.add(textMunicipality.getText());
            tempData.add(textCity.getText());
            tempData.add(textProvince.getText());
            tempData.add(textZipCode.getText()); 
            tempData.add(textBasicSalary.getText());
            tempData.add(txtRiceSubsidy1.getText());
            tempData.add(txtPhoneAllowance1.getText());
            tempData.add(txtClothingAllowance1.getText());
            tempData.add(txtSSSNum1.getText());
            tempData.add(txtPhilNum1.getText());
            tempData.add(txtTINNum1.getText());
            tempData.add(txtPagIbigNum1.getText());
            tempData.add(comboPositions.getSelectedItem().toString());
            tempData.add(comboStatus.getSelectedItem().toString());
            tempData.add(txtSupervisor1.getText());

        }
      return tempData;
    }
    void commaConstraints(java.awt.event.KeyEvent evt){
        if (evt.getKeyChar() == ',') {
                    evt.consume(); // Consume the event, preventing the comma from being entered
                    JOptionPane.showMessageDialog(null, "Commas is not allowed!");
        }
    }
    void letterDashConstraints(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == '-' || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_ENTER)) {
            evt.consume(); // Consume the event, preventing the comma from being entered
            JOptionPane.showMessageDialog(null, "Invalid key!");
        }
    }
    void numberOnly(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_ENTER)) {
            evt.consume(); // Consume the event, preventing the comma from being entered
            JOptionPane.showMessageDialog(null, "Invalid key!");
        }
    }
    void numberDotOnly(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == '.' || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_ENTER)) {
            evt.consume(); // Consume the event, preventing the comma from being entered
            JOptionPane.showMessageDialog(null, "Invalid key!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sideBarPanel = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtClock = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        btnAllEmployees = new javax.swing.JButton();
        btnAllCredentials = new javax.swing.JButton();
        lblNameSidebar = new javax.swing.JLabel();
        lblName5 = new javax.swing.JLabel();
        lblIDSidebar = new javax.swing.JLabel();
        btnPersonalDetails = new javax.swing.JButton();
        btnRequestPort = new javax.swing.JButton();
        btnDTR = new javax.swing.JButton();
        btnLeaveLedger = new javax.swing.JButton();
        btnLeaveLedger1 = new javax.swing.JButton();
        mainTabbed = new javax.swing.JTabbedPane();
        panelMotorPH = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tabbedPersonalDetails = new javax.swing.JPanel();
        panelPersonalDetails1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblEmpID = new javax.swing.JLabel();
        lblFName = new javax.swing.JLabel();
        lblLName = new javax.swing.JLabel();
        lblBDay = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPhoneNum = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtFName = new javax.swing.JTextField();
        txtLName = new javax.swing.JTextField();
        txtBDay = new javax.swing.JTextField();
        txtPhoneNum = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaStreet = new javax.swing.JTextArea();
        lblBrgy = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblProvince = new javax.swing.JLabel();
        lblZipCode = new javax.swing.JLabel();
        txtBrgy = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtProvince = new javax.swing.JTextField();
        txtZipCode = new javax.swing.JTextField();
        panelPersonalDetails = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblBasicSalary = new javax.swing.JLabel();
        lblRiceSubsidy = new javax.swing.JLabel();
        lblPhoneAllowances = new javax.swing.JLabel();
        lblClothingAllowanes = new javax.swing.JLabel();
        txtBasicSalary = new javax.swing.JTextField();
        txtRiceSubsidy = new javax.swing.JTextField();
        txtPhoneAllowance = new javax.swing.JTextField();
        txtClothingAllowance = new javax.swing.JTextField();
        lblBiMonthlyRate = new javax.swing.JLabel();
        txtBiMonthlyRate = new javax.swing.JTextField();
        lblHourlyRate = new javax.swing.JLabel();
        txtHourlyRate = new javax.swing.JTextField();
        panelPersonalDetails2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblPhilNum = new javax.swing.JLabel();
        lblSSSNum = new javax.swing.JLabel();
        lblTINNum = new javax.swing.JLabel();
        lblPagIbigNum = new javax.swing.JLabel();
        txtPhilNum = new javax.swing.JTextField();
        txtSSSNum = new javax.swing.JTextField();
        txtTINNum = new javax.swing.JTextField();
        txtPagIbigNum = new javax.swing.JTextField();
        panelPersonalDetails3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblPosition = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblSupervisor = new javax.swing.JLabel();
        txtPosition = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtSupervisor = new javax.swing.JTextField();
        tabbedRequest = new javax.swing.JPanel();
        panelTypeRequest = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblRequestType = new javax.swing.JLabel();
        comboTypeRequest = new javax.swing.JComboBox<>();
        tabbedInsideRequest = new javax.swing.JTabbedPane();
        panelAllRequest = new javax.swing.JPanel();
        lblAllRequest = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableAllRequest = new javax.swing.JTable();
        jSeparator6 = new javax.swing.JSeparator();
        panelLeaveRequestDetails = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtReason = new javax.swing.JTextArea();
        dateTo = new com.toedter.calendar.JDateChooser();
        dateFrom = new com.toedter.calendar.JDateChooser();
        lblMyName1 = new javax.swing.JLabel();
        txtDaysNumber = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        lblSLBalance = new javax.swing.JLabel();
        lblVLBalance = new javax.swing.JLabel();
        lblSL = new javax.swing.JLabel();
        lblVL = new javax.swing.JLabel();
        lblLeaveBalances = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        lblID = new javax.swing.JLabel();
        lblMyName = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblEmpID1 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        comboLeaveType = new javax.swing.JComboBox<>();
        panelOvertimeRequest = new javax.swing.JPanel();
        lblEmpID2 = new javax.swing.JLabel();
        lblID1 = new javax.swing.JLabel();
        lblName1 = new javax.swing.JLabel();
        lblMyName2 = new javax.swing.JLabel();
        dateFromOvertime = new com.toedter.calendar.JDateChooser();
        dateToOvertime = new com.toedter.calendar.JDateChooser();
        lblMyName3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtReasonOvertime = new javax.swing.JTextArea();
        btnSubmit1 = new javax.swing.JButton();
        lblLeaveBalances1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txtDaysNumber1 = new javax.swing.JTextField();
        tabbedDTR = new javax.swing.JPanel();
        panelDTR = new javax.swing.JPanel();
        tableDTR = new javax.swing.JScrollPane();
        jTableAllDTR = new javax.swing.JTable();
        dateFrom2 = new com.toedter.calendar.JDateChooser();
        dateTo2 = new com.toedter.calendar.JDateChooser();
        lblPeriod = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        lblName2 = new javax.swing.JLabel();
        lblMyName4 = new javax.swing.JLabel();
        lblEmpID3 = new javax.swing.JLabel();
        lblID2 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        tabbedLeaveLedger = new javax.swing.JPanel();
        panelLeaveLedger = new javax.swing.JPanel();
        tableDTR1 = new javax.swing.JScrollPane();
        jTableAllRequest3 = new javax.swing.JTable();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        lblSL1 = new javax.swing.JLabel();
        lblSLBalance1 = new javax.swing.JLabel();
        lblVL1 = new javax.swing.JLabel();
        lblVLBalance1 = new javax.swing.JLabel();
        lblMyName5 = new javax.swing.JLabel();
        lblName3 = new javax.swing.JLabel();
        lblEmpID4 = new javax.swing.JLabel();
        lblID3 = new javax.swing.JLabel();
        lblLeaveBalances2 = new javax.swing.JLabel();
        tabbedPayslip = new javax.swing.JPanel();
        panelPayslip = new javax.swing.JPanel();
        jSeparator12 = new javax.swing.JSeparator();
        dateFrom3 = new com.toedter.calendar.JDateChooser();
        dateTo3 = new com.toedter.calendar.JDateChooser();
        btnReport = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tabbedAllEmployees = new javax.swing.JPanel();
        panelTypeRequest1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        tabbedInsideRequest1 = new javax.swing.JTabbedPane();
        panelAllRequest1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableEmployees = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        lblAllRequest3 = new javax.swing.JLabel();
        lblAllRequest4 = new javax.swing.JLabel();
        lblEmpID7 = new javax.swing.JLabel();
        txtID2 = new javax.swing.JTextField();
        lblFName2 = new javax.swing.JLabel();
        txtFName2 = new javax.swing.JTextField();
        lblLName2 = new javax.swing.JLabel();
        txtLName2 = new javax.swing.JTextField();
        lblBDay2 = new javax.swing.JLabel();
        lblPhoneNum2 = new javax.swing.JLabel();
        txtPhoneNum2 = new javax.swing.JTextField();
        lblStreet = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        textStreet = new javax.swing.JTextArea();
        lblPhilNum1 = new javax.swing.JLabel();
        txtPhilNum1 = new javax.swing.JTextField();
        lblSSSNum1 = new javax.swing.JLabel();
        txtSSSNum1 = new javax.swing.JTextField();
        lblTINNum1 = new javax.swing.JLabel();
        txtTINNum1 = new javax.swing.JTextField();
        lblPagIbigNum1 = new javax.swing.JLabel();
        txtPagIbigNum1 = new javax.swing.JTextField();
        lblBarangay = new javax.swing.JLabel();
        lblCities = new javax.swing.JLabel();
        textCity = new javax.swing.JTextField();
        lblProvinces = new javax.swing.JLabel();
        textZipCode = new javax.swing.JTextField();
        lblRiceSubsidy1 = new javax.swing.JLabel();
        txtRiceSubsidy1 = new javax.swing.JTextField();
        lblPhoneAllowances1 = new javax.swing.JLabel();
        txtPhoneAllowance1 = new javax.swing.JTextField();
        lblClothingAllowanes1 = new javax.swing.JLabel();
        txtClothingAllowance1 = new javax.swing.JTextField();
        lblPosition1 = new javax.swing.JLabel();
        lblStatus1 = new javax.swing.JLabel();
        lblSupervisor1 = new javax.swing.JLabel();
        txtSupervisor1 = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JSeparator();
        jBDay2 = new com.toedter.calendar.JDateChooser();
        comboStatus = new javax.swing.JComboBox<>();
        textProvince = new javax.swing.JTextField();
        lblZipCodes = new javax.swing.JLabel();
        textBarangay = new javax.swing.JTextField();
        lblMunicipality = new javax.swing.JLabel();
        textMunicipality = new javax.swing.JTextField();
        lblRiceSubsidy2 = new javax.swing.JLabel();
        textBasicSalary = new javax.swing.JTextField();
        comboPositions = new javax.swing.JComboBox<>();
        btnUpdate = new javax.swing.JButton();
        panelAllRequest3 = new javax.swing.JPanel();
        lblPayrollPeriod = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTablePayroll = new javax.swing.JTable();
        jSeparator16 = new javax.swing.JSeparator();
        lblAllRequest5 = new javax.swing.JLabel();
        lblFrom = new javax.swing.JLabel();
        lblTo = new javax.swing.JLabel();
        jDateFrom = new com.toedter.calendar.JDateChooser();
        jDateTo = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        comboAllDetails = new javax.swing.JComboBox<>();
        tabbedAllCredentials = new javax.swing.JPanel();
        panelTypeRequest2 = new javax.swing.JPanel();
        tabbedInsideRequest2 = new javax.swing.JTabbedPane();
        panelAllRequest2 = new javax.swing.JPanel();
        lblAllRequest2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableCredentials = new javax.swing.JTable();
        jSeparator17 = new javax.swing.JSeparator();
        btnUpdate2 = new javax.swing.JButton();
        lblCredentialID = new javax.swing.JLabel();
        txtCredentialID = new javax.swing.JTextField();
        lblCredentialPassword = new javax.swing.JLabel();
        txtCredentialPassword = new javax.swing.JTextField();
        lblRequestType2 = new javax.swing.JLabel();
        txtCredentialRole = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LabelMotorPH.png"))); // NOI18N
        jPanel8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 300, 70));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 110, 90));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1600, 30, -1, 50));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1750, 100));

        sideBarPanel.setBackground(new java.awt.Color(255, 204, 102));

        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clock.png"))); // NOI18N

        txtClock.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtClock.setText("8:00 AM");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/employee.png"))); // NOI18N

        jSeparator13.setBackground(new java.awt.Color(255, 204, 153));
        jSeparator13.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator14.setBackground(new java.awt.Color(255, 204, 153));
        jSeparator14.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator15.setBackground(new java.awt.Color(255, 204, 153));
        jSeparator15.setForeground(new java.awt.Color(255, 255, 255));

        btnAllEmployees.setText(">VIEW EMPLOYEE AND PAYROLL");
        btnAllEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllEmployeesActionPerformed(evt);
            }
        });

        btnAllCredentials.setText(">>VIEW ALL CREDENTIALS");
        btnAllCredentials.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllCredentialsActionPerformed(evt);
            }
        });

        lblNameSidebar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNameSidebar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNameSidebar.setText("Aquino Bianca Sofia");
        lblNameSidebar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblName5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName5.setText("No.");

        lblIDSidebar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIDSidebar.setText("10003");

        btnPersonalDetails.setText("PERSONAL DETAILS");
        btnPersonalDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalDetailsActionPerformed(evt);
            }
        });

        btnRequestPort.setText("EMPLOYEE REQUEST");
        btnRequestPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestPortActionPerformed(evt);
            }
        });

        btnDTR.setText("DTR");
        btnDTR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDTRActionPerformed(evt);
            }
        });

        btnLeaveLedger.setText("LEAVE LEDGER");
        btnLeaveLedger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaveLedgerActionPerformed(evt);
            }
        });

        btnLeaveLedger1.setText("PAYSLIP");
        btnLeaveLedger1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaveLedger1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sideBarPanelLayout = new javax.swing.GroupLayout(sideBarPanel);
        sideBarPanel.setLayout(sideBarPanelLayout);
        sideBarPanelLayout.setHorizontalGroup(
            sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(sideBarPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtClock)))
                .addGap(36, 36, 36))
            .addGroup(sideBarPanelLayout.createSequentialGroup()
                .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sideBarPanelLayout.createSequentialGroup()
                        .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sideBarPanelLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(sideBarPanelLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel6)))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(sideBarPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator14)
                            .addGroup(sideBarPanelLayout.createSequentialGroup()
                                .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAllEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAllCredentials, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarPanelLayout.createSequentialGroup()
                .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sideBarPanelLayout.createSequentialGroup()
                        .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sideBarPanelLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(lblName5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIDSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnPersonalDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRequestPort, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDTR, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLeaveLedger, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLeaveLedger1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNameSidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sideBarPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator13)
                    .addContainerGap()))
            .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sideBarPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator15)
                    .addContainerGap()))
        );
        sideBarPanelLayout.setVerticalGroup(
            sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblNameSidebar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName5)
                    .addComponent(lblIDSidebar))
                .addGap(27, 27, 27)
                .addComponent(btnPersonalDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRequestPort, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDTR, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnLeaveLedger, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLeaveLedger1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAllEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAllCredentials, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sideBarPanelLayout.createSequentialGroup()
                    .addGap(158, 158, 158)
                    .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(629, Short.MAX_VALUE)))
            .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarPanelLayout.createSequentialGroup()
                    .addContainerGap(450, Short.MAX_VALUE)
                    .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(337, 337, 337)))
        );

        jPanel1.add(sideBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, 790));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hrPortal.jpg"))); // NOI18N

        javax.swing.GroupLayout panelMotorPHLayout = new javax.swing.GroupLayout(panelMotorPH);
        panelMotorPH.setLayout(panelMotorPHLayout);
        panelMotorPHLayout.setHorizontalGroup(
            panelMotorPHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMotorPHLayout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(368, Short.MAX_VALUE))
        );
        panelMotorPHLayout.setVerticalGroup(
            panelMotorPHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMotorPHLayout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(379, Short.MAX_VALUE))
        );

        mainTabbed.addTab("tab6", panelMotorPH);

        tabbedPersonalDetails.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));

        panelPersonalDetails1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personal Details", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N

        lblEmpID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmpID.setText("Employee ID:");

        lblFName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFName.setText("First Name:");

        lblLName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLName.setText("Last Name:");

        lblBDay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBDay.setText("Birthday:");

        lblAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAddress.setText("Street");

        lblPhoneNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPhoneNum.setText("Phone No.");

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtFName.setEditable(false);
        txtFName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtLName.setEditable(false);
        txtLName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtBDay.setEditable(false);
        txtBDay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtPhoneNum.setEditable(false);
        txtPhoneNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        textAreaStreet.setEditable(false);
        textAreaStreet.setColumns(20);
        textAreaStreet.setRows(5);
        jScrollPane1.setViewportView(textAreaStreet);

        lblBrgy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBrgy.setText("Barangay :");

        lblCity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCity.setText("City :");

        lblProvince.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblProvince.setText("Province :");

        lblZipCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblZipCode.setText("Zip Code:");

        txtBrgy.setEditable(false);
        txtBrgy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtCity.setEditable(false);
        txtCity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtProvince.setEditable(false);
        txtProvince.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtZipCode.setEditable(false);
        txtZipCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblEmpID, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblFName)
                                .addGap(25, 25, 25)
                                .addComponent(txtFName))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblPhoneNum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblBDay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblLName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lblAddress))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(txtLName)
                                    .addComponent(txtBDay)
                                    .addComponent(txtPhoneNum)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblZipCode)
                                .addGap(36, 36, 36)
                                .addComponent(txtZipCode))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblBrgy)
                                .addGap(30, 30, 30)
                                .addComponent(txtBrgy))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblCity, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(txtCity))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblProvince)
                        .addGap(41, 41, 41)
                        .addComponent(txtProvince)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmpID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFName)
                    .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLName)
                    .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBDay)
                    .addComponent(txtBDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPhoneNum)
                    .addComponent(txtPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddress)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBrgy)
                    .addComponent(txtBrgy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCity)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProvince)
                    .addComponent(txtProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblZipCode)
                    .addComponent(txtZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPersonalDetails1Layout = new javax.swing.GroupLayout(panelPersonalDetails1);
        panelPersonalDetails1.setLayout(panelPersonalDetails1Layout);
        panelPersonalDetails1Layout.setHorizontalGroup(
            panelPersonalDetails1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalDetails1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPersonalDetails1Layout.setVerticalGroup(
            panelPersonalDetails1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalDetails1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        panelPersonalDetails.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salaries and Allowances", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N

        lblBasicSalary.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBasicSalary.setText("Basic Salary :");

        lblRiceSubsidy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRiceSubsidy.setText("Rice Subsidy: ");

        lblPhoneAllowances.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPhoneAllowances.setText("Phone Allowances: ");

        lblClothingAllowanes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblClothingAllowanes.setText("Clothing Allowances: ");

        txtBasicSalary.setEditable(false);
        txtBasicSalary.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBasicSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBasicSalaryActionPerformed(evt);
            }
        });

        txtRiceSubsidy.setEditable(false);
        txtRiceSubsidy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtRiceSubsidy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRiceSubsidyActionPerformed(evt);
            }
        });

        txtPhoneAllowance.setEditable(false);
        txtPhoneAllowance.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPhoneAllowance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneAllowanceActionPerformed(evt);
            }
        });

        txtClothingAllowance.setEditable(false);
        txtClothingAllowance.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtClothingAllowance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClothingAllowanceActionPerformed(evt);
            }
        });

        lblBiMonthlyRate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBiMonthlyRate.setText("BiMonthly Rate:");

        txtBiMonthlyRate.setEditable(false);
        txtBiMonthlyRate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblHourlyRate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHourlyRate.setText("Hourly Rate:");

        txtHourlyRate.setEditable(false);
        txtHourlyRate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblBasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(lblBiMonthlyRate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(36, 36, 36)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblHourlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHourlyRate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(txtBiMonthlyRate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBasicSalary, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblClothingAllowanes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPhoneAllowances, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRiceSubsidy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhoneAllowance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(txtClothingAllowance, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtRiceSubsidy, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(6, 6, 6))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBasicSalary)
                    .addComponent(txtBasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBiMonthlyRate)
                    .addComponent(txtBiMonthlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHourlyRate)
                    .addComponent(txtHourlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRiceSubsidy)
                    .addComponent(txtRiceSubsidy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhoneAllowances)
                    .addComponent(txtPhoneAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClothingAllowanes)
                    .addComponent(txtClothingAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelPersonalDetailsLayout = new javax.swing.GroupLayout(panelPersonalDetails);
        panelPersonalDetails.setLayout(panelPersonalDetailsLayout);
        panelPersonalDetailsLayout.setHorizontalGroup(
            panelPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        panelPersonalDetailsLayout.setVerticalGroup(
            panelPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalDetailsLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPersonalDetails2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Government IDs", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N

        lblPhilNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPhilNum.setText("PhilHealth No.");

        lblSSSNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSSSNum.setText("SSS No.");

        lblTINNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTINNum.setText("TIN No.");

        lblPagIbigNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPagIbigNum.setText("PagIbig No.");

        txtPhilNum.setEditable(false);
        txtPhilNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSSSNum.setEditable(false);
        txtSSSNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTINNum.setEditable(false);
        txtTINNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtPagIbigNum.setEditable(false);
        txtPagIbigNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblPagIbigNum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(lblTINNum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTINNum, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(txtPagIbigNum)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSSSNum)
                            .addComponent(lblPhilNum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhilNum)
                            .addComponent(txtSSSNum))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPhilNum)
                    .addComponent(txtPhilNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSSSNum)
                    .addComponent(txtSSSNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTINNum)
                    .addComponent(txtTINNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPagIbigNum)
                    .addComponent(txtPagIbigNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPersonalDetails2Layout = new javax.swing.GroupLayout(panelPersonalDetails2);
        panelPersonalDetails2.setLayout(panelPersonalDetails2Layout);
        panelPersonalDetails2Layout.setHorizontalGroup(
            panelPersonalDetails2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalDetails2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPersonalDetails2Layout.setVerticalGroup(
            panelPersonalDetails2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalDetails2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPersonalDetails3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employment Details", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N

        lblPosition.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPosition.setText("Position: ");

        lblStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblStatus.setText("Status:");

        lblSupervisor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSupervisor.setText("Supervisor:");

        txtPosition.setEditable(false);
        txtPosition.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPositionActionPerformed(evt);
            }
        });

        txtStatus.setEditable(false);
        txtStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSupervisor.setEditable(false);
        txtSupervisor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupervisorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSupervisor, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(lblPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(txtSupervisor)
                    .addComponent(txtPosition))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPosition)
                    .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupervisor)
                    .addComponent(txtSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelPersonalDetails3Layout = new javax.swing.GroupLayout(panelPersonalDetails3);
        panelPersonalDetails3.setLayout(panelPersonalDetails3Layout);
        panelPersonalDetails3Layout.setHorizontalGroup(
            panelPersonalDetails3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalDetails3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPersonalDetails3Layout.setVerticalGroup(
            panelPersonalDetails3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalDetails3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabbedPersonalDetailsLayout = new javax.swing.GroupLayout(tabbedPersonalDetails);
        tabbedPersonalDetails.setLayout(tabbedPersonalDetailsLayout);
        tabbedPersonalDetailsLayout.setHorizontalGroup(
            tabbedPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabbedPersonalDetailsLayout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(panelPersonalDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(panelPersonalDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(panelPersonalDetails2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(panelPersonalDetails3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        tabbedPersonalDetailsLayout.setVerticalGroup(
            tabbedPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedPersonalDetailsLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(tabbedPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabbedPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(panelPersonalDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelPersonalDetails2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelPersonalDetails3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelPersonalDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        mainTabbed.addTab("Personal Details", tabbedPersonalDetails);

        panelTypeRequest.setBackground(new java.awt.Color(255, 255, 255));
        panelTypeRequest.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NEW REQUEST", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 102, 0))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRequestType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRequestType.setText("Request Type :");
        jPanel2.add(lblRequestType, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 100, -1));

        comboTypeRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Request", "Leave Application", "Overtime Application" }));
        comboTypeRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTypeRequestActionPerformed(evt);
            }
        });
        jPanel2.add(comboTypeRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 198, 31));

        tabbedInsideRequest.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        panelAllRequest.setBackground(new java.awt.Color(255, 255, 255));

        lblAllRequest.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAllRequest.setText("ALL REQUEST");

        jTableAllRequest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableAllRequest.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableAllRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DATE FILED", "TYPE OF REQUEST", "PERIOD FROM", "PERIOD TO", "NUMBER OF DAYS", "REASON", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAllRequest.setColumnSelectionAllowed(true);
        jTableAllRequest.setRowHeight(25);
        jTableAllRequest.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTableAllRequest);

        jSeparator6.setBackground(new java.awt.Color(255, 204, 153));

        javax.swing.GroupLayout panelAllRequestLayout = new javax.swing.GroupLayout(panelAllRequest);
        panelAllRequest.setLayout(panelAllRequestLayout);
        panelAllRequestLayout.setHorizontalGroup(
            panelAllRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAllRequestLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(panelAllRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAllRequestLayout.createSequentialGroup()
                        .addComponent(lblAllRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(400, 400, 400))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAllRequestLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        panelAllRequestLayout.setVerticalGroup(
            panelAllRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAllRequestLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblAllRequest)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        tabbedInsideRequest.addTab("", panelAllRequest);

        panelLeaveRequestDetails.setBackground(new java.awt.Color(255, 255, 255));

        txtReason.setColumns(20);
        txtReason.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtReason.setRows(5);
        txtReason.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reason", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N
        jScrollPane2.setViewportView(txtReason);

        dateTo.setBackground(new java.awt.Color(255, 255, 255));
        dateTo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "To", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N
        dateTo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateToPropertyChange(evt);
            }
        });

        dateFrom.setBackground(new java.awt.Color(255, 255, 255));
        dateFrom.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "From", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51)))); // NOI18N
        dateFrom.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateFromPropertyChange(evt);
            }
        });

        lblMyName1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMyName1.setText("Inclusive Dates");

        txtDaysNumber.setEditable(false);
        txtDaysNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDaysNumber.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Number of Working Days Applied For", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 102))); // NOI18N
        txtDaysNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDaysNumberActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(255, 204, 153));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        lblSLBalance.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSLBalance.setText("30.30");

        lblVLBalance.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVLBalance.setText("20.20");

        lblSL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSL.setText("Sick Leave Leave (SL) :");

        lblVL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblVL.setText("Vacation Leave (VL) :");

        lblLeaveBalances.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLeaveBalances.setText("Leave Balances as of this Date");

        jSeparator3.setBackground(new java.awt.Color(255, 204, 153));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator1.setBackground(new java.awt.Color(255, 204, 153));

        lblID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblID.setText("123");

        lblMyName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMyName.setText("John Paul Arquita");

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName.setText("Name :");

        lblEmpID1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmpID1.setText("Employee ID:");

        btnSubmit.setText("SUBMIT");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        comboLeaveType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboLeaveType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Vacation Leave", "Sick Leave" }));
        comboLeaveType.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Type of Leave", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N

        javax.swing.GroupLayout panelLeaveRequestDetailsLayout = new javax.swing.GroupLayout(panelLeaveRequestDetails);
        panelLeaveRequestDetails.setLayout(panelLeaveRequestDetailsLayout);
        panelLeaveRequestDetailsLayout.setHorizontalGroup(
            panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLeaveRequestDetailsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLeaveRequestDetailsLayout.createSequentialGroup()
                        .addComponent(lblLeaveBalances, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(353, 353, 353))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLeaveRequestDetailsLayout.createSequentialGroup()
                        .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                                .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateFrom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMyName1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(110, 110, 110)
                                .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2)
                                .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                                    .addComponent(txtDaysNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(110, 110, 110)
                                    .addComponent(comboLeaveType, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(220, 220, 220))))
            .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                        .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                                .addGap(195, 195, 195)
                                .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEmpID1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMyName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(104, 104, 104)
                                .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                                        .addComponent(lblSL, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblSLBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                                        .addComponent(lblVL, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblVLBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelLeaveRequestDetailsLayout.setVerticalGroup(
            panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLeaveRequestDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLeaveBalances)
                .addGap(12, 12, 12)
                .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                        .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmpID1)
                            .addComponent(lblID))
                        .addGap(13, 13, 13)
                        .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMyName)
                            .addComponent(lblName)))
                    .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                        .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVLBalance)
                            .addComponent(lblVL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSLBalance)
                            .addComponent(lblSL))))
                .addGap(15, 15, 15)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(txtDaysNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(comboLeaveType, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMyName1)
                .addGap(9, 9, 9)
                .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateTo, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(dateFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        tabbedInsideRequest.addTab("", panelLeaveRequestDetails);

        panelOvertimeRequest.setBackground(new java.awt.Color(255, 255, 255));

        lblEmpID2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmpID2.setText("Employee ID:");

        lblID1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblID1.setText("10001");

        lblName1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName1.setText("Name :");

        lblMyName2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMyName2.setText("John Paul Arquita");

        dateFromOvertime.setBackground(new java.awt.Color(255, 255, 255));
        dateFromOvertime.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "From", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51)))); // NOI18N
        dateFromOvertime.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateFromOvertimePropertyChange(evt);
            }
        });

        dateToOvertime.setBackground(new java.awt.Color(255, 255, 255));
        dateToOvertime.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "To", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N
        dateToOvertime.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateToOvertimePropertyChange(evt);
            }
        });

        lblMyName3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMyName3.setText("Inclusive Dates*");

        txtReasonOvertime.setColumns(20);
        txtReasonOvertime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtReasonOvertime.setRows(5);
        txtReasonOvertime.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reason", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N
        jScrollPane3.setViewportView(txtReasonOvertime);

        btnSubmit1.setText("SUBMIT");
        btnSubmit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmit1ActionPerformed(evt);
            }
        });

        lblLeaveBalances1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLeaveBalances1.setText("Overtime Request");

        jSeparator4.setBackground(new java.awt.Color(255, 204, 153));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator5.setBackground(new java.awt.Color(255, 204, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel1.setText("*Please be informed that the overtime period is from 5:01pm to 9:00pm only.");

        txtDaysNumber1.setEditable(false);
        txtDaysNumber1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDaysNumber1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Number of Working Days Applied For", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 102))); // NOI18N
        txtDaysNumber1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDaysNumber1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOvertimeRequestLayout = new javax.swing.GroupLayout(panelOvertimeRequest);
        panelOvertimeRequest.setLayout(panelOvertimeRequestLayout);
        panelOvertimeRequestLayout.setHorizontalGroup(
            panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOvertimeRequestLayout.createSequentialGroup()
                .addContainerGap(196, Short.MAX_VALUE)
                .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOvertimeRequestLayout.createSequentialGroup()
                        .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateToOvertime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDaysNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblMyName3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dateFromOvertime, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSubmit1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(185, 185, 185))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOvertimeRequestLayout.createSequentialGroup()
                        .addComponent(lblLeaveBalances1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(350, 350, 350))
                    .addGroup(panelOvertimeRequestLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmpID2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblID1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMyName2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelOvertimeRequestLayout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jSeparator4)
                    .addGap(2, 2, 2)))
            .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE))
        );
        panelOvertimeRequestLayout.setVerticalGroup(
            panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOvertimeRequestLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblLeaveBalances1)
                .addGap(24, 24, 24)
                .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmpID2)
                    .addComponent(lblID1))
                .addGap(13, 13, 13)
                .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMyName2)
                    .addComponent(lblName1))
                .addGap(35, 35, 35)
                .addComponent(lblMyName3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateToOvertime, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(dateFromOvertime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(txtDaysNumber1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addComponent(btnSubmit1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelOvertimeRequestLayout.createSequentialGroup()
                    .addGap(137, 137, 137)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(427, Short.MAX_VALUE)))
            .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelOvertimeRequestLayout.createSequentialGroup()
                    .addGap(461, 461, 461)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(103, Short.MAX_VALUE)))
        );

        tabbedInsideRequest.addTab("", panelOvertimeRequest);

        javax.swing.GroupLayout panelTypeRequestLayout = new javax.swing.GroupLayout(panelTypeRequest);
        panelTypeRequest.setLayout(panelTypeRequestLayout);
        panelTypeRequestLayout.setHorizontalGroup(
            panelTypeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTypeRequestLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTypeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedInsideRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 997, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelTypeRequestLayout.setVerticalGroup(
            panelTypeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTypeRequestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tabbedInsideRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabbedRequestLayout = new javax.swing.GroupLayout(tabbedRequest);
        tabbedRequest.setLayout(tabbedRequestLayout);
        tabbedRequestLayout.setHorizontalGroup(
            tabbedRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedRequestLayout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(panelTypeRequest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(238, Short.MAX_VALUE))
        );
        tabbedRequestLayout.setVerticalGroup(
            tabbedRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedRequestLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(panelTypeRequest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        mainTabbed.addTab("Request Port", tabbedRequest);

        panelDTR.setBackground(new java.awt.Color(255, 255, 255));
        panelDTR.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "YOUR DAILY TIME RECORD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 102, 0))); // NOI18N

        jTableAllDTR.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableAllDTR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DATE", "LOGIN", "LOGOUT", "REMARKS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAllDTR.setColumnSelectionAllowed(true);
        jTableAllDTR.setRowHeight(25);
        jTableAllDTR.getTableHeader().setReorderingAllowed(false);
        tableDTR.setViewportView(jTableAllDTR);
        jTableAllDTR.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        dateFrom2.setBackground(new java.awt.Color(255, 255, 255));
        dateFrom2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "From", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51)))); // NOI18N

        dateTo2.setBackground(new java.awt.Color(255, 255, 255));
        dateTo2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "To", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N

        lblPeriod.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPeriod.setText("Period :");

        jSeparator7.setBackground(new java.awt.Color(255, 204, 153));

        jSeparator8.setBackground(new java.awt.Color(255, 204, 153));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));

        lblName2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName2.setText("Name :");

        lblMyName4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMyName4.setText("John Paul Arquita");

        lblEmpID3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmpID3.setText("Employee ID:");

        lblID2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblID2.setText("10001");

        btnClear.setText("Search");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDTRLayout = new javax.swing.GroupLayout(panelDTR);
        panelDTR.setLayout(panelDTRLayout);
        panelDTRLayout.setHorizontalGroup(
            panelDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator7)
            .addGroup(panelDTRLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panelDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmpID3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblID2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMyName4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelDTRLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDTRLayout.createSequentialGroup()
                        .addGap(0, 39, Short.MAX_VALUE)
                        .addGroup(panelDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelDTRLayout.createSequentialGroup()
                                .addComponent(lblPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dateFrom2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(dateTo2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDTRLayout.createSequentialGroup()
                                .addComponent(tableDTR, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))))
                    .addComponent(jSeparator8)))
        );
        panelDTRLayout.setVerticalGroup(
            panelDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDTRLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(panelDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmpID3)
                    .addComponent(lblID2))
                .addGap(13, 13, 13)
                .addGroup(panelDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMyName4)
                    .addComponent(lblName2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDTRLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateFrom2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDTRLayout.createSequentialGroup()
                                .addComponent(lblPeriod)
                                .addGap(9, 9, 9))
                            .addComponent(dateTo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelDTRLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(tableDTR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        javax.swing.GroupLayout tabbedDTRLayout = new javax.swing.GroupLayout(tabbedDTR);
        tabbedDTR.setLayout(tabbedDTRLayout);
        tabbedDTRLayout.setHorizontalGroup(
            tabbedDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedDTRLayout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(panelDTR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(279, Short.MAX_VALUE))
        );
        tabbedDTRLayout.setVerticalGroup(
            tabbedDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabbedDTRLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(panelDTR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        mainTabbed.addTab("tab3", tabbedDTR);

        panelLeaveLedger.setBackground(new java.awt.Color(255, 255, 255));
        panelLeaveLedger.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "YOUR LEAVE LEDGER HISTORY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 102, 0))); // NOI18N

        jTableAllRequest3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableAllRequest3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DATE FILED", "TYPE OF LEAVE", "FROM", "TO", "NUMBER OF DAYS", "REASON", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAllRequest3.setColumnSelectionAllowed(true);
        jTableAllRequest3.setRowHeight(25);
        jTableAllRequest3.getTableHeader().setReorderingAllowed(false);
        tableDTR1.setViewportView(jTableAllRequest3);

        jSeparator9.setBackground(new java.awt.Color(255, 204, 153));

        jSeparator11.setBackground(new java.awt.Color(255, 204, 153));
        jSeparator11.setForeground(new java.awt.Color(255, 255, 255));

        lblSL1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSL1.setText("Sick Leave Leave (SL) :");

        lblSLBalance1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSLBalance1.setText("30.30");

        lblVL1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblVL1.setText("Vacation Leave (VL) :");

        lblVLBalance1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVLBalance1.setText("20.20");

        lblMyName5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMyName5.setText("John Paul Arquita");

        lblName3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName3.setText("Name :");

        lblEmpID4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmpID4.setText("Employee ID:");

        lblID3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblID3.setText("10001");

        lblLeaveBalances2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLeaveBalances2.setText("LEAVE LEDGER");

        javax.swing.GroupLayout panelLeaveLedgerLayout = new javax.swing.GroupLayout(panelLeaveLedger);
        panelLeaveLedger.setLayout(panelLeaveLedgerLayout);
        panelLeaveLedgerLayout.setHorizontalGroup(
            panelLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator9)
            .addGroup(panelLeaveLedgerLayout.createSequentialGroup()
                .addComponent(jSeparator11)
                .addGap(6, 6, 6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLeaveLedgerLayout.createSequentialGroup()
                .addGap(0, 47, Short.MAX_VALUE)
                .addComponent(tableDTR1, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLeaveLedgerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmpID4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblID3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMyName5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(180, 180, 180)
                .addGroup(panelLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLeaveLedgerLayout.createSequentialGroup()
                        .addComponent(lblSL1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSLBalance1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLeaveLedgerLayout.createSequentialGroup()
                        .addComponent(lblVL1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblVLBalance1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(215, 215, 215))
            .addGroup(panelLeaveLedgerLayout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addComponent(lblLeaveBalances2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLeaveLedgerLayout.setVerticalGroup(
            panelLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLeaveLedgerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblLeaveBalances2)
                .addGap(22, 22, 22)
                .addGroup(panelLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLeaveLedgerLayout.createSequentialGroup()
                        .addGroup(panelLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmpID4)
                            .addComponent(lblID3))
                        .addGap(13, 13, 13)
                        .addGroup(panelLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMyName5)
                            .addComponent(lblName3)))
                    .addGroup(panelLeaveLedgerLayout.createSequentialGroup()
                        .addGroup(panelLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVLBalance1)
                            .addComponent(lblVL1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSLBalance1)
                            .addComponent(lblSL1))))
                .addGap(21, 21, 21)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tableDTR1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        javax.swing.GroupLayout tabbedLeaveLedgerLayout = new javax.swing.GroupLayout(tabbedLeaveLedger);
        tabbedLeaveLedger.setLayout(tabbedLeaveLedgerLayout);
        tabbedLeaveLedgerLayout.setHorizontalGroup(
            tabbedLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedLeaveLedgerLayout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(panelLeaveLedger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );
        tabbedLeaveLedgerLayout.setVerticalGroup(
            tabbedLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabbedLeaveLedgerLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(panelLeaveLedger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        mainTabbed.addTab("tab4", tabbedLeaveLedger);

        panelPayslip.setBackground(new java.awt.Color(255, 255, 255));
        panelPayslip.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "YOUR PERSONAL PAYSLIP", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 102, 0))); // NOI18N

        jSeparator12.setBackground(new java.awt.Color(255, 204, 153));
        jSeparator12.setForeground(new java.awt.Color(255, 255, 255));

        dateFrom3.setBackground(new java.awt.Color(255, 255, 255));
        dateFrom3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "From", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51)))); // NOI18N

        dateTo3.setBackground(new java.awt.Color(255, 255, 255));
        dateTo3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "To", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N

        btnReport.setText("Generate");
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPayslipLayout = new javax.swing.GroupLayout(panelPayslip);
        panelPayslip.setLayout(panelPayslipLayout);
        panelPayslipLayout.setHorizontalGroup(
            panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator12)
            .addGroup(panelPayslipLayout.createSequentialGroup()
                .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPayslipLayout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel7))
                    .addGroup(panelPayslipLayout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(dateFrom3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dateTo3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReport)))
                .addContainerGap(242, Short.MAX_VALUE))
        );
        panelPayslipLayout.setVerticalGroup(
            panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPayslipLayout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFrom3, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(dateTo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(71, 71, 71)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(124, 124, 124))
        );

        javax.swing.GroupLayout tabbedPayslipLayout = new javax.swing.GroupLayout(tabbedPayslip);
        tabbedPayslip.setLayout(tabbedPayslipLayout);
        tabbedPayslipLayout.setHorizontalGroup(
            tabbedPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedPayslipLayout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(panelPayslip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(300, Short.MAX_VALUE))
        );
        tabbedPayslipLayout.setVerticalGroup(
            tabbedPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedPayslipLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(panelPayslip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(277, Short.MAX_VALUE))
        );

        mainTabbed.addTab("tab5", tabbedPayslip);

        panelTypeRequest1.setBackground(new java.awt.Color(255, 255, 255));
        panelTypeRequest1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ALL EMPLOYEE DETAILS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 102, 0))); // NOI18N
        panelTypeRequest1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabbedInsideRequest1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        panelAllRequest1.setBackground(new java.awt.Color(255, 255, 255));

        jTableEmployees.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableEmployees.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "LAST NAME", "FIRST NAME", "BIRTHDAY", "STREET", "BARANGAY", "Municipality", "CITY", "PROVINCE", "ZIP CODE", "PHONE #", "SSS #", "PHILHEALTH #", "TIN #", "PAGIBIG #", "STATUS", "POSITION", "IMMEDIATE SUPERVISOR", "BASIC SALARY", "RICE SUBSIDY", "PHONE ALLOWANC", "CLOTHING ALLOWANCE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEmployees.setColumnSelectionAllowed(true);
        jTableEmployees.setRowHeight(25);
        jTableEmployees.getTableHeader().setReorderingAllowed(false);
        jTableEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmployeesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableEmployees);
        jTableEmployees.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        btnAdd.setText("ADD NEW EMPLOYEE");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblAllRequest3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        lblAllRequest4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAllRequest4.setText("ALL EMPLOYEE DETAILS");

        lblEmpID7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmpID7.setText("Employee ID:");

        txtID2.setEditable(false);
        txtID2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblFName2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFName2.setText("First Name:");

        txtFName2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFName2ActionPerformed(evt);
            }
        });
        txtFName2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFName2KeyTyped(evt);
            }
        });

        lblLName2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLName2.setText("Last Name:");

        txtLName2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLName2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLName2KeyTyped(evt);
            }
        });

        lblBDay2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBDay2.setText("Birthday:");

        lblPhoneNum2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPhoneNum2.setText("Phone No.");

        txtPhoneNum2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPhoneNum2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneNum2KeyTyped(evt);
            }
        });

        lblStreet.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblStreet.setText("Street :");

        textStreet.setColumns(20);
        textStreet.setRows(5);
        textStreet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textStreetKeyTyped(evt);
            }
        });
        jScrollPane8.setViewportView(textStreet);

        lblPhilNum1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPhilNum1.setText("PhilHealth No.");

        txtPhilNum1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPhilNum1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhilNum1KeyTyped(evt);
            }
        });

        lblSSSNum1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSSSNum1.setText("SSS No.");

        txtSSSNum1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSSSNum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSSSNum1ActionPerformed(evt);
            }
        });
        txtSSSNum1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSSSNum1KeyTyped(evt);
            }
        });

        lblTINNum1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTINNum1.setText("TIN No.");

        txtTINNum1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTINNum1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTINNum1KeyTyped(evt);
            }
        });

        lblPagIbigNum1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPagIbigNum1.setText("PagIbig No.");

        txtPagIbigNum1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPagIbigNum1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagIbigNum1KeyTyped(evt);
            }
        });

        lblBarangay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBarangay.setText("Barangay :");

        lblCities.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCities.setText("City :");

        textCity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textCityKeyTyped(evt);
            }
        });

        lblProvinces.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblProvinces.setText("Province :");

        textZipCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textZipCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textZipCodeKeyTyped(evt);
            }
        });

        lblRiceSubsidy1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRiceSubsidy1.setText("Rice Subsidy: ");

        txtRiceSubsidy1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtRiceSubsidy1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRiceSubsidy1KeyTyped(evt);
            }
        });

        lblPhoneAllowances1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPhoneAllowances1.setText("Phone Allowances: ");

        txtPhoneAllowance1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPhoneAllowance1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneAllowance1KeyTyped(evt);
            }
        });

        lblClothingAllowanes1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblClothingAllowanes1.setText("Clothing Allowances: ");

        txtClothingAllowance1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtClothingAllowance1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClothingAllowance1KeyTyped(evt);
            }
        });

        lblPosition1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPosition1.setText("Position: ");

        lblStatus1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblStatus1.setText("Status:");

        lblSupervisor1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSupervisor1.setText("Supervisor ID:");

        txtSupervisor1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSupervisor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupervisor1ActionPerformed(evt);
            }
        });
        txtSupervisor1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSupervisor1KeyTyped(evt);
            }
        });

        jSeparator18.setBackground(new java.awt.Color(255, 204, 153));
        jSeparator18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 51)));

        jBDay2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jBDay2PropertyChange(evt);
            }
        });

        comboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStatusActionPerformed(evt);
            }
        });

        textProvince.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textProvince.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textProvinceKeyTyped(evt);
            }
        });

        lblZipCodes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblZipCodes.setText("Zip Code:");

        textBarangay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textBarangay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textBarangayKeyTyped(evt);
            }
        });

        lblMunicipality.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMunicipality.setText("Municipality : ");

        textMunicipality.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMunicipality.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textMunicipalityKeyTyped(evt);
            }
        });

        lblRiceSubsidy2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRiceSubsidy2.setText("Basic Salary :");

        textBasicSalary.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textBasicSalary.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textBasicSalaryKeyTyped(evt);
            }
        });

        comboPositions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPositionsActionPerformed(evt);
            }
        });

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAllRequest1Layout = new javax.swing.GroupLayout(panelAllRequest1);
        panelAllRequest1.setLayout(panelAllRequest1Layout);
        panelAllRequest1Layout.setHorizontalGroup(
            panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAllRequest1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmpID7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBDay2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblLName2)
                        .addComponent(lblFName2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLName2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFName2)
                    .addComponent(txtID2)
                    .addComponent(jBDay2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAllRequest1Layout.createSequentialGroup()
                        .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPhoneNum2)
                            .addComponent(lblStreet))
                        .addGap(59, 59, 59)
                        .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhoneNum2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelAllRequest1Layout.createSequentialGroup()
                        .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBarangay)
                            .addComponent(lblCities)
                            .addComponent(lblMunicipality))
                        .addGap(38, 38, 38)
                        .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textMunicipality, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textCity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textBarangay, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAllRequest1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lblProvinces, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAllRequest1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAllRequest1Layout.createSequentialGroup()
                                .addComponent(lblClothingAllowanes1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtClothingAllowance1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAllRequest1Layout.createSequentialGroup()
                                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelAllRequest1Layout.createSequentialGroup()
                                        .addComponent(lblPhoneAllowances1)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPhoneAllowance1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelAllRequest1Layout.createSequentialGroup()
                                        .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblZipCodes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblRiceSubsidy1, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblRiceSubsidy2, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textZipCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtRiceSubsidy1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textBasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(54, 54, 54)))
                        .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblPagIbigNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSSSNum1)
                                    .addComponent(lblTINNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelAllRequest1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(lblPhilNum1)))
                        .addGap(33, 33, 33)
                        .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelAllRequest1Layout.createSequentialGroup()
                                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelAllRequest1Layout.createSequentialGroup()
                                        .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtSSSNum1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                                .addComponent(txtPhilNum1))
                                            .addComponent(txtTINNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(panelAllRequest1Layout.createSequentialGroup()
                                                .addComponent(lblStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(24, 24, 24))
                                            .addComponent(lblSupervisor1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblPosition1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtPagIbigNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtSupervisor1)
                                    .addComponent(comboStatus, javax.swing.GroupLayout.Alignment.LEADING, 0, 156, Short.MAX_VALUE)
                                    .addComponent(comboPositions, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelAllRequest1Layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)))
                        .addGap(235, 235, 235))))
            .addGroup(panelAllRequest1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator18))
            .addGroup(panelAllRequest1Layout.createSequentialGroup()
                .addGap(554, 554, 554)
                .addComponent(lblAllRequest4)
                .addGap(0, 875, Short.MAX_VALUE))
            .addGroup(panelAllRequest1Layout.createSequentialGroup()
                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAllRequest1Layout.createSequentialGroup()
                        .addGap(534, 534, 534)
                        .addComponent(lblAllRequest3))
                    .addGroup(panelAllRequest1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1431, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAllRequest1Layout.setVerticalGroup(
            panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAllRequest1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAllRequest4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAllRequest1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblAllRequest3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhoneNum2)
                            .addComponent(txtPhoneNum2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(panelAllRequest1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProvinces)
                            .addComponent(textProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAllRequest1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAllRequest1Layout.createSequentialGroup()
                                        .addComponent(lblTINNum1)
                                        .addGap(15, 15, 15))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAllRequest1Layout.createSequentialGroup()
                                        .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtSSSNum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblSSSNum1))
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTINNum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPagIbigNum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPagIbigNum1))
                                .addGap(199, 199, 199))
                            .addGroup(panelAllRequest1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textBarangay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblRiceSubsidy1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textMunicipality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPhoneAllowance1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPhoneAllowances1))
                                .addGap(18, 18, 18)
                                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblClothingAllowanes1)
                                    .addComponent(txtClothingAllowance1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelAllRequest1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPhilNum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSupervisor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSupervisor1)
                                    .addComponent(lblPhilNum1))
                                .addGap(18, 18, 18)
                                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblStatus1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboPositions, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPosition1))
                                .addGap(34, 34, 34)
                                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(154, 154, 154))
                            .addGroup(panelAllRequest1Layout.createSequentialGroup()
                                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelAllRequest1Layout.createSequentialGroup()
                                        .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(panelAllRequest1Layout.createSequentialGroup()
                                                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblEmpID7, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtID2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(28, 28, 28)
                                                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(lblFName2)
                                                    .addComponent(txtFName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(txtLName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblLName2)))
                                            .addGroup(panelAllRequest1Layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(lblZipCodes)
                                                    .addComponent(textZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAllRequest1Layout.createSequentialGroup()
                                                        .addComponent(txtRiceSubsidy1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(20, 20, 20))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAllRequest1Layout.createSequentialGroup()
                                                        .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(lblRiceSubsidy2)
                                                            .addComponent(textBasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(56, 56, 56)))))
                                        .addGap(15, 15, 15)
                                        .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblBDay2)
                                            .addComponent(jBDay2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelAllRequest1Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(lblStreet)
                                        .addGap(36, 36, 36)
                                        .addComponent(lblBarangay)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblMunicipality)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblCities)))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );

        tabbedInsideRequest1.addTab("", panelAllRequest1);

        panelAllRequest3.setBackground(new java.awt.Color(255, 255, 255));

        lblPayrollPeriod.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPayrollPeriod.setText("Payroll from ");

        jTablePayroll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTablePayroll.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTablePayroll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Payslip Number", "Employee ID", "Full Name", "Position", "Period From", "Period To", "Monthly Salary", "Daily Rate", "Days Worked", "Total Overtime", "Gross Income", "Rice Subsidy", "Phone Allowance", "Clothing Allowance", "Total Allowance", "SSS", "Pag-Ibig", "Philhealth", "Withholding Tax", "Take-home Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePayroll.setColumnSelectionAllowed(true);
        jTablePayroll.setRowHeight(25);
        jTablePayroll.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(jTablePayroll);

        jSeparator16.setBackground(new java.awt.Color(255, 204, 153));

        lblAllRequest5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        lblFrom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrom.setText("From :");

        lblTo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTo.setText("To :");

        jButton1.setText("Generate Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAllRequest3Layout = new javax.swing.GroupLayout(panelAllRequest3);
        panelAllRequest3.setLayout(panelAllRequest3Layout);
        panelAllRequest3Layout.setHorizontalGroup(
            panelAllRequest3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAllRequest3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAllRequest3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAllRequest3Layout.createSequentialGroup()
                        .addComponent(lblFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(lblTo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAllRequest5)
                        .addGap(0, 946, Short.MAX_VALUE))
                    .addComponent(jSeparator16))
                .addContainerGap())
            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelAllRequest3Layout.createSequentialGroup()
                .addGap(580, 580, 580)
                .addComponent(lblPayrollPeriod)
                .addGap(0, 796, Short.MAX_VALUE))
        );
        panelAllRequest3Layout.setVerticalGroup(
            panelAllRequest3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAllRequest3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelAllRequest3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAllRequest5)
                    .addGroup(panelAllRequest3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTo)
                        .addGroup(panelAllRequest3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelAllRequest3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblFrom)
                                .addComponent(jButton1)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(lblPayrollPeriod)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        tabbedInsideRequest1.addTab("", panelAllRequest3);

        comboAllDetails.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "View Employees", "View Payroll" }));
        comboAllDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAllDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTypeRequest1Layout = new javax.swing.GroupLayout(panelTypeRequest1);
        panelTypeRequest1.setLayout(panelTypeRequest1Layout);
        panelTypeRequest1Layout.setHorizontalGroup(
            panelTypeRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTypeRequest1Layout.createSequentialGroup()
                .addGap(720, 720, 720)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(tabbedInsideRequest1, javax.swing.GroupLayout.PREFERRED_SIZE, 1488, Short.MAX_VALUE)
            .addGroup(panelTypeRequest1Layout.createSequentialGroup()
                .addGap(558, 558, 558)
                .addComponent(comboAllDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTypeRequest1Layout.setVerticalGroup(
            panelTypeRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTypeRequest1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboAllDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedInsideRequest1, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout tabbedAllEmployeesLayout = new javax.swing.GroupLayout(tabbedAllEmployees);
        tabbedAllEmployees.setLayout(tabbedAllEmployeesLayout);
        tabbedAllEmployeesLayout.setHorizontalGroup(
            tabbedAllEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedAllEmployeesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTypeRequest1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        tabbedAllEmployeesLayout.setVerticalGroup(
            tabbedAllEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedAllEmployeesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTypeRequest1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, Short.MAX_VALUE))
        );

        mainTabbed.addTab("tab7", tabbedAllEmployees);

        panelTypeRequest2.setBackground(new java.awt.Color(255, 255, 255));
        panelTypeRequest2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ALL EMPLOYEE CREDENTIALS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 102, 0))); // NOI18N

        tabbedInsideRequest2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        panelAllRequest2.setBackground(new java.awt.Color(255, 255, 255));

        lblAllRequest2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAllRequest2.setText("ALL EMPLOYEE CREDENTIALS");

        jTableCredentials.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableCredentials.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableCredentials.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "ROLE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCredentials.setColumnSelectionAllowed(true);
        jTableCredentials.setRowHeight(25);
        jTableCredentials.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jTableCredentials);
        jTableCredentials.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jSeparator17.setBackground(new java.awt.Color(255, 204, 153));

        btnUpdate2.setText("ADD NEW CREDENTIALS");
        btnUpdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate2ActionPerformed(evt);
            }
        });

        lblCredentialID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCredentialID.setText("Employee ID : ");

        txtCredentialID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCredentialID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCredentialIDKeyTyped(evt);
            }
        });

        lblCredentialPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCredentialPassword.setText("Password :");

        txtCredentialPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCredentialPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCredentialPasswordKeyTyped(evt);
            }
        });

        lblRequestType2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRequestType2.setText("Employee Role:");

        txtCredentialRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employee", "Human Resource", "Payroll Staff", "Supervisor" }));
        txtCredentialRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCredentialRoleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAllRequest2Layout = new javax.swing.GroupLayout(panelAllRequest2);
        panelAllRequest2.setLayout(panelAllRequest2Layout);
        panelAllRequest2Layout.setHorizontalGroup(
            panelAllRequest2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAllRequest2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
            .addGroup(panelAllRequest2Layout.createSequentialGroup()
                .addGroup(panelAllRequest2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAllRequest2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnUpdate2))
                    .addGroup(panelAllRequest2Layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addComponent(lblAllRequest2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAllRequest2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 957, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAllRequest2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(panelAllRequest2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAllRequest2Layout.createSequentialGroup()
                                .addComponent(lblCredentialID)
                                .addGap(32, 32, 32)
                                .addComponent(txtCredentialID, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(lblCredentialPassword))
                            .addGroup(panelAllRequest2Layout.createSequentialGroup()
                                .addComponent(lblRequestType2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCredentialRole, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(61, 61, 61)
                        .addComponent(txtCredentialPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAllRequest2Layout.setVerticalGroup(
            panelAllRequest2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAllRequest2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblAllRequest2)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelAllRequest2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAllRequest2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCredentialPassword)
                        .addComponent(txtCredentialPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAllRequest2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCredentialID)
                        .addComponent(txtCredentialID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(panelAllRequest2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRequestType2)
                    .addComponent(txtCredentialRole, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        tabbedInsideRequest2.addTab("", panelAllRequest2);

        javax.swing.GroupLayout panelTypeRequest2Layout = new javax.swing.GroupLayout(panelTypeRequest2);
        panelTypeRequest2.setLayout(panelTypeRequest2Layout);
        panelTypeRequest2Layout.setHorizontalGroup(
            panelTypeRequest2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedInsideRequest2, javax.swing.GroupLayout.PREFERRED_SIZE, 962, Short.MAX_VALUE)
        );
        panelTypeRequest2Layout.setVerticalGroup(
            panelTypeRequest2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedInsideRequest2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout tabbedAllCredentialsLayout = new javax.swing.GroupLayout(tabbedAllCredentials);
        tabbedAllCredentials.setLayout(tabbedAllCredentialsLayout);
        tabbedAllCredentialsLayout.setHorizontalGroup(
            tabbedAllCredentialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedAllCredentialsLayout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(panelTypeRequest2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(278, Short.MAX_VALUE))
        );
        tabbedAllCredentialsLayout.setVerticalGroup(
            tabbedAllCredentialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabbedAllCredentialsLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(panelTypeRequest2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        mainTabbed.addTab("tab8", tabbedAllCredentials);

        jPanel1.add(mainTabbed, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 1510, 800));

        jScrollPane7.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1740, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate2ActionPerformed
        // TODO add your handling code here:
        ArrayList<String> tempData = new ArrayList<>();     //Creating new ArrayList
        if(!txtCredentialID.getText().isEmpty() && !txtCredentialPassword.getText().isEmpty()       //Validating all fields if it is not empty
                && !txtCredentialRole.getSelectedItem().toString().isEmpty()){
            tempData.add(txtCredentialID.getText());                                                //Adding credential ID value to ArrayList
            tempData.add(txtCredentialPassword.getText());                                          //Adding password value to ArrayList
            tempData.add(txtCredentialRole.getSelectedItem().toString());                           //Adding crednetial access to ArrayList
        if(humanResource.addNewCredentials(tempData)){                                              //Calling the methods to add new credentials
            humanResource.setTableData(humanResource.retrievedAllCredentials());                    //Calling methods to retrieved all credentials 
            humanResource.setTableSize(3);
            humanResource.displayDataTable(jTableCredentials);                                      //Display all credentials to the table
            txtCredentialID.setText("");
            txtCredentialPassword.setText("");
            txtCredentialRole.setSelectedIndex(0);
        }
        }else{
            JOptionPane.showMessageDialog(null, "Please Provide all Necessary Information!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdate2ActionPerformed

    private void btnAllCredentialsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllCredentialsActionPerformed
        // TODO add your handling code here:
        mainTabbed.setSelectedIndex(7);
        humanResource.setTableData(humanResource.retrievedAllCredentials());
        humanResource.setTableSize(3);
        humanResource.displayDataTable(jTableCredentials);    
    }//GEN-LAST:event_btnAllCredentialsActionPerformed

    private void btnAllEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllEmployeesActionPerformed
        // TODO add your handling code here
        emptyFieldsEmployeeDetails();
        btnAdd.setEnabled(true);
        btnUpdate.setEnabled(false);
        if(comboAllDetails.getSelectedItem().equals("View Employees")){
            tabbedInsideRequest1.setSelectedIndex(0);
            txtID2.setText(humanResource.nextEmployeeID().get(0).get(0)); //Current employee_id + 1; 
        
            mainTabbed.setSelectedIndex(6);
            humanResource.setTableData(humanResource.displayAllDetails());
            humanResource.setTableSize(22);
            humanResource.displayDataTable(jTableEmployees);

            if(comboStatus.getItemCount() == 0){
                    humanResource.retrievedEmploymentStatus("status").forEach(row -> {
                       for (String item : row) {
                           comboStatus.addItem(item);  // Add each element of the 2D ArrayList
                       }
                    });
            }

            if(comboPositions.getItemCount() == 0){
                    humanResource.retrievedEmploymentStatus("position").forEach(row -> {
                       for (String item : row) {
                           comboPositions.addItem(item);  // Add each element of the 2D ArrayList
                       }
                    });
            }
        }else{
            tabbedInsideRequest1.setSelectedIndex(1);
        }
        
    }//GEN-LAST:event_btnAllEmployeesActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        employee.userLogin();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        employee.userLogout();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnPersonalDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalDetailsActionPerformed
        // TODO add your handling code here:
        mainTabbed.setSelectedIndex(1);
        txtID.setText(employee.getEmployee_id());
        txtFName.setText(employee.getFirstName());
        txtLName.setText(employee.getLastName());
        txtBDay.setText(employee.getBirthday());
        txtPhoneNum.setText(employee.getPhoneNumber());
        textAreaStreet.setText(employee.getStreet());
        txtBrgy.setText(employee.getBarangay());
        txtCity.setText(employee.getCity());
        txtProvince.setText(employee.getProvince());
        txtZipCode.setText(employee.getZipCode());
        txtBasicSalary.setText(String.valueOf(employee.getBasicSalary()));
        txtBiMonthlyRate.setText(String.valueOf(employee.getSemiBasicSalary()));
        txtHourlyRate.setText(String.valueOf(employee.getHourlyRate()));
        txtRiceSubsidy.setText(String.valueOf(employee.getRiceSubsidy()));
        txtPhoneAllowance.setText(String.valueOf(employee.getRiceSubsidy()));
        txtClothingAllowance.setText(String.valueOf(employee.getClothingAllowance()));
        txtPhilNum.setText(employee.getPhilHealthNumber());
        txtSSSNum.setText(employee.getSssNumber());
        txtTINNum.setText(employee.getTinNumber());
        txtPagIbigNum.setText(employee.getPagibigNumber());
        txtPosition.setText(employee.getPosition());
        txtStatus.setText(employee.getStatus());
        txtSupervisor.setText(employee.getSupervisor());
    }//GEN-LAST:event_btnPersonalDetailsActionPerformed

    private void btnRequestPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestPortActionPerformed
        // TODO add your handling code here:.
        mainTabbed.setSelectedIndex(2);

        // Set the combo box to "All Request" (index 0) and display the "All Request" panel
        comboTypeRequest.setSelectedIndex(0);
        tabbedInsideRequest.setSelectedIndex(0);

        // Display all requests in the table
        employee.setTableData(employee.getDataAllRequests());
        employee.setTableSize(7);
        employee.displayDataTable(jTableAllRequest);
        
    }//GEN-LAST:event_btnRequestPortActionPerformed

    private void btnDTRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDTRActionPerformed
        // TODO add your handling code here:
        mainTabbed.setSelectedIndex(3);

        // Set employee details in the DTR panel
        employee.viewPersonalDetails();
        lblID2.setText(employee.getEmployee_id());
        lblMyName4.setText(employee.getEmployeeCompleteName());

        // Get current date
        Calendar today = Calendar.getInstance();
        int currentDay = today.get(Calendar.DAY_OF_MONTH);

        // Set up date range based on current period (1-15 or 16-end of month)
        Calendar startCal = Calendar.getInstance();
        Calendar endCal = Calendar.getInstance();

        // First half of the month (1-31)
        startCal.set(Calendar.DAY_OF_MONTH, 1);
        endCal.set(Calendar.DAY_OF_MONTH, endCal.getActualMaximum(Calendar.DAY_OF_MONTH));
        
        // Set the date fields to show the current period
        dateFrom2.setDate(startCal.getTime());
        dateTo2.setDate(endCal.getTime());

       // Set the date fields to show the current period
        dateFrom2.setDate(startCal.getTime());
        dateTo2.setDate(endCal.getTime());

        // Load and display the attendance records for the current period
        employee.setTableData(employee.getDTR(startCal.getTime(), endCal.getTime()));
        employee.setTableSize(4);
        employee.displayDataTable(jTableAllDTR);
    }//GEN-LAST:event_btnDTRActionPerformed

    private void btnLeaveLedgerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaveLedgerActionPerformed
        // TODO add your handling code here:
        mainTabbed.setSelectedIndex(4);

        employee.leaveBalancesInformation();
        lblID3.setText(employee.getEmployee_id());
        lblMyName5.setText(employee.getEmployeeCompleteName());
        lblVLBalance1.setText(employee.accountDetails.getVLBalance());
        lblSLBalance1.setText(employee.accountDetails.getSLBalance());

        employee.setTableData(employee.viewPersonalLeaveLedger());
        employee.setTableSize(7);
        employee.displayDataTable(jTableAllRequest3);
  
    }//GEN-LAST:event_btnLeaveLedgerActionPerformed

    private void btnLeaveLedger1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaveLedger1ActionPerformed
        // TODO add your handling code here:
        mainTabbed.setSelectedIndex(5);
    }//GEN-LAST:event_btnLeaveLedger1ActionPerformed

    private void txtBasicSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBasicSalaryActionPerformed

    }//GEN-LAST:event_txtBasicSalaryActionPerformed

    private void txtRiceSubsidyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRiceSubsidyActionPerformed

    }//GEN-LAST:event_txtRiceSubsidyActionPerformed

    private void txtPhoneAllowanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneAllowanceActionPerformed

    }//GEN-LAST:event_txtPhoneAllowanceActionPerformed

    private void txtClothingAllowanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClothingAllowanceActionPerformed

    }//GEN-LAST:event_txtClothingAllowanceActionPerformed

    private void txtPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPositionActionPerformed

    private void txtSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupervisorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupervisorActionPerformed

    private void comboTypeRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTypeRequestActionPerformed
        // TODO add your handling code here:
       String selectedItem = comboTypeRequest.getSelectedItem().toString();

        if(selectedItem.equals("All Request")) {
            tabbedInsideRequest.setSelectedIndex(0);
            // Display all requests in the table
            employee.setTableData(employee.getDataAllRequests());
            employee.setTableSize(7);
            employee.displayDataTable(jTableAllRequest);

        } else if(selectedItem.equals("Leave Application")) {
            tabbedInsideRequest.setSelectedIndex(1);

            employee.leaveBalancesInformation();
            lblID.setText(employee.getEmployee_id());
            lblMyName.setText(employee.getEmployeeCompleteName());
            lblVLBalance.setText(employee.accountDetails.getVLBalance());
            lblSLBalance.setText(employee.accountDetails.getSLBalance());

        } else {
            tabbedInsideRequest.setSelectedIndex(2);
            lblID1.setText(employee.getEmployee_id());
            lblMyName2.setText(employee.getEmployeeCompleteName());
            // Display all requests in the table
            employee.setTableData(employee.getDataAllRequests());
            employee.setTableSize(7);
            employee.displayDataTable(jTableAllRequest);
        }
        
    }//GEN-LAST:event_comboTypeRequestActionPerformed

    private void dateToPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateToPropertyChange
        // TODO add your handling code here:
        if(dateFrom.getDate() != null && dateTo.getDate() != null){
            if(humanResource.countNumberOfDays(dateFrom.getDate(), dateTo.getDate())){
                txtDaysNumber.setText(String.valueOf(humanResource.getNumberOfDaysLeave()));
                humanResource.setNumberOfDaysLeave();
            }else{
                humanResource.setNumberOfDaysLeave();
                txtDaysNumber.setText(String.valueOf(humanResource.getNumberOfDaysLeave()));
            }
        }
    }//GEN-LAST:event_dateToPropertyChange

    private void dateFromPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateFromPropertyChange
        // TODO add your handling code here:
        if(dateTo.getDate() != null && dateFrom.getDate() != null){
            if(humanResource.countNumberOfDays(dateFrom.getDate(), dateTo.getDate())){
                txtDaysNumber.setText(String.valueOf(humanResource.getNumberOfDaysLeave()));
                humanResource.setNumberOfDaysLeave();
            }else{
                humanResource.setNumberOfDaysLeave();
                txtDaysNumber.setText(String.valueOf(humanResource.getNumberOfDaysLeave()));
            }
        }
    }//GEN-LAST:event_dateFromPropertyChange

    private void txtDaysNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDaysNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDaysNumberActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        
         if (comboLeaveType.getSelectedIndex() == 0 || dateFrom.getDate() == null || dateTo.getDate() == null || txtReason.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please provide all the necessary details for filing of Leave Request!");
            return;
        }else if(txtDaysNumber.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "Error date of leave!");
            return;
        }
        if(employee.fileLeaveRequest(dateFrom.getDate(), dateTo.getDate(), comboLeaveType.getSelectedItem().toString(),
                Integer.parseInt(txtDaysNumber.getText()), txtReason.getText())){
            txtDaysNumber.setText(null);
            comboLeaveType.setSelectedIndex(0);
            dateFrom.setDate(null);
            dateTo.setDate(null);
            txtReason.setText(null);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void dateFromOvertimePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateFromOvertimePropertyChange
        // TODO add your handling code here:
        if(dateToOvertime.getDate() != null && dateFromOvertime.getDate() != null){
            if(humanResource.countNumberOfDays(dateFromOvertime.getDate(), dateToOvertime.getDate())){
                txtDaysNumber1.setText(String.valueOf(humanResource.getNumberOfDaysLeave()));
                humanResource.setNumberOfDaysLeave();
            }else{
                humanResource.setNumberOfDaysLeave();
                txtDaysNumber1.setText(String.valueOf(humanResource.getNumberOfDaysLeave()));
            }
        }
    }//GEN-LAST:event_dateFromOvertimePropertyChange

    private void dateToOvertimePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateToOvertimePropertyChange
        // TODO add your handling code here:
        if(dateFromOvertime.getDate() != null && dateToOvertime.getDate() != null){
            if(humanResource.countNumberOfDays(dateFromOvertime.getDate(), dateToOvertime.getDate())){
                txtDaysNumber1.setText(String.valueOf(humanResource.getNumberOfDaysLeave()));
                humanResource.setNumberOfDaysLeave();
            }else{
                humanResource.setNumberOfDaysLeave();
                txtDaysNumber1.setText(String.valueOf(humanResource.getNumberOfDaysLeave()));
            }
        }
    }//GEN-LAST:event_dateToOvertimePropertyChange

    private void btnSubmit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmit1ActionPerformed
        // TODO add your handling code here:      
          if(dateToOvertime.getDate() != null && dateFromOvertime.getDate() != null && !txtReasonOvertime.getText().trim().isEmpty()){
             if(employee.countNumberOfDays(dateFromOvertime.getDate(), dateToOvertime.getDate())){
                 Boolean isSuccessfulyAdded = employee.fileOvertimeRequest(
                         dateFromOvertime.getDate(),
                         dateToOvertime.getDate(),
                         Integer.parseInt(txtDaysNumber1.getText()),
                         txtReasonOvertime.getText()
                 );
                 if(isSuccessfulyAdded){
                     dateFromOvertime.setDate(null);
                     dateToOvertime.setDate(null);
                     txtDaysNumber1.setText(null);
                     txtReasonOvertime.setText(null);
                     employee.setNumberOfDaysLeave();
                 }
             } 
        } else{
           JOptionPane.showMessageDialog(null, "Provide all the neccessary details for overtime!!");
        }
          
    }//GEN-LAST:event_btnSubmit1ActionPerformed

    private void txtDaysNumber1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDaysNumber1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDaysNumber1ActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        employee.setTableData(employee.getDTR(dateFrom2.getDate(), dateTo2.getDate()));
        employee.setTableSize(4);
        employee.displayDataTable(jTableAllDTR);
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtCredentialIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCredentialIDKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCredentialIDKeyTyped

    private void txtCredentialPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCredentialPasswordKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCredentialPasswordKeyTyped

    private void txtCredentialRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCredentialRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCredentialRoleActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Logout This Account?", "Confirm", JOptionPane.YES_NO_OPTION);
        if(choice == 0){
            JOptionPane.showMessageDialog(null, "Successfuly Logout Account!");
            dispose();
            LoginGUI login = new LoginGUI();
            login.setVisible(true);
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
            if(humanResource.addEmployeeDetails(employeDetails())){
                humanResource.setTableData(humanResource.displayAllDetails());
                humanResource.setTableSize(21);
                humanResource.displayDataTable(jTableEmployees);
                
                emptyFieldsEmployeeDetails();
            }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtFName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFName2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFName2ActionPerformed

    private void txtFName2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFName2KeyTyped
        // TODO add your handling code here:
        commaConstraints(evt);   //To call method for comma constraints
    }//GEN-LAST:event_txtFName2KeyTyped

    private void txtLName2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLName2KeyTyped
        // TODO add your handling code here:
        commaConstraints(evt);   //To call method for comma constraints
    }//GEN-LAST:event_txtLName2KeyTyped

    private void txtPhoneNum2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneNum2KeyTyped
        // TODO add your handling code here:
        letterDashConstraints(evt);   //To call method for comma constraints
    }//GEN-LAST:event_txtPhoneNum2KeyTyped

    private void textStreetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textStreetKeyTyped
        // TODO add your handling code here:
        commaConstraints(evt);   //To call method for comma constraints
    }//GEN-LAST:event_textStreetKeyTyped

    private void txtPhilNum1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhilNum1KeyTyped
        // TODO add your handling code here:
        numberOnly(evt);   //To call method for comma constraints
    }//GEN-LAST:event_txtPhilNum1KeyTyped

    private void txtSSSNum1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSSSNum1KeyTyped
        // TODO add your handling code here:
        letterDashConstraints(evt);   //To call method for comma constraints
    }//GEN-LAST:event_txtSSSNum1KeyTyped

    private void txtTINNum1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTINNum1KeyTyped
        // TODO add your handling code here:
        letterDashConstraints(evt);   //To call method for comma constraints
    }//GEN-LAST:event_txtTINNum1KeyTyped

    private void txtPagIbigNum1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagIbigNum1KeyTyped
        // TODO add your handling code here:
        numberOnly(evt);   //To call method for comma constraints
    }//GEN-LAST:event_txtPagIbigNum1KeyTyped

    private void textCityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCityKeyTyped
        // TODO add your handling code here:
        commaConstraints(evt);   //To call method for comma constraints
    }//GEN-LAST:event_textCityKeyTyped

    private void textZipCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textZipCodeKeyTyped
        // TODO add your handling code here:
        commaConstraints(evt);   //To call method for comma constraints
    }//GEN-LAST:event_textZipCodeKeyTyped

    private void txtRiceSubsidy1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRiceSubsidy1KeyTyped
        // TODO add your handling code here:
        numberDotOnly(evt);   //To call method for comma constraints
    }//GEN-LAST:event_txtRiceSubsidy1KeyTyped

    private void txtPhoneAllowance1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneAllowance1KeyTyped
        // TODO add your handling code here:
        numberDotOnly(evt);   //To call method for comma constraints
    }//GEN-LAST:event_txtPhoneAllowance1KeyTyped

    private void txtClothingAllowance1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClothingAllowance1KeyTyped
        // TODO add your handling code here:
        numberDotOnly(evt);   //To call method for comma constraints
    }//GEN-LAST:event_txtClothingAllowance1KeyTyped

    private void txtSupervisor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupervisor1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSupervisor1ActionPerformed

    private void txtSupervisor1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSupervisor1KeyTyped
        // TODO add your handling code here:
        commaConstraints(evt);   //To call method for comma constraints
    }//GEN-LAST:event_txtSupervisor1KeyTyped

    private void jBDay2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jBDay2PropertyChange
        // TODO add your handling code here:
        if(jBDay2.getDate() != null)
        if(!humanResource.validateDateBirthday(jBDay2.getDate())){
            JOptionPane.showMessageDialog(null, "You must be 18 years old to proceed.");
            jBDay2.setDate(null);
        }
    }//GEN-LAST:event_jBDay2PropertyChange

    private void textProvinceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textProvinceKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_textProvinceKeyTyped

    private void txtSSSNum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSSSNum1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSSSNum1ActionPerformed

    private void textBarangayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBarangayKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_textBarangayKeyTyped

    private void textMunicipalityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMunicipalityKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_textMunicipalityKeyTyped

    private void textBasicSalaryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBasicSalaryKeyTyped
        // TODO add your handling code here:
        numberDotOnly(evt);   
    }//GEN-LAST:event_textBasicSalaryKeyTyped

    private void comboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStatusActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_comboStatusActionPerformed

    private void comboPositionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPositionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPositionsActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        // TODO add your handling code here:
        if(employee.downloadPayslip(dateFrom3.getDate(), dateTo3.getDate())){
            dateFrom3.setDate(null);
            dateTo3.setDate(null);
        }
    }//GEN-LAST:event_btnReportActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        humanResource.setTableSize(14);
        humanResource.displayDataTable(jTablePayroll);

        if (!(jDateTo.getDate().after(jDateFrom.getDate()))){
            JOptionPane.showMessageDialog(null, "Error: Invalid date!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            String startFormatted = new SimpleDateFormat("MMM d").format(jDateFrom.getDate());
            String endFormatted = new SimpleDateFormat("d").format(jDateTo.getDate());
            String dateRange = startFormatted + "-" + endFormatted + ", 2024";    
            lblPayrollPeriod.setText("Payroll from "+dateRange);
            
            DefaultTableModel model = (DefaultTableModel)jTablePayroll.getModel();
            model.setRowCount(0);
            for(Object[] item : getPayrollData()){
                model.addRow(item);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private ArrayList<Object[]> getPayrollData(){
        PayrollStaff payrollStaff = new PayrollStaff();
        ArrayList<Object[]> payrollData = new ArrayList<Object[]>();
        ArrayList<ArrayList<String>> employeeWithAttendance = payrollStaff.getEmployeeWithAttendance(jDateFrom.getDate(), jDateTo.getDate());
        PdfGenerator generator = new PdfGenerator();
     
        for (int i = 0; i < employeeWithAttendance.size(); i++){
            payrollData.add(generator.readEmployeeDetailsFromDB(employeeWithAttendance.get(i).get(0), jDateFrom.getDate(), jDateTo.getDate()));
        }
        return payrollData;
    }
 
    private void comboAllDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAllDetailsActionPerformed
        // TODO add your handling code here:
        if(comboAllDetails.getSelectedItem().equals("View Employees")){
            tabbedInsideRequest1.setSelectedIndex(0);
        }else{
            tabbedInsideRequest1.setSelectedIndex(1);
        }
        
    }//GEN-LAST:event_comboAllDetailsActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if(humanResource.updateEmployeeDetails(employeDetails())){
                humanResource.setTableData(humanResource.displayAllDetails());
                humanResource.setTableSize(22);
                humanResource.displayDataTable(jTableEmployees);
                
                emptyFieldsEmployeeDetails();
            }
        btnAdd.setEnabled(true);
        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jTableEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmployeesMouseClicked
        // TODO add your handling code here:
        btnAdd.setEnabled(false);
        btnUpdate.setEnabled(true);
        int selectedRow = jTableEmployees.getSelectedRow();

        if (selectedRow != -1) {
            String [] data = new String[22];
            int columnCount = jTableEmployees.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                 Object cellValue = jTableEmployees.getValueAt(selectedRow, i);
                 data[i] = (cellValue != null) ? cellValue.toString() : "";
            }
            txtID2.setText(data[0]);
            txtFName2.setText(data[2]);
            txtLName2.setText(data[1]);
            try {
                jBDay2.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(data[3]));
            } catch (ParseException ex) {
                Logger.getLogger(HumanResourceGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtPhoneNum2.setText(data[10]);
            textStreet.setText(data[4]);
            textBarangay.setText(data[5]);
            textMunicipality.setText(data[6]);
            textCity.setText(data[7]);
            textProvince.setText(data[8]);
            textZipCode.setText(data[9]);
            textBasicSalary.setText(data[18]);
            txtRiceSubsidy1.setText(data[19]);
            txtPhoneAllowance1.setText(data[20]);
            txtClothingAllowance1.setText(data[21]);
            txtSSSNum1.setText(data[11]);
            txtPhilNum1.setText(data[12]);
            txtTINNum1.setText(data[13]);
            txtPagIbigNum1.setText(data[14]);
            comboPositions.setSelectedItem(data[16]);
            comboStatus.setSelectedItem(data[15]);
            txtSupervisor1.setText(data[17]);
            
        }
    }//GEN-LAST:event_jTableEmployeesMouseClicked

    private void setClockText(){ //code for realtime date & time updates to the dashboard
        Timer timer = new Timer(1000, new ActionListener(){ //timer updates every second (1000 milliseconds)
            @Override
            public void actionPerformed(ActionEvent e) {
                txtClock.setText("<html>" + DateFormat.getTimeInstance(DateFormat.SHORT).format(new Date()) + "<br/>" + DateFormat.getDateInstance().format(new Date()) + "</html>");
                // added <html> and <br> tags to line break between the time and date texts
            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
        timer.start();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HumanResourceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HumanResourceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HumanResourceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HumanResourceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true); // Control 4: portals open only through login
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAllCredentials;
    private javax.swing.JButton btnAllEmployees;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDTR;
    private javax.swing.JButton btnLeaveLedger;
    private javax.swing.JButton btnLeaveLedger1;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPersonalDetails;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnRequestPort;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnSubmit1;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdate2;
    private javax.swing.JComboBox<String> comboAllDetails;
    private javax.swing.JComboBox<String> comboLeaveType;
    private javax.swing.JComboBox<String> comboPositions;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JComboBox<String> comboTypeRequest;
    private com.toedter.calendar.JDateChooser dateFrom;
    private com.toedter.calendar.JDateChooser dateFrom2;
    private com.toedter.calendar.JDateChooser dateFrom3;
    private com.toedter.calendar.JDateChooser dateFromOvertime;
    private com.toedter.calendar.JDateChooser dateTo;
    private com.toedter.calendar.JDateChooser dateTo2;
    private com.toedter.calendar.JDateChooser dateTo3;
    private com.toedter.calendar.JDateChooser dateToOvertime;
    private com.toedter.calendar.JDateChooser jBDay2;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateFrom;
    private com.toedter.calendar.JDateChooser jDateTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTableAllDTR;
    private javax.swing.JTable jTableAllRequest;
    private javax.swing.JTable jTableAllRequest3;
    private javax.swing.JTable jTableCredentials;
    private javax.swing.JTable jTableEmployees;
    private javax.swing.JTable jTablePayroll;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAllRequest;
    private javax.swing.JLabel lblAllRequest2;
    private javax.swing.JLabel lblAllRequest3;
    private javax.swing.JLabel lblAllRequest4;
    private javax.swing.JLabel lblAllRequest5;
    private javax.swing.JLabel lblBDay;
    private javax.swing.JLabel lblBDay2;
    private javax.swing.JLabel lblBarangay;
    private javax.swing.JLabel lblBasicSalary;
    private javax.swing.JLabel lblBiMonthlyRate;
    private javax.swing.JLabel lblBrgy;
    private javax.swing.JLabel lblCities;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblClothingAllowanes;
    private javax.swing.JLabel lblClothingAllowanes1;
    private javax.swing.JLabel lblCredentialID;
    private javax.swing.JLabel lblCredentialPassword;
    private javax.swing.JLabel lblEmpID;
    private javax.swing.JLabel lblEmpID1;
    private javax.swing.JLabel lblEmpID2;
    private javax.swing.JLabel lblEmpID3;
    private javax.swing.JLabel lblEmpID4;
    private javax.swing.JLabel lblEmpID7;
    private javax.swing.JLabel lblFName;
    private javax.swing.JLabel lblFName2;
    private javax.swing.JLabel lblFrom;
    private javax.swing.JLabel lblHourlyRate;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblID1;
    private javax.swing.JLabel lblID2;
    private javax.swing.JLabel lblID3;
    private javax.swing.JLabel lblIDSidebar;
    private javax.swing.JLabel lblLName;
    private javax.swing.JLabel lblLName2;
    private javax.swing.JLabel lblLeaveBalances;
    private javax.swing.JLabel lblLeaveBalances1;
    private javax.swing.JLabel lblLeaveBalances2;
    private javax.swing.JLabel lblMunicipality;
    private javax.swing.JLabel lblMyName;
    private javax.swing.JLabel lblMyName1;
    private javax.swing.JLabel lblMyName2;
    private javax.swing.JLabel lblMyName3;
    private javax.swing.JLabel lblMyName4;
    private javax.swing.JLabel lblMyName5;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblName2;
    private javax.swing.JLabel lblName3;
    private javax.swing.JLabel lblName5;
    private javax.swing.JLabel lblNameSidebar;
    private javax.swing.JLabel lblPagIbigNum;
    private javax.swing.JLabel lblPagIbigNum1;
    private javax.swing.JLabel lblPayrollPeriod;
    private javax.swing.JLabel lblPeriod;
    private javax.swing.JLabel lblPhilNum;
    private javax.swing.JLabel lblPhilNum1;
    private javax.swing.JLabel lblPhoneAllowances;
    private javax.swing.JLabel lblPhoneAllowances1;
    private javax.swing.JLabel lblPhoneNum;
    private javax.swing.JLabel lblPhoneNum2;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblPosition1;
    private javax.swing.JLabel lblProvince;
    private javax.swing.JLabel lblProvinces;
    private javax.swing.JLabel lblRequestType;
    private javax.swing.JLabel lblRequestType2;
    private javax.swing.JLabel lblRiceSubsidy;
    private javax.swing.JLabel lblRiceSubsidy1;
    private javax.swing.JLabel lblRiceSubsidy2;
    private javax.swing.JLabel lblSL;
    private javax.swing.JLabel lblSL1;
    private javax.swing.JLabel lblSLBalance;
    private javax.swing.JLabel lblSLBalance1;
    private javax.swing.JLabel lblSSSNum;
    private javax.swing.JLabel lblSSSNum1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatus1;
    private javax.swing.JLabel lblStreet;
    private javax.swing.JLabel lblSupervisor;
    private javax.swing.JLabel lblSupervisor1;
    private javax.swing.JLabel lblTINNum;
    private javax.swing.JLabel lblTINNum1;
    private javax.swing.JLabel lblTo;
    private javax.swing.JLabel lblVL;
    private javax.swing.JLabel lblVL1;
    private javax.swing.JLabel lblVLBalance;
    private javax.swing.JLabel lblVLBalance1;
    private javax.swing.JLabel lblZipCode;
    private javax.swing.JLabel lblZipCodes;
    private javax.swing.JTabbedPane mainTabbed;
    private javax.swing.JPanel panelAllRequest;
    private javax.swing.JPanel panelAllRequest1;
    private javax.swing.JPanel panelAllRequest2;
    private javax.swing.JPanel panelAllRequest3;
    private javax.swing.JPanel panelDTR;
    private javax.swing.JPanel panelLeaveLedger;
    private javax.swing.JPanel panelLeaveRequestDetails;
    private javax.swing.JPanel panelMotorPH;
    private javax.swing.JPanel panelOvertimeRequest;
    private javax.swing.JPanel panelPayslip;
    private javax.swing.JPanel panelPersonalDetails;
    private javax.swing.JPanel panelPersonalDetails1;
    private javax.swing.JPanel panelPersonalDetails2;
    private javax.swing.JPanel panelPersonalDetails3;
    private javax.swing.JPanel panelTypeRequest;
    private javax.swing.JPanel panelTypeRequest1;
    private javax.swing.JPanel panelTypeRequest2;
    private javax.swing.JPanel sideBarPanel;
    private javax.swing.JPanel tabbedAllCredentials;
    private javax.swing.JPanel tabbedAllEmployees;
    private javax.swing.JPanel tabbedDTR;
    private javax.swing.JTabbedPane tabbedInsideRequest;
    private javax.swing.JTabbedPane tabbedInsideRequest1;
    private javax.swing.JTabbedPane tabbedInsideRequest2;
    private javax.swing.JPanel tabbedLeaveLedger;
    private javax.swing.JPanel tabbedPayslip;
    private javax.swing.JPanel tabbedPersonalDetails;
    private javax.swing.JPanel tabbedRequest;
    private javax.swing.JScrollPane tableDTR;
    private javax.swing.JScrollPane tableDTR1;
    private javax.swing.JTextArea textAreaStreet;
    private javax.swing.JTextField textBarangay;
    private javax.swing.JTextField textBasicSalary;
    private javax.swing.JTextField textCity;
    private javax.swing.JTextField textMunicipality;
    private javax.swing.JTextField textProvince;
    private javax.swing.JTextArea textStreet;
    private javax.swing.JTextField textZipCode;
    private javax.swing.JTextField txtBDay;
    private javax.swing.JTextField txtBasicSalary;
    private javax.swing.JTextField txtBiMonthlyRate;
    private javax.swing.JTextField txtBrgy;
    private javax.swing.JTextField txtCity;
    private javax.swing.JLabel txtClock;
    private javax.swing.JTextField txtClothingAllowance;
    private javax.swing.JTextField txtClothingAllowance1;
    private javax.swing.JTextField txtCredentialID;
    private javax.swing.JTextField txtCredentialPassword;
    private javax.swing.JComboBox<String> txtCredentialRole;
    private javax.swing.JTextField txtDaysNumber;
    private javax.swing.JTextField txtDaysNumber1;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtFName2;
    private javax.swing.JTextField txtHourlyRate;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtID2;
    private javax.swing.JTextField txtLName;
    private javax.swing.JTextField txtLName2;
    private javax.swing.JTextField txtPagIbigNum;
    private javax.swing.JTextField txtPagIbigNum1;
    private javax.swing.JTextField txtPhilNum;
    private javax.swing.JTextField txtPhilNum1;
    private javax.swing.JTextField txtPhoneAllowance;
    private javax.swing.JTextField txtPhoneAllowance1;
    private javax.swing.JTextField txtPhoneNum;
    private javax.swing.JTextField txtPhoneNum2;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtProvince;
    private javax.swing.JTextArea txtReason;
    private javax.swing.JTextArea txtReasonOvertime;
    private javax.swing.JTextField txtRiceSubsidy;
    private javax.swing.JTextField txtRiceSubsidy1;
    private javax.swing.JTextField txtSSSNum;
    private javax.swing.JTextField txtSSSNum1;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtSupervisor;
    private javax.swing.JTextField txtSupervisor1;
    private javax.swing.JTextField txtTINNum;
    private javax.swing.JTextField txtTINNum1;
    private javax.swing.JTextField txtZipCode;
    // End of variables declaration//GEN-END:variables
}
