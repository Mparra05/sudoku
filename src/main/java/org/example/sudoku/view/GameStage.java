package org.example.sudoku.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.sudoku.controller.GameController;

import java.io.IOException;

public class GameStage extends Stage {

    private GameController gameController;
    // Controlador del juego Sudoku


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
        //Configuarion de la ventana del juego Sudoku
    }

    /* Constructor de la clase GameStage
     *  Carga la interfaz de usuario del juego Sudoku. */


    public GameController getGameController() {
        return gameController;
    }
    //Metodo para obtener el controlador del Juego Sudoku
    private static class GameStageHolder {
        private static GameStage INSTANCE;
    }
    // Implementacion para el metodo Singleton
    public static GameStage getInstance() throws IOException{
        return GameStageHolder.INSTANCE = new GameStage();
    }

    public static void deleteInstance() {
        GameStageHolder.INSTANCE.close();
        GameStageHolder.INSTANCE = null;
    }
    //Metodo para eliminar la instacia unica del GameStage. Cierra la ventana del Juego Sudoku Y establece la instancia en null
}
