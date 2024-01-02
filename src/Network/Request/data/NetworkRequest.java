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
        LOGIN("LOGIN"),
        REGISTER("REGISTER"),
        AVAILABLE_PLAYERS("AVAILABLE_PLAYERS"),
        NONE("NONE");

        String type = "";

        private RequestType(String s) {
            this.type = s;
        }

        public static RequestType fromString(String typeString) {
            for (RequestType type : RequestType.values()) {
                if (type.equals(typeString.replace("\"", ""))) {
                    System.out.println("Type  = " + type + "\nvalue = " + typeString);
                    return type;
                }
            }
            return NONE;
        }

    }
}
