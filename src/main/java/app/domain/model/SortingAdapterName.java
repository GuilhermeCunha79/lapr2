package app.domain.model;

import app.SortingMethods.Number.BubbleSortTinNumber;
import app.SortingMethods.String.BubbleSortName;
import app.SortingMethods.String.InsertionSortName;
import app.ui.console.utils.Utils;

import java.util.List;

public class SortingAdapterName implements Sorting {

    @Override
    public List<Client> getSortedList(List<Client> clientList) {
        long start = System.currentTimeMillis();
        List<Client> clients = new InsertionSortName().orderedList(clientList);
        System.out.println(System.currentTimeMillis() - start);
        return clients;
    }
}
