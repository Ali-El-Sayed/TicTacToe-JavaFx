/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Screens;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Button;

public class RecordingGame {
    
    private int positions[];

    public RecordingGame() {
        positions = new int[9];
    }
    
     public  void record(int possion ,int counter){
        positions[counter] = possion;
        counter++;
        System.out.println(Arrays.toString(positions));
    }
     public  void startReplay(Button []arButton) {
        new Thread(() -> {
            try {
                boolean isX =true;
                Thread.sleep(400);
                for (Button button : arButton) {
                    Platform.runLater(() -> button.setText(""));
                }
                for (int i : positions) {
                    if (i == 0) {
                        break;
                    }
                    Button currentButton = arButton[i - 1];
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
}
