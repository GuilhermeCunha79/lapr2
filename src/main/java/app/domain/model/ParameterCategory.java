package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class ParameterCategory {

    private String code;

    private String name;

    /**
     * Constructor for ParameterCategory Class
     * @param code receives the Parameter category code
     * @param name recives the Parameter category name
     */

    public ParameterCategory(String code, String name){
        checkCodeRules(code);
        checkNameRules(name);
        this.code = code;
        this.name = name;
    }

    private void checkNameRules(String name) {
        if(StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be blank");
        //Missing Other Rules!!!!
    }

    private void checkCodeRules(String code) {
        if(StringUtils.isBlank(code))
            throw new IllegalArgumentException("Code cannot be blank");
        //Missing Other Rules!!!!
    }

    /**
     * Method to get the Parameter category code
     * @return return he Parameter category code
     */
    public String getCode() {
        return code;
    }

    /**
     * Method to change the Parameter category code
     * @param code receives the new Parameter category code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Method to get the Parameter category name
     * @return return he Parameter category name
     */

    public String getName() {
        return name;
    }

    /**
     * Method to change the Parameter category name
     * @param name receives the new Parameter category name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * To string method
     * @return a description of the object
     */
    @Override
    public String toString() {
        return String.format("Parameter Category:\nName: %s\nCode: %d", this.name, this.code);
    }

    /**
     * Method to check if one object equals the object that called this method
     * @param obj receives another object
     * @return true or false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ParameterCategory newObj = (ParameterCategory) obj;
        return code == newObj.code && Objects.equals(name, newObj.name);
    }
}
