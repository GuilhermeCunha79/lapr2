package app.ui.gui;

import app.ui.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class NewWindowClientTestsUI implements Initializable {

    private Main mainApp;

    @FXML
    private TextArea testsList;

    @FXML
    private Button btnBack;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void setTextArea(List<String> list) {
        testsList.setText(convertStringListToString(list));
    }


    @FXML
    public void back(ActionEvent actionEvent){
        CheckTestsResultsUI checkTestsResultsUI = (CheckTestsResultsUI) this.mainApp.changeStageContent("/fxml/CheckTestsResults.fxml");
        checkTestsResultsUI.setMainApp(this.mainApp);

    }

    public String convertStringListToString(List<String> list) {
        String result = "";
        for (String str : list) {
            result = result.concat(str + "\n");
        }
        return result;
    }
}

