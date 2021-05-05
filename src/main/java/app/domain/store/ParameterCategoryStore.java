package app.domain.store;

import app.domain.model.ParameterCategory;

import java.util.ArrayList;
import java.util.List;

public class ParameterCategoryStore {

    private List<ParameterCategory> parameterCategoryList = new ArrayList();


    public ParameterCategory createParameterCategory(String code, String name){
        return new ParameterCategory(code, name);
    }

    public boolean saveParameterCategory(ParameterCategory pc){
        if(validateParameterCategory(pc)){
            addParameterCategory(pc);
            return true;
        }
        return false;
    }

    public boolean addParameterCategory(ParameterCategory pc)
    {
        if (pc != null && validateParameterCategory(pc)) {
            return this.parameterCategoryList.add(pc);
        }
        return false;
    }

    public boolean validateParameterCategory(ParameterCategory pc) {
        for (ParameterCategory parCat : parameterCategoryList){
            if(parCat.equals(pc)){
                return false;
            }
        }
        return true;
    }

    public List<ParameterCategory> getParameterCategoryList() {
        return new ArrayList<>(parameterCategoryList);
    }

}
