package app.domain.model;


import java.util.Objects;

public class Parameter {

    private String code;
    private String shortName;
    private String description;

    static final int DESCRIPTION_LENGTH = 20;
    static final int CODE_LENGTH = 5;
    static final int SHORT_NAME_LENGTH = 8;

    public Parameter(String shortName, String code, String description, ParameterCategory category){
        checkCodeRules(code);
        checkShortNameRules(shortName);
        checkDescriptionRules(description);
        this.code = code;
        this.shortName = shortName;
        this.description = description;
    }

    private void checkDescriptionRules(String description) {
        if(description.length()>DESCRIPTION_LENGTH)
            throw new IllegalArgumentException("Description has more than 20 chars");
    }

    private void checkShortNameRules(String shortName) {
        if(shortName.length()>SHORT_NAME_LENGTH)
            throw new IllegalArgumentException("Short name has more than 8 chars");
    }

    private void checkCodeRules(String code) {
        if(!code.matches("[A-Za-z0-9]"))
            throw new IllegalArgumentException("Code has non alphanumeric chars.");
        if(code.length()!=CODE_LENGTH)
            throw new IllegalArgumentException("Code needs to have exactly 5 chars");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Parameter:\nCode: %s\nName: %s\nDescription: %s",
                this.code, this.shortName, this.description);
    }

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
