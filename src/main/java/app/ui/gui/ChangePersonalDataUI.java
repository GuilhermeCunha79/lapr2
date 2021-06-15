package app.ui.gui;


import app.controller.ChangeClientDataController;
import app.ui.Main;
import app.ui.gui.utils.SharedMethods;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static app.domain.shared.CommonMethods.serializeStore;

public class ChangePersonalDataUI implements Initializable {

    private final ChangeClientDataController ctrl = new ChangeClientDataController();

    private Main mainApp;

    //Buttons
    @FXML
    private Button btnChangeName;

    @FXML
    private Button btnChangePhoneNumber;

    @FXML
    private Button btnChangeSex;

    @FXML
    private Button btnChangeAddress;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnConfirm;

    //Combo Box
    @FXML
    private ComboBox sexComboBox;

    //Text Fields

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField ccTxt;

    @FXML
    private TextField nhsTxt;

    @FXML
    private TextField tinTxt;

    @FXML
    private TextField birthDateTxt;

    @FXML
    private TextField phoneNumberTxt;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField addressTxt;


    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ctrl.getClientByEmail();
        List<String> sex = new ArrayList<>();
        sex.add("");
        sex.add("Male");
        sex.add("Female");
        nameTxt.setText(ctrl.getName());
        ccTxt.setText(ctrl.getCitizenCardNumber());
        nhsTxt.setText(ctrl.getNhs());
        tinTxt.setText(ctrl.getTin());
        birthDateTxt.setText(ctrl.getBirthDate());
        //sexComboBox.set;
        sexComboBox.setPromptText(ctrl.getSex());
        sexComboBox.setItems(FXCollections.observableList(sex));
        phoneNumberTxt.setText(ctrl.getPhoneNumber());
        emailTxt.setText(ctrl.getEmail());
        addressTxt.setText(ctrl.getAddress());
    }


    @FXML
    private void enableTextFieldName(ActionEvent actionEvent) {
        nameTxt.setDisable(false);
        nameTxt.setEditable(true);
    }

    @FXML
    private void enableTextFieldSex(ActionEvent actionEvent) {
        sexComboBox.setDisable(false);

    }

    @FXML
    private void enableTextFieldPhoneNumber(ActionEvent actionEvent) {
        phoneNumberTxt.setDisable(false);
        phoneNumberTxt.setEditable(true);
    }

    @FXML
    private void enableTextFieldAddress(ActionEvent actionEvent) {
        addressTxt.setDisable(false);
        addressTxt.setEditable(true);

    }

    @FXML
    private void confirmData(ActionEvent actionEvent) {
        ctrl.changeName(ctrl.getClientByEmail(), nameTxt.getText());
        ctrl.changePhoneNumber(ctrl.getClientByEmail(), phoneNumberTxt.getText());
        ctrl.changeSex(ctrl.getClientByEmail(), (String) sexComboBox.getValue());
        ctrl.changeAddress(ctrl.getClientByEmail(), addressTxt.getText());
        ctrl.saveChanges();
        SharedMethods.notificationAlert("Your data has been updated with success!", "Data Changed");
        ClientUI clientUI =(ClientUI) this.mainApp.changeStageContent("/fxml/ClientMenu.fxml");
        clientUI.setMainApp(this.mainApp);
    }

    @FXML
    private void cancelBtn(ActionEvent actionEvent){
        ChangePersonalDataUI changePersonalDataUI = (ChangePersonalDataUI) this.mainApp.changeStageContent("/fxml/ClientMenu.fxml");
        changePersonalDataUI.setMainApp(this.mainApp);
    }


}
