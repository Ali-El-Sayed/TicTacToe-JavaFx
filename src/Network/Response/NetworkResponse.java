package Network.Response;

import Network.Request.NetworkRequest.RequestType;
import com.google.gson.annotations.SerializedName;

public class NetworkResponse<T> {

    ResponseStatus status;
    @SerializedName("response")
    T responseInfo;
    RequestType responseType;

    public T getResponseInfo() {
        return responseInfo;
    }

    public void setResponseInfo(T responseInfo) {
        this.responseInfo = responseInfo;
    }
    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public RequestType getRespnseType() {
        return responseType;
    }

    public void setRespnseType(RequestType respnseType) {
        this.responseType = respnseType;
    }
    
    
    public enum ResponseStatus {
    SUCCESS("success"), 
    FAILURE("failure"),
    SERVER_ERROR("server_error");
    
    @SerializedName("status")
    private final String status;
    ResponseStatus(String status){
      this.status=status;
    }
    
}
}
