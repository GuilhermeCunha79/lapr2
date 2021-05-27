package app.controller;

import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.store.TestStore;
import app.mappers.TestReadyToValidateMapper;

import java.util.ArrayList;
import java.util.List;

public class ValidationController {

    private TestStore testStore;
    private List<Test> testList = new ArrayList<>();
    private Test test;

    public ValidationController(){
        this(App.getInstance().getCompany());
    }

    public ValidationController(Company company){
        this.testStore = company.getTestStore();
    }


    public List<String> readyToValidate(){
        List<Test> readyToValidate = testStore.getTestList();
        if(readyToValidate != null) {
            TestReadyToValidateMapper testReady = new TestReadyToValidateMapper();
            return testReady.toDtoVal(readyToValidate);
        }
        return null;
    }


    public Test getTestByCode(String internalCode) {
        for (Test test : testList) {
            if (test.getInternalCode().equals(internalCode))
                return test;
        }
        return null;
    }


        public boolean changeStateToValidate(List <String> testList){
            if(!testList.isEmpty()) {
                for (String test : testList) {
                    this.test = getTestByCode(test.substring(15, 27));
                    this.test.changeStateValidationToDone();
                }
                return true;
            }
            return false;
        }



    //public doValidation(testValidationList)
    public List<Test> getTestList() {
        return App.getInstance().getCompany().getTestStore().getTestList();
    }
}