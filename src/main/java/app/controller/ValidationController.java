package app.controller;

import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.store.TestStore;
import app.mappers.TestListMapper;
import app.mappers.TestReadyToValidateMapper;

import java.util.List;
import java.util.Objects;

public class ValidationController {

    private TestStore testStore;

    private Test test;

    public ValidationController(){
        this(App.getInstance().getCompany());
    }

    public ValidationController(Company company){
        this.testStore = company.getTestStore();
    }


    public List<String> testValidationList(){
        List<Test> readyToValidate = testStore.getTestList();
        if(readyToValidate != null) {
            TestReadyToValidateMapper testReady = new TestReadyToValidateMapper();
            return testReady.toDtoVal(readyToValidate);
        }
        return null;
    }


    public Test getTestByCode(String internalCode){
        if(internalCode!=null) {
            this.test = testStore.getTestByCode(internalCode);
            return testStore.createValidateTest(test);
        }
        return null;
    }

    public List<Test> getTestList() {
        return App.getInstance().getCompany().getTestStore().getTestList();
    }
}