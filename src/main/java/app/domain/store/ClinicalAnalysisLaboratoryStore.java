package app.domain.store;

import app.domain.model.ClinicalAnalysisLaboratory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ClinicalAnalysisLaboratoryStore implements Serializable {


    private List<ClinicalAnalysisLaboratory> laboratoryList = new ArrayList<>();

    /**
     * Method that receives parameters from the associated controller to create a new clinical analysis laboratory
     *
     * @param name         of the clinical analysis laboratory
     * @param phoneNumber  of the clinical analysis laboratory
     * @param laboratoryID of the clinical analysis laboratory
     * @param tinNumber    of the clinical analysis laboratory
     * @param address      of the clinical analysis laboratory
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
            addClinicalAnalysisLaboratory(cal);
            serializeStore();
            return true;
        }
        return false;
    }

    private void serializeStore() {
        try{
            FileOutputStream out = new FileOutputStream("data\\calab.dat");
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(this.laboratoryList);
            outputStream.close();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
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

    public void setCALabList(List<ClinicalAnalysisLaboratory> lCALabs) {
        this.laboratoryList = new ArrayList<>(lCALabs);
    }
}
