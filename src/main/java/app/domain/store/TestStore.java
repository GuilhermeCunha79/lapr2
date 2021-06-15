package app.domain.store;

import app.domain.model.Client;
import app.domain.model.ClinicalTest;
import app.domain.model.Parameter;
import app.domain.model.TypeOfTest;
import app.domain.shared.DateTime;
import app.domain.shared.SendingEmailSMS;
import app.mappers.dto.ClinicalTestDto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static app.domain.shared.CommonMethods.serializeStore;

public class TestStore implements Serializable {

    private ClinicalTest test;
    private List<ClinicalTest> testList = new ArrayList<>();


    /**
     * Method to add a parameter to test
     *
     * @param parameter parameter object to be added
     * @return true if added with success
     */
    public boolean addParameter(Parameter parameter) {
        return this.test.addParameter(parameter);
    }

    /**
     * Method to create a new test
     *
     * @param nhsCode    of the test
     * @param client     object of the Client
     * @param typeOfTest object of the TestType
     * @param lParameter object of the Parameter
     * @return
     */
    public ClinicalTest createTest(String nhsCode, Client client, TypeOfTest typeOfTest, List<Parameter> lParameter, String labWhereCreated) {
        this.test = new ClinicalTest(nhsCode, client, typeOfTest, lParameter, labWhereCreated, this.testList.size() + 1);
        return this.test;
    }

    /**
     * Method to create tests from a csv file as they already come with all the dates/hours and results
     * @param dto
     * @return
     */
    public ClinicalTest createTestWithDates (ClinicalTestDto dto) {
        this.test = new ClinicalTest(dto, testList.size()+1);
        return this.test;
    }

    /**
     * Method  to get the type of tests list
     *
     * @return List<Test>
     */
    public List<ClinicalTest> getTestList() {
        return new ArrayList<>(this.testList);
    }

    public void setTestList(List<ClinicalTest> testList) {
        this.testList = new ArrayList<>(testList);
    }

    /**
     * Method to validate test
     *
     * @param testCreated object of the test to be validated
     * @return true if test created is valid
     */
    public boolean validateTest(ClinicalTest testCreated) {
        if (testCreated == null)
            return false;
        for (ClinicalTest ctest : testList) {
            if (ctest.equals(testCreated)) {
                return false;
            }
        }
        return !this.testList.contains(testCreated);
    }

    /**
     * Method to add a test to the list of the types of test
     *
     * @param test object test to be added
     * @return
     */
    public boolean addTest(ClinicalTest test) {
        return this.testList.add(test);
    }


    /**
     * Method to save a test object
     *
     * @param test object test to be saved
     * @return true if added with success, false if not
     */
    public boolean saveTest(ClinicalTest test) {
        if (validateTest(test)) {
            addTest(test);
            serializeStore(this.testList, "data\\test.dat");
            return true;
        }
        return false;
    }


    public List<ClinicalTest> getTestsWithoutResults(String labId) {
        List<ClinicalTest> lTestNoResult = new ArrayList<>();
        for (ClinicalTest recordTest : testList) {
            if (!recordTest.getResultStatus() && recordTest.getLabWhereCreated().equals(labId))
                lTestNoResult.add(recordTest);
        }
        if (lTestNoResult.isEmpty())
            return Collections.emptyList();
        else
            return lTestNoResult;
    }

    public List<ClinicalTest> getTestWithoutSample() {
        List<ClinicalTest> lTestNoSample = new ArrayList<>();
        if (!testList.isEmpty()) {
            for (ClinicalTest clinicalTest : testList) {
                if (!clinicalTest.getSampleStatus())
                    lTestNoSample.add(clinicalTest);
            }
            if (lTestNoSample.isEmpty())
                return Collections.emptyList();
            else
                return lTestNoSample;
        } else {
            return Collections.emptyList();
        }
    }

    public List<ClinicalTest> getTestWithoutReport() {
        List<ClinicalTest> lTestNoReport = new ArrayList<>();
        if (!testList.isEmpty()) {
            for (ClinicalTest clinicalTest : testList) {
                if (!clinicalTest.getReportStatus() && !clinicalTest.getResultStatus())
                    lTestNoReport.add(clinicalTest);
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
    public List<ClinicalTest> getTestWithoutValidation() {
        List<ClinicalTest> testWithoutValidation = new ArrayList<>();
        if (!testList.isEmpty()) {
            for (ClinicalTest clinicalTest : testList) {
                if (!clinicalTest.getValidationStatus())
                    testWithoutValidation.add(clinicalTest);
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
     * Saves tests that wasn't validated yet in a List
     * @return testWithoutValidation or null
     */
    public List<ClinicalTest> getTestFinalizated() {
        List<ClinicalTest> testsFinalizated = new ArrayList<>();
        if (!testList.isEmpty()) {
            for (ClinicalTest clinicalTest : testList) {
                if (!clinicalTest.getValidationStatus())
                    testsFinalizated.add(clinicalTest);
            }
            if (testsFinalizated.isEmpty())
                return Collections.emptyList();
            else
                return testsFinalizated;
        } else {
            return Collections.emptyList();
        }
    }

    /***
     * Method that returns a CATest by its code
     * @param internalCode
     * @return caTest or null
     */
    public ClinicalTest getTestByCode(String internalCode) {
        for (ClinicalTest clinicalTest : testList) {
            if (clinicalTest.getInternalCode().equals(internalCode))
                return clinicalTest;
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
            for (ClinicalTest clinicalTest : testList) {
                if (!clinicalTest.getValidationStatus()) {
                    ClinicalTest test1 = getTestByCode(clinicalTest.getInternalCode());
                    Client client = test1.getClient();
                    String name = client.getName();
                    clinicalTest.changeStateValidationToDone();
                    DateTime validatedAt = clinicalTest.getValidationDate();
                    SendingEmailSMS.sendEmailWithNotification(name, validatedAt);
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
        if (internalCode != null) {
            ClinicalTest test1 = getTestByCode(internalCode);
            Client client = test1.getClient();
            String name = client.getName();
            test1.changeStateValidationToDone();
            DateTime validatedAt = test1.getValidationDate();
            SendingEmailSMS.sendEmailWithNotification(name, validatedAt);
            return true;
        }
        return false;
    }

    public List<ClinicalTest> getClientTests(Client client) {
        List<ClinicalTest> clientTests = new ArrayList<>();
        if (client != null) {
            for (ClinicalTest caTest : testList) {
                if (caTest.getValidationStatus()) {
                    if (caTest.getClient().equals(client))
                        clientTests.add(caTest);
                }
            }
            if (clientTests.isEmpty())
                return Collections.emptyList();
            else
                return clientTests;
        } else {
            return Collections.emptyList();
        }
    }
}


