package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class SocketConnection extends Thread {

    private static SocketConnection socketHandler = null;
    private Socket socket;
    private BufferedReader receiver;
    private PrintStream sender;

    private SocketConnection() {
        initializeSocket();
    }

    public static SocketConnection getInstance() {

        if (socketHandler == null) {
            return new SocketConnection();
        }
        return socketHandler;
    }

    private void initializeSocket() {
        try {
            socket = new Socket(Endpoint.SERVER_IP, Endpoint.PORT_NUMBER);
            this.start();
        } catch (IOException ex) {
            System.err.println("Connection Failed");
        }
    }

    private void setupIOSteams() {
        if (socket.isConnected()) {
            try {
                receiver = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                sender = new PrintStream(socket.getOutputStream());
            } catch (IOException ex) {
                System.err.println("Failed IO");
            }
        }

        while (socket.isConnected()) {
            try {
                String receivedMessage = receiver.readLine();
                if (!receivedMessage.isEmpty()) {
                    System.out.println(receivedMessage);

                }
                for (int i = 0; i < 10; i++) {
                    sender.println("Hello");
                }

            } catch (IOException ex) {

            }

        }

    }

    @Override
    public void run() {
        setupIOSteams();
    }

    public void closeConnection() {

        try {
            sender.close();
            receiver.close();
            socket.close();
        } catch (IOException ex) {
            System.err.println("Socket Disconnected");

        }
    }

    private class Endpoint {

        public static final int PORT_NUMBER = 5000;
        public static final String SERVER_IP = "127.0.0.1";

    }
}
