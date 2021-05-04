package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TypeOfTestTest {
    @Test(expected = NullPointerException.class)
    public void ensureNullParameterIsNotCreated() {
       TypeOfTest tot = new TypeOfTest(null, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericCodeAreNotAccepted() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
       TypeOfTest tot = new TypeOfTest("3%251", "RNA remnants", "cotton swab", pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotHaveMoreOrLessThan5Char() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot = new TypeOfTest("534366", "RNA remnants", "cotton swab", pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotBeBlank() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot = new TypeOfTest("", "RNA remnants", "cotton swab", pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotHaveMoreThan15Char() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot = new TypeOfTest("53436", "RNA remnants and Dna remnats", "cotton swab", pc);
    }

    @Test
    public void ensureDescriptionCanHave15Char() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotBeBlank() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot = new TypeOfTest("53436", "", "cotton swab", pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureColectingMethodCannotHaveMoreThan15Char() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot = new TypeOfTest("53436", "RNA remnants", "cotton swab thro the nose", pc);
    }

    @Test
    public void ensureColectingMethodCanHave15Char() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureColectingMethodCannotBeBlank() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot = new TypeOfTest("53436", "RNA remnants", "", pc);
    }

    @Test
    public void checkGetCodeMethod() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        String expected= "53436";
        assertEquals(expected, tot1.getCode());
    }

    @Test
    public void checkSetCodeMethod() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        tot1.setCode("120134");
        String expected= "120134";
        assertEquals(expected, tot1.getCode());
    }
    @Test
    public void checkGetDescriptionMethod() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        String expected= "RNA remnants";
        assertEquals(expected, tot1.getDescription());
    }

    @Test
    public void checkSetDescriptionMethod() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        tot1.setDescription("DNA remnants");
        String expected= "DNA remnants";
        assertEquals(expected, tot1.getDescription());
    }
    @Test
    public void checkGetColectingMethodMethod() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        String expected= "cotton swab";
        assertEquals(expected, tot1.getColectingmethod());
    }

    @Test
    public void checkSetColectingMethodMethod() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        tot1.setColectingmethod("Saliva bottle");
        String expected= "Saliva bottle";
        assertEquals(expected, tot1.getColectingmethod());
    }
    @Test
    public void checkToStringMethod() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        String expected= String.format("Type of Test: \nCode: 53436 \nDescription: RNA remnants \nColectingMethod: cotton swab ");
        assertEquals(expected, tot1.toString());
    }

    @Test
    public void checkIfTypeOfTestIsDiffThanNull() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        TypeOfTest tot2= null;
        boolean expected = false;
        assertEquals(expected, tot1.equals(tot2));
    }

    @Test
    public void checkIf2TypeOfTestAreEqual() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        TypeOfTest tot2= new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        assertEquals( tot1,tot2);
    }

    @Test
    public void checkIf2TypeOfTestSameCodeAreEqual() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnant", "cotton swab", pc);
        TypeOfTest tot2= new TypeOfTest("53436", "RNA remnants", "cotton stick", pc);
        assertEquals( tot1,tot2);
    }

    @Test
    public void checkIf2TypeOfTestSameDescriptionAndColectingMethodAreEqual() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        TypeOfTest tot2= new TypeOfTest("53435", "RNA remnants", "cotton swab", pc);
        assertEquals( tot1,tot2);
    }

    @Test
    public void checkIf2TypeOfTestAreDiferents() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        TypeOfTest tot2= new TypeOfTest("53435", "RNA remnant", "cotton swab", pc);
        assertNotEquals( tot1,tot2);
    }

    public void checkIfTheSameTypeOfTestAreEqual() {
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        TypeOfTest tot2 = tot1;
        assertEquals( tot1,tot2);
    }

    @Test
    public void checkIfDifferentObjectsAreDifferent(){
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", pc);
        assertNotEquals( tot1,pc);
    }
}