package app.ui.console;

import app.controller.ValidationController;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ValidationUI implements Runnable {
    private final ValidationController ctrl = new ValidationController();

    @Override
    public void run() {
        boolean repeat;
        int validationProcess = validationMethod();
        if (validationProcess == 0) {
            validateAllTests();
        } else if (validationProcess == 1) {
            do {
                repeat = validationProcess();
            } while (repeat && Objects.requireNonNull(Utils.readLineFromConsole("Do you want to do another validation? (Y/N)")).equalsIgnoreCase("y"));
        } else {
            System.out.println("INFO: Invalid option");
        }
    }

    private void validateAllTests() {
        System.out.println("These tests are going to be validated:");
        List<String> testList = ctrl.getTestWithoutValidation();
        try {
            for(String test : testList){
                System.out.println(test);
            }
            if (Objects.requireNonNull(Utils.readLineFromConsole("Confirm validation? (Y/N)")).equalsIgnoreCase("y")) {
                if (ctrl.doValidation(testList))
                    System.out.println("INFO: All tests were successfully validated");
                else
                    System.out.println("INFO: Something wrong happen");
            } else {
                System.out.println("INFO: Validation aborted");
            }
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    private int validationMethod() {
        List<String> options = new ArrayList<>();
        options.add("Validate all tests");
        options.add("Validate a subset of tests");
        return Utils.showAndSelectIndex(options, "Select one of the following options:");
    }

    /**
     * This method is responsible to guide the user through the test selection and report creation process
     *
     * @return false if its not possible to write another report due to not having more tests
     * needing reports, return true when there are tests still needing reports
     */
    private boolean validationProcess() {
        while (true) {
            try {
                List<String> rtvListDto = ctrl.getTestWithoutValidation();
                if (rtvListDto != null) {
                    int option = Utils.showAndSelectIndex(rtvListDto, "Select one of the following tests:");
                    String results = ctrl.getTestResults(rtvListDto.get(option).substring(15, 27));
                    System.out.println(results);
                    System.out.printf("Confirm the tests to validate: %n%s%n", rtvListDto.get(option));
                    if (Objects.requireNonNull(Utils.readLineFromConsole("Y or N:")).equalsIgnoreCase("y")) {
                        if (ctrl.saveValidation(results) )
                            System.out.println("Validation Saved!");
                        return true;
                    }
                } else {
                    System.out.println("%n No more tests need validation!");
                    return false;
                }
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
