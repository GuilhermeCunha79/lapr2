package app.mappers;

import app.domain.model.ClinicalTest;

import java.util.ArrayList;
import java.util.List;

public class TestListMapper {

    private TestListMapper() {
        throw new IllegalStateException("Utility class");
    }


    /**
     * This method converts a list of tests to a list of strings with the data from each test to be used in the UI
     * @param lTestNoReport list of tests
     * @return list of strings
     */
    public static List<String> toDto(List<ClinicalTest> lTestNoReport){
        List<String> testListNoReportDto = new ArrayList<>();
        for(ClinicalTest test : lTestNoReport){
            testListNoReportDto.add(test.toString());
        }
        return testListNoReportDto;
    }
}
