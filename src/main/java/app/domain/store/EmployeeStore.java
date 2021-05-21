package app.domain.store;

import app.controller.App;
import app.domain.model.Employee;
import app.domain.model.SpecialistDoctor;
import app.mappers.dto.EmpDto;

import java.util.ArrayList;
import java.util.List;

public class EmployeeStore {
    private List<Employee> employeeList = new ArrayList<>();

    /**
     * Method that receives information from the associated controller to create a new employee with data received from a dto
     * @param empDto
     * @return the employee created
     */
    public Employee createEmployee(EmpDto empDto){
        return new Employee(empDto);
    }

    /**
     * Method that receives parameters from the associated controller to create a new Specialist Doctor with data received from a DTO
     * @param empDto
     * @return the parameter category created
     */
    public SpecialistDoctor createSpecialistDoctor(EmpDto empDto){
        return new SpecialistDoctor(empDto);
    }

    /**
     * Method responsible to validate a new employee before it's added to the list when called by the saveParameterCategory method
     * @param emp receives the employee to be added
     * @return if it was successfully added to the store (true or false)
     */
    public boolean validateEmployee(Employee emp){
        String email = emp.getEmail();
        return !App.getInstance().getCompany().getAuthFacade().existsUser(email) && !checkDuplicates(emp);
    }

    /**
     * This method is called by validateEmployee() and is function is to check if the employee that is being added is not already in the system
     * @param emp
     * @return if it already is in the system or not
     */
    private boolean checkDuplicates(Employee emp){
        for (Employee employee : employeeList){
            if(emp.equals(employee))
                return false;
        }
        return true;
    }

    /**
     * This method validates the employee received by parameter and adds it to the employee store by calling the method addParameterCategory
     * @param emp employee that will be added
     * @return if it was successfully added to the store (true or false)
     */
    public boolean saveEmployee(Employee emp){
        if(validateEmployee(emp)) {
            String name = emp.getName();
            String role = emp.getRole();

            return addEmployee(emp);
        }
        return false;

    }

    /**
     * Method responsible to add a new parameter category to the list when asked by the saveParameterCategory method
     * @param emp receives the Parameter category to be added
     * @return if it was successfully added to the store (true or false)
     */
    private boolean addEmployee(Employee emp) {
        return this.employeeList.add(emp);
    }

    /**
     * This method return a copy of the employee List for other classes that need to access it
     * @return List of employee
     */
    public List<Employee> getEmployeeList(){
        return new ArrayList<>(employeeList);
    }
}
