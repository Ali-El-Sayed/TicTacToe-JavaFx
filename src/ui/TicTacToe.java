package ui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.Screens.SplashScreenBase;

public class TicTacToe extends Application {

    public Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new SplashScreenBase(stage);
        scene = new Scene(root, 1343, 858);

        stage.setScene(scene);
        stage.setTitle("Tic Tac Toe Game");
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
