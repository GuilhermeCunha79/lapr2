package app.domain.model;

import app.domain.shared.Constants;
import auth.domain.model.User;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 *Employee class
 */
public class Employee {
    private String employeeID;
    private String role;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private int soc;
    List<Employee> employeeList = new ArrayList<>();
    static final int MAX_CHAR_NAME_EMP= 35;
    static final int MAX_CHAR_DOC_INDEX_NUM= 6;
    static final int MAX_CHAR_SOC= 4;
    static final int MAX_ORG_ROLE_CHAR=15;
    static final int MAX_PHONE_NUMBER_CHAR=11;
    static final int MAX_CHAR_ADDRESS = 30;

    private static int employeeCount = 0;
    /**
     * Constructor for class Employee.
     * @param role
     * @param name
     * @param address
     * @param phoneNumber
     * @param email
     * @param soc
     */
    public Employee(String role, String name, String address, String phoneNumber, String email, int soc) {
        employeeCount++;
        setRole(role);
        setName(name);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setSoc(soc);
        this.employeeID = employeeIdCreator();

    }

    /***
     * Method that create the employeeId
     * @return
     */

    private String employeeIdCreator() {
        String nameInitials = "";
        if(this.name!=null){
            for (int i = 0; i < this.name.length(); i++) {
                char letter = this.name.charAt(i);
                if (Character.isUpperCase(letter)){
                    nameInitials += letter;
                }
            }
        }
        return String.format("%s%05d", nameInitials, employeeCount);
    }

    /***
     * Verify if the email given is a valid one
     * @param email
     * @return
     */
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    /***
     * Check if a string just have letters and spaces
     * @param name
     * @return
     */

    public static boolean isValidString(String name){
        for(int i=0;i<name.length();i++){
            char ch = name.charAt(i);
            if (Character.isLetter(ch) || ch == ' ') {
                continue;
            }
            return false;
        }
        return true;
    }

    /***
     * Verify if the given string just have numbers
     * @param number
     * @return
     */
    private boolean checkIfStringJustHaveNumbers(String number) {
        int numberq = 0;
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                numberq++;
            } else {
                return false;
            }
        }
        if (numberq == number.length())
            return true;
        return false;
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
        if(role==null)
            throw new NullPointerException("Role cannot be null.");
        if(StringUtils.isBlank(role))
            throw new IllegalArgumentException("Role cannot be blank");
        if(!(role.equalsIgnoreCase(Constants.ROLE_ADMIN) || role.equalsIgnoreCase(Constants.ROLE_RECEPTIONIST) || role.equalsIgnoreCase(Constants.ROLE_SPECIALIST_DOCTOR)));
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
        if (name == null)
            throw new NullPointerException("Name cannot be null");
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be blank.");
        if (name.length() > MAX_CHAR_NAME_EMP)
            throw new IllegalArgumentException("Name cannot have more than 35 characters");
        if (!(isValidString(name)))
            throw new IllegalArgumentException("Name has non alphanumeric characters.");
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
        if (address == null)
            throw new NullPointerException("Address cannot be null");
        if (address.length() > MAX_CHAR_ADDRESS)
            throw new IllegalArgumentException("Address cannot have more than 35 characters");
        if (StringUtils.isBlank(address))
            throw new IllegalArgumentException("Address cannot be blank");
        for (int i = 0; i < address.length(); i++) {
            String c = String.valueOf(address.charAt(i));
            if (!c.matches("[A-Za-z0-9]"))
                throw new IllegalArgumentException("Address has non alphanumeric chars.");
        }
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
        if (phoneNumber == null)
            throw new NullPointerException("Phone number cannot be null");
        if (StringUtils.isBlank(phoneNumber))
            throw new IllegalArgumentException("Phone number cannot be blank.");
        if (!(checkIfStringJustHaveNumbers(phoneNumber)) || phoneNumber.length() != MAX_PHONE_NUMBER_CHAR)
            throw new IllegalArgumentException("Phone number must have 11 digit numbers.");
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
        if (email == null)
            throw new NullPointerException("Email cannot be null");
        if (StringUtils.isBlank(email))
            throw new IllegalArgumentException("Email cannot be blank.");
        if (!isValidEmail(email))
            throw new IllegalArgumentException("The introduced email is not valid.");
        this.email = email;
    }

    /**
     * Method that returns the soc of the employee
     *
     * @return the employee's soc
     */
    public int getSoc() {
        return soc;
    }

    /**
     * Sets the soc of the employee
     *
     * @param soc
     */
    public void setSoc(int soc) {
        if (soc == 0)
            throw new IllegalArgumentException("SOC cannot be blank.");
        if(soc == MAX_CHAR_SOC)
            throw new IllegalArgumentException("SOC needs to have exactly 4 characters.");
        this.soc = soc;
    }

    /**
     * Validation of instance Employee
     *
     * @return true or false
     */
    public static boolean validateEmployee(Employee employee) {
        return (employee.role != null
                && employee.name != null
                && employee.address != null
                && employee.phoneNumber != null
                && employee.email != null
                && employee.soc > 0);
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
        return getEmployeeID().equals(employee.getEmployeeID()) && getPhoneNumber().equals(employee.getPhoneNumber()) && getSoc() == employee.getSoc() && getRole().equals(employee.getRole()) && getName().equals(employee.getName()) && getAddress().equals(employee.getAddress()) && getEmail().equals(employee.getEmail());
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
