package app.ui.console;

import app.controller.CreateTestController;
import app.ui.console.utils.Utils;

import java.util.List;

public class CreateTestUI implements Runnable {


    private CreateTestController ctrl;
    private final String labId;

    /**
     * This constructor receives the lab id which tell the system where the receptionist is working from
     * @param labId Id of the lab
     */
    public CreateTestUI(String labId) {
        this.labId = labId;
    }

    /**
     * Method that initiates the user interaction to guide him through the process of creating a new test
     */
    @Override
    public void run() {
        ctrl = new CreateTestController();
        ctrl.setLabId(labId);
        if (createTestProcess()) {
            Utils.printToConsole("Test created and saved successfully.");
        } else {
            Utils.printToConsole("Test creation failed.");
        }
    }

    /**
     * This method initiates and ends the creation of the test with the help of other UI methods
     * @return if the test was created or not
     */
    private boolean createTestProcess() {
        while (true) {
            try {
                if (clientSelection() == null) {
                    return false;
                }
                testTypeSelection();
                if (parameterSelection()) {
                    ctrl.createTest();
                    if (Utils.confirm("Save Test? (Y or N)"))
                        return ctrl.saveTest();
                }else
                    return false;
            } catch (Exception e) {
                Utils.printToConsole(e.getLocalizedMessage());
            }
        }
    }

    /**
     * Method responsible for showing to the user the parameters available for a certain test type
     * @return if the parameters to test were saved or not
     */
    private boolean parameterSelection() {
        List<String> lParameters = ctrl.getParameterList();
        int option;
        boolean addAnother = false;
        if (lParameters != null && !lParameters.isEmpty()) {
            do {
                option = Utils.showAndSelectIndex(lParameters, "Select one parameter from the list to be tested:");
                if (option >= 0 && option < lParameters.size()) {
                    ctrl.addParameter(lParameters.get(option).substring(19, 24));
                    lParameters.remove(option);
                    if (!lParameters.isEmpty() && Utils.confirm("Add another parameter: (Y/N)"))
                        addAnother = true;
                } else {
                    Utils.printToConsole("Selection invalid!");
                    return false;
                }
            } while (!lParameters.isEmpty() && option > lParameters.size() || addAnother);
        } else {
            Utils.printToConsole("No parameters available");
            return false;
        }
        return true;
    }
    /**
     * Method presents to the user the test types available
     */
    private void testTypeSelection() {
        List<String> lTestTypes = ctrl.getTypeOfTestList();
        int option;
        if (lTestTypes != null && !lTestTypes.isEmpty()) {
            do {
                option = Utils.showAndSelectIndex(lTestTypes, "Select a test type from the list:");
                if (option >= 0 && option < lTestTypes.size()) {
                    ctrl.addTypeOfTest(lTestTypes.get(option).substring(1, 6));
                } else
                    Utils.printToConsole("Selection invalid!");
            } while (option < 0 || option > lTestTypes.size());
        } else {
            Utils.printToConsole("No test types available");
        }
    }

    /**
     * This method allows the receptionist to select the client that is going to be linked to the test being created by using its TIN
     * @return the tin of the client
     */
    private String clientSelection() {
        String nhsCode = Utils.readLineFromConsole("Insert NHS code (12 digits):");
        boolean repeat = false;
        do {
            String clientTin = Utils.readLineFromConsole("Insert client's Tax Identification Number (TIN):");
            String client = ctrl.getClientByTINAndSaveNhsCode(clientTin, nhsCode);
            if (client == null) {
                Utils.printToConsole("\nINFO: There is no client registered with this TIN\n\n");
                return null;
            } else {
                if (Utils.confirm(String.format("Is the client correct?%n%s%n(Y or N)%n", client)))
                    return clientTin;
                else if (Utils.confirm("Try another TIN? (Y or N)"))
                    repeat = true;
            }
        } while (!repeat);
        return null;
    }
}
