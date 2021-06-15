package app.mappers;

import app.domain.model.ClinicalTest;

import java.util.ArrayList;
import java.util.List;

public class TestsFinalizedMapper {

    private TestsFinalizedMapper(){
        throw new IllegalStateException("Utility Class");
    }
    /***
     * This method converts a list of test types to a list of strings with the data from each test to be presented in the UI
     * @param readyToValidate
     * @return
     */
    public static List<String> toDtoFin(List<ClinicalTest> readyToValidate) {
        List<String> rtvListDto = new ArrayList<>();

        for (ClinicalTest test : readyToValidate) {
            rtvListDto.add(String.format("%s Collected at: %s | Reported at: %s | Validated at: %s | %n | Report: %s |%n",test.toString(), test.getChemicalAnalysisDate(), test.getReportDate(), test.getValidationDate(), test.getReportText()));
        }
        return rtvListDto;
    }
}

