package ui.Screens;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import  ui.components.GameButton;
import ui.SceneController;
import ui.components.GameButton;

public class OfflineModeScreen extends VBox {

    protected final HBox hBox;
    protected final Label headerL;
    protected final HBox hBox0;
    protected final Button btnVsComputer;
    protected final Button btnTwoPlayer;
    protected final HBox hBox1;
    protected final Button btnBack;

    public OfflineModeScreen() {

        hBox = new HBox();
        headerL = new Label();
        hBox0 = new HBox();
        btnVsComputer = new GameButton("VS COMPUTER", GameButton.Mode.NORMAL, () -> {
        });
        btnTwoPlayer = new GameButton("TWO PLAYERS", GameButton.Mode.NORMAL, () -> {
        });
        btnBack = new GameButton(GameButton.Mode.BACK, () -> {
        });
        hBox1 = new HBox();
        setAlignment(javafx.geometry.Pos.CENTER);
        setFillWidth(false);
        setMaxHeight(858);
        setMaxWidth(1343);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(858);
        setPrefWidth(1343);

        Image img = new Image(getClass().getResourceAsStream("/assets/background.png"));
        BackgroundImage backgroundImg = new BackgroundImage(img,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        Background bg = new Background(backgroundImg);
        setBackground(bg);

        VBox.setVgrow(hBox, javafx.scene.layout.Priority.ALWAYS);
        hBox.setAccessibleRole(javafx.scene.AccessibleRole.BUTTON);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(1345.0);

        headerL.setAlignment(javafx.geometry.Pos.CENTER);
        headerL.setText("Offline Mode");
        headerL.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        headerL.setFont(new Font("Berlin Sans FB Bold", 150.0));

        VBox.setVgrow(hBox0, javafx.scene.layout.Priority.SOMETIMES);
        hBox0.setAlignment(javafx.geometry.Pos.CENTER);
        hBox0.setPrefHeight(100.0);
        hBox0.setPrefWidth(1345.0);
        hBox0.setSpacing(100.0);

        btnTwoPlayer.setLayoutX(66.0);
        btnTwoPlayer.setLayoutY(10.0);

        VBox.setVgrow(hBox1, javafx.scene.layout.Priority.ALWAYS);
        hBox1.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        hBox1.setFillHeight(false);
        hBox1.setPrefHeight(100.0);
        hBox1.setPrefWidth(1300.0);

        hBox1.setPadding(new Insets(0.0, 0.0, 20.0, 0.0));

        hBox.getChildren().add(headerL);
        getChildren().add(hBox);
        hBox0.getChildren().add(btnVsComputer);
        hBox0.getChildren().add(btnTwoPlayer);
        getChildren().add(hBox0);
        hBox1.getChildren().add(btnBack);
        getChildren().add(hBox1);
         
        btnVsComputer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SceneController sceneController = new SceneController();
                try {
                    sceneController.switchToSelectLevelScreen(event);
                } catch (IOException ex) {
                    Logger.getLogger(SelectModeBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnTwoPlayer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            }
        });
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SceneController sceneController = new SceneController();
                try {
                    sceneController.switchToSelectMode(event);
                } catch (IOException ex) {
                    Logger.getLogger(SelectModeBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
    }
}
