package javafxtest;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;

public class GameButton extends Button {

    private final String PRESSED = "/assets/btnPressed.png";
    private final String NORMAL = "/assets/btnNormal.png";
    private final String BACK = "/assets/btnBack.png";
    private final Label label;
    private final Mode mode;
    private final ImageView currBtn;

    public GameButton(String label, Mode m, OnClick onclick) {
        this.mode = m;
        this.label = new Label(label);
        this.label.setCenterShape(true);
        this.label.setStyle("-fx-font-weight: bold; -fx-font-size: 20px; -fx-text-fill: white;");
        this.label.setPadding(new Insets(0, 0, 15, 0));

        if (mode != Mode.BACK) {
            currBtn = new ImageView(new Image(getClass().getResourceAsStream(NORMAL)));
        } else {
            currBtn = new ImageView(new Image(getClass().getResourceAsStream(BACK)));
        }

        currBtn.setFitHeight(70);
        currBtn.setFitWidth(140);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(currBtn, this.label);
        setGraphic(stackPane);

        this.setBorder(Border.EMPTY);
        this.setBackground(Background.EMPTY);

        this.setOnMouseEntered((e) -> {
            this.setCursor(Cursor.HAND);
        });

        this.setOnMouseExited(e -> {
            this.setCursor(Cursor.DEFAULT);
        });

        this.setOnMousePressed((e) -> {
            changeButton();
            onclick.OnClick();
            this.setEffect(new DropShadow());
            this.setCursor(Cursor.CLOSED_HAND);
        });
        this.setOnMouseReleased((e) -> {
            changeButton();
            this.setEffect(null);
            this.setCursor(Cursor.HAND);
        });

    }

    public GameButton(Mode m, OnClick onclick) {
        this.label = new Label();
        this.mode = m;
        if (mode != Mode.BACK) {
            currBtn = new ImageView(new Image(getClass().getResourceAsStream(NORMAL)));
        } else {
            currBtn = new ImageView(new Image(getClass().getResourceAsStream(BACK)));
        }

        currBtn.setFitHeight(70);
        currBtn.setFitWidth(140);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(currBtn);
        setGraphic(stackPane);

        this.setBorder(Border.EMPTY);
        this.setBackground(Background.EMPTY);

        this.setOnMouseEntered((e) -> {
            this.setCursor(Cursor.HAND);
        });

        this.setOnMouseExited(e -> {
            this.setCursor(Cursor.DEFAULT);
        });

        this.setOnMousePressed((e) -> {
            changeButton();
            onclick.OnClick();
            this.setEffect(new DropShadow());
            this.setCursor(Cursor.CLOSED_HAND);
        });
        this.setOnMouseReleased((e) -> {
            changeButton();
            this.setEffect(null);
            this.setCursor(Cursor.HAND);
        });

    }

    void changeButton() {
        if (this.mode != Mode.BACK) {
            if (this.isPressed()) {
                currBtn.setImage(new Image(getClass().getResourceAsStream(PRESSED)));

            } else {
                currBtn.setImage(new Image(getClass().getResourceAsStream(NORMAL)));
            }
        }

    }

    public static enum Mode {
        NORMAL,
        BACK
    }
}
