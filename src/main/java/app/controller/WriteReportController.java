package app.controller;

import app.domain.model.Company;
import app.domain.model.Report;
import app.domain.model.ClinicalTest;
import app.domain.store.TestStore;
import app.mappers.TestListMapper;

import java.util.List;

public class WriteReportController {

    private TestStore testStore;

    private ClinicalTest test;

    private Report report;

    /**
     * This constructor finds the instance of the company being used by the app
     */
    public WriteReportController(){
        this(App.getInstance().getCompany());
    }
    /**
     * This constructor finds the testStore used by the company
     */
    public WriteReportController(Company company){
        this.testStore = company.getTestStore();
    }

    /**
     * This method returns a list with the main information about each test available without a report
     * @return a list of Strings holding the data for each test
     */
    public List<String> getTestWithoutReport(){
        List<ClinicalTest> lTestNoReport = testStore.getTestWithoutReport();
        if(!lTestNoReport.isEmpty()) {
            return TestListMapper.toDto(lTestNoReport);
        }
        return null;
    }

    /**
     * This method receives an internal code and finds the test that has it from the test store, then, returns all of its test results
     * @param testCode internal code to be used
     * @return all the parameter tested results
     */
    public String getTestResults(String testCode){
        this.test = testStore.getTestByCode(testCode);
        return test.getTestResults();
    }

    /**
     * This method receives a text and creates a new instance of a report to save the text
     * @param text
     */
    public void newReport(String text){
        this.report = new Report(text);
    }

    /**
     * When everything is confirmed by the user, this method saves the report created as an attribute of its test
     */
    public boolean saveReport(){
        return this.test.addReport(this.report);
    }

}
