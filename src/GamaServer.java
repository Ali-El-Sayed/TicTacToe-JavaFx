
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.Screens.GameBoardScreen;


public class GamaServer {
    ServerSocket serversocket;
    Socket clientSocket;
    DataInputStream ear;
    PrintStream mouth;

    public GamaServer()  {
        try {
            serversocket=new ServerSocket(5005);
            while(true){
                clientSocket=serversocket.accept();
                new GameHandler(clientSocket);
                
            }
        } catch (IOException ex) {
            Logger.getLogger(GamaServer.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    public static void main(String[] args) {
        new GamaServer();
    }
    
    
}
 class GameHandler extends Thread {
    DataInputStream ear;
    PrintStream mouth;
    static Vector<GameHandler> clients;

    static {
        clients = new Vector<GameHandler>();
    }

    public GameHandler(Socket socket) {
        try {
            ear=new DataInputStream(socket.getInputStream());
            mouth=new PrintStream(socket.getOutputStream());
            clients.add(this);
            start();
            
        } catch (IOException ex) {
            Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            


    }
    public void run (){
        while(true){
            try {
                String symbol=ear.readLine();
                System.out.println("receive from client"+symbol);
                for(int i=0; i< clients.size();i++){
                    clients.get(i).mouth.println(symbol);
                    
                }
            } catch (IOException ex) {
                Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
