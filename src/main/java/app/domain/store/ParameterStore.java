package app.domain.store;

import app.domain.model.Parameter;

import java.util.ArrayList;
import java.util.List;

public class ParameterStore {

    private List<Parameter> parameterList = new ArrayList();

    /**
     * Method that receives parameters from the associated controller to create a new parameter
     * @param code of the parameter
     * @param shortName of the parameter
     * @param description of the parameter
     * @param category of the parameter
     * @return the parameter created
     */
    public Parameter createParameter(String code, String shortName, String description, String category) {
        return new Parameter(code, shortName, description, category);
    }

    /**
     * This method validates the parameter received and adds it to the Parameter store by calling the method addParameter
     * @param p Parameter that will be added
     * @return if it was successfully added to the store (true or false)
     */
    public boolean saveParameter(Parameter p) {
        if (validateParameter(p)) {
            return addParameter(p);
        }
        return false;
    }

    /**
     * Method responsible to add a new parameter to the list when asked by the saveParameter method
     * @param p receives the Parameter to be added
     * @return if it was successfully added to the store (true or false)
     */
    public boolean addParameter(Parameter p) {
        if (p != null) {
            return this.parameterList.add(p);
        }
        return false;
    }

    /**
     * Method responsible to validate a new parameter before it's added to the list when asked by the saveParameter method
     * @param p receives the Parameter to be validate
     * @return if it was successfully added to the store (true or false)
     */

    public boolean validateParameter(Parameter p) {
        for (Parameter par : parameterList) {
            if (par.equals(p)) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method return a copy of the Parameter List for other classes that need and can access it
     * @return List of parameter
     */
    public List<Parameter> getParameterList() {
        return new ArrayList<>(parameterList);
    }
}
