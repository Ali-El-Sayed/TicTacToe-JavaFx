package Network.Response.data;

import Network.Response.NetworkResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

public class LogInResponse extends NetworkResponse {

    private int id, wins, loses, draws, status;
    private String userName, email;

    public LogInResponse(String ip) {
        this.ip = ip;
        setMode(NetworkResponse.ResponseMode.LOGIN);
    }

    public LogInResponse() {
    }

    public LogInResponse(String[] values) {
        this.id = Integer.parseInt(values[0]);
        this.userName = values[1].replace("\"", "");
        this.email = values[2].replace("\"", "");
        this.wins = Integer.parseInt(values[3].replace("\"", ""));
        this.loses = Integer.parseInt(values[4].replace("\"", ""));
        this.draws = Integer.parseInt(values[5].replace("\"", ""));
        this.status = Integer.parseInt(values[6].replace("\"", ""));
        setIp(values[12].replace("\"", ""));
        setResponseStatus(ResponseStatus.fromString(values[13].replace("\"", "")));
        setMode(ResponseMode.fromString(values[14].replace("\"", "")));
    }

    public LogInResponse(String string, String json) {
        System.out.println("Network.Response.data.LogInResponse.<init>()" + json);
        JsonArray arr = new Gson().fromJson(json, JsonArray.class);
        id = Integer.parseInt(arr.get(0).toString().replace("\"", ""));
        setUserName(arr.get(1).toString().replace("\"", ""));
        setEmail(arr.get(2).toString().replace("\"", ""));
        setWins(Integer.parseInt(arr.get(3).toString().replace("\"", "")));
        setLoses(Integer.parseInt(arr.get(4).toString().replace("\"", "")));
        setDraws(Integer.parseInt(arr.get(5).toString().replace("\"", "")));
        setStatus(Integer.parseInt(arr.get(6).toString().replace("\"", "")));
        setIp(arr.get(12).toString().replace("\"", ""));
        setResponseStatus(ResponseStatus.fromString(arr.get(13).toString().replace("\"", "")));
        setMode(ResponseMode.fromString(arr.get(14).toString().replace("\"", "")));

    }

    public String[] toArray() {
        String[] values = new String[15];
        values[0] = String.valueOf(id);
        values[1] = userName;
        values[2] = email;
        values[3] = String.valueOf(wins);
        values[4] = String.valueOf(loses);
        values[5] = String.valueOf(draws);
        values[6] = String.valueOf(status);
        values[12] = getIp();
        values[13] = String.valueOf(getResponseStatus());
        values[14] = String.valueOf(getMode());
        return values;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    @Override
    public String toString() {
        return String.format(
                "PlayerInfo{id=%d, userName='%s', email='%s', wins=%d, loses=%d, draws=%d, status=%d , mode = %s, responseStatus=%s, ip=%s}",
                id, userName, email, wins, loses, draws, status, getMode(), getResponseStatus(), ip
        );
    }

}
