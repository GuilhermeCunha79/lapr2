package app.domain.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParameterCategoryTest {


    ParameterCategory pc = new ParameterCategory("12345", "covid");
    /**
     * Checks if category with null values is not created
     */
    @Test(expected = NullPointerException.class)
    public void ensureNullParameterCategoryIsNotCreated() {
        ParameterCategory p = new ParameterCategory(null, null);
    }

    /**
     * Tests for code's acceptance criteria
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericCodeAreNotAccepted() {
        new ParameterCategory("120@12", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotHaveMoreThan5Char() {
        new ParameterCategory("120121", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotHaveLessThan5Char() {
        new ParameterCategory("120", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotBeBlank() {
        new ParameterCategory("", "hemograms");
    }

    /**
     * Tests for name's acceptance criteria
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotHaveMoreThan10Char() {
        new ParameterCategory("12012", "hemograms12");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotBeBlank() {
        new ParameterCategory("12012", "");
    }

    /**
     * Tests for get methods
     */
    @Test
    public void checkGetCodeMethod(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        String expected = "12012";
        assertEquals(expected, pc.getCode());
    }

    @Test
    public void checkGetNameMethod(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        String expected = "hemograms";
        assertEquals(expected, pc.getName());
    }

    /**
     * Tests for set methods
     */

    @Test
    public void checkSetCodeMethod(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        pc.setCode("10231");
        String expected = "10231";
        assertEquals(expected, pc.getCode());
    }

    @Test
    public void checkSetNameMethod(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        pc.setName("urine");
        String expected = "urine";
        assertEquals(expected, pc.getName());
    }

    /**
     * Test for parameter category toString method
     */
    @Test
    public void checkToStringMethod(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        String expected = String.format("Parameter Category -> Name: hemograms | Code: 12012 |%n");
        assertEquals(expected, pc.toString());
    }

    @Test
    public void checkIfParameterCategoryIsDiffThanNull(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        assertFalse(pc.equals(null));
    }

    @Test
    public void checkIf2ParameterCategoriesAreEqual(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        ParameterCategory pc2 = new ParameterCategory("12012", "hemograms");
        assertEquals(pc, pc2);
    }

    @Test
    public void checkIf2ParameterCategoriesSameCodeAreEqual(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        ParameterCategory pc2 = new ParameterCategory("12012", "hemogram");
        assertEquals(pc, pc2);
    }

    @Test
    public void checkIf2ParameterCategoriesSameNameAreEqual(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        ParameterCategory pc2 = new ParameterCategory("12013", "hemograms");
        assertEquals(pc, pc2);
    }


    @Test
    public void checkIf2ParameterCategoriesAreDifferent(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        ParameterCategory pc2 = new ParameterCategory("12013", "hemogram");
        assertNotEquals(pc, pc2);
    }

    @Test
    public void checkIfTheSameParametersAreEqual(){
        ParameterCategory pc = new ParameterCategory("12012", "hemograms");
        assertEquals(pc, pc);
    }

    @Test
    public void checkIfDifferentObjectsAreDifferent(){
        new ParameterCategory("12012", "hemograms");
        Parameter p1 = new Parameter("12012", "Blood1", "Test lood Cells", pc);
        assertNotEquals(p1, new String());
    }

}