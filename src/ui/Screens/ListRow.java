package ui.Screens;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Circle;
import ui.components.GameButton;
import ui.components.GameButton.Mode;

public  class ListRow extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final RowConstraints rowConstraints;
    protected final ImageView avatarLabel;
    protected final Circle statusLabel;
    protected final Button inviteLabel;
    protected final Label usernameLabel;

    public ListRow(ImageView avatarImageView, Circle statusCircle, Label usernameLabel) {
        
     
    
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        this.avatarLabel = avatarImageView;
        
        this.statusLabel = statusCircle;
        this.inviteLabel = new GameButton("INVITE",Mode.NORMAL,()->{});
        inviteLabel.setPrefSize(130, 65);
        inviteLabel.setStyle("-fx-background-color: transparent;");
        this.usernameLabel = usernameLabel; 
        
        

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(100.0);
        setPrefWidth(700.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(avatarLabel, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(avatarLabel, javafx.geometry.VPos.CENTER);
        avatarLabel.setFitHeight(72.0);
        avatarLabel.setFitWidth(113.0);
        avatarLabel.setPickOnBounds(true);
        avatarLabel.setPreserveRatio(true);
        avatarLabel.setImage(new Image(getClass().getResource("/assets/cricket-player.png").toExternalForm()));

        GridPane.setColumnIndex(statusLabel, 1);
        GridPane.setHalignment(statusLabel, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(statusLabel, javafx.geometry.VPos.CENTER);
        statusLabel.setFill(statusLabel.getFill());
        statusLabel.setRadius(10.0);
        statusLabel.setStroke(javafx.scene.paint.Color.BLACK);
        statusLabel.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        GridPane.setColumnIndex(inviteLabel, 3);
        GridPane.setHalignment(inviteLabel, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(inviteLabel, javafx.geometry.VPos.CENTER);
        inviteLabel.setMnemonicParsing(false);


        GridPane.setColumnIndex(usernameLabel, 2);
        GridPane.setHalignment(usernameLabel, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(usernameLabel, javafx.geometry.VPos.CENTER);
        usernameLabel.setText(usernameLabel.getText());
        usernameLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");
        setMargin(inviteLabel, new Insets(0, 0, 0, 80));


        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getColumnConstraints().add(columnConstraints1);
        getColumnConstraints().add(columnConstraints2);
        getRowConstraints().add(rowConstraints);
        getChildren().add(avatarLabel);
        getChildren().add(statusLabel);
        getChildren().add(usernameLabel);
        getChildren().add(inviteLabel);
        
        

    }
}
