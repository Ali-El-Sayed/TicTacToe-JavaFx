package ui.Screens;

import Network.Request.data.RegisterRequest;
import Network.Response.NetworkResponse;
import Network.Response.data.LogInResponse;
import Network.SocketConnection;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import ui.SceneController;
import ui.components.GameButton;

public class SignupBase extends StackPane {

    protected final ImageView imageView = new ImageView();
    protected final BorderPane borderPane = new BorderPane();
    protected final Label label = new Label();
    protected final FlowPane flowPane = new FlowPane();
    protected final Label label0 = new Label();
    protected final Label usernameLabel = new Label();
    protected final Label emailLabel = new Label();
    protected final Label passwordLabel = new Label();

    protected final TextField fname_tf = new TextField();
    protected final Label label1 = new Label();
    protected final TextField lname_tf = new TextField();
    protected final TextField username_tf = new TextField();
    protected final Label label2 = new Label();
    protected final TextField email_tf = new TextField();
    protected final Label label3 = new Label();
    protected final PasswordField password_tf = new PasswordField();
    protected final TextField passwordrevealed_tf = new TextField();
    protected final FlowPane flowPane0 = new FlowPane();
    protected final Button back_btn = new GameButton(
            "",
            GameButton.Mode.BACK,
            () -> {
            }
    );
    protected final FlowPane flowPane1 = new FlowPane();
    protected final Button signup_btn = new GameButton(
            "Sign up",
            GameButton.Mode.NORMAL,
            () -> {
            }
    );
    protected final Button passreveal_btn = new Button();
    protected final ImageView imageView0 = new ImageView();
    protected boolean togglePass = false;
    protected boolean togglePassField = false;

