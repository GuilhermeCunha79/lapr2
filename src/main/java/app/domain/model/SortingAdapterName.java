package app.domain.model;

import app.SortingMethods.Number.BubbleSortTinNumber;
import app.SortingMethods.String.BubbleSortName;
import app.ui.console.utils.Utils;

import java.util.List;

public class SortingAdapterName implements Sorting{

    @Override
    public List<Client> getSortedList(List<Client> clientList) {
        long start = System.currentTimeMillis();
        List<Client> client= new BubbleSortName().orderedList(clientList);
        String time = String.format("%d",System.currentTimeMillis()-start);
        Utils.printToConsole(time);
        return client;
    }
}
