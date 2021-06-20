package app.scheduler;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Scheduler {

    /**
     * Scheduler responsible for sending the NHS report every day at 6:00 AM
     */
    public Scheduler(){
        Timer scheduler = new Timer();
        TimerTask sendDailyNhsReport = new SendDailyNhsReportTask();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 6);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date timerHour = calendar.getTime();
        scheduler.scheduleAtFixedRate(sendDailyNhsReport, timerHour, timerHour.getTime());
    }
}
