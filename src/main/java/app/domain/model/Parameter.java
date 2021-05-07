package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Parameter {

    static final int DESCRIPTION_LENGTH = 20;
    static final int CODE_LENGTH = 5;
    static final int SHORT_NAME_LENGTH = 8;
    static final String STRING_BLANK_EXEPT = "Strings cannot be empty";

    private String code;
    private String shortName;
    private String description;
    private String category;

    /**
     * Class Constructor with all parameters needed to create a new parameter
     * @param code code of the parameter
     * @param shortName name of the parameter
     * @param description description of the parameter
     * @param category category chosen from a list of categories registered in the system
     */
    public Parameter(String code, String shortName, String description, String category) {
        setCode(code);
        setShortName(shortName);
        setDescription(description);
        this.code = code;
        this.shortName = shortName;
        this.description = description;
        this.category = category;
    }

    /**
     * Method that allows other classes to access a parameter code
     * @return a String with the parameter code
     */
    public String getCode() {
        return code;
    }

    /**
     * Method that verifies if acceptation criterias for a new code are met and also change a parameter code
     * @param code receives the new code as a parameter
     */
    public void setCode(String code) {
        if (code.length() != CODE_LENGTH)
            throw new IllegalArgumentException("Code needs to have exactly 5 chars");
        if (StringUtils.isBlank(code))
            throw new IllegalArgumentException(STRING_BLANK_EXEPT);

        for (int i = 0; i < code.length(); i++) {
            String c = String.valueOf(code.charAt(i));
            if (!c.matches("[A-Za-z0-9]"))
                throw new IllegalArgumentException("Code has non alphanumeric chars.");
        }
        this.code = code;
    }

    /**
     * Method that allows other classes to access a parameter name
     * @return a String with the parameter name
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Method that verifies if acceptation criterias for a new name are met and also change a parameter name
     * @param shortName receives the new name as a parameter
     */
    public void setShortName(String shortName) {
        if (shortName.length() > SHORT_NAME_LENGTH)
            throw new IllegalArgumentException("Short name has more than 8 chars");
        if (StringUtils.isBlank(shortName))
            throw new IllegalArgumentException(STRING_BLANK_EXEPT);
        this.shortName = shortName;
    }

    /**
     * Method that allows other classes to access a parameter description
     * @return a String with the parameter description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method that verifies if acceptation criterias for a new description are met and also change a parameter description
     * @param description receives the new description as a parameter
     */
    public void setDescription(String description) {
        if (description.length() > DESCRIPTION_LENGTH)
            throw new IllegalArgumentException("Description has more than 20 chars");
        if (StringUtils.isBlank(description))
            throw new IllegalArgumentException(STRING_BLANK_EXEPT);
        this.description = description;
    }

    /**
     * This method returns a string with all the data of the instance of parameter that called the method
     * @return a string with the data
     */
    @Override
    public String toString() {
        return String.format("Parameter:%nCode: %s%nName: %s%nDescription: %s",
                this.code, this.shortName, this.description);
    }

    /**
     * Method used to check if two objects are equals or not, by comparing their attributes.
     * @param o object to be compared to the object that called the method
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Parameter newParam = (Parameter) o;
        return Objects.equals(code, newParam.code) ||
                Objects.equals(shortName, newParam.shortName) ||
                Objects.equals(description, newParam.description);
    }
}
