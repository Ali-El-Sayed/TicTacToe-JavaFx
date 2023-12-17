package ui.Screens;

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
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import ui.components.GameButton;

public class SignupBase extends StackPane {

    protected final ImageView imageView;
    protected final BorderPane borderPane;
    protected final Label label;
    protected final FlowPane flowPane;
    protected final Label label0;
    protected final TextField fname_tf;
    protected final Label label1;
    protected final TextField lname_tf;
    protected final Label label2;
    protected final TextField email_tf;
    protected final Label label3;
    protected final PasswordField password_tf;
    protected final TextField passwordrevealed_tf;
    protected final FlowPane flowPane0;
    protected final Button back_btn;
    protected final FlowPane flowPane1;
    protected final Button signup_btn;
    protected final Button passreveal_btn;
    protected final ImageView imageView0;
    protected boolean togglePass;
    public SignupBase() {

        togglePass=false;
        imageView = new ImageView();
        borderPane = new BorderPane();
        label = new Label();
        flowPane = new FlowPane();
        label0 = new Label();
        fname_tf = new TextField();
        label1 = new Label();
        lname_tf = new TextField();
        label2 = new Label();
        email_tf = new TextField();
        label3 = new Label();
        password_tf = new PasswordField();
        passwordrevealed_tf = new TextField();
        flowPane0 = new FlowPane();
        back_btn = new GameButton("", GameButton.Mode.BACK, () -> {
        });
        flowPane1 = new FlowPane();
        signup_btn = new GameButton("Sign up", GameButton.Mode.NORMAL, () -> {
        });
        passreveal_btn = new Button();
        imageView0 = new ImageView();

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
        imageView.setImage(new Image(getClass().getResource("/assets/background.png").toExternalForm()));

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
        flowPane.setVgap(30.0);

        label0.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        label0.setPrefHeight(50.0);
        label0.setPrefWidth(350.0);
        label0.setText("First Name");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("Berlin Sans FB Bold", 45.0));

        fname_tf.setMaxWidth(650.0);
        fname_tf.setMinHeight(60.0);
        fname_tf.setMinWidth(0.0);
        fname_tf.setPrefHeight(30.0);
        fname_tf.setPrefWidth(0.0);
        fname_tf.setFont(new Font("Berlin Sans FB Bold", 24.0));
        FlowPane.setMargin(fname_tf, new Insets(-30.0, 0.0, 0.0, 0.0));

        label1.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        label1.setPrefHeight(50.0);
        label1.setPrefWidth(350.0);
        label1.setText("Last Name");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("Berlin Sans FB Bold", 45.0));

        lname_tf.setMaxWidth(650.0);
        lname_tf.setMinHeight(60.0);
        lname_tf.setMinWidth(0.0);
        lname_tf.setPrefHeight(30.0);
        lname_tf.setPrefWidth(0.0);
        lname_tf.setFont(new Font("Berlin Sans FB Bold", 24.0));
        FlowPane.setMargin(lname_tf, new Insets(-30.0, 0.0, 0.0, 0.0));

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
        FlowPane.setMargin(password_tf, new Insets(-30.0, 0.0, 0.0, 0.0));
        password_tf.setFont(new Font("Berlin Sans FB Bold", 24.0));
        passwordrevealed_tf.setMaxWidth(650.0);
        passwordrevealed_tf.setMinHeight(60.0);
        passwordrevealed_tf.setMinWidth(0.0);
        passwordrevealed_tf.setPrefHeight(30.0);
        passwordrevealed_tf.setPrefWidth(509.0);
        passwordrevealed_tf.setVisible(false);
        FlowPane.setMargin(passwordrevealed_tf, new Insets(0.0, 0.0, -60.0, 0.0));
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
        passreveal_btn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        passreveal_btn.setMinHeight(1.0);
        passreveal_btn.setMinWidth(1.0);
        passreveal_btn.setMnemonicParsing(false);
        passreveal_btn.setPrefHeight(1.0);
        passreveal_btn.setPrefWidth(1.0);
        passreveal_btn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        StackPane.setMargin(passreveal_btn, new Insets(0.0, -350.0, -550.0, 0.0));

        imageView0.setFitHeight(35.0);
        imageView0.setFitWidth(50.0);
        imageView0.setPickOnBounds(true);
        imageView0.setImage(new Image(getClass().getResource("/assets/closed.png").toExternalForm()));
        passreveal_btn.setGraphic(imageView0);
        passreveal_btn.setCursor(Cursor.HAND);

        getChildren().add(imageView);
        flowPane.getChildren().add(label0);
        flowPane.getChildren().add(fname_tf);
        flowPane.getChildren().add(label1);
        flowPane.getChildren().add(lname_tf);
        flowPane.getChildren().add(label2);
        flowPane.getChildren().add(email_tf);
        flowPane.getChildren().add(label3);
        flowPane.getChildren().add(passwordrevealed_tf);
        flowPane.getChildren().add(password_tf);
        flowPane0.getChildren().add(back_btn);
        flowPane1.getChildren().add(signup_btn);
        getChildren().add(borderPane);
        getChildren().add(passreveal_btn);

        passreveal_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!togglePass){
                    passwordrevealed_tf.setText(password_tf.getText());
                    togglePass=true;
                    passwordrevealed_tf.setVisible(true);
                    password_tf.setVisible(false);
                    imageView0.setImage(new Image(getClass().getResource("/assets/open.png").toExternalForm()));
                    
                }
                else{
                    togglePass=false;
                    password_tf.setText(passwordrevealed_tf.getText());
                    passwordrevealed_tf.setVisible(false);
                    password_tf.setVisible(true);
                    imageView0.setImage(new Image(getClass().getResource("/assets/closed.png").toExternalForm()));
                     
                }
            }
        });
    }
}
