package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;

public class RegisterClientController {
    private Company company;
    private Client ct;

    public RegisterClientController(){
        this(App.getInstance().getCompany());
    }

    public RegisterClientController(Company company) {
        this.company=company;
        this.ct = null;
    }

   // public boolean newClient(long nhsNumber, String name, long tinNumber, String birthDate, String sex, String email){
        //this.ct=this.company.newClient;
    //}
}
