package Network.Response;

import Network.Response.data.LogInResponse;
import Network.Response.data.RegisterResposne;
import com.google.gson.Gson;

public class ResponseHandler {

    public static String getRegisterResponseJson(RegisterResposne registerResposne) {

        return new Gson().toJson(registerResposne);
    }

    public static LogInResponse getLogInResponseObj(String json) {
        return new Gson().fromJson(json, LogInResponse.class);
    }

    public static RegisterResposne getRegisterResponseObj(String json) {

        return new Gson().fromJson(json, RegisterResposne.class);
    }
}
