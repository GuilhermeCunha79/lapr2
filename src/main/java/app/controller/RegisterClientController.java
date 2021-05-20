package app.controller;

import app.domain.mappers.dto.ClientDTO;
import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.store.ClientStore;


import java.io.IOException;
import java.util.List;

public class RegisterClientController {
    private final ClientStore ctStore;
    private Client ct;

    public RegisterClientController() {
        this(App.getInstance().getCompany());
    }

    public RegisterClientController(Company company) {
        this.ctStore = company.getClientStore();
        this.ct = null;
    }

    public boolean newClient(ClientDTO dto) {
        this.ct = this.ctStore.newClient(dto);
        return this.ctStore.validateClient(ct);
    }

    public boolean saveClient() throws IOException {
        return this.ctStore.saveClient(ct);
    }

    public List<Client> getClientList() {
        return App.getInstance().getCompany().getClientStore().getClientList();
    }

}
