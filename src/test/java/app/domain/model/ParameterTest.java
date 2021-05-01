package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParameterTest {

    @Test(expected = NullPointerException.class)
    public void ensureNullParameterIsNotCreated() {
        Parameter p = new Parameter(null, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericCodeAreNotAccepted() {
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p = new Parameter("Blood", "10@22", "Test Blood Cells", pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotHaveMoreOrLessThan5Char() {
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p = new Parameter("Blood", "102322", "Test Blood Cells", pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotHaveMoreThan8Char() {
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p = new Parameter("Blood Cells", "10322", "Test Blood Cells", pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotHaveMoreThan20Char() {
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p = new Parameter("Blood Cells", "10322", "Test Blood Cells and Urine", pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotBeBlank() {
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p = new Parameter("", "", "", pc);
    }

    @Test
    public void checkIf2ParametersAreEqual(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p1 = new Parameter("Blood", "10232", "Test Blood Cells", pc);
        Parameter p2 = new Parameter("Blood", "10232", "Test Blood Cells", pc);
        assertTrue(p1.equals(p2));
    }

}