package ui.Screens;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import ui.Screens.GameBoardBase;

public class PlayerVsComputer extends GameBoardBase {

    private char currentPlayer = 'X';
    private Button[][] buttonArray = new Button[3][3]; // 2D array to store buttons

    public PlayerVsComputer() {
        populateButtonArray();
    }

    private void populateButtonArray() {
         ObservableList<Node> children = this.gridPane.getChildren();

        for (Node child : children) {
            if (child instanceof Button) {
                Button button = (Button) child;
                button.setText("");
           
                button.setOnAction(e -> handleButtonClick(button));
                buttonArray[GridPane.getColumnIndex(button)][GridPane.getColumnIndex(button)] = button;
            }
        }
    }

    private void handleButtonClick(Button button) {
        if (button.getText().isEmpty()) {
            button.setText(Character.toString(currentPlayer));
            if (isWin()) {
                displayWinner();
            } else if (isDraw()) {
                displayDraw();
            } else {
                switchPlayer();
                if (currentPlayer == 'O') {
                    new Thread(this::makeComputerMove).start();
                }
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private void makeComputerMove() {
        try {
            // Simulate some processing time for the computer move
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        int row, col;

        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!buttonArray[row][col].getText().isEmpty());
          final int finalRow = row;
          final int finalCol = col;

        Platform.runLater(() -> buttonArray[finalRow][finalCol].setText("O"));

        if (isWin()) {
            Platform.runLater(this::displayWinner);
        } else if (isDraw()) {
            Platform.runLater(this::displayDraw);
        } else {
            switchPlayer();
        }
    }

    private boolean isWin() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (buttonArray[i][0].getText().equals(Character.toString(currentPlayer))
                    && buttonArray[i][1].getText().equals(Character.toString(currentPlayer))
                    && buttonArray[i][2].getText().equals(Character.toString(currentPlayer))) {
                return true;
            }

            if (buttonArray[0][i].getText().equals(Character.toString(currentPlayer))
                    && buttonArray[1][i].getText().equals(Character.toString(currentPlayer))
                    && buttonArray[2][i].getText().equals(Character.toString(currentPlayer))) {
                return true;
            }
        }

        return buttonArray[0][0].getText().equals(Character.toString(currentPlayer))
                && buttonArray[1][1].getText().equals(Character.toString(currentPlayer))
                && buttonArray[2][2].getText().equals(Character.toString(currentPlayer))
                || buttonArray[0][2].getText().equals(Character.toString(currentPlayer))
                && buttonArray[1][1].getText().equals(Character.toString(currentPlayer))
                && buttonArray[2][0].getText().equals(Character.toString(currentPlayer));
    }

    private boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttonArray[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void displayWinner() {
        Platform.runLater(() -> showResultDialog("Player " + currentPlayer + " wins!"));
        resetGame();
    }

    private void displayDraw() {
        Platform.runLater(() -> showResultDialog("It's a draw!"));
        resetGame();
    }

    private void showResultDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Result");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void resetGame() {
        currentPlayer = 'X';
        populateButtonArray();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
