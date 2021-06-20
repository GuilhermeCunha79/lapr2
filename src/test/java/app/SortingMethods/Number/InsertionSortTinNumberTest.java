package app.SortingMethods.Number;

import app.domain.model.Client;
import app.mappers.dto.ClientDTO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InsertionSortTinNumberTest{

    @Test
    public void fillArrayTest(){
        List<Client> clientList= new ArrayList<>();
        ClientDTO dto = new ClientDTO("Tomás", "1234567891273456", "1234567891", "1234567810", "23/12/2001", "male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        Client client =new Client(dto);
        clientList.add(client);
        InsertionSortTinNumber lol1 = new InsertionSortTinNumber();
        String[] expected = {"1234567810"};
        assertEquals(expected,lol1.insertionSort(clientList));
    }

    @Test
    public void insertionTest(){
        List<Client> clientList= new ArrayList<>();
        ClientDTO dto1 = new ClientDTO("Tomás", "1234567891273456", "1234567891", "1111111111", "23/12/2001", "male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        Client client1=new Client(dto1);
        clientList.add(client1);
        ClientDTO dto3 = new ClientDTO("Tomás", "1234567891273456", "1234567891", "2222222222", "23/12/2001", "male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        Client client3 =new Client(dto3);
        clientList.add(client3);
        ClientDTO dto = new ClientDTO("Tomás", "1234567891273456", "1234567891", "0000000001", "23/12/2001", "male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        Client client =new Client(dto);
        clientList.add(client);

        InsertionSortTinNumber lol = new InsertionSortTinNumber();
        String[] expected = {"0000000001","1111111111","2222222222"};
        assertEquals(expected, lol.insertionSort(clientList));

    }

    @Test
    public void orderedListTest(){
        List<Client> clientList= new ArrayList<>();
        ClientDTO dto1 = new ClientDTO("Tomás", "1234567891273456", "1234567891", "1111111111", "23/12/2001", "male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        Client client1=new Client(dto1);
        clientList.add(client1);
        ClientDTO dto3 = new ClientDTO("Tomás", "1234567891273456", "1234567891", "2222222222", "23/12/2001", "male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        Client client3 =new Client(dto3);
        clientList.add(client3);
        ClientDTO dto = new ClientDTO("Tomás", "1234567891273456", "1234567891", "0000000001", "23/12/2001", "male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        Client client =new Client(dto);
        clientList.add(client);

        List<Client> expected= new ArrayList<>();
        expected.add(client);
        expected.add(client1);
        expected.add(client3);

        InsertionSortTinNumber lol = new InsertionSortTinNumber();

        assertEquals(expected,lol.orderedList(clientList));
    }

}