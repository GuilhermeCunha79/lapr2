package app.controller;

import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.store.TestStore;
import app.mappers.TestReadyToValidateMapper;

import java.util.ArrayList;
import java.util.List;

public class ValidationController {

    private static TestStore testStore;
    private List<Test> testValidationList = new ArrayList<>();
    private Test test;

    public ValidationController() {
        this(App.getInstance().getCompany());
    }

    public ValidationController(Company company) {
        this.testStore = company.getTestStore();
    }

    public void displayList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public List<String> readyToValidate() {
        List<Test> readyToValidate = testStore.getTestList();
        if (readyToValidate != null) {
            TestReadyToValidateMapper testReady = new TestReadyToValidateMapper();
            return testReady.toDtoVal(readyToValidate);
        }
        return null;
    }

    public List<String> getTestWithoutValidation() {
        List<Test> testWithoutValList = testStore.getTestWithoutValidation();
        if (testWithoutValList != null) {
            TestReadyToValidateMapper testMapper = new TestReadyToValidateMapper();
            return testMapper.toDtoVal(testWithoutValList);
        }
        return null;
    }

    public Test getTestByCode(String internalCode) {
        for (Test test : testValidationList) {
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

    public boolean doValidation(List<Test> testValidationList) {
        return this.testStore.doValidation(testValidationList);
    }

    public List<Test> getTestList() {
        return App.getInstance().getCompany().getTestStore().getTestList();
    }
}