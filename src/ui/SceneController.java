package ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.Screens.AboutUsBase;
import ui.Screens.AvailablePlayersScreen;
import ui.Screens.GameBoardScreen;
import ui.Screens.LoginBase;
import ui.Screens.LoginsignupBase;
import ui.Screens.OfflineModeScreen;
import ui.Screens.SelectLevelScreen;
import ui.Screens.SelectModeBase;
import ui.Screens.SignupBase;
import ui.Screens.SplashScreenBase;
import ui.Screens.VideoScreenBase;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToSelectMode(ActionEvent event) throws IOException {
        root = new SelectModeBase();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToOfflineMode(ActionEvent event) throws IOException {
        root = new OfflineModeScreen();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSplashScreen(ActionEvent event) throws IOException {
        root = new SplashScreenBase();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSelectLevelScreen(ActionEvent event) throws IOException {
        root = new SelectLevelScreen();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToLogInSignUp(ActionEvent event) throws IOException {
        root = new LoginsignupBase();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSignUp(ActionEvent event) throws IOException {
        root = new SignupBase();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToLogIn(ActionEvent event) throws IOException {
        root = new LoginBase();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToGameBoard(ActionEvent event) throws IOException {
        root = new GameBoardScreen();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAboutMode(ActionEvent event) throws IOException {
        root = new AboutUsBase();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAvailablePlayersScreen(ActionEvent event) throws IOException {
        root = new AvailablePlayersScreen();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToVideoScreen(ActionEvent event) throws IOException {
        root = new VideoScreenBase();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        Platform.runLater(() -> {
            try {
                Thread.sleep(1000);
                stage.setScene(scene);
                stage.show();
            } catch (InterruptedException ex) {
                Logger.getLogger(SceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

}
