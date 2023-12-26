package DataBase;

import java.sql.ResultSet;

public interface UserDao {
    void getUserData(int Id , DaoCallback<ResultSet> callback);
    void getDataForLogin(String email, DaoCallback<ResultSet> callback);
    void addNewUser(int id,DaoCallback<Integer> callback);
    void updateScore(int id , int isWin , DaoCallback<Integer> callback);
}
