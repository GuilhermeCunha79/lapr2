package app.domain.model;

import app.domain.shared.CommonMethods;
import app.domain.shared.DateTime;
import org.apache.commons.lang3.StringUtils;

public class Report {

    private DateTime createdAt;
    private String reportText;

    private final int MAX_WORDS_IN_REPORT = 400;

    public Report (String reportText){
        setReportText(reportText);
    }

    public String getReportText() {
        return reportText;
    }

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

    public void registerReportDateTime(){
        this.createdAt = new DateTime();
    }

    @Override
    public String toString() {
        return String.format("Report created on %s: %n Report: %s", createdAt, reportText);
    }
}
