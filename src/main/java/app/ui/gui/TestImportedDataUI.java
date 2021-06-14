package app.ui.gui;

import app.controller.ImportTestFromCsvController;
import app.ui.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TestImportedDataUI implements Initializable {

    private Main mainApp;

    @FXML
    private Button okBtn;

    @FXML
    private TextArea testsAddedTxtField;

    @FXML
    private TextArea testsFailedTxtField;

    @FXML
    private Text addedTotalText;

    @FXML
    private Text failedTotalText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    public void setTestAddedCount(int testAddedCount) {
        addedTotalText.setText("Total: " + testAddedCount);
    }

    public void setTestFailCount(int testFailCount) {
        failedTotalText.setText("Total: " + testFailCount);
    }

    @FXML
    private void okButton(ActionEvent actionEvent) {
        LabCoordinatorMenuUI labCoordinatorMenuUI = (LabCoordinatorMenuUI) this.mainApp.changeStageContent("/fxml/LabCoordinatorMenu.fxml");
        labCoordinatorMenuUI.setMainApp(this.mainApp);
    }

    public void setTestFailedList(List<String> testsFailedList) {
        this.testsFailedTxtField.setText(convertStringListToString(testsFailedList));
    }

    public void setTestAddedList(List<String> testsAddedList) {
        this.testsAddedTxtField.setText(convertStringListToString(testsAddedList));
    }

    public String convertStringListToString(List<String> list) {
        String result = "";
        for (String str : list) {
            result = result.concat(str + "\n");
        }
        return result;
    }
}
