package app.scheduler;

import app.controller.DailyNHSReportController;
import java.util.TimerTask;

public class SendDailyNhsReportTask extends TimerTask {

    /**
     * This method is responsible for running the task of sending the NHS report
     */
    @Override
    public void run() {
        new DailyNHSReportController();
    }
}
