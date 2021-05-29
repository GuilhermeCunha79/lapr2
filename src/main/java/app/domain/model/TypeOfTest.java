package app.domain.model;

import app.domain.shared.CommonMethods;
import app.domain.shared.Constants;
import org.apache.commons.lang3.StringUtils;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class TypeOfTest {

    static final int DESCRIPTION_LENGTH = 15;
    static final int COLLECTING_METHOD_LENGTH = 20;
    static final String STRING_COLLECTING_METHODS = "Collecting method";
    private List<ParameterCategory> parameterCategoryList = new ArrayList<>();
    private String code;
    private String description;
    private String collectingMethod;


    /**
     * Class Constructor with all parameters needed to create a new type of test
     *
     * @param code             of the type of test
     * @param description      of the type of test
     * @param collectingMethod of the type of test
     * @param pc               to be added to the type of test
     */
    public TypeOfTest(String code, String description, String collectingMethod, ParameterCategory pc) {
        setCode(code);
        setDescription(description);
        setCollectingMethod(collectingMethod);
        addParameterCategory(pc);
    }

    /**
     * Method that allows other classes to access a type of test code
     *
     * @return a String with the Type of test code
     */
    public String getCode() {
        return code;
    }

    /**
     * Method that allows other classes to access a type of test description
     *
     * @return a String with the type of test description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method that allows other classes to access a type of test collecting method
     *
     * @return a String with the type of test collecting method
     */
    public String getCollectingMethod() {
        return collectingMethod;
    }

    /**
     * Method that verifies if acceptation criterias for a new code are met and also change a type of test code
     *
     * @param code receives the new code as a type of test
     */
    public void setCode(String code) {
        CommonMethods.codeValidation(code);
        this.code = code;
    }

    /**
     * Method that verifies if acceptation criterias for a new description are met and also change a type of test description
     *
     * @param description receives the new description as a type of test
     */
    public void setDescription(String description) {
        if (description == null)
            throw new NullPointerException(Constants.STRING_DESCRIPTION + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(description))
            throw new IllegalArgumentException(Constants.STRING_DESCRIPTION + Constants.STRING_BLANK_EXEPT);
        if (description.length() > DESCRIPTION_LENGTH)
            throw new IllegalArgumentException(Constants.STRING_DESCRIPTION + " cannot have more than 15 characters.");
        this.description = description;
    }

    /**
     * Method that verifies if acceptation criterias for a new collectind method are met and also change a type of test collecting method
     *
     * @param collectingMethod receives the new collecting method as a type of test
     */
    public void setCollectingMethod(String collectingMethod) {
        if (collectingMethod == null)
            throw new NullPointerException(STRING_COLLECTING_METHODS + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(collectingMethod))
            throw new IllegalArgumentException(STRING_COLLECTING_METHODS + Constants.STRING_BLANK_EXEPT);
        if (collectingMethod.length() > COLLECTING_METHOD_LENGTH)
            throw new IllegalArgumentException(STRING_COLLECTING_METHODS + Constants.STRING_NOT_MORE_THAN_20);
        this.collectingMethod = collectingMethod;
    }

    /**
     * Method used to add the new parameter category to the test type received by parameter
     *
     * @param pc parameter category to be added
     * @return (in)success of the operation
     */
    public boolean addParameterCategory(ParameterCategory pc) {
        if (pc != null)
            return this.parameterCategoryList.add(pc);
        return false;
    }

    public ExternalModule getExternalModule(String paramCode){
        Properties props = new Properties();
        try (InputStream in = new FileInputStream("config.properties")) {
            props.load(in);
            String value;
            Class<?> oClass = null;
            if (paramCode.equals("IgGAN")) {
                value = props.getProperty("Company.CovidReferenceValues.adapter");
            } else {
                value = props.getProperty("Company.BloodReferenceValues.adapter");

            }
            oClass = Class.forName(value);
            in.close();
            return (ExternalModule) oClass.newInstance();

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    /**
     * This method returns a string with all the data of the instance of type of test that called the method
     *
     * @return a string with the data
     */
    @Override
    public String toString() {
        return String.format("Type of Test:%nCode: %s%nDescription: %s%nCollecting Method: %s%n%s", this.code, this.description, this.collectingMethod, printCategories());
    }

    /**
     * Method used to check if two objects are equals or not, by comparing their attributes.
     *
     * @param obj object to be compared to the object that called the method
     * @return true or false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TypeOfTest newTot = (TypeOfTest) obj;
        return code.equals(newTot.code) || description.equals(newTot.description) &&
                collectingMethod.equals(newTot.collectingMethod);
    }


    /**
     * Method used to group the categories for the test in a String output
     *
     * @return output or String ("No Categories")
     */
    private String printCategories() {
        if (parameterCategoryList != null && !parameterCategoryList.isEmpty()) {
            String output = String.format("Parameter Category(ies):%n");
            for (ParameterCategory category : parameterCategoryList) {
                output = output.concat(category.toString());
            }
            return output;
        } else {
            return ("No Categories");
        }
    }

    public List<ParameterCategory> getCategoryListByTheTypeOfTest() {
        return new ArrayList<>(parameterCategoryList);
    }

}