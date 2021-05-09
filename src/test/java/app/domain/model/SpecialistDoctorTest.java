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
        assertTrue(employee.getDoctorIndexNumber()==employee.getDoctorIndexNumber());
    }

    @Test
    public void testEqualsPhoneNumber() {
        assertTrue(employee.getPhoneNumber().equals(employee.getPhoneNumber()));
    }

    @Test
    public void testEqualsEmail() {
        assertTrue(employee.getEmail().equals(employee.getEmail()));
    }

    @Test
    public void testEqualsFalse() {
        assertFalse(employee.equals(employee1));
    }

    @Test
    public void testEqualsIndexFalse() {
        assertFalse(employee.getDoctorIndexNumber()==employee1.getDoctorIndexNumber());
    }

    @Test
    public void testEqualsPhoneNumberFalse() {
        assertFalse(employee.getPhoneNumber().equals(employee1.getPhoneNumber()));
    }

    @Test
    public void testEqualsEmailFalse() {
        assertFalse(employee.getEmail().equals(employee1.getEmail()));
    }
}