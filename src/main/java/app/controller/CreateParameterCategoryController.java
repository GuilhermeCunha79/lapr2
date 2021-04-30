package app.controller;

import app.domain.model.ParameterCategory;
import auth.domain.store.ParameterCategoryStore;

public class CreateParameterCategoryController {

    private ParameterCategoryStore pcStore;

    private ParameterCategory pc;

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
