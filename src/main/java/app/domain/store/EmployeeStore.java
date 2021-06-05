package app.domain.store;

import app.controller.App;
import app.domain.model.Employee;
import app.domain.model.SpecialistDoctor;
import app.domain.shared.Constants;
import app.domain.shared.PasswordGenerator;
import app.domain.shared.SendingEmailSMS;
import app.mappers.dto.EmpDto;
import auth.domain.model.UserRole;
import auth.domain.store.UserRoleStore;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import static app.domain.shared.CommonMethods.serializeStore;

public class EmployeeStore {

    private List<Employee> employeeList = new ArrayList<>();

    /**
     * Method that receives information from the associated controller to create a new employee with data received from a dto
     *
     * @param empDto
     * @return the employee created
     */
    public Employee newEmployee(EmpDto empDto) {
        return new Employee(empDto);
    }

    /**
     * Method that receives information from the associated controller to create a new specialistDoctor with data received from a dto
     *
     * @param empDto
     * @return the specialist doctor created
     */
    public SpecialistDoctor newSpecialistDoctor(EmpDto empDto) {
        return new SpecialistDoctor(empDto);
    }

    public void setEmployeeList(List<Employee> employeeList){
        this.employeeList = new ArrayList<>(employeeList);
    }

    public boolean isSpecialistDoctor(String roleId) {
        UserRole userRole = getUserRole(roleId.toUpperCase());
        return userRole.hasId(Constants.ROLE_SPECIALIST_DOCTOR);
    }

    public UserRole getUserRole(String roleId) {
        UserRoleStore roles = App.getInstance().getCompany().getAuthFacade().getUserRoleStore();
        if (roles.getById(roleId).isPresent())
            return roles.getById(roleId).get();
        else
            throw new IllegalArgumentException("Typed role isn't available in the system.");

    }

    /**
     * Method responsible to validate a new employee before it's added to the list when called by the saveParameterCategory method
     *
     * @param emp receives the employee to be added
     * @return if it was successfully added to the store (true or false)
     */
    public boolean validateEmployee(Employee emp) {
        String email = emp.getEmail();
        return !App.getInstance().getCompany().getAuthFacade().existsUser(email) && checkDuplicates(emp);
    }

    /**
     * This method is called by validateEmployee() and is function is to check if the employee that is being added is not already in the system
     *
     * @param emp
     * @return if it already is in the system or not
     */
    private boolean checkDuplicates(Employee emp) {
        for (Employee employee : employeeList) {
            if (emp.equals(employee))
                return false;
        }
        return true;
    }

    /**
     * This method validates the employee received by parameter and adds it to the employee store by calling the method addParameterCategory
     *
     * @param emp employee that will be added
     * @return if it was successfully added to the store (true or false)
     */
    public boolean saveEmployee(Employee emp) {
        if (validateEmployee(emp)) {
            String roleDesc = emp.getRole().getDescription();
            String pwd = PasswordGenerator.generatePassword();
            App.getInstance().getCompany().getAuthFacade().addUserWithRole(emp.getName(), emp.getEmail(), pwd, roleDesc);
            addEmployee(emp);
            SendingEmailSMS.sendEmailWithPassword(emp.getName(), emp.getEmail(), pwd);
            serializeStore(this.employeeList, "data\\employee.dat");
            return true;

        }
        return false;

    }

    /**
     * Method responsible to add a new parameter category to the list when asked by the saveParameterCategory method
     *
     * @param emp receives the Parameter category to be added
     * @return if it was successfully added to the store (true or false)
     */
    private void addEmployee(Employee emp) {
        this.employeeList.add(emp);
    }
}
