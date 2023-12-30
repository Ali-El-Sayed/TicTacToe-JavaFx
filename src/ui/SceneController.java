package ui;

import animation.Animation;
import data.Pc;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
import ui.Screens.SinglePlayer;

import ui.Screens.SplashScreenBase;

public class SceneController {

  private Stage stage;
  private Scene scene;
  private Parent root;

  public static void switchToSelectMode(ActionEvent event, Pane currentPane) {
    Animation.animated(currentPane, new SelectModeBase(), event);
  }

  public static void switchToOfflineMode(ActionEvent event, Pane currentPane) {

    Animation.animated(currentPane, new OfflineModeScreen(), event);
  }

  public static void switchToSplashScreen(ActionEvent event, Pane currentPane) {
    Animation.animated(currentPane, new SplashScreenBase(), event);
  }

  public static void switchToSelectLevelScreen(ActionEvent event, Pane currentPane) {

    Animation.animated(currentPane, new SelectLevelScreen(), event);
  }

  public static void switchToLogInSignUp(ActionEvent event, Pane currentPane) {
    Animation.animated(currentPane, new LoginsignupBase(), event);
  }

  public static void switchToSignUp(ActionEvent event, Pane currentPane) {
    Animation.animated(currentPane, new SignupBase(), event);
  }

  public static void switchToLogIn(ActionEvent event, Pane currentPane) {
    Animation.animated(currentPane, new LoginBase(), event);
  }

  public static void switchToGameBoard(ActionEvent event, Pane currentPane) {
    Animation.animated(currentPane, new GameBoardScreen(), event);
  }

  public static void switchToAboutUs(ActionEvent event, Pane currentPane) {
    Animation.animated(currentPane, new AboutUsBase(), event);
  }

  public static void switchToAvailablePlayersScreen(ActionEvent event, Pane currentPane) {
    Animation.animated(currentPane, new AvailablePlayersScreen(), event);
  }
  
  public static void switchToSinglePlayerBoard(ActionEvent event, Pane currentPane, Pc pc) {
    Animation.animated(currentPane, new SinglePlayer(pc), event);
  }
}
