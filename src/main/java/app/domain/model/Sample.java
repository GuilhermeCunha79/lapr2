package app.domain.model;



import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;


public class Sample implements Serializable  {
    private String code;

    private static final int CODE_LENGTH = 11;

    /**
     * creates a list of class sample list
     * @param code
     */
    public Sample(String code) {
       setCode(code);
    }

    /**
     * method to get the sample list
     * @return sampleList
     */
    public String getCode() {
        return code;
    }

    /**
     * This method sets the report text and also validates is own content
     * @param code to set
     */
    public void setCode(String code) {
        if(code == null)
            throw new NullPointerException();
        if(StringUtils.isBlank(code))
            throw new IllegalArgumentException("Code cannot be empty");
        if(code.length() != CODE_LENGTH)
            throw new IllegalArgumentException("Code can only 11 characters.");
        this.code = code;
    }

    /**
     * to String method to show the
     * @return a String
     */
    @Override
    public String toString() {
        return String.format("Sample: %s",code);
    }
}

