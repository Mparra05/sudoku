package org.example.sudoku.controller;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.sudoku.model.BoardGame;
import javafx.event.EventHandler;
import org.example.sudoku.view.GameStage;
import org.example.sudoku.view.alert.AlertBox;

/**
 * Class of the game controller
 */
public class GameController {

    /**
     * Instance of the BoardGame class
     */
    private BoardGame boardGame;

    /**
     * FXML GridPane of the GUI
     */
    @FXML
    private GridPane gridGame;

    /**
     * Initialize the game controller and show the application
     * @see #setOnKeyTyped(TextField, int, int)
     */
    @FXML
    public void initialize() {
        boardGame = new BoardGame();

        for (int i = 0; i < 9; i++) {
            for (int  j = 0; j < 9; j++) {
                TextField numberField = new TextField();
                numberField.setPrefSize(44, 44);
                numberField.setAlignment(Pos.CENTER);
                numberField.setFont(Font.font("System", FontWeight.BOLD, 16));

                if ((i==j && (i==2 || i==5 ||i==8)) || (i==2 && j==5) || (i==2 && j==8) || (i==5 && j==2) || (i==5 && j==8) || (i==8 && j==2) || (i==8 && j==5)) {
                    numberField.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0, 2, 2, 0))));
                }
                else if (i==2 || i==5 || i==8) {
                    numberField.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0, 0, 2, 0))));
                }
                else if (j==2 || j==5 || j==8) {
                    numberField.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0, 2, 0, 0))));
                }

                if (boardGame.getBoardGame()[i][j] > 0) {
                    numberField.setText(String.valueOf(boardGame.getBoardGame()[i][j]));
                    numberField.setEditable(false);
                }

                setOnKeyTyped(numberField, i, j);
                gridGame.add(numberField, j, i);
            }
        }
    }

    /**
     * Sets the key event to the fields of the board game to start playing
     * @param textField Text fields of the board game
     * @param row Text field row
     * @param column Text field column
     * @see #winGame(boolean)
     */
    public void setOnKeyTyped(TextField textField, int row, int column) {
        textField.setOnKeyTyped(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent keyEvent) {

                if (!Character.isDigit(keyEvent.getCharacter().charAt(0))) {
                    if(textField.getText().length() == 1) {
                        textField.setText(null);
                        boardGame.removeNumberBoardGame(row,column);
                    }
                    else {
                        textField.setText(null);
                        boardGame.removeNumberBoardGame(row,column);
                    }
                }
                else {
                    int digitTyped = Integer.parseInt(keyEvent.getCharacter());
                    textField.setText(textField.getText(0, 1));

                    if (!boardGame.validateNumberRow(digitTyped, row, column)
                            && !boardGame.validateNumberColumn(digitTyped, column, row)
                            && !boardGame.validateNumberGrid(digitTyped, row, column, boardGame.getInitialRowOrColumnIndex(row),
                            boardGame.getFinalRowOrColumnIndex(row),
                            boardGame.getInitialRowOrColumnIndex(column),
                            boardGame.getFinalRowOrColumnIndex(column))) {

                        boardGame.setNumberBoardGame(digitTyped, row, column);
                    }
                    else {
                        new AlertBox().showAlertMessage("Error", "Entrada Invalida!!", "No puedes usar este número en esta casilla.", Alert.AlertType.ERROR);
                        textField.setText(null);
                        boardGame.removeNumberBoardGame(row,column);
                    }
                }

                winGame(boardGame.validateBoardComplete());
            }
        });
    }

    /**
     * Shows a message to the winner and close the application
     * @param validatedBoardComplete Status of the board game
     */
    public void winGame(boolean validatedBoardComplete) {
        if (validatedBoardComplete) {
            new AlertBox().showAlertMessage("Juego Completado", "Has ganado!", "Felicitaciones has completado el tablero del Sudoku!!!", Alert.AlertType.INFORMATION);
            GameStage.deleteInstance();
        }
    }
}
