package app.mappers.dto;

public class EmpDto {
    private final String name;
    private final String roleId;
    private final String address;
    private final String phoneNumber;
    private final String email;
    private final String soc;
    private String doctorIndexNumber;

    public EmpDto(String roleId, String name, String address, String phoneNumber, String email, String soc) {
        this.roleId = roleId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.soc = soc;
    }

    public EmpDto(String roleId, String name, String address, String phoneNumber, String email, String soc, String doctorIndexNumber) {
        this.roleId = roleId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.soc = soc;
        this.doctorIndexNumber = doctorIndexNumber;
    }

    public String getName() {
        return name;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getSoc() {
        return soc;
    }

    public String getDoctorIndexNumber() {
        return doctorIndexNumber;
    }
}
