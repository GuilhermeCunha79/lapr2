package app.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *Employee class
 */
public class Employee {
    private int employeeID;
    private OrganizationRole role;
    private String name;
    private String address;
    private int phoneNumber;
    private String email;
    private int soc;
    List<Employee> employeeList = new ArrayList<>();

    /**
     * Constructor for class Employee.
     * @param employeeID
     * @param role
     * @param name
     * @param address
     * @param phoneNumber
     * @param email
     * @param soc
     */
    public Employee(int employeeID, OrganizationRole role, String name, String address, int phoneNumber, String email, int soc) {
        this.employeeID = employeeID;
        this.role = role;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.soc = soc;
    }

    /**
     * Method that returns the id of the employee
     *
     * @return the employee's id
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * Method that sets the id of the employee
     *
     * @param employeeID
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Method that returns the role of the employee
     *
     * @return the employee's role
     */
    public OrganizationRole getRole() {
        return role;
    }

    /**
     * Method that sets the role of the employee
     *
     * @param role
     */
    public void setRole(OrganizationRole role) {
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
        this.address = address;
    }

    /**
     * Method that returns the phone number of the employee
     *
     * @return the employee's phone number
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Method that sets the phone number of the employee
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(int phoneNumber) {
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
        this.soc = soc;
    }

    /**
     * Validation of instance Employee
     *
     * @return true or false
     */
    public static boolean validateEmployee(Employee employee) {
        return (employee.employeeID > 0
                && employee.role != null
                && employee.name != null
                && employee.address != null
                && employee.phoneNumber > 000000000
                && employee.phoneNumber <= 999999999
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
        return getEmployeeID() == employee.getEmployeeID() && getPhoneNumber() == employee.getPhoneNumber() && getSoc() == employee.getSoc() && getRole() == employee.getRole() && getName().equals(employee.getName()) && getAddress().equals(employee.getAddress()) && getEmail().equals(employee.getEmail());
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
