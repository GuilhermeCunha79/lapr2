package app.domain.model;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class TypeOfTestTest {

    ParameterCategory pc = new ParameterCategory("34567", "Src");

    /**
     * Tests with null values
     */
    @Test(expected = NullPointerException.class)
    public void ensureNullTypeOfTestIsNotCreated() {
       new TypeOfTest(null, null, null, null);
    }


    /**
     * Tests to type of test's code acceptance criterias
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericCodeAreNotAccepted() {

       new TypeOfTest("3%251", "RNA remnants", "cotton swab", pc);
    }


    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotHaveMoreOrLessThan5Char() {

        new TypeOfTest("534366", "RNA remnants", "cotton swab",pc );
    }


    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotBeBlank() {

        new TypeOfTest("", "RNA remnants", "cotton swab",pc );
    }


    /**
     * Tests to Type of Test's description acceptance criterias
     */
    @Test(expected = NullPointerException.class)
    public void ensureDescriptionCannotBeNull() {

        new TypeOfTest("53436", null, "cotton swab",pc );
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotHaveMoreThan15Char() {

        new TypeOfTest("53436", "RNA remnants and Dna remnats", "cotton swab",pc );
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotBeBlank() {

        new TypeOfTest("53436", "", "cotton swab",pc );
    }

    /**
     * Tests to type of test's colllecting acceptance criterias
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureCollectingMethodCannotHaveMoreThan15Char() {

        new TypeOfTest("53436", "RNA remnants", "cotton swab thro the nose", pc);
    }

    @Test(expected = NullPointerException.class)
    public void ensureCollectingMethodCannotBeNull() {

        new TypeOfTest("53436", "adfaasdv", null,pc );
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCollectingMethodCannotBeBlank() {

        new TypeOfTest("53436", "RNA remnants", "", pc );
    }

    /**
     * Tests to get methods
     */
    @Test
    public void checkGetCodeMethod() {

        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab",pc );
        String expected= "53436";
        assertEquals(expected, tot1.getCode());
    }

    @Test
    public void checkGetDescriptionMethod() {

        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        String expected= "RNA remnants";
        assertEquals(expected, tot1.getDescription());
    }

    @Test
    public void checkGetCollectingMethodMethod() {

        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        String expected= "cotton swab";
        assertEquals(expected, tot1.getCollectingMethod());
    }

    /**
     * Check set methods
     */
    @Test
    public void checkSetCodeMethod() {

        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        tot1.setCode("12013");
        String expected= "12013";
        assertEquals(expected, tot1.getCode());
    }


    @Test
    public void checkSetDescriptionMethod() {

        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab",pc );
        tot1.setDescription("DNA remnants");
        String expected= "DNA remnants";
        assertEquals(expected, tot1.getDescription());
    }




    @Test
    public void checkSetCollectingMethodMethod() {
       TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        tot1.setCollectingMethod("Saliva");
        String expected = "Saliva";
        assertEquals(expected, tot1.getCollectingMethod());
    }

    /**
     * Test for type of test toString method
     */
    @Test
    public void checkToStringMethod() {
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        String expected= String.format("Type of Test:%nCode: 53436%nDescription: RNA remnants%nCollecting Method: cotton swab%nParameter Category(ies):%nParameter Category:%nName: Src%nCode: 34567%n");
       assertEquals(expected, tot1.toString());
    }


    /**
     * Test for type of test equals method
     */
    @Test
    public void checkIfTypeOfTestIsDiffThanNull() {
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        assertNotEquals(null, tot1);
    }


    @Test
    public void checkIf2TypeOfTestAreEqual() {
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        TypeOfTest tot2= new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        assertEquals( tot1,tot2);
    }


    @Test
    public void checkIf2TypeOfTestSameCodeAreEqual() {
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnant", "cotton swab",pc);
        TypeOfTest tot2= new TypeOfTest("53436", "RNA remnants", "cotton stick",pc );
        assertEquals( tot1,tot2);
    }


    @Test
    public void checkIf2TypeOfTestSameDescriptionAndCollectingMethodAreEqual() {
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab",pc);
        TypeOfTest tot2= new TypeOfTest("53435", "RNA remnants", "cotton swab", pc);
        assertEquals( tot1,tot2);
    }

    @Test
    public void checkIf2TypeOfTestJustSameDescriptionAreDifferent() {
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab",pc);
        TypeOfTest tot2= new TypeOfTest("53433", "RNA remnants", "swab", pc);
        assertNotEquals( tot1,tot2);
    }


    @Test
    public void checkIf2TypeOfTestsAreDifferent() {
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab",pc);
        TypeOfTest tot2= new TypeOfTest("53435", "RNA remnant", "cotton swab", pc);
        assertNotEquals( tot1,tot2);
    }


    @Test
    public void checkIfTheSameTypeOfTestAreEqual() {
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        TypeOfTest tot2 = tot1;
        assertEquals( tot1,tot2);
    }


    @Test
    public void checkIfDifferentObjectsAreDifferent(){
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab",pc);
        assertNotEquals( tot1,pc);
    }

    @Test
    public void checkIfItsPossibleToAddMoreCategories() {
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab",pc);
        assertTrue( tot1.addParameterCategory(new ParameterCategory("43212", "pc")));
    }

    @Test
    public void checkIfPrintCategoriesReturnFalseWhenNull() {
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab",null);
        String expected = String.format("Type of Test:%nCode: 53436%nDescription: RNA remnants%nCollecting Method: cotton swab%nNo Categories");
        assertEquals(expected, tot1.toString());
    }
}