/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network.Request.data;
import Network.Request.NetworkRequest;

/**
 *
 * @author esraa
 */
public class AvailablePlayersRequest extends NetworkRequest{
    private int userId;
    
    public AvailablePlayersRequest(){
        
    }

    public AvailablePlayersRequest(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    
    
    
}
