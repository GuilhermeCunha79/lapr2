package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class ParameterCategory {

    private static final int NAME_LENGTH = 10;
    private static final int CODE_LENGTH = 5;
    private String code;

    private String name;

    /**
     * Constructor for ParameterCategory Class
     * @param code receives the Parameter category code
     * @param name recives the Parameter category name
     */

    public ParameterCategory(String code, String name){
        setCode(code);
        setName(name);
        this.code = code;
        this.name = name;
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
        if (code.length() != CODE_LENGTH)
            throw new IllegalArgumentException("Code needs to have exactly 5 chars");
        if (StringUtils.isBlank(code))
            throw new IllegalArgumentException("Code cannot be blank");

        for (int i = 0; i < code.length(); i++) {
            String c = String.valueOf(code.charAt(i));
            if (!c.matches("[A-Za-z0-9]"))
                throw new IllegalArgumentException("Code has non alphanumeric chars.");
        }
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
        if(StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be blank");
        if (name.length() > NAME_LENGTH)
            throw new IllegalArgumentException("Short name has more than 10 chars");
        this.name = name;
    }

    /**
     * To string method
     * @return a description of the object
     */
    @Override
    public String toString() {
        return String.format("Parameter Category:%nName: %s%nCode: %s", this.name, this.code);
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
        ParameterCategory newPC = (ParameterCategory) obj;
        return code == newPC.code || Objects.equals(name, newPC.name);
    }
}
