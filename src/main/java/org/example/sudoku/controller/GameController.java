package org.example.sudoku.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import org.example.sudoku.model.GridGame;

public class GameController {

    @FXML
    private GridPane boardGame, gridGame1, gridGame2, gridGame3, gridGame4;
    @FXML
    private GridPane gridGame5, gridGame6, gridGame7, gridGame8, gridGame9;

    @FXML
    public void initialize() {
        for (byte i = 0; i < 3; i++) {
            for (byte j = 0; j < 3; j++) {
                boardGame.add(new GridGame().getGridNumbers(), j, i);
            }
        }
    }
}
