package payrollsystem;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Security event log (login, logout, password and credential changes).
// One line per event: time | EVENT | user=... | details. Passwords and hashes are never written.
// Denied actions are still written to access_denied.log by AccessControl (unchanged from Milestone 2).
final class SecurityLog {
    static final String EVENTS_LOG = "security_events.log";

    private SecurityLog(){
    }

    static synchronized void event(String event, String userID, String details){
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        try(PrintWriter writer = new PrintWriter(new FileWriter(EVENTS_LOG, true))){
            writer.println(time + " | " + event + " | user=" + (userID == null ? "none" : clean(userID))
                    + (details == null ? "" : " | " + clean(details)));
        }catch(IOException e){
            System.err.println("Could not write " + EVENTS_LOG + ": " + e.getMessage());
        }
    }

    // Keep each event on one line so a typed value cannot fake a second log entry.
    private static String clean(String value){
        return value.replaceAll("[\\r\\n|]", "_");
    }
}
