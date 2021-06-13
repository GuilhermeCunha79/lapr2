package app.ui.gui;

import app.controller.App;
import app.ui.Main;
import app.ui.console.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class SpecialistDoctorMenuUI implements Initializable {

    private Main mainApp;

    @FXML
    private Button writeReportBtn;

    @FXML
    private Button mainMenuBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void writeNewTestReport(ActionEvent actionEvent){
        WriteReportUI writeReportUI = new WriteReportUI();
        writeReportUI.run();
    }

    @FXML
    private void returnToLoginUI(ActionEvent actionEvent){
        App.getInstance().doLogout();
        LoginUI loginUI = (LoginUI) this.mainApp.changeStageContent("/fxml/LoginScreen.fxml");
        loginUI.setMainApp(this.mainApp);
    }
}
