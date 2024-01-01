package ui.Screens;

import Network.Request.NetworkRequest;
import Network.Request.RequestHandler;
import Network.Request.data.AvailablePlayersRequest;
import Network.Response.ResponseHandler;
import Network.SocketConnection;
import Network.Response.data.AvailablePlayersResponse;
import Network.Response.data.AvailablePlayerData;
import data.LoggedInUser;
import java.io.IOException;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import ui.components.GameButton;
import ui.components.GameButton.Mode;
import ui.Screens.ListRow;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AvailablePlayersScreen extends VBox {

    protected Label topLabel;
    protected ListView<AvailablePlayerData> availablePlayers;
    private String currentUsername;
    AvailablePlayersResponse onlinePlayersList;
    //SocketConnection s;

    public AvailablePlayersScreen() {
         
           // s=new SocketConnection();
            handleAvailablePlayerRequest();
          
      
    }

    public AvailablePlayersScreen(String username) {
        this.currentUsername = username;
    }

    public  AvailablePlayersScreen (AvailablePlayersResponse onlinePlayersList) {

        this.onlinePlayersList = onlinePlayersList;
        System.out.println("Number of players: " + onlinePlayersList.playerData.size());
      

    }

private void setAvailablePlayersScreen() {
    
    topLabel = new Label();
    availablePlayers = new ListView<>();
    setStyle("-fx-background-image: url('/assets/background.png'); -fx-background-size: cover;");

    topLabel.setText("Find Opponents");
    topLabel.setStyle("-fx-font-family: 'Berlin Sans FB Bold'; -fx-font-size: 75.0;");

    availablePlayers.setPrefHeight(345.0);
    availablePlayers.setPrefWidth(600.0);
    availablePlayers.setStyle("-fx-background-color: transparent; -fx-control-inner-background: transparent;");
    availablePlayers.setCellFactory(param -> new PlayerListCell());

    // Check if onlinePlayersList is not null
    if (onlinePlayersList != null) {
        List<AvailablePlayerData> playerDataList = onlinePlayersList.playerData;

        // Check if playerDataList is not null
        if (playerDataList != null) {
            for (int i = 0; i < playerDataList.size(); i++) {
                AvailablePlayerData player = playerDataList.get(i);

                // Check if player is not null before adding to the list
                if (player != null) {
                    availablePlayers.getItems().add(player);
                } else {
                    // Handle the case where player is null, such as logging a message or skipping the null entry
                    System.out.println("Encountered null player at index " + i);
                }
            }
        } else {
            System.out.println("playerDataList is null");
        }
    } else {
        System.out.println("onlinePlayersList is null");
    }

    getChildren().addAll(topLabel, availablePlayers);
}


    private void handleAvailablePlayerRequest() {
        AvailablePlayersRequest networkRequest = new AvailablePlayersRequest();
        networkRequest.setRequestType(NetworkRequest.RequestType.AVAILABLE_PLAYERS);
        networkRequest.setRequestData(new AvailablePlayersRequest(LoggedInUser.getId()));

        String requestJson = RequestHandler.getJsonRequest(networkRequest);
        SocketConnection.getInstance().getSender().println(requestJson);
        setAvailablePlayersScreen();
       
        

        // Assume that you have a method to handle the response asynchronously
     //handleResponse();
    }
//    private void handleResponse(){
//        try {
//            String response= s.getInstance().getReceiver().readLine();
//            
//            AvailablePlayersResponse onlinePlayersList = ResponseHandler.getResponseObj(response);
//            setAvailablePlayersScreen();
//        } catch (IOException ex) {
//            Logger.getLogger(AvailablePlayersScreen.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }



    class PlayerListCell extends ListCell<AvailablePlayerData> {
        @Override

    protected void updateItem(AvailablePlayerData player, boolean empty) {
        System.out.println("in updateItem");
        super.updateItem(player, empty);
        if (empty || player == null) {
             System.out.println("empty");
            setText(null);
            setGraphic(null);
        } else {
            setText(player.getUsername());  // Display the username for testing
        }
    }

        private ListRow createPlayerBox(AvailablePlayerData player) {
            ImageView avatarImageView = new ImageView(new Image(getClass().getResourceAsStream("/assets/cricket-player.png")));
            avatarImageView.setFitWidth(50);
            avatarImageView.setFitHeight(50);

            Circle statusCircle = new Circle(8, player.getplayerStatus() == 0 ? Color.GREEN : Color.RED);
            statusCircle.setStroke(Color.BLACK);

            Label usernameLabel = new Label(player.getUsername());

            Button inviteButton = new GameButton("INVITE", Mode.NORMAL, () -> {
            });
            inviteButton.setMaxSize(150, 60);
            inviteButton.setOnAction(event -> {
                System.out.println("Inviting " + player.getUsername());
            });

            return new ListRow(avatarImageView, statusCircle, usernameLabel);
        }
    }
}
    