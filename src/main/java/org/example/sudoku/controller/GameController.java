package org.example.sudoku.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class GameController {

    @FXML
    private GridPane boardGame, gridGame1, gridGame2, gridGame3, gridGame4;
    @FXML
    private GridPane gridGame5, gridGame6, gridGame7, gridGame8, gridGame9;

    @FXML
    public void initialize() {
        System.out.println("Bienvenido");
    }
}
