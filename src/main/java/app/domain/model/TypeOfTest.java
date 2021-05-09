package app.domain.model;

import app.domain.shared.CommonMethods;
import app.domain.shared.Constants;
import org.apache.commons.lang3.StringUtils;


import java.util.List;


public class TypeOfTest {

    static final int DESCRIPTION_LENGTH = 15;
    static final int COLLECTING_METHOD_LENGTH = 20;
    static final String STRING_COLLECTING_METHODS="Collecting method";
    private final List<ParameterCategory> parameterCategoryList;
    private String code;
    private String description;
    private String collectingMethod;


    public TypeOfTest(String code, String description, String collectingMethod, List<ParameterCategory> parameterCategoryList){
        setCode(code);
        setDescription(description);
        setCollectingMethod(collectingMethod);
        this.parameterCategoryList = parameterCategoryList;
    }

    public String getCode() { return code; }

    public String getDescription() { return description; }

    public String getCollectingMethod() { return collectingMethod; }


    public void setCode(String code) {
        CommonMethods.codeValidation(code);
        this.code = code;
    }

    public void setDescription(String description) {
        if (description == null)
            throw new NullPointerException(Constants.STRING_DESCRIPTION + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(description))
            throw new IllegalArgumentException(Constants.STRING_DESCRIPTION + Constants.STRING_BLANK_EXEPT);
        if (description.length() > DESCRIPTION_LENGTH)
            throw new IllegalArgumentException(Constants.STRING_DESCRIPTION + " cannot have more than 15 characters.");
        this.description = description;
    }

    public void setCollectingMethod(String collectingMethod) {
        if (collectingMethod == null)
            throw new NullPointerException(STRING_COLLECTING_METHODS + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(collectingMethod))
            throw new IllegalArgumentException(STRING_COLLECTING_METHODS + Constants.STRING_BLANK_EXEPT);
        if (collectingMethod.length() > COLLECTING_METHOD_LENGTH)
            throw new IllegalArgumentException(STRING_COLLECTING_METHODS + Constants.STRING_NOT_MORE_THAN_20);
        this.collectingMethod = collectingMethod;
    }

    @Override
    public String toString() {
        return String.format("Type of Test: %nCode: %s %nDescription: %s %nCollecting Method: %s %n%s", this.code, this.description, this.collectingMethod, printCategories());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TypeOfTest newTot = (TypeOfTest) obj;
        return code.equals(newTot.code) || description.equals(newTot.description) &&
                collectingMethod.equals(newTot.collectingMethod);
    }

    private String printCategories(){
        if(parameterCategoryList != null && parameterCategoryList.size()>0){
            String output = "\nParameter Category(ies):\n";
            for (ParameterCategory category : parameterCategoryList) {
                output = output.concat(category.toString());
            }
            return output;
        }else {
            return ("No Categories");
        }
    }
}

