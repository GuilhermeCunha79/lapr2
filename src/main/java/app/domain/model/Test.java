package app.domain.model;

import app.domain.shared.DateTime;
import org.apache.commons.lang3.NotImplementedException;

public class Test {

    private DateTime createdAt;
    private String internalCode;
    private String nhsCode;
    private boolean reportDone;
    private Report report;

    /**
     * this method returns if this test already has a report or not using the reportDone boolean variable
     * @return true or false
     */
    public boolean getReportStatus(){
        return this.reportDone;
    }

    /**
     * This method returns the internal code of this test
     * @return a string with the internal code
     */
    public String getInternalCode() {
        return this.internalCode;
    }

    /**
     * This method finds all the parameter test results done for this test and return them in a string
     * @return the results available
     */
    public String getTestResults() {
        throw new NotImplementedException("Method not implemented yet");
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
