package Network.Request.data;

public class NetworkRequest<T> {

    protected String ip;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public enum RequestType {
        LOGIN,
        LOGOUT,
        REGISTER,
        AVAILABLE_PLAYERS;
    }
}