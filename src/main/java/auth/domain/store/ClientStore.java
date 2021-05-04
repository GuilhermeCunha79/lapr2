package auth.domain.store;

import app.domain.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientStore {

        private List<Client> clientList = new ArrayList();


        public Client newClient(String name, long nhsNumber, long tinNumber, String birthDate, String sex, long phoneNumber, String email){
            return new Client(name, nhsNumber, tinNumber, birthDate, sex, phoneNumber, email);
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
            for (Client parClt : clientList){
                if(parClt.equals(ct)){
                    return true;
                }
            }
            return false;
        }

        public List<Client> getClientList() {
            return clientList;
        }

    }
