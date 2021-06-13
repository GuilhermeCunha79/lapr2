package app.ui.gui;

import app.controller.App;
import app.domain.store.ClinicalAnalysisLaboratoryStore;
import app.mappers.CalListMapper;
import app.ui.Main;
import app.ui.console.CreateTestUI;
import app.ui.console.RegisterANewClientUI;
import app.ui.console.RegisterEmployeeUI;
import app.ui.gui.utils.SharedMethods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ReceptionistMenuUI implements Initializable {

    private Main mainApp;

    @FXML
    private Button newClientBtn;

    @FXML
    private Button newClinicalTestBtn;

    @FXML
    private Button mainMenuBtn;

    @FXML
    private ComboBox labComboBox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> calList = CalListMapper.toDto();
        labComboBox.setItems(FXCollections.observableList(calList));
    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void registerNewClientUI(ActionEvent actionEvent){
        RegisterANewClientUI registerANewClientUI = new RegisterANewClientUI();
        registerANewClientUI.run();
    }

    @FXML
    private void createNewClinicalTest(ActionEvent actionEvent){
        String labSelected;
        if (!labComboBox.getSelectionModel().isEmpty()) {
            labSelected = labComboBox.getValue().toString().substring(8, 13);
            if (!labSelected.isBlank()) {
                CreateTestUI createTestUI = new CreateTestUI(labSelected);
                createTestUI.run();
            }
        }
        else{
            SharedMethods.infoAlert("Select a laboratory", "Invalid data");
        }
    }

    @FXML
    private void returnToLoginUI(ActionEvent actionEvent){
        App.getInstance().doLogout();
        LoginUI loginUI = (LoginUI) this.mainApp.changeStageContent("/fxml/LoginScreen.fxml");
        loginUI.setMainApp(this.mainApp);
    }
}
