package app.domain.model;

import app.SortingMethods.String.BubbleSortName;

import java.util.List;

public class SortingAdapterBubbleSortName implements Sorting{

    @Override
    public List<Client> getSortedList(List<Client> clientList) {
        return new BubbleSortName().orderedList(clientList);
    }
}
