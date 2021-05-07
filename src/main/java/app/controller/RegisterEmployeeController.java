package app.controller;

import app.domain.model.Employee;
import app.domain.model.OrganizationRole;

public class RegisterEmployeeController {
    public Employee employee;

    public RegisterEmployeeController(Employee employee){
        this.employee=employee;
    }

    public RegisterEmployeeController() {

    }

    public boolean newEmployee(OrganizationRole role, String name, String address, String phoneNumber, String email, int soc){
        this.employee = new Employee(role, name, address, phoneNumber, email, soc);
        return employee.validateEmployee(this.employee) ;
    }
}
