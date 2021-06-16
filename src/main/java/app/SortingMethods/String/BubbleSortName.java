package app.SortingMethods.String;

import app.domain.model.Client;

//import app.mappers.dto.ClientDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class BubbleSortName {


    private static String[] fillArray(List<Client> clientList) {
        List<String> strings = new ArrayList<>(clientList.size());
        for (Client object : clientList) {
            strings.add(Objects.toString(object.getName(), null));
        }
        String[] array = new String[clientList.size()];

        return strings.toArray(array);
    }
/*
    public static void main(String[] args) {
        BubbleSortName sorter = new BubbleSortName();
        List<Client> arr3 = new ArrayList<>();



        ClientDTO dto8 = new ClientDTO("Ana ana", "1234567890123456", "1234567891", "1234567890", "23/12/2002", "male", "12345678901", "tomas@isep.ipp.pt", "street");
        Client client8 = new Client(dto8);
        arr3.add(client8);ClientDTO dto = new ClientDTO("ana maria", "1234567890123456", "1234567891", "1234567890", "23/12/2002", "male", "12345678901", "tomas@isep.ipp.pt", "street");
        Client client = new Client(dto);
        arr3.add(client);
        ClientDTO dto4 = new ClientDTO("ana ana", "1234567890123456", "1234567891", "1234567890", "23/12/2002", "male", "12345678901", "tomas@isep.ipp.pt", "street");
        Client client4 = new Client(dto4);
        arr3.add(client4);


        ClientDTO dto1 = new ClientDTO("ana joana", "1234567890123456", "1234567891", "1234567890", "23/12/2002", "male", "12345678901", "tomas@isep.ipp.pt", "street");
        Client client1 = new Client(dto1);
        arr3.add(client1);
        ClientDTO dto9 = new ClientDTO("Filipe", "1234567890123456", "1234567891", "1234567890", "23/12/2002", "male", "12345678901", "tomas@isep.ipp.pt", "street");
        Client client9 = new Client(dto9);
        arr3.add(client9);
        ClientDTO dto6 = new ClientDTO("eduardo", "1234567890123456", "1234567891", "1234567890", "23/12/2002", "male", "12345678901", "tomas@isep.ipp.pt", "street");
        Client client6 = new Client(dto6);
        arr3.add(client6);

        sorter.displaySortedList(arr3);

   public void displaySortedList(List<Client> clientList) {

        String[] sorted = bubbleSort(clientList);
        List<Client> arr3 = new ArrayList<>();
        for (String name : sorted) {
            for (Client client1 : clientList) {
                if (name.equals(client1.getName())) {
                    arr3.add(client1);
                }
            }
        }
        CommonMethods.printList(arr3);
    }
    }*/

    public String[] bubbleSort(List<Client> clientList) {
        String[] a = fillArray(clientList);
        String temp;
        for (int j = 0; j < a.length; j++) {
            for (int i = j + 1; i < a.length; i++) {

                if (a[i].compareToIgnoreCase(a[j]) < 0) {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
        return a;
    }




}
