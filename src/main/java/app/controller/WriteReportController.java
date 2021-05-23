package app.controller;

import app.domain.model.Company;
import app.domain.model.Report;
import app.domain.model.Test;
import app.domain.store.TestStore;
import app.mappers.TestListMapper;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

public class WriteReportController {

    private TestStore testStore;

    private Test test;

    private Report report;

    public WriteReportController(){
        this(App.getInstance().getCompany());
    }

    public WriteReportController(Company company){
        this.testStore = company.getTestStore();
    }

    public List<String> getTestWithoutReport(){
        List<Test> lTestNoReport = testStore.getTestWithoutReport();
        if(!lTestNoReport.isEmpty()) {
            TestListMapper tlm = new TestListMapper();
            return tlm.toDto(lTestNoReport);
        }
        return null;
    }

    public String getTestResults(String testCode){
        this.test = testStore.getTestByCode(testCode);
        return test.getTestResults();
    }

    public void newReport(String text){
        this.report = new Report(text);
    }

    public void saveReport(){
        this.test.addReport(this.report);
    }

}
