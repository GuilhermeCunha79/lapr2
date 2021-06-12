package app.SortingMethods.numberSorting;

import app.domain.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuickSort {


    private static int[] fillArray(List<Client> clientList) {
        int[] array = new int[clientList.size()];
        for (Client client : clientList) {
            for (int i = 0; i < clientList.size(); i++) {
                int number = Integer.parseInt(client.getTinNumber());
                array[i] = number;
            }
        }
        return array;
    }

    private static int partition(int[] arr, int begin, int end) {
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[end]) {
                int temp = arr[counter];
                arr[counter] = arr[i];
                arr[i] = temp;
                counter++;
            }
        }
        int temp = arr[end];
        arr[end] = arr[counter];
        arr[counter] = temp;

        return counter;
    }


    public static List<Integer> quickSort(int[] arr, int begin, int end) {
        if (end <= begin)
            return null;
        int pivot = partition(arr, begin, end);
        List<Integer> arr1 = quickSort(arr, begin, pivot - 1);
        List<Integer> arr2 = quickSort(arr, pivot + 1, end);
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.addAll(arr1);
        list1.addAll(arr2);
        return (list1);
    }

    private List<Client> displaySortedList(List<Client> clientList) {
        int size = clientList.size();
        int[] arr = fillArray(clientList);
        List<Integer> arr2 = quickSort(arr, 0, size);
        List<Client> arr3 = new ArrayList<>();
        for (int i = 0; i < Objects.requireNonNull(arr2).size(); i++) {
            for (Integer number : arr2) {
                for (Client client1 : clientList) {
                    if (number == Integer.parseInt(client1.getTinNumber())) {
                        arr3.add(client1);
                    }
                }
            }
        }
        return arr3;
    }

}
