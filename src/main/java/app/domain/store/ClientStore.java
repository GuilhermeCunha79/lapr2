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
                addClient(ct);
                return true;
            }
            return false;
        }


        public boolean addClient(Client ct)
        {
            if (ct != null) {
                if (!validateClient(ct))
                    return this.clientList.add(ct);
            }
            return false;
        }

        public boolean validateClient(Client ct) {
            for (Client parCt : clientList){
                if(parCt.equals(ct)){
                    return true;
                }
            }
            return false;
        }

        public List<Client> getClientList() {
            return clientList;
        }

    }
