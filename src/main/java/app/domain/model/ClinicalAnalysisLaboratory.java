package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/***
 * ClinicalAnalysisLaboratoryClass
 */

public class ClinicalAnalysisLaboratory {


    private String name;
    private String address;
    private String tinNumber;
    private String phoneNumber;
    private String laboratoryID;
    private int laboratoryCount = 0; //PERGUNTAR FORMATOOOOOOOOOOOOOOOOOOOOOOOOO
    List<ClinicalAnalysisLaboratory> laboratoryList = new ArrayList<>();

    static final int MAX_CHAR_NAME = 20;
    static final int PHONE_NUMBER_DIGITS = 11;
    static final int TIN_NUMBER_DIGITS = 10;
    static final int MAX_CHAR_LABORATORY_ID = 5;
    static final int MAX_CHAR_ADDRESS = 30;


    /***
     * Constructor for class ClinicalAnalysisLaboratory, complete
     * @param address
     * @param name
     * @param tinNumber
     * @param phoneNumber
     * @param laboratoryID
     */


    public ClinicalAnalysisLaboratory (String name, String phoneNumber, String laboratoryID, String tinNumber, String address) {
        setName(name);
        setTinNumber(tinNumber);
        setPhoneNumber(phoneNumber);
        setLaboratoryID(laboratoryID);
        setAddress(address);
    }

    /***
     * Verify if the given string just have numbers
     * @param number
     * @return
     */
    private boolean checkStringNumbers(String number) {
        if (!Pattern.matches("[a-zA-Z]+", number) && number.length() > 2) {
            return false;
        }
        return true;
    }

/*
    /***
     * Verify if the typeOfTest respect the imposed rules
     * @param typeOfTest

    private void checkTypeOfTestRules(String typeOfTest) {

*/

    /***
     * Method to get the Clinical Analysis Laboratory name
     * @return return he Clinical Analysis Laboratory name
     */
    public String getName(String name) {
        return name;
    }

    /***
     * Method that sets the name of the Clinical Analysis Laboratory
     * @param name
     */
    public void setName(String name) {
        if (name == null)
            throw new IllegalArgumentException("Name cannot be null");
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be blank");
        if (name.length() > MAX_CHAR_NAME)
            throw new IllegalArgumentException("Name cannot have more than 20 characters");
        for (int i = 0; i < name.length(); i++) {
            String d = String.valueOf(name.charAt(i));
            if (!d.matches("[A-Za-zÁ-Úá-ú]"))
                throw new IllegalArgumentException("Name has non alphanumeric chars.");
        }
        this.name = name;

    }

    /***
     * Method to get the Clinical Analysis Laboratory address
     * @return return he Clinical Analysis Laboratory address
     */
    public String getAddress(String address) {
        return address;
    }

    /***
     * Method that sets the address of the Clinical Analysis Laboratory
     * @param address
     */
    public void setAddress(String address) {
        if (address == null)
            throw new NullPointerException("Address cannot be null");
        if (address.length() > MAX_CHAR_ADDRESS)
            throw new IllegalArgumentException("Address cannot have more than 35 characters");
        if (StringUtils.isBlank(address))
            throw new IllegalArgumentException("Address cannot be blank");
        for (int i = 0; i < address.length(); i++) {
            String c = String.valueOf(address.charAt(i));
            if (!c.matches("[A-Za-z0-9]"))
                throw new IllegalArgumentException("Address has non alphanumeric chars.");
        }
        this.address = address;
    }


    /***
     * Method to get the Clinical Analysis Laboratory tinNumber
     * @return return he Clinical Analysis Laboratory tinNumber
     */
    public String getTinNumber(String tinNumber) {
        return tinNumber;
    }

    /***
     * Method that sets the tin number of the Client
     * @param tinNumber
     */
    public void setTinNumber(String tinNumber) {
        if (tinNumber == null)
            throw new NullPointerException("TIN number cannot be null");
        if (StringUtils.isBlank(tinNumber))
            throw new IllegalArgumentException("TIN number cannot be blank.");
        if ((!checkStringNumbers(tinNumber)) || tinNumber.length() != TIN_NUMBER_DIGITS)
            throw new IllegalArgumentException("TIN number must have 10 digit numbers.");
        this.tinNumber = tinNumber;
    }

    /***
     * Method that sets the phone number of the Client
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null)
            throw new NullPointerException("Phone number cannot be null");
        if (StringUtils.isBlank(phoneNumber))
            throw new IllegalArgumentException("Phone number cannot be blank.");
        if ((!checkStringNumbers(phoneNumber)) || phoneNumber.length() != PHONE_NUMBER_DIGITS)
            throw new IllegalArgumentException("Phone number must have 11 digit numbers.");
        this.phoneNumber = phoneNumber;
    }

    /***
     * Method that sets the laboratoryID of the Clinical Analysis Laboratory
     * @param laboratoryID
     */
    public void setLaboratoryID(String laboratoryID) {
        if (laboratoryID == null)
            throw new IllegalArgumentException("LaboratoryID cannot be null");
        if (StringUtils.isBlank(laboratoryID))
            throw new IllegalArgumentException("LaboratoryID cannot be blank");
        if (laboratoryID.length() > MAX_CHAR_LABORATORY_ID)
            throw new IllegalArgumentException("LaboratoryID cannot have more than 5 alphanumerical characters");
        for (int i = 0; i < laboratoryID.length(); i++) {
            String d = String.valueOf(laboratoryID.charAt(i));
            if (!d.matches("[A-Za-z0-9]"))
                throw new IllegalArgumentException("LaboratoryID has alphanumeric chars.");
        }
        this.laboratoryID = laboratoryID;

    }

    /***
     * Validate a Clinical Analysis Laboratory if it's not null
     * @param clinicalAnalysisLaboratory
     * @return
     */
    public static boolean validateClinicalAnalysisLaboratory(ClinicalAnalysisLaboratory clinicalAnalysisLaboratory) {
        return (clinicalAnalysisLaboratory.name != null
                && clinicalAnalysisLaboratory.tinNumber != null
                && clinicalAnalysisLaboratory.address != null
                && clinicalAnalysisLaboratory.phoneNumber != null
                && clinicalAnalysisLaboratory.laboratoryID != null);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;


        ClinicalAnalysisLaboratory clinicalAnalysisLaboratory = (ClinicalAnalysisLaboratory) o;
        return Objects.equals(name, clinicalAnalysisLaboratory.phoneNumber)
                && Objects.equals(tinNumber, clinicalAnalysisLaboratory.tinNumber)
                && Objects.equals(address, clinicalAnalysisLaboratory.address)
                && Objects.equals(phoneNumber, clinicalAnalysisLaboratory.phoneNumber)
                && Objects.equals(laboratoryID, clinicalAnalysisLaboratory.laboratoryID);
    }
}
