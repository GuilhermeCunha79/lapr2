package app.controller;

import app.domain.model.Employee;
import app.domain.shared.Constants;
import app.domain.store.EmployeeStore;

public class RegisterEmployeeController {
    public Employee employee;

    private EmployeeStore empStore;
    private Employee emp;

    /**
     * This method gets the company employee store
     */
    public RegisterEmployeeController (){
        this(App.getInstance().getCompany().getEmpStore());
    }

    /**
     * Class Constructor that assign
     * @param empStore
     */
    public RegisterEmployeeController(EmployeeStore empStore){
        this.empStore = empStore;
    }

    public boolean isSpecialistDoctor(String role){
        return role.equalsIgnoreCase(Constants.ROLE_SPECIALIST_DOCTOR);
    }

    public boolean createEmployee(String role, String name, String address, String phoneNumber, String email, int soc){
        this.emp = this.empStore.createEmployee(role, name, address, phoneNumber, email, soc);
        return saveEmployee();
    }

    public boolean createSpecialistDoctor(String role, String name, String address, String phoneNumber, String email, int soc, int indexNumber){
        this.emp = this.empStore.createSpecialistDoctor(role,name,address,phoneNumber,email,soc, indexNumber);
        return saveEmployee();
    }

    private boolean saveEmployee() {
        return this.empStore.saveEmployee(emp);
    }
}
