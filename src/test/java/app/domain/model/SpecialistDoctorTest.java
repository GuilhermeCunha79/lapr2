package app.domain.model;

import app.domain.shared.Constants;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpecialistDoctorTest {

    SpecialistDoctor employee = new SpecialistDoctor(Constants.ROLE_SPECIALIST_DOCTOR, "Pedro", "Porto", "91111111221", "sfgsdfgsfdg@gmail.com", "1234",2);
    SpecialistDoctor employee1 = new SpecialistDoctor(Constants.ROLE_SPECIALIST_DOCTOR, "Miguel", "Lisboa", "91131111221", "sfgsgsfdg@gmail.com", "4414",3);

    @Test
    public void getDoctorIndexNumber() {
        int expected = 2;
        assertEquals(expected, employee.getDoctorIndexNumber());
    }

    @Test
    public void setDoctorIndexNumber() {
        employee.setDoctorIndexNumber(3);
        int expected = 3;
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