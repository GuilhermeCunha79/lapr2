package app.domain.model;

import app.domain.shared.DateTime;
import org.apache.commons.lang3.NotImplementedException;

public class Test {

    private DateTime createdAt;
    private String internalCode;
    private String nhsCode;
    private boolean reportDone;

    public String getTestResults(){
        throw new NotImplementedException("Method not implemented yet");
    }

    public boolean addReportText(String reportText){
        throw new NotImplementedException("Method not implemented yet");
    }

    private void changeStateToReportDone(){
        reportDone = true;
    }
}
