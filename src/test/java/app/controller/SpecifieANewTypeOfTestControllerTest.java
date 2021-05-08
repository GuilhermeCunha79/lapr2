package app.controller;

import app.domain.model.ParameterCategory;
import app.domain.model.TypeOfTest;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SpecifieANewTypeOfTestControllerTest  {

    SpecifieANewTypeOfTestController ctrl = new SpecifieANewTypeOfTestController();

    ParameterCategory pc = new ParameterCategory("34567", "Src");

    ArrayList<ParameterCategory> Listpc = new ArrayList<ParameterCategory>();

    @Test(expected = NullPointerException.class)
    public void ensureNullTypeOfTestIsNotCreated() {
        ctrl.createANewTypeOfTest(null, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTypeOfTestIsNotCreatedWithBlankAttributes() {
        ctrl.createANewTypeOfTest("", "","" , Listpc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericCodeAreNotAccepted() {
        Listpc.add(pc);
        ctrl.createANewTypeOfTest("334@2", "IE", "CM", Listpc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotHaveMoreThan5Char() {
        Listpc.add(pc);
        ctrl.createANewTypeOfTest("334672", "IE", "CM", Listpc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotHaveLessThan5Char() {
        Listpc.add(pc);
        ctrl.createANewTypeOfTest("33", "IE", "CM", Listpc);
    }

    @Test
    public void ensureCodeHasWith5CharIsAccepted() {
        Listpc.add(pc);
        assertTrue( ctrl.createANewTypeOfTest("34565", "FL", "Cl", Listpc));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotBeCreatedBlank() {
        Listpc.add(pc);
        ctrl.createANewTypeOfTest("", "IE", "CM", Listpc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotHaveMoreThan15Char() {
        Listpc.add(pc);
        ctrl.createANewTypeOfTest("53436", "RNA remnants and Dna remnats", "cotton swab", Listpc);
    }

    @Test
    public void ensureDescriptionCanHave15Char() {
        Listpc.add(pc);
        assertTrue(ctrl.createANewTypeOfTest("53447", "RNA ", "cotton swab", Listpc));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotBeBlank() {
        Listpc.add(pc);
        ctrl.createANewTypeOfTest("53436", "", "cotton swab", Listpc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureColectingMethodCannotHaveMoreThan15Char() {
        Listpc.add(pc);
        ctrl.createANewTypeOfTest("53436", "RNA remnants", "cotton swab thro the nose", Listpc);
    }

    @Test
    public void ensureColectingMethodCanHave15Char() {
        Listpc.add(pc);
        assertTrue(ctrl.createANewTypeOfTest("53237", "RNA", "Seringe", Listpc));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureColectingMethodCannotBeBlank() {
        Listpc.add(pc);
        ctrl.createANewTypeOfTest("53436", "RNA remnants", "",Listpc );
    }

    @Test
    public void ensureCannotCreateSameTOTTwice() {
        Listpc.add(pc);
        ctrl.createANewTypeOfTest("33452", "IE", "CM", Listpc);
        ctrl.saveTypeOfTest();
        ctrl.createANewTypeOfTest("33452", "IE", "CM", Listpc);
        assertFalse(ctrl.saveTypeOfTest());
    }
}