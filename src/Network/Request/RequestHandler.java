package Network.Request;

import Network.Request.data.NetworkRequest;
import com.google.gson.Gson;

public class RequestHandler {

    public static String getJsonRequest(NetworkRequest request) {
        return new Gson().toJson(request);
    }

 
}
