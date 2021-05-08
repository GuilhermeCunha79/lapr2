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
    private String name;
    private String address;
    private String tinNumber;
    private String phoneNumber;
    private String laboratoryID;
    private int laboratoryCount = 0;
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
        laboratoryCount++;
        setName(name);
        setTinNumber(tinNumber);
        setPhoneNumber(phoneNumber);
        setLaboratoryID(laboratoryID);
        setAddress(address);
        this.typeOfTestList = typeOfTestList;
    }



    private String employeeIdCreator() {
        StringBuilder nameInitials = new StringBuilder();
        if (this.name != null) {
            for (int i = 0; i < this.name.length(); i++) {
                char letter = this.name.charAt(i);
                if (Character.isUpperCase(letter)) {
                    nameInitials.append(letter);
                }
            }
        }
        return String.format("%s%05d", nameInitials, laboratoryCount);
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
        public String getName (String name){
            return name;
        }

        /***
         * Method that sets the name of the Clinical Analysis Laboratory
         * @param name
         */
        public void setName (String name){
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
                throw new NullPointerException("LaboratoryID" + Constants.STRING_NULL_EXEPT);
            if (StringUtils.isBlank(laboratoryID))
                throw new IllegalArgumentException("LaboratoryID" + Constants.STRING_BLANK_EXEPT);
            if (laboratoryID.length() > MAX_CHAR_LABORATORY_ID)
                throw new IllegalArgumentException("LaboratoryID cannot have more than 5 alphanumerical characters");
            this.laboratoryID = laboratoryID; //Verificaaaaaaaaaaaaaaaaaaaaaaaaaaaar

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

