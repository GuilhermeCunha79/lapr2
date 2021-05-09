package app.ui.console;

import app.controller.RegisterNewClinicalAnalysisLaboratoryController;
import app.domain.model.TypeOfTest;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegisterNewClinicalAnalysisUI implements Runnable {

    private RegisterNewClinicalAnalysisLaboratoryController ctrl;

    List<String> showTypeOfTest = new ArrayList<>();
    List<TypeOfTest> listOfSelectedTOfTest = new ArrayList<>();


    /**
     * First method to be called when this UI is instantiated
     */
    public void run() {
        ctrl = new RegisterNewClinicalAnalysisLaboratoryController();

        System.out.println("Register new clinical analysis laboratory:\nEnter the following data.");

        if (registerCALab())
            System.out.println("\nClinical analysis laboratory added to the system");
        else
            System.out.println("Operation failed");
    }

    /**
     * This method is responsible to interact with the user to guide him in the clinical analysis laboratory registration process
     * @return if the lab was registered or not
     */
    private boolean registerCALab() {
        boolean done = false;
        do {
            try {
                String labID = Utils.readLineFromConsole("Enter laboratory ID: ");
                String name = Utils.readLineFromConsole("Enter laboratory name: ");
                String tinNumber = Utils.readLineFromConsole("Enter laboratory TIN number: ");
                String address = Utils.readLineFromConsole("Enter laboratory address: ");
                String phoneNumber = Utils.readLineFromConsole("Enter laboratory phone number: ");

                List<TypeOfTest> tOfTestList = ctrl.listOfTypeOfTests();
                if (tOfTestList.isEmpty()) {
                    System.out.println("There are no type of tests in the system, please create at least one first.");
                    return false;
                }
                else {

                    for (TypeOfTest tOfT : tOfTestList) {
                        showTypeOfTest.add(tOfT.getDescription());
                    }
                    int option = Utils.showAndSelectIndex(showTypeOfTest, "\nSelect one type of test:");
                    while (option != -1) {

                        TypeOfTest tOfTestSelected = tOfTestList.get(option);

                        listOfSelectedTOfTest.add(tOfTestSelected);

                        showTypeOfTest.remove(option);
                        if (Objects.requireNonNull(Utils.readLineFromConsole("Add another type of test: (Y or N)")).equalsIgnoreCase("y"))
                            option = Utils.showAndSelectIndex(showTypeOfTest, "Select another type of test: ");
                        else
                            option = -1;
                    }
                    if (ctrl.registerNewClinicalAnalysisLaboratory(name, phoneNumber, labID, tinNumber, address, listOfSelectedTOfTest)) {
                        System.out.println("\nConfirm laboratory data:");
                        System.out.printf("ID: %s%nName: %s%nTIN number: %s%nAddress: %s%nPhone number: %s%n", labID, name, tinNumber, address, phoneNumber);
                        if (Objects.requireNonNull(Utils.readLineFromConsole("(Y/N):")).equalsIgnoreCase("y")) {
                            done = true;
                            return ctrl.saveClinicalAnalysisLaboratory();
                        } else {
                            System.out.println("Operation cancelled!");
                            return false;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }

        } while (!done);
        return false;
    }
}
