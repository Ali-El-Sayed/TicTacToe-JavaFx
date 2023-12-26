
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

        Media media = new Media(new File("C:/Users/LEGION/Desktop/winnerVideo.mp4").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        Button playAgain = new GameButton("Play Again", GameButton.Mode.NORMAL, () -> { });
        
        playAgain.setPrefSize(250, 100);
        Button Back = new GameButton(GameButton.Mode.BACK, () -> {
            System.out.println("Back");
        });
        Back.setPrefSize(250, 100);

        HBox hBox = new HBox();
        HBox.setMargin(playAgain, new Insets(25.0, 40.0, 20.0, 20.0));
        HBox.setMargin(Back, new Insets(25.0, 0.0, 0.0, 0.0));
        hBox.getChildren().add(playAgain);
        hBox.getChildren().add(Back);

        BorderPane root = new BorderPane();
        root.setCenter(mediaView);
        BorderPane.setAlignment(mediaView, Pos.TOP_CENTER);

        root.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.TOP_LEFT);

        root.setBackground(new Background(new BackgroundImage(new Image("/assets/background.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));

        Scene scene = new Scene(root, 1200, 858);
        
        playAgain.setOnAction((event) -> {
            try {
                videoStage.close();
                
                new SceneController().switchToGameBoard(event);
            } catch (IOException ex) {
                Logger.getLogger(videoPopUp.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        videoStage.setScene(scene);
        videoStage.setResizable(false);
        videoStage.setOnCloseRequest(event -> {
            mediaPlayer.stop();
        });
        mediaPlayer.play();
        videoStage.showAndWait();
    }
}
