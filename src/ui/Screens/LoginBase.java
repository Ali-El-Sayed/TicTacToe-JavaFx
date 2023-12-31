package ui.Screens;

import Network.Request.data.NetworkRequest;
import Network.Request.RequestHandler;
import Network.Request.data.LoginRequest;
import Network.SocketConnection;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import ui.SceneController;
import ui.components.GameButton;

public class LoginBase extends StackPane {

    protected final ImageView imageView;
    protected final BorderPane borderPane;
    protected final Label label;
    protected final FlowPane flowPane;
    protected final FlowPane flowPane0;
    protected final Button back_btn;
    protected final Button login_btn;
    protected final Label label0;
    protected final TextField email_tf;
    protected final PasswordField password_tf;
    protected final Label label1;

    public LoginBase() {

        imageView = new ImageView();
        borderPane = new BorderPane();
        label = new Label();
        flowPane = new FlowPane();
        flowPane0 = new FlowPane();
        back_btn = new GameButton("", GameButton.Mode.BACK, () -> {
        });
        back_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {                    
                 SceneController.switchToLogInSignUp(event, borderPane);
            }
        });
        login_btn = new GameButton("Login", GameButton.Mode.NORMAL, () -> {
        });
        login_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Login BTN ");
//                    new SceneController().switchToAvailablePlayersScreen(event);
                NetworkRequest<LoginRequest> networkRequest = new NetworkRequest<>();
                networkRequest.setRequestType(NetworkRequest.RequestType.LOGIN);
                networkRequest.setRequestData(new LoginRequest(email_tf.getText(), password_tf.getText()));
                String requestJson = RequestHandler.getJsonRequest(networkRequest);
                System.out.println(requestJson);
                SocketConnection.getInstance().getSender().println(requestJson);

                // navigation 
                //  SceneController.switchToAboutUs(event, borderPane);
                
            }
        });
        label0 = new Label();
        email_tf = new TextField();
        password_tf = new PasswordField();
        label1 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(858.0);
        setPrefWidth(1343.0);

        StackPane.setAlignment(imageView, javafx.geometry.Pos.CENTER);
        imageView.setFitHeight(858.0);
        imageView.setFitWidth(1343.0);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getResource("/assets/background.png").toExternalForm()));

        BorderPane.setAlignment(label, javafx.geometry.Pos.CENTER);
        label.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        label.setPrefHeight(218.0);
        label.setPrefWidth(590.0);
        label.setText("TIC TAC TOE!");
        label.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label.setFont(new Font("Berlin Sans FB Bold", 75.0));
        borderPane.setTop(label);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane.setPrefHeight(329.0);
        flowPane.setPrefWidth(625.0);
        borderPane.setCenter(flowPane);

        BorderPane.setAlignment(flowPane0, javafx.geometry.Pos.BOTTOM_LEFT);
        flowPane0.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        flowPane0.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane0.setPrefHeight(200.0);
        flowPane0.setPrefWidth(200.0);
        flowPane0.setRowValignment(javafx.geometry.VPos.BOTTOM);

        back_btn.setMinHeight(20.0);
        back_btn.setMinWidth(20.0);
        back_btn.setMnemonicParsing(false);
        back_btn.setPrefHeight(21.0);
        back_btn.setPrefWidth(58.0);
        FlowPane.setMargin(back_btn, new Insets(0.0, 0.0, -2.0, 90.0));
        back_btn.setCursor(Cursor.HAND);
        borderPane.setLeft(flowPane0);

        BorderPane.setAlignment(login_btn, javafx.geometry.Pos.CENTER);
        login_btn.setMinHeight(50.0);
        login_btn.setMinWidth(150.0);
        login_btn.setMnemonicParsing(false);
        login_btn.setPrefHeight(31.0);
        login_btn.setPrefWidth(93.0);
        BorderPane.setMargin(login_btn, new Insets(-50.0, 0.0, 55.0, 0.0));
        login_btn.setCursor(Cursor.HAND);
        borderPane.setBottom(login_btn);

        label0.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        label0.setPrefHeight(206.0);
        label0.setPrefWidth(459.0);
        label0.setText("Email");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("Berlin Sans FB Bold", 34.0));
        StackPane.setMargin(label0, new Insets(-15.0, 0.0, 0.0, 0.0));

        StackPane.setAlignment(email_tf, javafx.geometry.Pos.CENTER);
        email_tf.setMaxWidth(453.0);
        email_tf.setMinHeight(40.0);
        email_tf.setMinWidth(0.0);
        email_tf.setPrefHeight(49.0);
        email_tf.setPrefWidth(0.0);
        StackPane.setMargin(email_tf, new Insets(-85.0, 10.0, 0.0, 0.0));
        email_tf.setCursor(Cursor.TEXT);
        email_tf.setFont(new Font("Berlin Sans FB Demi Bold", 20.0));

        password_tf.setMaxWidth(453.0);
        password_tf.setMinHeight(40.0);
        password_tf.setMinWidth(0.0);
        password_tf.setPrefHeight(49.0);
        password_tf.setPrefWidth(0.0);
        StackPane.setMargin(password_tf, new Insets(130.0, 0.0, 0.0, 0.0));

        label1.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        label1.setPrefHeight(20.0);
        label1.setPrefWidth(464.0);
        label1.setText("Password");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("Berlin Sans FB Bold", 34.0));
        StackPane.setMargin(label1, new Insets(40.0, -5.0, 0.0, 0.0));

        getChildren().add(imageView);
        flowPane0.getChildren().add(back_btn);
        getChildren().add(borderPane);
        getChildren().add(label0);
        getChildren().add(email_tf);
        getChildren().add(password_tf);
        getChildren().add(label1);
        validateLogin(email_tf, password_tf);
    }

    public void validateLogin(TextField emailTF, TextField passwordTF) {
        final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Label emailLabel = new Label();
        emailLabel.setTextFill(javafx.scene.paint.Color.RED);
        Label passwordLabel = new Label("Please enter your password");
        passwordLabel.setTextFill(javafx.scene.paint.Color.RED);
        emailLabel.setVisible(false);
        passwordLabel.setVisible(false);
        emailLabel.setPrefWidth(260);
        passwordLabel.setPrefWidth(260);
        StackPane.setMargin(emailLabel, new Insets(-10.0, 180.0, 0.0, 0.0));
        StackPane.setMargin(passwordLabel, new Insets(210.0, 180.0, 0.0, 0.0));
        getChildren().add(emailLabel);
        getChildren().add(passwordLabel);
//        login_btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                if (emailTF.getText().isEmpty()) {
//                    emailLabel.setText("Please enter your email address");
//                    emailLabel.setVisible(true);
//                } else if ((!emailTF.getText().matches(EMAIL_REGEX)) && (!emailTF.getText().isEmpty())) {
//                    emailLabel.setText("Please enter a valid email address");
//                    emailLabel.setVisible(true);
//                } else {
//                    emailLabel.setVisible(false);
//                }
//                if (passwordTF.getText().isEmpty()) {
//                    passwordLabel.setText("Please enter your password");
//                    passwordLabel.setVisible(true);
//                } else if ((passwordTF.getText().length() < 8) && (!passwordTF.getText().isEmpty())) {
//                    passwordLabel.setText("Password must be at least 8 characters");
//                    passwordLabel.setVisible(true);
//                } else {
//                    passwordLabel.setVisible(false);
//                }
//            }
//        });
//    }
    }
}
