package app.domain.store;

import app.controller.App;
import app.domain.model.Client;
import app.domain.shared.Constants;
import app.domain.shared.SendingEmailSMS;
import app.mappers.dto.ClientDTO;
import auth.domain.model.Email;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import static app.domain.shared.PasswordGenerator.generatePassword;
import static app.domain.shared.SendingEmailSMS.sendEmailWithChanges;

public class ClientStore {

    private List<Client> clientList = new ArrayList<>();

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
                serializeStore();
                return true;
            } else {
                if (validateClient(client)) {
                    App.getInstance().getCompany().getAuthFacade().addUserWithRole(name, email, pwd, Constants.ROLE_CLIENT);
                    sendEmail(client, pwd);
                    addClient(client);
                    serializeStore();
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public boolean saveChanges(Client client) {
        if (client != null) {
            String name = client.getName();
            if (validateClient(client)) {
                sendEmailWithChanges(name);
                serializeStore();
                return true;
            }
            return true;
        }
        return false;
    }

    private void serializeStore() {
        try {
            FileOutputStream out = new FileOutputStream("data\\clients.dat");
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(this.clientList);
            outputStream.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private boolean checkDuplicate(Client client) {
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

    public void changeName(Client client, String name) {
        client.setName(name);
    }

    public void changeCitizenCardNumber(Client client, String citizenCardNumber) {
        client.setCitizenCardNumber(citizenCardNumber);
    }

    public void changeEmail(Client client, String email) {
        client.setEmail(email);
    }

    public void changeNhsNumber(Client client, String nhsNumber) {
        client.setNhsNumber(nhsNumber);
    }

    public void changeTinNumber(Client client, String tinNumber) {
        client.setTinNumber(tinNumber);
    }

    public void changeBirthDate(Client client, String birthDate) {
        client.setBirthDate(birthDate);
    }

    public void changePhoneNumber(Client client, String phoneNumber) {
        client.setPhoneNumber(phoneNumber);
    }


}

