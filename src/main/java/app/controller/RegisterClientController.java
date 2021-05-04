package app.controller;

import app.domain.model.Client;
import auth.domain.store.ClientStore;

public class RegisterClientController {
    private ClientStore ctStore;
    private Client ct;

    public RegisterClientController(ClientStore clientStore) {
        this.ctStore=ctStore;
        this.ct = null;
    }

   public boolean newClient(String name, long citizenCardNumber,long nhsNumber, long tinNumber, String birthDate, String sex, long phoneNumber, String email){
        this.ct=this.ctStore.newClient(name, citizenCardNumber, nhsNumber,tinNumber,birthDate, sex, phoneNumber,email);
        return this.ctStore.validateClient(ct);
    }
    public boolean saveClient(){
        return this.ctStore.saveClient(ct);
    }
}
