
package ui.Screens;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ui.SceneController;
import ui.components.GameButton;

public class videoPopUp {

    public static void openVideoPopUp() {
        Stage videoStage = new Stage();
        videoStage.initModality(Modality.APPLICATION_MODAL);
        videoStage.setTitle("Winning Celebrations");
        Media media = new Media(new File("src/assets/winnerVideo.mp4").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        BorderPane root = new BorderPane();
        root.setCenter(mediaView);
        BorderPane.setAlignment(mediaView, Pos.TOP_CENTER);
        root.setBackground(new Background(new BackgroundImage(new Image("/assets/background.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));
        Scene scene = new Scene(root, 1200, 700);
        videoStage.setScene(scene);
        videoStage.setResizable(false);
        videoStage.setOnCloseRequest(event -> {
            mediaPlayer.stop();
        });
        mediaPlayer.play();
        videoStage.showAndWait();
    }
}
