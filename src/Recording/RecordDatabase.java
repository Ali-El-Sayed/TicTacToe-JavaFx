/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recording;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;

public class RecordDatabase {

    private Connection conn;
    private Statement stmt;
    private static RecordDatabase recordDatabase;

    private RecordDatabase() {
        try {
            DriverManager.registerDriver(new ClientDriver());
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDb", "root", "root");
        } catch (SQLException ex) {
            System.out.println("ERROR IN DATABASE CONNECTION");
        }
    }
    
    public static RecordDatabase getInstance(){
        if(recordDatabase == null){
            recordDatabase = new RecordDatabase();
        }
        return recordDatabase;
    }
    
    

    public ResultSet getData() {
        try {

            String queryString = "select * from RECORDING";
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stmt.executeQuery(queryString);

            return rs;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

    }

    public ResultSet getDataForReplay(int id) {
        try {
            String queryString = "select * from RECORDING WHERE Id = "+id;
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(queryString);
            
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void setData(String moves) {
        try {
            String queryString = "insert into RECORDING (moves) Values(?) ";
            PreparedStatement pst = conn.prepareStatement(queryString);
            pst.setString(1, moves);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
