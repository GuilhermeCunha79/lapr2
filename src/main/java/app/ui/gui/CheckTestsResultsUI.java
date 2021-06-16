package app.ui.gui;

import app.controller.CheckResultsController;
import app.domain.shared.CommonMethods;
import app.ui.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CheckTestsResultsUI implements Initializable {

    private final CheckResultsController ctrl = new CheckResultsController();

    private Main mainApp;

    //Buttons
    @FXML
    private Button btnNameSort;

    @FXML
    private Button btnTINSort;

    @FXML
    private Button btnCheckResults;

    @FXML
    private Button btnLabCoordinatorMenu;

    @FXML
    private TextArea textAreaClients;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> lClientDto = ctrl.showClients();
        textAreaClients.setText(convertStringListToString(lClientDto));
    }

    @FXML
    public void orderListByName(){

    }

    @FXML
    public void orderListByTIN(){

    }

    @FXML
    public void checkTestResults(){

    }

    @FXML
    public void clinicalChemistryTechnologistMenu(){
        CheckTestsResultsUI checkTestsResultsUI = (CheckTestsResultsUI) this.mainApp.changeStageContent("/fxml/ClinicalChemistryTechnologistMenu.fxml");
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
