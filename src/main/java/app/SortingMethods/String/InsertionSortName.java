package app.SortingMethods.String;

import app.domain.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InsertionSortName {

    /***
     * Method responsible for sorting the client list using insertion sort
     * @param clientList
     * @return array
     */
    public String[] insertionSort(List<Client> clientList) {
        String[] array = fillArray(clientList);
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j].compareToIgnoreCase(array[j - 1]) < 0) {
                    String temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }

    /***
     * Method that order a client list by name using bubble sort algorithm
     * @param clientList
     * @return arr3
     */
    public List<Client> orderedList(List<Client> clientList) {
        String[] sorted = insertionSort(clientList);
        List<Client> arr3 = new ArrayList<>();
        for (String name : sorted) {
            for (Client client1 : clientList) {
                if (name.equals(client1.getName())) {
                    arr3.add(client1);
                }
            }
        }
        return arr3;
    }

    /***
     * Method that fills an string array with a list of client's name
     * @param clientList
     * @return filled string array
     */
    private String[] fillArray(List<Client> clientList) {
        List<String> strings = new ArrayList<>(clientList.size());
        for (Client object : clientList) {
            strings.add(Objects.toString(object.getName(), null));
        }
        String[] array = new String[clientList.size()];

        return strings.toArray(array);
    }

}

