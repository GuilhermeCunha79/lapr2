package app.domain.shared;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Constants {
    public static final String ROLE_ADMIN = "ADMINISTRATOR";
    public static final String ROLE_RECEPTIONIST = "RECEPTIONIST";
    public static final String ROLE_SPECIALIST_DOCTOR = "SPECIALIST DOCTOR";
    public static final String ROLE_CLIENT = "CLIENT";

    static final int PHONE_NUMBER_DIGITS = 11;
    static final int NHS_TIN_NUMBER_DIGITS = 10;
    static final int MAX_CHAR_NAME_EMPLOYEE_CLIENT= 35;
    public static final String STRING_BLANK_EXEPT =  " cannot be empty.";
    public static final String STRING_NULL_EXEPT =  " cannot be null.";
    public static final String NON_ALPHANUM_EXEPT =  " has non alphanumeric chars.";


    public static final String PARAMS_FILENAME = "config.properties";
    public static final String PARAMS_COMPANY_DESIGNATION = "Company.Designation";
}
