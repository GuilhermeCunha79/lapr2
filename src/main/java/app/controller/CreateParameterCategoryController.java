package app.controller;

import app.domain.model.ParameterCategory;
import app.domain.store.ParameterCategoryStore;

public class CreateParameterCategoryController {

    private ParameterCategoryStore pcStore;
    private ParameterCategory pc;

    public CreateParameterCategoryController() {
        this(App.getInstance().getCompany().getParameterCategoryStore());
    }

    public CreateParameterCategoryController(ParameterCategoryStore pcStore) {
        this.pcStore = pcStore;
        this.pc = null;
    }

    public boolean createNewParameterCategory(String code, String name){
        this.pc = this.pcStore.createParameterCategory(code, name);
        return this.pcStore.validateParameterCategory(pc);
    }

    public boolean saveParameterCategory(){
        return this.pcStore.saveParameterCategory(pc);
    }
}
