package app.domain.model;

import app.domain.shared.CommonMethods;
import app.domain.shared.DateTime;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class Report implements Serializable {

    private DateTime createdAt;
    private String reportText;

    private static final int MAX_WORDS_IN_REPORT = 400;

    /**
     * Constructor of this class
     *
     * @param reportText saved in the reportText string
     */
    public Report(String reportText) {
        setReportText(reportText);
    }

    /**
     * If a test is created via a CSV file, this constructor
     * allows to save any report date as long as it is a valid date and hour
     * @param reportDateHour
     */
    public Report(DateTime reportDateHour) {
        setCreatedAt(reportDateHour);
    }

    /**
     * Get method for the report text
     *
     * @return a string with the report text
     */
    public String getReportText() {
        return reportText;
    }

    /**
     * Get method for the report creation date
     *
     * @return a string with the report date
     */
    public DateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * This method sets the report text and also validates is own content
     *
     * @param reportText to set
     */
    public void setReportText(String reportText) {
        if (reportText == null)
            throw new NullPointerException();
        if (StringUtils.isBlank(reportText))
            throw new IllegalArgumentException("Report cannot be empty");
        if (CommonMethods.wordCounter(reportText) > MAX_WORDS_IN_REPORT)
            throw new IllegalArgumentException("Report cannot have more than " + MAX_WORDS_IN_REPORT + "words.");
        this.reportText = reportText;
        registerReportDateTime();
    }

    /**
     * This method validates dateTime objects and assigns them if they are valid
     * @param createdAt
     */
    public void setCreatedAt(DateTime createdAt) {
        if (createdAt == null)
            throw new NullPointerException("Date and Time of the report cannot be null");
        this.createdAt = createdAt;
    }

    /**
     * This method when called saves the date and time of when the report was done
     */
    public void registerReportDateTime() {
        this.createdAt = new DateTime();
    }

    /**
     * To string method with essential data about the report such as the creation date and time and also the report text
     *
     * @return a string
     */
    @Override
    public String toString() {
        return String.format("Report created on: %s%nReport: %s", createdAt, reportText);
    }
}
