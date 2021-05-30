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

    private TestStore store;
    private Client client;

    ParameterCategory pc1 = new ParameterCategory("54321", "adaca");
    TypeOfTest tpt = new TypeOfTest("12345", "noth", "mao",pc1);
    ClientDTO clDto = new ClientDTO("maria", "1234567890123456", "1234567890", "1234567890", "23/12/2002", "male", "12345678901", "gui@isep.pt");
    Client client1 = new Client(clDto);
    List<Parameter> lp = new ArrayList<>();
    Parameter p1 = new Parameter("12345", "abcd", "adsavaa", pc1);
    CATest ct1 = new CATest("123456789111", client, tpt, lp, "lol");
    @Test
    public void testReadyToValidate() {
    }

    @Test
    public void testGetTestWithoutValidation() {
    }

    @Test
    public void testGetTestResults() {
       // assertEquals();
    }

    @Test
    public void testTestWithoutValidation() {
        List<Parameter> lp = new ArrayList<>();
        lp.add(p1);
        Assert.assertNotNull(ctrl.getTestWithoutValidation());
    }

    @Test
    public void testChangeStateToValidate() {
    }

    @Test
    public void testChangeStateToValidateOne() {
    }

    @Test
    public void testDoValidation() {
    }

    @Test
    public void testGetTestList() {
    }
}