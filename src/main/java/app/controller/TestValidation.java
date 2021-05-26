package app.controller;

import app.domain.model.Test;
import app.domain.shared.DateTime;

public class TestValidation extends Test {

    private String internalCode;
    private DateTime registrationDate;
    private DateTime chemicalAnalysisDate;
    private DateTime reportDate;

    public TestValidation(Test test){
        super(test.getInternalCode(), test.getRegistrationDate(), test.getChemicalAnalysisDate(), test.getReportDate());
    }


    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public DateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(DateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public DateTime getChemicalAnalysisDate() {
        return chemicalAnalysisDate;
    }

    public void setChemicalAnalysisDate(DateTime chemicalAnalysisDate) {
        this.chemicalAnalysisDate = chemicalAnalysisDate;
    }

    public DateTime getReportDate() {
        return reportDate;
    }

    public void setReportDate(DateTime reportDate) {
        this.reportDate = reportDate;
    }

    @Override
    public String toString() {
        return String.format("Internal Code: %s | Registration Date: %s | Collected on: %s | Report Date: %s|",
                this.internalCode, this.registrationDate, this.chemicalAnalysisDate, this.reportDate);
    }
}
