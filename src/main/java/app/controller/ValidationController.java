package app.controller;

import app.domain.model.CATest;
import app.domain.model.Company;
import app.domain.store.TestStore;
import app.mappers.TestReadyToValidateMapper;

import java.util.ArrayList;
import java.util.List;

public class ValidationController {

    private TestStore testStore;
    private List<CATest> testValidationList = new ArrayList<>();
    private CATest test;

    public ValidationController() {
        this(App.getInstance().getCompany());
    }

    public ValidationController(Company company) {
        testStore = company.getTestStore();
    }


    public List<String> readyToValidate() {
        List<CATest> readyToValidate = testStore.getTestList();
        if (readyToValidate != null) {
            TestReadyToValidateMapper testReady = new TestReadyToValidateMapper();
            return testReady.toDtoVal(readyToValidate);
        }
        return null;
    }

    public List<String> getTestWithoutValidation() {
        List<CATest> testWithoutValList = testStore.getTestWithoutValidation();
        if (testWithoutValList != null) {
            TestReadyToValidateMapper testMapper = new TestReadyToValidateMapper();
            return testMapper.toDtoVal(testWithoutValList);
        }
        return null;
    }

    public CATest getTestByCode(String internalCode) {
        for (CATest test : testValidationList) {
            if (test.getInternalCode().equals(internalCode))
                return test;
        }
        return null;
    }

//VER SE É NECESSÁRIO
    public boolean changeStateToValidate(List<String> testList) {
        if (!testList.isEmpty()) {
            for (String test : testList) {
                this.test = getTestByCode(test.substring(15, 27));
                this.test.changeStateValidationToDone();
            }
            return true;
        }
        return false;
    }

    public boolean changeStateToValidateOne(String internalCode) {
        if (test != null) {
            this.test = getTestByCode(internalCode);
            this.test.changeStateValidationToDone();
            return true;
        }
        return false;
    }

    public boolean doValidation(List<String> testValidationList) {
        return testStore.doValidation(testValidationList);
    }

    public void displayList(List<String> list){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public List<CATest> getTestList() {
        return App.getInstance().getCompany().getTestStore().getTestList();
    }
}