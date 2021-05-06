package app.controller;

import app.domain.model.Client;
import app.domain.store.ClientStore;

public class RegisterClientController {
    private ClientStore ctStore;
    private Client ct;

    public RegisterClientController() {
        this(App.getInstance().getCompany().getClientStore());
    }

    public RegisterClientController(ClientStore ctStore) {
        this.ctStore=ctStore;
        this.ct = null;
    }

   public boolean newClient(String name, String citizenCardNumber,String nhsNumber, String tinNumber, String birthDate, String sex, String phoneNumber, String email){
        this.ct=this.ctStore.newClient(name, citizenCardNumber, nhsNumber,tinNumber,birthDate, sex, phoneNumber,email);
        return this.ctStore.validateClient(ct);
    }
    public boolean saveClient(){
        return this.ctStore.saveClient(ct);
    }
}
