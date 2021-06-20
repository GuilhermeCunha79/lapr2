package app.ui;

import app.scheduler.Scheduler;

import app.ui.gui.LoginUI;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;


/**
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Main extends Application {

    private Stage stage;
    static final String MANY_LABS = "Many Labs";

    public static void main(String[] args) {
        try{
            new Scheduler();
            launch(args);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public Stage getStage() {
        return stage;
    }

    public void start(Stage stage) {
        this.stage = stage;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoadingScreen.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            this.stage.setTitle(MANY_LABS);
            this.stage.setScene(scene);

            stage.setOnCloseRequest(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

                alert.setTitle(MANY_LABS);
                alert.setHeaderText("Action Confirmation");
                alert.setContentText("Sure you want to exit?");

                ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Yes");
                ((Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("No");

                if (alert.showAndWait().get() == ButtonType.CANCEL) {
                    event.consume();
                }
            });
            this.stage.show();
            PauseTransition delay = new PauseTransition(Duration.seconds(3));
            delay.setOnFinished(event -> {
                try {
                    LoginUI loginUI = (LoginUI) changeStageContent("/fxml/LoginScreen.fxml");
                    loginUI.setMainApp(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            delay.play();
        } catch (IOException e) {
            errorAlert(e).show();
        }
    }

    public Initializable changeStageContent(String fxml)  {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            this.stage.setScene(scene);
            return loader.getController();
        } catch (IOException e) {
            errorAlert(e).show();
            return null;
        }
    }


    public Alert errorAlert(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(MANY_LABS);
        alert.setHeaderText("App launch error.");
        alert.setContentText(e.getMessage());

        return alert;
    }
}
