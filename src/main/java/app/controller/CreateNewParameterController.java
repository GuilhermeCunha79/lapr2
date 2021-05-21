package app.controller;


import app.domain.model.Company;
import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.store.ParameterCategoryStore;
import app.domain.store.ParameterStore;
import app.mappers.ParameterCategoryMapper;

import java.util.List;

public class CreateNewParameterController {

    private ParameterStore ps;
    private ParameterCategoryStore pcs;

    private List<ParameterCategory> lPC;

    private Parameter param;

    /**
     * Class Constructor that gets the Parameter Store created in the Company Class
     */
    public CreateNewParameterController() {
        this(App.getInstance().getCompany());
    }

    /**
     * This Constructor receives the Parameter Store picked from the class Company to be used in this controller
     * @param company
     */
    public CreateNewParameterController(Company company){
        this.ps = company.getParameterStore();
        this.pcs = company.getParameterCategoryStore();
        this.lPC = pcs.getParameterCategoryList();
        this.param = null;
    }

    /**
     * This method is responsible for receiving data from the UI and send it to the Parameter Store to create a new parameter
     * @param code of the parameter
     * @param name of the parameter
     * @param description of the parameter
     * @param categoryId of the parameter
     * @return if the parameter was successfully saved in the parameter store by calling the saveParameter method
     */
    public boolean createNewParameter(String code, String name, String description, String categoryId){
        this.param = this.ps.createParameter(code,name,description,categoryId);
        return this.ps.validateParameter(param);
    }

    /**
     * Method responsible to save a new parameter in the parameter store when called by the createNewParameter method
     * @return if the parameter was saved in the store (True or False)
     */
    public boolean saveParameter(){
        return this.ps.saveParameter(param);
    }

    /**
     * This method gets the Category list needed to present the Parameter Categories available to the admin, for him to assign one to the parameter being created
     * @return a List of parameter categories.
     */
    public List<String> getAllParameterCategories(){
        return ParameterCategoryMapper.toDTO(this.lPC);
    }


}
