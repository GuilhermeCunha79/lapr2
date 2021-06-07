package app.controller;

import app.domain.model.ClinicalTest;
import app.domain.model.Company;
import app.domain.store.TestStore;
import app.mappers.TestReadyToValidateMapper;

import java.util.ArrayList;
import java.util.List;

public class ValidationController {

    private TestStore testStore;
    private final List<ClinicalTest> testValidationList = new ArrayList<>();
    private ClinicalTest test;

    public ValidationController() {
        this(App.getInstance().getCompany());
    }

    public ValidationController(Company company) {
        testStore = company.getTestStore();
    }


    public List<String> getTestWithoutValidation() {
        List<ClinicalTest> readyToValidate = testStore.getTestWithoutValidation();
        if (readyToValidate != null) {
            TestReadyToValidateMapper trv = new TestReadyToValidateMapper();
            return trv.toDtoVal(readyToValidate);
        }
        return null;
    }


    public String getTestResults(String testCode) {
        this.test = testStore.getTestByCode(testCode);
        return test.getTestValidation();
    }

    public boolean saveValidation(String internalCode) {
        return testStore.doValidationOne(internalCode);
    }

    public String getTestByCode(String testCode) {
        this.test = testStore.getTestByCode(testCode);
        return test.getTestResults();
    }


    public boolean doValidation(List<String> testValidationList) {
        return testStore.doValidation(testValidationList);
    }
    public List<ClinicalTest> getTestList() {
        return App.getInstance().getCompany().getTestStore().getTestList();
    }
}