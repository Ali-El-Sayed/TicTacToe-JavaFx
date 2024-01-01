package Network.Response;

import Network.Response.data.AvailablePlayerData;
import Network.Response.data.AvailablePlayersResponse;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;


import java.util.List;



public class ResponseHandler {
    
    public static String handleAvailablePlayersResponse(AvailablePlayerData responseList) {
        Gson gson = new Gson();
        return gson.toJson(responseList);
    }
    private static <T> NetworkResponse<T> parseJson(String json) {
        Gson gson = new Gson();
        TypeToken<NetworkResponse<T>> typeToken = new TypeToken<NetworkResponse<T>>() {
        };
        return gson.fromJson(json, typeToken.getType());
    }
//    public static NetworkResponse getResponseFromJsom(String json) {
//        return processResponse(json);
//    }
    
//       public static NetworkResponse processAvailablePlayerResponse(String responseData) {
//        return new Gson().fromJson(responseData, AvailablePlayerData.class);
//    }
//    
//    private static NetworkResponse processResponse(String networkResponse) {
//        NetworkResponse response = parseJson(networkResponse);
//
//        switch (response.responseType) {
//            case AVAILABLE_PLAYERS:
//                return processAvailablePlayerResponse(networkResponse);
//            default:
//                return response;
//        }
//    }
    
    public static AvailablePlayersResponse getResponseObj(String json) {

        return new Gson().fromJson(json, AvailablePlayersResponse.class);
    }
}

