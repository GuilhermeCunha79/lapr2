package app.domain.model;

import app.mappers.dto.ClientDTO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SortingAdapterNameTest {

    @Test
    public void testGetSortedList() {
        ClientDTO dto1 = new ClientDTO("Alfredo", "1237897890123456", "1234567821", "9234567891", "23/12/2001", "male", "92345678901", "alfredo@isep.ipp.pt", "street 1");
        ClientDTO dto2 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        Client ct01 = new Client(dto1);
        Client ct02 = new Client(dto2);

        List<Client> clientList = new ArrayList<>();
        clientList.add(ct02);
        clientList.add(ct01);

        List<Client> ordered = new SortingAdapterName().getSortedList(clientList);

        assertTrue("expected", ordered.get(0).getName().equals("Alfredo"));


    }
}