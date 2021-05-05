package app.domain.store;

import app.domain.model.Parameter;

import java.util.ArrayList;
import java.util.List;

public class ParameterStore {

    private List<Parameter> parameterList = new ArrayList();

    public Parameter createParameter(String code, String shortName, String description, String category){
        return new Parameter(code,shortName,description,category);
    }

    public boolean saveParameter(Parameter p){
        if(validateParameter(p)){
            return addParameter(p);
        }
        return false;
    }

    public boolean addParameter(Parameter p) {
        if (p != null) {
            if (validateParameter(p))
                return this.parameterList.add(p);
        }
        return false;
    }

    public boolean validateParameter(Parameter p) {
        for (Parameter par : parameterList){
            if(par.equals(p)){
                return false;
            }
        }
        return true;
    }

    public List<Parameter> getParameterList() {
        return parameterList;
    }
}
