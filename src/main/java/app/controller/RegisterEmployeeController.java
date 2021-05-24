package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.store.EmployeeStore;
import app.mappers.dto.EmpDto;
import auth.domain.model.UserRole;

public class RegisterEmployeeController {
    public Employee employee;

    private EmployeeStore empStore;
    private Employee emp;


    /**
     * This method gets the company employee store
     */
    public RegisterEmployeeController (){
        this(App.getInstance().getCompany());
    }

    /**
     * Class Constructor
     * @param company
     */
    public RegisterEmployeeController(Company company){
        this.empStore = company.getEmployeeStore();
    }

    /**
     * Method that creates a specialist doctor from the given information
     * @param empDto
     * @return true or false
     */
    public boolean newEmployee(EmpDto empDto){
        this.emp = this.empStore.newEmployee(empDto);
        if(this.empStore.validateEmployee(emp)) {
            addEmployeeRole(empDto);
            return true;
        }
        return false;
    }
    
    private void addEmployeeRole(EmpDto empDto){
        UserRole role = empStore.getUserRole(empDto.getRoleId());
        emp.setRole(role);
    }

    /**
     * Method that creates a specialist doctor from the given information
     * @return if it was validates or not (True or false)
     */
    public boolean newSpecialistDoctor(EmpDto empDto){
        this.emp = this.empStore.newSpecialistDoctor(empDto);
        if(this.empStore.validateEmployee(emp)){
            addEmployeeRole(empDto);
            return true;
        }
        return false;
    }

    /**
     * Method that checks if the employee is a specialist doctor or not
     * @return if it is a specialist doctor (True or false)
     */
    public boolean isSpecialistDoctor(String role){
        return empStore.isSpecialistDoctor(role);
    }

    /**
     * Method that asks the employee store to save the category being created
     * @return if it was saved (True or false)
     */
    public boolean saveEmployee() {
        return this.empStore.saveEmployee(emp);
    }
}
