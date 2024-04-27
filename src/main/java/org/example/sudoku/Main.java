package org.example.sudoku;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.sudoku.view.GameStage;

import java.io.IOException;

/**
 * Main class representing the application
 */
public class Main extends Application {

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the application
     * @param stage Application stage
     * @throws IOException if the game stage gets an error
     */
    @Override
    public void start(Stage stage) throws IOException {
        GameStage.getInstance();
    }
}