package app.domain.model;

import java.util.Objects;

public class SpecialistDoctor extends Employee{

    private int doctorIndexNumber;

    /**
     * Constructor for class SpecialistDoctor.
     *
     * @param doctorIndexNumber
     * @param role
     * @param name
     * @param address
     * @param phoneNumber
     * @param email
     * @param soc
     */
    public SpecialistDoctor(int doctorIndexNumber, OrganizationRole role, String name, String address, int phoneNumber, String email, int soc) {
        super(role, name, address, phoneNumber, email, soc);
        this.doctorIndexNumber = doctorIndexNumber;
    }

    public int getDoctorIndexNumber() {
        return doctorIndexNumber;
    }

    public void setDoctorIndexNumber(int doctorIndexNumber) {
        this.doctorIndexNumber = doctorIndexNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (!(o instanceof SpecialistDoctor)) return false;
        else if(!super.equals(o)) return false;
        SpecialistDoctor that = (SpecialistDoctor) o;
        return getDoctorIndexNumber() == that.getDoctorIndexNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDoctorIndexNumber());
    }
}
