package app.domain.model;

import app.domain.shared.Constants;
import app.mappers.dto.EmpDto;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpecialistDoctorTest {

    EmpDto empDto = new EmpDto(Constants.ROLE_RECEPTIONIST, "Pedro", "Porto", "91111111221", "sfgsdfgsfdg@gmail.com", "1234", "123412");
    EmpDto empDto1 = new EmpDto(Constants.ROLE_RECEPTIONIST, "Paulo", "Porto", "91111131221", "sfgsadfsgsfdg@gmail.com", "1274", "123112");


    SpecialistDoctor employee = new SpecialistDoctor(empDto);
    SpecialistDoctor employee1 = new SpecialistDoctor(empDto1);

    @Test
    public void getDoctorIndexNumber() {
        String expected = "123412";
        assertEquals(expected, employee.getDoctorIndexNumber());
    }

    @Test
    public void setDoctorIndexNumber() {
        employee.setDoctorIndexNumber("987654");
        String expected = "987654";
        assertEquals(expected, employee.getDoctorIndexNumber());
    }

    @Test
    public void testEquals() {
        assertTrue(employee.equals(employee));
    }

    @Test
    public void testEqualsIndex() {
        assertEquals(employee.getDoctorIndexNumber(), employee.getDoctorIndexNumber());
    }

    @Test
    public void testEqualsPhoneNumber() {
        assertEquals(employee.getPhoneNumber(), employee.getPhoneNumber());
    }

    @Test
    public void testEqualsEmail() {
        assertEquals(employee.getEmail(), employee.getEmail());
    }

    @Test
    public void testEqualsFalse() {
        assertNotEquals(employee, employee1);
    }

    @Test
    public void testEqualsIndexFalse() {
        assertNotEquals(employee.getDoctorIndexNumber(), employee1.getDoctorIndexNumber());
    }

    @Test
    public void testEqualsPhoneNumberFalse() {
        assertNotEquals(employee.getPhoneNumber(), employee1.getPhoneNumber());
    }

    @Test
    public void testEqualsEmailFalse() {
        assertNotEquals(employee.getEmail(), employee1.getEmail());
    }
}