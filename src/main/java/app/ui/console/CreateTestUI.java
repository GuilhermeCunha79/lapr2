package app.ui.console;

import app.controller.CreateTestController;
import app.ui.console.utils.Utils;

import java.util.List;
import java.util.Objects;

public class CreateTestUI implements Runnable{

    private CreateTestController ctrl;
    private String labId;

    public CreateTestUI (String labId){
        this.labId = labId;
    }

    @Override
    public void run() {
        ctrl = new CreateTestController();
        ctrl.setLabId(labId);
        if(createTestProcess()){
            System.out.println("Test created and saved successfully.");
        }else{
            System.out.println("Test creation failed.");
        }
    }

    private boolean createTestProcess() {
        if(clientSelection() == null){
            return false;
        }
        testTypeSelection();
        if(parameterSelection())
            ctrl.createTest();
        if(Utils.readLineFromConsole("Save test? (Y/N)").equalsIgnoreCase("Y"))
            return ctrl.saveTest();
        else
            return false;
    }

    private boolean parameterSelection() {
        List<String> lParameters = ctrl.getParameterList();
        int option;
        boolean addAnother = false;
        if (lParameters != null && !lParameters.isEmpty()) {
            do {
                option = Utils.showAndSelectIndex(lParameters, "Select one parameter from the list to be tested:");
                if (option >= 0 && option < lParameters.size()) {
                    ctrl.addParameter(lParameters.get(option).substring(19,24));
                    lParameters.remove(option);
                    if(Objects.requireNonNull(Utils.readLineFromConsole("Add another parameter: ")).equalsIgnoreCase("Y"))
                        addAnother = true;
                    else
                        return true;
                } else
                    System.out.println("Selection invalid!");
            } while (option < 0 || option > lParameters.size() || addAnother || !lParameters.isEmpty());
        }else{
            System.out.println("No parameters available");
            return false;
        }
        return true;
    }

    private void testTypeSelection() {
        List<String> lTestTypes = ctrl.getTypeOfTestList();
        int option;
        if (lTestTypes != null && !lTestTypes.isEmpty()) {
            do {
                option = Utils.showAndSelectIndex(lTestTypes, "Select a test type from the list:");
                if (option >= 0 && option < lTestTypes.size()) {
                    ctrl.addTypeOfTest(lTestTypes.get(option).substring(1,5));
                } else
                    System.out.println("Selection invalid!");
            } while (option < 0 || option > lTestTypes.size());
        }else{
            System.out.println("No test types available");
        }
    }

    private String clientSelection() {
        String nhsCode = Utils.readLineFromConsole("Insert NHS code (12 digits):");
        boolean repeat = false;
        do {
            String clientTin = Utils.readLineFromConsole("Insert client's Tax Identification Number (TIN):");
            String client = ctrl.getClientByTINAndSaveNhsCode(clientTin, nhsCode);
            if(Objects.requireNonNull(Utils.readLineFromConsole(String.format("Is the client correct?%n%s%n(Y/N)%n", client))).equalsIgnoreCase("Y"))
                return clientTin;
            else if (Objects.requireNonNull(Utils.readLineFromConsole("Try another TIN? (Y/N)")).equalsIgnoreCase("Y"))
                repeat = true;
        }while (!repeat);
        return null;
    }
}
