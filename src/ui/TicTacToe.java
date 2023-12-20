package ui;

import java.awt.SplashScreen;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ui.Screens.SplashScreenBase;

public class TicTacToe extends Application {

    @Override
    public void start(Stage stage) {
        Parent root = new SplashScreenBase();
        Scene scene = new Scene(root, 1343, 858);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }

}
