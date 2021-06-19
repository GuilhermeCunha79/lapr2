package app.ui.gui;

import app.controller.App;
import app.ui.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientUI implements Initializable {

    private Main mainApp;

    @FXML
    private Button changeDataBtn;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void changePersonalDataUI(ActionEvent actionEvent) {
        ChangePersonalDataUI changePersonalDataUI = (ChangePersonalDataUI) this.mainApp.changeStageContent("/fxml/ClientChanges.fxml");
        changePersonalDataUI.setMainApp(this.mainApp);

    }

    @FXML
    private void viewTestResultsUI(ActionEvent actionEvent) {
        ViewTestResultsUI viewTestResultsUI = (ViewTestResultsUI) this.mainApp.changeStageContent("/fxml/ViewTestResults.fxml");
        viewTestResultsUI.setMainApp(this.mainApp);
    }

    @FXML
    private void returnToLoginUI(ActionEvent actionEvent) {
        App.getInstance().doLogout();
        LoginUI loginUI = (LoginUI) this.mainApp.changeStageContent("/fxml/LoginScreen.fxml");
        loginUI.setMainApp(this.mainApp);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

