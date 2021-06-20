package app.ui.gui;

import app.controller.SendNHSReportController;
import app.ui.Main;
import app.ui.gui.utils.SharedMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SendNhsReportUI implements Initializable {
    private Main mainApp;

    private SendNHSReportController ctrl;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button sendReportButton;

    @FXML
    private TextField dateFromTextField;

    @FXML
    private TextField dateUntilTxtField;

    @FXML
    private ComboBox<String> regressionModelComboBox;

    @FXML
    private ComboBox<String> regressionModelTypeDataComboBox;

    @FXML
    private TextField confidenceLevelTxtField;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        regressionModelComboBox.getItems().add("Simple Linear Regression Model");
        regressionModelComboBox.getItems().add("Multiple Linear Regression Model");
        regressionModelTypeDataComboBox.getItems().add("Mean age");
        regressionModelTypeDataComboBox.getItems().add("Number of tests performed");
    }

    @FXML
    private void returnToMenu(ActionEvent actionEvent) {
        AdminMenuUI adminMenuUI = (AdminMenuUI) this.mainApp.changeStageContent("/fxml/AdminMenu.fxml");
        adminMenuUI.setMainApp(this.mainApp);
    }

    @FXML
    private void sendReport(ActionEvent actionEvent) {
        double ic;
        String chosenModel;
        String chosenIndepVariable;
        String firstDate;
        String lastDate;
        try {
            if (confidenceLevelTxtField.getText() != null && regressionModelComboBox.getValue() != null) {
                ic = Double.parseDouble(confidenceLevelTxtField.getText());
                chosenModel = regressionModelComboBox.getValue();
                if (chosenModel.equals("Simple Linear Regression Model") && regressionModelTypeDataComboBox.getValue() != null) {
                    chosenIndepVariable = regressionModelTypeDataComboBox.getValue();
                    if (!dateFromTextField.getText().isEmpty() && !dateUntilTxtField.getText().isEmpty()) {
                        firstDate = dateFromTextField.getText();
                        lastDate = dateUntilTxtField.getText();
                        ctrl = new SendNHSReportController(chosenModel, chosenIndepVariable, firstDate, lastDate, ic);
                        SharedMethods.infoAlert("NHS report was sent successfully", "Info");
                    } else {
                        SharedMethods.infoAlert("Date fields cannot be empty", "Invalid Data");
                    }
                } else if (chosenModel.equals("Multiple Linear Regression Model")) {
                    if (dateFromTextField.getText() != null && dateUntilTxtField != null) {
                        firstDate = dateFromTextField.getText();
                        lastDate = dateUntilTxtField.getText();
                        ctrl = new SendNHSReportController(chosenModel, null, firstDate, lastDate, ic);
                        SharedMethods.infoAlert("NHS report was sent successfully", "Info");
                    } else {
                        SharedMethods.infoAlert("Date fields cannot be empty", "Invalid Data");
                    }
                }
            } else
                SharedMethods.infoAlert("Confidence level value and regression model cannot be empty", "Invalid Data");
        } catch (Exception e) {
            SharedMethods.errorAlert(e, "Error");
        }
    }


}
