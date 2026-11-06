# Test Evidence: Controls 1 and 4

One page per attack the mentor asked about. Each row gives the test ID, how to run it, the expected result, the actual result, and where the proof is.
- Full steps for the Milestone 2 tests (C1-FT/AT, C4-FT/AT): Implementation Log, sheets "Control 1 …" and "Control 4 …".
- Automated tests in `test/payrollsystem/` (NetBeans: **Test Packages → payrollsystem**, right-click, then **Run File**):
  - `RbacCheck.java`: 29 checks (Control 4).
  - `PasswordPolicyCheck.java`: 17 checks (Control 1, feedback round).
- Latest run: 2026-11-06, on the team's Mac with the real database (`docs/evidence/mac-results-2026-11-06.txt`) and on a test copy. Outputs are in `docs/evidence/`. Screenshots from the team's Mac use the names in the Evidence column.

## 0. Before and after the feedback fixes

A review against the feedback found 8 sensitive functions that still had **no** role check or password rule. We proved each gap with an attack, fixed it, and ran the same attack again.

| # | Attack | Before (`gap-probe-before.txt`) | After (`gap-probe-after.txt`) | Fix |
|---|---|---|---|---|
| G1 | No login, read employee 10005's salary + SSS no. | **GAP**: salary 52,670, SSS shown | BLOCKED | `requireSelf` in `Employee.viewPersonalDetails` |
| G2 | Employee 10003 downloads 10005's payslip | **GAP**: PDF saved | BLOCKED | `requireSelf` in `downloadPayslip` |
| G3 | Employee 10003 reads 10005's DTR | **GAP**: 20 rows | BLOCKED | `requireSelf` in `getDTR` |
| G4 | Supervisor reads 10005's payroll breakdown | **GAP**: net pay shown | BLOCKED | `require(VIEW_PAYROLL)` in `PdfGenerator.readEmployeeDetailsFromDB` |
| G5 | Employee lists every employee's name | **GAP**: 34 names | BLOCKED | `require(VIEW_EMPLOYEE_DTR)` in both `employeeNames()` |
| G8 | Employee inserts a fake payslip for 10005 | **GAP**: row inserted | BLOCKED | `require(GENERATE_PAYSLIP)` in `insertPdfToDB` |
| G6 | HR backend saves weak password `test1234` | **GAP**: row saved | BLOCKED | `PasswordPolicy` in `addNewCredentials` |
| G7 | `Login.changePassword("abc")` called directly | **GAP**: saved | BLOCKED | `PasswordPolicy` re-checked in the backend |

## 1. Authorization bypass attempts

Method: `RbacCheck` sets a fake session (or none) and calls the backend method **directly**, skipping the screens. This is the strongest bypass, because no button hiding can help. Each call must throw `SecurityException` before any SQL runs, and must add one line to `access_denied.log`.

| ID | Attempt | Expected | Actual | Evidence |
|---|---|---|---|---|
| C4-T6 | Employee adds an HR credential | DENIED | PASS | `rbaccheck-output.txt`, C4-AT1 screenshot |
| C4-T7 | Employee approves a leave request | DENIED | PASS | C4-AT2 |
| C4-T8 | Employee generates a payslip | DENIED | PASS | C4-AT3 |
| C4-T9 | HR forwards a DTR | DENIED | PASS | C4-AT4 |
| C4-T10 | Payroll Staff views all credentials | DENIED | PASS | C4-AT5 |
| C4-T11 | Supervisor adds an employee | DENIED | PASS | C4-AT6 |
| C4-T12 | Supervisor generates a payslip | DENIED | PASS | C4-AT7 |
| C4-T13 | No login views employee records | DENIED | PASS | C4-AT8 |
| C4-T20 | No login reads 10005's salary + government IDs | DENIED | PASS | `rbaccheck-output.txt` |
| C4-T21 | Employee 10003 reads 10005's DTR (ID tampering) | DENIED | PASS | 〃 |
| C4-T22 | Employee 10003 downloads 10005's payslip | DENIED | PASS | 〃 |
| C4-T23 | Employee 10003 files a leave request as 10005 | DENIED | PASS | 〃 |
| C4-T24 | HR files overtime as 10005 | DENIED | PASS | 〃 |
| C4-T25 | Supervisor reads a payroll breakdown | DENIED | PASS | 〃 |
| C4-T26 | Employee inserts a fake payslip | DENIED | PASS | 〃 |
| C4-T27 | Employee lists all employee names | DENIED | PASS | 〃 |
| C4-AT9 | Run a portal file directly (skip login) | login screen opens | PASS | C4-AT9 screenshot |
| C4-AT10 | Change role to `Admin` in MySQL, then log in | "Access denied: your account has no valid role." | PASS | C4-AT10 screenshot |
| GUI | Forbidden action from inside the HR portal | "Access denied" pop-up, logged | PASS | `gui-smoke-test.txt`, `sample-access_denied.log` |
| C4-T19 | One log line per denial | 16 new lines | PASS (16) | `rbaccheck-output.txt` |

