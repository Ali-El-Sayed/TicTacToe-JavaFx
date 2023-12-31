package Network.Response;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ResponseHandler {

    public static NetworkResponse handleRegisterResponse(String jsonString) {
            return new Gson().fromJson(jsonString, NetworkResponse.class);
       
    }
}
