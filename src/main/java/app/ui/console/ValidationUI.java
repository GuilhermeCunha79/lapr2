package app.ui.console;

import app.controller.ValidationController;
import app.ui.console.utils.Utils;

import java.util.List;
import java.util.Objects;

public class ValidationUI implements Runnable {
    private final ValidationController ctrl = new ValidationController();

    @Override
    public void run() {
        boolean repeat;
        do{
            repeat = validationProcess();
        }while(repeat && Objects.requireNonNull(Utils.readLineFromConsole("Do you want to do another validation? (Y/N)")).equalsIgnoreCase("y"));
    }

    /**
     * This method is responsible to guide the user through the test selection and report creation process
     * @return false if its not possible to write another report due to not having more tests
     * needing reports, return true when there are tests still needing reports
     */
    private boolean validationProcess() {
        while (true){
            try {
                List<String> rtvListDto = ctrl.getTestWithoutValidation();
                if (rtvListDto != null) {
                    int option = Utils.showAndSelectIndex(rtvListDto, "Select one of the following tests:");
                    String results = ctrl.getTestResults(rtvListDto.get(option).substring(15, 27));
                    System.out.println(results);
                    System.out.printf("Confirm the tests to validate: %n%s%n", rtvListDto.get(option));
                    if (Objects.requireNonNull(Utils.readLineFromConsole("Y or N:")).equalsIgnoreCase("y")) {
                        if(ctrl.saveValidation())
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
    /*

    public void run() {
        boolean repeat;
        displayList();
        int option = selectOption();
        if (option == 2) {
            do {
                repeat = validation();
            } while (repeat && Objects.requireNonNull(Utils.readLineFromConsole("Do you want to do another validation? (Y/N)")).equalsIgnoreCase("y"));
        }else{
            do {
                repeat = validateAllTests();
            } while (repeat && Objects.requireNonNull(Utils.readLineFromConsole("Do you want to exit the validation menu? (Y/N)")).equalsIgnoreCase("n"));
        }
    }
    private boolean validateAllTests() {
        while (true) {
            try {
                if (rtvListDto != null) {
                    displayList();
                    System.out.println("Do you want to validate all tests?");
                    if (Objects.requireNonNull(Utils.readLineFromConsole("Y or N:")).equalsIgnoreCase("y")) {
                        if (ctrl.doValidation(rtvListDto))
                            if (ctrl.saveValidation())
                                System.out.println("All tests has been validated with success!");
                        return true;
                    }
                } else {
                    System.out.println("\n Error during the validation.");
                    return false;
                }
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int selectOption() {
        int optionSelected = -1;
        System.out.println("\nSelect one option:");
        System.out.println("1. Validate all tests");
        System.out.println("2. Validate a subset of tests");
        System.out.println("0. Cancel");

        do {
            try {
                optionSelected = Utils.readIntegerFromConsole("Your option: ");
            } catch (Exception e) {
                System.out.println("Please insert a valid option");
            }
        } while (!(optionSelected == 1) && !(optionSelected == 2) && !(optionSelected == 0));

        return optionSelected;
    }

    private void displayList() {
        Utils.showList(rtvListDto, "Test ready to validate: ");
    }*/
}
