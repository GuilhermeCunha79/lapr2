package app.ui.console;

import app.controller.ValidationController;
import app.ui.console.utils.Utils;

import java.util.List;

public class ValidationUI implements Runnable {
    private final ValidationController ctrl = new ValidationController();

    List<String> rtvListDto = ctrl.getTestWithoutValidation();

    @Override
    public void run() {
        System.out.println("Test Validation");
        int optionSelected = selectOption();
        displayList(rtvListDto);
        if (optionSelected != 0) {
            if (optionSelected == 1) {
                ctrl.doValidation(rtvListDto);
            }
            if (optionSelected == 2) {
                validateJustOneTest();
                doValidation();
            }
            displayList(rtvListDto);
        }
    }

    private boolean doValidation() {
        while (true) {
            try {
                List<String> validationDTO = ctrl.getTestWithoutValidation();
                if (validationDTO != null) {
                    int option = Utils.showAndSelectIndex(validationDTO, "Select the tests you want to validate:");
                    String results = ctrl.getTestByCode(validationDTO.get(option).substring(15, 26)).toString();
                    System.out.println(results);
                    System.out.printf("Confirm that the selected tests are to validate: %s%n%s", validationDTO.get(option), results);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void validateJustOneTest() {
        int testToValidate;
        do {
            try {
                testToValidate = Utils.readIntegerFromConsole("Select the test(s) you want to validate");
                ctrl.changeStateToValidateOne(rtvListDto.get(testToValidate).substring(15, 26));
            } catch (Exception exp) {
                System.out.println("Insert a valid option!");
            }
        } while (!Utils.confirm("Do you have any other test that you want to validate? (Y/N)"));
    }

    private int selectOption() {
        int optionSelected;
        System.out.println("Select one option : ");
        System.out.println("1 - Validate all the ready tests");
        System.out.println("2 - Validate some tests");
        System.out.println("0 - Cancel");
        do {
            optionSelected = Utils.readIntegerFromConsole("Choose an option:");
        } while (optionSelected != 0);
        return optionSelected;
    }

    private void displayList(List<String> list) {
        ctrl.displayList(list);
    }
}
