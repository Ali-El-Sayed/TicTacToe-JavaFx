
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;


public final class UserDB {
    private static UserDB udb=null;
    public Connection con =null;
    
    private UserDB(){
        try {
            DriverManager.registerDriver(new ClientDriver());       
        } catch (SQLException e) {
            System.out.println("can't register");
        }
    }
    
    public static UserDB getInstance(){
        if (udb == null) {
           return new UserDB();
        }
        return udb;
    }
    
    final void connect(){
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDb", "root", "root");
        } catch (SQLException ex) {
            System.out.println("can't connect to server database");
        }
    }
}
