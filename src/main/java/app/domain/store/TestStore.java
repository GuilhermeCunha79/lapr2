package app.domain.store;

import app.domain.model.Test;
import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class TestStore {

    private List<Test> testList = new ArrayList<>();

    public List<Test> getTestWithoutReport(){
        List<Test> lTestNoReport = new ArrayList<>();
        for (Test test : testList){
            if(!test.getReportStatus())
                lTestNoReport.add(test);
        }
        if(lTestNoReport.isEmpty())
            return null;
        else
            return lTestNoReport;
    }

    public Test getTestByCode(String testCode){
        for(Test test : testList){
            if(test.getInternalCode().equals(testCode))
                return test;
        }
        return null;
    }
}
