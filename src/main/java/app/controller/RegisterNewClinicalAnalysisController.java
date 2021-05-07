package app.controller;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.store.ClinicalAnalysisLaboratoryStore;

import java.util.List;


public class RegisterNewClinicalAnalysisController {

        private ClinicalAnalysisLaboratoryStore cals;

        private ClinicalAnalysisLaboratory cal;
        public RegisterNewClinicalAnalysisController() {
        this(App.getInstance().getCompany().getClinicalAnalysisLaboratoryStore());
    }
        public RegisterNewClinicalAnalysisController(ClinicalAnalysisLaboratoryStore cals) {
            this.cals = cals;
            this.cal = null;
        }

        public boolean RegisterNewClinicalAnalysisLaboratory(String name, String phoneNumber, String laboratoryID, String tinNumber, String address){
            this.cal = this.cals.registerClinicalAnalysisLaboratory(name, phoneNumber, laboratoryID, tinNumber, address);
            return this.cals.validateClinicalAnalysisLaboratory(cal);
        }

        public boolean saveClinicalAnalysisLaboratory(){
            return this.cals.saveClinicalAnalysisLaboratory(cal);
        }

        public List<ClinicalAnalysisLaboratory> getClinicalAnalysisLaboratoryList(){
            return App.getInstance().getCompany().getClinicalAnalysisLaboratoryStore().getClinicalAnalysisLaboratoryList();
        }
    }
