package app.domain.model;

import app.SortingMethods.Number.BubbleSortTinNumber;

import java.util.List;

public class SortingAdapterBubbleSortTIN implements Sorting{

    @Override
    public List<Client> getSortedList(List<Client> clientList){
        return new BubbleSortTinNumber().orderedList(clientList);
    }
}
