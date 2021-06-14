package app.domain.store;

import app.controller.App;
import app.domain.model.Client;
import app.domain.shared.Constants;
import app.domain.shared.SendingEmailSMS;
import app.mappers.dto.ClientDTO;
import auth.domain.model.Email;

import java.util.ArrayList;
import java.util.List;

import static app.domain.shared.CommonMethods.serializeStore;
import static app.domain.shared.PasswordGenerator.generatePassword;

public class ClientStore {

    private List<Client> clientList = new ArrayList<>();
    private final String DATA_PATH = "data\\clients.dat";

    /***
     * Method that receives parameters from the associated controller to create a new client
     * @param dto
     * @return
     */
    public Client newClient(ClientDTO dto) {
        return new Client(dto);
    }

    /***
     * This method validates the client received and adds it to the Parameter store by calling the method addClient
     * @param client
     * @return if it was successfully added to the store (true or false)
     */
    public boolean saveClient(Client client) {
        if (client != null) {
            String email = client.getEmail();
            String name = client.getName();
            String pwd = generatePassword();
            if (clientList.size()==0) {
                App.getInstance().getCompany().getAuthFacade().addUserWithRole(name, email, pwd, Constants.ROLE_CLIENT);
                sendEmail(client, pwd);
                addClient(client);
                serializeStore(this.clientList, DATA_PATH);
                return true;
            } else {
                if (validateClient(client)) {
                    App.getInstance().getCompany().getAuthFacade().addUserWithRole(name, email, pwd, Constants.ROLE_CLIENT);
                    sendEmail(client, pwd);
                    addClient(client);
                    serializeStore(this.clientList, DATA_PATH);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public boolean saveChanges(Client client) {
        if (client != null) {
            //client = getClientByNewEmail(client.getEmail());
            //String name = client.getName();
            if (!checkDuplicate(client)) {
                //sendEmailWithChanges(name);
                serializeStore(this.clientList, DATA_PATH);
                return true;
            }
            return false;
        }
        return false;
    }

    /***
     * Method responsible to add a new client to the list when asked by the saveClient method
     * @param ct
     * @return if it was successfully added to the store (true or false)
     */
    private boolean addClient(Client ct) {
        return this.clientList.add(ct);
    }

    /***
     * Method responsible to validate a new client before it's added to the list when asked by the saveClient method
     * @param
     * @param client
     * @return if it was successfully added to the store (true or false)
     */
    public boolean validateClient(Client client) {
        String email = client.getEmail();
        return !App.getInstance().getCompany().getAuthFacade().existsUser(email) && !checkDuplicate(client);
    }


    public boolean checkDuplicate(Client client) {
        for (Client clt : clientList) {
            if (clt.equals(client))
                return true;
        }
        return false;
    }

    private void sendEmail(Client client, String pwd) {
        String name = client.getName();
        String email = client.getEmail();
        if (name != null) {
            SendingEmailSMS.sendEmailWithPassword(name, email, pwd);
        }
    }

    /***
     * This method return a copy of the Parameter List for other classes that need and can access it
     * @return List of clients
     */
    public List<Client> getClientList() {
        return new ArrayList<>(clientList);
    }

    /*private void sendEmailWithChanges(String name) {
        if (name != null) {
            SendingEmailSMS.sendEmailWithChanges(name);
        }
    }*/

    public void setClientList(List<Client> lClient) {
        this.clientList = new ArrayList<>(lClient);
    }

    /***
     * This method return a client by find his TIN
     * @param tin
     * @return client
     */
    public Client getClientByTIN(String tin) {
        if (tin != null && !tin.isEmpty()) {
            for (Client client : clientList) {
                if (client.getTinNumber().equals(tin))
                    return client;
            }
        }
        return null;
    }
    



    /***
     * This method return a client by find his email
     * @return client
     */

    public Client getClientByEmail() {
        Email email = App.getInstance().getCompany().getAuthFacade().getCurrentUserSession().getUserId();
        String email1 = email.getEmail();
        for (Client client : clientList) {
            if (client.getEmail().equals(email1))
                return client;
        }
        return null;
    }
/*
    public Client getClientByNewEmail(String email) {
        for (Client client : clientList) {
            if (client.getEmail().equals(email))
                return client;
        }
        return null;
    }*/

    public void changeName(Client client, String name) {
        client.setName(name);
    }

    public boolean changeCitizenCardNumber(Client client, String citizenCardNumber) {
        for (Client client1 : clientList){
            if (client1.getCitizenCardNumber().equals(citizenCardNumber))
                return false;
        }
        client.setCitizenCardNumber(citizenCardNumber);
        return true;
    }

    public boolean changeEmail(Client client, String email) {
        for (Client client1 : clientList){
            if (client1.getEmail().equals(email))
                return false;
        }
        client.setEmail(email);
        return true;
    }

    public boolean changeAddress(Client client, String address) {
        for (Client client1 : clientList){
            if (client1.getAddress().equals(address))
                return false;
        }
        client.setAddress(address);
        return true;
    }

    public boolean changeNhsNumber(Client client, String nhsNumber) {
        for (Client client1 : clientList){
            if (client1.getNhsNumber().equals(nhsNumber))
                return false;
        }
        client.setNhsNumber(nhsNumber);
        return true;
    }

    public boolean changeTinNumber(Client client, String tinNumber) {
        for (Client client1 : clientList){
            if (client1.getTinNumber().equals(tinNumber))
                return false;
        }
        client.setTinNumber(tinNumber);
        return true;
    }

    public void changeBirthDate(Client client, String birthDate) {
        client.setBirthDate(birthDate);
    }

    public void changeSex(Client client, String sex) {
        client.setSex(sex);
    }

    public boolean changePhoneNumber(Client client, String phoneNumber) {
        for (Client client1 : clientList){
            if (client1.getPhoneNumber().equals(phoneNumber))
                return false;
        }
        client.setPhoneNumber(phoneNumber);
        return true;
    }
}

