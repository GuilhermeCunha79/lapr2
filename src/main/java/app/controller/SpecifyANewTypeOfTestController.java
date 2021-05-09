package app.controller;

import app.domain.model.ParameterCategory;
import app.domain.model.TypeOfTest;
import app.domain.store.TypeOfTestStore;

import java.util.List;

public class SpecifyANewTypeOfTestController {

    private TypeOfTestStore tots;

    private TypeOfTest tot;

    /**
     * This Constructor receives the Type of Test Store picked from the class Company to be used in this controller
     * @param totStore Type of Test Store from the Company Class
     */
    public SpecifyANewTypeOfTestController(TypeOfTestStore totStore){
        this.tots = totStore;
        this.tot = null;
    }

    /**
     * Class Constructor that gets the Type of Test Store created in the Company Class
     */
    public SpecifyANewTypeOfTestController() {
        this(App.getInstance().getCompany().getTypeOfTestStore());
    }

    /**
     *  This method is responsible for receiving data from the UI and send it to the Type of Test Store to create a new type of test
     * @param code of the type of test
     * @param description of the type of test
     * @param colectingmethod of the type of test
     * @param parameterCategoryList of the type of test
     * @return  if the type of test was successfully validted in the parameter store by calling the validateTypeOfTest method
     */
    public boolean createANewTypeOfTest(String code, String description, String colectingmethod,  List<ParameterCategory> parameterCategoryList){
        this.tot = this.tots.createTypeOfTest( code, description, colectingmethod, parameterCategoryList);
        return tots.validateTypeOfTest(tot);
    }


    /**
     * This method to get the type of test created
     * @return Type of test
     */
    public TypeOfTest getTot(){
        return this.tot;
    }

    /**
     * Method responsible to save a new Types of Test in the parameter store when called by the createNewParameter method
     * @return if the Type of Test was saved in the store (True or False)
     */
    public boolean saveTypeOfTest(){
        return this.tots.saveTypeOfTest(tot);
    }


    /**
     * This method gets the Category list needed to present the Parameter Categories available to the admin, for him to assign one or more to the Type of Test being created
     * @return a List of parameter categories.
     */
    public List<ParameterCategory> getCategoryList(){
        return App.getInstance().getCompany().getParameterCategoryStore().getParameterCategoryList();
    }

}
