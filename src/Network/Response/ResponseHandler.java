package Network.Response;

import Network.Response.data.RegisterResposne;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ResponseHandler {

    public static NetworkResponse handleRegisterResponse(String jsonString) {
        JsonElement jsonElement = JsonParser.parseString(jsonString);

        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            return new Gson().fromJson(jsonString, NetworkResponse.class);

        }
        return new NetworkResponse();
    }
    
    public static String getRegisterResponseJson(RegisterResposne registerResposne) {

        return new Gson().toJson(registerResposne);
    }

    public static RegisterResposne getRegisterResponseObj(String json) {

        return new Gson().fromJson(json, RegisterResposne.class);
    }
}
