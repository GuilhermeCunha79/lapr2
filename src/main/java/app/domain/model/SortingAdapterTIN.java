package app.domain.model;

import app.SortingMethods.Number.BubbleSortTinNumber;

import java.util.List;

public class SortingAdapterTIN implements Sorting{

    @Override
    public String[] getSortedList(List<Client> clientList){
        return new BubbleSortTinNumber().bubbleSort(clientList);
    }
}
