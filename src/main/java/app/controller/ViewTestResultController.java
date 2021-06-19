package app.controller;

import app.domain.model.Client;
import app.domain.model.ClinicalTest;
import app.domain.model.Report;
import app.domain.store.ClientStore;
import app.domain.model.Company;
import app.domain.store.TestStore;
import app.mappers.TestListMapper;
import auth.domain.model.Email;

import java.util.List;


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



    public List<String> showClientTestsValidatedAndOrderedByRegistrationDate(Client client) {
        List<ClinicalTest> testListOrderedAndValidated = testStore.getClientTestsValidatedAndOrderedByRegistrationDate(client);
        if (testListOrderedAndValidated != null) {
            return TestListMapper.toDto(testListOrderedAndValidated);
        }
        return null;
    }
    /**
     * This method receives an internal code and finds the test that has it from the test store
     * @param internalCode to be used
     * @return returns the specify test associated to the client
     */

    public String showTestSelected(String internalCode) {
        this.clinicalTest = testStore.getTestByCode(internalCode);
        if (clinicalTest != null)
            return clinicalTest.toString();
        else
            return null;
    }

    /**
     * This method receives an internal code and finds the test that has it from the test store, then, returns all of its test results
     * @param internalCode to be used
     * @return all the parameter tested results of the client
     */
    public String getTestResults(String internalCode) {
        this.clinicalTest = testStore.getTestByCode(internalCode);
        return clinicalTest.getTestResults();
    }


}