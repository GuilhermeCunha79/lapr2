package app.domain.model;

import app.domain.shared.Constants;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpecialistDoctorTest {

    SpecialistDoctor employee = new SpecialistDoctor(Constants.ROLE_SPECIALIST_DOCTOR, "Pedro", "Porto", "91111111221", "sfgsdfgsfdg@gmail.com", "1234",2);
    SpecialistDoctor employee1 = new SpecialistDoctor(Constants.ROLE_SPECIALIST_DOCTOR, "Miguel", "Lisboa", "91111111221", "sfgsdfgsfdg@gmail.com", "1234",2);

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
    public void testEqualsFalse() {
        assertFalse(employee.equals(employee1));
    }
}