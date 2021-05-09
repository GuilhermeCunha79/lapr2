package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.shared.CommonMethods;
import app.domain.shared.Constants;
import app.domain.store.ClientStore;
import auth.AuthFacade;

import java.util.List;

public class RegisterClientController {
    private ClientStore ctStore;
    private Client ct;

    private AuthFacade authFacade;

    public RegisterClientController() {
        this(App.getInstance().getCompany());
    }

    public RegisterClientController(Company company) {
        this.ctStore= company.getClientStore();
        this.authFacade = company.getAuthFacade();
        this.ct = null;
    }

   public boolean newClient(String name, String citizenCardNumber,String nhsNumber, String tinNumber, String birthDate, String sex, String phoneNumber, String email){
        this.ct=this.ctStore.newClient(name, citizenCardNumber, nhsNumber,tinNumber,birthDate, sex, phoneNumber,email);
        return this.ctStore.validateClient(ct);
    }
    public boolean saveClient(){
        if(this.ctStore.saveClient(ct));
        return addUserToSystem(ct.getName(), ct.getEmail(), Constants.ROLE_CLIENT);
    }

    private boolean addUserToSystem(String name, String email, String role) {
        return CommonMethods.addUserToSystem(name, email, role, this.authFacade);
    }

    public List<Client> getClientList(){
        return App.getInstance().getCompany().getClientStore().getClientList();
    }
}
