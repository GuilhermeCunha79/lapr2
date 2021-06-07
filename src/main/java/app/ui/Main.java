package app.ui;

import app.ui.console.MainMenuUI;

import java.io.IOException;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Main {

    public static void main(String[] args)
    {

        try
        {
            MainMenuUI menu = new MainMenuUI();

            menu.run();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }

         /*
        launch(args);
        */
    }
/*
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoadingScreen.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            //scene.getStylesheets().add("/styles/Styles.css");

            stage.setTitle("Many Labs");
            stage.setScene(scene);

            stage.setOnCloseRequest(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

                alert.setTitle("App");
                alert.setHeaderText("Action Confirmation");
                alert.setContentText("Sure you want to exit?");

                ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Yes");
                ((Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("No");

                if (alert.showAndWait().get() == ButtonType.CANCEL) {
                    event.consume();
                }
            });
            stage.show();
        } catch (IOException e) {
            errorAlert(e).show();
        }
    }

    private Alert errorAlert(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("App");
        alert.setHeaderText("App launch error.");
        alert.setContentText(e.getMessage());

        return alert;
    }

 */
}
