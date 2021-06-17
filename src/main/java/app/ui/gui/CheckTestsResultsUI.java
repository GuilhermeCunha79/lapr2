package app.ui.gui;

import app.controller.CheckResultsController;
import app.ui.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
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
    private ListView<String> listViewClients;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> lClientDto = ctrl.showClients();
        for(String client : lClientDto){
            listViewClients.getItems().add(client);
        }
    }

    @FXML
    public void orderListByName(){
        String type= "name";
        List<String> lClientDto = ctrl.showOrderedClients(type);
        for(String client : lClientDto){
            listViewClients.getItems().add(client);
        }

    }

    @FXML
    public void orderListByTIN(){
        String type= "tin";
        List<String> lClientDto = ctrl.showOrderedClients(type);
        for(String client : lClientDto){
            listViewClients.getItems().add(client);
        }
    }

    @FXML
    public void checkTestResults(){

    }

    @FXML
    public void clinicalChemistryTechnologistMenu(){
        CheckTestsResultsUI checkTestsResultsUI = (CheckTestsResultsUI) this.mainApp.changeStageContent("/fxml/ClinicalChemistryTechnologistMenu.fxml");
        checkTestsResultsUI.setMainApp(this.mainApp);
    }
}
