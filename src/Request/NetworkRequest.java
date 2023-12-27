/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Request;

/**
 *
 * @author esraa
 * @param <T>
 */
public class NetworkRequest <T>{
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
    
}
