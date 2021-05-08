package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TypeOfTest {

    static final int DESCRIPTION_LENGTH = 15;
    static final int CODE_LENGTH = 5;
    static final int COLECTING_METHOD_LENGTH = 20;

    private String code;
    private String description;
    private String colectingMethod;
    private List<ParameterCategory> parameterCategoryList = new ArrayList();

    public TypeOfTest(String code, String description, String colectingMethod, List<ParameterCategory> parameterCategoryList){
        setCode(code);
        setDescription(description);
        setColectingMethod(colectingMethod);
        this.code = code;
        this.description = description;
        this.colectingMethod = colectingMethod;
        this.parameterCategoryList = parameterCategoryList;
    }



    public String getCode() { return code; }

    public String getDescription() { return description; }

    public String getColectingMethod() { return colectingMethod; }

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

    public void setDescription(String description) {
        if(StringUtils.isBlank(description))
            throw new IllegalArgumentException("Description cannot be blank");
        if (description.length() > DESCRIPTION_LENGTH)
            throw new IllegalArgumentException("Too long description has more than 15 chars");
        this.description = description;
    }

    public void setColectingMethod(String colectingMethod) {
        if(StringUtils.isBlank(colectingMethod))
            throw new IllegalArgumentException("Colecting method cannot be blank");
        if (colectingMethod.length() > COLECTING_METHOD_LENGTH)
            throw new IllegalArgumentException("Too long colecting method has more than 20 chars");
        this.colectingMethod = colectingMethod;
    }

    @Override
    public String toString() {
        return String.format("Type of Test: \nCode: %s \nDescription: %s \nColecting Method: %s \n%s", this.code, this.description, this.colectingMethod, this.printCategories() );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TypeOfTest newtot = (TypeOfTest) obj;
        return code == newtot.code || description.equals(newtot.description) &&
                colectingMethod.equals(newtot.colectingMethod);
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
            output.concat("No Categorys");
        }
        return output;
    }
}

