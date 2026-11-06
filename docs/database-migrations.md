# Database Migrations (Control 1)

What changed in `payroll_system_db`, in what order, how to check it, and how to undo it.

| | |
|---|---|
| Applied | 2026-10-17, branch `dev-security-controls` |
| Starting point | git tag `baseline-plaintext` (commit 171d984): plaintext passwords, `VARCHAR(50)` |
| Scripts | `Database Script File/migrations/` |
| Full schema after migration | `Database Script File/MotorPH Payroll System Database Script.sql` (exported with `--routines`) |
| Re-tested | 2026-11-06: replayed on the baseline database, see `docs/evidence/migration-replay.txt` |

## Summary of changes

| # | Change | Table / column | Before | After | Reason |
|---|---|---|---|---|---|
| V1 | Widen column | `credentials.employee_password` | `VARCHAR(50)` | `VARCHAR(255) NOT NULL` | A BCrypt hash is 60 characters. 50 would cut it and break every login |
| V2 | New column | `credentials.must_change_password` | (none) | `TINYINT(1) NOT NULL DEFAULT 1` | Forces a new password at first login (initial passwords = employee ID) |
| Data | Hash all passwords | `credentials.employee_password` | 34 plaintext values | 34 `$2a$12$` hashes | RISK-01 |
| Fix | Re-export stored procedures | `generate_payslip_report`, `UpdateLeaveIfBalanceSufficient` | missing from the first export | included | Payslips use `generate_payslip_report` |

No other table was changed. No column was removed. IDs and roles were not touched.

## Step 0: Backup (always first)

```bash
# macOS (MySQL from the official installer). On Windows use "C:\Program Files\MySQL\MySQL Server 8.0\bin\mysqldump.exe".
/usr/local/mysql/bin/mysqldump -u root -p --routines --triggers payroll_system_db > ~/Desktop/payroll_system_db-backup.sql
```
- Also zip the project folder (we made `PayrollAOOP-M2.zip`) and tag the code (`git tag baseline-plaintext`).
- `--routines` matters: without it the two stored procedures are lost. This was issue 4 in the Implementation Log.

## Step 1: Schema (V1, V2)

```bash
/usr/local/mysql/bin/mysql -u root -p < "Database Script File/migrations/V1__control1_widen_password_column.sql"
/usr/local/mysql/bin/mysql -u root -p < "Database Script File/migrations/V2__control1_must_change_password.sql"
```
V1 must run before step 2. Otherwise MySQL cuts the hash at 50 characters.

## Step 2: Hash the existing passwords (one time)

1. Copy `Database Script File/migrations/PasswordMigration.java` into `src/payrollsystem/`.
2. NetBeans: right-click it, then **Run File**. Expected output: `Hashed: 34, already hashed: 0`.
3. Delete the copy from `src/payrollsystem/` (AC 4.3: the tool must not stay in the app).

How it stays safe:
- **One transaction.** Either all rows are converted or none. Any error triggers a rollback.
- **Re-run is harmless.** Rows that are already hashes are skipped (`Hashed: 0, already hashed: 34`).
- It uses the same `PasswordUtil.hash()` as the app (jBCrypt 1.0.2, work factor 12).

## Step 3: Verify

```bash
/usr/local/mysql/bin/mysql -u root -p < "Database Script File/migrations/V3__verify_after_migration.sql"
```

| Check | Expected | Result 2026-10-17 | Replay 2026-11-06 |
|---|---|---|---|
| `employee_password` type | `varchar(255)` | Pass (C1-FT1.2) | Pass |
| Rows not `$2a$12$`/60 chars | 0 | Pass (C1-AT11) | Pass |
| Number of accounts | 34 (same as backup) | Pass | Pass, IDs and roles unchanged |
| Stored procedures | 2 | Pass | Pass |
| `CHECKSUM TABLE` | saved as the fingerprint for later tests | Used by RbacCheck C4-T18 | Pass |

## Rollback

| Situation | How to undo |
|---|---|
| After V1 only | `ALTER TABLE credentials MODIFY employee_password VARCHAR(50) NOT NULL;` |
| After V2 only | `ALTER TABLE credentials DROP COLUMN must_change_password;` |
| After step 2 (hashing) | Hashes cannot be turned back into passwords. Restore the backup: `mysql -u root -p payroll_system_db < ~/Desktop/payroll_system_db-backup.sql`, then check out tag `baseline-plaintext` |
| Hashing failed halfway | Nothing to undo. The transaction rolls back by itself |

## Setting up a fresh database (new team member)

Import `Database Script File/MotorPH Payroll System Database Script.sql`. It already has the final schema, the hashed passwords and both procedures. **Do not** run V1 or V2 on it (V2 would stop with "Duplicate column name"). Run only V3 to check it.

## Not changed in this milestone (known limits)

- The app still connects as MySQL `root` (Control 14, not selected).
- The salary and government-ID columns are still unencrypted (Control 5, not selected).
