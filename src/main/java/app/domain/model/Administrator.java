package app.domain.model;

import app.domain.model.Employee;
/**
 *Administrator class
 */
public class Administrator extends Employee {

    private int adminID;
    static Employee newEmployee;

    /**
     * Constructor for class Administrator.
     * @param adminID
     * @param employeeID
     * @param role
     * @param name
     * @param address
     * @param phoneNumber
     * @param email
     * @param soc
     */
    public Administrator(int adminID, int employeeID, OrganizationRole role, String name, String address, int phoneNumber, String email, int soc) {
        super(employeeID, role, name, address, phoneNumber, email, soc);
        this.adminID = adminID;
    }
    /**
     * Constructor for class Administrator.
     * @param adminID
     * @param employee
     */
    public Administrator(int adminID, Employee employee) {
        super(employee.getEmployeeID(),employee.getRole(), employee.getName(), employee.getAddress(), employee.getPhoneNumber(), employee.getEmail(), employee.getSoc());
        this.adminID = adminID;
    }

    /**
     * Method that returns the id of the Administrator
     *
     * @return the administrator's id
     */
    public int getAdminID() {
        return adminID;
    }
    /**
     * Method that sets the id of the Administrator
     *
     * @return the administrator's id
     */
    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    /**
     * Method that calls for a new instance Employee
     *
     */
    static boolean registerAnEmployee(int employeeID, OrganizationRole role, String name, String address, int phoneNumber, String email, int soc) {
        newEmployee = new Employee(employeeID, role, name, address, phoneNumber, email, soc);
        return validateEmployee(newEmployee);
    }
}
