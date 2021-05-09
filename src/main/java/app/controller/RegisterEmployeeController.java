package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.shared.CommonMethods;
import app.domain.shared.Constants;
import app.domain.store.EmployeeStore;
import auth.AuthFacade;

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
     * Class Constructor
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
        return this.empStore.validateEmployee(emp);
    }

    private boolean addUserToSystem(String name, String email, String role) {
        return CommonMethods.addUserToSystem(name, email, role, this.authFacade);
    }

    public boolean createSpecialistDoctor(String role, String name, String address, String phoneNumber, String email, String soc, int indexNumber){
        this.emp = this.empStore.createSpecialistDoctor(role,name,address,phoneNumber,email,soc, indexNumber);
        return this.empStore.validateEmployee(emp);
    }

    public boolean saveEmployee() {
        if(this.empStore.saveEmployee(emp))
            return addUserToSystem(emp.getName(), emp.getEmail(), emp.getRole());
        return false;
    }
}
