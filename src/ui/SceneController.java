
package ui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import ui.Screens.GameBoardFXML;
import ui.Screens.LoginBase;
import ui.Screens.LoginsignupBase;
import ui.Screens.OfflineModeScreen;
import ui.Screens.SelectLevelScreen;
import ui.Screens.SelectModeBase;
import ui.Screens.SignupBase;
import ui.Screens.SplashScreenBase;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void switchToSelectMode(ActionEvent event) throws IOException{
        root = new SelectModeBase();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToOfflineMode(ActionEvent event) throws IOException{
        root = new OfflineModeScreen();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSplashScreen(ActionEvent event) throws IOException{
        root = new SplashScreenBase(stage);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSelectLevelScreen(ActionEvent event) throws IOException{
        root = new SelectLevelScreen();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
     public void switchToLogInSignUp(ActionEvent event) throws IOException{
        root = new LoginsignupBase();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
     public void switchToSignUp(ActionEvent event) throws IOException{
        root = new SignupBase();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToLogIn(ActionEvent event) throws IOException{
        root = new LoginBase();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToGameBoard(ActionEvent event) throws IOException{
        root = new GameBoardFXML();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

