package ui;

import java.awt.SplashScreen;
import java.io.IOException;
import data.Pc;
import data.Pc.Level;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.Screens.GameBoardScreen;

import ui.Screens.SinglePlayer;
import ui.Screens.SplashScreenBase;

public class TicTacToe extends Application {
  @Override
  public void start(Stage stage) {
    Parent root = new GameBoardScreen(stage);
    Scene scene = new Scene(root, 1343, 858);
    stage.setResizable(false);
    stage.setScene(scene);
    stage.show();

  }

  public static void main(String[] args) throws IOException {
    launch(args);

  }

}
