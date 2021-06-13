package app.ui.gui;

import app.ui.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

public class DevelopersUI implements Initializable {

    private Main mainApp;

    @FXML
    private Button returnToMenuBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setMainApp(Main mainApp){
        this.mainApp = mainApp;
    }

    @FXML
    private void showUIScreen (ActionEvent actionEvent){
        LoginUI loginUI = (LoginUI) this.mainApp.changeStageContent("/fxml/LoginScreen.fxml");
        loginUI.setMainApp(this.mainApp);
    }


}
