package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdministratorTest {

    @Test
    public void getAdminID() {
        Administrator administrator = new Administrator( 2, 1,OrganizationRole.Doctor,"Pedro","Porto",911111111,"sfgsdfgsfdg@gmail.com",2);
        int expected = 2;
        assertEquals(expected, administrator.getAdminID());
    }

    @Test
    public void getAdminID1() {
        Employee employee = new Employee(1,OrganizationRole.Doctor,"Pedro","Porto",911111111,"sfgsdfgsfdg@gmail.com",2);
        Administrator oAdministrator = new Administrator(2,employee);
        int expected = 2;
        assertEquals(expected,oAdministrator.getAdminID());
    }

    @Test
    public void setAdminID() {
        Administrator administrator = new Administrator( 2, 1,OrganizationRole.Doctor,"Pedro","Porto",911111111,"sfgsdfgsfdg@gmail.com",2);
        administrator.setAdminID(3);
        int expected = 3;
        assertEquals(expected, administrator.getAdminID());
    }

    @Test
    public void registerAnEmployee() {
        boolean registered = Administrator.registerAnEmployee(1,OrganizationRole.Doctor,"Pedro","Porto",911111111,"sfgsdfgsfdg@gmail.com",2);
        assertTrue(registered);
    }
}