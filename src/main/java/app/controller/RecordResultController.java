package app.controller;


import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.store.TestStore;
import app.mappers.ParameterMapper;
import app.mappers.TestListMapper;

import java.util.List;

public class RecordResultController {

    private final TestStore testStore;
    private Test test;

    public RecordResultController(){
        this(App.getInstance().getCompany());
    }

    public RecordResultController(Company company){
        this.testStore = company.getTestStore();
    }

    public List<String> getListOfTestWithoutResult(String labId){
        List<Test> testList = testStore.getTestsWithoutResults(labId);
        if(!testList.isEmpty()) {
            TestListMapper tlm = new TestListMapper();
            return tlm.toDto(testList);
        }
        return null;
    }

    public List<String> getTest(String internalCode){
        this.test = testStore.getTestByCode(internalCode);
        return ParameterMapper.toDto(this.test.getParameterList());
    }

    public boolean addParameterTestResult(String internalCode, double value, String metric){
        return test.addTestParameterResult(internalCode, value, metric);
    }

    public String getTestResults(){
        return this.test.getTestResults();
    }
    public boolean changeStateToResultDone(){
        return test.changeStateToResultDone();
    }
}
