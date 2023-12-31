package Network.Request.data;

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

}
