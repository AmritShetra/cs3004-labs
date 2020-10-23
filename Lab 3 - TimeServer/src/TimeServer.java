import java.io.IOException;
import java.net.ServerSocket;

public class TimeServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        int serverPort = 4444;

        // Create a server socket and bind to the specified port
        try {
            serverSocket = new ServerSocket(serverPort);
            System.out.println("Server started.");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // As new clients connect, make a new Thread to deal with them
        while(true) {
            new TimeThread(serverSocket.accept()).start();
            System.out.println("New server thread started.");
        }

    }

}
