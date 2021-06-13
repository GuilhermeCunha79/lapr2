package app.ui.gui;

import app.controller.App;
import app.mappers.CalListMapper;
import app.ui.Main;
import app.ui.console.RegisterSampleUI;
import app.ui.gui.utils.SharedMethods;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MedLabTechnicianMenuUI implements Initializable {

    private Main mainApp;

    @FXML
    private Button recordSamplesBtn;

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
    private void registerNewSample(ActionEvent actionEvent){
        String labSelected;
        if (!labComboBox.getSelectionModel().isEmpty()) {
            labSelected = labComboBox.getValue().toString().substring(8, 13);
            if (!labSelected.isBlank()) {
                RegisterSampleUI registerSampleUI = new RegisterSampleUI(labSelected);
                registerSampleUI.run();
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
