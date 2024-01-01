
package Network.Response.data;

import Network.Response.NetworkResponse;



public class AvailablePlayerData  {

    String username;
    int playerStatus;
    int id;

    public AvailablePlayerData(String username, int playerStatus, int id) {
        this.username = username;
        this.playerStatus = playerStatus;
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setplayerStatus(int playerStatus) {
        this.playerStatus = playerStatus;
    }
    
    public int getplayerStatus() {
        return playerStatus;
    }

    public String getUsername() {
        return username;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
