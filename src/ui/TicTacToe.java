package ui;

import Network.SocketConnection;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.Screens.LoginBase;

public class TicTacToe extends Application {

    @Override
    public void start(Stage stage) {
        Parent root = new LoginBase();
        Scene scene = new Scene(root, 1343, 858);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        SocketConnection.getInstance();

    }

    public static void main(String[] args) throws IOException {
        launch(args);

    }

}
