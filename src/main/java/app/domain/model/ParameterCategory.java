package app.domain.model;

import app.domain.shared.CommonMethods;
import app.domain.shared.Constants;
import org.apache.commons.lang3.StringUtils;

public class ParameterCategory {

    private static final int NAME_LENGTH = 10;

    private String code;
    private String name;

    /**
     * Constructor for ParameterCategory Class
     *
     * @param code receives the Parameter category code
     * @param name recives the Parameter category name
     */

    public ParameterCategory(String code, String name) {
        setCode(code);
        setName(name);
    }

    /**
     * Method to get the Parameter category code
     *
     * @return return he Parameter category code
     */
    public String getCode() {
        return code;
    }

    /**
     * Method to change the Parameter category code and verify if it checks all acceptance criterias
     *
     * @param code receives the new Parameter category code
     */
    public void setCode(String code) {
        CommonMethods.codeValidation(code);
        this.code = code;
    }

    /**
     * Method to get the Parameter category name
     *
     * @return return he Parameter category name
     */

    public String getName() {
        return name;
    }

    /**
     * Method to change the Parameter category name and also check if the acceptance criterias are fulfilled
     *
     * @param name receives the new Parameter category name
     */

    public void setName(String name) {
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException(Constants.STRING_SHORT_NAME + Constants.STRING_BLANK_EXEPT);
        if (name.length() > NAME_LENGTH)
            throw new IllegalArgumentException(Constants.STRING_SHORT_NAME + Constants.STRING_NOT_MORE_THAN_10);
        this.name = name;
    }

    /**
     * To string method
     *
     * @return a description of the object
     */
    @Override
    public String toString() {
        return String.format("Parameter Category:%nName: %s%nCode: %s%n", this.name, this.code);
    }

    /**
     * Method to check if one object equals the object that called this method
     *
     * @param obj receives another object
     * @return true or false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ParameterCategory newPC = (ParameterCategory) obj;
        return code.equals(newPC.code) || name.equals(newPC.name);
    }
}
