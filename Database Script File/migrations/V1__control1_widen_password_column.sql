-- Migration V1 - Control 1 (BCrypt password hashing)          Applied: 2026-10-17
-- Why: a BCrypt hash is 60 characters; the old column was VARCHAR(50) and would cut it.
-- Before: take a full backup (see docs/database-migrations.md, step 0).
-- Safe to re-run: yes (MODIFY to the same type changes nothing).

USE payroll_system_db;

ALTER TABLE credentials
    MODIFY employee_password VARCHAR(255) NOT NULL;

-- Check: Type must be varchar(255)
SHOW COLUMNS FROM credentials LIKE 'employee_password';
