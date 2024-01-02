package ui.Screens;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import ui.components.GameButton;

public class RecordRowBase extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final Button playBtn; 
    protected final Text recordDate;
    protected final Text recordId;

    public RecordRowBase(Text id , Text recordDate) {

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        
        this.recordDate = recordDate;
        this.recordId = id;
        this.playBtn = new GameButton("play",GameButton.Mode.NORMAL, ()->{});
        playBtn.setPrefSize(130, 65);
        playBtn.setStyle("-fx-background-color: transparent;");
        
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(100.0);
        setPrefWidth(600.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        
        GridPane.setColumnIndex(playBtn, 3);
        GridPane.setHalignment(playBtn, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(playBtn, javafx.geometry.VPos.CENTER);
        playBtn.setMnemonicParsing(false);
        
        
        GridPane.setColumnIndex(recordDate, 1);
        recordDate.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        recordDate.setStrokeWidth(0.0);
        
        recordDate.setWrappingWidth(187.6708984375);
        GridPane.setMargin(recordDate, new Insets(0.0, 0.0, 0.0, 10.0));
        recordDate.setFont(new Font("Berlin Sans FB Bold", 18.0));

        recordId.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        recordId.setStrokeWidth(0.0);
        
        recordId.setWrappingWidth(171.6708984375);
        recordId.setFont(new Font("Berlin Sans FB Bold", 24.0));
        GridPane.setMargin(recordId, new Insets(0.0, 0.0, 0.0, 15.0));
        setCursor(Cursor.HAND);

        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getColumnConstraints().add(columnConstraints1);
        getRowConstraints().add(rowConstraints);
        
        getChildren().add(recordDate);
        getChildren().add(recordId);
        getChildren().add(playBtn);
    }
}
