-- Migration V2 - Control 1 (forced password change at first login)    Applied: 2026-10-17
-- Why: many initial passwords equal the employee ID. Every account must set a new,
-- stronger password before any portal opens. 1 = must change, 0 = already changed.
-- New credentials added by HR get 1 automatically (column default).
-- Safe to re-run: no - run once. If the column already exists, MySQL stops with
-- "Duplicate column name" and nothing is changed.

USE payroll_system_db;

ALTER TABLE credentials
    ADD COLUMN must_change_password TINYINT(1) NOT NULL DEFAULT 1;

UPDATE credentials SET must_change_password = 1;   -- all 34 existing accounts

-- Check: every row shows 1
SELECT must_change_password, COUNT(*) AS accounts FROM credentials GROUP BY must_change_password;
