package app.domain.store;

import app.domain.model.Employee;
import app.domain.model.SpecialistDoctor;

import java.util.ArrayList;
import java.util.List;

public class EmployeeStore {
    private List<Employee> employeeList = new ArrayList<>();

    public Employee createEmployee(String role, String name, String address, String phoneNumber, String email, int soc){
        return new Employee(role, name, address, phoneNumber, email, soc);
    }

    public Employee createSpecialistDoctor(String role, String name, String address, String phoneNumber, String email, int soc, int indexNumber){
        return new SpecialistDoctor(role, name, address, phoneNumber, email, soc, indexNumber);
    }

    public boolean validateEmployee(Employee emp){
        for (Employee employee : employeeList){
            if(emp.equals(employee))
                return false;
        }
        return true;
    }

    public boolean saveEmployee(Employee emp){
        if(emp!=null && validateEmployee(emp))
            return addEmployee(emp);
        return false;

    }

    private boolean addEmployee(Employee emp) {
        return this.employeeList.add(emp);
    }

    public List<Employee> getEmployeeList(){
        return new ArrayList<>(employeeList);
    }
}
