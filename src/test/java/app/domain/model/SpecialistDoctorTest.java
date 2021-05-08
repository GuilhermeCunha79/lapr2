package app.domain.model;

import app.domain.shared.Constants;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpecialistDoctorTest {

    @Test
    public void getDoctorIndexNumber() {
        SpecialistDoctor specialistDoctor = new SpecialistDoctor( 2, Constants.ROLE_SPECIALIST_DOCTOR,"Pedro","Porto","91111111111","sfgsdfgsfdg@gmail.com",2);
        int expected = 2;
        assertEquals(expected, specialistDoctor.getDoctorIndexNumber());
    }

    @Test
    public void setDoctorIndexNumber() {
        SpecialistDoctor specialistDoctor = new SpecialistDoctor( 2,Constants.ROLE_SPECIALIST_DOCTOR,"Pedro","Porto","91111111111","sfgsdfgsfdg@gmail.com",2);
        specialistDoctor.setDoctorIndexNumber(3);
        int expected = 3;
        assertEquals(expected, specialistDoctor.getDoctorIndexNumber());
    }

    /*
    @Test
    public void testEquals() {
        SpecialistDoctor sd1 = new SpecialistDoctor( 2,OrganizationRole.SpecialistDoctor,"Pedro","Porto",911111111,"sfgsdfgsfdg@gmail.com",2);
        SpecialistDoctor sd2 = new SpecialistDoctor( 2,OrganizationRole.SpecialistDoctor,"Pedro","Porto",911111111,"sfgsdfgsfdg@gmail.com",2);
        assertEquals(sd2, sd1);
    }

    @Test
    public void testHashCode() {
        SpecialistDoctor sd1 = new SpecialistDoctor( 2,OrganizationRole.SpecialistDoctor,"Pedro","Porto",911111111,"sfgsdfgsfdg@gmail.com",2);
        SpecialistDoctor sd2 = new SpecialistDoctor( 2,OrganizationRole.SpecialistDoctor,"Pedro","Porto",911111111,"sfgsdfgsfdg@gmail.com",2);
        assertEquals(sd2.hashCode(), sd1.hashCode());
    }*/
}