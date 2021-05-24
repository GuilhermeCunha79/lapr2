package app.mappers;

import app.domain.model.Test;

import java.util.ArrayList;
import java.util.List;

public class TestListMapper {

    /**
     * This method converts a list of tests to a list of strings with the data from each test to be used in the UI
     * @param lTestNoReport list of tests
     * @return list of strings
     */
    public List<String> toDto(List<Test> lTestNoReport){
        List<String> testListNoReportDto = new ArrayList<>();
        for(Test test : lTestNoReport){
            testListNoReportDto.add(test.toString());
        }
        return testListNoReportDto;
    }
}
