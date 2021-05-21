package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.shared.CommonMethods;
import app.domain.shared.Constants;
import app.domain.store.EmployeeStore;
import app.mappers.dto.EmpDto;
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

    /**
     * Method that checks if the employee is a specialist doctor or not
     * @return if it is a specialist doctor (True or false)
     */
    public boolean isSpecialistDoctor(String role){
        return role.equalsIgnoreCase(Constants.ROLE_SPECIALIST_DOCTOR);
    }

    /**
     * Method that creates a specialist doctor from the given information
     * @param empDto
     * @return true or false
     */
    public boolean createEmployee(EmpDto empDto){
        this.emp = this.empStore.createEmployee(empDto);
        return this.empStore.validateEmployee(emp);
    }

    /**
     * Method that adds the given information in a user and after introduces it in the system
     * @return if it was added (True or false)
     */
    private boolean addUserToSystem(String name, String email, String role) {
        return CommonMethods.addUserToSystem(name, email, role, this.authFacade);
    }

    /**
     * Method that creates a specialist doctor from the given information
     * @return if it was validates or not (True or false)
     */
    public boolean createSpecialistDoctor(EmpDto empDto){
        this.emp = this.empStore.createSpecialistDoctor(empDto);
        return this.empStore.validateEmployee(emp);
    }

    /**
     * Method that asks the employee store to save the category being created
     * @return if it was saved (True or false)
     */
    public boolean saveEmployee() {
        if(this.empStore.saveEmployee(emp))
            return addUserToSystem(emp.getName(), emp.getEmail(), emp.getRole());
        return false;
    }
}
