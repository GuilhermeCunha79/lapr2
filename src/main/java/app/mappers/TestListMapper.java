package app.mappers;

import app.domain.model.Test;

import java.util.ArrayList;
import java.util.List;

public class TestListMapper {

    public List<String> toDto(List<Test> lTestNoReport){
        List<String> testListNoReportDto = new ArrayList<>();
        for(Test test : lTestNoReport){
            testListNoReportDto.add(test.toString());
        }
        return testListNoReportDto;
    }
}
