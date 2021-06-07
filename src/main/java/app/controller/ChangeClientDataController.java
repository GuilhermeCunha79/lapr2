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

    public String showData(Client client) {
            return client.toString();
    }


    public void changeName(Client client, String name) {
        this.ctStore.changeName(client, name);
    }

    public void changeCitizenCardNumber(Client client, String name) {
        this.ctStore.changeCitizenCardNumber(client, name);
    }

    public void changeNhsNumber(Client client, String name) {
        this.ctStore.changeNhsNumber(client, name);
    }

    public void changeTinNumber(Client client, String name) {
        this.ctStore.changeTinNumber(client, name);
    }

    public void changeBirthDate(Client client, String name) {
        this.ctStore.changeBirthDate(client, name);
    }

    public void changePhoneNumber(Client client, String name) {
        this.ctStore.changePhoneNumber(client, name);
    }

    public void changeEmail(Client client, String name) {
        this.ctStore.changeEmail(client, name);
    }


    public boolean saveChanges() {
        return this.ctStore.saveChanges(ct);
    }

}

