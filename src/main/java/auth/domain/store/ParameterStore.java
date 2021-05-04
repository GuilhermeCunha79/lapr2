package auth.domain.store;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;

import java.util.ArrayList;
import java.util.List;

public class ParameterStore {

    private List<Parameter> parameterList = new ArrayList();

    public Parameter createParameter(String code, String shortName, String description, String category){
        return new Parameter(code,shortName,description,category);
    }

    public boolean saveParameterCategory(Parameter p){
        if(validateParameterCategory(p)){
            addParameterCategory(p);
            return true;
        }
        return false;
    }

    public boolean addParameterCategory(Parameter p)
    {
        if (p != null) {
            if (!validateParameterCategory(p))
                return this.parameterList.add(p);
        }
        return false;
    }

    public boolean validateParameterCategory(Parameter p) {
        for (Parameter par : parameterList){
            if(par.equals(p)){
                return true;
            }
        }
        return false;
    }

    public List<Parameter> getParameterList() {
        return parameterList;
    }
}
