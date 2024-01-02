package ui;

import Network.SocketConnection;
import Recording.RecordDatabase;
import data.Pc;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.Screens.HistoryBase;
import ui.Screens.ReplayScreen;
import ui.Screens.SignupBase;
import ui.Screens.SinglePlayer;
import ui.Screens.SplashScreenBase;

public class TicTacToe extends Application {

    @Override
    public void start(Stage stage) {
        Parent root = new SplashScreenBase();
        Scene scene = new Scene(root, 1343, 858);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
    }

    @Override
    public void stop() throws Exception {
        super.stop(); 
       new SocketConnection(0).closeConnection();
    }
    
    

    public static void main(String[] args) throws IOException {
        launch(args);

    }

}
