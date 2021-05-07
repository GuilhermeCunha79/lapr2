package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {
    Employee employee = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", "91111111221", "sfgsdfgsfdg@gmail.com", 2);
    Employee employee1 = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", "91111311221", "sfgsdfgsfdg@gmail.com", 2);
    Employee employeenull = new Employee(null, null, null, "00001", null, 0);

    /**
     * Test of getEmployeeID method, of class Employee.
     */
    @Test
    public void getEmployeeID() {
        String expected = "P00025";
        assertEquals(expected, employee.getEmployeeID());
    }

    /**
     * Test of getRole method, of class Employee.
     */
    @Test
    public void getRole() {

        OrganizationRole expected = OrganizationRole.Doctor;
        assertEquals(expected, employee.getRole());
    }

    /**
     * Test of setRole method, of class Employee.
     */
    @Test
    public void setRole() {
        employee.setRole(OrganizationRole.SpecialistDoctor);
        OrganizationRole expected = OrganizationRole.SpecialistDoctor;
        assertEquals(expected, employee.getRole());
    }

    /**
     * Test of getName method, of class Employee.
     */
    @Test
    public void getName() {
        String expected = "Pedro";
        assertEquals(expected, employee.getName());
    }

    /**
     * Test of setName method, of class Employee.
     */
    @Test
    public void setName() {
        employee.setName("Miguel");
        String expected = "Miguel";
        assertEquals(expected, employee.getName());
    }

    /**
     * Test of getAddress method, of class Employee.
     */
    @Test
    public void getAddress() {
        String expected = "Porto";
        assertEquals(expected, employee.getAddress());
    }

    /**
     * Test of setAddress method, of class Employee.
     */
    @Test
    public void setAddress() {
        employee.setAddress("Lisboa");
        String expected = "Lisboa";
        assertEquals(expected, employee.getAddress());
    }

    /**
     * Test of getPhoneNumber method, of class Employee.
     */
    @Test
    public void getPhoneNumber() {
        long expected = 91111111221L;
        assertEquals(expected, employee.getPhoneNumber());
    }

    /**
     * Test of setPhoneNumber method, of class Employee.
     */
    @Test
    public void setPhoneNumber() {
        employee.setPhoneNumber("91111111221");
        long expected = 91111111221L;
        assertEquals(expected, employee.getPhoneNumber());
    }

    /**
     * Test of getEmail method, of class Employee.
     */
    @Test
    public void getEmail() {
        String expected = "sfgsdfgsfdg@gmail.com";
        assertEquals(expected, employee.getEmail());
    }

    /**
     * Test of setEmail method, of class Employee.
     */
    @Test
    public void setEmail() {
        employee.setEmail("antigoeraoriginal@gmail.com");
        String expected = "antigoeraoriginal@gmail.com";
        assertEquals(expected, employee.getEmail());
    }

    /**
     * Test of getSoc method, of class Employee.
     */
    @Test
    public void getSoc() {
        int expected = 2;
        assertEquals(expected, employee.getSoc());
    }

    /**
     * Test of setSoc method, of class Employee.
     */
    @Test
    public void setSoc() {
        employee.setSoc(3);
        int expected = 3;
        assertEquals(expected, employee.getSoc());
    }

    /**
     * Test of Equals, of class Employee.
     */

    @Test

    public void testEquals() {
        assertEquals(employee, employee1);
    }


    @Test
    public void testHashCode() {
        assertEquals(employee1.hashCode(), employee.hashCode());
    }

    /**
     * Test of Equals, of class Employee.
     */
    @Test
    public void testEqualsFalseRole() {
        employee1.setRole(OrganizationRole.SpecialistDoctor);
        assertNotEquals(employee1, employee);
    }
    /**
     * Test of Equals, of class Employee.
     */
    @Test
    public void testEqualsFalseName() {
        employee1.setName("Miguel");
        assertNotEquals(employee1, employee);
    }

    /**
     * Test of Equals, of class Employee.
     */
    @Test
    public void testEqualsFalseAddress() {
        employee1.setAddress("Lisboa");
        assertNotEquals(employee1, employee);
    }

    /**
     * Test of Equals, of class Employee.
     */
    @Test
    public void testEqualsFalsePhoneNumber() {
        employee1.setPhoneNumber("91111211221");
        assertNotEquals(employee1, employee);
    }

    /**
     * Test of Equals, of class Employee.
     */
    @Test
    public void testEqualsFalseEmail() {
        employee1.setEmail("asda@hotmail.com");
        assertNotEquals(employee1, employee);
    }

    /**
     * Test of Equals, of class Employee.
     */
    @Test
    public void testEqualsFalseSOC() {
        employee1.setSoc(10);
        assertNotEquals(employee1, employee);
    }

    /**
     * Test of validateEmployee, of class Employee.
     */
    @Test
    public void validateEmployee() {
        boolean result = employee.validateEmployee(employee);
        assertTrue(result);
    }

    /**
     * Test of validateEmployee, of class Employee.
     */
    @Test
    public void validateEmployeeError() {
        boolean result = employeenull.validateEmployee(employeenull);
        assertFalse(result);
    }
}