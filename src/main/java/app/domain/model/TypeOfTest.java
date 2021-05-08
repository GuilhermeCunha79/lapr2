package app.domain.model;

import app.domain.shared.CommonMethods;
import app.domain.shared.Constants;
import org.apache.commons.lang3.StringUtils;


import java.util.List;


public class TypeOfTest {

    static final int DESCRIPTION_LENGTH = 15;
    static final int CODE_LENGTH = 5;
    static final int COLLECTING_METHOD_LENGTH = 20;
    private final List<ParameterCategory> parameterCategoryList;
    private String code;
    private String description;
    private String collectingMethod;


    public TypeOfTest(String code, String description, String collectingMethod, List<ParameterCategory> parameterCategoryList){
        setCode(code);
        setDescription(description);
        setCollectingMethod(collectingMethod);
        this.code = code;
        this.description = description;
        this.collectingMethod = collectingMethod;
        this.parameterCategoryList = parameterCategoryList;
    }



    public String getCode() { return code; }

    public String getDescription() { return description; }

    public String getCollectingMethod() { return collectingMethod; }


    public void setCode(String code) {
        if (code == null)
            throw new NullPointerException("Code" + Constants.STRING_NULL_EXEPT);
        if (code.length() != CODE_LENGTH)
            throw new IllegalArgumentException("Code needs to have exactly 5 characters");
        if (StringUtils.isBlank(code))
            throw new IllegalArgumentException("Code" + Constants.STRING_BLANK_EXEPT);
        if (!CommonMethods.stringHaveAlphanumerical(code))
            throw new IllegalArgumentException("Code" + Constants.NON_ALPHANUM_EXEPT);
        this.code = code;
    }

    public void setDescription(String description) {
        if (description == null)
            throw new NullPointerException("Description" + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(description))
            throw new IllegalArgumentException("Description" + Constants.STRING_BLANK_EXEPT);
        if (description.length() > DESCRIPTION_LENGTH)
            throw new IllegalArgumentException("Description cannot have more than 15 characters.");
        this.description = description;
    }

    public void setCollectingMethod(String collectingMethod) {
        if (collectingMethod == null)
            throw new NullPointerException("Collecting method" + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(collectingMethod))
            throw new IllegalArgumentException("Collecting method" + Constants.STRING_BLANK_EXEPT);
        if (collectingMethod.length() > COLLECTING_METHOD_LENGTH)
            throw new IllegalArgumentException("Collecting method cannot have more than 20 characters");
        this.collectingMethod = collectingMethod;
    }

    @Override
    public String toString() {
        return String.format("Type of Test: %nCode: %s %nDescription: %s %nCollecting Method: %s %n%s", this.code, this.description, this.collectingMethod, this.printCategories() );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TypeOfTest newTot = (TypeOfTest) obj;
        return code == newTot.code || description.equals(newTot.description) &&
                collectingMethod.equals(newTot.collectingMethod);
    }

    private String printCategories(){
        String output = "Category List:"+System.lineSeparator();
        if(parameterCategoryList != null && parameterCategoryList.size()>0){
            for(int i=0;i<parameterCategoryList.size();i++){
                parameterCategoryList.get(i).toString();
                output = output.concat( parameterCategoryList.get(i).toString());
                output =output.concat(System.lineSeparator());
            }
        }else {
            output.concat("No Categories");
        }
        return output;
    }
}

