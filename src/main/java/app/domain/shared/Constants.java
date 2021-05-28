package app.domain.shared;

/***
 * Constants Class
 */

public class Constants {

    //ROLES
    public static final String ROLE_ADMIN = "ADMINISTRATOR";
    public static final String ROLE_RECEPTIONIST = "RECEPTIONIST";
    public static final String ROLE_SPECIALIST_DOCTOR = "SPECIALIST DOCTOR";
    public static final String ROLE_CLIENT = "CLIENT";
    public static final String ROLE_LAB_COORDINATOR = "LAB COORDINATOR";

    //PARAMETERS NAMES
    public static final String STRING_NAME = "Name";
    public static final String STRING_CODE = "Code";
    public static final String STRING_EMAIL = "Email";
    public static final String STRING_SHORT_NAME= "Short Name";
    public static final String STRING_DESCRIPTION= "Description";
    public static final String STRING_PHONE_NUMBER = "Phone Number";
    public static final String STRING_ADDRESS = "Address";
    public static final String STRING_TIN_NUMBER = "TIN Number";
    public static final String STRING_DOC_INDEX_NUMB = "Doctor Index Number";
    public static final String STRING_NHS_CODE = "NhsCode";

    //PARAMETER DIGITS
    public static final int ADDRESS_DIGITS = 30;
    public static final int CODE_DIGITS = 5;
    public static final int PHONE_NUMBER_DIGITS = 11;
    public static final int NHS_TIN_NUMBER_DIGITS = 10;
    public static final int CHAR_NAME_EMPLOYEE_CLIENT = 35;

    //PARAMETER MAX DIGITS
    public static final String STRING_NOT_MORE_THAN_10 = " cannot have more than 10 characters.";
    public static final String STRING_NOT_MORE_THAN_20 = " cannot have more than 20 characters.";
    public static final String STRING_NOT_MORE_THAN_30 = " cannot have more than 30 characters.";
    public static final String STRING_NOT_MORE_THAN_35 = " cannot have more than 35 characters.";
    public static final String STRING_NOT_MORE_THAN_12 = " cannot have more than 12 characters.";

    //COMMON ERRORS
    public static final String STRING_BLANK_EXEPT = " cannot be empty.";
    public static final String STRING_NULL_EXEPT = " cannot be null.";
    public static final String NON_ALPHANUM_EXEPT = " has non alphanumeric chars.";
    public static final String PARAMS_FILENAME = "config.properties";
    public static final String PARAMS_COMPANY_DESIGNATION = "Company.Designation";

    /***
     *
     */
    private Constants() {
        throw new IllegalStateException("Utility class");
    }
}
