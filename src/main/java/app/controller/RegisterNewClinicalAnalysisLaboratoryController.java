package app.controller;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.model.TypeOfTest;
import app.domain.store.ClinicalAnalysisLaboratoryStore;

import java.util.List;


public class RegisterNewClinicalAnalysisLaboratoryController {

    private ClinicalAnalysisLaboratoryStore cals;
    private ClinicalAnalysisLaboratory cal;

    /**
     * Class Constructor that gets the Clinical Analysis Laboratory Store from the Company Class
     */
    public RegisterNewClinicalAnalysisLaboratoryController() {
        this(App.getInstance().getCompany().getClinicalAnalysisLaboratoryStore());
    }

    /**
     * Constructor that receives the Clinical Analysis Laboratory Store picked from the class Company to be used in this controller
     *
     * @param cals Clinical Analysis Laboratory Store from the Company Class
     */
    public RegisterNewClinicalAnalysisLaboratoryController(ClinicalAnalysisLaboratoryStore cals) {
        this.cals = cals;
        this.cal = null;
    }

    /**
     * This method is responsible for gathering the data sent by the UI and redirect it to the Clinical Analysis Laboratory Store to create a new clinical analysis laboratory
     *
     * @param name           of the clinical analysis laboratory
     * @param phoneNumber    of the clinical analysis laboratory
     * @param laboratoryID   of the clinical analysis laboratory
     * @param tinNumber      of the clinical analysis laboratory
     * @param address        of the clinical analysis laboratory
     * @param typeOfTestList of the clinical analysis laboratory
     * @return if the clinical analysis laboratory was successfully saved in the clinical analysis laboratory store using the saveClinicalAnalysisLaboratory method
     */
    public boolean registerNewClinicalAnalysisLaboratory(String name, String phoneNumber, String laboratoryID, String tinNumber, String address, List<TypeOfTest> typeOfTestList) {
        this.cal = this.cals.registerClinicalAnalysisLaboratory(name, phoneNumber, laboratoryID, tinNumber, address, typeOfTestList);
        return this.cals.validateClinicalAnalysisLaboratory(cal);
    }


    /**
     * Method that asks the Clinical Analysis Laboratory store to save the clinical analysis laboratory being created
     *
     * @return if it was saved (True or false)
     */
    public boolean saveClinicalAnalysisLaboratory() {
        return this.cals.saveClinicalAnalysisLaboratory(cal);
    }

    /**
     * Returns the list of type of tests available in the system
     * @return list of type of tests
     */
    public List<TypeOfTest> listOfTypeOfTests(){
        return App.getInstance().getCompany().getTypeOfTestStore().getTypeOfTestList();
    }
}