Normal use still works: C4-T14–T17, T28 (own details), T29 (Payroll reads payroll), all 4 portals (`gui-smoke-test.txt`).

**Coverage: every sensitive backend method and its check**

| Class | Method | Check |
|---|---|---|
| HumanResource | displayAllDetails, retrievedEmploymentStatus | VIEW_EMPLOYEE_RECORDS |
| HumanResource | addEmployeeDetails, nextEmployeeID | ADD_EMPLOYEE |
| HumanResource | updateEmployeeDetails | UPDATE_EMPLOYEE |
| HumanResource | retrievedAllCredentials / addNewCredentials | VIEW_CREDENTIALS / ADD_CREDENTIALS + PasswordPolicy |
| Supervisor | employeeRequest | VIEW_TEAM_REQUESTS |
| Supervisor | approvedEmployeeRequest / disapprovedEmployeeRequest / forwardDTR | APPROVE / DISAPPROVE_REQUEST / FORWARD_DTR |
| Supervisor, PayrollStaff | employeeNames, getDataForDTRTable | VIEW_EMPLOYEE_DTR |
| PayrollStaff | getEmployeeWithAttendance | VIEW_PAYROLL |
| PayrollStaff | generatePayslip | GENERATE_PAYSLIP |
| PdfGenerator | generatePayslipPDF, insertPdfToDB / readEmployeeDetailsFromDB | GENERATE_PAYSLIP / VIEW_PAYROLL |
| Employee (self-service, all roles) | viewPersonalDetails, getDataAllRequests, getDTR, viewPersonalLeaveLedger, fileOvertimeRequest, fileLeaveRequest, userLogin, userLogout, leaveBalancesInformation, getDaysWorked, getOvertime, downloadPayslip | requireSelf (own records only) |
| Login | changePassword | must have logged in + PasswordPolicy |

Not checked on purpose: `countNumberOfDays` and `validateDateBirthday` (pure date math, no data), and getters/setters (they only return values already loaded by a checked method).

## 2. SQL injection

Why it fails: every query uses `PreparedStatement` with bound parameters (IAS2 audit: Control 3 partial). The ID is converted to a number before any query. The password is never put in SQL; it is only compared with BCrypt.

| ID | Input | Field | Expected | Actual | Evidence |
|---|---|---|---|---|---|
| C1-AT4 | `' OR '1'='1` and `' OR 1=1 --` | password (GUI) | "Credentials Not Found!" | PASS | C1-AT4 SQLi password.png |
| C1-AT5 | `10001 OR 1=1` and `10001' --` | Employee ID (GUI) | "Invalid Employee ID!" | PASS | C1-AT5 SQLi ID.png |
| C1-P12/P13 | same password payloads, backend `Login.checkCredentials` | password | no login | PASS | `passwordpolicycheck-output.txt` |
| C1-P14/P15 | same ID payloads, `Integer.parseInt` (same as LoginGUI) | Employee ID | rejected | PASS | 〃 |
| C1-P17 | after all the payloads | credentials table | checksum unchanged | PASS | 〃 |

