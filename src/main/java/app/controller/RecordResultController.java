package app.controller;

import app.domain.model.Company;
import app.domain.model.Result;
import app.domain.model.Test;
import app.domain.store.TestStore;
import app.mappers.TestListMapper;

import java.util.List;

public class RecordResultController {
    private TestStore testStore;

    private Test test;

    private Result result;

    public RecordResultController(){
        this(App.getInstance().getCompany());
    }

    public RecordResultController(Company company){
        this.testStore = company.getTestStore();
    }

    public List<String> getTestWithoutResult(){
        List<Test> testList = testStore.getTestsWithoutResults();
        if(!testList.isEmpty()) {
            TestListMapper tlm = new TestListMapper();
            return tlm.toDto(testList);
        }
        return null;
    }

    public Result getTestResults(String testCode){
        this.test = testStore.getTestByCode(testCode);
        return test.getTestResults();
    }

    public void newResult(String text){
        this.result = new Result(text);
    }

    public void saveResult(Test test){
        test.addResult(this.result);
    }

}
