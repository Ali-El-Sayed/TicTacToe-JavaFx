package ui.Screens;

import Recording.RecordDatabase;
import com.sun.org.apache.regexp.internal.recompile;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import ui.SceneController;
import ui.components.GameButton;

public class HistoryBase extends VBox {

    protected final Label label;
    protected final ListView recordList;
    ResultSet rs;

    class Record {

        public int id;
        public String date;

        public Record(int id, String date) {
            this.id = id;
            this.date = date;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

    }
    RecordDatabase db ;
    public HistoryBase() {

        db = new RecordDatabase();
        rs = db.getData();
        Button exitBnt = new GameButton("Exit",GameButton.Mode.BACK);
        label = new Label();
        recordList = new ListView();

        setAlignment(javafx.geometry.Pos.CENTER);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(858.0);
        setPrefWidth(1343.0);
        setStyle("-fx-background-image: url('/assets/background.png'); -fx-background-size: cover;");

        label.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        label.setPrefHeight(43.0);
        label.setPrefWidth(1343);
        label.setAlignment(Pos.CENTER);
        label.setText("History");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        VBox.setMargin(label, new Insets(0.0, 0.0, 10.0, 0.0));
        label.setFont(new Font("Berlin Sans FB Bold", 52.0));

        recordList.setStyle("-fx-background-color: transparent; -fx-control-inner-background: transparent;");
        recordList.setCellFactory(param -> new RecordListCell());
        recordList.setPrefHeight(858.0);
        recordList.setPrefWidth(1343.0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            while (rs.next()) {
                Date d = new Date();

                recordList.getItems().add(new Record(rs.getInt(1), String.valueOf(rs.getDate(3))));

            }
        } catch (SQLException ex) {
            Logger.getLogger(HistoryBase.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        
        exitBnt.setOnAction((ActionEvent event) -> {
            SceneController.switchToSplashScreen(event, this);
        });
        getChildren().add(label);
        getChildren().add(recordList);
        setAlignment(Pos.BOTTOM_LEFT);
        getChildren().add(exitBnt);

    }

    class RecordListCell extends ListCell<Record> {

        @Override
        protected void updateItem(Record item, boolean empty) {
            super.updateItem(item, empty);
            this.setAlignment(Pos.CENTER);

            if (empty || item == null) {
                setText(null);
                setGraphic(null);
            } else {
                RecordRowBase recordGrid = recordRow(item);
                setGraphic(recordGrid);
                recordGrid.playBtn.setOnAction(event -> {
                    ResultSet resultSet = db.getDataForReplay(item.getId());
                    try {
                        resultSet.next();
                        String m = resultSet.getString(2);
                        SceneController.switchToReplay(event, recordGrid, m);
                    } catch (SQLException ex) {
                        Logger.getLogger(HistoryBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                });
            }
        }

        private RecordRowBase recordRow(Record record) {

            Text id = new Text(String.valueOf(record.getId()));
            Text date = new Text(String.valueOf(record.getDate()));
            Button play = new GameButton("Play", GameButton.Mode.NORMAL, () -> {
                
            });
            play.setMaxSize(150, 60);
            

            RecordRowBase recordRowBase = new RecordRowBase(id, date);
            return recordRowBase;
        }

    }
}
