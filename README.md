# MotorPH Payroll System

The MotorPH Payroll System is a database-driven payroll and HR solution designed to streamline and automate employee compensation, attendance tracking, and statutory deduction processes. This system replaces the legacy flat-file (CSV-based) structure with a scalable MySQL-integrated architecture, significantly improving accuracy, data accessibility, and workflow efficiency.

---

## 📌 Project Overview

### This expanded MotorPH Payroll System handles the following key functions:
- **Centralized Payroll Processing**
Automates salary computation based on daily time records (DTR), approved leaves, overtime, and statutory deductions (SSS, PhilHealth, Pag-IBIG, tax).
- **Role-Based User Access**
Secure login for four main user roles—Employees, Supervisors, HR Personnel, and Payroll Staff—each with tailored functionality.
- **Leave and Overtime Management**
Employees can file leave or overtime requests, which supervisors can approve or reject.
- **Dynamic Report Generation**
Generates real-time payslips, payroll summaries, and statutory reports in downloadable PDF format using JasperReports.
- **Attendance Tracking**
Daily logs, DTR submission, and approval workflows integrated into user dashboards.

---

## 🔐 Security Controls (MO-IT153 IAS 2, Group 18)

Branch `dev-security-controls` adds two controls from the IAS 1 design:
- **Control 1: BCrypt password hashing.** jBCrypt 1.0.2, work factor 12, 72-byte limit, forced password change at first login, one password rule set (`PasswordPolicy`) used everywhere.
- **Control 4: RBAC enforced per action.** `AccessControl.require(...)` on every sensitive backend method, `requireSelf(...)` on self-service records, default deny, and denials logged.

Documentation:
- [Database migrations](docs/database-migrations.md): V1/V2 scripts, password migration, verify and rollback
- [Cross-platform fixes](docs/cross-platform-fixes.md): Windows to macOS issues and fixes
- [Security logging and session management](docs/security-logging-and-session.md)
- [Test evidence](docs/test-evidence.md): authorization bypass, SQL injection, password truncation, database integrity
- Test runners (NetBeans: Test Packages → payrollsystem): `test/payrollsystem/RbacCheck.java`, `PasswordPolicyCheck.java`, `StressCheck.java` (right-click, then Run File)

Requires JDK 23+ with `--enable-preview` (set in the project) or JDK 25+.

---

## 💻 Installation

### System Requirements
#### Hardware:
- A computer or laptop with reliable internet connectivity.
- For optimal performance, a device with at least 2GB of RAM is recommended.
- A stable network connection for multi-user environments.

#### Software
- Java Runtime Environment (JRE) version 8 or higher.
- MySQL Server and MySQL Workbench version 8.0.
- The system works across modern operating systems including Windows, macOS, and Linux. No specific browser is required as this is a standalone application.

#### Network
- For multi-user environments, a stable connection to the company network is required. Standard network bandwidth is sufficient for normal operation.

---

## ⚙️ Accessing the System

### Initial Setup

1) **Verify Java Installation**
Ensure that **Java Runtime Environment (JRE) 8 or higher** is installed on your  computer.
To check, open **Command Prompt or Terminal** and type: java -version.
If Java is not installed, download it from java.com and follow the installation instructions.

2) **Ensure MySQL Server is Running**
- Make sure the **MySQL Server** is running in the background.
- To check the status of  MySQL server is using the MySQL client to connect, or verifying running processes.

3) **Verify MySQL Workbench Installation**
- Ensure that MySQL Workbench 8 is installed on your computer.

4) **Download Application Files**
- Go to the GitHub repository of the MotorPH Payroll System.
- Navigate to the AOOP branch and download the files.
- Extract the files to a destination folder with a simple path (avoid using folders with special characters).

5) **Configuring Database Connection in DatabaseConnection.java**
- Before launching the MotorPH Payroll System, you need to configure the connection to your MySQL database by updating the URL, username, and password in the DatabaseConnection.java file. Follow these steps to set up the connection:

