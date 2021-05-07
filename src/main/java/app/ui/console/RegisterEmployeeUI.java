package app.ui.console;

import app.controller.RegisterEmployeeController;

import app.ui.console.utils.Utils;

import java.util.Scanner;

public class RegisterEmployeeUI implements Runnable{

    static Scanner scanner = new Scanner(System.in);

    private RegisterEmployeeController ctrl;

    @Override
    public void run() {
        registerEmployee();
    }

    public  RegisterEmployeeUI() {
        this.ctrl = new RegisterEmployeeController();
    }

    /**
     * Basic UI to get the correct inputs to register a Employee.
     */
    public void registerEmployee(){

        String empName = Utils.readLineFromConsole("Introduce the Employee name: ");
        String empAddress = Utils.readLineFromConsole("Introduce employee's address: ");
        String empPhoneNumber = Utils.readLineFromConsole("Introduce employee's phone number: ");
        String empEmail = Utils.readLineFromConsole("Introduce employee's email: ");
        int empSoc = Utils.readIntegerFromConsole("Introduce employee's email: ");

        boolean state = false;
        try {
            state = ctrl.newEmployee(null, empName, empAddress, empPhoneNumber, empEmail, empSoc);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getStackTrace());
        }
        if (state) {
            System.out.printf("\nConfirm the employee data: \nName: %s\nAddress %s\nPhone Number: %s\nEmail: %s\nSOC:%d", null, empName, empAddress, empPhoneNumber, empEmail, empSoc);
            String answer = scanner.nextLine();
            while (!answer.equals("Y") && !answer.equals("N")) {
                System.out.println("Answer not valid! Use (Y/N)");
                answer = scanner.nextLine();
                if (answer.equals("Y")) {
                    System.out.println("Employee has been registered");
                }
            }
        } else {
            System.out.println("Employee is invalid!");
        }

    }


}
