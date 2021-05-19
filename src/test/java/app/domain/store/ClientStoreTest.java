package app.domain.store;

import app.controller.App;
import app.domain.dto.ClientDto;
import app.domain.model.Client;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ClientStoreTest {

    ClientStore cls = new ClientStore();
    @Before
    public void createClientList(){
        ClientDto dto = new ClientDto("Tomás", "1234567890123456","1234567890","1234567890","23/12/2002","male","12345678901","tomas@isep.ipp.pt");
        Client clt = new Client(dto);
        Client ct01 = cls.newClient(dto);
        cls.saveClient(ct01);
    }


    @Test
    public void ensureCannotAddSameClientTwice(){
        ClientDto dto = new ClientDto("Tomás", "1234567890123456","1234567890","1234567890","23/12/2002","male","12345678901","tomas@isep.ipp.pt");
        Client ct01 = cls.newClient(dto);
        Client ct02 = cls.newClient(dto);
        cls.saveClient(ct01);
        assertFalse(cls.saveClient(ct02));
    }


    @Test
    public void ensureAdd2differentClientsWorks(){
        ClientDto dto1 = new ClientDto("Tomás", "1234567890123456","1234567890","1234567890","23/12/2002","male","12345678901","tomas@isep.ipp.pt");
        ClientDto dto2 = new ClientDto("Margarida", "1324354657687980", "1087654321", "2123345551", "23/10/2010","female","12345678901","margarida@isep.ipp.pt");
        Client ct01 = cls.newClient(dto1);
        Client ct02 = cls.newClient(dto2);
        cls.saveClient(ct01);
        assertTrue(cls.saveClient(ct02));
    }

    @Test
    public void testGetClientListMethod(){
        ClientDto dto1 = new ClientDto("Tomás", "1234567890123456","1234567890","1234567890","23/12/2002","male","12345678901","tomas@isep.ipp.pt");
        ClientDto dto2 = new ClientDto("Margarida", "1324354657687980", "1087654321", "2123345551", "23/10/2010","female","12345678901","margarida@isep.ipp.pt");
        Client ct01 = cls.newClient(dto1);
        Client ct02 = cls.newClient(dto2);
        cls.saveClient(ct01);
        cls.saveClient(ct02);
        assertTrue(cls.getClientList().contains(ct01) && cls.getClientList().contains(ct02));
    }


}