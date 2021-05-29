package app.domain.store;

import app.domain.model.ParameterCategory;

import java.util.ArrayList;
import java.util.List;

public class ParameterCategoryStore {

    private List<ParameterCategory> parameterCategoryList = new ArrayList();


    /**
     * Method that receives parameters from the associated controller to create a new parameter category
     *
     * @param code of the parameter category
     * @param name of the parameter category
     * @return the parameter category created
     */
    public ParameterCategory createParameterCategory(String code, String name) {
        return new ParameterCategory(code, name);
    }

    /**
     * Method that returns a parameter category from the list with the same code as the one received by parameter
     *
     * @param categoryId
     * @return Parameter category
     */
    public ParameterCategory getParameterCategory(String categoryId) {
        for (ParameterCategory pc : parameterCategoryList) {
            if (pc.getCode().equals(categoryId))
                return pc;
        }
        return null;
    }

    /**
     * This method validates the parameter category received by parameter and adds it to the Parameter category store by calling the method addParameterCategory
     *
     * @param pc Parameter category that will be added
     * @return if it was successfully added to the store (true or false)
     */
    public boolean saveParameterCategory(ParameterCategory pc) {
        if (validateParameterCategory(pc)) {
            return addParameterCategory(pc);
        }
        return false;
    }

    /**
     * Method responsible to add a new parameter category to the list when asked by the saveParameterCategory method
     *
     * @param pc receives the Parameter category to be added
     * @return if it was successfully added to the store (true or false)
     */
    private boolean addParameterCategory(ParameterCategory pc) {
        if (pc != null) {
            return this.parameterCategoryList.add(pc);
        }
        return false;
    }

    /**
     * Method responsible to validate a new parameter category before it's added to the list when called by the saveParameterCategory method
     *
     * @param pc receives the Parameter category to be added
     * @return if it was successfully added to the store (true or false)
     */
    public boolean validateParameterCategory(ParameterCategory pc) {
        for (ParameterCategory parCat : parameterCategoryList) {
            if (parCat.equals(pc)) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method return a copy of the Parameter Category List for other classes that need to access it
     *
     * @return List of parameter categories
     */
    public List<ParameterCategory> getParameterCategoryList() {
        return new ArrayList<>(parameterCategoryList);
    }


}
