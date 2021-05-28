package app.domain.store;

import app.domain.model.Client;
import app.domain.model.Parameter;
import app.domain.model.Test;
import app.domain.model.TypeOfTest;


import app.domain.shared.SendingEmailSMS;

import java.util.ArrayList;
import java.util.List;

public class TestStore {

    private Test test;
    private List<Test> testList = new ArrayList<>();


    /**
     * Method to add a parameter to test
     * @param parameter parameter object to be added
     * @return true if added with success
     */
    public boolean addParameter(Parameter parameter) {
        return this.test.addParameter(parameter);
    }

    /**
     * Method to create a new test
     * @param nhsCode of the test
     * @param client object of the Client
     * @param typeOfTest object of the TestType
     * @param lParameter object of the Parameter
     * @return
     */
    public Test createTest(String nhsCode, Client client, TypeOfTest typeOfTest, List<Parameter> lParameter) {
        this.test = new Test(nhsCode, client, typeOfTest, lParameter);
        return this.test;
    }

    /**
     * Method  to get the type of tests list
     * @return List<Test>
     */
    public List<Test> getTestList() {
        return new ArrayList<>(this.testList);
    }

    /**
     * Method to validate test
     * @param testCreated object of the test to be validated
     * @return true if test created is valid
     */
    public boolean validateTest(Test testCreated) {
        if (testCreated == null)
            return false;
        for (Test test : testList) {
            if (test.equals(testCreated)) {
                System.out.println(testCreated);
                return false;
            }
        }
        return !this.testList.contains(testCreated);
    }

    /**
     * Method to add a test to the list of the types of test
     * @param test object test to be added
     * @return
     */
    private boolean addTest(Test test) {
        return this.testList.add(test);
    }


    /**
     * Method to save a test object
     * @param test object test to be saved
     * @return true if added with success, false if not
     */
    public boolean saveTest(Test test) {
        if(validateTest(test)) {
            return addTest(test);
        }
        return false;
    }


    public List<Test> getTestsWithoutResults() {
        System.out.println(testList.size());
        List<Test> lTestNoResult = new ArrayList<>();
        for (Test recordTest : testList) {
            if (!recordTest.getResultStatus())
                lTestNoResult.add(recordTest);
        }
        if (lTestNoResult.isEmpty())
            return null;
        else
            return lTestNoResult;
    }

    public List<Test> getTestWithoutSample() {
        List<Test> lTestNoSample = new ArrayList<>();
        if (!testList.isEmpty()) {
            for (Test test : testList) {
                if (!test.getReportStatus())
                    lTestNoSample.add(test);
            }
            if (lTestNoSample.isEmpty())
                return null;
            else
                return lTestNoSample;
        } else {
            return null;
        }
    }

    public List<Test> getTestWithoutReport() {
        List<Test> lTestNoReport = new ArrayList<>();
        if (!testList.isEmpty()) {
            for (Test test : testList) {
                if (!test.getReportStatus())
                    lTestNoReport.add(test);
            }
            if (lTestNoReport.isEmpty())
                return null;
            else
                return lTestNoReport;
        } else {
            return null;
        }
    }

    /***
     * Method responsible for getting a test by its internalCode
     * @param internalCode
     * @return
     */
    public Test getTestByCode(String internalCode) {
        for (Test test : testList) {
            if (test.getInternalCode().equals(internalCode))
                return test;
        }
        return null;
    }

    /***
     * Saves tests that wasn't validated yet in a List
     * @return testWithoutValidation or null
     */
    public List<Test> getTestWithoutValidation() {
        List<Test> testWithoutValidation = new ArrayList<>();
        if (!testList.isEmpty()) {
            for (Test test : testList) {
                if (!test.getValidationStatus())
                    testWithoutValidation.add(test);
            }
            if (testWithoutValidation.isEmpty())
                return null;
            else
                return testWithoutValidation;
        } else {
            return null;
        }
    }

    /***
     * Method that makes the validation of a List of Tests
     * @param testWithoutValidation
     * @return true or false
     */
    public boolean doValidation(List<Test> testWithoutValidation) {

        if (testWithoutValidation.isEmpty()) {
            for (Test test:testList) {
                Test test1= getTestByCode(test.getInternalCode());
                Client client = test1.getClient();
                String name = client.getName();
                test.changeStateValidationToDone();
                SendingEmailSMS.sendEmailWithNotification(name);
                return true;
            }

        }
        return false;
    }
}

