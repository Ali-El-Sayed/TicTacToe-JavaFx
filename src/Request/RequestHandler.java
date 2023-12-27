/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Request;

import com.google.gson.Gson;

/**
 *
 * @author esraa
 */
public class RequestHandler {
    public static String getRegisterRequest(String firstName, String lastName, String email, String password) {
        NetworkRequest<RegisterRequest> request = new NetworkRequest();
        request.setRequestType(RequestType.REGISTER);
        RegisterRequest requestData = new RegisterRequest(firstName,lastName,email,password);
        request.setRequestData(requestData);
        return new Gson().toJson(request);

    }
}
