package app.domain.model;


import app.mappers.dto.EmpDto;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class SpecialistDoctorTest {

    @Test(expected = NullPointerException.class)
    public void testSetDoctorIndexNumberNull(){
        new SpecialistDoctor(new EmpDto("Receptionist", "James", "street", "91919191919", "james@gmail.com", "1232", null));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testSetDINWithMoreThan6Digits(){
        new SpecialistDoctor(new EmpDto("Receptionist", "James", "street", "91919191919", "james@gmail.com", "1231", "12314124"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDINWithLessThan6Digits(){
        new SpecialistDoctor(new EmpDto("Receptionist", "James", "street", "91919191919", "james@gmail.com", "1212", "12"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDINWithNonAlphaNumeric(){
        new SpecialistDoctor(new EmpDto("Receptionist", "James", "street", "91919191919", "james@gmail.com", "1212", "@@@@£@"));
    }

    @Test
    public void testGetDoctorIndexNumber(){
        SpecialistDoctor sd = new SpecialistDoctor(new EmpDto("Receptionist", "James", "street", "91919191919", "james@gmail.com", "1232", "123123"));
        String expected = "123123";
        assertEquals(expected, sd.getDoctorIndexNumber());
    }

}