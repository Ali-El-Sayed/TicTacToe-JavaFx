

package data;



public class LoggedInUser {
    private static int id , wins,loses,draws,status;
    private static String userName,email;

    public static int getId() {
        return id;
    }

    public static int getWins() {
        return wins;
    }

    public static int getLoses() {
        return loses;
    }

    public static int getDraws() {
        return draws;
    }

    public static int getStatus() {
        return status;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getEmail() {
        return email;
    }

    public static void setId(int id) {
        LoggedInUser.id = id;
    }

    public static void setWins(int wins) {
        LoggedInUser.wins = wins;
    }

    public static void setLoses(int loses) {
        LoggedInUser.loses = loses;
    }

    public static void setDraws(int draws) {
        LoggedInUser.draws = draws;
    }

    public static void setStatus(int status) {
        LoggedInUser.status = status;
    }

    public static void setUserName(String userName) {
        LoggedInUser.userName = userName;
    }

    public static void setEmail(String email) {
        LoggedInUser.email = email;
    }

    
    
}
    

