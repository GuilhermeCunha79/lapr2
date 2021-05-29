package app.ui.console;

import app.controller.RecordResultController;

import app.ui.console.utils.Utils;

import java.util.List;
import java.util.Objects;

public class RecordResultUI implements Runnable {

    private RecordResultController ctrl;


    private final String labId;

    public RecordResultUI(String labId) {
        this.labId = labId;
    }

    @Override
    public void run() {
        ctrl = new RecordResultController();
        boolean repeat;
        do {
            repeat = recordResults();
        } while (repeat && Objects.requireNonNull(Utils.readLineFromConsole("Record results for another test? (Y/N)")).equalsIgnoreCase("y"));

    }

    private boolean recordResults() {
        String chosenTest = testSelection();
        if (chosenTest == null)
            return false;
        List<String> testParameterList = ctrl.getTest(chosenTest.substring(15, 27));
        int option;
        while(true) {
            try {
                do {
                    if (testParameterList != null && !testParameterList.isEmpty()) {
                        do {
                            option = Utils.showAndSelectIndex(testParameterList, "Select a test parameter to add result:");
                            if (option >= 0 && option < testParameterList.size()) {
                                if (addResult(testParameterList.get(option).substring(19, 24))) {
                                    testParameterList.remove(option);
                                }
                            } else if (option == -1)
                                return false;
                            else
                                System.out.println("Selection invalid!");
                        } while (option < 0 || option > testParameterList.size());
                    } else {
                        System.out.println("No parameters available");
                        return true;
                    }
                } while (!testParameterList.isEmpty());
                System.out.println(ctrl.getTestResults());
                if (Objects.requireNonNull(Utils.readLineFromConsole("Confirm everything? (Y/N)")).equalsIgnoreCase("y"))
                    return ctrl.changeStateToResultDone();
                return false;
            } catch (Exception e) {
                System.out.println("INFO: "+ e.getLocalizedMessage());
            }
        }
    }

    private boolean addResult(String parameterCode) {
        System.out.println("To add a result to the parameter tested, enter de following data:");
        do {
            try {
                double value = Utils.readDoubleFromConsole("Enter value:");
                String metric = Utils.readLineFromConsole("Enter metric:");
                return ctrl.addParameterTestResult(parameterCode, value, metric);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while(true);
    }

    private String testSelection() {
        List<String> availableTestList = ctrl.getListOfTestWithoutResult(labId);
        int option;
        if (availableTestList != null && !availableTestList.isEmpty()) {
            do {
                option = Utils.showAndSelectIndex(availableTestList, "Select a test:");
                if (option >= 0 && option < availableTestList.size())
                    return availableTestList.get(option);
                else if(option == -1){
                    return null;
                }
                System.out.println("Selection invalid!");
            }while (option < 0 || option > availableTestList.size());
        }
        System.out.println("INFO: There are no tests available");
        return null;
    }

}
