package app.domain.model;

import app.domain.shared.CommonMethods;
import app.domain.shared.Constants;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Parameter {

    private String code;
    private String shortName;
    private String description;
    private ParameterCategory category;


    static final int DESCRIPTION_LENGTH = 20;
    static final int SHORT_NAME_LENGTH = 8;

    /**
     * Class Constructor with all parameters needed to create a new parameter
     *
     * @param code        code of the parameter
     * @param shortName   name of the parameter
     * @param description description of the parameter
     * @param category    category chosen from a list of categories registered in the system
     */
    public Parameter(String code, String shortName, String description, ParameterCategory category) {
        setCode(code);
        setShortName(shortName);
        setDescription(description);
        this.category = category;
    }



    /**
     * Method that allows other classes to access a parameter code
     *
     * @return a String with the parameter code
     */
    public String getCode() {
        return code;
    }

    /**
     * Method that verifies if acceptation criterias for a new code are met and also change a parameter code
     *
     * @param code receives the new code as a parameter
     */
    public void setCode(String code) {
        CommonMethods.codeValidation(code);
        this.code = code;
    }

    /**
     * Method that allows other classes to access a parameter name
     *
     * @return a String with the parameter name
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Method that verifies if acceptation criterias for a new name are met and also change a parameter name
     *
     * @param shortName receives the new name as a parameter
     */
    public void setShortName(String shortName) {
        if (shortName==null)
            throw new NullPointerException(Constants.STRING_SHORT_NAME + Constants.STRING_NULL_EXEPT);
        if (shortName.length() > SHORT_NAME_LENGTH)
            throw new IllegalArgumentException(Constants.STRING_SHORT_NAME + " has more than 8 chars");
        if (StringUtils.isBlank(shortName))
            throw new IllegalArgumentException(Constants.STRING_SHORT_NAME + Constants.STRING_BLANK_EXEPT);
        this.shortName = shortName;
    }

    /**
     * Method that allows other classes to access a parameter description
     *
     * @return a String with the parameter description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method that verifies if acceptation criterias for a new description are met and also change a parameter description
     *
     * @param description receives the new description as a parameter
     */
    public void setDescription(String description) {
        if (description==null)
            throw new NullPointerException(Constants.STRING_DESCRIPTION + Constants.STRING_NULL_EXEPT);
        if (description.length() > DESCRIPTION_LENGTH)
            throw new IllegalArgumentException(Constants.STRING_DESCRIPTION + Constants.STRING_NOT_MORE_THAN_20);
        if (StringUtils.isBlank(description))
            throw new IllegalArgumentException(Constants.STRING_DESCRIPTION + Constants.STRING_BLANK_EXEPT);
        this.description = description;
    }

    /**
     * This method returns a string with all the data of the instance of parameter that called the method
     *
     * @return a string with the data
     */
    @Override
    public String toString() {
        return String.format("Parameter -> Code: %s | Name: %s | Description: %s",
                this.code, this.shortName, this.description);
    }

    /**
     * Method used to check if two objects are equals or not, by comparing their attributes.
     *
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

    public ParameterCategory getCategory() {
        return this.category;
    }
}
