package app.SortingMethods.String;

import app.SortingMethods.Number.BubbleSortTinNumber;
import app.domain.model.Client;
import app.mappers.dto.ClientDTO;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InsertionSortNameTest{

    @Test
    public void fillArrayTest(){
        List<Client> clientList= new ArrayList<>();
        ClientDTO dto = new ClientDTO("Tomás", "1234567891273456", "1234567891", "1234567810", "23/12/2001", "male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        Client client =new Client(dto);
        clientList.add(client);
        InsertionSortName lol = new InsertionSortName();
        String[] expected = {"Tomás"};
        assertEquals(expected,lol.insertionSort(clientList));
    }

    @Test
    public void bubbleSortTest(){
        List<Client> clientList= new ArrayList<>();
        ClientDTO dto1 = new ClientDTO("Miguel", "1234567891273456", "1234567891", "1111111111", "23/12/2001", "male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        Client client1=new Client(dto1);
        clientList.add(client1);
        ClientDTO dto3 = new ClientDTO("Ana", "1234567891273456", "1234567891", "2222222222", "23/12/2001", "male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        Client client3 =new Client(dto3);
        clientList.add(client3);
        ClientDTO dto = new ClientDTO("Beatriz", "1234567891273456", "1234567891", "0000000001", "23/12/2001", "male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        Client client =new Client(dto);
        clientList.add(client);

        InsertionSortName lol = new InsertionSortName();
        String[] expected = {"Ana","Beatriz","Miguel"};
        assertEquals(expected, lol.insertionSort(clientList));

    }

    @Test
    public void orderedListTest(){
        List<Client> clientList= new ArrayList<>();
        ClientDTO dto1 = new ClientDTO("Beatriz", "1234567891273456", "1234567891", "1111111111", "23/12/2001", "male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        Client client1=new Client(dto1);
        clientList.add(client1);
        ClientDTO dto3 = new ClientDTO("Carla", "1234567891273456", "1234567891", "2222222222", "23/12/2001", "male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        Client client3 =new Client(dto3);
        clientList.add(client3);
        ClientDTO dto = new ClientDTO("Ana", "1234567891273456", "1234567891", "0000000001", "23/12/2001", "male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        Client client =new Client(dto);
        clientList.add(client);

        List<Client> expected= new ArrayList<>();
        expected.add(client);
        expected.add(client1);
        expected.add(client3);

        InsertionSortName lol = new InsertionSortName();

        assertEquals(expected,lol.orderedList(clientList));
    }

}