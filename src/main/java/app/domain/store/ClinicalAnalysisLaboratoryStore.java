package app.domain.store;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.model.TypeOfTest;


import java.util.ArrayList;
import java.util.List;


public class ClinicalAnalysisLaboratoryStore {


      private List<ClinicalAnalysisLaboratory> laboratoryList = new ArrayList<>();

    /**
     * Method that receives parameters from the associated controller to create a new clinical analysis laboratory
     * @param name of the clinical analysis laboratory
     * @param phoneNumber of the clinical analysis laboratory
     * @param laboratoryID of the clinical analysis laboratory
     * @param tinNumber of the clinical analysis laboratory
     * @param address of the clinical analysis laboratory
     * @param typeOfTestList of the clinical analysis laboratory
     * @return the parameter clinical analysis laboratory
     */
        public ClinicalAnalysisLaboratory registerClinicalAnalysisLaboratory(String name, String phoneNumber, String laboratoryID, String tinNumber, String address, List<TypeOfTest> typeOfTestList){
                return new ClinicalAnalysisLaboratory(name, phoneNumber, laboratoryID, tinNumber, address, typeOfTestList);
        }

    /**
     * This method validates the clinical analysis laboratory received by parameter and adds it to the ClinicalAnalysisLaboratoryStore by calling the method addClinicalAnalysisLaboratory
     * @param cal ClinicalAnalysisLaboratory that will be added
     * @return if it was successfully added to the store (true or false)
     */
        public boolean saveClinicalAnalysisLaboratory(ClinicalAnalysisLaboratory cal){
                if(validateClinicalAnalysisLaboratory(cal)){
                        return addClinicalAnalysisLaboratory(cal);
                }
                return false;
        }

    /**
     * Method responsible to add a new clinical analysis laboratory to the list when asked by the saveClinicalAnalysisLaboratory method
     * @param cal receives the Clinical Analysis Laboratory to be added
     * @return if it was successfully added to the store (true or false)
     */

        public boolean addClinicalAnalysisLaboratory(ClinicalAnalysisLaboratory cal)
        {
                if (cal != null && validateClinicalAnalysisLaboratory(cal)) {
                        return this.laboratoryList.add(cal);
                }
                return false;
        }

    /**
     * Method responsible to validate a new clinical analysis laboratory before it's added to the list when called by the saveClinicalAnalysisLaboratory method
     * @param cal receives the Clinical Analysis Laboratory to be added
     * @return if it was successfully added to the store (true or false)
     */

        public boolean validateClinicalAnalysisLaboratory(ClinicalAnalysisLaboratory cal) {
                for (ClinicalAnalysisLaboratory calCal : laboratoryList){
                        if(calCal.equals(cal)){
                                return false;
                        }
                }
                return true;
        }

    /**
     * This method return a copy of the Clinical Analysis Laboratory List for other classes that need to access it
     * @return List of laboratories
     */

        public List<ClinicalAnalysisLaboratory> getClinicalAnalysisLaboratoryList() { return new ArrayList <>(laboratoryList);
        }

}
