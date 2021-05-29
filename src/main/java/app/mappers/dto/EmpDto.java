package app.mappers.dto;

public class EmpDto {

    private final String name;
    private final String roleId;
    private final String address;
    private final String phoneNumber;
    private final String email;
    private final String soc;
    private String doctorIndexNumber;

    /**
     * Dto constructor for an employee
     * @param roleId
     * @param name
     * @param address
     * @param phoneNumber
     * @param email
     * @param soc
     */
    public EmpDto(String roleId, String name, String address, String phoneNumber, String email, String soc) {
        this.roleId = roleId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.soc = soc;
    }

    /**
     * Dto constructor for a specialist doctor
     * @param roleId
     * @param name
     * @param address
     * @param phoneNumber
     * @param email
     * @param soc
     * @param doctorIndexNumber
     */
    public EmpDto(String roleId, String name, String address, String phoneNumber, String email, String soc, String doctorIndexNumber) {
        this.roleId = roleId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.soc = soc;
        this.doctorIndexNumber = doctorIndexNumber;
    }

    /**
     * get method for the employee name
     * @return employee name
     */
    public String getName() {
        return name;
    }

    /**
     * get method for the employee roleId
     * @return employee role ID
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * get method for the employee address
     * @return employee address
     */
    public String getAddress() {
        return address;
    }

    /**
     * get method for the employee phone number
     * @return employee phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * get method for the employee email address
     * @return employee email
     */
    public String getEmail() {
        return email;
    }

    /**
     * get method for the employee soc
     * @return employee soc
     */
    public String getSoc() {
        return soc;
    }

    /**
     * get method for the specialist doctor's doctor index number
     * @return specialist doctor's doctor index number
     */
    public String getDoctorIndexNumber() {
        return doctorIndexNumber;
    }
}
