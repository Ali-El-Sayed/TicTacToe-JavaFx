package Network.Request.data;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

public class LoginRequest extends NetworkRequest {

    private String email;
    private String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
        setRequestType(NetworkRequest.RequestType.LOGIN);
    }

    public LoginRequest(String json) {
        JsonArray values = new Gson().fromJson(json, JsonArray.class);
        String valuesArr[] = new String[15];

        valuesArr[0] = values.get(0).toString();
        valuesArr[1] = values.get(1).toString();
        valuesArr[12] = values.get(12).toString();
        valuesArr[14] = values.get(14).toString();

        setEmail(valuesArr[0]);
        setPassword(valuesArr[1]);
        setIp(valuesArr[12]);
        setRequestType(NetworkRequest.RequestType.fromString(valuesArr[14]));
    }

    public String[] toArray() {
        String[] arr = new String[15];
        for (int i = 0; i < 15; i++) {
            arr[i] = "   ";
        }
        arr[0] = getEmail();
        arr[1] = getPassword();
        arr[12] = getIp();
        arr[14] = this.getRequestType().toString();

        return arr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "email='" + email + '\''
                + ", password=" + password
                + '}';
    }

}