## 3. Password truncation (BCrypt 72-byte limit)

BCrypt ignores every byte after 72. Without a limit, `password` + anything would log in. We block >72 bytes at **every** entry point, and also inside `verify()`.

| ID | Test | Expected | Actual | Evidence |
|---|---|---|---|---|
| C1-AT3 | Set a 72-character password, then log in with 73 characters (extra last character) | rejected | PASS | C1-AT3 truncation.png |
| C1-FT3.2 | HR adds a 73-character password | "Password must be at most 72 characters.", nothing saved | PASS | C1-FT3.2 too long.png |
| C1-FT5.4 | 73 characters in the change dialog | same message | PASS | C1-FT5.4 too long.png |
| C1-P4 | `PasswordPolicy` with 73 bytes | rejected | PASS | `passwordpolicycheck-output.txt` |
| C1-P5 | exactly 72 bytes (strong) | accepted | PASS | 〃 |
| C1-P10 | `PasswordUtil.verify(73-byte, hash of the 72-byte one)` | false | PASS | 〃 |
| C1-P11 | `verify(72-byte, its hash)` | true | PASS | 〃 |

Rules are now the same everywhere (`PasswordPolicy`): 8–72 characters, upper + lower + number + special, not the employee ID, not the current password. Proof: C1-P1–P9.

## 4. Database integrity verification

Method: MySQL `CHECKSUM TABLE` gives a number for each table's content. The same number before and after a test means the test changed no data.
```sql
CHECKSUM TABLE credentials, employees, leave_ledger, overtime_requests, attendance_records, payslip;
```

| ID | What | Expected | Actual | Evidence |
|---|---|---|---|---|
| C4-T18 | 6 tables, before vs after all 16 bypass attempts (7 of them try to write: add credential, add employee, approve, forward DTR, file leave, file overtime, insert payslip) | identical | PASS: values printed in the output | `rbaccheck-output.txt` |
| C1-P17 | `credentials`, before vs after injection and weak-password attempts | identical | PASS | `passwordpolicycheck-output.txt` |
| C1-AT11 / C1-P16 | rows that are not a `$2a$12$` 60-character hash | 0 | PASS | C1-AT11 no plaintext.png |
| Migration | 34 accounts before and after; ID + role pairs identical; 2 procedures present | identical | PASS | `migration-replay.txt` |

## 5. Stress tests (`StressCheck.java`, output in `docs/evidence/stress-test.txt`)

| ID | Test | Result |
|---|---|---|
| C1-S1 | 500 rapid wrong-password logins on one account | **Before:** from attempt 177 MySQL refused new connections and 137 attempts ended in "Database Connection Failed!", so no one could log in (connection leak: 5 MySQL connections per login attempt, never closed; limit 151). **After** the shared-connection fix: 500/500 rejected, 0 errors, about 300 ms per attempt, 1 connection open at the end |
| C1-S2 | Offline guessing against a stolen hash of 10003 with a list of employee IDs + common passwords | **Test copy** (10003 still on its initial password): cracked in 3 guesses. **Real database on the Mac** (10003 already changed it): NOT cracked after 57 guesses. BCrypt slows guessing to about 3 per second per CPU core, but it cannot protect a password that is easy to guess. That is why the forced change and `PasswordPolicy` are needed |
| C1-S3 | Same list against a changed, policy-compliant password | Not cracked |
| C4-S1 | 1000 rapid forbidden calls | 1000 denied, 1000 logged, 52 ms in total |
| C4-S2 | Cost of one permission check | about 0.1 µs (no visible slowdown) |

## How to reproduce on your own machine

1. Import `Database Script File/MotorPH Payroll System Database Script.sql`.
2. Run `V3__verify_after_migration.sql`. Save the checksum output.
3. NetBeans: run `RbacCheck.java`, `PasswordPolicyCheck.java` and `StressCheck.java`. Screenshot each Output panel.
4. Open `access_denied.log` and `security_events.log`. Screenshot them.
