package app.controller;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import auth.domain.store.ParameterStore;

public class CreateNewParameterController {

    private ParameterStore ps;

    private Parameter param;

    public CreateNewParameterController(ParameterStore ps){
        this.ps = ps;
        this.param = null;
    }

    public boolean createNewParameter(String shortName, String code, String description, ParameterCategory pc){
        this.param = this.ps.createParameter(shortName,code,description,pc);
        return this.ps.validateParameterCategory(param);
    }

    public boolean saveParameter(){
        return this.ps.saveParameterCategory(param);
    }
}
