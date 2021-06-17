package app.SortingMethods.Number;

import app.domain.model.Client;
import app.mappers.dto.ClientDTO;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;


public class BubbleSortTinNumberTest{


    @Test
    public void fillArrayTest(){
        List<Client> clientList= new ArrayList<>();
        ClientDTO dto = new ClientDTO("Tomás", "1234567891273456", "1234567891", "1234567810", "23/12/2001", "male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        Client client =new Client(dto);
        clientList.add(client);
        BubbleSortTinNumber lol = new BubbleSortTinNumber();
        String[] expected = {"1234567810"};
        assertEquals(expected,lol.bubbleSort(clientList));
    }

    @Test
    public void bubbleSortTest(){
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

        BubbleSortTinNumber lol = new BubbleSortTinNumber();
        String[] expected = {"0000000001","1111111111","2222222222"};
        assertEquals(expected, lol.bubbleSort(clientList));

    }

}