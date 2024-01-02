/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation {

    static Stage stage;

    public static void animated(Pane currentPane, Parent nextScene, ActionEvent event) {
        FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(500), currentPane);
        fadeOutTransition.setFromValue(1);
        fadeOutTransition.setToValue(0);
        fadeOutTransition.setOnFinished(e -> {
            Scene newScene = new Scene(nextScene);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        });
        fadeOutTransition.play();
    }

}
