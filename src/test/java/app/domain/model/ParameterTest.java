package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParameterTest {

    ParameterCategory pc = new ParameterCategory("12345", "covid");

    /**
     * Tests with null values
     */
    @Test(expected = NullPointerException.class)
    public void ensureNullParameterIsNotCreated() {
        new Parameter(null, null, null, null);
    }

    @Test(expected = NullPointerException.class)
    public void checkGetShortNameMethodWithNull() {
        new Parameter("10232", null, "Test Blood Cells", pc);
    }

    @Test(expected = NullPointerException.class)
    public void checkGetDescriptionMethodWithNull() {
        new Parameter("10232", "Blood", null, pc);
    }


    /**
     * Tests to parameter's code acceptance criterias
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericCodeAreNotAccepted() {
        new Parameter("10@22", "Blood", "Test Blood Cells", pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotHaveMoreThan5Char() {
        new Parameter("102322", "Blood", "Test Blood Cells", pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotHaveLessThan5Char() {
        new Parameter("122", "Blood", "Test Blood Cells", pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotBeBlank() {
        new Parameter("", "Blood", "Test Blood Cells", pc);
    }

    /**
     * Tests to parameter's name acceptance criterias
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotHaveMoreThan8Char() {
        new Parameter("10322", "Blood Cells", "Test Blood Cells", pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotBeBlank() {
        new Parameter("13212", "", "Test Blood Cells", pc);
    }

    /**
     * Tests to parameter's description acceptance criterias
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotHaveMoreThan20Char() {
        new Parameter("10322", "Blood Cells", "Test Blood Cells and Urine", pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotBeBlank() {
        new Parameter("12012", "Cells", "", pc);
    }

    /**
     * Tests to get methods
     */
    @Test
    public void checkGetCodeMethod() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", pc);
        String expected = "10232";
        assertEquals(expected, p1.getCode());
    }

    @Test
    public void checkGetShortNameMethod() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", pc);
        String expected = "Blood";
        assertEquals(expected, p1.getShortName());
    }

    @Test
    public void checkGetDescriptionMethod() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", pc);
        String expected = "Test Blood Cells";
        assertEquals(expected, p1.getDescription());
    }

    /**
     * Check set methods
     */

    @Test
    public void checkSetNameMethod() {
        Parameter p1 = new Parameter("10232", "blood", "Test Blood Cells", pc);
        p1.setShortName("urine");
        String expected = "urine";
        assertEquals(expected, p1.getShortName());
    }

    @Test
    public void checkSetDescriptionMethod() {
        Parameter p1 = new Parameter("10232", "blood", "Test Blood Cells", pc);
        p1.setDescription("cells");
        String expected = "cells";
        assertEquals(expected, p1.getDescription());
    }

    @Test
    public void checkSetCodeMethod() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", pc);
        p1.setCode("10231");
        String expected = "10231";
        assertEquals(expected, p1.getCode());
    }

    /**
     * Test for parameter toString method
     */
    @Test
    public void checkToStringMethod() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", pc);
        String expected = "Parameter -> Code: 10232 | Name: Blood | Description: Test Blood Cells";
        assertEquals(expected, p1.toString());
    }

    /**
     * Test for parameter equals method
     */
    @Test
    public void checkIfParameterIsDiffThanNull() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", pc);
        assertNotEquals(p1, null);
    }

    @Test
    public void checkIf2ParametersAreEqual() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", pc);
        Parameter p2 = new Parameter("10232", "Blood", "Test Blood Cells", pc);
        assertEquals(p1, p2);
    }

    @Test
    public void checkIf2ParametersSameCodeAreEqual() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", pc);
        Parameter p2 = new Parameter("10232", "Bloods", "Test Blood", pc);
        assertEquals(p1, p2);
    }

    @Test
    public void checkIf2ParametersSameNameAreEqual() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", pc);
        Parameter p2 = new Parameter("10132", "Blood", "Test Blood Cell", pc);
        assertEquals(p1, p2);
    }

    @Test
    public void checkIf2ParametersSameDescriptionAreEqual() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", pc);
        Parameter p2 = new Parameter("10132", "Urine", "Test Blood Cells", pc);
        assertEquals(p1, p2);
    }

    @Test
    public void checkIf2ParametersAreDifferent() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", pc);
        Parameter p2 = new Parameter("10131", "Blood1", "Test lood Cells", pc);
        assertNotEquals(p1, p2);
    }

    @Test
    public void checkIfTheSameParametersAreEqual() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", pc);
        assertEquals(p1, p1);
    }

    @Test
    public void checkIfDifferentObjectsAreDifferent() {
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p1 = new Parameter("10131", "Blood1", "Test lood Cells", pc);
        assertNotEquals(p1, pc);
    }

}

