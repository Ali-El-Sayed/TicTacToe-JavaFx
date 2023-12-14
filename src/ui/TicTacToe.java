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
import ui.Screens.LoginBase;
import ui.Screens.LoginsignupBase;
import ui.Screens.SignupBase;
import ui.Screens.SplashScreenBase;

public class TicTacToe extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("/ui/Screens/Login.fxml"));
        Parent root = new SplashScreenBase();
        Scene scene = new Scene(root,1343,858);
        stage.setResizable(false);
        //stage.setWidth(143);
        //stage.setHeight(858);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
