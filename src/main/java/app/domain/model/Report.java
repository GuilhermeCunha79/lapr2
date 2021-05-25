package app.domain.model;

import app.domain.shared.CommonMethods;
import app.domain.shared.DateTime;
import org.apache.commons.lang3.StringUtils;

public class Report {

    private DateTime createdAt;
    private String reportText;

    private static final int MAX_WORDS_IN_REPORT = 400;

    /**
     * Constructor of this class
     * @param reportText saved in the reportText string
     */
    public Report (String reportText){
        setReportText(reportText);
    }

    /**
     * Get method for the report text
     * @return a string with the report text
     */
    public String getReportText() {
        return reportText;
    }

    /**
     * This method sets the report text and also validates is own content
     * @param reportText to set
     */
    public void setReportText(String reportText) {
        if(reportText == null)
            throw new NullPointerException();
        if(StringUtils.isBlank(reportText))
            throw new IllegalArgumentException("Report cannot be empty");
        if(CommonMethods.wordCounter(reportText) > MAX_WORDS_IN_REPORT)
            throw new IllegalArgumentException("Report cannot have more than " + MAX_WORDS_IN_REPORT + "words.");
        this.reportText = reportText;
        registerReportDateTime();
    }

    /**
     * This method when called saves the date and time of when the report was done
     */
    public void registerReportDateTime(){
        this.createdAt = new DateTime();
    }

    /**
     * To string method with essential data about the report such as the creation date and time and also the report text
     * @return a string
     */
    @Override
    public String toString() {
        return String.format("Report created on: %s%nReport: %s", createdAt, reportText);
    }
}
