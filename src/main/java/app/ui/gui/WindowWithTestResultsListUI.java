package app.ui.gui;

import app.ui.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class WindowWithTestResultsListUI implements Initializable {

    private Main mainApp;

    @FXML
    private ListView<String>testsList;

    @FXML
    private Button btnBack;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void setTextA(List<String> list) {
        for(String testResults : list){
            testsList.getItems().add(testResults);
        }
    }

        public void setText(String string) {
            testsList.getItems().add(string);
        }

    @FXML
    public void back(ActionEvent actionEvent){
        ViewTestResultsUI viewTestResultsUI = (ViewTestResultsUI) this.mainApp.changeStageContent("/fxml/ViewTestResults.fxml");
        viewTestResultsUI.setMainApp(this.mainApp);
    }
}

