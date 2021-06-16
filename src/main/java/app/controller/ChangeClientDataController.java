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

    public Client getClientByEmail() {
        return this.ct = this.ctStore.getClientByEmail();
    }
/*
    public Client getClientByNewEmail() {
        return this.ct = this.ctStore.getClientByNewEmail(ct.getEmail());
    }*/

    public String showData(Client client) {
            return client.toString();
    }


    public void changeName(Client client, String name) {
        this.ctStore.changeName(client, name);
    }

    public void changeBirthDate(Client client, String name) {
        this.ctStore.changeBirthDate(client, name);
    }

    public void changeSex(Client client, String name) {
        this.ctStore.changeSex(client, name);
    }

    public boolean changePhoneNumber(Client client, String name) {
        return this.ctStore.changePhoneNumber(client, name);

    }

    public boolean changeAddress(Client client, String name) {
        return this.ctStore.changeAddress(client, name);
    }

    public String getName(){
        return this.ct.getName();
    }

    public String getCitizenCardNumber(){
        return this.ct.getCitizenCardNumber();
    }

    public String getNhs(){
        return this.ct.getNhsNumber();
    }

    public String getTin(){
        return this.ct.getTinNumber();
    }

    public String getSex(){
        return this.ct.getSex();
    }

    public String getBirthDate(){
        return this.ct.getBirthDate();
    }

    public String getPhoneNumber(){
        return this.ct.getPhoneNumber();
    }

    public String getEmail(){
        return this.ct.getEmail();
    }
    public String getAddress(){
        return this.ct.getAddress();
    }




    public boolean saveChanges() {
        return this.ctStore.saveChanges(ct);
    }

}

