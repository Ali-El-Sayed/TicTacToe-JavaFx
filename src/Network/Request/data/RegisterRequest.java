package Network.Request.data;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

public class RegisterRequest extends NetworkRequest {

    private String userName;
    private String email;
    private String password;

    public RegisterRequest(String userName, String email, String password) {
        this.requestType = NetworkRequest.RequestType.REGISTER;
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    public RegisterRequest(String json) {
        JsonArray values = new Gson().fromJson(json, JsonArray.class);
        String valuesArr[] = new String[15];

        valuesArr[0] = values.get(0).toString();
        valuesArr[1] = values.get(1).toString();
        valuesArr[2] = values.get(2).toString();
        valuesArr[12] = values.get(12).toString();
        valuesArr[14] = values.get(14).toString();

        setUserName(valuesArr[0]);
        setEmail(valuesArr[1]);
        setPassword(valuesArr[2]);
        setIp(valuesArr[12]);
        setRequestType(NetworkRequest.RequestType.fromString(valuesArr[14]));
    }

    public String[] toArray() {
        String[] values = new String[15];
        values[0] = userName;
        values[1] = email;
        values[2] = password;
        values[12] = getIp();
        values[14] = String.valueOf(RequestType.REGISTER);
        return values;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        return "RegisterRequest{"
                + "userName='" + userName + '\''
                + ", email='" + email + '\''
                + ", password='" + password + '\''
                + '}';
    }
}
