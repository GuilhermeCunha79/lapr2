package app.domain.model;

import app.mappers.dto.EmpDto;
import auth.domain.model.UserRole;
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

    @Test(expected = IllegalArgumentException.class)
    public void testSetAddressWithMoreThan30Chars(){
        new Employee(new EmpDto("Receptionist", "James", "dsafsvasdvadsfasdfadsvasdfasdfsvdv", "91919191919", "james@gmail.com", "12312412"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetAddressWithNonAlphanumericChars(){
        new Employee(new EmpDto("Receptionist", "James", "s@£treet", "91919191919", "james@gmail.com", "12"));

    }

    @Test
    public void testGetPhoneNumber(){
        Employee emp = new Employee(new EmpDto("Receptionist", "James", "street", "91919191919", "james@gmail.com", "1232"));
        String expected = "91919191919";
        assertEquals(expected, emp.getPhoneNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPhoneNumberWithMoreThan11Digits(){
        new Employee(new EmpDto("Receptionist", "James", "dsafsvasdvadsfasdfadsvasdfasdfsvdv", "91919191911219", "james@gmail.com", "12312412"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPhoneNumberWithLessThan11Digits(){
        new Employee(new EmpDto("Receptionist", "James", "dsafsvasdvadsfasdfadsvasdfasdfsvdv", "91911219", "james@gmail.com", "12312412"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPhoneNumberWithNonNumericChars(){
        new Employee(new EmpDto("Receptionist", "James", "s@£treet", "12asf121212", "james@gmail.com", "12"));

    }

    @Test
    public void testGetName(){
        Employee emp = new Employee(new EmpDto("Receptionist", "James", "street", "91919191919", "james@gmail.com", "1232"));
        emp.setRole(new UserRole("RECEPTIONIST", "RECEPTIONIST"));
        String expected = "James";
        assertEquals(expected, emp.getName());
    }

}