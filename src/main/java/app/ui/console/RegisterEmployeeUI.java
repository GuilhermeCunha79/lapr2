
package app.ui.console;

import app.controller.RegisterEmployeeController;

import app.mappers.dto.EmpDto;
import app.ui.console.utils.Utils;

public class RegisterEmployeeUI implements Runnable {

    private RegisterEmployeeController ctrl;

    @Override
    public void run() {
        this.ctrl = new RegisterEmployeeController();
        if (registerEmployee())
            System.out.println("Employee was succesfully registered!");
    }

    public boolean registerEmployee() {
        boolean state = false;
        do {
            String empRole = Utils.readLineFromConsole("Introduce employee's role in the company: ");
            String empName = Utils.readLineFromConsole("Introduce employee's name: ");
            String empAddress = Utils.readLineFromConsole("Introduce employee's address: ");
            String empPhoneNumber = Utils.readLineFromConsole("Introduce employee's phone number: ");
            String empEmail = Utils.readLineFromConsole("Introduce employee's email: ");
            String empSoc = Utils.readLineFromConsole("Introduce employee's SOC: ");

            try {
                if (ctrl.isSpecialistDoctor(empRole))
                    state = ctrl.newSpecialistDoctor(new EmpDto(empRole, empName, empAddress, empPhoneNumber, empEmail, empSoc, Utils.readLineFromConsole("Introduce doctor index number: ")));
                state = ctrl.newEmployee(new EmpDto(empRole, empName, empAddress, empPhoneNumber, empEmail, empSoc));

                if (state) {
                    String answer = Utils.readLineFromConsole(String.format("%nConfirm the employee data: %nCompany Role: %s%nName: %s%nAddress %s%nPhone Number: %s%nEmail: %s%nSOC: %s%n(Y/N)", empRole, empName, empAddress, empPhoneNumber, empEmail, empSoc));
                    while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
                        answer = Utils.readLineFromConsole("Answer not valid! Use (Y/N)");

                    }
                    if (answer.equalsIgnoreCase("Y")) {
                        return ctrl.saveEmployee();
                    }
                } else {
                    System.out.println("Employee is invalid!");
                    return false;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!state);
        return false;
    }


}
