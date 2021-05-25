package app.domain.store;

import app.domain.model.ClinicalAnalysisLaboratory;

import java.util.ArrayList;
import java.util.List;


public class ClinicalAnalysisLaboratoryStore {


    private final List<ClinicalAnalysisLaboratory> laboratoryList = new ArrayList<>();

    /**
     * Method that receives parameters from the associated controller to create a new clinical analysis laboratory
     *
     * @param name           of the clinical analysis laboratory
     * @param phoneNumber    of the clinical analysis laboratory
     * @param laboratoryID   of the clinical analysis laboratory
     * @param tinNumber      of the clinical analysis laboratory
     * @param address        of the clinical analysis laboratory
     * @return the parameter clinical analysis laboratory
     */
    public ClinicalAnalysisLaboratory registerClinicalAnalysisLaboratory(String laboratoryID, String name, String address, String phoneNumber, String tinNumber) {
        return new ClinicalAnalysisLaboratory(laboratoryID, name, address, phoneNumber, tinNumber);
    }

    /**
     * This method validates the clinical analysis laboratory received by parameter and adds it to the ClinicalAnalysisLaboratoryStore by calling the method addClinicalAnalysisLaboratory
     *
     * @param cal ClinicalAnalysisLaboratory that will be added
     * @return if it was successfully added to the store (true or false)
     */
    public boolean saveClinicalAnalysisLaboratory(ClinicalAnalysisLaboratory cal) {
        if (cal != null && validateClinicalAnalysisLaboratory(cal)) {
            return addClinicalAnalysisLaboratory(cal);
        }
        return false;
    }

    /**
     * Method responsible to add a new clinical analysis laboratory to the list when asked by the saveClinicalAnalysisLaboratory method
     *
     * @param cal receives the Clinical Analysis Laboratory to be added
     * @return if it was successfully added to the store (true or false)
     */

    private boolean addClinicalAnalysisLaboratory(ClinicalAnalysisLaboratory cal) {
            return this.laboratoryList.add(cal);
    }

    /**
     * Method responsible to validate a new clinical analysis laboratory before it's added to the list when called by the saveClinicalAnalysisLaboratory method
     *
     * @param cal receives the Clinical Analysis Laboratory to be added
     * @return if it was successfully added to the store (true or false)
     */

    public boolean validateClinicalAnalysisLaboratory(ClinicalAnalysisLaboratory cal) {
        for (ClinicalAnalysisLaboratory calCal : laboratoryList) {
            if (calCal.equals(cal)) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method return a copy of the Clinical Analysis Laboratory List for other classes that need to access it
     *
     * @return List of laboratories
     */

    public List<ClinicalAnalysisLaboratory> getClinicalAnalysisLaboratoryList() {
        return new ArrayList<>(laboratoryList);
    }

}
