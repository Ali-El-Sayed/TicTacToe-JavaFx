package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ui.Screens.LoginBase;
import ui.Screens.SignupBase;

public class TicTacToe extends Application {
  @Override
  public void start(Stage stage) {
    Parent root = new SignupBase();
    Scene scene = new Scene(root, 1343, 858);
    stage.setResizable(false);
    stage.setScene(scene);
    stage.show();

  }

  public static void main(String[] args) throws IOException {
    launch(args);

  }

}
