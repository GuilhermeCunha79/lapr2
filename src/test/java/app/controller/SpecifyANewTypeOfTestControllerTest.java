package app.controller;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpecifyANewTypeOfTestControllerTest {
    private SpecifyANewTypeOfTestController ctrl = new SpecifyANewTypeOfTestController();

    @Test(expected = NullPointerException.class)
    public void ensureNullTypeOfTestIsNotCreated() {
        ctrl.createANewTypeOfTest(null, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTypeOfTestIsNotCreatedWithBlankAttributes() {
        ctrl.createANewTypeOfTest("", "","" , "34567");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericCodeAreNotAccepted() {

        ctrl.createANewTypeOfTest("334@2", "IE", "CM", "34567");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotHaveMoreThan5Char() {
        ctrl.createANewTypeOfTest("334672", "IE", "CM", "34567");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotHaveLessThan5Char() {
        ctrl.createANewTypeOfTest("33", "IE", "CM", "34567");
    }

    @Test
    public void ensureCodeHasWith5CharIsAccepted() {
        assertTrue( ctrl.createANewTypeOfTest("34565", "FL", "Cl", "34567"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotBeCreatedBlank() {
        ctrl.createANewTypeOfTest("", "IE", "CM", "34567");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotHaveMoreThan15Char() {
        ctrl.createANewTypeOfTest("53436", "RNA remnants and Dna remnats", "cotton swab", "34567");
    }

    @Test
    public void ensureDescriptionCanHave15Char() {
        assertTrue(ctrl.createANewTypeOfTest("53447", "RNA ", "cotton swab", "34567"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotBeBlank() {
        ctrl.createANewTypeOfTest("53436", "", "cotton swab", "34567");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCollectingMethodCannotHaveMoreThan15Char() {
        ctrl.createANewTypeOfTest("53436", "RNA remnants", "cotton swab thro the nose", "34567");
    }

    @Test
    public void ensureCollectingMethodCanHave15Char() {
        assertTrue(ctrl.createANewTypeOfTest("53237", "RNA", "Seringe", "34567"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCollectingMethodCannotBeBlank() {
        ctrl.createANewTypeOfTest("53436", "RNA remnants", "","34567" );
    }

    @Test
    public void ensureCannotCreateSameTOTTwice() {
        ctrl.createANewTypeOfTest("33452", "IE", "CM", "34567");
        ctrl.saveTypeOfTest();
        ctrl.createANewTypeOfTest("33452", "IE", "CM", "34567");
        assertFalse(ctrl.saveTypeOfTest());
    }

}