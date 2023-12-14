package ui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.Screens.SelectLevelScreen;

public class TicTacToe extends Application {

    @Override
    public void start(Stage stage) throws Exception {

//        Parent root = FXMLLoader.load(getClass().getResource("/ui/Screens/selectMode.fxml"));
        Parent root = new SelectLevelScreen();

        Scene scene = new Scene(root, 1343, 858);
        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
