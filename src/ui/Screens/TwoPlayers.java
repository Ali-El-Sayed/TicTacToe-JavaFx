/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Screens;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class TwoPlayers extends GameBoardScreen implements CommonBehaviorInModes {

    public TwoPlayers() {
    }

    @Override
    public void initializeBtnHandler() {
        for (Node node : gridPane.getChildren()) {
            if (node.getClass() == Button.class) {
                Button btn = (Button) node;
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        handlePressedButton(event);
                        Integer btn1 = gridPane.getChildren().indexOf(node);
                        checkedBtns.put(btn1 + 1, isX ? "O" : "X");
                        if (isWinner()) {
                            handleGameOver(event);

                        }
                    }
                });
            }
        }
    }

    @Override
    public void handlePressedButton(ActionEvent event) {
        Button btn = (Button) event.getTarget();

        btn.setText(isX ? "X" : "O");
        isX = !isX;
        btn.setOnAction((e) -> {

        });
    }

}
