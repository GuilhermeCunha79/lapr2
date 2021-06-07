package app.mappers;

import app.domain.model.Client;


import java.util.ArrayList;
import java.util.List;

public class ClientMapper {

    public ClientMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static List<String> toDTOClient (List<Client> listClient){
        List<String> clientList = new ArrayList<>();
        for (Client ct : listClient){
            clientList.add(ct.toString());
        }
        return clientList;
    }
}
