package app.domain.model;

import app.domain.shared.CommonMethods;
import app.domain.shared.Constants;
import app.domain.shared.DateTime;
import app.mappers.dto.ClinicalTestDto;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClinicalTest implements Serializable, Comparable<ClinicalTest>{
    private static final int NHS_CODE = 12;
    private String labWhereCreated;
    private DateTime createdAt;
    private DateTime chemicalAnalysisDate;
    private DateTime validationDate;
    private Client client;
    private TypeOfTest typeOfTest;
    private String internalCode;
    private String nhsCode;

    private boolean sampleDone;
    private boolean reportDone;
    private boolean resultDone;
    private boolean validationDone;

    private Report report;
    private List<TestParameter> testParametersList = new ArrayList<>();
    private List<ClinicalTest> testReadyToVal = new ArrayList<>();
    private List<Parameter> parameterList;
    private List<ClinicalTest> testClient;
    private List<Sample> sampleList;


    /***
     * Constructor for CATest with all parameters
     * @param nhsCode
     * @param client
     * @param typeOfTest
     * @param parameterList
     * @param labWhereCreated
     */
    public ClinicalTest(String nhsCode, Client client, TypeOfTest typeOfTest, List<Parameter> parameterList, String labWhereCreated, int testCount) {
        this.labWhereCreated = labWhereCreated;
        setClient(client);
        this.typeOfTest = typeOfTest;
        this.createdAt = new DateTime();
        this.internalCode = generateInternalCode(testCount);
        setNhsCode(nhsCode);
        setTypeOfTest(typeOfTest);
        setParameterList(parameterList);
        createTestParameterList();
    }

    /**
     * Complete constructor for when a test is created via an CSV file
     * @param testDto with all the test data
     * @param testCount number of tests already registered in the system
     */
    public ClinicalTest(ClinicalTestDto testDto, int testCount) {
        this.labWhereCreated = testDto.getLabWhereCreated();
        setClient(testDto.getClient());
        this.typeOfTest = testDto.getTypeOfTest();
        this.createdAt = testDto.getRegistDateHour();
        this.sampleDone = true;
        this.chemicalAnalysisDate = testDto.getChemicalDateHour();
        this.resultDone = true;
        this.report = new Report(testDto.getsDoctorDateHour());
        this.reportDone = true;
        this.validationDate = testDto.getValidationDateHour();
        this.validationDone = true;
        this.internalCode = generateInternalCode(testCount);
        setNhsCode(testDto.getNhsCode());
        setTypeOfTest(testDto.getTypeOfTest());
        setParameterList(testDto.getParameterList());
        createTestParameterList();
    }


    private void createTestParameterList() {
        for (Parameter p : parameterList) {
            testParametersList.add(new TestParameter(p));
        }
    }

    /***
     * Method that generate a internal Code
     * @return internalCode
     */
    private String generateInternalCode(int testCounter) {
        return String.format("%012d", testCounter);
    }

    /***
     * Method that returns the creation date
     * @return createdAt
     */
    public DateTime getCreatedAt() {
        return this.createdAt;
    }

    /***
     *  Method that returns the type of test
     * @return typeOfTest
     */
    public TypeOfTest getTypeOfTest() {
        return this.typeOfTest;
    }

    /***
     * Method that returns the Client
     * @return client
     */
    public Client getClient() {
        return this.client;
    }

    /***
     * Method that returns the nhsCode of a test
     * @return email
     */
    public String getNhsCode() {
        return this.nhsCode;
    }

    public String getReportText() {
        return this.report.getReportText();
    }

    public List<Parameter> getParameterList() {
        return new ArrayList<>(parameterList);
    }

    public List<ClinicalTest> getTestClient() {
        return new ArrayList<>(testClient);
    }

    /***
     * Method that sets the client
     * @param client
     */
    public void setClient(Client client) {
        if (client == null)
            throw new NullPointerException(Constants.STRING_CLIENT + Constants.STRING_NULL_EXEPT);
        this.client = client;
    }

    /***
     * Method that sets the nhsCode
     * @param nhsCode
     */
    public void setNhsCode(String nhsCode) {
        if (nhsCode == null)
            throw new NullPointerException(Constants.STRING_NHS_CODE + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(nhsCode))
            throw new IllegalArgumentException(Constants.STRING_NHS_CODE + Constants.STRING_BLANK_EXEPT);
        if (nhsCode.length() != NHS_CODE)
            throw new IllegalArgumentException(Constants.STRING_NHS_CODE + " needs to have exactly 12 alphanumeric characters");
        if (!CommonMethods.stringHaveAlphanumerical(nhsCode))
            throw new IllegalArgumentException(Constants.STRING_NHS_CODE + Constants.NON_ALPHANUM_EXEPT);
        this.nhsCode = nhsCode;
    }

    /***
     * Method that sets the parameter
     * @param parameterList
     */
    public void setParameterList(List<Parameter> parameterList) {
        if (parameterList == null)
            throw new NullPointerException(Constants.STRING_PARAMETER_LIST + Constants.STRING_NULL_EXEPT);
        this.parameterList = new ArrayList<>(parameterList);
    }

    /***
     * Method that sets the type of test
     * @param typeOfTest
     */
    public void setTypeOfTest(TypeOfTest typeOfTest) {
        if (typeOfTest == null)
            throw new NullPointerException(Constants.STRING_CLIENT + Constants.STRING_NULL_EXEPT);
        this.typeOfTest = typeOfTest;
    }

    /***
     * This method returns where the date when the report was made
     * @return report
     */
    public DateTime getReportDate() {
        return this.report.getCreatedAt();
    }

    /***
     * This method returns where the date when the validation was made
     * @return validationDate
     */
    public DateTime getValidationDate() {
        return this.validationDate;
    }

    /***
     * This method returns where the date when the chemical analysis was made
     * @return chemicalAnalysisDate
     */
    public DateTime getChemicalAnalysisDate() {
        return this.chemicalAnalysisDate;
    }

    /***
     * This method returns where the lab was created
     * @return labWhereCreated
     */
    public String getLabWhereCreated() {
        return this.labWhereCreated;
    }

    /**
     * Method to add a new parameter to parameter list
     *
     * @param parameter Parameter object
     * @return true if parameter added with success false if not
     */
    public boolean addParameter(Parameter parameter) {
        if (!this.parameterList.isEmpty() && checkDuplications(parameter)) {
            return parameterList.add(parameter);
        }
        return false;
    }

    /**
     * This method ensures that its not possible to add the same parameter twice
     *
     * @param parameter to add
     * @return if it's duplicated or not
     */
    private boolean checkDuplications(Parameter parameter) {
        for (Parameter p : this.parameterList) {
            if (p.equals(parameter)) {
                return false;
            }
        }
        return true;
    }

    /**
     * this method returns if this test already has a sample or not using the sampleDone boolean variable
     *
     * @return true or false
     */
    public boolean getSampleStatus() {
        return this.sampleDone;
    }

    /**
     * this method returns if this test already has a report or not using the reportDone boolean variable
     *
     * @return true or false
     */
    public boolean getReportStatus() {
        return this.reportDone;
    }

    /**
     * this method returns if this test already has a result
     *
     * @return true or false
     */
    public boolean getResultStatus() {
        return this.resultDone;
    }

    /**
     * this method returns if this test as already been validated
     *
     * @return true or false
     */
    public boolean getValidationStatus() {
        return this.validationDone;
    }


    /**
     * This method returns the internal code of this test
     *
     * @return a string with the internal code
     */
    public String getInternalCode() {
        return this.internalCode;
    }


    /**
     * This method finds all the parameter test results done for this test and return them in a string
     *
     * @return the results available
     */
    public String getTestResults() {
        String results = String.format("%n%nTest Results: %n");
        if (!testParametersList.isEmpty()) {
            for (TestParameter result : testParametersList) {
                results = results.concat(result.toString());
            }
        }
        return results;
    }

    /**
     * This method finds all the test results validated and return them in a string
     *
     * @return the results available
     */
    public String getTestValidation() {
        String results = String.format("%n%nTest Results: %n");
        if (!testReadyToVal.isEmpty()) {
            for (ClinicalTest result : testReadyToVal) {
                results = results.concat(result.toString());
            }
        }
        return results;
    }

    public String getClientTests() {
        String results = String.format("%n%nTests made and details: %n");
        if (!testClient.isEmpty()) {
            for (ClinicalTest result : testClient) {
                results = results.concat(result.toString());
            }
        }
        return results;
    }


    /**
     * This method receives a Sample and assigns it to the test it's related to
     *
     * @param sample the instance of a Report
     * @return if it was added or not
     */
    public boolean addSample(Sample sample) {
        if (!sampleDone) {
            this.sampleList = (List<Sample>) sample;
            changeStateToSampleDone();
        }
        return this.sampleDone;
    }

    /**
     * This method receives a Report and assigns it to the test it's related to
     *
     * @param report the instance of a Report
     * @return if it was added or not
     */
    public boolean addReport(Report report) {
        if (!reportDone) {
            this.report = report;
            changeStateToReportDone();
        }
        return this.reportDone;
    }

    /**
     * This method receives a Test and assigns it to the test it's related to
     *
     * @return if it was added or not
     */
    public boolean addValidation() {
        if (!validationDone) {
            changeStateValidationToDone();
        }
        return this.validationDone;
    }

    /***
     * Method that adds a test parameter to a test
     * @param paramCode
     * @param value
     * @param metric
     * @return
     */
    public boolean addTestParameterResult(String paramCode, double value, String metric) {
        TestParameter testParam = getTestParameterByCode(paramCode);
        if (testParam != null) {
            Parameter parameter = testParam.getParameter();
            ExternalModule em = this.typeOfTest.getExternalModule(paramCode);
            ReferenceValue refValue = em.getReferenceValue(parameter);
            testParam.addTestResult(value, metric, refValue);
            if (this.chemicalAnalysisDate == null)
                this.chemicalAnalysisDate = new DateTime();
            return true;
        }
        return false;
    }

    /**
     * The only purpose of this method is to change the state of the test to inform that the sample is done
     */
    private void changeStateToSampleDone() {
        sampleDone = true;
    }

    /**
     * The only purpose of this method is to change the state of the test to inform that the report is done
     */
    private void changeStateToReportDone() {
        reportDone = true;
    }

    /**
     * The only purpose of this method is to change the state of the test to inform that the result is done
     */
    public boolean changeStateToResultDone() {
        return resultDone = true;
    }

    /***
     * Method that returns a Test Patameter by its code
     * @param paramCode
     * @return
     */
    private TestParameter getTestParameterByCode(String paramCode) {
        if (!this.testParametersList.isEmpty()) {
            for (TestParameter tp : this.testParametersList) {
                if (tp.getParameter().getCode().equals(paramCode))
                    return tp;
            }
        }
        return null;
    }

    /***
     * This method change the state of a test to true
     * @return true or false
     */
    public boolean changeStateValidationToDone() {
        if (!validationDone) {
            this.validationDate = new DateTime();
            return validationDone = true;
        }
        return false;
    }

    @Override
    public int compareTo(ClinicalTest o1) {
        Date thisDate = new Date(this.getValidationDate().toString());
        Date o1Date = new Date(o1.getValidationDate().toString());
        if (o1Date == null || thisDate == null)
            return 0;
        return o1Date.compareTo(thisDate);
    }


    /**
     * This method returns a string with some important data about this test
     *
     * @return string
     */
    @Override
    public String toString() {
        return String.format("Internal Code: %s | NHS Code: %s | Created on: %s |",
                this.internalCode, this.nhsCode, this.createdAt);
    }


    /**
     * This method compares two tests and returns if they are the same or not
     *
     * @param o object to compare with
     * @return the result of the comparison
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClinicalTest test = (ClinicalTest) o;
        return internalCode.equals(test.internalCode) || nhsCode.equals(test.nhsCode);
    }
}
