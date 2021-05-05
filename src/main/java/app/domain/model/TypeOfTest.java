package app.domain.model;

import org.apache.commons.lang3.StringUtils;

public class TypeOfTest {

    private String code;
    private String description;
    private String colectingMethod;

    static final String STRING_BLANK_EXEPT = "Strings cannot be empty";

    public TypeOfTest(String code, String description, String colectingmethod, ParameterCategory category){
        checkCodeRules(code);
        checkDescriptionRules(description);
        checkColectingMethod(colectingmethod);
        this.code = code;
        this.description = description;
        this.colectingMethod = colectingmethod;
    }


    private void checkCodeRules(String code) {
        for (int i = 0; i < code.length(); i++) {
            String c = String.valueOf(code.charAt(i));
            if (!c.matches("[A-Za-z0-9]"))
                throw new IllegalArgumentException("Code has non alphanumeric chars.");
        }

        if (code.length() != 5)
            throw new IllegalArgumentException("Code needs to have exactly 5 chars");
        if (StringUtils.isBlank(code))
            throw new IllegalArgumentException(STRING_BLANK_EXEPT);
    }

    private void checkDescriptionRules(String description){
        if (StringUtils.isBlank(description))
            throw new IllegalArgumentException(STRING_BLANK_EXEPT);
        if ( description.length() > 15)
            throw new IllegalArgumentException("Description cannot pass 15 chars in length.");
    }

    private void checkColectingMethod(String colectingMethod){
        if (StringUtils.isBlank(colectingMethod))
            throw new IllegalArgumentException(STRING_BLANK_EXEPT);
        if (colectingMethod.length() > 20)
            throw new IllegalArgumentException("Colecting method cannot pass 20 chars in length.");
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getColectingmethod() {
        return colectingMethod;
    }



    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setColectingmethod(String colectingmethod) {
        this.colectingMethod = colectingmethod;
    }



    @Override
    public String toString() {
        return String.format("Type of Test: \nCode: %s \nDescription: %s \nColectingMethod: %s ", this.code, this.description, this.colectingMethod  );

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TypeOfTest newtot = (TypeOfTest) obj;
        return code == newtot.code || description.equals(newtot.description) &&
                colectingMethod.equals(newtot.colectingMethod);
    }
}

