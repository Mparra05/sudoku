package org.example.sudoku.model;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class GridGame {

    private GridPane gridNumbers;

    public GridGame() {
        gridNumbers = new GridPane();
        gridNumbers.setAlignment(Pos.CENTER);
        gridNumbers.setStyle("-fx-border-color: black");
        gridNumbers.setStyle("-fx-background-color: black");

        for (byte i = 0; i < 3; i++) {
            for (byte j = 0; j <3; j++) {
                TextField fieldNumber = new TextField();
                fieldNumber.setAlignment(Pos.CENTER);
                //fieldNumber.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.NONE, CornerRadii.EMPTY, new BorderWidths(1, 1, 1, 1))));
                fieldNumber.setStyle("-fx-border-color: black");
                fieldNumber.setPrefSize(43, 43);
                gridNumbers.add(fieldNumber, j, i);
            }
        }
    }

    public GridPane getGridNumbers() {
        return this.gridNumbers;
    }
}
