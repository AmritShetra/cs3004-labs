import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeThread extends Thread {

    private Socket socket = null;

    TimeThread(Socket socket) {
        super("TimeThread");
        this.socket = socket;
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                // Read in the input from the socket
                String message = in.readLine();

                if (message.equals("What time is it?")) {
                    String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
                    out.println(time);
                } else {
                    out.println("I only understand \"What time is it?\"");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
