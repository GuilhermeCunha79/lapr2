package app.ui.console;

import app.controller.RegisterNewClinicalAnalysisLaboratoryController;
import app.ui.console.utils.Utils;
import java.util.List;
import java.util.Objects;

public class RegisterNewClinicalAnalysisUI implements Runnable {

    private RegisterNewClinicalAnalysisLaboratoryController ctrl;


    /**
     * First method to be called when this UI is instantiated
     */
    public void run() {
        ctrl = new RegisterNewClinicalAnalysisLaboratoryController();

        Utils.printToConsole("Register new clinical analysis laboratory:\nEnter the following data.");

        if (registerCALab())
            Utils.printToConsole("\nClinical analysis laboratory added to the system");
        else
            Utils.printToConsole("\nClinical analysis laboratory not added to the system");
    }

    /**
     * This method is responsible to interact with the user to guide him in the clinical analysis laboratory registration process
     *
     * @return if the lab was registered or not
     */
    private boolean registerCALab() {
        do {
            try {
                String labID = Utils.readLineFromConsole("Enter laboratory ID: ");
                String name = Utils.readLineFromConsole("Enter laboratory name: ");
                String tinNumber = Utils.readLineFromConsole("Enter laboratory TIN number: ");
                String address = Utils.readLineFromConsole("Enter laboratory address: ");
                String phoneNumber = Utils.readLineFromConsole("Enter laboratory phone number: ");

                if (ctrl.registerNewClinicalAnalysisLaboratory(labID, name, address, phoneNumber, tinNumber)) {
                    List<String> ttListDisplay = ctrl.listOfTypeOfTests();
                    if (ttListDisplay.isEmpty()) {
                        Utils.printToConsole("There are no test types in the system, please create at least one first.");
                        return false;
                    } else {
                        int option = Utils.showAndSelectIndex(ttListDisplay, "\nSelect one type of test:");
                        while (option != -1 && !ttListDisplay.isEmpty()) {
                            String tOfTestSelected = ttListDisplay.get(option);
                            ctrl.addTestType(tOfTestSelected.substring(1, 6));
                            ttListDisplay.remove(option);
                            if (Utils.confirm("Add another type of test: (Y or N)"))
                                option = Utils.showAndSelectIndex(ttListDisplay, "Select another type of test: ");
                            else
                                option = -1;
                        }
                        Utils.printToConsole("\nConfirm laboratory data:");
                        Utils.printToConsole(String.format("Lab ID: %s%nName: %s%nTIN number: %s%nAddress: %s%nPhone number: %s%n", labID, name, tinNumber, address, phoneNumber));
                        if (Utils.confirm("Y or N")) {
                            return ctrl.saveClinicalAnalysisLaboratory();
                        } else {
                            Utils.printToConsole("\nOperation cancelled!");
                            return false;
                        }
                    }
                }else{
                    Utils.printToConsole("\nFailed to add new clinical analysis laboratory");
                }
            } catch (Exception e) {
                
                System.out.println(e.getLocalizedMessage());
            }

        } while (true);
    }
}
