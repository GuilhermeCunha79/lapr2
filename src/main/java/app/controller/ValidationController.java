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


    public List<String> getTestWithoutValidation() {
        List<CATest> readyToValidate = testStore.getTestList();
        if (readyToValidate != null) {
            return TestReadyToValidateMapper.toDtoVal(readyToValidate);
        }
        return null;
    }


    public String getTestByCode(String testCode){
        this.test = testStore.getTestByCode(testCode);
        return test.getTestResults();
    }
//VER SE É NECESSÁRIO
    public boolean changeStateToValidate(List<String> testList) {
        if (!testList.isEmpty()) {
            for (String test : testList) {
                //this.test = getTestByCode(test.substring(15, 27));
                this.test.changeStateValidationToDone();
            }
            return true;
        }
        return false;
    }

    public boolean changeStateToValidateOne(String internalCode) {
        if (test != null) {
            //this.test = getTestByCode(internalCode);
            this.test.changeStateValidationToDone();
            return true;
        }
        return false;
    }

    public boolean doValidation(List<String> testValidationList) {
        return testStore.doValidation(testValidationList);
    }

    public boolean doValidationOne(String internalCode) {
        return testStore.doValidationOne(internalCode);
    }

    public String getTestResults(String testCode){
        this.test = testStore.getTestByCode(testCode);
        return test.getTestValidation();
    }

    public boolean saveValidation(){
        return this.test.changeStateValidationToDone();
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