**5.1 Locate the DatabaseConnection.java File**
- Navigate to the extracted project folder.
- Inside the folder, locate the DatabaseConnection.java file under the Payrollsystem directory.

**5.2 Open DatabaseConnection.java**
- Open the DatabaseConnection.java file in your preferred code editor (e.g., NetBeans, IntelliJ, Visual Studio Code).

**5.3 Edit Database Connection Details**
- In the DatabaseConnection.java file, you will find a section of code where the URL, username, and password are defined. Update these with your MySQL database credentials.

**Find the following code:**
String url = "jdbc:mysql://localhost:3306/motorph_db";  // URL to connect to the database
String username = "root";  // Your MySQL username
String password = "password123";  // Your MySQL password

**Update the values as follows:**
URL: Replace "localhost:3306/motorph_db" with the correct database host and name. If your MySQL server is on a remote machine, replace localhost with the server's IP address or domain name. Ensure the port number is correct (default is 3306).
String url = "jdbc:mysql://<your-database-host>:<port>/<your-database-name>";

**Example:**
String url = "jdbc:mysql://192.168.1.10:3306/motorph_db";
Username: Replace "root" with the username you use to access the MySQL database. Typically, the default username is root, but it may vary based on your setup.
String username = "<your-username>";
Password: Replace "password123" with the password associated with the username you are using to connect to the MySQL database.
String password = "<your-password>";

**5.4 Save the Changes**
- After making the necessary changes to the URL, username, and password, save the DatabaseConnection.java file.

**5.5 Test the Connection**
- After configuring the credentials, run the application or test the connection to verify that the system can successfully connect to the MySQL database with the provided details.

---

## 📁 Verify File Structure
Once the files are extracted, confirm the folder structure contains the following:
** 🗄️Database Script:** MotorPH Payroll System Database Script.sql
** 📦 JAR Files:**
- apiguardian-api-1.1.2.jar
- commons-beanutils-1.11.0.jar
- commons-collections4-4.5.0.jar
- commons-digester3-3.2.jar
- commons-logging-1.3.5.jar
- desktop.inistax2-2.1.jar
- openpdf-2.2.3.jar
- mysql-connector-j-9.3.0.jar
- junit-platform-launcher-1.10.0.jar
- junit-platform-console-standalone-1.10.0.jar
- junit-platform-commons-1.10.0.jar
- junit-jupiter-engine-5.10.0.jar
- junit-jupiter-api-5.10.0.jar
- jcalendar-1.4.jar
- jasperreports-pdf-7.0.3.jar
- jasperreports-7.0.3.jar
- jackson-dataformat-xml-2.19.1.jar
- jackson-databind-2.19.1.jar
- jackson-core-2.19.1.jar
- jackson-annotations-3.0-rc5.jar

**Source Files:**
- PayrollSlip.jrxml
- AccountDetails.java
- Credentials.java
- DatabaseConnection.java
- DatabaseManager.java
- Employee.java
- EmployeeGUI.form
- EmployeeGUI.java
- HumanResource.java
- HumanResourceGUI.form
- HumanResourceGUI.java
- Login.java
- LoginGUI.form
- LoginGUI.java
- Payroll.java
- PayrollStaff.java
- PayrollStaffGUI.form
- PayrollStaffGUI.java
- PdfGenerator.java
- Supervisor.java
- SupervisorGUI.form
- SupervisorGUI.java

---

## 🚀 Launching the Application

### 📂 Direct Launch Method
1. **Navigate to the Application Folder**  
   Go to the folder where the `PayrollSystem.jar` file is located.

2. **Double-Click to Launch**  
   Double-click on `PayrollSystem.jar` to start the application.

> ⚠️ If the application does not start, use the Command Line Launch Method below.


### 💻 Command Line Launch Method

