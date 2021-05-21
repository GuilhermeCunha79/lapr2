package app.domain.model;

import app.domain.shared.CommonMethods;
import app.domain.shared.Constants;
import app.mappers.dto.EmpDto;
import auth.domain.model.UserRole;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;


/**
 * Employee class
 */
public class Employee {
    static final String STRING_ROLE = "Role";
    static final String STRING_SOC = "SOC Number";
    static final int MAX_CHAR_SOC = 4;

    private static int employeeCount = 0;
    private final String employeeID;
    private String role;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String soc;

    /**
     * Constructor for class Employee using a data transfer object.
     *
     * @param empDto
     */
    public Employee(EmpDto empDto) {
        employeeCount++;
        setRole(empDto.getRole());
        setName(empDto.getName());
        setAddress(empDto.getAddress());
        setPhoneNumber(empDto.getPhoneNumber());
        setEmail(empDto.getEmail());
        setSoc(empDto.getSoc());
        this.employeeID = employeeIdCreator();
    }

    /***
     * Method that create the employeeId
     * @return
     */

    private String employeeIdCreator() {
        StringBuilder nameInitials = new StringBuilder();
        if (this.name != null) {
            for (int i = 0; i < this.name.length(); i++) {
                char letter = this.name.charAt(i);
                if (Character.isUpperCase(letter)) {
                    nameInitials.append(letter);
                }
            }
        }
        return String.format("%s%05d", nameInitials, employeeCount);
    }


    /**
     * Method that returns the id of the employee
     *
     * @return the employee's id
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * Method that returns the role of the employee
     *
     * @return the employee's role
     */
    public String getRole() {
        return role;
    }

    /**
     * Method that sets the role of the employee
     *
     * @param role
     */
    public void setRole(String role) {
        if (role == null)
            throw new NullPointerException(STRING_ROLE + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(role))
            throw new IllegalArgumentException(STRING_ROLE + Constants.STRING_BLANK_EXEPT);
        if (!(role.equalsIgnoreCase(Constants.ROLE_ADMIN) || role.equalsIgnoreCase(Constants.ROLE_RECEPTIONIST) || role.equalsIgnoreCase(Constants.ROLE_SPECIALIST_DOCTOR)))
            throw new IllegalArgumentException("The inserted" + STRING_ROLE  + "it's not valid");
        this.role = role;
    }

    /**
     * Method that returns the address of the employee
     *
     * @return the employee's address
     */
    public String getName() {
        return name;
    }

    /**
     * Method that sets the name of the employee
     *
     * @param name
     */
    public void setName(String name) {
        CommonMethods.nameClientEmployeeValidation(name);
        this.name = name;
    }

    /**
     * Method that returns the address of the employee
     *
     * @return the employee's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Method that sets the address of the employee
     *
     * @param address
     */
    public void setAddress(String address) {
        CommonMethods.addressValidation(address);
        this.address = address;
    }

    /**
     * Method that returns the phone number of the employee
     *
     * @return the employee's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Method that sets the phone number of the employee
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        CommonMethods.phoneValidation(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    /**
     * Method that returns the email of the employee
     *
     * @return the employee's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method that sets the email of the employee
     *
     * @param email
     */
    public void setEmail(String email) {
        CommonMethods.isValidEmail(email);
        this.email = email;
    }

    /**
     * Method that returns the soc of the employee
     *
     * @return the employee's soc
     */
    public String getSoc() {
        return soc;
    }

    /**
     * Sets the soc of the employee
     *
     * @param soc
     */
    public void setSoc(String soc) {
        if (soc == null)
            throw new NullPointerException(STRING_SOC + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(soc))
            throw new NullPointerException(STRING_SOC + Constants.STRING_BLANK_EXEPT);
        if (soc.length() != MAX_CHAR_SOC)
            throw new IllegalArgumentException("SOC needs to have exactly 4 characters.");
        this.soc = soc;
    }

    /**
     * Method that compares a object with the selected employee
     *
     * @param o
     * @return true if the object equals, false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getEmployeeID().equals(employee.getEmployeeID()) && getPhoneNumber().equals(employee.getPhoneNumber()) && getSoc().equals(employee.getSoc()) && getRole().equals(employee.getRole()) && getName().equals(employee.getName()) && getAddress().equals(employee.getAddress()) && getEmail().equals(employee.getEmail());
    }

    /**
     * Method that returns the hash code
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeID(), getRole(), getName(), getAddress(), getPhoneNumber(), getEmail(), getSoc());
    }
}
