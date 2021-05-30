package app.controller;

import app.domain.model.*;
import app.domain.store.TestStore;
import app.mappers.dto.ClientDTO;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateTestControllerTest {

    ArrayList<CATest> ListTest = new ArrayList<>();

    CreateTestController ctt = new CreateTestController();

        private TestStore store;
        private Client client;

        ParameterCategory pc = new ParameterCategory("54321", "adaca");
        TypeOfTest tpt1 = new TypeOfTest("12345", "noth", "mao", pc);
        ClientDTO clDto = new ClientDTO("maria", "1234567890123456", "1234567890", "1234567890", "23/12/2002", "male", "12345678901", "gui@isep.pt");
        Client client1 = new Client(clDto);
        List<Parameter> lp = new ArrayList<>();
        Parameter p1 = new Parameter("12345", "abcd", "adsavaa", pc);
        CATest ct1 = new CATest("123456789111", client, tpt1, lp, "lol");




}
