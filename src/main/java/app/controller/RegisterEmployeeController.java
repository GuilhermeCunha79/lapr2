package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.shared.CommonMethods;
import app.domain.shared.Constants;
import app.domain.store.EmployeeStore;
import auth.AuthFacade;
import auth.domain.store.UserStore;

import java.util.InputMismatchException;

public class RegisterEmployeeController {
    public Employee employee;

    private EmployeeStore empStore;
    private Employee emp;

    private AuthFacade authFacade;

    /**
     * This method gets the company employee store
     */
    public RegisterEmployeeController (){
        this(App.getInstance().getCompany());
        ;
    }

    /**
     * Class Constructor that assign
     * @param company
     */
    public RegisterEmployeeController(Company company){
        this.empStore = company.getEmpStore();
        this.authFacade = company.getAuthFacade();
    }

    public boolean isSpecialistDoctor(String role){
        return role.equalsIgnoreCase(Constants.ROLE_SPECIALIST_DOCTOR);
    }

    public boolean createEmployee(String role, String name, String address, String phoneNumber, String email, String soc){
        this.emp = this.empStore.createEmployee(role, name, address, phoneNumber, email, soc);
        if(saveEmployee())
            return addUserToSystem(name, email, role);
        return false;
    }

    private boolean addUserToSystem(String name, String email, String role) {
        String password = CommonMethods.generatePassword();
        try {
            if (this.authFacade.addUserWithRole(name, email, password, role)) {
                System.out.println(password);
                CommonMethods.sendEmailWithPassword(name, password);
                return true;
            }
        }catch(Exception e){
            return false;
        }
        return false;
    }

    public boolean createSpecialistDoctor(String role, String name, String address, String phoneNumber, String email, String soc, int indexNumber){
        this.emp = this.empStore.createSpecialistDoctor(role,name,address,phoneNumber,email,soc, indexNumber);
        return saveEmployee();
    }

    public boolean saveEmployee() {
        return this.empStore.saveEmployee(emp);
    }
}
