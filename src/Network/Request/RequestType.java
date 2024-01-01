/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network.Request;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author p&p
 */
public enum RequestType {
    LOGIN("login_request"),
    REGISTER("register_request"),
    AVAILABLE_PLAYERS("available_players_request");
   @SerializedName("type")
    private final String type;
    RequestType(String type) {
        this.type = type;
    }
}