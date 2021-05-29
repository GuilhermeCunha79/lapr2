package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestParameterTest {

    @Test
    public void testGetParameterMethod(){
        Parameter p = new Parameter("42424", "asdsd", "afdfas", new ParameterCategory("34314", "qweqeq"));
        TestParameter tp = new TestParameter(p);
        assertEquals(p, tp.getParameter());
    }

    @Test
    public void testGetTestParameterResultMethod(){
        Parameter p = new Parameter("42424", "asdsd", "afdfas", new ParameterCategory("34314", "qweqeq"));
        TestParameter tp = new TestParameter(p);
        TestParameterResult tpr = new TestParameterResult(2.22, "ml", new ReferenceValue(2.22, 2.11, "ml"));
        tp.addTestResult(2.22, "ml", new ReferenceValue(2.22, 2.11, "ml"));
        assertEquals(tpr.toString(), tp.getTestParameterResult().toString());
    }

    @Test
    public void testToStringMethod(){
        Parameter p = new Parameter("42424", "asdsd", "afdfas", new ParameterCategory("34314", "qweqeq"));
        TestParameter tp = new TestParameter(p);
        TestParameterResult tpr = new TestParameterResult(2.22, "ml", new ReferenceValue(2.22, 2.11, "ml"));
        tp.addTestResult(2.22, "ml", new ReferenceValue(2.22, 2.11, "ml"));
        String expected = "- Parameter tested: Parameter -> Code: 42424 | Name: asdsd | Description: afdfas | Results -> value: 2.220000 ml | Reference Values -> min. value: 2.220000 ml | max. value: 2.110000 ml \n";
        assertEquals(expected, tp.toString());
    }


}