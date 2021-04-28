package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void getEmployeeID() {
        Employee employee = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        int expected = 1;
        assertEquals(expected, employee.getEmployeeID());
    }

    @Test
    public void getRole() {
        Employee employee = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        int expected = 1;
        assertEquals(expected, employee.getEmployeeID());
    }

    @Test
    public void setRole() {
        Employee employee = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        employee.setRole(OrganizationRole.SpecialistDoctor);
        OrganizationRole expected = OrganizationRole.SpecialistDoctor;
        assertEquals(expected, employee.getRole());
    }

    @Test
    public void getName() {
        Employee employee = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        String expected = "Pedro";
        assertEquals(expected, employee.getName());
    }

    @Test
    public void setName() {
        Employee employee = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        employee.setName("Miguel");
        String expected = "Miguel";
        assertEquals(expected, employee.getName());
    }

    @Test
    public void getAddress() {
        Employee employee = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        String expected = "Porto";
        assertEquals(expected, employee.getAddress());
    }

    @Test
    public void setAddress() {
        Employee employee = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        employee.setAddress("Lisboa");
        String expected = "Lisboa";
        assertEquals(expected, employee.getAddress());
    }

    @Test
    public void getPhoneNumber() {
        Employee employee = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        int expected = 911111111;
        assertEquals(expected, employee.getPhoneNumber());
    }

    @Test
    public void setPhoneNumber() {
        Employee employee = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        employee.setPhoneNumber(921111111);
        int expected = 921111111;
        assertEquals(expected, employee.getPhoneNumber());
    }

    @Test
    public void getEmail() {
        Employee employee = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        String expected = "sfgsdfgsfdg@gmail.com";
        assertEquals(expected, employee.getEmail());
    }

    @Test
    public void setEmail() {
        Employee employee = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        employee.setEmail("antigoeraoriginal@gmail.com");
        String expected = "antigoeraoriginal@gmail.com";
        assertEquals(expected, employee.getEmail());
    }

    @Test
    public void getSoc() {
        Employee employee = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        int expected = 2;
        assertEquals(expected, employee.getSoc());
    }

    @Test
    public void setSoc() {
        Employee employee = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        employee.setSoc(3);
        int expected = 3;
        assertEquals(expected, employee.getSoc());
    }

    /**
     * Test of Equals, of class Employee.
     */
    @Test
    public void testEquals() {
        Employee e1 = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        Employee e2 = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        assertEquals(e2, e1);
    }

    /**
     * Test of Hash code method, of class Employee.
     */
    @Test
    public void testHashCode() {
        Employee e1 = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        Employee e2 = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        assertEquals(e2.hashCode(), e1.hashCode());
    }

    /**
     * Test of Equals, of class Employee.
     */
    @Test
    public void testEqualsFalseID() {
        Employee e1 = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        Employee e2 = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        assertNotEquals(e2, e1);
    }

    /**
     * Test of Equals, of class Employee.
     */
    @Test
    public void testEqualsFalseRole() {
        Employee e1 = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        Employee e2 = new Employee(OrganizationRole.SpecialistDoctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        assertNotEquals(e2, e1);
    }

    /**
     * Test of Equals, of class Employee.
     */
    @Test
    public void testEqualsFalseName() {
        Employee e1 = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        Employee e2 = new Employee(OrganizationRole.Doctor, "Miguel", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        assertNotEquals(e2, e1);
    }

    /**
     * Test of Equals, of class Employee.
     */
    @Test
    public void testEqualsFalseAddress() {
        Employee e1 = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        Employee e2 = new Employee(OrganizationRole.Doctor, "Pedro", "Lisboa", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        assertNotEquals(e2, e1);
    }

    /**
     * Test of Equals, of class Employee.
     */
    @Test
    public void testEqualsFalsePhoneNumber() {
        Employee e1 = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        Employee e2 = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911122211, "sfgsdfgsfdg@gmail.com", 2);
        assertNotEquals(e2, e1);
    }

    /**
     * Test of Equals, of class Employee.
     */
    @Test
    public void testEqualsFalseEmail() {
        Employee e1 = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        Employee e2 = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "aaaaaagsfdg@gmail.com", 2);
        assertNotEquals(e2, e1);
    }

    /**
     * Test of Equals, of class Employee.
     */
    @Test
    public void testEqualsFalseSOC() {
        Employee e1 = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        Employee e2 = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 3);
        assertNotEquals(e2, e1);
    }

    @Test
    public void validateEmployee() {
        Employee e1 = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        boolean result = Employee.validateEmployee(e1);
        assertTrue(result);

    }

    @Test
    public void validateEmployeeError() {
        Employee e1 = new Employee(null, null, null, 00001, null, 0);
        boolean result = Employee.validateEmployee(e1);
        assertFalse(result);
    }
}