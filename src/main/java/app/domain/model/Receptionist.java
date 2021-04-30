package app.domain.model;

public class Receptionist extends Employee{

    private long employeeId;
    /**
     * Constructor for class Employee.
     *
     * @param role
     * @param name
     * @param address
     * @param phoneNumber
     * @param email
     * @param soc
     */
    public Receptionist(OrganizationRole role, String name, String address, long phoneNumber, String email, int soc, long employeeId) {
        super(role, name, address, phoneNumber, email, soc);
        this.employeeId=employeeId;
    }
    /**
     * Method that returns the employeeId of the receptionist
     *
     * @return the receptionist's employeeId
     */
    public long getEmployeeId() {
        return employeeId;
    }

    /**
     * Method that sets the employeeId of the receptionist
     *
     * @param employeeId
     */
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

}
