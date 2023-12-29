package Network.Request;

public class NetworkRequest<T> {

    RequestType requestType;
    T requestData;

    public T getRequestData() {
        return requestData;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public void setRequestData(T requestData) {
        this.requestData = requestData;
    }

    public enum RequestType {
        LOGIN("LOGIN_REQUEST"),
        REGISTER("REGISTER_REQUEST"),
        AVAILABLE_PLAYERS("AVAILABLE_PLAYERS_REQUEST");
        private String type;

        RequestType(String type) {
            this.type = type;
        }
    }

}
