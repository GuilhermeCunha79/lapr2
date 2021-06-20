package app.controller;

import app.domain.model.MultipleLinearRegression;
import app.domain.model.SimpleLinearRegression;
import app.domain.store.TestStore;
import com.nhs.report.Report2NHS;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SendNHSReportController {

    private TestStore testStore;
    private double ic;
    private String firstDate;
    private String lastDate;

    private LocalDate firstDateToFitRegressionModel;
    private LocalDate lastDateToFitRegressionModel;

    List<LocalDate> lDatesToFitRegressionModel;

    public SendNHSReportController(String regressionModel, String independentVariable, String firstDate, String lastDate, double ic) {
        this.ic = ic;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        firstDateToFitRegressionModel = LocalDate.parse(firstDate, formatter);
        lastDateToFitRegressionModel = LocalDate.parse(lastDate, formatter);
        lDatesToFitRegressionModel = createListOfDates(firstDateToFitRegressionModel, lastDateToFitRegressionModel);
        this.testStore = App.getInstance().getCompany().getTestStore();
        if (regressionModel.equals("Simple Linear Regression Model")) {
            if (independentVariable.equals("Mean age"))
                sendDailyNhsReportSLR(1);
            else
                sendDailyNhsReportSLR(0);
        } else {
            sendDailyNhsReportMLR();
        }
    }

    /**
     * This method gathers the necessary data needed for the simple regression model and also decides which data will be used by comparing their performance in the regression model
     * Then it will send the report to the NHS using their API
     *
     * @param id
     */
    private void sendDailyNhsReportSLR(int id) {
        double[] arrayOfPositiveCovidTests = testStore.getPositiveTestsForEachDayOfList(lDatesToFitRegressionModel);
        double[] arrayOfNumberOfCovidTestsPerformed = testStore.getCovidTestCountForEachDayOfList(lDatesToFitRegressionModel);
        double[] arrayOfMeanAgesForCovidClientForEachDayOfList = testStore.getMeanAgesForCLientWithCovidForEachDayOfList(lDatesToFitRegressionModel);
        SimpleLinearRegression slr;
        if(id == 1) {
            slr = new SimpleLinearRegression(lDatesToFitRegressionModel, arrayOfMeanAgesForCovidClientForEachDayOfList, arrayOfPositiveCovidTests, ic);
        }else
            slr = new SimpleLinearRegression(lDatesToFitRegressionModel, arrayOfNumberOfCovidTestsPerformed, arrayOfPositiveCovidTests, ic);
        Report2NHS.writeUsingFileWriter(slr.toString());
    }

    /**
     * This method gathers the necessary data for the multiple linear regression model and then sends the repor to nhs using their API
     *
     *
     */
    private void sendDailyNhsReportMLR() {
        double[] arrayOfPositiveCovidTests = testStore.getPositiveTestsForEachDayOfList(lDatesToFitRegressionModel);
        double[] arrayOfNumberOfCovidTestsPerformed = testStore.getCovidTestCountForEachDayOfList(lDatesToFitRegressionModel);
        double[] arrayOfMeanAgesForCovidClientForEachDayOfList = testStore.getMeanAgesForCLientWithCovidForEachDayOfList(lDatesToFitRegressionModel);

        MultipleLinearRegression mlr = new MultipleLinearRegression(lDatesToFitRegressionModel, arrayOfPositiveCovidTests, arrayOfNumberOfCovidTestsPerformed, arrayOfMeanAgesForCovidClientForEachDayOfList, ic);
        Report2NHS.writeUsingFileWriter(mlr.toString());
    }

    /**
     * This method creates a list of all dates in between two dates but excluding all sundays
     *
     * @param firstDate
     * @param lastDate
     * @return
     */
    private List<LocalDate> createListOfDates(LocalDate firstDate, LocalDate lastDate) {
        LocalDate currentDate = firstDate;
        List<LocalDate> listOfDates = new ArrayList<>();
        while (!currentDate.equals(lastDate)) {
            if (!currentDate.getDayOfWeek().equals(DayOfWeek.SUNDAY))
                listOfDates.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }
        return listOfDates;
    }

}
