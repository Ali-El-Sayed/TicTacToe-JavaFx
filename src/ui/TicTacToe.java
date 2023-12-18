/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.SplashScreen;
import java.awt.event.MouseListener;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ui.Screens.GameBoardScreen;
import ui.Screens.LoginBase;
import ui.Screens.LoginsignupBase;
import ui.Screens.SignupBase;
import ui.Screens.SplashScreenBase;

public class TicTacToe extends Application {
    public Scene scene;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new SplashScreenBase(stage);
        scene = new Scene(root,1343,858);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
