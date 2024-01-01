package Network;
import Network.Response.NetworkResponse;
import  Network.Response.ResponseHandler;
import Network.Response.data.AvailablePlayerData;
import Network.Response.data.AvailablePlayersResponse;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;
import javafx.application.Platform;


import ui.Screens.AvailablePlayersScreen;


public class SocketConnection extends Thread {

    private static SocketConnection socketHandler = null;
    private Socket socket;
    private BufferedReader receiver;
    private PrintStream sender;
    private String msg;

    public BufferedReader getReceiver() {
        return receiver;
    }

    public PrintStream getSender() {
        return sender;
    }

    public SocketConnection() {
        initializeSocket();
    }

    public static SocketConnection getInstance() {

        if (socketHandler == null) {
            return new SocketConnection();
        }
        return socketHandler;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    

    private void initializeSocket() {
        try {
            socket = new Socket(Endpoint.SERVER_IP, Endpoint.PORT_NUMBER);
            System.out.println("Connection Stablished : " + socket.isConnected());

        } catch (IOException ex) {
            System.err.println("Connection Failed");
        }
        if (socket.isConnected()) {
            try {
                receiver = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                sender = new PrintStream(socket.getOutputStream());
            } catch (IOException ex) {
                System.err.println("Failed IO");
            }
        }
        this.start();
    }

    private void setupIOSteams() {

        while (socket.isConnected()) {
            try {

                String receivedMessage = receiver.readLine(); //listen to server 
                if (!receivedMessage.isEmpty()) {
                    System.out.println("receive from server" + receivedMessage);

                    this.setMsg(receivedMessage);

                    AvailablePlayersResponse onlinePlayersList = ResponseHandler.getResponseObj(receivedMessage);
                    Platform.runLater(() -> {
                        new AvailablePlayersScreen(onlinePlayersList);

                    });

//                    for (int i = 0; i < onlinePlayersList.playerData.size(); i++) {
//                        System.out.println("Printing" + onlinePlayersList.playerData);
//                    }

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
