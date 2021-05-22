package app.domain.model;

import app.domain.shared.CommonMethods;
import app.domain.shared.Constants;
import app.mappers.dto.EmpDto;
import org.apache.commons.lang3.StringUtils;

public class SpecialistDoctor extends Employee {

    private String doctorIndexNumber;

    /**
     * Constructor for class SpecialistDoctor using a data transfer object.
     *
     * @param empDto
     */
    public SpecialistDoctor(EmpDto empDto) {
        super(empDto);
        setDoctorIndexNumber(empDto.getDoctorIndexNumber());
    }

    /**
     * Returns the Specialist doctor index number
     *
     * @return an integer with the doctor index number
     */
    public String getDoctorIndexNumber() {
        return doctorIndexNumber;
    }

    /**
     * Allows making a change to the Specialist Doctor index number
     *
     * @param doctorIndexNumber new index number to be assigned to the Doctor
     */
    public void setDoctorIndexNumber(String doctorIndexNumber) {
        if (doctorIndexNumber == null)
            throw new NullPointerException(Constants.STRING_DOC_INDEX_NUMB + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(doctorIndexNumber))
            throw new IllegalArgumentException(Constants.STRING_DOC_INDEX_NUMB + Constants.STRING_BLANK_EXEPT);
        if (!CommonMethods.stringHaveAlphanumerical(doctorIndexNumber))
            throw new IllegalArgumentException(Constants.STRING_DOC_INDEX_NUMB + Constants.NON_ALPHANUM_EXEPT);
        if (doctorIndexNumber.length() != 6)
            throw new IllegalArgumentException("Doctor index number needs to have exactly 6 digits");
        this.doctorIndexNumber = doctorIndexNumber;
    }

    /**
     * Compares if one object is the same as the specialist doctor instance that called the method
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (!(o instanceof SpecialistDoctor)) return false;
        else if (!super.equals(o)) return false;
        SpecialistDoctor specDoc = (SpecialistDoctor) o;
        return getDoctorIndexNumber().equals(specDoc.getDoctorIndexNumber())
                || super.getPhoneNumber().equals(specDoc.getPhoneNumber())
                || super.getEmail().equals(specDoc.getEmail())
                || super.getSoc().equals(specDoc.getSoc());
    }
}
