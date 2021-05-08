package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;


public class TypeOfTestTest {

    ParameterCategory pc = new ParameterCategory("34567", "Src");

    @Test(expected = NullPointerException.class)
    public void ensureNullParameterIsNotCreated() {
       TypeOfTest tot = new TypeOfTest(null, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericCodeAreNotAccepted() {
       TypeOfTest tot = new TypeOfTest("3%251", "RNA remnants", "cotton swab", "Src" );
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotHaveMoreOrLessThan5Char() {

        TypeOfTest tot = new TypeOfTest("534366", "RNA remnants", "cotton swab", "Src");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotBeBlank() {
        TypeOfTest tot = new TypeOfTest("", "RNA remnants", "cotton swab", "Src");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotHaveMoreThan15Char() {
        TypeOfTest tot = new TypeOfTest("53436", "RNA remnants and Dna remnats", "cotton swab", "Src");
    }

    @Test
    public void ensureDescriptionCanHave15Char() {
        TypeOfTest tot = new TypeOfTest("53436", "RNA remnants", "cotton swab", "Src");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotBeBlank() {
        TypeOfTest tot = new TypeOfTest("53436", "", "cotton swab", "Src");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureColectingMethodCannotHaveMoreThan15Char() {
        TypeOfTest tot = new TypeOfTest("53436", "RNA remnants", "cotton swab thro the nose", "Src");
    }

    @Test
    public void ensureColectingMethodCanHave15Char() {
        TypeOfTest tot = new TypeOfTest("53436", "RNA remnants", "cotton swab", "Src");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureColectingMethodCannotBeBlank() {
        TypeOfTest tot = new TypeOfTest("53436", "RNA remnants", "","Src" );
    }

    @Test
    public void checkGetCodeMethod() {
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", "Src");
        String expected= "53436";
        assertEquals(expected, tot1.getCode());
    }

    @Test
    public void checkSetCodeMethod() {
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", "Src");
        tot1.setCode("12013");
        String expected= "12013";
        assertEquals(expected, tot1.getCode());
    }
    @Test
    public void checkGetDescriptionMethod() {
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", "Src");
        String expected= "RNA remnants";
        assertEquals(expected, tot1.getDescription());
    }

    @Test
    public void checkSetDescriptionMethod() {
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", "Src");
        tot1.setDescription("DNA remnants");
        String expected= "DNA remnants";
        assertEquals(expected, tot1.getDescription());
    }
    @Test
    public void checkGetCollectingMethodMethod() {
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", "Src");
        String expected= "cotton swab";
        assertEquals(expected, tot1.getCollectingMethod());
    }

    @Test
    public void checkSetCollectingMethodMethod() {
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", "Src");
        tot1.setCollectingMethod("Saliva");
        String expected = "Saliva";
        assertEquals(expected, tot1.getCollectingMethod());
    }
    @Test
    public void checkToStringMethod() {
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", "Src");
        String expected= String.format("Type of Test: %nCode: 53436 %nDescription: RNA remnants %nColectingMethod: cotton swab ");
        assertEquals(expected, tot1.toString());
    }

    @Test
    public void checkIfTypeOfTestIsDiffThanNull() {

        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", "Src");
        TypeOfTest tot2= null;
        boolean expected = false;
        assertEquals(expected, tot1.equals(tot2));
    }

    @Test
    public void checkIf2TypeOfTestAreEqual() {

        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab","Src" );
        TypeOfTest tot2= new TypeOfTest("53436", "RNA remnants", "cotton swab", "Src");
        assertEquals( tot1,tot2);
    }

    @Test
    public void checkIf2TypeOfTestSameCodeAreEqual() {
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnant", "cotton swab","Src" );
        TypeOfTest tot2= new TypeOfTest("53436", "RNA remnants", "cotton stick","Src" );
        assertEquals( tot1,tot2);
    }

    @Test
    public void checkIf2TypeOfTestSameDescriptionAndColectingMethodAreEqual() {

        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab","Src");
        TypeOfTest tot2= new TypeOfTest("53435", "RNA remnants", "cotton swab", "Src");
        assertEquals( tot1,tot2);
    }

    @Test
    public void checkIf2TypeOfTestAreDiferents() {
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab","Src" );
        TypeOfTest tot2= new TypeOfTest("53435", "RNA remnant", "cotton swab", "Src");
        assertNotEquals( tot1,tot2);
    }

    @Test
    public void checkIfTheSameTypeOfTestAreEqual() {
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", "Src");
        TypeOfTest tot2 = tot1;
        assertEquals( tot1,tot2);
    }

    @Test
    public void checkIfDifferentObjectsAreDifferent(){
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab","Src");
        assertNotEquals( tot1,pc);
    }
}