package app.ui.gui;

import app.controller.App;
import app.controller.ViewTestResultController;
import app.domain.shared.Constants;
import app.ui.Main;
import auth.mappers.dto.UserRoleDTO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewTestResultsUI implements Initializable {

    private final ViewTestResultController ctrl = new ViewTestResultController();

    private Main mainApp;

    //Buttons
    @FXML
    private Button btnViewTestResults;

    @FXML
    private Button btnClientMenu;

    @FXML
    private ListView<String> listViewTests;






    public void initialize(URL url, ResourceBundle resourceBundle) {
        verifyClientRoleWithAllTests();
    }

    public void verifyClientRoleWithAllTests() {
        for (UserRoleDTO roleDTO : App.getInstance().getCurrentUserSession().getUserRoles()) {
             if (roleDTO.getDescription().equals(Constants.ROLE_CLIENT)){
                List<String> lClientTestsDto = ctrl.showClientTestsValidatedAndOrderedByRegistrationDate(ctrl.getClientByEmail());
                for (String test: lClientTestsDto){
                    listViewTests.getItems().add(test);
                }

            }

        }
    }

    public void viewTestResults() {
        WindohWithTestResultsListUI windohWithTestResultsListUI = (WindohWithTestResultsListUI) this.mainApp.changeStageContent("/fxml/ClientTestResultsList.fxml");
        windohWithTestResultsListUI.setMainApp(this.mainApp);
        windohWithTestResultsListUI.setText(ctrl.showTestSelected(listViewTests.getSelectionModel().getSelectedItem().substring(listViewTests.getSelectionModel().getSelectedItem().lastIndexOf("NHS Code: ")+1,listViewTests.getSelectionModel().getSelectedItem().lastIndexOf("NHS Code: ")+10)));
        windohWithTestResultsListUI.setTextA(ctrl.showTestResultsAndReport());

    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    public void clientMenu(){
        ViewTestResultsUI viewTestResultUI = (ViewTestResultsUI) this.mainApp.changeStageContent("/fxml/ClientMenu.fxml");
        viewTestResultUI.setMainApp(this.mainApp);
    }


}