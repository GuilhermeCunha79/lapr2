package app.domain.store;

import app.domain.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientStore {

        private List<Client> clientList = new ArrayList();


        public Client newClient(String name, String citizenCardNumber,String nhsNumber, String tinNumber, String birthDate, String sex, String phoneNumber, String email){
            return new Client(name, citizenCardNumber, nhsNumber, tinNumber, birthDate, sex, phoneNumber, email);
        }

        public boolean saveClient(Client ct){
            if(validateClient(ct)){
                return addClient(ct);
            }
            return false;
        }


        public boolean addClient(Client ct)
        {
            if (ct != null && validateClient(ct)) {
                    return this.clientList.add(ct);
            }
            return false;
        }

        public boolean validateClient(Client ct) {
            for (Client clt : clientList){
                if(clt.equals(ct)){
                    return false;
                }
            }
            return true;
        }

        public List<Client> getClientList() {
            return new ArrayList <>(clientList);
        }

    }
