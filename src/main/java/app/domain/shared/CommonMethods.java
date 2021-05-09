package app.domain.shared;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.regex.Pattern;


/***
 * Common Methods Class
 */
public class CommonMethods {

    private CommonMethods() {
        throw new IllegalStateException("Utility class");
    }

    private static SecureRandom random = new SecureRandom();

    /***
     * Verify if the given string just have numbers
     * @param number
     * @return
     */
    public static boolean checkIfStringJustHaveNumbers(String number) {
        int numberq = 0;
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                numberq++;
            } else {
                return false;
            }
        }
        return numberq == number.length();
    }


    /***
     * Verify if the email given is a valid one
     * @param email
     * @return
     */
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    /***
     * Validate a String if it just have letters and spaces
     * @param name
     * @return
     */
    public static boolean isValidString(String name) {
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (Character.isLetter(ch) || ch == ' ') {
                continue;
            }
            return false;
        }
        return true;
    }

    /***
     *  Check if a string contains alphanumerical characters
     * @param name
     * @return
     */
    public static boolean stringHaveAlphanumerical(String name) {
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (Character.isLetterOrDigit(ch) || ch == ' ') {
                continue;
            }
            return false;
        }
        return true;
    }

    /***
     * Method that genrate RANDOM
     * @return
     */
    public static String generatePassword() {
        int len = 10;
        String alphanumericChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String result = "";
        for (int i = 0; i < len; i++) {
            int index = random.nextInt(alphanumericChars.length());
            result += alphanumericChars.charAt(index);
        }
        return result;
    }

    /***
     * Validate a string (name) by testing the string with some imposed rules
     * @param name
     */
    public static void nameClientEmployeeValidation(String name) {
        if (name == null)
            throw new NullPointerException(Constants.STRING_NAME + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException(Constants.STRING_NAME + Constants.STRING_BLANK_EXEPT);
        if (name.length() > Constants.CHAR_NAME_EMPLOYEE_CLIENT)
            throw new IllegalArgumentException(Constants.STRING_NAME + Constants.STRING_NOT_MORE_THAN_35);
        if (!isValidString(name))
            throw new IllegalArgumentException(Constants.STRING_NAME + Constants.NON_ALPHANUM_EXEPT);
    }


    /***
     * Validate a string (email) by testing the string with some imposed rules
     * @param email
     */
    public static void emailValidation(String email) {
        if (email == null)
            throw new NullPointerException(Constants.STRING_EMAIL + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(email))
            throw new IllegalArgumentException(Constants.STRING_EMAIL + Constants.STRING_BLANK_EXEPT);
        if (!isValidEmail(email))
            throw new IllegalArgumentException("The introduced " + Constants.STRING_EMAIL + " is not valid.");
    }

    /***
     * Validate a string (code) by testing the string with some imposed rules
     * @param code
     */
    public static void codeValidation(String code) {
        if (code == null)
            throw new NullPointerException(Constants.STRING_CODE + Constants.STRING_NULL_EXEPT);
        if (code.length() != Constants.CODE_DIGITS)
            throw new IllegalArgumentException(Constants.STRING_CODE + " needs to have exactly 5 characters");
        if (StringUtils.isBlank(code))
            throw new IllegalArgumentException(Constants.STRING_CODE + Constants.STRING_BLANK_EXEPT);
        if (!CommonMethods.stringHaveAlphanumerical(code))
            throw new IllegalArgumentException(Constants.STRING_CODE + Constants.NON_ALPHANUM_EXEPT);
    }

    /***
     * Validate a string (phoneNumber) by testing the string with some imposed rules
     * @param phoneNumber
     */
    public static void phoneValidation(String phoneNumber) {
        if (phoneNumber == null)
            throw new NullPointerException(Constants.STRING_PHONE_NUMBER + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(phoneNumber))
            throw new IllegalArgumentException(Constants.STRING_PHONE_NUMBER + Constants.STRING_BLANK_EXEPT);
        if (!(checkIfStringJustHaveNumbers(phoneNumber)) || phoneNumber.length() != Constants.PHONE_NUMBER_DIGITS)
            throw new IllegalArgumentException(Constants.STRING_PHONE_NUMBER + " must have 11 digit numbers.");
    }

    /***
     * Validate a string (address) by testing the string with some imposed rules
     * @param address
     */
    public static void addressValidation(String address) {
        if (address == null)
            throw new NullPointerException(Constants.STRING_ADDRESS + Constants.STRING_NULL_EXEPT);
        if (address.length() > Constants.ADDRESS_DIGITS)
            throw new IllegalArgumentException(Constants.STRING_ADDRESS + " cannot have more than 35 characters");
        if (StringUtils.isBlank(address))
            throw new IllegalArgumentException(Constants.STRING_ADDRESS + Constants.STRING_BLANK_EXEPT);
        if (!CommonMethods.stringHaveAlphanumerical(address))
            throw new IllegalArgumentException(Constants.STRING_ADDRESS + Constants.NON_ALPHANUM_EXEPT);
    }

    /***
     * Validate a string (tinNumber) by testing the string with some imposed rules
     * @param tinNumber
     */
    public static void tinValidation(String tinNumber) {
        if (tinNumber == null)
            throw new NullPointerException(Constants.STRING_TIN_NUMBER + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(tinNumber))
            throw new IllegalArgumentException(Constants.STRING_TIN_NUMBER + Constants.STRING_BLANK_EXEPT);
        if ((!checkIfStringJustHaveNumbers(tinNumber) || tinNumber.length() != Constants.NHS_TIN_NUMBER_DIGITS))
            throw new IllegalArgumentException(Constants.STRING_TIN_NUMBER + Constants.STRING_NOT_MORE_THAN_10);
    }

    /***
     * Method that sends a email with the password
     * @param name
     * @param password
     * @throws IOException
     */
    public static void sendEmailWithPassword(String name, String password) throws IOException {
        File email = new File("SMS_EMAIL\\email.txt");
        PrintWriter out = new PrintWriter(email);

        out.printf("Hello %s,%nYou now can use your email and the following password to access Many Labs app: %n%n%s", name, password);
        out.close();
    }
}
