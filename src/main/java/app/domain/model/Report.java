package app.domain.model;

import app.domain.shared.DateTime;
import org.apache.commons.lang3.NotImplementedException;

public class Report {

    private DateTime createdAt;
    private String ReportText;

    public Report (String reportText){
        setReportText(reportText);
    }

    public void setReportText(String reportText) {
        throw new NotImplementedException("Method not implemented yet");
    }

    public void registerReportDateTime(){
        this.createdAt = new DateTime();
    }
}
