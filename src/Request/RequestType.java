/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Request;

import com.google.gson.annotations.SerializedName;
/**
 *
 * @author esraa
 */
public enum RequestType {
    LOGIN("login_request"),
    REGISTER("register_request"),
    AVAILABLE_PLAYERS("available_players_request");
   @SerializedName("type")
    private String type;

    RequestType(String type) {
        this.type = type;
    }
}
