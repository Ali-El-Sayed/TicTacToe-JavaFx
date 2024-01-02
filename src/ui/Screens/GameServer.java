
package ui.Screens;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GameServer {
    ServerSocket serversocket;
    public GameServer()  {
        try {
            serversocket = new ServerSocket(5010);
            while(true){
                Socket socket = serversocket.accept();
                if(socket.isConnected()){
                    System.out.println(socket.getLocalPort());
                    new GameHandler(socket);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        new GameServer();
    }
    
}
