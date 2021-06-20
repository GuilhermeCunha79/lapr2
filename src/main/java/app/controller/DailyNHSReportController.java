package app.controller;

import app.domain.model.MultipleLinearRegression;
import app.domain.model.SimpleLinearRegression;
import app.domain.store.TestStore;
import app.ui.console.utils.Utils;
import com.nhs.report.Report2NHS;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DailyNHSReportController{

    private TestStore testStore;

    /**
     * This constructor is responsible for getting the regression model, through the configuration file, that will be used for the NHS report
     */
    public DailyNHSReportController() {
        this.testStore = App.getInstance().getCompany().getTestStore();
        try {
            if(Objects.equals(getValuesFromConfigFile("Company.RegressionModel"), "MLR")){
                sendDailyNhsReportMLR(testStore);
            }else if(Objects.equals(getValuesFromConfigFile("Company.RegressionModel"), "SLR")){
                sendDailyNhsReportSLR(testStore);
            }else{
                throw new IllegalArgumentException("INFO: Configuration file has invalid regression model value");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method gathers the necessary data needed for the simple regression model and also decides which data will be used by comparing their performance in the regression model
     * Then it will send the report to the NHS using their API
     * @param testStore
     */
    private void sendDailyNhsReportSLR(TestStore testStore) {
        double ic = Double.parseDouble(Objects.requireNonNull(getValuesFromConfigFile("Company.confidenceValueNhsReport")));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String firstDate = (Objects.requireNonNull(getValuesFromConfigFile("Company.FirstDayToFitRegressionModel")));
        LocalDate firstDateToFitRegressionModel = LocalDate.parse(firstDate, formatter);
        LocalDate lastDateToFitRegressionModel = firstDateToFitRegressionModel.plusDays(Integer.parseInt(Objects.requireNonNull(getValuesFromConfigFile("Company.NumberOfDaysToFitRegressionModel"))));
        List<LocalDate> lDatesToFitRegressionModel = createListOfDates(firstDateToFitRegressionModel, lastDateToFitRegressionModel);
        double[] arrayOfPositiveCovidTests = testStore.getPositiveTestsForEachDayOfList(lDatesToFitRegressionModel);
        double[] arrayOfNumberOfCovidTestsPerformed = testStore.getCovidTestCountForEachDayOfList(lDatesToFitRegressionModel);
        double[] arrayOfMeanAgesForCovidClientForEachDayOfList = testStore.getMeanAgesForCLientWithCovidForEachDayOfList(lDatesToFitRegressionModel);
        SimpleLinearRegression slrCovidTestsNumber = new SimpleLinearRegression(lDatesToFitRegressionModel, arrayOfPositiveCovidTests, arrayOfNumberOfCovidTestsPerformed, ic);
        SimpleLinearRegression slrMeanAges = new SimpleLinearRegression(lDatesToFitRegressionModel, arrayOfPositiveCovidTests, arrayOfMeanAgesForCovidClientForEachDayOfList, ic);
        if(slrCovidTestsNumber.getR2()>slrMeanAges.getR2())
            Report2NHS.writeUsingFileWriter(slrCovidTestsNumber.toString());
        Report2NHS.writeUsingFileWriter(slrMeanAges.toString());
    }

    /**
     * This method gathers the necessary data for the multiple linear regression model and then sends the repor to nhs using their API
     * @param testStore
     */
    private void sendDailyNhsReportMLR(TestStore testStore){
        double ic = Double.parseDouble(Objects.requireNonNull(getValuesFromConfigFile("Company.confidenceValueNhsReport")));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String firstDate = (Objects.requireNonNull(getValuesFromConfigFile("Company.FirstDayToFitRegressionModel")));
        LocalDate firstDateToFitRegressionModel = LocalDate.parse(firstDate, formatter);
        LocalDate lastDateToFitRegressionModel = firstDateToFitRegressionModel.plusDays(Integer.parseInt(Objects.requireNonNull(getValuesFromConfigFile("Company.NumberOfDaysToFitRegressionModel"))));
        List<LocalDate> lDatesToFitRegressionModel = createListOfDates(firstDateToFitRegressionModel, lastDateToFitRegressionModel);
        double[] arrayOfPositiveCovidTests = testStore.getPositiveTestsForEachDayOfList(lDatesToFitRegressionModel);
        double[] arrayOfNumberOfCovidTestsPerformed = testStore.getCovidTestCountForEachDayOfList(lDatesToFitRegressionModel);
        double[] arrayOfMeanAgesForCovidClientForEachDayOfList = testStore.getMeanAgesForCLientWithCovidForEachDayOfList(lDatesToFitRegressionModel);

        MultipleLinearRegression mlr = new MultipleLinearRegression(lDatesToFitRegressionModel, arrayOfPositiveCovidTests, arrayOfNumberOfCovidTestsPerformed, arrayOfMeanAgesForCovidClientForEachDayOfList, ic);
        Report2NHS.writeUsingFileWriter(mlr.toString());
    }

    /**
     * This method creates a list of all dates in between two dates but excluding all sundays
     * @param firstDate
     * @param lastDate
     * @return
     */
    private List<LocalDate> createListOfDates(LocalDate firstDate, LocalDate lastDate) {
        LocalDate currentDate = firstDate;
        List<LocalDate> listOfDates = new ArrayList<>();
        while (!currentDate.equals(lastDate)){
            if(!currentDate.getDayOfWeek().equals(DayOfWeek.SUNDAY))
                listOfDates.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }
        return listOfDates;
    }

    /**
     * This method receives a key by parameter and returns the corresponding value found in the configuration file
     * @param propertyName
     * @return
     */
    private String getValuesFromConfigFile(String propertyName) {
        Properties props = new Properties();
        try (InputStream in = new FileInputStream("config.properties")) {
            props.load(in);
            String value;
            value = props.getProperty(propertyName);
            return value;
        } catch (Exception e) {
            Utils.printToConsole(e.getLocalizedMessage());
            return null;
        }
    }
}
