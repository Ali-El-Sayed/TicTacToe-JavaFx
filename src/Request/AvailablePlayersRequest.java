/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Request;

/**
 *
 * @author p&p
 */
public class AvailablePlayersRequest {
    private String username;

    public AvailablePlayersRequest(String username) {
        this.username=username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    
    
    
}
