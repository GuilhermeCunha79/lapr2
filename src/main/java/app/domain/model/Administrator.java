package app.domain.model;

public class Administrator extends Employee {

    private int adminID;

    public Administrator(int adminID, int employeeID, OrganizationRole role, String name, String address, int phoneNumber, String email, int soc) {
        super(employeeID, role, name, address, phoneNumber, email, soc);
        this.adminID = adminID;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    static void registerAnEmployee(int employeeID, OrganizationRole role, String name, String address, int phoneNumber, String email, int soc) {
        Employee newEmployee = new Employee(employeeID, role, name, address, phoneNumber, email, soc);
    }
}
