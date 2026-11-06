# Cross-Platform Compatibility Fixes

The system was first built on Windows (NetBeans, Paul's laptop). It was then hardened and tested on macOS. Each problem below was found while testing on macOS. This page lists the problem, the fix, the commit, and how we proved it works.

| # | Problem (symptom on macOS) | Cause | Fix | Commit | Proof |
|---|---|---|---|---|---|
| 1 | Releasing payslips failed: report file not found | `PdfGenerator` built paths with Windows backslashes: `user.dir + "\\src\\files\\PayrollSlip.jrxml"` | `new File(baseDir, "src/files/PayrollSlip.jrxml")`. Java turns `/` into the correct separator on every OS. Same for the logo and the `src/temp` output | `bead1b1` | 34 October 2024 payslips released (C4-FT2.3); re-run 2026-11-06 in `docs/evidence/gui-smoke-test.txt` |
| 2 | Payslip PDF failed to render: font "Segoe UI" not available | The report used Windows-only fonts (`Segoe UI`, `Segoe UI Light`, 45 fields) | Changed all 45 fields in `PayrollSlip.jrxml` to `SansSerif` (a logical Java font on every OS). Also set `net.sf.jasperreports.awt.ignore.missing.font=true` as a safety net | `bead1b1` | Same as #1 |
| 3 | jBCrypt not found when the project was opened on another computer | NetBeans saved the jar with an absolute path from another project folder | Removed it and re-added it from `jar files/jbcrypt-1.0.2.jar` (relative path, forward slash) | `acf61b2` | C1-FT1.3 (Libraries screenshot) |
| 4 | `jcalendar-1.4.jar` reference pointed to `C:\Users\Paul\Downloads\...` | Absolute Windows path in `nbproject/project.properties` | Now `jar files/jcalendar-1.4.jar` (relative). The old `jar files\\jcalendar-1.4.jar` entry stays because Ant accepts `\` on every OS | branch `feedback-fixes` | Project builds on macOS and Linux (2026-11-06) |
| 5 | Running the migration tool from the default package failed | `PasswordMigration` was created outside the `payrollsystem` package and could not use package-private classes | Recreated in `payrollsystem` (now kept in `Database Script File/migrations/`) | Implementation Log issue 3 | `docs/evidence/migration-replay.txt` |
| 6 | Database export dropped the stored procedures | `mysqldump` without `--routines` | Always export with `--routines --triggers` | `b855bb2` | V3 check #4 (2 procedures) |

## Rules we now follow (so it stays portable)

- Build every file path with `new File(base, "a/b/c")` or `Paths.get(...)`. Never hard-code `\\` or `C:\`.
- Use only logical fonts (`SansSerif`, `Serif`, `Monospaced`) in reports.
- Add jars only from the project's `jar files/` folder, so the path is relative.
- Commands in docs show both macOS (`/usr/local/mysql/bin/mysql`) and Windows (`"C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe"`) paths.
- Runtime files (`access_denied.log`, `security_events.log`, `DownloadFiles/`, `src/temp/`) are in `.gitignore`, so one person's test data never reaches git.

## Tested environments

| OS | Java | MySQL | Who / when | Result |
|---|---|---|---|---|
| Windows 11 | JDK 23 (preview on) | 8.0 | original build | Works (before hardening) |
| macOS | JDK 23 (preview on) | 8.0 (`/usr/local/mysql`) | team, 2026-10-17 | All Control 1 and Control 4 tests passed |
| Ubuntu 24.04 (test copy) | JDK 25 | 8.0.46 | 2026-11-06 | Builds; RbacCheck 29/29, PasswordPolicyCheck 17/17, all 4 portals open |

Note: the project uses Java "flexible constructor bodies" (code before `super()` in `Employee` and `Supervisor`). This needs JDK 23/24 with `--enable-preview` (already set in `nbproject/project.properties`) or JDK 25+, where it is standard. It does not compile on JDK 21 or older.
