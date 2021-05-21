package app.domain.store;

import app.domain.model.Employee;
import app.domain.model.SpecialistDoctor;
import app.domain.shared.Constants;
import app.mappers.dto.EmpDto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeStoreTest {
    EmployeeStore employeeStore = new EmployeeStore();

    EmpDto empDto = new EmpDto("receptionist", "Pedro", "Porto", "91111111221", "sfgsdfgsfdg@gmail.com", "1234");
    EmpDto sdDto = new EmpDto("receptionist", "Pedro", "Porto", "91111111221", "sfgsdfgsfdg@gmail.com", "1234", "123123");


    Employee employee = employeeStore.createEmployee(empDto);
    Employee employee1 = employeeStore.createEmployee(empDto);

    @Test
    public void createSpecialistDoctor() {
        SpecialistDoctor specialistDoctor = employeeStore.createSpecialistDoctor(sdDto);
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
}