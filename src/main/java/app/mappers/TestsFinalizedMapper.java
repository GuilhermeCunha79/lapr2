package app.mappers;

import app.domain.model.ClinicalTest;

import java.util.ArrayList;
import java.util.List;

public class TestsFinalizedMapper {

    private TestsFinalizedMapper() {
        throw new IllegalStateException("Utility Class");
    }

    /***
     * This method converts a list of tests to a list of strings with the data from each test to be presented in the UI
     * @param lTestsDone
     * @return
     */
    public static List<String> toDtoFin(List<ClinicalTest> lTestsDone) {
        List<String> rtvListDto = new ArrayList<>();

        for (ClinicalTest test : lTestsDone) {
            rtvListDto.add(String.format("%s Collected at: %s | Reported at: %s | Validated at: %s | %n | Test Results: %s %n| Report: %s |%n", test.toString(), test.getChemicalAnalysisDate(), test.getReportDate(), test.getValidationDate(), test.getTestResults(), test.getReportText()));
        }
        return rtvListDto;
    }
/*
    public static List<String> toDtoFinn(List<ClinicalTest> lTestResults) {
        List<String> rttvListDto = new ArrayList<>();

        for (ClinicalTest clinicalTest : lTestResults) {
            rttvListDto.add(String.format("%s Collected at: %s | Validated Status: %s | Test Results: %s |%n", clinicalTest.toString(), clinicalTest.getChemicalAnalysisDate(), clinicalTest.getValidationStatus(), clinicalTest.getTestResults()));
        }
        return rttvListDto;
    }
    */

}


