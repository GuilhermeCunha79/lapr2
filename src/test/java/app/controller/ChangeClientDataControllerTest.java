package app.controller;


import app.domain.model.Client;
import app.mappers.dto.ClientDTO;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChangeClientDataControllerTest {

    RegisterClientController ctrl1 = new RegisterClientController();
    ChangeClientDataController ctrl= new ChangeClientDataController();
    ClientDTO dto = new ClientDTO("Tomás", "1234567890123455","1234567890","1234567890","23/12/2000","male","12345678901","tomas@isep.ipp.pt");

    @Test
    public void testGetClientByEmail() {
    }

    @Test
    public void testShowData() {

        String expected= "%nClient:%nName: Tomás%nCitizen Card Number: 1234567890123455%nNHS number: 1234567890%nTIN number: 1234567890%nBirth date: 23/12/2000%nSex: male%nPhone number: 12345678901%nEmail: tomas@isep.ipp.pt%n%n";
        Client client = new Client(dto);
        assertEquals(expected,ctrl.showData(client));
    }

    @Test
    public void testChangeName() {

    }

    @Test
    public void testChangeCitizenCardNumber() {
    }

    @Test
    public void testChangeNhsNumber() {
    }

    @Test
    public void testChangeTinNumber() {
    }

    @Test
    public void testChangeBirthDate() {
    }

    @Test
    public void testChangePhoneNumber() {
    }

    @Test
    public void testChangeEmail() {
    }

    @Test
    public void testSaveClient() {
    }
}