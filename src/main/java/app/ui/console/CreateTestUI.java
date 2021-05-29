package app.ui.console;

import app.controller.CreateTestController;
import app.ui.console.utils.Utils;

import java.util.List;
import java.util.Objects;

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
            System.out.println("Test created and saved successfully.");
        } else {
            System.out.println("Test creation failed.");
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
                if (parameterSelection())
                    ctrl.createTest();
                if (Objects.requireNonNull(Utils.readLineFromConsole("Save test? (Y/N)")).equalsIgnoreCase("Y"))
                    return ctrl.saveTest();
                else
                    return false;
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
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
                    if (!lParameters.isEmpty() && Objects.requireNonNull(Utils.readLineFromConsole("Add another parameter: (Y/N)")).equalsIgnoreCase("Y") )
                        addAnother = true;
                } else {
                    System.out.println("Selection invalid!");
                    return false;
                }
            } while (!lParameters.isEmpty() && option > lParameters.size() || addAnother);
        } else {
            System.out.println("No parameters available");
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
                    System.out.println("Selection invalid!");
            } while (option < 0 || option > lTestTypes.size());
        } else {
            System.out.println("No test types available");
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
                System.out.println("\nINFO: There is no client registered with this TIN\n\n");
                return null;
            } else {
                if (Objects.requireNonNull(Utils.readLineFromConsole(String.format("Is the client correct?%n%s%n(Y/N)%n", client))).equalsIgnoreCase("Y"))
                    return clientTin;
                else if (Objects.requireNonNull(Utils.readLineFromConsole("Try another TIN? (Y/N)")).equalsIgnoreCase("Y"))
                    repeat = true;
            }
        } while (!repeat);
        return null;
    }
}
