package app.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class RegisterNewClinicalAnalysisLaboratoryControllerTest {

    RegisterNewClinicalAnalysisLaboratoryController ctrl = new RegisterNewClinicalAnalysisLaboratoryController();

    @Test(expected = NullPointerException.class)
    public void ensureNullClinicalAnalysisLaboratoryIsNotCreated() {
        ctrl.registerNewClinicalAnalysisLaboratory(null, null, null, null, null, null);
    }


}




