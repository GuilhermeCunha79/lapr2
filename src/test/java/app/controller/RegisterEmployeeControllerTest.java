package app.controller;

import app.domain.model.Employee;
import app.domain.model.OrganizationRole;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegisterEmployeeControllerTest {

    /**
     * Test of newEmployee method, of class RegisterEmployeeController.
     */
    @Test
    public void newEmployee() {
        RegisterEmployeeController employeeController = new RegisterEmployeeController();
        assertTrue(employeeController.newEmployee(OrganizationRole.Doctor, "Pedro", "Porto", "91111111221", "sfgsdfgsfdg@gmail.com", 2));
    }
}