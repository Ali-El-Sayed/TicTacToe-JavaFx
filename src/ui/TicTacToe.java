/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.SplashScreen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.Screens.GameBoardFXML;
import ui.Screens.*;

public class TicTacToe extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new SignupBase();
        Scene scene = new Scene(root,1343,858);
        stage.setScene(scene);
        stage.setTitle("Welcome to our Tic Tac Toe Game");
        stage.show();
        stage.setResizable(false);
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
