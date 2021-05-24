package app.ui.console;

import app.controller.WriteReportController;
import app.ui.console.utils.Utils;

import java.util.List;
import java.util.Objects;

public class WriteReportUI implements Runnable{

    private WriteReportController ctrl = new WriteReportController();
    @Override
    public void run() {
        boolean repeat;
        do{
            repeat = writeReportProcess();
        }while(repeat && Objects.requireNonNull(Utils.readLineFromConsole("Write another report? (Y/N)")).equalsIgnoreCase("y"));
    }

    private boolean writeReportProcess() {

        boolean done = false;
        while (!done){
            try {
                List<String> lTestDto = ctrl.getTestWithoutReport();
                if (lTestDto != null) {
                    int option = Utils.showAndSelectIndex(lTestDto, "Select one of the following tests:");
                    String results = ctrl.getTestResults(lTestDto.get(option).substring(15, 26));
                    System.out.println(results);
                    String report = Utils.readLineFromConsole("Write report below:");
                    ctrl.newReport(report);
                    System.out.printf("Confirm report for Test: %s%n%s%nYour report: %n%s", lTestDto.get(option), results, report);
                    if (Objects.requireNonNull(Utils.readLineFromConsole("Y or N:")).equalsIgnoreCase("y")) {
                        ctrl.saveReport();
                        System.out.println("INFO: Report Saved.");
                        done = true;
                        return true;
                    }
                } else {
                    System.out.println("\nINFO: No tests needing report are available.");
                    return false;
                }
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }
}
