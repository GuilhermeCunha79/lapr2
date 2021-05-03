package app.domain.model;

import org.apache.commons.lang3.StringUtils;

public class TypeOfTest {

    private String Code;
    private String Description;
    private String ColectingMethod;
    private String SelectedCategory;

    public TypeOfTest (String code, String description, String colectingmethod, String SelectedCategory ){
        checkCodeRules(code);
        checkDescriptionRules(description);
        checkColectingMethod(colectingmethod);
        this.SelectedCategory= SelectedCategory;
        this.Code = code;
        this.Description = description;
        this.ColectingMethod = colectingmethod;
    }

    private void checkCodeRules(String Code) {
        if (StringUtils.isBlank(Code))
            throw new IllegalArgumentException("Code cannot be blank.");
        if ( (Code.length() == 5))
            throw new IllegalArgumentException("Code must have 5 alphanumeric characters written.");
    }

    private void checkDescriptionRules(String Description){
        if (StringUtils.isBlank(Description))
            throw new IllegalArgumentException("Description cannot be blank.");
        if ( (Description.length() < 6) || (Description.length() > 15))
            throw new IllegalArgumentException("Description must have 6 to 15 chars.");
    }

    private void checkColectingMethod(String ColectingMethod){
        if (StringUtils.isBlank(ColectingMethod))
            throw new IllegalArgumentException("C cannot be blank.");
        if ( (ColectingMethod.length() < 6) || (ColectingMethod.length() > 20))
            throw new IllegalArgumentException("Code must have 6 to 20 chars.");
    }

    public String getCode() {
        return Code;
    }

    public String getDescription() {
        return Description;
    }

    public String getColectingmethod() {
        return ColectingMethod;
    }

    public String getSelectedCategory() {
        return SelectedCategory;
    }

    public void setCode(String code) {
        this.Code = code;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public void setColectingmethod(String colectingmethod) {
        this.ColectingMethod = colectingmethod;
    }

    public void setSelectedCategory(String selectedCategory) {
        this.SelectedCategory = selectedCategory;
    }

    @Override
    public String toString() {
        return String.format("Type of Test: \nCode: %s \nDescription: %s \nColectingMethod: %s \nSelectedCategory: %s", this.Code, this.Description, this.ColectingMethod, this.SelectedCategory );

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TypeOfTest newToT = (TypeOfTest) obj;
        return Code == newToT.Code && Description.equals(newToT.Description) &&
                ColectingMethod.equals(newToT.ColectingMethod) && SelectedCategory.equals(newToT.SelectedCategory);
    }
}