    public SignupBase() {
        setupLayout();

        back_btn.setOnAction(
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SceneController.switchToLogInSignUp(event, borderPane);
            }
        }
        );

        signup_btn.setOnAction(
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (validateEntries(
                        username_tf,
                        email_tf,
                        password_tf,
                        passwordrevealed_tf
                )) {
                    RegisterRequest networkRequest = new RegisterRequest(
                            username_tf.getText(),
                            email_tf.getText(),
                            password_tf.getText()
                    );
                    networkRequest.setIp(SocketConnection.getInstance().getLocalIp());
                    String requestJson = new Gson().toJson(networkRequest.toArray());
                    System.out.println(requestJson);
                    SocketConnection.getInstance().getSender().println(requestJson);
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
                    String s = "";
                    try {
                        s = SocketConnection.getInstance().getReceiver().readLine();
                    } catch (IOException ex) {
                        Logger.getLogger(SignupBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("response in signup" + s.replace("\\\"", ""));
//                    s = s.replace("\\\"", "");
                    LogInResponse logInResponseObj = new LogInResponse("", s);

                    System.err.println(event);
                    if (logInResponseObj.getResponseStatus() == NetworkResponse.ResponseStatus.SUCCESS) {
                        SceneController.switchToAvailablePlayersScreen(event, borderPane);
                            
                    } else {
                        System.out.println("Wrong Data");
                    }
                }
            }
        }
        );
        passreveal_btn.setOnAction(
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                revealPassword(password_tf, passwordrevealed_tf);
            }
        }
        );
    }

    private void setupLayout() {
        flowPane1.setAlignment(Pos.BOTTOM_CENTER);
        flowPane1.setAlignment(Pos.BOTTOM_CENTER);
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
        imageView.setImage(
                new Image(
                        getClass().getResource("/assets/background.png").toExternalForm()
                )
        );

        borderPane.setMaxHeight(Double.MAX_VALUE);
        borderPane.setMaxWidth(Double.MAX_VALUE);
        borderPane.setMinHeight(858.0);
        borderPane.setMinWidth(1343.0);
        borderPane.setPrefHeight(858.0);
        borderPane.setPrefWidth(1343.0);

        BorderPane.setAlignment(label, javafx.geometry.Pos.CENTER);
        label.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        label.setPrefHeight(218.0);
        label.setPrefWidth(764.0);
        label.setText("TIC TAC TOE!");
        label.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label.setFont(new Font("Berlin Sans FB Bold", 120.0));
        BorderPane.setMargin(label, new Insets(-10.0, 0.0, 0.0, 0.0));
        borderPane.setTop(label);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setMinHeight(700.0);
        flowPane.setMinWidth(400.0);
        flowPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane.setPrefHeight(200.0);
        flowPane.setPrefWidth(200.0);
        flowPane.setVgap(50.0);

        label0.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        label0.setPrefHeight(50.0);
        label0.setPrefWidth(350.0);
        label0.setText("Username");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("Berlin Sans FB Bold", 45.0));

        username_tf.setMaxWidth(650.0);
        username_tf.setMinHeight(60.0);
        username_tf.setMinWidth(0.0);
        username_tf.setPrefHeight(30.0);
        username_tf.setPrefWidth(0.0);
        username_tf.setFont(new Font("Berlin Sans FB Bold", 24.0));
        FlowPane.setMargin(username_tf, new Insets(-30.0, 0.0, 0.0, 0.0));

        label2.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        label2.setPrefHeight(50.0);
        label2.setPrefWidth(350.0);
        label2.setText("Email Address");
        label2.setTextFill(javafx.scene.paint.Color.WHITE);
        label2.setFont(new Font("Berlin Sans FB Bold", 45.0));

        email_tf.setMaxWidth(650.0);
        email_tf.setMinHeight(60.0);
        email_tf.setMinWidth(0.0);
        email_tf.setPrefHeight(30.0);
        email_tf.setPrefWidth(0.0);
        email_tf.setFont(new Font("Berlin Sans FB Bold", 24.0));
        FlowPane.setMargin(email_tf, new Insets(-30.0, 0.0, 0.0, 0.0));

        label3.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        label3.setPrefHeight(50.0);
        label3.setPrefWidth(350.0);
        label3.setText("Password");
        label3.setTextFill(javafx.scene.paint.Color.WHITE);
        label3.setFont(new Font("Berlin Sans FB Bold", 45.0));

        password_tf.setMaxWidth(650.0);
        password_tf.setMinHeight(60.0);
        password_tf.setMinWidth(0.0);
        password_tf.setPrefHeight(30.0);
        password_tf.setPrefWidth(509.0);
        FlowPane.setMargin(password_tf, new Insets(-110.0, 0.0, 0.0, 0.0));
        password_tf.setFont(new Font("Berlin Sans FB Bold", 24.0));
        passwordrevealed_tf.setMaxWidth(650.0);
        passwordrevealed_tf.setMinHeight(60.0);
        passwordrevealed_tf.setMinWidth(0.0);
        passwordrevealed_tf.setPrefHeight(30.0);
        passwordrevealed_tf.setPrefWidth(509.0);
        passwordrevealed_tf.setVisible(false);
        FlowPane.setMargin(passwordrevealed_tf, new Insets(-30.0, 0.0, 0.0, 0.0));
        passwordrevealed_tf.toBack();
        password_tf.toFront();
        passwordrevealed_tf.setFont(new Font("Berlin Sans FB Bold", 24.0));
        BorderPane.setMargin(flowPane, new Insets(-70.0, 0.0, 0.0, 250.0));
        borderPane.setCenter(flowPane);

        BorderPane.setAlignment(flowPane0, javafx.geometry.Pos.CENTER);
        flowPane0.setAlignment(javafx.geometry.Pos.BOTTOM_RIGHT);
        flowPane0.setMaxHeight(500.0);
        flowPane0.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane0.setPrefHeight(200.0);
        flowPane0.setPrefWidth(130.0);
        flowPane0.setRowValignment(javafx.geometry.VPos.BOTTOM);

        back_btn.setMinHeight(20.0);
        back_btn.setMinWidth(20.0);
        back_btn.setMnemonicParsing(false);
        back_btn.setPrefHeight(21.0);
        back_btn.setPrefWidth(58.0);
        FlowPane.setMargin(back_btn, new Insets(0.0, -33.0, -30.0, 0.0));
        back_btn.setCursor(Cursor.HAND);
        BorderPane.setMargin(flowPane0, new Insets(0.0));
        borderPane.setLeft(flowPane0);

        BorderPane.setAlignment(flowPane1, javafx.geometry.Pos.CENTER);
        flowPane1.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER);
        flowPane1.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane1.setPrefHeight(632.0);
        flowPane1.setPrefWidth(368.0);
        flowPane1.setRowValignment(javafx.geometry.VPos.TOP);

        signup_btn.setMinHeight(50.0);
        signup_btn.setMinWidth(150.0);
        signup_btn.setMnemonicParsing(false);
        signup_btn.setPrefHeight(31.0);
        signup_btn.setPrefWidth(93.0);
        FlowPane.setMargin(signup_btn, new Insets(0.0, 20.0, 52.0, 0.0));
        signup_btn.setCursor(Cursor.HAND);
        borderPane.setRight(flowPane1);

        passreveal_btn.setAlignment(javafx.geometry.Pos.CENTER);
        passreveal_btn.setContentDisplay(
                javafx.scene.control.ContentDisplay.CENTER
        );
        passreveal_btn.setMinHeight(1.0);
        passreveal_btn.setMinWidth(1.0);
        passreveal_btn.setMnemonicParsing(false);
        passreveal_btn.setPrefHeight(1.0);
        passreveal_btn.setPrefWidth(1.0);
        passreveal_btn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        StackPane.setMargin(
                passreveal_btn,
                new Insets(-155.0, -350.0, -550.0, 0.0)
        );

        imageView0.setFitHeight(35.0);
        imageView0.setFitWidth(50.0);
        imageView0.setPickOnBounds(true);
        imageView0.setImage(
                new Image(getClass().getResource("/assets/closed.png").toExternalForm())
        );
        passreveal_btn.setGraphic(imageView0);
        passreveal_btn.setCursor(Cursor.HAND);

        getChildren().add(imageView);
        flowPane.getChildren().add(label0);
        flowPane.getChildren().add(username_tf);
        flowPane.getChildren().add(label2);
        flowPane.getChildren().add(email_tf);
        flowPane.getChildren().add(label3);
        flowPane.getChildren().add(passwordrevealed_tf);
        flowPane.getChildren().add(password_tf);
        flowPane0.getChildren().add(back_btn);
        flowPane1.getChildren().add(signup_btn);
        getChildren().add(borderPane);
        getChildren().add(passreveal_btn);
        usernameLabel.setTextFill(javafx.scene.paint.Color.RED);
        usernameLabel.setPrefWidth(260);
        emailLabel.setTextFill(javafx.scene.paint.Color.RED);
        passwordLabel.setTextFill(javafx.scene.paint.Color.RED);
        emailLabel.setPrefWidth(260);
        passwordLabel.setPrefWidth(260);
        StackPane.setMargin(emailLabel, new Insets(100.0, 290.0, 0.0, 0.0));
        StackPane.setMargin(passwordLabel, new Insets(480.0, 290.0, 0.0, 0.0));
        StackPane.setMargin(usernameLabel, new Insets(-280.0, 290.0, 0.0, 0.0));
        getChildren().add(emailLabel);
        getChildren().add(passwordLabel);
        getChildren().add(usernameLabel);
    }

    void revealPassword(TextField password, TextField passRevealed) {
        if (!togglePass) {
            passRevealed.setText(password.getText());
            passRevealed.setVisible(true);
            password.setVisible(false);
            imageView0.setImage(
                    new Image(getClass().getResource("/assets/open.png").toExternalForm())
            );
            togglePass = !togglePass;
        } else {
            password.setText(passRevealed.getText());
            passRevealed.setVisible(false);
            password.setVisible(true);
            imageView0.setImage(
                    new Image(getClass().getResource("/assets/closed.png").toExternalForm())
            );
            togglePass = !togglePass;
        }
    }

    boolean validateUsername(TextField username) {
        final String USERNAME_REGEX = "^\\S+$";
        if (username.getText().isEmpty()) {
            usernameLabel.setText("Please enter your username");
            return false;
        } else if ((username.getText().length() < 4) && (!username.getText().isEmpty())) {
            usernameLabel.setText("Username must be at least 4 characters");
            return false;
        } else if ((!username.getText().matches(USERNAME_REGEX))
                && (!username.getText().isEmpty())) {
            usernameLabel.setText("Username must be have no spaces");
            return false;
        } else {
            usernameLabel.setText("");
            return true;
        }
    }

    boolean validateEmail(TextField email) {
        final String EMAIL_REGEX
                = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (email.getText().isEmpty()) {
            emailLabel.setText("Please enter your email address");
            return false;
        } else if ((!email.getText().matches(EMAIL_REGEX)) && (!email.getText().isEmpty())) {
            emailLabel.setText("Please enter a valid email address");
            return false;
        } else {
            emailLabel.setText("");
            return true;
        }
    }

    boolean validatePassword(TextField password, TextField passRev) {
        final String PASSWORD_REGEX = "^\\S+$";
        if (!togglePass) {
            if (password.getText().isEmpty()) {
                passwordLabel.setText("Please enter your password");
                return false;
            } else if ((!password.getText().matches(PASSWORD_REGEX))) {
                passwordLabel.setText("Password must be have no spaces");
                return false;
            } else if ((password.getText().length() < 8)) {
                passwordLabel.setText("Password must be at least 8 characters");
                return false;
            } else {
                passwordLabel.setText("");
                return true;
            }
        } else {
            if (password.getText().isEmpty()) {
                passRev.setText("Please enter your password");
                return false;
            } else if ((!passRev.getText().matches(PASSWORD_REGEX))) {
                passwordLabel.setText("Password must be have no spaces");
                return false;
            } else if ((passRev.getText().length() < 8)) {
                passwordLabel.setText("Password must be at least 8 characters");
                return false;
            } else {
                passwordLabel.setText("");
                return true;
            }
        }
    }

    boolean validateEntries(
            TextField username_tf,
            TextField email_tf,
            TextField password_tf,
            TextField passwordRevealed_tf
    ) {
        return ((validateUsername(username_tf))
                && (validateEmail(email_tf))
                && (validatePassword(password_tf, passwordRevealed_tf)));
    }
}
