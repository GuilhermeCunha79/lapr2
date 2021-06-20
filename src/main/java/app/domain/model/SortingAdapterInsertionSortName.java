package app.domain.model;

import app.SortingMethods.String.InsertionSortName;

import java.util.List;

public class SortingAdapterInsertionSortName implements Sorting{

    @Override
    public List<Client> getSortedList(List<Client> clientList){
        return new InsertionSortName().orderedList(clientList);
    }
}
