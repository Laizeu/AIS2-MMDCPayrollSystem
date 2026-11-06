-- Verification - run after V1, V2 and PasswordMigration (step 3 of docs/database-migrations.md).
-- Every query below has an expected result. Screenshot the output as evidence.

USE payroll_system_db;

-- 1. Column sizes. Expected: employee_password varchar(255); must_change_password tinyint(1) default 1
SHOW COLUMNS FROM credentials;

-- 2. No plaintext left. Expected: 0
SELECT COUNT(*) AS not_bcrypt
FROM credentials
WHERE employee_password NOT LIKE '$2a$12$%' OR CHAR_LENGTH(employee_password) <> 60;

-- 3. Same number of accounts as before the migration, IDs and roles unchanged.
--    Expected: 34 rows (compare with the backup: same employee_id + role pairs)
SELECT COUNT(*) AS accounts FROM credentials;
SELECT employee_id, role FROM credentials ORDER BY employee_id, role;

-- 4. Both stored procedures exist (payslips need generate_payslip_report). Expected: 2 rows
SELECT ROUTINE_NAME FROM information_schema.ROUTINES
WHERE ROUTINE_SCHEMA = 'payroll_system_db' AND ROUTINE_TYPE = 'PROCEDURE';

-- 5. Integrity fingerprint of the main tables. Save this output; re-run it after any test
--    to prove the test did not change data (same numbers = same data).
CHECKSUM TABLE credentials, employees, leave_ledger, overtime_requests, attendance_records, payslip;
