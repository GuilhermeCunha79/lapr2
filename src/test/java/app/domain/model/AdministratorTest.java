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
    public void setAdminID() {
        Administrator administrator = new Administrator( 2, 1,OrganizationRole.Doctor,"Pedro","Porto",911111111,"sfgsdfgsfdg@gmail.com",2);
        administrator.setAdminID(3);
        int expected = 3;
        assertEquals(expected, administrator.getAdminID());
    }

    /*@Test
    public void registerAnEmployee() {
        Administrator.registerAnEmployee(1,OrganizationRole.Doctor,"Pedro","Porto",911111111,"sfgsdfgsfdg@gmail.com",2);

    }*/
}