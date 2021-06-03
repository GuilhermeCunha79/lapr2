package app.domain.store;

import app.domain.model.CATest;
import app.domain.model.Client;
import app.domain.model.Parameter;
import app.domain.model.TypeOfTest;


import app.domain.shared.DateTime;
import app.domain.shared.SendingEmailSMS;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestStore implements Serializable {

    private CATest test;
    private List<CATest> testList = new ArrayList<>();


    /**
     * Method to add a parameter to test
     * @param parameter parameter object to be added
     * @return true if added with success
     */
    public boolean addParameter(Parameter parameter) {
        return this.test.addParameter(parameter);
    }

    public void setTestList(List<CATest> testList){
        this.testList = new ArrayList<>(testList);
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
        this.test = new CATest(nhsCode, client, typeOfTest, lParameter, labWhereCreated, this.testList.size()+1);
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
    public boolean addTest(CATest test) {
        return this.testList.add(test);
    }


    /**
     * Method to save a test object
     * @param test object test to be saved
     * @return true if added with success, false if not
     */
    public boolean saveTest(CATest test) {
        if(validateTest(test)) {
            addTest(test);
            serializeStore();
            return true;
        }
        return false;
    }



    private void serializeStore() {
        try{
            FileOutputStream out = new FileOutputStream("data\\test.dat");
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(this.testList);
            outputStream.close();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public List<CATest> getTestsWithoutResults(String labId) {
        System.out.println(testList.size());
        List<CATest> lTestNoResult = new ArrayList<>();
        for (CATest recordTest : testList) {
            if (!recordTest.getResultStatus() && recordTest.getLabWhereCreated().equals(labId))
                lTestNoResult.add(recordTest);
        }
        if (lTestNoResult.isEmpty())
            return Collections.emptyList();
        else
            return lTestNoResult;
    }

    public List<CATest> getTestWithoutSample() {
        List<CATest> lTestNoSample = new ArrayList<>();
        if (!testList.isEmpty()) {
            for (CATest caTest : testList) {
                if (!caTest.getSampleStatus())
                    lTestNoSample.add(caTest);
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
            for (CATest caTest : testList) {
                if (!caTest.getReportStatus())
                    lTestNoReport.add(caTest);
            }
            if (lTestNoReport.isEmpty())
                return Collections.emptyList();
            else
                return lTestNoReport;
        } else {
            return Collections.emptyList();
        }
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
     * Method that returns a CATest by its code
     * @param internalCode
     * @return caTest or null
     */
    public CATest getTestByCode(String internalCode) {
        for (CATest caTest : testList) {
            if (caTest.getInternalCode().equals(internalCode))
                return caTest;
        }
        return null;
    }

    /***
     * Method that makes the validation of a List of Tests
     * @param testWithoutValidation
     * @return true or false
     */
    public boolean doValidation(List<String> testWithoutValidation) {
        if (!testWithoutValidation.isEmpty()) {
            for (CATest caTest:testList) {
                if (!caTest.getValidationStatus()) {
                    CATest test1 = getTestByCode(caTest.getInternalCode());
                    Client client = test1.getClient();
                    String name = client.getName();
                    caTest.changeStateValidationToDone();
                    DateTime validatedAt= caTest.getValidationDate();
                    SendingEmailSMS.sendEmailWithNotification(name,validatedAt);
                }
            }
            return true;
        }
        return false;
    }

    /***
     *
     * @param internalCode
     * @return
     */
    public boolean doValidationOne(String internalCode) {
        if (internalCode!=null) {
                CATest test1= getTestByCode(internalCode);
                Client client = test1.getClient();
                String name = client.getName();
                test1.changeStateValidationToDone();
                DateTime validatedAt= test1.getValidationDate();
                SendingEmailSMS.sendEmailWithNotification(name,validatedAt);
            return true;
        }
        return false;
    }
}

