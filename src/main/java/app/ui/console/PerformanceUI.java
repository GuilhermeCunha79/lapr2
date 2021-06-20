/*package app.ui.console;

import app.controller.PerformanceController;
import app.domain.shared.DateTime;
import app.ui.console.utils.Utils;

public class PerformanceUI implements Runnable {

    private PerformanceController ctrl;

    @Override
    public void run() {
        this.ctrl = new PerformanceController();
        if (registerPerformance())
            Utils.printToConsole("Statistics was successfully produced!");
    }

    public boolean registerPerformance() {
        boolean state = false;
        do {
            {
                String beginDay = Utils.readLineFromConsole("Introduce the beginning day : ");
                String beginHour = Utils.readLineFromConsole("Introduce the beginning hour : ");

                String endDay = Utils.readLineFromConsole("Introduce the ending day : ");
                String endHour = Utils.readLineFromConsole("Introduce the ending hour : ");

                DateTime begin = new DateTime(beginDay, beginHour);
                DateTime end = new DateTime(endDay, endHour);


                try {
                    if (ctrl.newPerformance(begin, end)) state = true;

                    else {
                        Utils.printToConsole("Sorry, but the performance cannot be produced.");
                        return false;
                    }
                } catch (Exception e) {
                    Utils.printToConsole("INFO: " + e.getMessage());
                }
            }
        }
        while (!state) ;
        return false;

    }
}*/
