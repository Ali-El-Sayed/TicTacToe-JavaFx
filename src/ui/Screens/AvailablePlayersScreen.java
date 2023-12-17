package ui.Screens;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import ui.components.GameButton;
import ui.components.GameButton.Mode;

public  class AvailablePlayersScreen extends VBox {

    protected final Label topLabel;
    protected final ListView availablePlayers;
    
    public class Player {
        public String username;
        public String avatarPath;
        public boolean online;

        public Player(String username, String avatarPath, boolean online) {
            this.username = username;
            this.avatarPath = avatarPath;
            this.online = online;
        }

        public String getUsername() {
            return username;
        }

        public String getAvatarPath() {
            return avatarPath;
        }

        public boolean isOnline() {
            return online;
        }
    }

    public AvailablePlayersScreen() {

        topLabel = new Label();
        availablePlayers = new ListView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(858.0);
        setPrefWidth(1343.0);
        setStyle("-fx-background-image: url('/assets/background.png'); -fx-background-size: cover;");

        topLabel.setText("Find Opponents");
        topLabel.setFont(new Font("Berlin Sans FB Bold", 75.0));

        availablePlayers.setPrefHeight(345.0);
        availablePlayers.setPrefWidth(600.0);
        availablePlayers.setStyle("-fx-background-color: transparent; -fx-control-inner-background: transparent;");
        availablePlayers.setCellFactory(param -> new PlayerListCell());
        Player player1 = new Player("John Doe", "/assets/cricket-player.png", true);
        Player player2 = new Player("salmamaher", "/assets/cricket-player.png", false);
        Player player3 = new Player("AhmedSamy", "/assets/cricket-player.png", true);


        availablePlayers.getItems().addAll(player1, player2, player3);
        setAlignment(javafx.geometry.Pos.CENTER);
     
        getChildren().add(topLabel);
        getChildren().add(availablePlayers);

    }
     class PlayerListCell extends ListCell<Player> {
         
        @Override
        protected void updateItem(Player player, boolean empty) {
            super.updateItem(player, empty);
            this.setAlignment(Pos.CENTER);

            if (empty || player == null) {
                setText(null);
                setGraphic(null);
            } else {
               // HBox playerGrid = createPlayerBox(player);
                setGraphic(new ListRow());
            }
        }

     /*   private HBox createPlayerBox(Player player) {
            ImageView avatarImageView = new ImageView(new Image(getClass().getResourceAsStream(player.getAvatarPath())));
            avatarImageView.setFitWidth(50);
            avatarImageView.setFitHeight(50);

            Circle statusCircle = new Circle(8, player.isOnline() ? Color.GREEN : Color.RED);
            statusCircle.setStroke(Color.BLACK);

            Label usernameLabel = new Label(player.getUsername());

            Button inviteButton = new GameButton("INVITE",Mode.NORMAL,()->{});
            inviteButton.setMaxSize(150, 60);
            inviteButton.setOnAction(event -> {
                System.out.println("Inviting " + player.getUsername());
            });
            inviteButton.setStyle("-fx-background-color: transparent; -fx-min-width: 80px; -fx-min-height: 30px; -fx-max-width: 80px; -fx-max-height: 30px;");
            HBox playerBox = new HBox(avatarImageView, statusCircle, usernameLabel, inviteButton);
            
            playerBox.setAlignment(Pos.CENTER);
            playerBox.setSpacing(30);
            playerBox.setBackground(Background.EMPTY);
 
            HBox.setMargin(inviteButton, new javafx.geometry.Insets(50, 10, 10, 10));
            

            return playerBox;
        }*/
    }
}






