package ui;

import data.Pc;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.Screens.SignupBase;
import ui.Screens.SinglePlayer;

public class TicTacToe extends Application {

    @Override
    public void start(Stage stage) {
        Parent root = new SinglePlayer(new Pc(Pc.Level.HARD));
        Scene scene = new Scene(root, 1343, 858);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
      
    }

    public static void main(String[] args) throws IOException {
        launch(args);

    }

}
