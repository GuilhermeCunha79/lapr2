package app.mappers.dto;

public class EmpDto {
    private String name;
    private String role;
    private String address;
    private String phoneNumber;
    private String email;
    private String soc;
    private String doctorIndexNumber;

    public EmpDto(String role, String name, String address, String phoneNumber, String email, String soc){
        this.role = role;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.soc = soc;
    }

    public EmpDto(String role, String name, String address, String phoneNumber, String email, String soc, String doctorIndexNumber){
        this.role = role;
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

    public String getRole() {
        return role;
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
