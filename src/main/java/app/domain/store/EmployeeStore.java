package app.domain.store;

import app.domain.model.Employee;
import app.domain.model.SpecialistDoctor;

import java.util.ArrayList;
import java.util.List;

public class EmployeeStore {
    private List<Employee> employeeList = new ArrayList<>();

    /**
     * Method that receives information from the associated controller to create a new employee
     * @param role of the employee
     * @param name of the employee
     * @param address of the employee
     * @param phoneNumber of the employee
     * @param email of the employee
     * @param soc of the employee
     * @return the employee created
     */
    public Employee createEmployee(String role, String name, String address, String phoneNumber, String email, String soc){
        return new Employee(role, name, address, phoneNumber, email, soc);
    }

    /**
     * Method that receives parameters from the associated controller to create a new parameter category
     * @param role of the employee
     * @param name of the employee
     * @param address of the employee
     * @param phoneNumber of the employee
     * @param email of the employee
     * @param soc of the employee
     * @param indexNumber of the employee
     * @return the parameter category created
     */
    public SpecialistDoctor createSpecialistDoctor(String role, String name, String address, String phoneNumber, String email, String soc, int indexNumber){
        return new SpecialistDoctor(role, name, address, phoneNumber, email, soc, indexNumber);
    }

    /**
     * Method responsible to validate a new employee before it's added to the list when called by the saveParameterCategory method
     * @param emp receives the employee to be added
     * @return if it was successfully added to the store (true or false)
     */
    public boolean validateEmployee(Employee emp){
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
        if(emp!=null && validateEmployee(emp))
            return addEmployee(emp);
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
