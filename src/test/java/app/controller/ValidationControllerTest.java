
package app.controller;

import app.domain.model.*;
import app.domain.store.TestStore;
import app.mappers.dto.ClientDTO;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

public class ValidationControllerTest extends TestCase {

    ValidationController ctrl= new ValidationController();
    CreateTestController ctrl1= new CreateTestController();





@Test
    public void testGetTestWithoutValidationMethodWhenThereAreNoTests() {
        Assert.assertNotNull(ctrl.getTestWithoutValidation());
    }
/*
    @Test
    public void testGetTestWithoutValidation(){

    }

    @Test
    public void testSaveValidation(){

    assertTrue(ctrl.saveValidation(ct1.getInternalCode()));
    }

    @Test
    public void testGetTestByCode(){
    String code= "123456789111";

    assertEquals(ct1,ctrl.getTestByCode(code));
    }*/
}
