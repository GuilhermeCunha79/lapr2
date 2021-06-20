package app.ui.gui;

import app.controller.PerformanceController;
import app.domain.shared.DateTime;
import app.ui.Main;
import app.ui.gui.utils.SharedMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PerformanceUI implements Initializable {

    private Main mainApp;

    private PerformanceController performanceController;

    @FXML
    private LineChart graphLine;

    @FXML
    private Button generateBtn;

    @FXML
    private Button returnBtn;

    @FXML
    private TextField fromDateTextField;

    @FXML
    private TextField fromHourTextField;

    @FXML
    private TextField untilDateTextField;

    @FXML
    private TextField untilHourTextField;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        performanceController = new PerformanceController();
    }

    @FXML
    private void createGraph(ActionEvent actionEvent) {
        String fromDate = fromDateTextField.getText();
        String fromHour = fromHourTextField.getText();
        String untilDate = untilDateTextField.getText();
        String untilHour = untilHourTextField.getText();
        if(fromDate.isEmpty() || fromHour.isEmpty() || untilHour.isEmpty() || untilDate.isEmpty()){
            SharedMethods.infoAlert("Text fields cannot be empty", "Error");
        }else{
            performanceController.newPerformance(new DateTime(fromDate, fromHour), new DateTime(untilDate, untilHour));
            graphLine = performanceController.getChart();
        }


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
