package ui;

import animation.Animation;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
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
    
   

    public static void switchToSelectMode(ActionEvent event ,Pane currentPane)  {
        Animation.animated(currentPane, new SelectModeBase(), event);
    }

    public static void switchToOfflineMode(ActionEvent event, Pane currentPane)  {
         
        Animation.animated(currentPane, new OfflineModeScreen(), event);
    }

    public static void switchToSplashScreen(ActionEvent event, Pane currentPane){
         Animation.animated(currentPane, new SplashScreenBase(), event);
    }

    public static void switchToSelectLevelScreen(ActionEvent event, Pane currentPane){
        
        Animation.animated(currentPane, new SelectLevelScreen(), event);
    }

    public static void switchToLogInSignUp(ActionEvent event, Pane currentPane) {
         Animation.animated(currentPane, new LoginsignupBase(), event);
    }

    public static void switchToSignUp(ActionEvent event, Pane currentPane)  {
        Animation.animated(currentPane, new SignupBase(), event);
    }

    public static void switchToLogIn(ActionEvent event, Pane currentPane)  {
        Animation.animated(currentPane, new LoginBase(), event);
    }

    public static void switchToGameBoard(ActionEvent event, Pane currentPane)  {
        Animation.animated(currentPane, new GameBoardScreen(), event);
    }

    public static void switchToAboutUs(ActionEvent event,Pane currentPane)  {
        Animation.animated(currentPane, new AboutUsBase(), event);
    }

    public void switchToAvailablePlayersScreen(ActionEvent event, Pane currentPane)  {
        Animation.animated(currentPane, new AvailablePlayersScreen(), event);
    }

    

}
