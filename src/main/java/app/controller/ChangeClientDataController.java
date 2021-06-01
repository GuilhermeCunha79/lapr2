package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.store.ClientStore;

public class ChangeClientDataController {

    private final ClientStore ctStore;
    private Client ct;

    public ChangeClientDataController() {
        this(App.getInstance().getCompany());
    }

    public ChangeClientDataController(Company company) {
        this.ctStore = company.getClientStore();
        this.ct = null;
    }
/*
    public Client getClientByEmail(){
        return this.ct = this.ctStore.getClientByEmail();
    }*/

    public void showData(Client client){
        System.out.println(client.toString());
    }


    public void saveChanges(){

    }

    public boolean saveClient() {
        return this.ctStore.saveClient(ct);
    }

}
