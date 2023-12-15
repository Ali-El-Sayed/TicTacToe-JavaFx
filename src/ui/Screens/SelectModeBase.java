package ui.Screens;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import ui.components.GameButton;

public class SelectModeBase extends StackPane {

    protected final ImageView imageView;
    protected final BorderPane borderPane;
    protected final HBox hBox;
    protected final Button btnOfflineMode;
    protected final Button btnOnlineMode;
    protected final Text text;
    protected final HBox hBox0;
    protected final Button btnBack;

    public SelectModeBase() {

        imageView = new ImageView();
        borderPane = new BorderPane();
        hBox = new HBox();
        btnOfflineMode = new GameButton("Offline", GameButton.Mode.NORMAL, () -> {

            System.out.println("test btn");

        }
        );
        btnOnlineMode = new GameButton("Online", GameButton.Mode.NORMAL,() -> {
            System.out.println("Online");
        });
        text = new Text();
        hBox0 = new HBox();
        btnBack = new GameButton(GameButton.Mode.BACK, () -> {
            System.out.println("Back");
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
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/background.png").toExternalForm()));

        borderPane.setPrefHeight(200.0);
        borderPane.setPrefWidth(200.0);

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        btnOfflineMode.setMinHeight(50.0);
        btnOfflineMode.setMinWidth(110.0);
        btnOfflineMode.setMnemonicParsing(false);
        btnOfflineMode.setPrefHeight(31.0);
        btnOfflineMode.setPrefWidth(90.0);
        btnOfflineMode.setCursor(Cursor.HAND);
        btnOfflineMode.setPadding(new Insets(0.0, 150.0, 0.0, 0.0));
        HBox.setMargin(btnOfflineMode, new Insets(0.0, 250.0, 0.0, 0.0));

        btnOnlineMode.setMinHeight(50.0);
        btnOnlineMode.setMinWidth(150.0);
        btnOnlineMode.setMnemonicParsing(false);
        btnOnlineMode.setPrefHeight(31.0);
        btnOnlineMode.setPrefWidth(93.0);
        btnOnlineMode.setCursor(Cursor.HAND);
        borderPane.setCenter(hBox);

        BorderPane.setAlignment(text, javafx.geometry.Pos.CENTER);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Select Mode ");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(1270.65576171875);
        text.setFont(new Font("Berlin Sans FB Bold", 75.0));
        BorderPane.setMargin(text, new Insets(50.0, 0.0, 0.0, 0.0));
        borderPane.setTop(text);

        BorderPane.setAlignment(hBox0, javafx.geometry.Pos.CENTER);
        hBox0.setPrefHeight(100.0);
        hBox0.setPrefWidth(200.0);

        btnBack.setMinHeight(50.0);
        btnBack.setMinWidth(110.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(31.0);
        btnBack.setPrefWidth(90.0);
        btnBack.setCursor(Cursor.HAND);
        btnBack.setPadding(new Insets(0.0, 150.0, 0.0, 0.0));
        HBox.setMargin(btnBack, new Insets(0.0, 0.0, 0.0, 200.0));
        borderPane.setBottom(hBox0);

        getChildren().add(imageView);
        hBox.getChildren().add(btnOfflineMode);
        hBox.getChildren().add(btnOnlineMode);
        hBox0.getChildren().add(btnBack);
        getChildren().add(borderPane);

    }
}
