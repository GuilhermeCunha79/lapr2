package app.domain.store;

import app.controller.App;
import app.domain.model.*;
import app.domain.shared.Constants;
import app.domain.shared.SendingEmailSMS;
import app.mappers.dto.ClientDTO;
import auth.domain.model.Email;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static app.domain.shared.CommonMethods.serializeStore;
import static app.domain.shared.PasswordGenerator.generatePassword;

public class ClientStore {

    static final String DATA_PATH = "data\\clients.dat";
    private List<Client> clientList = new ArrayList<>();

    private Client client;
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
            if (clientList.size() == 0) {
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


    /***
     * Method responsible for saving the changes made and serialize them
     * @param client
     * @return true or false
     */
    public boolean saveChanges(Client client) {
        if (client != null) {
            sendEmailWithChanges(client);
            serializeStore(this.clientList, DATA_PATH);
            return true;
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

    /***
     * Method that checks if two clients are equals
     * @param client
     * @return true or false
     */
    public boolean checkDuplicate(Client client) {
        for (Client clt : clientList) {
            if (clt.equals(client))
                return true;
        }
        return false;
    }


    /***
     * Method that is responsible to send an email to the client with his password, name and email
     * @param client
     * @param pwd
     */
    private void sendEmail(Client client, String pwd) {
        String name = client.getName();
        String email = client.getEmail();
        if (name != null) {
            SendingEmailSMS.sendEmailWithPassword(name, email, pwd);
        }
    }

    /***
     * Method that is responsible to send an email to the client with his password, name and email
     * @param client
     */
    private void sendEmailWithChanges(Client client) {
        String name = client.getName();
        if (name != null) {
            SendingEmailSMS.sendEmailWithChanges(name);
        }
    }

    /***
     * This method return a copy of the Parameter List for other classes that need and can access it
     * @return List of clients
     */
    public List<Client> getClientList() {
        return new ArrayList<>(clientList);
    }

    /***
     * This method sets  the client list
     * @param lClient
     */
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
     * @return client or null
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

    /***
     * Method that sets the client's name with a new one
     * @param client
     * @param name
     */
    public void changeName(Client client, String name) {
        client.setName(name);
    }


    /***
     * Method that sets the client's address with a new one
     * @param client
     * @param address
     * @return
     */
    public boolean changeAddress(Client client, String address) {
        for (Client client1 : clientList) {
            if (client1.getAddress().equals(address))
                return false;
        }
        client.setAddress(address);
        return true;
    }

    /***
     * Method that sets the client's birth date with a new one
     * @param client
     * @param birthDate
     */
    public void changeBirthDate(Client client, String birthDate) {
        client.setBirthDate(birthDate);
    }

    /***
     * Method that sets the client's sex with a new one
     * @param client
     * @param sex
     */
    public void changeSex(Client client, String sex) {
        client.setSex(sex);
    }

    /***
     * Method that sets the client's phone number with a new one
     * @param client
     * @param phoneNumber
     * @return
     */
    public boolean changePhoneNumber(Client client, String phoneNumber) {
        for (Client client1 : clientList) {
            if (client1.getPhoneNumber().equals(phoneNumber))
                return false;
        }
        client.setPhoneNumber(phoneNumber);
        return true;
    }

    public List<Client> getSortedList(String type) {
        List<Client> clientList = getClientList();
        if (clientList != null) {
            Sorting list = this.client.getSortingMethod(type);
            return list.getSortedList(clientList);
        }
        return null;
    }
}

