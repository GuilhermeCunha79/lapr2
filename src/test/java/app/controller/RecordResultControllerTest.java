/*package app.controller;

import app.domain.model.Result;
import app.domain.model.Test;
import junit.framework.TestCase;
import java.util.List;

public class RecordResultControllerTest extends TestCase {

    Test test = new Test("123456789123","123456");
    Test test1 = new Test("132456789123","654321");
    RecordResultController ctrl = new RecordResultController();


    public RecordResultControllerTest() {
    }

    public void testGetTestWithoutResult() {
        List<String> list= ctrl.getTestWithoutResult();
        assertNotNull(list);
    }

    public void testGetTestResults() {
        test1.addResult(new Result("Positivo"));
        ctrl.saveResult(test1);
        assertNotNull(ctrl.getTestResults("132456789123").toString());
    }

    public void testNewResult() {
        test.addResult(new Result("Positivo"));
        assertNotNull(test.getTestResults());
    }

   public void testSaveResult() {
        ctrl.saveResult(test);
        assertNotNull(test.getTestResults());

    }
}*/