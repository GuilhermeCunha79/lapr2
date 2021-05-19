package app.controller;

import app.domain.mappers.TestTypeMapper;
import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.model.Company;
import app.domain.model.TypeOfTest;
import app.domain.store.ClinicalAnalysisLaboratoryStore;
import app.domain.store.TypeOfTestStore;

import java.util.List;


public class RegisterNewClinicalAnalysisLaboratoryController {

    private ClinicalAnalysisLaboratoryStore cals;
    private ClinicalAnalysisLaboratory cal;
    private TypeOfTestStore totStore;

    /**
     * Class Constructor that gets the Clinical Analysis Laboratory Store from the Company Class
     */
    public RegisterNewClinicalAnalysisLaboratoryController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor that receives the Clinical Analysis Laboratory Store picked from the class Company to be used in this controller
     *
     * @param company Company Class
     */
    public RegisterNewClinicalAnalysisLaboratoryController(Company company) {
        this.cals = company.getClinicalAnalysisLaboratoryStore();
        this.totStore = company.getTypeOfTestStore();
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
     * @return if the clinical analysis laboratory was successfully saved in the clinical analysis laboratory store using the saveClinicalAnalysisLaboratory method
     */
    public boolean registerNewClinicalAnalysisLaboratory(String laboratoryID, String name, String address, String phoneNumber, String tinNumber) {
        this.cal = this.cals.registerClinicalAnalysisLaboratory(laboratoryID, name, address, phoneNumber, tinNumber);
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
     * This method adds a new test types to a CA Laboratory instance
     * @param ttId
     * @return (in)success of the operation
     */
    public boolean addTestType(String ttId){
        TypeOfTest typeOfTest = this.totStore.getTestType(ttId);
        return cal.addTestType(typeOfTest);
    }
    /**
     * Returns the list of type of tests available in the system
     * @return list of type of tests
     */
    public List<String> listOfTypeOfTests(){
        List<TypeOfTest> lTT = this.totStore.getTypeOfTestList();
        return TestTypeMapper.toDto(lTT);
    }
}
