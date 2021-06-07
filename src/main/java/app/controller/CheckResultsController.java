package app.controller;

import app.domain.model.Client;
import app.domain.model.ClinicalTest;
import app.domain.model.Company;
import app.domain.store.ClientStore;
import app.domain.store.TestStore;
import app.mappers.ClientMapper;
import app.mappers.TestsFinalizatedMapper;


import java.util.List;

public class CheckResultsController {

    private final ClientStore ctStore;
    private final TestStore tstStore;
    private Client ct;
    private ClinicalTest tst;

    public CheckResultsController() {
        this(App.getInstance().getCompany());
    }

    public CheckResultsController(Company company) {
        this.ctStore = company.getClientStore();
        this.tstStore = company.getTestStore();
        this.ct = null;
        this.tst=null;
    }

    public List<String> showClients() {
        List<Client> listClients = ctStore.getClientList();
        if(listClients != null) {
            ClientMapper tlm = new ClientMapper();
            return tlm.toDTOClient(listClients);
        }
        return null;
    }



    /**
     * This method returns a list with the main information about each test available without a report
     * @return a list of Strings holding the data for each test
     */
    public List<String> getTestsFinalizated(Client client){
        List<ClinicalTest> lTestNoReport = tstStore.getClientTests(client);
        if(lTestNoReport != null) {
            TestsFinalizatedMapper tlm = new TestsFinalizatedMapper();
            return tlm.toDtoFin(lTestNoReport);
        }
        return null;
    }

    public String getClientList(String tinNumber){
        this.ct=ctStore.getClientByTIN(tinNumber);
        return ct.getClientResults();

    }



}
