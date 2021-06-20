package app.domain.model;

import app.SortingMethods.Number.BubbleSortTinNumber;
import app.SortingMethods.Number.InsertionSortTinNumber;
import app.ui.console.utils.Utils;

import java.util.List;

public class SortingAdapterTIN implements Sorting{

    @Override
    public List<Client> getSortedList(List<Client> clientList){
        long start = System.currentTimeMillis();
        List<Client> orderedList = new InsertionSortTinNumber().orderedList(clientList);
        System.out.println(System.currentTimeMillis() - start);
        return orderedList;
    }
}
