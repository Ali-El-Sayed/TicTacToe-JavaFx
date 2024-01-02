package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import javafx.scene.control.Alert;
import ui.SceneController;
import java.util.Vector;

public class SocketConnection extends Thread {

    private static SocketConnection socketConnection = null;
    private Socket socket;
    private BufferedReader receiver;
    private PrintStream sender;
    private String localIp;
    private static Vector<String> list = new Vector<>();

    public String getLocalIp() {
        return localIp;
    }

    public BufferedReader getReceiver() {
        return receiver;
    }

    public PrintStream getSender() {
        return sender;
    }

    public SocketConnection(int x) {

    }

    private SocketConnection() {
        initializeSocket();
    }

    public static SocketConnection getInstance() {
        if (socketConnection == null) {
            synchronized (SocketConnection.class) {
                if (socketConnection == null) {
                    socketConnection = new SocketConnection();
                }
            }
        }
        return socketConnection;
    }

    private void initializeSocket() {
        try {
            socket = new Socket(Endpoint.SERVER_IP, Endpoint.PORT_NUMBER);
            System.out.println("Connection Stablished : " + socket.isConnected());
            localIp = socket.getInetAddress().getHostAddress();
        } catch (IOException ex) {
            Alert al = new Alert(Alert.AlertType.ERROR, "there is no connection \n please play offline");
            al.show();
        }
        if (socket != null && socket.isConnected()) {
            try {
                receiver = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                sender = new PrintStream(socket.getOutputStream());
            } catch (IOException ex) {
                Alert al = new Alert(Alert.AlertType.ERROR, "there is no connection \n please play offline");
                al.showAndWait();

            }
            this.start();
        }

    }

    private void setupIOSteams() {
//        while (socket.isConnected()) {
//            try {
//                String receivedMessage = receiver.readLine();
//                if (!receivedMessage.isEmpty()) {
//                    System.out.println("Recieved Response : " + receivedMessage);
//                    list.add(localIp);
//                }
//            } catch (IOException ex) {
//                System.out.println("Error in Reciever");
//            }
//        }

    }

    @Override
    public void run() {
        setupIOSteams();
    }

    public void closeConnection() {

        try {
            if (socket != null && socket.isConnected()) {
                sender.close();
                receiver.close();
                socket.close();
            }

        } catch (IOException ex) {
            System.err.println("Socket Disconnected");

        }
    }

    public static String getLastResponse() {
        return list.isEmpty() ? "" : list.get(0);
    }

    private class Endpoint {

        public static final int PORT_NUMBER = 5000;
//        public static final String SERVER_IP = "127.0.0.1";
        public static final String SERVER_IP = "10.145.14.104";
    }

}
