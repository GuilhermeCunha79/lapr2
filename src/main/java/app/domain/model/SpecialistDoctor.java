package app.domain.model;

public class SpecialistDoctor extends Employee {

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
    public SpecialistDoctor(String role, String name, String address, String phoneNumber, String email, String soc, int doctorIndexNumber) {
        super(role, name, address, phoneNumber, email, soc);
        this.doctorIndexNumber = doctorIndexNumber;
    }

    /**
     * Returns the Specialist doctor index number
     * @return an integer with the doctor index number
     */
    public int getDoctorIndexNumber() {
        return doctorIndexNumber;
    }

    /**
     * Allows making a change to the Specialist Doctor index number
     * @param doctorIndexNumber new index number to be assigned to the Doctor
     */
    public void setDoctorIndexNumber(int doctorIndexNumber) {
        this.doctorIndexNumber = doctorIndexNumber;
    }

    /**
     * Compares if one object is the same as the specialist doctor instance that called the method
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (!(o instanceof SpecialistDoctor)) return false;
        else if (!super.equals(o)) return false;
        SpecialistDoctor specDoc = (SpecialistDoctor) o;
        return getDoctorIndexNumber() == specDoc.getDoctorIndexNumber()
                || super.getPhoneNumber().equals(specDoc.getPhoneNumber())
                || super.getEmail().equals(specDoc.getEmail());
    }
}
