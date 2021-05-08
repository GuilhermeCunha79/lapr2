package app.controller;

import app.domain.model.Employee;
import app.domain.model.SpecialistDoctor;
import app.domain.shared.Constants;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegisterEmployeeControllerTest {
    RegisterEmployeeController controller = new RegisterEmployeeController();

    Employee employee = new Employee(Constants.ROLE_RECEPTIONIST, "Pedro", "Porto", "91111111221", "sfgsdfgsfdg@gmail.com", 1234);


    @Test
    public void isSpecialistDoctor() {
        SpecialistDoctor specialistDoctor = new SpecialistDoctor(Constants.ROLE_SPECIALIST_DOCTOR, "Pedro", "Porto", "91111111221", "sfgsdfgsfdg@gmail.com", 1234,2);
        boolean expected = controller.isSpecialistDoctor(specialistDoctor.getRole());
        assertTrue(expected);
    }

    @Test
    public void createEmployee() {
        boolean expected = controller.createEmployee(Constants.ROLE_RECEPTIONIST, "Pedro", "Porto", "91111111221", "sfgsdfgsfdg@gmail.com", 1234);
        assertTrue(expected);
    }

    @Test
    public void createSpecialistDoctor() {
        boolean expected = controller.createSpecialistDoctor(Constants.ROLE_SPECIALIST_DOCTOR, "Pedro", "Porto", "91111111221", "sfgsdfgsfdg@gmail.com", 1234,2);
        assertTrue(expected);
    }

}