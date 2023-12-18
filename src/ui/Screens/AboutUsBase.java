package ui.Screens;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import ui.SceneController;
import ui.components.GameButton;

public class AboutUsBase extends StackPane {

    protected final ImageView imageView;
    protected final BorderPane borderPane;
    protected final HBox hBox;
    protected final Button back_btn;
    protected final VBox vBox;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final Label label5;
    protected final Label label6;

    public AboutUsBase() {

        imageView = new ImageView();
        borderPane = new BorderPane();
        hBox = new HBox();
        //back_btn = new Button();
        back_btn = new GameButton(GameButton.Mode.BACK, () -> {
        });
        vBox = new VBox();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(858.0);
        setPrefWidth(1343.0);

        imageView.setFitHeight(858.0);
        imageView.setFitWidth(1343.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/background.png").toExternalForm()));

        borderPane.setPrefHeight(200.0);
        borderPane.setPrefWidth(200.0);

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        back_btn.setMinHeight(50.0);
        back_btn.setMinWidth(110.0);
        back_btn.setMnemonicParsing(false);
        back_btn.setPrefHeight(31.0);
        back_btn.setPrefWidth(90.0);
        back_btn.setCursor(Cursor.HAND);
        back_btn.setPadding(new Insets(0.0, 150.0, 0.0, 0.0));
        HBox.setMargin(back_btn, new Insets(0.0, 0.0, 0.0, 200.0));
        borderPane.setBottom(hBox);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(679.0);
        vBox.setPrefWidth(1343.0);

        label.setPrefHeight(102.0);
        label.setPrefWidth(1343.0);

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setPrefHeight(115.0);
        label0.setPrefWidth(1343.0);
        label0.setText("Welcome to our Tic Tac Toe Game");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#234d20"));
        label0.setFont(new Font("Berlin Sans FB Bold", 77.0));

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setPrefHeight(156.0);
        label1.setPrefWidth(1343.0);
        label1.setText("V1.0 DEVELOPED BY: ");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#396f35"));
        label1.setFont(new Font("Berlin Sans FB", 60.0));
        label1.setPadding(new Insets(0.0, 0.0, 50.0, 0.0));

        label2.setAlignment(javafx.geometry.Pos.CENTER);
        label2.setPrefHeight(78.0);
        label2.setPrefWidth(1343.0);
        label2.setText("Ali El Sayed");
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#234d20"));
        label2.setFont(new Font("Berlin Sans FB Bold", 60.0));

        label3.setAlignment(javafx.geometry.Pos.CENTER);
        label3.setPrefHeight(115.0);
        label3.setPrefWidth(1343.0);
        label3.setText("Mina Thabet ");
        label3.setTextFill(javafx.scene.paint.Color.valueOf("#234d20"));
        label3.setFont(new Font("Berlin Sans FB Bold", 60.0));

        label4.setAlignment(javafx.geometry.Pos.CENTER);
        label4.setPrefHeight(115.0);
        label4.setPrefWidth(1343.0);
        label4.setText("Mohamed Hussein");
        label4.setTextFill(javafx.scene.paint.Color.valueOf("#234d20"));
        label4.setFont(new Font("Berlin Sans FB Bold", 60.0));

        label5.setAlignment(javafx.geometry.Pos.CENTER);
        label5.setPrefHeight(115.0);
        label5.setPrefWidth(1343.0);
        label5.setText("Israa Assem");
        label5.setTextFill(javafx.scene.paint.Color.valueOf("#234d20"));
        label5.setFont(new Font("Berlin Sans FB Bold", 60.0));

        label6.setAlignment(javafx.geometry.Pos.CENTER);
        label6.setPrefHeight(80.0);
        label6.setPrefWidth(1343.0);
        label6.setText("Salma Maher");
        label6.setTextFill(javafx.scene.paint.Color.valueOf("#234d20"));
        label6.setFont(new Font("Berlin Sans FB Bold", 60.0));
        borderPane.setCenter(vBox);

        getChildren().add(imageView);
        hBox.getChildren().add(back_btn);
        vBox.getChildren().add(label);
        vBox.getChildren().add(label0);
        vBox.getChildren().add(label1);
        vBox.getChildren().add(label2);
        vBox.getChildren().add(label3);
        vBox.getChildren().add(label4);
        vBox.getChildren().add(label5);
        vBox.getChildren().add(label6);
        getChildren().add(borderPane);
        back_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SceneController sceneController = new SceneController();
                try {
                    sceneController.switchToSplashScreen(event);
                } catch (IOException ex) {
                    Logger.getLogger(SelectModeBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
