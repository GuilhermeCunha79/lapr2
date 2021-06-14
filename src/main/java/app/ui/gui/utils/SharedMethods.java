package app.ui.gui.utils;

import javafx.scene.control.Alert;

public class SharedMethods {

    public static void errorAlert(Exception e, String headerText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Many Labs");
        alert.setHeaderText(headerText);
        alert.setContentText(e.getLocalizedMessage());

        alert.show();
    }

    public static void infoAlert(String message, String headerText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Many Labs");
        alert.setHeaderText(headerText);
        alert.setContentText(message);

        alert.show();
    }
}
