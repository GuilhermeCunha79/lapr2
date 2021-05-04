package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    /**
     * Test of getEmployeeID method, of class Employee.
     */
    Employee employee = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);

    //@Test
   // public void getEmployeeID() {
        //String expected = "P00022";
       // assertEquals(expected, employee.getEmployeeID());
    //}

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
        int expected = 911111111;
        assertEquals(expected, employee.getPhoneNumber());
    }

    /**
     * Test of setPhoneNumber method, of class Employee.
     */
    @Test
    public void setPhoneNumber() {
        employee.setPhoneNumber(921111111);
        int expected = 921111111;
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
    /*
    @Test

    public void testEquals() {
        Employee e1 = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        Employee e2 = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        assertEquals(e2, e1);
    }


    @Test
    public void testHashCode() {
        Employee e1 = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        Employee e2 = new Employee(OrganizationRole.Doctor, "Pedro", "Porto", 911111111, "sfgsdfgsfdg@gmail.com", 2);
        assertEquals(e2.hashCode(), e1.hashCode());
    }
    */

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

    /**
     * Test of validateEmployee, of class Employee.
     */
    @Test
    public void validateEmployee() {
        Employee e1 = new Employee(OrganizationRole.Doctor,"Pedro","Porto",911111111,"sfgsdfgsfdg@gmail.com",2);
        boolean result = Employee.validateEmployee(e1);
        assertTrue(result);

    }

    /**
     * Test of validateEmployee, of class Employee.
     */
    @Test
    public void validateEmployeeError() {
        Employee e1 = new Employee(null, null, null, 00001, null, 0);
        boolean result = Employee.validateEmployee(e1);
        assertFalse(result);
    }
}