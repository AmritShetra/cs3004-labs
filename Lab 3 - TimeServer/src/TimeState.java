import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeState {

    public String getTime(String message) {
        if (message.equals("What time is it?")) {
            return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        } else {
            return "I only understand \"What time is it?\"";
        }
    }
}
