package app.domain.model;

import app.domain.shared.DateTime;

import java.util.ArrayList;
import java.util.List;

public class Test {              //criar metodo que associe o testCounter ao internalCode
    private Client client;//set get
    private TypeOfTest typeOfTest;//set get
    private DateTime createdAt;//get
    private String internalCode;//get
    private String nhsCode;// get set(criar metodo que verifique os 12 digitos)
    private boolean reportDone;
    private boolean resultDone;
    private boolean validationDone;
    private Report report;
    private List<TestParameterResult> resultList = new ArrayList<>();
    private List<Parameter> parameterList;//get set

    private static int testCounter = 0;
    private static final int NHS_CODE = 12;



    public Test(String nhsCode, Client client, TypeOfTest typeOfTest, List<Parameter> parameterList) {
        testCounter++;
        this.nhsCode = nhsCode;
        this.client = client;
        this.typeOfTest = typeOfTest;
        this.createdAt = new DateTime();
        this.parameterList = new ArrayList<>(parameterList);
        setNHSCode(nhsCode);
        reportDone = false;
        resultDone = false;
    }


    public DateTime getRegistrationDate() {
        return this.createdAt;
    }






    /**
     * this method returns if this test already has a report or not using the reportDone boolean variable
     * @return true or false
     */
    public boolean getReportStatus(){
        return this.reportDone;
    }

    /**
     * this method returns if this test already has a result
     * @return true or false
     */
    public boolean getResultStatus(){
        return this.resultDone;
    }

    /**
     * this method returns if this test as already been validated
     * @return true or false
     */
    public boolean getValidationStatus(){
        return this.validationDone;
    }


    /**
     * This method returns the internal code of this test
     * @return a string with the internal code
     */
    public String getInternalCode() {
        return this.internalCode;
    }

    /**
     * This method returns the client of this test
     * @return a string with the client
     */


    public void setNHSCode(String nhsCode) {
        this.nhsCode = nhsCode;
    }



    /**
     * This method finds all the parameter test results done for this test and return them in a string
     * @return the results available
     */
    public String getTestResults() {
        String results = "";
        if(!resultList.isEmpty()) {
            for (TestParameterResult result : resultList){
                results.concat(result.toString());
            }
        }
        return results;
    }


    /**
     * This method receives a Report and assigns it to the test it's related to
     * @param report the instance of a Report
     * @return if it was added or not
     */
    public boolean addReport(Report report) {
        this.report = report;
        changeStateToReportDone();
        return this.reportDone;
    }

    /**
     * The only purpose of this method is to change the state of the test to inform that the report is done
     */
    private void changeStateToReportDone() {
        reportDone = true;
    }

    private void changeStateToResultDone() {
        resultDone = true;
    }

    private void changeStateValidationToDone(){
        validationDone=true;
    }

    /**
     * This method returns a string with some important data about this test
     * @return string
     */
    @Override
    public String toString() {
        return String.format("Internal Code: %s | NHS Code: %s | Created on: %s |",
                this.internalCode, this.nhsCode, this.createdAt);
    }
}
