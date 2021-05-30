package app.controller;

import app.domain.model.CATest;
import app.domain.model.Company;
import app.domain.store.TestStore;
import app.mappers.TestReadyToValidateMapper;

import java.util.ArrayList;
import java.util.List;

public class ValidationController {

    private TestStore testStore;
    private final List<CATest> testValidationList = new ArrayList<>();
    private CATest test;

    public ValidationController() {
        this(App.getInstance().getCompany());
    }

    public ValidationController(Company company) {
        testStore = company.getTestStore();
    }


    public List<String> getTestWithoutValidation() {
        List<CATest> readyToValidate = testStore.getTestWithoutValidation();
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

    public boolean saveValidation() {
        return this.test.addValidation();
    }

}