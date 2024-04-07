module org.example.sudoku {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.sudoku to javafx.fxml;
    opens org.example.sudoku.controller to javafx.fxml;

    exports org.example.sudoku;
}