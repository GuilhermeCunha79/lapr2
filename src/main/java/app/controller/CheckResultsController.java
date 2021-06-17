package app.controller;

import app.domain.model.Client;
import app.domain.model.ClinicalTest;
import app.domain.model.Company;
import app.domain.store.ClientStore;
import app.domain.store.TestStore;
import app.mappers.ClientMapper;
import app.mappers.TestsFinalizedMapper;

import java.util.List;

public class CheckResultsController {

    private final ClientStore ctStore;
    private final TestStore tstStore;
    private Client ct;

    public CheckResultsController() {
        this(App.getInstance().getCompany());
    }

    public CheckResultsController(Company company) {
        this.ctStore = company.getClientStore();
        this.tstStore = company.getTestStore();
        this.ct = null;
    }

    public List<String> showClients() {
        List<Client> listClients = ctStore.getClientList();
        if(listClients != null) {
            return ClientMapper.toDTOClient(listClients);
        }
        return null;
    }

    public List<String> showOrderedClients(String type){
        List<Client> orderedClients= ctStore.getSortedList(type);
        if(orderedClients != null) {
            return ClientMapper.toDTOClient(orderedClients);
        }
        return null;
    }

    public List<String> showTestDetails(String tin){
        this.ct=ctStore.getClientByTIN(tin);
        List<ClinicalTest> lTestNoReport = tstStore.getClientTests(ct);
        if(lTestNoReport != null) {
            return TestsFinalizedMapper.toDtoFin(lTestNoReport);
        }
        return null;
    }




}
