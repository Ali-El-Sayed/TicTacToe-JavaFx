package ui.Screens;


import data.Pc;
import javafx.event.ActionEvent;
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
import ui.SceneController;
import ui.components.GameButton;

public class SelectLevelScreen extends VBox {

    protected final HBox hBox;
    protected final Label headerL;
    protected final HBox hBox0;
    protected final Button btnEasy;
    protected final Button btnIntermediate;
    protected final Button btnHard;
    protected final HBox hBox1;
    protected final Button btnBack;

    public SelectLevelScreen() {

        hBox = new HBox();
        headerL = new Label();
        hBox0 = new HBox();
        btnEasy = new GameButton("Easy", GameButton.Mode.NORMAL, () -> {
        });
        btnEasy.setOnAction((e) -> {
            SceneController.switchToSinglePlayerBoard(e, this,new Pc(Pc.Level.EASY));
        });
        btnIntermediate = new GameButton("Intermediate", GameButton.Mode.NORMAL, () -> {
        });
        btnHard = new GameButton("Hard", GameButton.Mode.NORMAL, () -> {
        });
        hBox1 = new HBox();
        btnBack = new GameButton(GameButton.Mode.BACK, () -> {
        });
        btnBack.setOnAction((ActionEvent event) -> {
             SceneController.switchToOfflineMode(event, this);
        });

        Image img = new Image(getClass().getResourceAsStream("/assets/background.png"));
        BackgroundImage backgroundImg = new BackgroundImage(img,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        Background bg = new Background(backgroundImg);
        setBackground(bg);

        setAlignment(javafx.geometry.Pos.CENTER);
        setFillWidth(false);
        setMaxHeight(858);
        setMaxWidth(1343);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(858);
        setPrefWidth(1343);

        VBox.setVgrow(hBox, javafx.scene.layout.Priority.ALWAYS);
        hBox.setAccessibleRole(javafx.scene.AccessibleRole.BUTTON);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(1345.0);

        headerL.setAlignment(javafx.geometry.Pos.CENTER);
        headerL.setText("Select Level");
        headerL.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        headerL.setFont(new Font("Berlin Sans FB Bold", 150.0));

        VBox.setVgrow(hBox0, javafx.scene.layout.Priority.SOMETIMES);
        hBox0.setAlignment(javafx.geometry.Pos.CENTER);
        hBox0.setPrefHeight(100.0);
        hBox0.setPrefWidth(1345.0);
        hBox0.setSpacing(100.0);

        btnIntermediate.setLayoutX(66.0);
        btnIntermediate.setLayoutY(10.0);

        btnHard.setLayoutX(576.0);
        btnHard.setLayoutY(44.0);

        VBox.setVgrow(hBox1, javafx.scene.layout.Priority.ALWAYS);
        hBox1.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        hBox1.setFillHeight(false);
        hBox1.setPrefHeight(100.0);
        hBox1.setPrefWidth(1300.0);

        hBox1.setPadding(new Insets(0.0, 0.0, 20.0, 0.0));

        hBox.getChildren().add(headerL);
        getChildren().add(hBox);
        hBox0.getChildren().add(btnEasy);
        hBox0.getChildren().add(btnIntermediate);
        hBox0.getChildren().add(btnHard);
        getChildren().add(hBox0);
        hBox1.getChildren().add(btnBack);
        getChildren().add(hBox1);

    }
}
