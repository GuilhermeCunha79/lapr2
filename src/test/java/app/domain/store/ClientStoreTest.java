package app.domain.store;

import app.domain.mappers.dto.ClientDTO;
import app.domain.model.Client;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ClientStoreTest {

    ClientStore cls = new ClientStore();
    @Before
    public void createClientList() throws IOException {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456","1234567890","1234567890","23/12/2002","male","12345678901","tomas@isep.ipp.pt");
        Client ct01 = cls.newClient(dto);
        cls.saveClient(ct01);
    }


    @Test
    public void ensureCannotAddSameClientTwice() throws IOException {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456","1234567890","1234567890","23/12/2002","male","12345678901","tomas@isep.ipp.pt");
        Client ct01 = cls.newClient(dto);
        Client ct02 = cls.newClient(dto);
        cls.saveClient(ct01);
        assertFalse(cls.saveClient(ct02));
    }


    @Test
    public void ensureAdd2differentClientsWorks(){
        ClientDTO dto1 = new ClientDTO("Tomás", "1234567890123456","1234567890","1234567890","23/12/2002","male","12345678901","tomas@isep.ipp.pt");
        ClientDTO dto2 = new ClientDTO("Margarida", "1324354657687980", "1087654321", "2123345551", "23/10/2010","female","12345678911","margarida@isep.ipp.pt");
        Client ct01 = cls.newClient(dto1);
        Client ct02 = cls.newClient(dto2);
        cls.saveClient(ct01);
        assertTrue(cls.saveClient(ct02));
    }

    @Test
    public void testGetClientListMethod(){
        ClientDTO dto1 = new ClientDTO("Maria", "1234567190123456","1234517890","1234167890","23/12/2002","male","12345178901","tomas1@isep.ipp.pt");
        ClientDTO dto2 = new ClientDTO("Margarida", "1324354657687980", "1087654321", "2123345551", "23/10/2010","female","12345678901","margarida@isep.ipp.pt");
        Client ct01 = cls.newClient(dto1);
        Client ct02 = cls.newClient(dto2);
        cls.saveClient(ct01);
        cls.saveClient(ct02);
        assertTrue(cls.getClientList().contains(ct01) && cls.getClientList().contains(ct02));
    }


}