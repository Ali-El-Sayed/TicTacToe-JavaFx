package Network.Response;

import com.google.gson.annotations.SerializedName;

public class NetworkResponse<T> {

    private ResponseMode mode;
    private ResponseStatus status;
    private T data;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseMode getMode() {
        return mode;
    }

    public void setMode(ResponseMode mode) {
        this.mode = mode;
    }

    public enum ResponseStatus {
        SUCCESS("success"),
        FAILURE("failure");
        @SerializedName("status")
        private final String status;

        ResponseStatus(String status) {
            this.status = status;
        }
    }

    public enum ResponseMode {
        LOGIN("ssss"),
        REGISTER("REGISTER"),
        AVAILABLE_PLAYERS("AVAILABLE_PLAYERS");
        @SerializedName("MODE")
        private final String mode;

        ResponseMode(String mode) {
            this.mode = mode;
        }

        public String getMode() {
            return this.mode;
        }
    }
}
