package app.domain.shared;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class DateTime {

    private String date;
    private String time;

    public DateTime(){
        this.date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm"));
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return String.format("%s at %s", this.date, this.time);
    }
}
