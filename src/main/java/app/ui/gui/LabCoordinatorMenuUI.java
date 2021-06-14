package app.ui.gui;

import app.controller.App;
import app.ui.Main;
import app.ui.console.ValidationUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class LabCoordinatorMenuUI implements Initializable {

    private Main mainApp;

    @FXML
    private Button testValidationBtn;

    @FXML
    private Button importTestsCsvFileBtn;

    @FXML
    private Button mainMenuBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void doTestValidation(ActionEvent actionEvent){
        ValidationUI validationUI = new ValidationUI();
        validationUI.run();
    }

    @FXML
    private void importTestFromCsvFile(ActionEvent actionEvent){
        ImportTestFromCsvFileUI importTestFromCsvFileUI = (ImportTestFromCsvFileUI) this.mainApp.changeStageContent("/fxml/AddTestFromCSVFile.fxml");
        importTestFromCsvFileUI.setMainApp(this.mainApp);
    }

    @FXML
    private void returnToLoginUI(ActionEvent actionEvent){
        App.getInstance().doLogout();
        LoginUI loginUI = (LoginUI) this.mainApp.changeStageContent("/fxml/LoginScreen.fxml");
        loginUI.setMainApp(this.mainApp);
    }
}
