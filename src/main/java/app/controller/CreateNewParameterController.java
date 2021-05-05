package app.controller;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.store.ParameterStore;

import java.util.List;

public class CreateNewParameterController {

    private ParameterStore ps;

    private Parameter param;

    public CreateNewParameterController(){
        this.ps = new ParameterStore();
        this.param = null;
    }

    public boolean createNewParameter(String shortName, String code, String description, String category){
        this.param = this.ps.createParameter(shortName,code,description,category);
        return saveParameter();
    }

    public boolean saveParameter(){
        return this.ps.saveParameter(param);
    }

    public List<ParameterCategory> getCategoryList(){
        return CreateParameterCategoryController.pcStore.getParameterCategoryList();
    }


}
