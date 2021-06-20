package app.domain.model;

import app.SortingMethods.Number.InsertionSortTinNumber;

import java.util.List;

public class SortingAdapterInsertionSortTIN implements Sorting{

    @Override
    public List<Client> getSortedList(List<Client> clientList){
        return new InsertionSortTinNumber().orderedList(clientList);
    }
}
