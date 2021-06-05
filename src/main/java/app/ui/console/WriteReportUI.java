package app.ui.console;

import app.controller.WriteReportController;
import app.ui.console.utils.Utils;

import java.util.List;

public class WriteReportUI implements Runnable {

    private final WriteReportController ctrl = new WriteReportController();

    /**
     * This method initiates the write report process and enables the option to write multiple reports without having to return to the menu
     */
    @Override
    public void run() {
        boolean repeat;
        do {
            repeat = writeReportProcess();
        } while (repeat && Utils.confirm("Write another report? (Y or N)"));
    }


    /**
     * This method is responsible to guide the user through the test selection and report creation process
     *
     * @return false if its not possible to write another report due to not having more tests
     * needing reports, return true when there are tests still needing reports
     */
    private boolean writeReportProcess() {
        while (true) {
            try {
                List<String> lTestDto = ctrl.getTestWithoutReport();
                if (lTestDto != null) {
                    int option = Utils.showAndSelectIndex(lTestDto, "Select one of the following tests:");
                    String results = ctrl.getTestResults(lTestDto.get(option).substring(15, 27));
                    Utils.printToConsole(results);
                    String report = Utils.readLineFromConsole("Write report below:");
                    ctrl.newReport(report);
                    Utils.printToConsole(String.format("Confirm report for Test: %s%n%s%nYour report: %n%s", lTestDto.get(option), results, report));
                    if (Utils.confirm("Y or N")) {
                        if (ctrl.saveReport())
                            Utils.printToConsole("INFO: Report Saved.");
                        return true;
                    }
                } else {
                    Utils.printToConsole("\nINFO: No tests needing report are available.");
                    return false;
                }
                return true;
            } catch (Exception e) {
                Utils.printToConsole("INFO: " + e.getMessage());
            }
        }
    }
}
