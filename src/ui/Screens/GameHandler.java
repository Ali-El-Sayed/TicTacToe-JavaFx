package ui.Screens;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameHandler extends Thread {
    BufferedReader ear;
    PrintStream mouth;

    static Vector<GameHandler> clients = new Vector<GameHandler>();

    public GameHandler(Socket cs) {
        System.out.println("Printing game handler");
        try {
            ear = new BufferedReader(new InputStreamReader(new DataInputStream(cs.getInputStream())));
            mouth = new PrintStream(cs.getOutputStream());
            GameHandler.clients.add(this);
            //start();
        } catch (IOException ex) {
            Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                String str = ear.readLine();
                //sendMessageToAll(str);
            } catch (IOException ex) {
                Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void sendMessageToAll(String msg) {

        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).mouth.println(msg);
        }
    }
}

/*
    interface QuackBehaviour {
        quack();
    }
    
    class Quack implements QuackBehaviour{
        quack(){};
    }
    class MuteQuack implements QuackBehaviour{
        quack(){};
    }

    class Duck{
        QuackBehaviour quackBehaviour;
        performQuack(){
            quackBehaviour.quack();
        }
    }

    class MallardDuck{
        QuackBehaviour = new Quack();
    }

    a setter method to set the quack behaviour at runtime in duck
        setQuackBehaviour(QuackBheaviour qb){
            quackbehaviour = qb;
        }
    
 */
