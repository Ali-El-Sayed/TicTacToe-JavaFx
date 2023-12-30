package Network.Request.data;

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
        LOGIN,
        LOGOUT,
        REGISTER,
        AVAILABLE_PLAYERS;
    }
}
