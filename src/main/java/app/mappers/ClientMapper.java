package app.mappers;

import app.domain.model.Client;


import java.util.ArrayList;
import java.util.List;

public class ClientMapper {

    private ClientMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static List<String> toDTOClient (List<Client> listClient){
        List<String> clientList = new ArrayList<>();
        for (Client ct : listClient){
            clientList.add(String.format("Name: %s | Citizen Card Number: %s | NHS number: %s | TIN number: %s | Birth date: %s | Sex: %s | Phone number: %s | Email: %s | Address: %s %n", ct.getName(),ct.getCitizenCardNumber(),ct.getNhsNumber(),ct.getTinNumber(),ct.getBirthDate(),ct.getSex(),ct.getPhoneNumber(),ct.getEmail(),ct.getAddress()));
        }
        return clientList;
    }
}
