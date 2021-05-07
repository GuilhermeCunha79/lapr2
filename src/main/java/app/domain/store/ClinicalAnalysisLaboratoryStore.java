package app.domain.store;

import app.domain.model.ClinicalAnalysisLaboratory;


import java.util.ArrayList;
import java.util.List;


public class ClinicalAnalysisLaboratoryStore {


      private   List<ClinicalAnalysisLaboratory> laboratoryList = new ArrayList<>();

        public ClinicalAnalysisLaboratory registerClinicalAnalysisLaboratory(String name, String phoneNumber, String laboratoryID, String tinNumber, String address){
                return new ClinicalAnalysisLaboratory(name, phoneNumber, laboratoryID, tinNumber, address);
        }

        public boolean saveClinicalAnalysisLaboratory(ClinicalAnalysisLaboratory cal){
                if(validateClinicalAnalysisLaboratory(cal)){
                        return addClinicalAnalysisLaboratory(cal);
                }
                return false;
        }


        public boolean addClinicalAnalysisLaboratory(ClinicalAnalysisLaboratory cal)
        {
                if (cal != null && validateClinicalAnalysisLaboratory(cal)) {
                        return this.laboratoryList.add(cal);
                }
                return false;
        }

        public boolean validateClinicalAnalysisLaboratory(ClinicalAnalysisLaboratory cl) {
                for (ClinicalAnalysisLaboratory cal : laboratoryList){
                        if(cal.equals(cl)){
                                return false;
                        }
                }
                return true;
        }

        public List<ClinicalAnalysisLaboratory> getClinicalAnalysisLaboratoryList() {
                return new ArrayList <>(laboratoryList);
        }

}
