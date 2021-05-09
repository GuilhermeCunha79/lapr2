package app.domain.store;

import app.domain.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientStore {

        private List<Client> clientList = new ArrayList();

    /***
     * Method that receives parameters from the associated controller to create a new client
     * @param name
     * @param citizenCardNumber
     * @param nhsNumber
     * @param tinNumber
     * @param birthDate
     * @param sex
     * @param phoneNumber
     * @param email
     * @return
     */
        public Client newClient(String name, String citizenCardNumber,String nhsNumber, String tinNumber, String birthDate, String sex, String phoneNumber, String email){
            return new Client(name, citizenCardNumber, nhsNumber, tinNumber, birthDate, sex, phoneNumber, email);
        }

    /***
     * This method validates the client received and adds it to the Parameter store by calling the method addClient
     * @param ct
     * @return if it was successfully added to the store (true or false)
     */
        public boolean saveClient(Client ct){
            if(validateClient(ct)){
                return addClient(ct);
            }
            return false;
        }

    /***
     * Method responsible to add a new client to the list when asked by the saveClient method
     * @param ct
     * @return if it was successfully added to the store (true or false)
     */
        public boolean addClient(Client ct)
        {
            if (ct != null && validateClient(ct)) {
                    return this.clientList.add(ct);
            }
            return false;
        }

    /***
     * Method responsible to validate a new client before it's added to the list when asked by the saveClient method
     * @param ct
     * @return if it was successfully added to the store (true or false)
     */
    public boolean validateClient(Client ct) {
            for (Client clt : clientList){
                if(clt.equals(ct)){
                    return false;
                }
            }
            return true;
        }

    /***
     * This method return a copy of the Parameter List for other classes that need and can access it
     * @return List of clients
     */
        public List<Client> getClientList() {
            return new ArrayList <>(clientList);
        }

    }
