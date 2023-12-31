package app.controller;

import app.domain.model.Parameter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CreateNewParameterControllerTest {

    CreateNewParameterController ctrl = new CreateNewParameterController();

    @Test(expected = NullPointerException.class)
    public void ensureNullParameterIsNotCreated() {
        ctrl.createNewParameter(null, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureParameterIsNotCreatedWithBlankAttributes() {
        ctrl.createNewParameter("", "","","");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericCodeAreNotAccepted() {
        ctrl.createNewParameter("120@12", "blood0", "description", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotHaveMoreThan5Char() {
        ctrl.createNewParameter("120121", "blood1", "description", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotHaveLessThan5Char() {
        ctrl.createNewParameter("120", "blood2", "description", "hemograms");
    }

    @Test
    public void ensureCodeHasWith5CharIsAccepted() {
        assertTrue(ctrl.createNewParameter("12812", "blood3", "descriptions", "hemograms"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotBeCreatedBlank() {
        ctrl.createNewParameter("", "blood4", "description", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotHaveMoreThan8Char() {
        ctrl.createNewParameter("12012", "hemograms2", "description", "hemograms");
    }

    @Test
    public void ensureNameCanHaveLessThan8Char() {
        assertTrue(ctrl.createNewParameter("12563", "hemoms2", "descriptiasdon", "hemograms"));
    }

    @Test
    public void ensureNameCanHave8Char() {
        assertTrue(ctrl.createNewParameter("12715", "hemoram", "descript", "hemograms"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotBeCreatedBlank() {
        ctrl.createNewParameter("12012", "", "description", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotHaveMoreThan20Char() {
        ctrl.createNewParameter("12912", "hemograms2", "description super long", "hemograms");
    }

    @Test
    public void ensureDescriptionCanHave20Char() {
        assertTrue(ctrl.createNewParameter("12015", "hemogram", "description with 20c", "hemograms"));
    }

    @Test
    public void ensureDescriptionCanHaveLessThan20Char() {
        assertTrue(ctrl.createNewParameter("12075", "hemogrsm", "descriptic", "hemograms"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionCannotBeCreatedBlank() {
        ctrl.createNewParameter("12012", "Blood", "", "hemograms");
    }

    @Test
    public void ensureCannotCreateSamePCTwice() {
        ctrl.createNewParameter("12012", "blood7", "description", "hemograms");
        ctrl.saveParameter();
        ctrl.createNewParameter("12012", "blood7", "description", "hemograms");
        assertFalse(ctrl.saveParameter());
    }



}