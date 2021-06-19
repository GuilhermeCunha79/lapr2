package app.SortingMethods.Number;

import app.domain.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class BubbleSortTinNumber {

    /***
     * Method that fills an string array with a list of client's tin number
     * @param clientList
     * @return filled string array
     */
    private String[] fillArray(List<Client> clientList) {
        List<String> strings = new ArrayList<>(clientList.size());
        for (Client object : clientList) {
            strings.add(Objects.toString(object.getTinNumber(), null));
        }
        String[] array = new String[clientList.size()];

        return strings.toArray(array);
    }

    /***
     * Method that order a client list by tin number using bubble sort algorithm
     * @param clientList
     * @return arr3
     */
    public List<Client> orderedList(List<Client> clientList) {
        String[] sorted = bubbleSort(clientList);
        List<Client> arr3 = new ArrayList<>();
        for (String name : sorted) {
            for (Client client1 : clientList) {
                if (name.equals(client1.getTinNumber())) {
                    arr3.add(client1);
                }
            }
        }
        return arr3;
    }

    /***
     * Method responsible for sorting the client list using bubble sort
     * @param clientList
     * @return a
     */
    public String[] bubbleSort(List<Client> clientList) {
        String[] a = fillArray(clientList);
        String temp;
        for (int j = 0; j < a.length; j++) {
            for (int i = j + 1; i < a.length; i++) {
                if (a[i].compareTo(a[j]) < 0) {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
        return a;
    }
}
