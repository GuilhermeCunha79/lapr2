package app.domain.model;

import app.SortingMethods.Number.BubbleSortTinNumber;
import app.ui.console.utils.Utils;

import java.util.List;

public class SortingAdapterTIN implements Sorting{

    @Override
    public List<Client> getSortedList(List<Client> clientList){
        List<Client> orderedList = new BubbleSortTinNumber().orderedList(clientList);
        return orderedList;
    }
}
