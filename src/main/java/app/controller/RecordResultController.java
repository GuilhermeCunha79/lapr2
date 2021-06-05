package app.controller;


import app.domain.model.Company;
import app.domain.model.ClinicalTest;
import app.domain.store.TestStore;
import app.mappers.ParameterMapper;
import app.mappers.TestListMapper;

import java.util.List;

public class RecordResultController {

    private final TestStore testStore;
    private ClinicalTest test;

    /**
     * Constructor that gets the instance of the company being used
     */
    public RecordResultController(){
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor that gets the test store used by the company
     * @param company
     */
    public RecordResultController(Company company){
        this.testStore = company.getTestStore();
    }

    /**
     * This method returns all the tests without results that were created in the same lab from where the user is working from
     * @param labId ID of the clinical analysis lab
     * @return a list with the tests that matches the requirements
     */
    public List<String> getListOfTestWithoutResult(String labId){
        List<ClinicalTest> testList = testStore.getTestsWithoutResults(labId);
        if(testList!=null && !testList.isEmpty()) {
            TestListMapper tlm = new TestListMapper();
            return tlm.toDto(testList);
        }
        return null;
    }

    /**
     * This method returns the list of parameters assigned to a test with the same code as the one received by parameter
     * @param internalCode of the test
     * @return a list with all the parameters
     */
    public List<String> getTest(String internalCode){
        this.test = testStore.getTestByCode(internalCode);
        return ParameterMapper.toDto(this.test.getParameterList());
    }

    /**
     * This method adds a value and metric to a parameter in order to save the result
     * @param internalCode of the parameter
     * @param value measured when testing the parameter
     * @param metric used to measure a value
     * @return
     */
    public boolean addParameterTestResult(String internalCode, double value, String metric){
        return test.addTestParameterResult(internalCode, value, metric);
    }

    /**
     * This method returns the results of all the parameter tested
     * @return a string with the results
     */
    public String getTestResults(){
        return this.test.getTestResults();
    }

    /**
     * After all the results were saved, this method is called to change the state of the test to tell that the results are done
     * @return if the state was changed or not
     */
    public boolean changeStateToResultDone(){
        return test.changeStateToResultDone();
    }
}
