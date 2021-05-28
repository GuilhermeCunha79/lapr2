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
        if (rtvListDto.size() >= 0) {
            System.out.println("Test Validation");
            int optionSelected = selectOption();

            if (optionSelected != 0) {
                if (optionSelected == 1) {
                    ctrl.changeStateToValidate(rtvListDto);
                } else {
                    validateJustOneTest();
                }
            }
        }
    }

    private boolean doValidation() {
        while (true) {
            try {
                rtvListDto = ctrl.getTestWithoutValidation();
                if (rtvListDto != null) {
                    int option = Utils.showAndSelectIndex(rtvListDto, "Select the tests you want to validate:");
                    String results = ctrl.getTestByCode(rtvListDto.get(option).substring(15, 26)).toString();
                    System.out.println(results);
                    System.out.printf("Confirm that the selected tests are to validate: %s%n%s", rtvListDto.get(option), results);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void validateJustOneTest(){
        int testToValidate=-1;
        do{
            try{
                testToValidate=Utils.readIntegerFromConsole("Select the test(s) you want to validate");
                String results= ctrl.getTestByCode(rtvListDto.get(testToValidate).substring(15,26)).toString();
            }catch (Exception exp){
                System.out.println("Insert a valid option!");
            }
        }while(!Utils.confirm("Do you have any other test that you want to validate? (Y/N)"));
    }

    private int selectOption(){
        int optionSelected;
        System.out.println("Select one option : ");
        System.out.println("1 -> Validate all the ready tests");
        System.out.println("2 -> Validate some tests");
        // perguntar se é preciso um para cancelar
        do{
            optionSelected=Utils.readIntegerFromConsole("Choose an option:");
        }while (optionSelected!=0);
        return optionSelected;
    }

    private void displayList(List<String> list){
        ctrl.displayList(list);
    }
}
