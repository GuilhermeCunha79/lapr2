package app.domain.shared;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class DateTime {

    private String date;
    private String time;

    /**
     * Constructor of this class, doesn't need any parameters but when called, saves the current date and time
     */
    public DateTime(){
        this.date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm"));
    }

    /**
     * Get method for the date
     * @return a date in the dd/MM/yyyy format
     */
    public String getDate() {
        return date;
    }

    /**
     * Get method for the time
     * @return a time in the hh:mm format
     */
    public String getTime() {
        return time;
    }

    /**
     * This toString method returns the date and time stored in this instance
     * @return the date and time
     */
    @Override
    public String toString() {
        return String.format("%s at %s", this.date, this.time);
    }
}
