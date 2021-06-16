package app.controller;

import app.domain.model.Company;
import app.domain.model.ClinicalTest;
import app.domain.model.SimpleRegressionModel;
import app.domain.store.TestStore;
import app.mappers.TestListMapper;

import java.util.List;

public class SendNHSReportControler {

    private TestStore testStore;

    private ClinicalTest test;

    private SimpleRegressionModel simpModel;
    /**
     * This constructor finds the instance of the company being used by the app
     */
    public SendNHSReportControler(){
        this(App.getInstance().getCompany());
    }

    /**
     * This constructor finds the testStore used by the company
     */
    public SendNHSReportControler(Company company){
        this.testStore = company.getTestStore();
    }

    /**
     * This method returns a list with the main information about each test available without a report
     * @return a list of Strings holding the data for each test
     */
    public List<String> getFinalisedTest(){
        List<ClinicalTest> FinalisedTest = testStore.getTestFinalizated();
        if(!FinalisedTest.isEmpty()) {
            return TestListMapper.toDto(FinalisedTest);
        }
        return null;
    }


}
