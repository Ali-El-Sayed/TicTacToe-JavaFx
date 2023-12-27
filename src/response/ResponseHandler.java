/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package response;

import com.google.gson.Gson;

/**
 *
 * @author esraa
 */
public class ResponseHandler {

    public static RegisterResponse handleRegisterResponse(String rawResponse) {
        Gson gson = new Gson();
     
        RegisterResponse registerResponse;
       
        registerResponse = gson.fromJson(rawResponse, RegisterResponse.class);
      
        return registerResponse;
     
}}
