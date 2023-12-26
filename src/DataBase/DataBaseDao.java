package DataBase;

import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseDao implements UserDao {

    private UserDB db = null;

    public DataBaseDao() {
        db = UserDB.getInstance();
        db.connect();
    }

    @Override
    public void getUserData(int id, DaoCallback<ResultSet> callback) {
        try {
            String query = "select * from player where id = ?";
            PreparedStatement pst = db.con.prepareStatement(query);
            pst.setInt(1, id);
            callback.onSuccess(pst.executeQuery());
            pst.close();
        } catch (SQLException ex) {
            System.out.println("Player not found please register");
            callback.onFailure(ex);
        }
    }

    @Override
    public void addNewUser(int id, DaoCallback<Integer> callback) {
        try {
            String query = "Insert into player Value(?)";
            PreparedStatement pst = db.con.prepareStatement(query);
            pst.setInt(1, id);
            callback.onSuccess(pst.executeUpdate());
            pst.close();
        } catch (SQLException ex) {
            System.out.println("User already in defined please LogIn");
            callback.onFailure(ex);
        }
    }
    @Override
    public void updateScore(int id, int isWin, DaoCallback<Integer> callback) {
        int win = 0, lose = 0, draw = 0;
        if (isWin == 1) {
            win = 1;
        }
        try {
            String query = "update player set wins = wins + ?  , loses = loses + ? , draws = draws + ? where id = ?";
            PreparedStatement pst = db.con.prepareStatement(query);
            pst.setInt(1, win);
            pst.setInt(2, lose);
            pst.setInt(3, draw);
            pst.setInt(4, id);
            callback.onSuccess(pst.executeUpdate());
            pst.close();
        } catch (SQLException ex) {
            System.out.println("Can't add new player");
            callback.onFailure(ex);
        }
    }

    @Override
    public void getDataForLogin(String email, DaoCallback<ResultSet> callback) {
        try {
            String query = "select Email,Password from player where email = ?";
            PreparedStatement pst = db.con.prepareStatement(query);
            pst.setString(1, email);
            callback.onSuccess(pst.executeQuery());
            pst.close();
        } catch (SQLException ex) {
            System.out.println("Player not found please register");
            callback.onFailure(ex);
        }
    }
    @Override
    public void getAllPlayer(DaoCallback<ResultSet> callback){
        
    }
    
}
