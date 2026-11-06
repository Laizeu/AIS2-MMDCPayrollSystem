# Security Logging and Session Management

## 1. Logs

The app writes two plain-text logs in the project folder. One line per event. Lines are only added, never rewritten.

| Log | Written by | Events | Line format |
|---|---|---|---|
| `access_denied.log` | `AccessControl` (Control 4) | Every blocked action: wrong role, no login, or someone else's records | `time \| DENIED \| user=… \| role=… \| action=… [\| owner=…]` |
| `security_events.log` | `SecurityLog` (new, feedback round) | `LOGIN_SUCCESS`, `LOGIN_FAILED`, `LOGIN_BLOCKED`, `SESSION_START`, `SESSION_END`, `PASSWORD_CHANGED`, `CREDENTIAL_ADDED` | `time \| EVENT \| user=… \| details` |

When each event is written:

| Event | When | Code |
|---|---|---|
| `LOGIN_FAILED` | wrong ID or password, or the ID is not a number | `LoginGUI.btnLoginActionPerformed` |
| `LOGIN_BLOCKED` | correct password, but the role is not valid, or the forced password change was not finished | `LoginGUI` |
| `LOGIN_SUCCESS` + `SESSION_START` | all checks passed, right before the portal opens | `LoginGUI`, `SessionContext.start` |
| `SESSION_END` | logout, or any return to the login screen | `SessionContext.end` |
| `PASSWORD_CHANGED` | forced first-login change saved | `ChangePasswordDialog` |
| `CREDENTIAL_ADDED` | HR adds a login (records who added it, for which ID and role) | `HumanResource.addNewCredentials` |
| `DENIED` | any `AccessControl.require(...)` or `requireSelf(...)` that fails | `AccessControl` |

Safeguards built into the logging:
- **Never logged:** passwords, hashes, salaries or government IDs. Only IDs, roles and action names.
- **No fake lines.** Line breaks and `|` in a logged value are replaced with `_`. A typed value cannot add a second, forged log entry.
- **Same message to the user.** A failed login always shows "Credentials Not Found!". The log keeps the detail for the team, but the screen never tells an attacker whether the ID exists (C1-AT10).
- **Kept out of git.** Both files are in `.gitignore`.

How the logs support the Incident Response Plan (SSEP):
- Brute force: count `LOGIN_FAILED` lines for one user, for example `grep "LOGIN_FAILED | user=10001" security_events.log | wc -l`.
- Privilege escalation: `grep DENIED access_denied.log`. Each line shows who tried what.
- Account misuse: `CREDENTIAL_ADDED` shows which HR user created which login.

Known limits (not selected for this milestone):
- The files are local text and can be edited by anyone with access to the folder. Tamper-proof, append-only audit logging is Control 6.
- There is no automatic alert. Someone has to read the log.

## 2. Session management

`SessionContext` holds one session per running app: the employee ID and the role.

| Safeguard | How | Proof |
|---|---|---|
| No session until every login check passes | `SessionContext.start()` runs only after the password matches, the role is valid and any forced password change is done | C4-FT1.1–1.4; `docs/evidence/gui-smoke-test.txt` (10025: no session while the change dialog is open) |
| Default deny | No session means role `null`, and `null` is never allowed (`AccessControl.isAllowed`) | C4-T13, C4-T20 |
| Unknown role refused | `Role.fromDb()` returns `null` for any text that is not one of the 4 roles. Login is blocked | C4-T5, C4-AT10 |
| Session cleared on logout | Every route back to the login screen calls `SessionContext.end()` (the `LoginGUI` constructor) | C4-FT3.2 |
| Portals open only through login | Each portal's `main()` opens `LoginGUI` | C4-AT9 |
| Checked on every action, not only at login | `AccessControl.require(action)` is the first line of 20 backend methods; `requireSelf(id)` is the first line of 12 self-service methods | `docs/test-evidence.md` §1 |
| Own records only | `requireSelf(id)`: the session user must be the owner of the record (stops ID tampering: user 10003 asking for 10005) | C4-T20–T24 |
| Clear message when blocked | A `SecurityException` from any screen shows "Access denied: you do not have permission for this action." (fixes the old AT 16 gap) | `docs/evidence/gui-smoke-test.txt` |
| Password never kept in the session | The session stores only the ID and role. `Login` removes the hash before data reaches the screens | C1-AT12 |

Known limits:
- No idle timeout or automatic logout (Control 8, not selected). A walk-up user at an unlocked PC could use an open portal.
- The session lives inside the desktop app. Anyone with the MySQL `root` password can skip the app entirely (Control 14). This is the limit stated in the SIP.
