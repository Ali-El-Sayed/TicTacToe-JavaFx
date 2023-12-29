package ui.Screens;

import java.io.File;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import ui.SceneController;
import ui.components.GameButton;

public class VideoScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final MediaView congratsVideo;
    protected final Label WinnerLabel;
    protected final Label winnerName;
    protected final Button back_btn;
    protected final File file;
    protected final Media media;
    protected final MediaPlayer mediaPlayer;
    public VideoScreenBase() {
        AnchorPane anchorPane =this;
        imageView = new ImageView();
        congratsVideo = new MediaView();
        WinnerLabel = new Label();
        winnerName = new Label();
        back_btn = new GameButton(GameButton.Mode.BACK, () -> {
        });
         back_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 SceneController.switchToGameBoard(event,anchorPane);
            }
        });
        setId("AnchorPane");
        setPrefHeight(858.0);
        setPrefWidth(1343.0);

        imageView.setFitHeight(858.0);
        imageView.setFitWidth(1343.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/background.png").toExternalForm()));

        congratsVideo.setFitHeight(800.0);
        congratsVideo.setFitWidth(1343.0);
        congratsVideo.setLayoutY(80.0);

        WinnerLabel.setLayoutX(468.0);
        WinnerLabel.setPrefHeight(69.0);
        WinnerLabel.setPrefWidth(237.0);
        WinnerLabel.setText("Winner  : ");
        WinnerLabel.setTextFill(javafx.scene.paint.Color.valueOf("#234d20"));
        WinnerLabel.setFont(new Font("Berlin Sans FB Bold", 50.0));

        winnerName.setLayoutX(707.0);
        winnerName.setPrefHeight(34.0);
        winnerName.setPrefWidth(274.0);
        winnerName.setText("Israa");
        winnerName.setTextFill(javafx.scene.paint.Color.valueOf("#234d20"));
        winnerName.setFont(new Font("Berlin Sans FB Bold", 50.0));

        back_btn.setLayoutX(90.0);
        back_btn.setLayoutY(20.0);
        back_btn.setMinHeight(50.0);
        back_btn.setMinWidth(110.0);
        back_btn.setMnemonicParsing(false);
        back_btn.setPrefHeight(31.0);
        back_btn.setPrefWidth(90.0);
        back_btn.setCursor(Cursor.HAND);
        back_btn.setPadding(new Insets(0.0, 150.0, 0.0, 0.0));

        getChildren().add(imageView);
        
        getChildren().add(WinnerLabel);
        getChildren().add(winnerName);
        getChildren().add(back_btn);
        // --add-modules javafx.controls,javafx.media
        file =new File("C:/Users/LEGION/Desktop/winnerVideo.mp4");
        media=new Media(file.toURI().toString());
        mediaPlayer=new MediaPlayer(media);
        congratsVideo.setMediaPlayer(mediaPlayer);
        getChildren().add(congratsVideo);
         mediaPlayer.play();
    
    }
    
    
    
    
}
