package app.domain.model;


import app.mappers.dto.EmpDto;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpecialistDoctorTest {

    @Test(expected = NullPointerException.class)
    public void testSetDoctorIndexNumberNull(){
        new SpecialistDoctor(new EmpDto("Specialist doctor", "James", "street", "91919191919", "james@gmail.com", "1232", null));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testSetDINWithMoreThan6Digits(){
        new SpecialistDoctor(new EmpDto("Specialist doctor", "James", "street", "91919191919", "james@gmail.com", "1231", "12314124"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDINWithLessThan6Digits(){
        new SpecialistDoctor(new EmpDto("Specialist doctor", "James", "street", "91919191919", "james@gmail.com", "1212", "12"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDINWithNonAlphaNumeric(){
        new SpecialistDoctor(new EmpDto("Specialist doctor", "James", "street", "91919191919", "james@gmail.com", "1212", "@@@@£@"));
    }

    @Test
    public void testGetDoctorIndexNumber(){
        SpecialistDoctor sd = new SpecialistDoctor(new EmpDto("Specialist doctor", "James", "street", "91919191919", "james@gmail.com", "1232", "123123"));
        String expected = "123123";
        assertEquals(expected, sd.getDoctorIndexNumber());
    }

    @Test
    public void ifSameSDAreEquals(){
        SpecialistDoctor sd = new SpecialistDoctor(new EmpDto("Specialist doctor", "James", "street", "91919191919", "james@gmail.com", "1232", "123123"));
        assertEquals(sd, sd);
    }

    @Test
    public void ifSDisDifferentThanAString(){
        SpecialistDoctor sd = new SpecialistDoctor(new EmpDto("Specialist doctor", "James", "street", "91919191919", "james@gmail.com", "1232", "123123"));
        assertNotEquals("hi", sd);
    }

    @Test
    public void ifSDWithSamePhoneNumberAreNotAllowed(){
        SpecialistDoctor sd = new SpecialistDoctor(new EmpDto("Specialist doctor", "James", "street", "91919191919", "james@gmail.com", "1232", "123123"));
        SpecialistDoctor sd1 = new SpecialistDoctor(new EmpDto("Specialist doctor", "John", "street12", "91919191919", "john@gmail.com", "4322", "234323"));
        assertTrue(sd.equals(sd1));
    }

    @Test
    public void ifSDWithSameEmailAreNotAllowed(){
        SpecialistDoctor sd = new SpecialistDoctor(new EmpDto("Specialist doctor", "James", "street", "91919191919", "james@gmail.com", "1232", "123123"));
        SpecialistDoctor sd1 = new SpecialistDoctor(new EmpDto("Specialist doctor", "John", "street12", "91913391919", "james@gmail.com", "4322", "234323"));
        assertTrue(sd.equals(sd1));
    }

    @Test
    public void ifSDWithSameSocAreNotAllowed(){
        SpecialistDoctor sd = new SpecialistDoctor(new EmpDto("Specialist doctor", "James", "street", "91919191919", "james@gmail.com", "4322", "123123"));
        SpecialistDoctor sd1 = new SpecialistDoctor(new EmpDto("Specialist doctor", "John", "street12", "91919191919", "john@gmail.com", "4322", "234323"));
        assertTrue(sd.equals(sd1));
    }

}