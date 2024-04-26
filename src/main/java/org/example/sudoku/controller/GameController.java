package org.example.sudoku.controller;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.sudoku.model.BoardGame;
import javafx.event.EventHandler;
import org.example.sudoku.view.GameStage;
import org.example.sudoku.view.alert.AlertBox;

public class GameController {

    private BoardGame boardGame;

    @FXML
    private GridPane gridGame;

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

    public void setOnKeyTyped(TextField textField, int row, int column) {
        textField.setOnKeyTyped(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent keyEvent) {
                int digitTyped = Integer.parseInt(keyEvent.getCharacter());

                if (!textField.getText().isEmpty()) textField.setText(textField.getText(0, 1));

                if (!Character.isDigit(keyEvent.getCharacter().charAt(0))) textField.setText(null);

                if (!boardGame.validateNumberRow(digitTyped, row, column)
                    && !boardGame.validateNumberColumn(digitTyped, column, row)
                    && !boardGame.validateNumberGrid(digitTyped, boardGame.getInitialRowOrColumnIndex(row),
                                                        boardGame.getFinalRowOrColumnIndex(row),
                                                        boardGame.getInitialRowOrColumnIndex(column),
                                                        boardGame.getFinalRowOrColumnIndex(column))) {

                    boardGame.setBoardGame(digitTyped, row, column);
                }
                else {
                    new AlertBox().showAlertMessage("Entrada Invalida", "Numero Incorrecto", "No puedes usar este número", Alert.AlertType.ERROR);
                    textField.setText(null);
                }

                winGame(boardGame.validateBoardComplete());
            }
        });
    }

    public void winGame(boolean validatedBoardComplete) {
        if (validatedBoardComplete) {
            new AlertBox().showAlertMessage("Juego Completado", "Has ganado", "Felicitaciones has completado el tablero del Sudoku", Alert.AlertType.INFORMATION);
            GameStage.deleteInstance();
        }
    }
}
