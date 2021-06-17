package app.domain.model;

import java.util.List;

public interface Sorting {

    List<Client> getSortedList(List<Client> clientList);
}
