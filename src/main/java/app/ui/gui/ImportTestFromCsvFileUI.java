package app.ui.gui;

import app.controller.ImportTestFromCsvController;
import app.ui.Main;
import app.ui.gui.utils.SharedMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ImportTestFromCsvFileUI implements Initializable {

    private Main mainApp;

    private ImportTestFromCsvController ctrl;
    @FXML
    private TextField filePathTxtField;

    @FXML
    private Button importTestsCsvFileBtn;

    @FXML
    private Button addTestsButton;

    @FXML
    private Button mainMenuBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ctrl = new ImportTestFromCsvController();
    }

    @FXML
    private void openFileFinder(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().setAll(new FileChooser.ExtensionFilter("CSV", "*.csv"));
        File file = fileChooser.showOpenDialog(new Stage());
        filePathTxtField.setText(file.getPath());
    }

    @FXML
    private void addTestsToSystem(ActionEvent actionEvent){
        ctrl.createTestFromCsvFile(filePathTxtField.getText());
        TestImportedDataUI importedDataUI = (TestImportedDataUI) this.mainApp.changeStageContent("/fxml/TestImportedData.fxml");
        importedDataUI.setMainApp(this.mainApp);
        importedDataUI.setTestFailCount(ctrl.getTestsFailedList().size());
        importedDataUI.setTestAddedCount(ctrl.getTestsAddedList().size());
        importedDataUI.setTestFailedList(ctrl.getTestsFailedList());
        importedDataUI.setTestAddedList(ctrl.getTestsAddedList());

    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void returnToMenu(ActionEvent actionEvent){
        LabCoordinatorMenuUI labCoordinatorMenuUI = (LabCoordinatorMenuUI) this.mainApp.changeStageContent("/fxml/LabCoordinatorMenu.fxml");
        labCoordinatorMenuUI.setMainApp(this.mainApp);
    }
}
