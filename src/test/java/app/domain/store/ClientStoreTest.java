package app.domain.store;

import app.mappers.dto.ClientDTO;
import app.domain.model.Client;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ClientStoreTest {

    ClientStore cls = new ClientStore();

    @Before
    public void createClientList() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456","1234567890","1234567890","23/12/2002","male","12345678901","tomas@isep.ipp.pt", "street 1");
        Client ct01 = cls.newClient(dto);
        cls.saveClient(ct01);
    }


    @Test
    public void ensureCannotAddSameClientTwice() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456","1234536890","1234505890","23/12/2002","male","12345634901","tomas@gmail.pt", "street 1");
        Client ct01 = cls.newClient(dto);
        Client ct02 = cls.newClient(dto);
        cls.saveClient(ct01);
        assertFalse(cls.saveClient(ct02));
    }


    @Test
    public void testSaveChanges() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567899123456","1239567890","1234569990","23/12/2002","male","12345679901","tomas@outlook.pt", "street 3");
        Client ct01 = cls.newClient(dto);
        assertTrue(cls.saveChanges(ct01));
    }
/*
    @Test
    public void testSaveClient() {
        ClientDTO dto = new ClientDTO("Tom", "1234567490624856","1244157490","1214557490","23/12/2002","male","14445518901","to@yahoo.pt", "street 4");
        Client ct01 = cls.newClient(dto);
        assertTrue(cls.saveClient(ct01));
    }
    */
}