package org.example.sudoku.view.alert;

import javafx.scene.control.Alert;

public class AlertBox implements IAlertBox{
    //Clase que implementa la interfaz IAlertBox y proporciona métodos para mostrar mensajes de alerta
    @Override
    public void showAlertMessage(String title, String header, String content, Alert.AlertType alertType) {
        // Crea una nueva instancia de Alert con el tipo especificado
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        // Configura el título, encabezado y contenido del mensaje de alerta
        alert.showAndWait();
        // Muestra el mensaje de alerta y espera hasta que el usuario lo cierre

    }
}
