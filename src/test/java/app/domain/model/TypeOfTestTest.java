package app.domain.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class TypeOfTestTest {

    ParameterCategory pc = new ParameterCategory("34567", "Src");

    List<ParameterCategory> Listpc = new ArrayList<ParameterCategory>();



    @Test(expected = NullPointerException.class)
    public void ensureNullTypeOfTestIsNotCreated() {
       new TypeOfTest(null, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericCodeAreNotAccepted() {
        Listpc.add(pc);
       new TypeOfTest("3%251", "RNA remnants", "cotton swab", Listpc );
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotHaveMoreOrLessThan5Char() {
        Listpc.add(pc);
        new TypeOfTest("534366", "RNA remnants", "cotton swab",Listpc );
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotBeBlank() {
        Listpc.add(pc);
        new TypeOfTest("", "RNA remnants", "cotton swab",Listpc );
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotHaveMoreThan15Char() {
        Listpc.add(pc);
        new TypeOfTest("53436", "RNA remnants and Dna remnats", "cotton swab",Listpc );
    }

    @Test
    public void ensureDescriptionCanHave15Char() {
        Listpc.add(pc);
        new TypeOfTest("53436", "RNA remnants", "cotton swab", Listpc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotBeBlank() {
        Listpc.add(pc);
        new TypeOfTest("53436", "", "cotton swab",Listpc );
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureColectingMethodCannotHaveMoreThan15Char() {
        Listpc.add(pc);
        new TypeOfTest("53436", "RNA remnants", "cotton swab thro the nose", Listpc);
    }

    @Test
    public void ensureColectingMethodCanHave15Char() {
        Listpc.add(pc);
        new TypeOfTest("53436", "RNA remnants", "cotton swab", Listpc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureColectingMethodCannotBeBlank() {
        Listpc.add(pc);
        new TypeOfTest("53436", "RNA remnants", "", Listpc );
    }

    @Test
    public void checkGetCodeMethod() {
        Listpc.add(pc);
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab",Listpc );
        String expected= "53436";
        assertEquals(expected, tot1.getCode());
    }

    @Test
    public void checkSetCodeMethod() {
        Listpc.add(pc);
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", Listpc);
        tot1.setCode("12013");
        String expected= "12013";
        assertEquals(expected, tot1.getCode());
    }
    @Test
    public void checkGetDescriptionMethod() {
        Listpc.add(pc);
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", Listpc);
        String expected= "RNA remnants";
        assertEquals(expected, tot1.getDescription());
    }

    @Test
    public void checkSetDescriptionMethod() {
        Listpc.add(pc);
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab",Listpc );
        tot1.setDescription("DNA remnants");
        String expected= "DNA remnants";
        assertEquals(expected, tot1.getDescription());
    }
    @Test
    public void checkGetColectingMethodMethod() {
        Listpc.add(pc);
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", Listpc);
        String expected= "cotton swab";
        assertEquals(expected, tot1.getCollectingMethod());
    }

    @Test
    public void checkSetColectingMethodMethod() {
        Listpc.add(pc);
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", Listpc);
        tot1.setCollectingMethod("Saliva");
        String expected = "Saliva";
        assertEquals(expected, tot1.getCollectingMethod());
    }
/*
    @Test
    public void checkToStringMethod() {
        Listpc.add(pc);
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", Listpc);
        String expected= String.format("Type of Test: %nCode: 53436 %nDescription: RNA remnants %nColecting Method: cotton swab %n%s",this.Listpc);
        assertEquals(expected, tot1.toString());
    }
/*/
    @Test
    public void checkIfTypeOfTestIsDiffThanNull() {
        Listpc.add(pc);
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", Listpc);
        TypeOfTest tot2= null;
        boolean expected = false;
        assertEquals(expected, tot1.equals(tot2));
    }

    @Test
    public void checkIf2TypeOfTestAreEqual() {
        Listpc.add(pc);
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", Listpc);
        TypeOfTest tot2= new TypeOfTest("53436", "RNA remnants", "cotton swab", Listpc);
        assertEquals( tot1,tot2);
    }

    @Test
    public void checkIf2TypeOfTestSameCodeAreEqual() {
        Listpc.add(pc);
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnant", "cotton swab",Listpc);
        TypeOfTest tot2= new TypeOfTest("53436", "RNA remnants", "cotton stick",Listpc );
        assertEquals( tot1,tot2);
    }

    @Test
    public void checkIf2TypeOfTestSameDescriptionAndColectingMethodAreEqual() {
        Listpc.add(pc);
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab",Listpc);
        TypeOfTest tot2= new TypeOfTest("53435", "RNA remnants", "cotton swab", Listpc);
        assertEquals( tot1,tot2);
    }

    @Test
    public void checkIf2TypeOfTestAreDiferents() {
        Listpc.add(pc);
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab",Listpc);
        TypeOfTest tot2= new TypeOfTest("53435", "RNA remnant", "cotton swab", Listpc);
        assertNotEquals( tot1,tot2);
    }

    @Test
    public void checkIfTheSameTypeOfTestAreEqual() {
        Listpc.add(pc);
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab", Listpc);
        TypeOfTest tot2 = tot1;
        assertEquals( tot1,tot2);
    }

    @Test
    public void checkIfDifferentObjectsAreDifferent(){
        Listpc.add(pc);
        ParameterCategory pc = new ParameterCategory("34567", "Src");
        TypeOfTest tot1 = new TypeOfTest("53436", "RNA remnants", "cotton swab",Listpc);
        assertNotEquals( tot1,pc);
    }
}