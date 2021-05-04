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

    public boolean createNewParameter(String shortName, String code, String description, String category){
        this.param = this.ps.createParameter(shortName,code,description,category);
        return this.ps.validateParameterCategory(param);
    }

    public boolean saveParameter(){
        return this.ps.saveParameterCategory(param);
    }


}
