package ui.Screens;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import ui.components.GameButton;

public class LoginsignupBase extends StackPane {

    protected final ImageView imageView;
    protected final BorderPane borderPane;
    protected final FlowPane flowPane;
    protected final Button signin_btn;
    protected final Button signup_btn;
    protected final Label label;
    protected final FlowPane flowPane0;
    protected final Button back_btn;

    public LoginsignupBase() {

        imageView = new ImageView();
        borderPane = new BorderPane();
        flowPane = new FlowPane();
        signin_btn = new GameButton("Sign in", GameButton.Mode.NORMAL, () -> {
        });
        signup_btn = new GameButton("Sign up", GameButton.Mode.NORMAL, () -> {
        });
        label = new Label();
        flowPane0 = new FlowPane();
        back_btn = new GameButton("", GameButton.Mode.BACK, () -> {
        });

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(858.0);
        setPrefWidth(1343.0);

        imageView.setFitHeight(858.0);
        imageView.setFitWidth(1343.0);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getResource("/assets/background.png").toExternalForm()));

        borderPane.setPrefHeight(200.0);
        borderPane.setPrefWidth(200.0);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setAlignment(javafx.geometry.Pos.CENTER);
        flowPane.setMinHeight(500.0);
        flowPane.setMinWidth(500.0);
        flowPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane.setPrefHeight(500.0);
        flowPane.setPrefWidth(500.0);
        flowPane.setVgap(130.0);

        signin_btn.setMinHeight(10.0);
        signin_btn.setMinWidth(10.0);
        signin_btn.setMnemonicParsing(false);
        signin_btn.setPrefHeight(37.0);
        signin_btn.setPrefWidth(138.0);
        signin_btn.setCursor(Cursor.HAND);

        signup_btn.setMinHeight(10.0);
        signup_btn.setMinWidth(10.0);
        signup_btn.setMnemonicParsing(false);
        signup_btn.setPrefHeight(45.0);
        signup_btn.setPrefWidth(144.0);
        signup_btn.setCursor(Cursor.HAND);
        BorderPane.setMargin(flowPane, new Insets(-50.0, 260.0, 0.0, 0.0));
        borderPane.setCenter(flowPane);

        BorderPane.setAlignment(label, javafx.geometry.Pos.CENTER);
        label.setText("TIC TAC TOE!");
        label.setFont(new Font("Berlin Sans FB Bold", 150.0));
        borderPane.setTop(label);

        BorderPane.setAlignment(flowPane0, javafx.geometry.Pos.CENTER);
        flowPane0.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        flowPane0.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane0.setPrefHeight(278.0);
        flowPane0.setPrefWidth(130.0);

        back_btn.setMinHeight(20.0);
        back_btn.setMinWidth(20.0);
        back_btn.setMnemonicParsing(false);
        back_btn.setPrefHeight(21.0);
        back_btn.setPrefWidth(58.0);
        FlowPane.setMargin(back_btn, new Insets(0.0, 0.0, 10.0, 15.0));
        back_btn.setCursor(Cursor.HAND);
        BorderPane.setMargin(flowPane0, new Insets(0.0, 0.0, 50.0, 90.0));
        borderPane.setLeft(flowPane0);

        getChildren().add(imageView);
        flowPane.getChildren().add(signin_btn);
        flowPane.getChildren().add(signup_btn);
        flowPane0.getChildren().add(back_btn);
        getChildren().add(borderPane);

    }
}
