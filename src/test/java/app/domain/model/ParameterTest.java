package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParameterTest {

    ParameterCategory pc = new ParameterCategory("12012", "hemograms");

    @Test(expected = NullPointerException.class)
    public void ensureNullParameterIsNotCreated() {
        Parameter p = new Parameter(null, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericCodeAreNotAccepted() {

        Parameter p = new Parameter("Blood", "10@22", "Test Blood Cells", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotHaveMoreOrLessThan5Char() {
        Parameter p = new Parameter("Blood", "102322", "Test Blood Cells", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotBeBlank() {
        Parameter p = new Parameter("Blood", "", "Test Blood Cells", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotHaveMoreThan8Char() {
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p = new Parameter("Blood Cells", "10322", "Test Blood Cells", "hemograms");
    }

    @Test
    public void ensureNameCanHave8Char() {
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p = new Parameter("BlodTest", "10322", "Test Blood Cells", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotBeBlank() {
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p = new Parameter("", "10322", "Test Blood Cells", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotHaveMoreThan20Char() {
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p = new Parameter("Blood Cells", "10322", "Test Blood Cells and Urine", "hemograms");
    }

    @Test
    public void ensureDescriptionCanHave20Char() {
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p = new Parameter("Cells", "10322", "Test BloodCell Urine", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotBeBlank() throws Exception {
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p = new Parameter("Cells", "12012", "", "hemograms");
    }

    @Test
    public void checkGetCodeMethod(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p1 = new Parameter("Blood", "10232", "Test Blood Cells", "hemograms");
        String expected = "10232";
        assertEquals(expected, p1.getCode());
    }

    @Test
    public void checkSetCodeMethod(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p1 = new Parameter("Blood", "10232", "Test Blood Cells", "hemograms");
        p1.setCode("10231");
        String expected = "10231";
        assertEquals(expected, p1.getCode());
    }

    @Test
    public void checkGetShortNameMethod(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p1 = new Parameter("Blood", "10232", "Test Blood Cells", "hemograms");
        String expected = "Blood";
        assertEquals(expected, p1.getShortName());
    }

    @Test
    public void checkSetNameMethod(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p1 = new Parameter("blood", "10232", "Test Blood Cells", "hemograms");
        p1.setShortName("urine");
        String expected = "urine";
        assertEquals(expected, p1.getShortName());
    }

    @Test
    public void checkGetDescriptionMethod(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p1 = new Parameter("Blood", "10232", "Test Blood Cells", "hemograms");
        String expected = "Test Blood Cells";
        assertEquals(expected, p1.getDescription());
    }

    @Test
    public void checkSetDescriptionMethod(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p1 = new Parameter("blood", "10232", "Test Blood Cells", "hemograms");
        p1.setDescription("cells");
        String expected = "cells";
        assertEquals(expected, p1.getDescription());
    }

    @Test
    public void checkToStringMethod(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p1 = new Parameter("Blood", "10232", "Test Blood Cells", "hemograms");
        String expected = String.format("Parameter:%nCode: 10232%nName: Blood%nDescription: Test Blood Cells");
        assertEquals(expected, p1.toString());
    }

    @Test
    public void checkIfParameterIsDiffThanNull(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p1 = new Parameter("Blood", "10232", "Test Blood Cells", "hemograms");
        Parameter p2 = null;
        boolean expected = false;
        assertEquals(expected, p1.equals(p2));
    }

    @Test
    public void checkIf2ParametersAreEqual(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p1 = new Parameter("Blood", "10232", "Test Blood Cells", "hemograms");
        Parameter p2 = new Parameter("Blood", "10232", "Test Blood Cells", "hemograms");
        assertEquals(p1, p2);
    }

    @Test
    public void checkIf2ParametersSameCodeAreEqual(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p1 = new Parameter("Blood", "10232", "Test Blood Cells", "hemograms");
        Parameter p2 = new Parameter("Bloods", "10232", "Test Blood", "hemograms");
        assertEquals(p1, p2);
    }

    @Test
    public void checkIf2ParametersSameNameAreEqual(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p1 = new Parameter("Blood", "10232", "Test Blood Cells", "hemograms");
        Parameter p2 = new Parameter("Blood", "10132", "Test Blood Cell", "hemograms");
        assertEquals(p1, p2);
    }

    @Test
    public void checkIf2ParametersSameDescriptionAreEqual(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p1 = new Parameter("Blood", "10232", "Test Blood Cells", "hemograms");
        Parameter p2 = new Parameter("Urine", "10132", "Test Blood Cells", "hemograms");
        assertEquals(p1, p2);
    }

    @Test
    public void checkIf2ParametersAreDifferent(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p1 = new Parameter("Blood", "10232", "Test Blood Cells", "hemograms");
        Parameter p2 = new Parameter("Blood1", "10131", "Test lood Cells", "hemograms");
        assertNotEquals(p1, p2);
    }

    @Test
    public void checkIfTheSameParametersAreEqual(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p1 = new Parameter("Blood", "10232", "Test Blood Cells", "hemograms");
        Parameter p2 = p1;
        assertEquals(p1, p2);
    }

    @Test
    public void checkIfDifferentObjectsAreDifferent(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        Parameter p1 = new Parameter("Blood1", "10131", "Test lood Cells", "hemograms");
        assertNotEquals(p1, pc);
    }

}