1. **Open Command Prompt / Terminal**  
   - On **Windows**, open **Command Prompt**  
   - On **macOS/Linux**, open **Terminal**
     
2. **Navigate to the JAR File Directory**  
   Use the `cd` command to navigate to the folder where “PayrollSystem.jar” is located. cd /path/to/application/folder
   
3. **Launch the Application**
Type the following command and press Enter:
java -jar PayrollSystem
This should launch the application and direct you to the login screen.

### 🧑‍💻 Running from NetBeans IDE (For Developers)
1. **Open the Project in NetBeans**
   - Launch NetBeans.
   - Click **File > Open Project**, then navigate to the project folder and open it.

2. **Run the Entire Project**
   - In the **Projects** panel, right-click the project name.
   - Select **Run**, or press `F6` on your keyboard.

3. **Run the Main Class (Login Screen)**
   - Alternatively, right-click on `LoginGUI.java` (the main entry point).
   - Choose **Run File** to start the application.
**The application should launch and display the login screen.**

---

## 🛠️ Troubleshooting Common Access Issues

### ☕ Java-Related Issues

**Java Not Recognized**
- **Ensure Java is correctly installed and added to your system's PATH.**
- **Unsupported major.minor version error:**  
  If you encounter this error, update your Java to version 8 or higher.
  
**Database Connection Issues**
In your `DatabaseConnection.java` (or similar file), verify the following details:
Database URL: Make sure the URL is correctly formatted, including the database host, port, and database name. For MySQL, the format should be:
String url = "jdbc:mysql://<host>:<port>/<database_name>"
For example:
String url = "jdbc:mysql://localhost:3306/motorph_db";

**Common Issues:**
- Incorrect host: Ensure that the host is correct (e.g., localhost or an IP address).
- Incorrect port: The default port for MySQL is 3306, but if it's different on your system, make sure to update it.
- Incorrect database name: Ensure that the database name is correct and exists in your MySQL server.

Username and Password: Verify that the username and password used to connect to MySQL are correct. Ensure that the user has sufficient privileges to access the database.

**Common Issues:**
- Incorrect username/password: Double-check the credentials.
- User permissions: Ensure that the user has appropriate permissions (e.g., SELECT, INSERT, UPDATE) for the database.

### 2. Check MySQL Server Status
Ensure that the MySQL server is running:

- **On Windows:**  
  Open the Services window (`services.msc`) and check if MySQL is listed as **Running**.
  
- **On macOS/Linux:**  
Run the command to check the status of MySQL:
sudo service mysql status
 - If the MySQL service is not running, start it:
Windows: Right-click MySQL in the Services window and select Start.
macOS/Linux: Run the command:
sudo service mysql start

### 3. Check the MySQL Server Host
Make sure that the MySQL server is configured to accept connections from your Java application, especially if it’s running on a different machine:
localhost: If you are using localhost or 127.0.0.1 in the URL, the MySQL server must be on the same machine as your NetBeans application.

### 4. Check JDBC Driver
Ensure that the MySQL JDBC driver is correctly added to your NetBeans project:
**Adding the MySQL Connector/J:** In NetBeans, you need to include the MySQL JDBC driver (e.g., mysql-connector-java-x.x.x.jar) in your project’s classpath.
- Right-click on Libraries in the Projects pane.
- Select Add JAR/Folder.
- Browse to the location of your MySQL JDBC driver and select it.

### 5. Common Error Messages and Their Fixes
- Access denied for user 'root'@'localhost' (using password: YES): This usually indicates an incorrect username or password. Double-check the credentials in your DatabaseConnection.java file.
- Communications link failure: This error occurs when the Java application cannot reach the MySQL server. It could be due to the server being down, an incorrect URL, or firewall/network issues.
- Unknown database: Ensure the database name specified in your URL exists in MySQL.

---

### Permission Issues
**Permission Denied:** Ensure you have read/write permissions for the application folder.
 - Try running the application as an administrator if on Windows.


# License

