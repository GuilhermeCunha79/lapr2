package app.ui.gui;

import app.controller.CheckResultsController;
import app.ui.Main;
import javafx.event.ActionEvent;
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
    public void orderListByName(ActionEvent actionEvent){
        String type= "name";
        listViewClients.getItems().clear();
        List<String> lClientDto = ctrl.showOrderedClients(type);
        for(String client : lClientDto){
            listViewClients.getItems().add(client);
        }
    }

    @FXML
    public void orderListByTIN(ActionEvent actionEvent){
        String type= "tin";
        listViewClients.getItems().clear();
        List<String> lClientDto = ctrl.showOrderedClients(type);
        for(String client : lClientDto){
            listViewClients.getItems().add(client);
        }
    }

    @FXML
    public void checkTestResults(ActionEvent actionEvent){
        NewWindowClientTestsUI newWindowClientTestsUI = (NewWindowClientTestsUI) this.mainApp.changeStageContent("/fxml/WindowWithTestList.fxml");
        newWindowClientTestsUI.setMainApp(this.mainApp);
        newWindowClientTestsUI.setTextArea(ctrl.showTestDetails(listViewClients.getSelectionModel().getSelectedItem().substring(listViewClients.getSelectionModel().getSelectedItem().lastIndexOf("TIN number: ")+12,listViewClients.getSelectionModel().getSelectedItem().lastIndexOf("TIN number: ")+22)));
    }

    @FXML
    public void clinicalChemistryTechnologistMenu(ActionEvent actionEvent){
        ClinicalChemistryTechnologistMenuUI clinicalChemistryTechnologistMenuUI = (ClinicalChemistryTechnologistMenuUI) this.mainApp.changeStageContent("/fxml/ClinicalChemistryTechnologistMenu.fxml");
        clinicalChemistryTechnologistMenuUI.setMainApp(this.mainApp);
    }


}
