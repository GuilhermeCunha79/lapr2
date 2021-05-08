package app.domain.shared;

import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.logging.Formatter;
import java.util.regex.Pattern;

public class CommonMethods {


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
        if (numberq == number.length())
            return true;
        return false;
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
     *
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

    public static void nameClientEmployeeValidation(String name) {
        if (name == null)
            throw new NullPointerException("Name" + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name" + Constants.STRING_BLANK_EXEPT);
        if (name.length() > Constants.CHAR_NAME_EMPLOYEE_CLIENT)
            throw new IllegalArgumentException("Name cannot have more than 35 characters");
        if (!isValidString(name))
            throw new IllegalArgumentException("Name" + Constants.NON_ALPHANUM_EXEPT);
    }

    public static void emailValidation(String email) {
        if (email == null)
            throw new NullPointerException("Email" + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(email))
            throw new IllegalArgumentException("Email" + Constants.STRING_BLANK_EXEPT);
        if (!isValidEmail(email))
            throw new IllegalArgumentException("The introduced email is not valid.");
    }

    public static void codeValidation(String code) {
        if (code == null)
            throw new NullPointerException("Code" + Constants.STRING_NULL_EXEPT);
        if (code.length() != Constants.CODE_DIGITS)
            throw new IllegalArgumentException("Code needs to have exactly 5 characters");
        if (StringUtils.isBlank(code))
            throw new IllegalArgumentException("Code" + Constants.STRING_BLANK_EXEPT);
        if (!CommonMethods.stringHaveAlphanumerical(code))
            throw new IllegalArgumentException("Code" + Constants.NON_ALPHANUM_EXEPT);
    }

    public static void phoneValidation(String phoneNumber) {
        if (phoneNumber == null)
            throw new NullPointerException("Phone Number" + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(phoneNumber))
            throw new IllegalArgumentException("Phone Number" + Constants.STRING_BLANK_EXEPT);
        if (!(checkIfStringJustHaveNumbers(phoneNumber)) || phoneNumber.length() != Constants.PHONE_NUMBER_DIGITS)
            throw new IllegalArgumentException("Phone Number must have 11 digit numbers.");
    }

    public static void addressValidation(String address) {
        if (address == null)
            throw new NullPointerException("Address" + Constants.STRING_NULL_EXEPT);
        if (address.length() > Constants.ADDRESS_DIGITS)
            throw new IllegalArgumentException("Address cannot have more than 35 characters");
        if (StringUtils.isBlank(address))
            throw new IllegalArgumentException("Address" + Constants.STRING_BLANK_EXEPT);
        if (!CommonMethods.stringHaveAlphanumerical(address))
            throw new IllegalArgumentException("Address" + Constants.NON_ALPHANUM_EXEPT);
    }

    public static void tinValidation(String tinNumber) {
        if (tinNumber == null)
            throw new NullPointerException("TIN number" + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(tinNumber))
            throw new IllegalArgumentException("TIN number" + Constants.STRING_BLANK_EXEPT);
        if ((!checkIfStringJustHaveNumbers(tinNumber) || tinNumber.length() != Constants.NHS_TIN_NUMBER_DIGITS))
            throw new IllegalArgumentException("TIN number must have 10 digit numbers.");
    }
}
