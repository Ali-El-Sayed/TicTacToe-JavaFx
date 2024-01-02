/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Screens;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import ui.SceneController;


public class ReplayScreen extends GameBoardScreen implements CommonBehaviorInModes{
    String moves;
    public ReplayScreen(String moves) {
        this.moves = moves;
        newGameBtn.setVisible(false);
        back_btn.setOnAction((ActionEvent event) -> {
            SceneController.switchToSplashScreen(event, gridPane);
        });
        recordBtn.setVisible(false);
        initializeBtnHandler();
        
    }

    @Override
    public void initializeBtnHandler() {
            
        new Thread(() -> {
                try {
                    boolean isX =true;
                    for (int i = 0; i < moves.length(); i++) {
                        Button currentButton = arButton[Character.getNumericValue(moves.charAt(i)) - 1];
                        String symbol = isX ? "X" : "O";
                        Platform.runLater(() -> currentButton.setText(symbol));
                        Thread.sleep(800);
                        int btn1 = Character.getNumericValue(moves.charAt(i)) -1;
                        checkedBtns.put(btn1 + 1, isX ? "O" : "X");
                        isX = !isX;
                        if(isWinner()){
                            
                        }else{
                            
                        }
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameBoardScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }).start();

    }

    @Override
    public void handlePressedButton(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
