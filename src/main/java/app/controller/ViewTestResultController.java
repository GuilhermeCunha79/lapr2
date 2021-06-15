package app.controller;

import app.domain.model.Client;
import app.domain.model.ClinicalTest;
import app.domain.model.Report;
import app.domain.store.ClientStore;
import app.domain.model.Company;
import app.domain.store.TestStore;


public class ViewTestResultController {

    private final ClientStore ctStore;
    private Client ct;
    private final TestStore testStore;
    private ClinicalTest clinicalTest;
    private Report report;


    public ViewTestResultController() {
        this(App.getInstance().getCompany());
    }

    public ViewTestResultController(Company company) {
        this.ctStore = company.getClientStore();
        this.ct = null;
        this.testStore = company.getTestStore();
        this.report = null;
        this.clinicalTest = null;
    }

    public Client getClientByEmail() {
        return this.ct = this.ctStore.getClientByEmail();
    }

    public ClinicalTest getTestSelected(String nhsCode) {
        return this.clinicalTest = this.testStore.getTestByNhsCode(nhsCode);
    }


    public String showTestResults() {
        this.ct = ctStore.getClientByEmail();
        return this.clinicalTest.getTestResults();
    }

    public Report showReportText() {

    }


}







