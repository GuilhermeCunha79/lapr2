package app.domain.model;

import app.domain.shared.DateTime;
import org.apache.commons.lang3.StringUtils;

public class Result {


    private DateTime createdAt;
    private String resultText;


    public Result (String resultText){
        setResultText(resultText);
    }

    public String getResultText() {
        return resultText;
    }

    public DateTime getResultDateTime() {
        return createdAt;
    }


    public void setResultText(String ResultText) {
        if(ResultText == null)
            throw new NullPointerException();
        if(StringUtils.isBlank(ResultText))
            throw new IllegalArgumentException("Result cannot be empty");
        this.resultText = ResultText;
        registerResultDateTime();
    }

    public void registerResultDateTime(){
        this.createdAt = new DateTime();
    }

    @Override
    public String toString() {
        return String.format("Result created on %s: %n Result: %s", createdAt, resultText);
    }
}
