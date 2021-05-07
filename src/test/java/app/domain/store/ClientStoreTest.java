package app.domain.store;

import app.domain.model.Client;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ClientStoreTest {

    ClientStore cls = new ClientStore();
    @Before
    public void createClientList(){
        Client ct01 = cls.newClient("Tomás", "1234567890123456","1234567890","1234567890","23/12/2002","male","12345678901","tomas@isep.ipp.pt");
        cls.addClient(ct01);
    }

    ClientStore cs = new ClientStore();
    @Test
    public void ensureCannotAddSameClientTwice(){
        Client ct01 = cs.newClient("Tomás", "1234567890123456","1234567890","1234567890","23/12/2002","male","12345678901","tomas@isep.ipp.pt");
        Client ct02 = cs.newClient("Tomás", "1234567890123456","1234567890","1234567890","23/12/2002","male","12345678901","tomas@isep.ipp.pt");
        cs.saveClient(ct01);
        assertFalse(cs.saveClient(ct02));
    }


    @Test
    public void ensureCannotAddSameClientTwiceTest2AddClient(){
        Client ct01 = cs.newClient("Tomás", "1234567890123456","1234567890","1234567890","23/12/2002","male","12345678901","tomas@isep.ipp.pt");
        Client ct02 = cs.newClient("Tomás", "1234567890123456","1234567890","1234567890","23/12/2002","male","12345678901","tomas@isep.ipp.pt");
        cs.addClient(ct01);
        assertFalse(cs.addClient(ct02));
    }


    @Test
    public void ensureAdd2differentClientsWorks(){
        Client ct01 = cs.newClient("Tomás", "1234567890123456","1234567890","1234567890","23/12/2002","male","12345678901","tomas@isep.ipp.pt");
        Client ct02 = cs.newClient("Miguel", "1234567890121212","1231121212","3212312313","20/10/2000","female","54321678901","tomas1@isep.ipp.pt");
        cs.saveClient(ct01);
        assertTrue(cs.saveClient(ct02));
    }

    @Test
    public void ensureAddNullCategoryDontWork(){
        assertFalse(cs.addClient(null));
    }

    @Test
    public void testGetCategoryListMethod(){
        Client ct01 = cs.newClient("Tomás", "1234567890123456", "1234567890", "1234567890","23/12/2002","male","12323232323","tomas@isep.ipp.pt");
        Client ct02 = cs.newClient("Margarida", "1324354657687980", "1087654321", "2123345551", "23/10/2010","female","12345678901","margarida@isep.ipp.pt");
        cs.saveClient(ct01);
        cs.saveClient(ct02);
        assertTrue(cs.getClientList().contains(ct01) && cs.getClientList().contains(ct02));
    }


}