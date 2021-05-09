package app.domain.store;

import app.domain.model.Employee;
import app.domain.model.SpecialistDoctor;
import app.domain.shared.Constants;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeStoreTest {
    EmployeeStore employeeStore = new EmployeeStore();
    Employee employee = employeeStore.createEmployee(Constants.ROLE_RECEPTIONIST, "Pedro", "Porto", "91111111221", "sfgsdfgsfdg@gmail.com", "1234");
    Employee employee1 = employeeStore.createEmployee(Constants.ROLE_RECEPTIONIST, "Zé", "Lisboa", "91111111221", "sfgsdfgsfdg@gmail.com", "1234");

    @Test
    public void createSpecialistDoctor() {
        SpecialistDoctor specialistDoctor = employeeStore.createSpecialistDoctor(Constants.ROLE_SPECIALIST_DOCTOR, "Miguel", "Lisboa", "91111111221", "sfgsdfgsfdg@gmail.com", "1234",2);
        assertNotNull(specialistDoctor);
    }

    @Test
    public void validateEmployee() {
        employeeStore.validateEmployee(employee);
    }

    @Test
    public void validateEmployeeError() {
        employeeStore.saveEmployee(employee);
        assertFalse(employeeStore.validateEmployee(employee));
    }

    @Test
    public void saveEmployee() {
        assertTrue(employeeStore.saveEmployee(employee));
    }

    @Test
    public void saveEmployeeError() {
        assertFalse(employeeStore.saveEmployee(null));
    }

    @Test
    public void getEmployeeList() {
        employeeStore.saveEmployee(employee);
        employeeStore.saveEmployee(employee1);
        List<Employee> list = employeeStore.getEmployeeList();
        assertTrue(list.contains(employee) && list.contains(employee1));
    }
}