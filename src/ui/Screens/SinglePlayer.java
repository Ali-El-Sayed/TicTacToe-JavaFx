
package ui.Screens;

import data.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SinglePlayer extends GameBoardScreen implements CommonBehaviorInModes{

    Pc pc;
    Player player;


    public SinglePlayer(Pc pc) {
    
        initializeBtnHandler();
        
        this.pc =pc;

    }

    @Override
    public void initializeBtnHandler(){
         for (Node node : gridPane.getChildren()) {
            if (node.getClass() == Button.class) {
                Button btn = (Button) node;
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        handlePressedButton(event);
                        Integer btn1 = gridPane.getChildren().indexOf(node);
                        checkedBtns.put(btn1+1 , "X");
                        if (isWinner()) {
                            handleGameOver(event);

                        } else {
                            int index=pc.play(checkedBtns.keySet());
                            //System.out.println(checkedBtns.keySet());
                            checkedBtns.put(index , "o");
                            //System.out.println(checkedBtns);
                            Button computerButton = (Button) gridPane.getChildren().get(index-1);
                            //System.out.println(index);
                            
                            computerButton.setText("o");
                            mouth.println(computerButton.getText());
                            if (isWinner()) {
                                handleGameOver(event);
                            }
                        }
                    }
                });
            }
        }
    }
    @Override
    public void handlePressedButton(ActionEvent event) {
        System.out.println("in handlePressedButton");
        Button btn = (Button) event.getTarget();

        btn.setText("X");
        mouth.println(btn.getText());

        btn.setOnAction((e) -> {

        });
    }

}
