/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;


import ui.Screens.PlayerVsComputer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.Screens.*;
import ui.Screens.GameBoardBase;

public class TicTacToe extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new PlayerVsComputer();
        Scene scene = new Scene(root,1343,858);
        stage.setScene(scene);
        stage.setTitle("Tic Tac Toe Game");
        stage.show();
        stage.setResizable(false);
    }
    public static void main(String[] args) {
        launch(args);
    }

}
