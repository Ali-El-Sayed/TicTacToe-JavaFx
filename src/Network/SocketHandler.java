package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketHandler {

    private static SocketHandler socketHandler = null;
    private Socket socket;
    private BufferedReader receiver;
    private PrintStream sender;

    private SocketHandler() {
        initializeSocket();
    }

    public static SocketHandler getInstance() {

        if (socketHandler == null) {
            return new SocketHandler();
        }
        return socketHandler;
    }

    private void initializeSocket() {
        new Thread(() -> {
            try {
                socket = new Socket(Endpoint.SERVER_IP, Endpoint.PORT_NUMBER);
                setupIOSteams();
            } catch (IOException ex) {
                Logger.getLogger(SocketHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }

    private void setupIOSteams() {
        if (socket.isConnected()) {
            try {
                receiver = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                sender = new PrintStream(socket.getOutputStream());
            } catch (IOException ex) {
                Logger.getLogger(SocketHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        while (socket.isConnected()) {
            try {
                String receivedMessage = receiver.readLine();
                if (!receivedMessage.isEmpty()) {
                    System.out.println(receivedMessage);
                    ResponseHandler.handle(receivedMessage);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }

}
