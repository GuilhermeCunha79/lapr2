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

public class AdminMenuUI implements Initializable {

    private Main mainApp;

    @FXML
    private Button newPCategoryBtn;

    @FXML
    private Button newParameterBtn;

    @FXML
    private Button newTestTypeBtn;

    @FXML
    private Button newCALabBtn;

    @FXML
    private Button newEmployeeBtn;

    @FXML
    private Button mainMenuBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void startPCategoryCreationUI(ActionEvent actionEvent){
        CreateParameterCategoryUI categoryUI = new CreateParameterCategoryUI();
        categoryUI.run();
    }

    @FXML
    private void startParameterCreationUI(ActionEvent actionEvent){
        CreateNewParameterUI parameterUI = new CreateNewParameterUI();
        parameterUI.run();
    }

    @FXML
    private void startNewTestTypeCreationUI(ActionEvent actionEvent){
        SpecifyANewTypeOfTestUI typeOfTestUI = new SpecifyANewTypeOfTestUI();
        typeOfTestUI.run();
    }

    @FXML
    private void startNewCALabCreationUI(ActionEvent actionEvent){
        RegisterNewClinicalAnalysisLabUI clinicalAnalysisLabUI = new RegisterNewClinicalAnalysisLabUI();
        clinicalAnalysisLabUI.run();
    }

    @FXML
    private void startNewEmployeeRegistrationUI(ActionEvent actionEvent){
        RegisterEmployeeUI registerEmployeeUI = new RegisterEmployeeUI();
        registerEmployeeUI.run();
    }

    @FXML
    private void returnToLoginUI(ActionEvent actionEvent){
        App.getInstance().doLogout();
        LoginUI loginUI = (LoginUI) this.mainApp.changeStageContent("/fxml/LoginScreen.fxml");
        loginUI.setMainApp(this.mainApp);
    }
}
