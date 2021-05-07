package app.controller;

import app.domain.model.ParameterCategory;
import app.domain.store.ParameterCategoryStore;

public class CreateParameterCategoryController {

    private ParameterCategoryStore pcStore;
    private ParameterCategory pc;

    /**
     * Class Constructor that gets the Parameter Category Store from the Company Class
     */
    public CreateParameterCategoryController() {
        this(App.getInstance().getCompany().getParameterCategoryStore());
    }

    /**
     * Constructor that receives the Parameter Category Store picked from the class Company to be used in this controller
     * @param pcStore Parameter Category Store from the Company Class
     */
    public CreateParameterCategoryController(ParameterCategoryStore pcStore) {
        this.pcStore = pcStore;
        this.pc = null;
    }

    /**
     * This method is responsible for gathering the data sent by the UI and redirect it to the Parameter Category Store to create a new parameter category
     * @param code of the parameter category
     * @param name of the parameter category
     * @return if the parameter category was successfully saved in the parameter category store using the saveParameterCategory method
     */
    public boolean createNewParameterCategory(String code, String name){
        this.pc = this.pcStore.createParameterCategory(code, name);
        return this.pcStore.validateParameterCategory(pc);
    }

    /**
     * Method that asks the Parameter Category store to save the category being created
     * @return if it was saved (True or false)
     */
    public boolean saveParameterCategory(){
        return this.pcStore.saveParameterCategory(pc);
    }
}
