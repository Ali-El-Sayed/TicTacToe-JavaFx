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

public class SplashScreenBase extends StackPane {

    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final BorderPane borderPane;
    protected final Label label;
    protected final FlowPane flowPane;
    protected final Button play_btn;
    protected final Button about_btn;
    protected final Button exit_btn;

    public SplashScreenBase() {

        imageView = new ImageView();
        borderPane = new BorderPane();
        label = new Label();
        flowPane = new FlowPane();
        play_btn = new GameButton("Play", GameButton.Mode.NORMAL, () -> {
        });
        imageView0 = new ImageView();
        about_btn = new GameButton("About", GameButton.Mode.NORMAL, () -> {
        });
        imageView1 = new ImageView();
        exit_btn = new GameButton("Exit", GameButton.Mode.NORMAL, () -> {
        });

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(858.0);
        setPrefWidth(1343.0);

        StackPane.setAlignment(imageView, javafx.geometry.Pos.CENTER);
        imageView.setFitHeight(858.0);
        imageView.setFitWidth(1343.0);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getResource("/assets/background.png").toExternalForm()));

        borderPane.setMaxHeight(USE_PREF_SIZE);
        borderPane.setMaxWidth(USE_PREF_SIZE);
        borderPane.setMinHeight(USE_PREF_SIZE);
        borderPane.setMinWidth(USE_PREF_SIZE);
        borderPane.setPrefHeight(858.0);
        borderPane.setPrefWidth(1343.0);

        BorderPane.setAlignment(label, javafx.geometry.Pos.CENTER);
        label.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        label.setPrefHeight(203.0);
        label.setPrefWidth(984.0);
        label.setText("TIC TAC TOE!");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setFont(new Font("Berlin Sans FB Bold", 150.0));
        BorderPane.setMargin(label, new Insets(-10.0, 0.0, 0.0, 0.0));
        borderPane.setTop(label);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER);
        flowPane.setMinHeight(500.0);
        flowPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane.setPrefHeight(500.0);
        flowPane.setPrefWidth(100.0);
        flowPane.setVgap(80.0);

        play_btn.setAlignment(javafx.geometry.Pos.CENTER);
        play_btn.setMinHeight(38.0);
        play_btn.setMinWidth(100.0);
        play_btn.setPrefHeight(41.0);
        play_btn.setPrefWidth(0.0);
        play_btn.setCursor(Cursor.HAND);

        about_btn.setMaxHeight(50.0);
        about_btn.setMaxWidth(138.0);
        about_btn.setMinHeight(21.0);
        about_btn.setMinWidth(100.0);
        about_btn.setPrefHeight(32.0);
        about_btn.setPrefWidth(0.0);
        about_btn.setCursor(Cursor.HAND);

        exit_btn.setMaxHeight(71.0);
        exit_btn.setMaxWidth(148.0);
        exit_btn.setMinHeight(21.0);
        exit_btn.setMinWidth(100.0);
        exit_btn.setPrefHeight(39.0);
        exit_btn.setPrefWidth(0.0);
        exit_btn.setCursor(Cursor.HAND);
        BorderPane.setMargin(flowPane, new Insets(0.0, 0.0, 150.0, 0.0));
        borderPane.setBottom(flowPane);

        getChildren().add(imageView);
        flowPane.getChildren().add(play_btn);
        flowPane.getChildren().add(about_btn);
        flowPane.getChildren().add(exit_btn);
        getChildren().add(borderPane);

    }
}
