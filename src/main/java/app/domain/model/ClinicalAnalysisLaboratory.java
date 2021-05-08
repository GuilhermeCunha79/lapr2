package app.domain.model;

import app.domain.shared.CommonMethods;
import app.domain.shared.Constants;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.regex.Pattern;

/***
 * ClinicalAnalysisLaboratoryClass
 */

public class ClinicalAnalysisLaboratory {


    static final int MAX_CHAR_NAME = 20;
    static final int MAX_CHAR_LABORATORY_ID = 5;
    static final int MAX_CHAR_ADDRESS = 30;
    private String name;
    private String address;
    private String tinNumber;
    private String phoneNumber;
    private String laboratoryID;
    private int laboratoryCount = 0; //PERGUNTAR FORMATOOOOOOOOOOOOOOOOOOOOOOOOO


    /***
     * Constructor for class ClinicalAnalysisLaboratory, complete
     * @param address
     * @param name
     * @param tinNumber
     * @param phoneNumber
     * @param laboratoryID
     */


    public ClinicalAnalysisLaboratory(String name, String phoneNumber, String laboratoryID, String tinNumber, String address) {
        setName(name);
        setTinNumber(tinNumber);
        setPhoneNumber(phoneNumber);
        setLaboratoryID(laboratoryID);
        setAddress(address);
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

/*
    /***
     * Verify if the typeOfTest respect the imposed rules
     * @param typeOfTest

    private void checkTypeOfTestRules(String typeOfTest) {

*/

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
            throw new NullPointerException("Name" + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name" + Constants.STRING_BLANK_EXEPT);
        if (name.length() > MAX_CHAR_NAME)
            throw new IllegalArgumentException("Name cannot have more than 20 characters");
        if (!CommonMethods.stringHaveAlphanumerical(name))
            throw new IllegalArgumentException("Name" + Constants.NON_ALPHANUM_EXEPT);
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
            throw new NullPointerException("Address" + Constants.STRING_NULL_EXEPT);
        if (address.length() > MAX_CHAR_ADDRESS)
            throw new IllegalArgumentException("Address cannot have more than 35 characters");
        if (StringUtils.isBlank(address))
            throw new IllegalArgumentException("Address" + Constants.STRING_BLANK_EXEPT);
        if (!CommonMethods.stringHaveAlphanumerical(address))
            throw new IllegalArgumentException("Address" + Constants.NON_ALPHANUM_EXEPT);
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
        CommonMethods.tinValidation(tinNumber);
        this.tinNumber = tinNumber;
    }

    /***
     * Method that sets the phone number of the Client
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        CommonMethods.phoneValidation(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    /***
     * Method that sets the laboratoryID of the Clinical Analysis Laboratory
     * @param laboratoryID
     */
    public void setLaboratoryID(String laboratoryID) {
        if (laboratoryID == null)
            throw new NullPointerException("LaboratoryID" + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(laboratoryID))
            throw new IllegalArgumentException("LaboratoryID" + Constants.STRING_BLANK_EXEPT);
        if (laboratoryID.length() > MAX_CHAR_LABORATORY_ID)
            throw new IllegalArgumentException("LaboratoryID cannot have more than 5 alphanumerical characters");
        if (!CommonMethods.stringHaveAlphanumerical(laboratoryID))
            throw new IllegalArgumentException("LaboratoryID" + Constants.NON_ALPHANUM_EXEPT);
        this.laboratoryID = laboratoryID;

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
