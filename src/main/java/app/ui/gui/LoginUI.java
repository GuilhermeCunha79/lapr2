package app.ui.gui;

import app.controller.AuthController;
import app.domain.shared.Constants;
import app.ui.Main;
import app.ui.console.MenuItem;
import app.ui.console.utils.Utils;
import app.ui.gui.utils.SharedMethods;
import auth.mappers.dto.UserRoleDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginUI implements Initializable {

    private Main mainApp;
    private AuthController authController;
    private Stage stage;

    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button developersButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        authController = new AuthController();
    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void showDevelopersScreen(ActionEvent actionEvent) {
        DevelopersUI developersUI = (DevelopersUI) this.mainApp.changeStageContent("/fxml/AboutDevelopersScreen.fxml");
        developersUI.setMainApp(mainApp);
    }

    @FXML
    private void doLogin(ActionEvent actionEvent) {
        String email = emailField.getText();
        String password = passwordField.getText();
        boolean success;
        if (!email.isBlank() && !password.isBlank()) {
            success = authController.doLogin(email, password);

            if (!success) {
                SharedMethods.infoAlert("Invalid UserId and/or Password.", "Login Error");
            } else {
                List<UserRoleDTO> roles = this.authController.getUserRoles();
                if ((roles == null) || (roles.isEmpty())) {
                    SharedMethods.infoAlert("Login Error", "User has no valid roles.");
                } else {
                    UserRoleDTO role = roles.get(0);
                    getUiForRole(role);
                }
            }
        } else {
            SharedMethods.infoAlert("Email/Password fields can't be empty", "Login Error");
        }
    }

    private void getUiForRole(UserRoleDTO role) {
        switch (role.getDescription()) {
            case Constants.ROLE_ADMIN:
                AdminMenuUI adminMenuUI = (AdminMenuUI) this.mainApp.changeStageContent("/fxml/AdminMenu.fxml");
                adminMenuUI.setMainApp(mainApp);
                break;

            case Constants.ROLE_RECEPTIONIST:
                ReceptionistMenuUI receptionistMenuUI = (ReceptionistMenuUI) this.mainApp.changeStageContent("/fxml/ReceptionistMenu.fxml");
                receptionistMenuUI.setMainApp(mainApp);
                break;

            case Constants.ROLE_MEDICAL_LAB_TECHNICIAN:
                MedLabTechnicianMenuUI labTechnicianMenuUI = (MedLabTechnicianMenuUI) this.mainApp.changeStageContent("/fxml/MedLabTechnicianMenu.fxml");
                labTechnicianMenuUI.setMainApp(mainApp);
                break;

            case Constants.ROLE_CLINICAL_CHEMISTRY_TECHNOLOGIST:
                ClinicalChemistryTechnologistMenuUI cCTechnologistUI = (ClinicalChemistryTechnologistMenuUI) this.mainApp.changeStageContent("/fxml/ClinicalChemistryTechnologistMenu.fxml");
                cCTechnologistUI.setMainApp(mainApp);
                break;

            case Constants.ROLE_SPECIALIST_DOCTOR:
                SpecialistDoctorMenuUI specialistDoctorMenuUI = (SpecialistDoctorMenuUI) this.mainApp.changeStageContent("/fxml/SpecialistDoctorMenu.fxml");
                specialistDoctorMenuUI.setMainApp(mainApp);
                break;

            case Constants.ROLE_LAB_COORDINATOR:
                LabCoordinatorMenuUI labCoordinatorMenuUI = (LabCoordinatorMenuUI) this.mainApp.changeStageContent("/fxml/LabCoordinatorMenu.fxml");
                labCoordinatorMenuUI.setMainApp(mainApp);
                break;

            case Constants.ROLE_CLIENT:
                ClientUI clientUI = (ClientUI) this.mainApp.changeStageContent("/fxml/ClientMenu.fxml");
                clientUI.setMainApp(mainApp);
                break;
        }
    }




}
