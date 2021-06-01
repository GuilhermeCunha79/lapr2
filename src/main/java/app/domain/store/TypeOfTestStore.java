package app.domain.store;

import app.domain.model.ParameterCategory;
import app.domain.model.TypeOfTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TypeOfTestStore {

    private List<TypeOfTest> typeOfTestList = new ArrayList<>();

    /**
     * Method that receives type of test from the associated controller to create a new type of test
     * @param code of he type of test
     * @param description of he type of test
     * @param collectingMethod of he type of test
     * @param pc to be added to the type of test
     * @return the type od test created
     */
    public TypeOfTest createTypeOfTest(String code, String description, String collectingMethod, ParameterCategory pc){
        return new TypeOfTest(code, description, collectingMethod, pc);
    }

    public void setTypeOfTestList(List<TypeOfTest> totList){
        this.typeOfTestList = new ArrayList<>(totList);
    }
    /**
     * This method validates the type of test received and adds it to the Type of Test store by calling the method addTypeOfTest
     * @param tot type of test that will be added
     * @return if it was successfully added to the store (true or false)
     */
    public boolean saveTypeOfTest(TypeOfTest tot){
        if(validateTypeOfTest(tot)){
           if(addTypeOfTest(tot)){
               serializeStore();
               return true;
           }
        }
        return false;
    }

    private void serializeStore() {
        try{
            FileOutputStream out = new FileOutputStream("data\\tot.dat");
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(this.typeOfTestList);
            outputStream.close();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    /**
     * Method responsible to add a new type of test to the list when asked by the saveTypeOfTest method
     * @param tot receives Type of Test that will be added
     * @return if it was successfully added to the store (true or false)
     */
    private boolean addTypeOfTest(TypeOfTest tot) {
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
     * Method receives an ID and compares it to the codes of all test types available in the list
     * @param ttId code to compare
     * @return the test type with a matching code
     */
    public TypeOfTest getTestType(String ttId){
        for(TypeOfTest typeOfTest : typeOfTestList){
            if (typeOfTest.getCode().equals(ttId))
                return typeOfTest;
        }
        return null;
    }

    /**
     * This method return a copy of the Type of Test List for other classes that need and can access it
     * @return List of type of test
     */
    public List<TypeOfTest> getTypeOfTestList() {
        return new ArrayList<>(typeOfTestList);
    }
}
