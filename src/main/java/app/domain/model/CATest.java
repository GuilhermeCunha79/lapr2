package app.domain.model;

import app.domain.shared.CommonMethods;
import app.domain.shared.Constants;
import app.domain.shared.DateTime;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CATest {
    private static final int NHS_CODE = 12;
    private static int testCounter = 0;
    private final String labWhereCreated;
    private DateTime chemicalAnalysisDate;
    private DateTime validationDate;
    private final Client client;
    private TypeOfTest typeOfTest;
    private final DateTime createdAt;
    private final String internalCode;
    private String nhsCode;
    private boolean sampleDone;
    private boolean reportDone;
    private boolean resultDone;
    private boolean validationDone;
    private Report report;
    private List<Sample> sampleList = new ArrayList<>();
    private final List<TestParameter> testParametersList = new ArrayList<>();
    private List<Parameter> parameterList;


    public CATest(String nhsCode, Client client, TypeOfTest typeOfTest, List<Parameter> parameterList, String labWhereCreated) {
        testCounter++;
        this.labWhereCreated = labWhereCreated;
        setClient(client);
        this.typeOfTest = typeOfTest;
        this.createdAt = new DateTime();
        this.internalCode = generateInternalCode();
        this.client = client;
        setNhsCode(nhsCode);
        setTypeOfTest(typeOfTest);
        setParameterList(parameterList);
        createTestParameterList();
    }


    private void createTestParameterList() {
        for (Parameter p : parameterList){
            testParametersList.add(new TestParameter(p));
        }
    }

    private String generateInternalCode() {
        return String.format("%012d", testCounter);
    }


    public DateTime getCreatedAt() {
        return this.createdAt;
    }

    public TypeOfTest getTypeOfTest() {
        return this.typeOfTest;
    }

    public Client getClient() {
        return this.client;
    }

    public String getNhsCode() {
        return this.nhsCode;
    }

    public List<Parameter> getParameterList() {
        return new ArrayList<>(parameterList);
    }

    public void setClient(Client client) {
        if (client == null)
            throw new NullPointerException(Constants.STRING_CLIENT + Constants.STRING_NULL_EXEPT);
    }


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

    public void setParameterList(List<Parameter> parameterList) {
        if (parameterList == null)
            throw new NullPointerException(Constants.STRING_PARAMETER_LIST + Constants.STRING_NULL_EXEPT);
        this.parameterList = new ArrayList<>(parameterList);
    }

    public void setTypeOfTest(TypeOfTest typeOfTest) {
        if (typeOfTest == null)
            throw new NullPointerException(Constants.STRING_CLIENT + Constants.STRING_NULL_EXEPT);
        this.typeOfTest = typeOfTest;
    }


    public DateTime getReportDate() {
        return this.report.getCreatedAt();
    }

    public DateTime getValidationDate() {
        return this.validationDate;
    }


    public DateTime getChemicalAnalysisDate() {
        return this.chemicalAnalysisDate;
    }

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
     * This method adds a new result to a parameter tested
     * @param paramCode of the parameter tested
     * @param value obtained from the analysis
     * @param metric used to measure the result
     * @return if it was added or not
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
     * The sole purpose of this method is to change the state of the test to inform that the results are done
     */
    public boolean changeStateToResultDone() {
        return resultDone = true;
    }

    /**
     * This method's function is to change the state of the test to validation done
     */
    public void changeStateValidationToDone() {
        this.validationDate = new DateTime();
        validationDone = true;
    }

    /**
     * This method receives a parameter code and finds the test parameter with a parameter of the same code
     * @param paramCode to use in the search
     * @return the test parameter
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

    /**
     * This method returns a string with some important data about this test
     *
     * @return string
     */
    @Override
    public String toString() {
        return String.format("CA Test:%nNHS Code: %s%nClient: %s%nType Of Test: %s%nParameter List: %s%nLab Where Created: %s%nInternal Code: %s%n",
        this.nhsCode, this.client, this.typeOfTest, this.parameterList, this.labWhereCreated, this.internalCode);
    }

    /**
     * This method compares two tests and returns if they are the same or not
     * @param o object to compare with
     * @return the result of the comparison
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CATest test = (CATest) o;
        return internalCode.equals(test.internalCode) || nhsCode.equals(test.nhsCode);
    }


}
