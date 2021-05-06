package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParameterTest {

    @Test(expected = NullPointerException.class)
    public void ensureNullParameterIsNotCreated() {
        new Parameter(null, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericCodeAreNotAccepted() {
        new Parameter("10@22", "Blood", "Test Blood Cells", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotHaveMoreOrLessThan5Char() {
        new Parameter("102322", "Blood", "Test Blood Cells", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotBeBlank() {
        new Parameter("", "Blood", "Test Blood Cells", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotHaveMoreThan8Char() {
        new Parameter("10322", "Blood Cells", "Test Blood Cells", "hemograms");
    }

    @Test
    public void ensureNameCanHave8Char() {
        new Parameter("10322", "BlodTest", "Test Blood Cells", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotBeBlank() {
        new Parameter("13212", "", "Test Blood Cells", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotHaveMoreThan20Char() {
        new Parameter("10322", "Blood Cells", "Test Blood Cells and Urine", "hemograms");
    }

    @Test
    public void ensureDescriptionCanHave20Char() {
        new Parameter("10322", "Cells", "Test BloodCell Urine", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotBeBlank() throws Exception {
        new Parameter("12012", "Cells", "", "hemograms");
    }

    @Test
    public void checkGetCodeMethod() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", "hemograms");
        String expected = "10232";
        assertEquals(expected, p1.getCode());
    }

    @Test
    public void checkSetCodeMethod() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", "hemograms");
        p1.setCode("10231");
        String expected = "10231";
        assertEquals(expected, p1.getCode());
    }

    @Test
    public void checkGetShortNameMethod() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", "hemograms");
        String expected = "Blood";
        assertEquals(expected, p1.getShortName());
    }

    @Test
    public void checkSetNameMethod() {
        Parameter p1 = new Parameter("10232", "blood", "Test Blood Cells", "hemograms");
        p1.setShortName("urine");
        String expected = "urine";
        assertEquals(expected, p1.getShortName());
    }

    @Test
    public void checkGetDescriptionMethod() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", "hemograms");
        String expected = "Test Blood Cells";
        assertEquals(expected, p1.getDescription());
    }

    @Test
    public void checkSetDescriptionMethod() {
        Parameter p1 = new Parameter("10232", "blood", "Test Blood Cells", "hemograms");
        p1.setDescription("cells");
        String expected = "cells";
        assertEquals(expected, p1.getDescription());
    }

    @Test
    public void checkToStringMethod() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", "hemograms");
        String expected = String.format("Parameter:%nCode: 10232%nName: Blood%nDescription: Test Blood Cells");
        assertEquals(expected, p1.toString());
    }

    @Test
    public void checkIfParameterIsDiffThanNull() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", "hemograms");
        Parameter p2 = null;
        assertFalse(p1.equals(p2));
    }

    @Test
    public void checkIf2ParametersAreEqual() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", "hemograms");
        Parameter p2 = new Parameter("10232", "Blood", "Test Blood Cells", "hemograms");
        assertEquals(p1, p2);
    }

    @Test
    public void checkIf2ParametersSameCodeAreEqual() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", "hemograms");
        Parameter p2 = new Parameter("10232", "Bloods", "Test Blood", "hemograms");
        assertEquals(p1, p2);
    }

    @Test
    public void checkIf2ParametersSameNameAreEqual() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", "hemograms");
        Parameter p2 = new Parameter("10132", "Blood", "Test Blood Cell", "hemograms");
        assertEquals(p1, p2);
    }

    @Test
    public void checkIf2ParametersSameDescriptionAreEqual() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", "hemograms");
        Parameter p2 = new Parameter("10132", "Urine", "Test Blood Cells", "hemograms");
        assertEquals(p1, p2);
    }

    @Test
    public void checkIf2ParametersAreDifferent() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", "hemograms");
        Parameter p2 = new Parameter("10131", "Blood1", "Test lood Cells", "hemograms");
        assertNotEquals(p1, p2);
    }

    @Test
    public void checkIfTheSameParametersAreEqual() {
        Parameter p1 = new Parameter("10232", "Blood", "Test Blood Cells", "hemograms");
        assertEquals(p1, p1);
    }

    @Test
    public void checkIfDifferentObjectsAreDifferent() {
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p1 = new Parameter("10131", "Blood1", "Test lood Cells", "hemograms");
        assertNotEquals(p1, pc);
    }

}

