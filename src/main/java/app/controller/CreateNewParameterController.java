package app.controller;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.store.ParameterStore;

import java.util.List;

public class CreateNewParameterController {

    private ParameterStore ps;

    private Parameter param;

    public CreateNewParameterController() {
        this(App.getInstance().getCompany().getParameterStore());
    }

    public CreateNewParameterController(ParameterStore pStore){
        this.ps = pStore;
        this.param = null;
    }

    public boolean createNewParameter(String code, String name, String description, String category){
        this.param = this.ps.createParameter(code,name,description,category);
        return saveParameter();
    }

    public boolean saveParameter(){
        return this.ps.saveParameter(param);
    }

    public List<ParameterCategory> getCategoryList(){
        return App.getInstance().getCompany().getParameterCategoryStore().getParameterCategoryList();
    }


}
