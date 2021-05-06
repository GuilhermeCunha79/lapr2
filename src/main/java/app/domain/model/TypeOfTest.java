package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class TypeOfTest {

    private String code;
    private String description;
    private String colectingMethod;
    private String category;

    public TypeOfTest(String code, String description, String colectingMethod, String category){
        setCode(code);
        setDescription(description);
        setColectingMethod(colectingMethod);
        this.code = code;
        this.description = description;
        this.colectingMethod = colectingMethod;
        this.category = category;
    }



    public String getCode() { return code; }

    public String getDescription() { return description; }

    public String getColectingMethod() { return colectingMethod; }

    public void setCode(String code) {
        if (code.length() != 5)
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

    public void setDescription(String description) {
        if(StringUtils.isBlank(description))
            throw new IllegalArgumentException("Description cannot be blank");
        if (description.length() > 15)
            throw new IllegalArgumentException("Too long description has more than 15 chars");
        this.description = description;
    }

    public void setColectingMethod(String colectingMethod) {
        if(StringUtils.isBlank(colectingMethod))
            throw new IllegalArgumentException("Colecting method cannot be blank");
        if (colectingMethod.length() > 20)
            throw new IllegalArgumentException("Too long colecting method has more than 20 chars");
        this.colectingMethod = colectingMethod;
    }

    @Override
    public String toString() {
        return String.format("Type of Test: %nCode: %s %nDescription: %s %nColectingMethod: %s ", this.code, this.description, this.colectingMethod  );

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

