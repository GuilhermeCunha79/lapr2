package app.ui.console;

import app.controller.ValidationController;
import app.ui.console.utils.Utils;

import java.util.List;
import java.util.Objects;

public class ValidationUI implements Runnable {
    private final ValidationController ctrl = new ValidationController();

    List<String> rtvListDto = ctrl.getTestWithoutValidation();

    @Override
    public void run() {
        boolean repeat = false;
        System.out.println("Test Validation");
        int optionSelected = selectOption();
        displayList(rtvListDto);
        do {
            if (!(optionSelected == 0)) {
                if (optionSelected == 1) {
                    repeat=ctrl.doValidation(rtvListDto);
                }else{
                    repeat=doValidation();
                }
                displayList(rtvListDto);
            }
        }while(repeat &&Objects.requireNonNull(Utils.readLineFromConsole("Do you want to validate another test(s)? (Y/N)")).equalsIgnoreCase("y"));
    }


    private boolean doValidation() {
        while (true) {
            try {
                if (rtvListDto != null) {
                    int option = Utils.showAndSelectIndex(rtvListDto, "Select the tests you want to validate:");
                    String results = ctrl.getTestByCode(rtvListDto.get(option).substring(15, 26)).toString();
                    System.out.println(results);
                    System.out.printf("Confirm that the selected tests are to validate: %s%n%s", rtvListDto.get(option), results);
                    if (Objects.requireNonNull(Utils.readLineFromConsole("Y or N:")).equalsIgnoreCase("y")) {
                        if (ctrl.doValidation(rtvListDto)) {
                            System.out.println("Validation done with success!");
                            return true;
                        }
                    }
                    }else{
                        System.out.println("Not validated");
                        return false;
                    }
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
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
