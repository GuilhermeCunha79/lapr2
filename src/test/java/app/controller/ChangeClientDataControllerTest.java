package app.controller;


import app.domain.model.Client;
import app.mappers.dto.ClientDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChangeClientDataControllerTest {

    ChangeClientDataController ctrl = new ChangeClientDataController();
    ClientDTO dto = new ClientDTO("Tomás", "1234567890123455", "1234567890", "1234567890", "23/12/2000", "male", "12345678901", "tomas@isep.ipp.pt", "street 21");
    Client client = new Client(dto);

    @Test
    public void testShowData() {

        String expected = String.format("%nClient:%nName: Tomás%nCitizen Card Number: 1234567890123455%nNHS number: 1234567890%nTIN number: 1234567890%nBirth date: 23/12/2000%nSex: male%nPhone number: 12345678901%nEmail: tomas@isep.ipp.pt%nAddress: street 21%n");
        assertEquals(expected, ctrl.showData(client));
    }

    /*@Test
    public void testGetClientByEmail(){
        String email="tomas@isep.ipp.pt";

        assertEquals(client,ctrl.getClientByEmail());
    }*/

    @Test
    public void testChangeName() {
        ctrl.changeName(client, "miguel");
        String expected = "miguel";
        assertEquals(expected, client.getName());
    }

    @Test
    public void testCitizenCardNumber() {
        ctrl.changeCitizenCardNumber(client, "1234565432345678");
        String expected = "1234565432345678";
        assertEquals(expected, client.getCitizenCardNumber());
    }

    @Test
    public void testNhsNumber() {
        ctrl.changeNhsNumber(client, "1232123456");
        String expected = "1232123456";
        assertEquals(expected, client.getNhsNumber());
    }

    @Test
    public void testChangeTinNumber() {
        ctrl.changeTinNumber(client, "1232123456");
        String expected = "1232123456";
        assertEquals(expected, client.getTinNumber());
    }

    @Test
    public void testChangeBirthDate() {
        ctrl.changeBirthDate(client, "23/12/2002");
        String expected = "23/12/2002";
        assertEquals(expected, client.getBirthDate());
    }

    @Test
    public void testChangePhoneNumber() {
        ctrl.changePhoneNumber(client, "23456543212");
        String expected = "23456543212";
        assertEquals(expected, client.getPhoneNumber());
    }
/*
    @Test
    public void testChangeEmail() {
        ctrl.changeEmail(client, "ola@isep.ipp.pt");
        String expected = "ola@isep.ipp.pt";
        assertEquals(expected, client.getEmail());
    }*/

    @Test
    public void testSaveNullChanges() {
        assertFalse(ctrl.saveChanges());
    }


}