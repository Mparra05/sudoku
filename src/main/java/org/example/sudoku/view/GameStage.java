package org.example.sudoku.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.sudoku.controller.GameController;

import java.io.IOException;

/**
 * Class of the game stage
 */
public class GameStage extends Stage {

    /**
     * Instance of the game controller
     */
    private GameController gameController;

    /**
     * Constructor of the game stage class, load the FXML file
     * @throws IOException if the loader gets an error
     */
    public GameStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/sudoku/game-view.fxml"));
        Parent root = loader.load();
        gameController = loader.getController();
        Scene scene = new Scene(root);
        setTitle("Sudoku");
        getIcons().add(new Image(String.valueOf(getClass().getResource("/org/example/sudoku/images/sudoku-icon.png"))));
        setResizable(false);
        setScene(scene);
        show();
    }

    /**
     * Gets the game controller
     * @return The game controller
     */
    public GameController getGameController() {
        return gameController;
    }

    /**
     * Class of the game stage holder
     */
    private static class GameStageHolder {
        /**
         * Instance of the game stage holder
         */
        private static GameStage INSTANCE;
    }

    /**
     * Gets the game stage instance
     * @return The game stage
     * @throws IOException if the game stage instance gets an error
     */
    public static GameStage getInstance() throws IOException{
        return GameStageHolder.INSTANCE = new GameStage();
    }

    /**
     * Delete the game stage instance
     */
    public static void deleteInstance() {
        GameStageHolder.INSTANCE.close();
        GameStageHolder.INSTANCE = null;
    }
}
