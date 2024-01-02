package Network.Request;

import Network.Request.data.LoginRequest;
import Network.Request.data.NetworkRequest;
import com.google.gson.Gson;

public class RequestHandler {

    public static String getJsonRequest(NetworkRequest request) {
        return new Gson().toJson(request);
    }

    public static String getLoginRequestJson(LoginRequest loginRequest) {
        return new Gson().toJson(loginRequest);
    }

}
