package app.domain.store;

import app.controller.App;


import app.mappers.dto.ClientDTO;
import app.domain.model.Client;
import app.domain.shared.SendingEmail;


import java.util.ArrayList;
import java.util.List;

public class ClientStore {

    private List<Client> clientList = new ArrayList();


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
     * @param ct
     * @return if it was successfully added to the store (true or false)
     */
    public boolean saveClient(Client ct) {
        if (validateClient(ct)) {
            return addClient(ct);
        }
        return false;
    }

    /***
     * Method responsible to add a new client to the list when asked by the saveClient method
     * @param ct
     * @return if it was successfully added to the store (true or false)
     */
    private boolean addClient(Client ct) {
        if (ct != null) {
            return this.clientList.add(ct);
        }
        return false;
    }

    /***
     * Method responsible to validate a new client before it's added to the list when asked by the saveClient method
     * @param
     * @param client
     * @return if it was successfully added to the store (true or false)
     */
    public boolean validateClient(Client client) {
        for (Client clt : clientList) {
            String email = client.getEmail();
            if (App.getInstance().getCompany().getAuthFacade().existsUser(email) || checkDuplicate(clt)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDuplicate(Client client) {
        for (Client clt : clientList) {
            if (clt.equals(client)) {
                return true;
            }
        }
        return false;
    }

    private void sendEmail(Client client, String pwd){
        String name = client.getName();
        if(name != null){
            SendingEmail.sendEmailWithPassword(name, pwd);
        }
    }

    /***
     * This method return a copy of the Parameter List for other classes that need and can access it
     * @return List of clients
     */
    public List<Client> getClientList() {
        return new ArrayList<>(clientList);
    }

}
