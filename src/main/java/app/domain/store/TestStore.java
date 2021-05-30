package app.domain.store;

import app.domain.model.CATest;
import app.domain.model.Client;
import app.domain.model.Parameter;
import app.domain.model.TypeOfTest;


import app.domain.shared.SendingEmailSMS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestStore {

    private CATest test;
    private final List<CATest> testList = new ArrayList<>();


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
    public CATest createTest(String nhsCode, Client client, TypeOfTest typeOfTest, List<Parameter> lParameter, String labWhereCreated) {
        this.test = new CATest(nhsCode, client, typeOfTest, lParameter, labWhereCreated);
        return this.test;
    }

    /**
     * Method  to get the type of tests list
     * @return List<Test>
     */
    public List<CATest> getTestList() {
        return new ArrayList<>(this.testList);
    }

    /**
     * Method to validate test
     * @param testCreated object of the test to be validated
     * @return true if test created is valid
     */
    public boolean validateTest(CATest testCreated) {
        if (testCreated == null)
            return false;
        for (CATest test : testList) {
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
    private boolean addTest(CATest test) {
        return this.testList.add(test);
    }


    /**
     * Method to save a test object
     * @param test object test to be saved
     * @return true if added with success, false if not
     */
    public boolean saveTest(CATest test) {
        if(validateTest(test)) {
            return addTest(test);
        }
        return false;
    }


    public List<CATest> getTestsWithoutResults(String labId) {
        System.out.println(testList.size());
        List<CATest> lTestNoResult = new ArrayList<>();
        for (CATest recordTest : testList) {
            if (!recordTest.getResultStatus() && recordTest.getLabWhereCreated().equals(labId))
                lTestNoResult.add(recordTest);
        }
        if (lTestNoResult.isEmpty())
            return null;
        else
            return lTestNoResult;
    }

    public List<CATest> getTestWithoutSample(String labId) {
        List<CATest> lTestNoSample = new ArrayList<>();
        if (!testList.isEmpty()) {
            for (CATest test : testList) {
                if (!test.getReportStatus())
                    lTestNoSample.add(test);
            }
            if (lTestNoSample.isEmpty())
                return Collections.emptyList();
            else
                return lTestNoSample;
        } else {
            return Collections.emptyList();
        }
    }

    public List<CATest> getTestWithoutReport() {
        List<CATest> lTestNoReport = new ArrayList<>();
        if (!testList.isEmpty()) {
            for (CATest test : testList) {
                if (!test.getReportStatus())
                    lTestNoReport.add(test);
            }
            if (lTestNoReport.isEmpty())
                return Collections.emptyList();
            else
                return lTestNoReport;
        } else {
            return Collections.emptyList();
        }
    }

    public CATest getTestByCode(String internalCode) {
        for (CATest caTest : testList) {
            if (caTest.getInternalCode().equals(internalCode))
                return caTest;
        }
        return null;
    }

    /***
     * Saves tests that wasn't validated yet in a List
     * @return testWithoutValidation or null
     */
    public List<CATest> getTestWithoutValidation() {
        List<CATest> testWithoutValidation = new ArrayList<>();
        if (!testList.isEmpty()) {
            for (CATest caTest : testList) {
                if (!caTest.getValidationStatus())
                    testWithoutValidation.add(caTest);
            }
            if (testWithoutValidation.isEmpty())
                return Collections.emptyList();
            else
                return testWithoutValidation;
        } else {
            return Collections.emptyList();
        }
    }

    /***
     * Method that makes the validation of a List of Tests
     * @param testWithoutValidation
     * @return true or false
     */
    public boolean doValidation(List<String> testWithoutValidation) {

        if (!testWithoutValidation.isEmpty()) {
            for (CATest test:testList) {
                CATest test1= getTestByCode(test.getInternalCode());
                Client client = test1.getClient();
                String name = client.getName();
                test.changeStateValidationToDone();
                SendingEmailSMS.sendEmailWithNotification(name);
            }
            return true;
        }
        return false;
    }

    public boolean doValidationOne(String internalCode) {
        if (internalCode!=null) {
                CATest test1= getTestByCode(internalCode);
                Client client = test1.getClient();
                String name = client.getName();
                test1.changeStateValidationToDone();
                SendingEmailSMS.sendEmailWithNotification(name);
            return true;
        }
        return false;
    }
}

