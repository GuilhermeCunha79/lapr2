package app.domain.model;


import app.mappers.dto.EmpDto;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    @Test(expected = NullPointerException.class)
    public void testSetRoleNull(){
        Employee emp = new Employee(new EmpDto("Receptionist", "James", "street", "91919191919", "james@gmail.com", "1232"));
        emp.setRole(null);
    }

    @Test(expected = NullPointerException.class)
    public void testSetSocNull(){
        Employee emp = new Employee(new EmpDto("Receptionist", "James", "street", "91919191919", "james@gmail.com", "1232"));
        emp.setSoc(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetSocWithMoreThan4Digits(){
        new Employee(new EmpDto("Receptionist", "James", "street", "91919191919", "james@gmail.com", "12312412"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetSocWithLessThan4Digits(){
        new Employee(new EmpDto("Receptionist", "James", "street", "91919191919", "james@gmail.com", "12"));

    }

    @Test
    public void testGetAddress(){
        Employee emp = new Employee(new EmpDto("Receptionist", "James", "street", "91919191919", "james@gmail.com", "1232"));
        String expected = "street";
        assertEquals(expected, emp.getAddress());
    }

}