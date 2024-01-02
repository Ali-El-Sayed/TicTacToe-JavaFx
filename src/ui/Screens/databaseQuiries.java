package ui.Screens;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;

class DatabaseQueries {

    public DatabaseQueries() {
        try {
            DriverManager.registerDriver(new ClientDriver());
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Tic-Tac-Toe", "root", "root");

            PreparedStatement pst1 = con.prepareStatement("INSERT INTO Player (playerId,userName,Email,password,status,wins,loses,draws) "
                    + "VALUES (23, 'Israa', 'israa@gmail', '123', true, 0, 0, 0)");

            pst1.executeUpdate();

            System.out.println("Data inserted successfully.");

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new DatabaseQueries();
    }
}
