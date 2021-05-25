package app.controller;

import app.domain.model.Company;
import app.domain.store.TestStore;

public class ValidationWorkController {

    private TestStore testStore;

    public ValidationWorkController(){
        this(App.getInstance().getCompany());
    }

    public ValidationWorkController(Company company){
        this.testStore = company.getTestStore();
    }

    public String getRegistrationDate(String date){
        this.test = testStore.getRegistrationDate(date);
        return test.getRegistrationDate();
    }

    public String getClinicalAnalysisDate(String date){
        this.test = testStore.getClinicalAnalysisDate(date);
        return test.getClinicalAnalysisDate();
    }

    public String getDiagnosisDate(String date){
        this.test = testStore.getDiagnosisDate(date);
        return test.getDiagnosisDate();
    }
}
