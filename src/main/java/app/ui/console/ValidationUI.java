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
            } while (repeat && Utils.confirm("Do you want to do another validation? (Y or N)"));
        } else {
            Utils.printToConsole("INFO: Invalid option");
        }
    }

    private void validateAllTests() {
        Utils.printToConsole("These tests are going to be validated:");
        List<String> testList = ctrl.getTestWithoutValidation();
        try {
            for(String test : testList){
                System.out.println(test);
            }
            if (Utils.confirm("Confirm validation? (Y or N)")) {
                if (ctrl.doValidation(testList))
                    Utils.printToConsole("INFO: All tests were successfully validated");
                else
                    Utils.printToConsole("INFO: Something wrong happened");
            } else {
                Utils.printToConsole("INFO: Validation aborted");
            }
        }catch(Exception e){
            Utils.printToConsole("INFO: " + e.getLocalizedMessage());
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
                    Utils.printToConsole(results);
                    Utils.printToConsole(String.format("Confirm the tests to validate: %n%s%n", rtvListDto.get(option)));
                    if (Utils.confirm("Y or N")) {
                        if (ctrl.saveValidation(results) )
                            Utils.printToConsole("Validation Saved!");
                        return true;
                    }
                } else {
                    Utils.printToConsole("\nNo more tests need validation!");
                    return false;
                }
                return true;
            } catch (Exception e) {
                Utils.printToConsole("INFO: " + e.getMessage());
            }
        }
    }
}
