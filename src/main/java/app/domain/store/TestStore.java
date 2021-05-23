package app.domain.store;

import app.domain.model.Test;
import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class TestStore {

    private List<Test> testList = new ArrayList<>();

    public List<Test> getTestWithoutReport(){
        throw new NotImplementedException("Method not implemented yet");
    }

    public Test getTestByCode(String testCode){
        throw new NotImplementedException("Method not implemented yet");
    }
}
