package DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseDao implements UserDao {
    
    private UserDB db = null;


    public DataBaseDao() {
        db = UserDB.getInstance();
    }

    @Override
    public void getUserData(int id, DaoCallback<ResultSet> callback) {
        db.connect();
        try {
            String query = "select * from player where id = ?";
            PreparedStatement pst = db.con.prepareStatement(query);
            pst.setString(1, String.valueOf(id));
            callback.onSuccess(pst.executeQuery());
            pst.close();
            db.con.close();
        } catch (SQLException ex) {
            System.out.println("Player not found please register");
            callback.onFailure(ex);
            
        }
    }

    @Override
    public void addNewUser(String id,DaoCallback<Integer> callback){
        db.connect();
        try {
            String query = "Insert into player Value(?)";
            PreparedStatement pst = db.con.prepareStatement(query);
            pst.setString(1, id);
            callback.onSuccess(pst.executeUpdate());
            pst.close();
            db.con.close();
        } catch (SQLException ex) {  
            System.out.println("User already in defined please LogIn");
            callback.onFailure(ex);
        }
      
    }
    @Override
    public void updateScore(int id , int isWin , DaoCallback<Integer> callback){
         db.connect();
         int win = 0 ,  lose = 0 , draw =0;
         if (isWin == 1) {
            win = 1;
        }
         try {
            String query = "update player set wins = wins + ?  , loses = loses + ? , draws = draws + ? where id = ?";
            PreparedStatement pst = db.con.prepareStatement(query);
            pst.setString(1, String.valueOf(win));
            pst.setString(2, String.valueOf(lose));
            pst.setString(3, String.valueOf(draw));
            pst.setString(4, String.valueOf(id));
            callback.onSuccess(pst.executeUpdate());
            pst.close();
            db.con.close();
        } catch (SQLException ex) {  
            System.out.println("Can't add new player");
            callback.onFailure(ex);
        }
    }

    @Override
    public void getDataForLogin(String email, DaoCallback<ResultSet> callback) {
        db.connect();
        try {
            String query = "select Email,Password from player where email = ?";
            PreparedStatement pst = db.con.prepareStatement(query);
            pst.setString(1, email);
            callback.onSuccess(pst.executeQuery());
            pst.close();
            db.con.close();
        } catch (SQLException ex) {
            System.out.println("Player not found please register");
            callback.onFailure(ex);
        }
    }
}
