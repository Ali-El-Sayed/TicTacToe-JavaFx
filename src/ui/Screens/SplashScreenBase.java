package ui.Screens;

import java.awt.GraphicsConfiguration;
import java.io.IOException;
import static java.lang.System.gc;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.Stage;
import javafxtest.GameButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ui.SceneController;

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

    public SplashScreenBase(Stage stage) {

        imageView = new ImageView();
        borderPane = new BorderPane();
        label = new Label();
        flowPane = new FlowPane();
        play_btn = new GameButton("PLAY", GameButton.Mode.NORMAL, () -> {});
        imageView0 = new ImageView();
        about_btn = new GameButton("ABOUT", GameButton.Mode.NORMAL, () -> {
        });
        imageView1 = new ImageView();
        exit_btn = new GameButton("EXIT", GameButton.Mode.NORMAL, () -> {
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
        BorderPane.setMargin(label, new Insets(120.0, 0.0, 0.0, 0.0));
        borderPane.setTop(label);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.BOTTOM_CENTER);
        flowPane.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER);
        flowPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane.setPrefHeight(600.0);
        flowPane.setPrefWidth(500.0);
        flowPane.setVgap(80.0);

        play_btn.setAlignment(javafx.geometry.Pos.CENTER);
        play_btn.setMinHeight(38.0);
        play_btn.setMinWidth(100.0);
        play_btn.setPrefHeight(41.0);
        play_btn.setPrefWidth(0.0);
        play_btn.setCursor(Cursor.HAND);

        about_btn.setAlignment(javafx.geometry.Pos.CENTER);
        about_btn.setMinHeight(38.0);
        about_btn.setMinWidth(100.0);
        about_btn.setPrefHeight(41.0);
        about_btn.setPrefWidth(0.0);
        about_btn.setCursor(Cursor.HAND);
        
        exit_btn.setAlignment(javafx.geometry.Pos.CENTER);
        exit_btn.setMinHeight(38.0);
        exit_btn.setMinWidth(100.0);
        exit_btn.setPrefHeight(41.0);
        exit_btn.setPrefWidth(0.0);
        exit_btn.setCursor(Cursor.HAND);
        BorderPane.setMargin(flowPane, new Insets(0.0, 0.0, 150.0, 0.0));
        borderPane.setBottom(flowPane);

        getChildren().add(imageView);
        flowPane.getChildren().add(play_btn);
        flowPane.getChildren().add(about_btn);
        flowPane.getChildren().add(exit_btn);
        getChildren().add(borderPane);
        
        play_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SceneController s = new SceneController();
                try {
                    s.switchToSelectMode(event);
                } catch (IOException ex) {
                    Logger.getLogger(SplashScreenBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        exit_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        about_btn.setOnAction(new EventHandler<ActionEvent>() {
        @Override
            public void handle(ActionEvent Event){
                JFrame jframe = new JFrame();
                jframe.setMaximizedBounds(null);
                jframe.setSize(600, 300);
                String message = "TIC TAC TOE GAME V1.0 DEVELOPED BY INTAKE 44 NATIVE MOBILE DEVELOPMENT TRACK TEAM\nALI EL SAYED\nESRAA ASEM\nMINA THABET\nMOHAMED HUSSEIN\nSALMA MAHER";
                JOptionPane.showMessageDialog(jframe, message,"ABOUT",JOptionPane.INFORMATION_MESSAGE);
            }  
        });
    }
}
