package app.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class CreateParameterCategoryControllerTest {

    CreateParameterCategoryController ctrl = new CreateParameterCategoryController();

    @Test(expected = NullPointerException.class)
    public void ensureNullParameterCategoryIsNotCreated() {
        ctrl.createNewParameterCategory(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureParameterCategoryIsNotCreatedWithBlankAttributes() {
        ctrl.createNewParameterCategory("", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericCodeAreNotAccepted() {
        ctrl.createNewParameterCategory("120@12", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotHaveMoreThan5Char() {
        ctrl.createNewParameterCategory("120121", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotHaveLessThan5Char() {
        ctrl.createNewParameterCategory("120", "hemograms");
    }

    @Test
    public void ensureCodeWith5CharIsAccepted() {
        assertTrue(ctrl.createNewParameterCategory("12112", "hemogram"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCodeCannotBeCreatedBlank() {
        ctrl.createNewParameterCategory("", "hemograms");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotHaveMoreThan15Char() {
        ctrl.createNewParameterCategory("12012", "hemogr8ams176572");
    }

    @Test
    public void ensureNameCanHave10Char() {
        assertTrue(ctrl.createNewParameterCategory("12015", "hemogramss"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotBeCreatedBlank() {
        ctrl.createNewParameterCategory("12012", "");
    }

    @Test
    public void ensureCannotCreateSamePCTwice() {
        ctrl.createNewParameterCategory("12012", "hemograms");
        ctrl.saveParameterCategory();
        ctrl.createNewParameterCategory("12012", "hemograms");
        assertFalse(ctrl.saveParameterCategory());
    }



}