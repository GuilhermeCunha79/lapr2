package app.domain.store;

import app.domain.model.ParameterCategory;
import app.domain.model.TypeOfTest;

import java.util.ArrayList;
import java.util.List;

public class TypeOfTestStore {

    private List<TypeOfTest> typeOfTestList = new ArrayList();

    /**
     * Method that receives type of test from the associated controller to create a new type of test
     * @param code of he type of test
     * @param description of he type of test
     * @param colectingmethod of he type of test
     * @param parameterCategoryList of he type of test
     * @return the type od test created
     */
    public TypeOfTest createTypeOfTest(String code, String description, String colectingmethod, List<ParameterCategory> parameterCategoryList){
        return new TypeOfTest(code, description, colectingmethod, parameterCategoryList);
    }

    /**
     * This method validates the type of test received and adds it to the Type of Test store by calling the method addTypeOfTest
     * @param tot type of test that will be added
     * @return if it was successfully added to the store (true or false)
     */
    public boolean saveTypeOfTest(TypeOfTest tot){
        if(validateTypeOfTest(tot)){
           return addTypeOfTest(tot);
        }
        return false;
    }


    /**
     * Method responsible to add a new type of test to the list when asked by the saveTypeOfTest method
     * @param tot receives Type of Test that will be added
     * @return if it was successfully added to the store (true or false)
     */
    public boolean addTypeOfTest(TypeOfTest tot) {
        if (tot != null && validateTypeOfTest(tot)){
                return this.typeOfTestList.add(tot);
        }
        return false;
    }


    /**
     * Method responsible to validate a new type of test before it's added to the list when asked by the saveTypeOfTest method
     * @param tot receives the Type of Test to be validate
     * @return if it was successfully added to the store (true or false)
     */
    public boolean validateTypeOfTest(TypeOfTest tot) {
        for (TypeOfTest typeTe : typeOfTestList){
            if(typeTe.equals(tot)){
                return false;
            }
        }
        return true;
    }

    /**
     * This method return a copy of the Type of Test List for other classes that need and can access it
     * @return List of type of test
     */
    public List<TypeOfTest> getTypeOfTestList() {
        return new ArrayList<>(typeOfTestList);
    }
}
