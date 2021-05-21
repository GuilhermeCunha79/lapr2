package app.controller;

import app.mappers.*;
import app.domain.model.Company;
import app.domain.model.ParameterCategory;
import app.domain.model.TypeOfTest;
import app.domain.store.ParameterCategoryStore;
import app.domain.store.TypeOfTestStore;

import java.util.List;

public class SpecifyANewTypeOfTestController {

    private TypeOfTestStore tots;
    private ParameterCategoryStore pcs;
    private TypeOfTest tot;

    /**
     * This Constructor receives the class Company to be used in this controller
     * @param company Company Class
     */
    public SpecifyANewTypeOfTestController(Company company){
        this.tots = company.getTypeOfTestStore();
        this.pcs = company.getParameterCategoryStore();
        this.tot = null;
    }

    /**
     * Class Constructor that gets the Type of Test Store created in the Company Class
     */
    public SpecifyANewTypeOfTestController() {
        this(App.getInstance().getCompany());
    }

    /**
     *  This method is responsible for receiving data from the UI and send it to the Type of Test Store to create a new type of test
     * @param code of the type of test
     * @param description of the type of test
     * @param collectingMethod of the type of test
     * @param pcId of the type of test
     * @return  if the type of test was successfully validted in the parameter store by calling the validateTypeOfTest method
     */
    public boolean createANewTypeOfTest(String code, String description, String collectingMethod,  String pcId){
        ParameterCategory pc = this.pcs.getParameterCategory(pcId);
        this.tot = this.tots.createTypeOfTest( code, description, collectingMethod, pc);
        return tots.validateTypeOfTest(tot);
    }


    /**
     * Method responsible to save a new Types of Test in the parameter store when called by the createNewParameter method
     * @return if the Type of Test was saved in the store (True or False)
     */
    public boolean saveTypeOfTest(){
        return this.tots.saveTypeOfTest(tot);
    }

    public boolean addCategory (String pcId){
        ParameterCategory pc = this.pcs.getParameterCategory(pcId);
        return this.tot.addParameterCategory(pc);
    }


    /**
     * This method gets the Category list needed to present the Parameter Categories available to the admin, for him to assign one or more to the Type of Test being created
     * @return a List of parameter categories.
     */
    public List<String> getCategoryList(){
        return ParameterCategoryMapper.toDTO(this.pcs.getParameterCategoryList());
    }

}
