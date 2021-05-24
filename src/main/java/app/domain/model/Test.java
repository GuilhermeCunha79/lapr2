package app.domain.model;

import app.domain.shared.DateTime;
import org.apache.commons.lang3.NotImplementedException;

public class Test {

    private DateTime createdAt;
    private String internalCode;
    private String nhsCode;
    private boolean reportDone;
    private Report report;

    public boolean getReportStatus(){
        return this.reportDone;
    }

    public String getInternalCode() {
        return this.internalCode;
    }

    public String getTestResults() {
        throw new NotImplementedException("Method not implemented yet");
    }

    public void addReport(Report report) {
        this.report = report;
        changeStateToReportDone();
    }

    private void changeStateToReportDone() {
        reportDone = true;
    }

    @Override
    public String toString() {
        return String.format("Internal Code: 000000000001 | NHS Code: %s | Created on: %s |",
                this.internalCode, this.nhsCode, this.createdAt);
    }
}
