package app.controller;

import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.store.TestStore;
import app.mappers.TestReadyToValidateMapper;

import java.util.List;

public class ValidationController {

    private TestStore testStore;

    private Test test;

    public ValidationController(){
        this(App.getInstance().getCompany());
    }

    public ValidationController(Company company){
        this.testStore = company.getTestStore();
    }


    public List<String> getTestReadyToValidate(){
        List<Test> readyToValidate = testStore.getTestWithoutReport();
        if(readyToValidate != null) {
            TestReadyToValidateMapper testReady = new TestReadyToValidateMapper();
            return testReady.toDtoVal(readyToValidate);
        }
        return null;
    }


    public String getTestByCode(String internalCode){
        this.test=testStore.getTestByCode(internalCode);
        return test.getTestResults();
    }


}