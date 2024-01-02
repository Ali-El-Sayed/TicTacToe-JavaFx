package Network.Response;

import Network.Response.NetworkResponse.ResponseMode;
import com.google.gson.annotations.SerializedName;

public class NetworkResponse {

    protected String ip;
    private ResponseMode mode;
    private ResponseStatus responseStatus;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setResponseStatus(ResponseStatus status) {
        this.responseStatus = status;
    }

    public ResponseMode getMode() {
        return mode;
    }

    public void setMode(ResponseMode mode) {
        this.mode = mode;
    }

    public enum ResponseStatus {
        SUCCESS("success"),
        FAILURE("failure"),
        NOTFOUND("notfound");

        @SerializedName("status")
        private final String status;

        ResponseStatus(String status) {
            this.status = status;
        }

        public static ResponseStatus fromString(String modeString) {
            for (ResponseStatus rStatus : ResponseStatus.values()) {
                if (rStatus.status.equalsIgnoreCase(modeString)) {
                    return rStatus;
                }
            }
            return SUCCESS;
        }
    }

    public enum ResponseMode {
        LOGIN("LOGIN"),
        REGISTER("REGISTER"),
        AVAILABLE_PLAYERS("AVAILABLE_PLAYERS"),
        NONE("NONE");

        private final String mode;

        ResponseMode(String mode) {
            this.mode = mode;
        }

        public static ResponseMode fromString(String modeString) {
            for (ResponseMode mode : ResponseMode.values()) {
                if (mode.equals(modeString.replace("\"", ""))) {
                    System.out.println("Type  = " + mode + "\nvalue = " + modeString);
                    return mode;
                }
            }
            return NONE;
        }
    }

    @Override
    public String toString() {
        return "NetworkResponse{"
                + "ip='" + ip + '\''
                + ", mode = " + mode
                + ", responseStatus=" + responseStatus
                + '}';
    }
}
