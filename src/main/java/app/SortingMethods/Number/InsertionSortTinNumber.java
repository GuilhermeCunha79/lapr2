package app.SortingMethods.Number;

import app.domain.model.Client;
import app.domain.shared.CommonMethods;
//import app.mappers.dto.ClientDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InsertionSortTinNumber {

    public String[] insertionSort(List<Client> clientList) {
        String[] array = fillArray(clientList);
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    String temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }

/*
    public static void main(String[] args) {
        InsertionSortTinNumber sorter = new InsertionSortTinNumber();
        List<Client> arr3 = new ArrayList<>();


        ClientDTO dto8 = new ClientDTO("zebreu", "1234567890123456", "1234567891", "1234567890", "23/12/2002", "male", "12345678901", "tomas@isep.ipp.pt", "street");
        Client client8 = new Client(dto8);
        arr3.add(client8);
        ClientDTO dto = new ClientDTO("ana maria", "1234567890123456", "1234567891", "1234567890", "23/12/2002", "male", "12345678901", "tomas@isep.ipp.pt", "street");
        Client client = new Client(dto);
        arr3.add(client);
        ClientDTO dto4 = new ClientDTO("ana ana", "1234567890123456", "1234567891", "1111111111", "23/12/2002", "male", "12345678901", "tomas@isep.ipp.pt", "street");
        Client client4 = new Client(dto4);
        arr3.add(client4);


        ClientDTO dto1 = new ClientDTO("ana joana", "1234567890123456", "1234567891", "2121212121", "23/12/2002", "male", "12345678901", "tomas@isep.ipp.pt", "street");
        Client client1 = new Client(dto1);
        arr3.add(client1);
        ClientDTO dto9 = new ClientDTO("filipe", "1234567890123456", "1234567891", "4321234567", "23/12/2002", "male", "12345678901", "tomas@isep.ipp.pt", "street");
        Client client9 = new Client(dto9);
        arr3.add(client9);
        ClientDTO dto6 = new ClientDTO("eduardo", "1234567890123456", "1234567891", "0123456789", "23/12/2002", "male", "12345678901", "tomas@isep.ipp.pt", "street");
        Client client6 = new Client(dto6);
        arr3.add(client6);

        sorter.displaySortedList(arr3);

         public void displaySortedList(List<Client> clientList) {

        String[] sorted = insertionSort(clientList);
        List<Client> arr3 = new ArrayList<>();
        for (String name : sorted) {
            for (Client client1 : clientList) {
                if (name.equals(client1.getTinNumber())) {
                    arr3.add(client1);
                }
            }
        }
        CommonMethods.printList(arr3);
    }
    }*/

    private static String[] fillArray(List<Client> clientList) {
        List<String> strings = new ArrayList<>(clientList.size());
        for (Client object : clientList) {
            strings.add(Objects.toString(object.getTinNumber(), null));
        }
        String[] array = new String[clientList.size()];

        return strings.toArray(array);
    }





}

