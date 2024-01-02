/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Screens;

import Recording.RecordDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Button;

public class RecordingGame {
    
    private int positions[];
    private String moves;
    private RecordDatabase rbd;
    public RecordingGame() {
        rbd = RecordDatabase.getInstance();
        positions = new int[9];
        moves = new String();
    }
    
     public  void record(int possion ,int counter){
            positions[counter] = possion;
            counter++;
            moves += String.valueOf(possion);
            System.out.println(Arrays.toString(positions));
            System.out.println("moves is = "+moves);
        
    }
    public  void startReplay(Button []arButton) {
            String move = moves;
            new Thread(() -> {
                try {
                    boolean isX =true;
                    Thread.sleep(400);
                    for (Button button : arButton) {
                        Platform.runLater(() -> button.setText(""));
                    }
                    for (int i = 0; i < move.length(); i++) {
                        
                        System.out.println(Character.getNumericValue(move.charAt(i)) - 1);
                        Button currentButton = arButton[Character.getNumericValue(move.charAt(i)) - 1];
                        String symbol = isX ? "X" : "O";
                        Platform.runLater(() -> currentButton.setText(symbol));
                        Thread.sleep(600);
                        isX = !isX;
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameBoardScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }).start();
       
    }
     
     public void saveRecord(){
            rbd.setData(moves);
     }
}
