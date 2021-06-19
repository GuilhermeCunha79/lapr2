package app.domain.shared;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class DateTime implements Serializable {

    private String date;
    private String time;

    /**
     * Constructor of this class, doesn't need any parameters but when called, saves the current date and time
     */
    public DateTime() {
        setDate();
        setTime();
    }

    /**
     * Complete constructor of the DateTime object
     *
     * @param date
     * @param time
     */
    public DateTime(String date, String time) {
        this.date = date;
        this.time = time;
    }

    /**
     * Get method for the date
     *
     * @return a date in the dd/MM/yyyy format
     */
    public String getDate() {
        return date;
    }

    public void setDate() {
        this.date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    /**
     * Get method for the time
     *
     * @return a time in the hh:mm format
     */
    public String getTime() {
        return time;
    }

    public void setTime() {
        this.time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm"));
    }

    /**
     * This toString method returns the date and time stored in this instance
     *
     * @return the date and time
     */
    @Override
    public String toString() {
        return String.format("%s at %s", this.date, this.time);
    }

    public int compareTo(DateTime createdAt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(date + " " + time, formatter);
        LocalDateTime anotherDateTime = LocalDateTime.parse(createdAt.getDate() + " " + createdAt.getTime(), formatter);
        if (dateTime.isAfter(anotherDateTime)) {
            return 1;
        }
        if (dateTime.isBefore(anotherDateTime)) {

            {
                return -1;
            }
        }
        return 0;
    }
}


