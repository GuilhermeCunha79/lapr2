package app.domain.model;

import app.domain.shared.CommonMethods;
import app.domain.shared.Constants;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;


/***
 * ClinicalAnalysisLaboratoryClass
 */

public class ClinicalAnalysisLaboratory {


    static final int MAX_CHAR_NAME = 20;
    static final int MAX_CHAR_LABORATORY_ID = 5;
    static final String STRING_LAB_ID = "Laboratory ID";
    private String name;
    private String address;
    private String tinNumber;
    private String phoneNumber;
    private String laboratoryID;
    private final List<TypeOfTest> typeOfTestList;


    /***
     * Constructor for class ClinicalAnalysisLaboratory, complete
     * @param address
     * @param name
     * @param tinNumber
     * @param phoneNumber
     * @param laboratoryID
     * @param typeOfTestList
     */


    public ClinicalAnalysisLaboratory(String name, String phoneNumber, String laboratoryID, String tinNumber, String address, List<TypeOfTest> typeOfTestList) {
        setName(name);
        setTinNumber(tinNumber);
        setPhoneNumber(phoneNumber);
        setLaboratoryID(laboratoryID);
        setAddress(address);
        this.typeOfTestList = typeOfTestList;
    }

    /***
     * Method that checks if a string just have numbers and digits
     * @param str
     * @return
     */
    public static boolean onlyDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
        /***
         * Method to get the Clinical Analysis Laboratory name
         * @return return he Clinical Analysis Laboratory name
         */
        public String getName (String name){
            return name;
        }

        /***
         * Method that sets the name of the Clinical Analysis Laboratory
         * @param name
         */
        public void setName (String name){
            if (name == null)
                throw new NullPointerException(Constants.STRING_NAME + Constants.STRING_NULL_EXEPT);
            if (StringUtils.isBlank(name))
                throw new IllegalArgumentException(Constants.STRING_NAME + Constants.STRING_BLANK_EXEPT);
            if (name.length() > MAX_CHAR_NAME)
                throw new IllegalArgumentException(Constants.STRING_NAME + Constants.STRING_NOT_MORE_THAN_20);
            if (!CommonMethods.stringHaveAlphanumerical(name))
                throw new IllegalArgumentException(Constants.STRING_NAME + Constants.NON_ALPHANUM_EXEPT);
            this.name = name;
        }

        /***
         * Method to get the Clinical Analysis Laboratory address
         * @return return he Clinical Analysis Laboratory address
         */
        public String getAddress (String address){
            return address;
        }

        /***
         * Method that sets the address of the Clinical Analysis Laboratory
         * @param address
         */
        public void setAddress (String address){
            CommonMethods.addressValidation(address);
            this.address = address;
        }

        /***
         * Method to get the Clinical Analysis Laboratory tinNumber
         * @return return he Clinical Analysis Laboratory tinNumber
         */
        public String getTinNumber (String tinNumber){
            return tinNumber;
        }

        /***
         * Method that sets the tin number of the Client
         * @param tinNumber
         */
        public void setTinNumber (String tinNumber){
            CommonMethods.tinValidation(tinNumber);
            this.tinNumber = tinNumber;
        }

        /***
         * Method that sets the phone number of the Client
         * @param phoneNumber
         */
        public void setPhoneNumber (String phoneNumber){
            CommonMethods.phoneValidation(phoneNumber);
            this.phoneNumber = phoneNumber;
        }

        /***
         * Method that sets the laboratoryID of the Clinical Analysis Laboratory
         * @param laboratoryID
         */
        public void setLaboratoryID (String laboratoryID){
            if (laboratoryID == null)
                throw new NullPointerException(STRING_LAB_ID + Constants.STRING_NULL_EXEPT);
            if (StringUtils.isBlank(laboratoryID))
                throw new IllegalArgumentException(STRING_LAB_ID + Constants.STRING_BLANK_EXEPT);
            if (laboratoryID.length() > MAX_CHAR_LABORATORY_ID)
                throw new IllegalArgumentException(STRING_LAB_ID + " cannot have more than 5 alphanumerical characters");
            if(onlyDigits(laboratoryID))
                throw new IllegalArgumentException(STRING_LAB_ID + " cannot have characters different than 5 alphanumerical");
            this.laboratoryID = laboratoryID;

        }

        private String printTypeOfTestList () {
            String output = "Type of Tests List:" + System.lineSeparator();
            if (typeOfTestList != null && typeOfTestList.size() > 0) {
                for (int i = 0; i < typeOfTestList.size(); i++) {
                    typeOfTestList.get(i).toString();
                    output = output.concat(typeOfTestList.get(i).toString());
                    output = output.concat(System.lineSeparator());
                }
            } else {
                output.concat("No Type of Tests");
            }
            return output;
        }

        @Override
        public boolean equals (Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass())
                return false;


            ClinicalAnalysisLaboratory clinicalAnalysisLaboratory = (ClinicalAnalysisLaboratory) o;
            return Objects.equals(name, clinicalAnalysisLaboratory.name)
                    && Objects.equals(phoneNumber, clinicalAnalysisLaboratory.phoneNumber)
                    && Objects.equals(laboratoryID, clinicalAnalysisLaboratory.laboratoryID)
                    && Objects.equals(tinNumber, clinicalAnalysisLaboratory.tinNumber)
                    && Objects.equals(address, clinicalAnalysisLaboratory.address)
                    && Objects.equals(typeOfTestList, clinicalAnalysisLaboratory.typeOfTestList);
        }

        @Override
        public String toString () {
            return String.format("Clinical Analysis Laboratory:%nName: %s%nPhone Number: %s%nLaboratory ID: %s%nTIN number: %s%nAddress: %s%n %s",
                    this.name, this.phoneNumber, this.laboratoryID, this.tinNumber, this.address, this.printTypeOfTestList());
        }
    }

