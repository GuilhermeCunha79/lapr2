package app.domain.shared;


import app.domain.model.Client;
import org.apache.commons.lang3.StringUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.regex.Pattern;


/***
 * Common Methods Class
 */
public class CommonMethods {

    private CommonMethods() {
        throw new IllegalStateException("Utility class");
    }

    public static void serializeStore(List<?> list, String path) {
        try (FileOutputStream out = new FileOutputStream(path); ObjectOutputStream outputStream = new ObjectOutputStream(out)) {
            outputStream.writeObject(list);
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }

    /***
     * Verify if the given string just have numbers
     * @param number
     * @return if it was successfully added to the store (true or false)
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
     * count the number of words in a string
     * @param text
     * @return a number
     */
    public static int wordCounter(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }


    /***
     * Verify if the email given is a valid one
     * @param email
     * @return if it was successfully added to the store (true or false)
     */
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);


        if (email == null)
            throw new NullPointerException("No email inserted");
        if (StringUtils.isBlank(email))
            throw new IllegalArgumentException("No email introduced");


        return pat.matcher(email).matches();
    }

    /***
     * Validate a String if it just have letters and spaces
     * @param name
     * @return if it was successfully added to the store (true or false)
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
     * @return if it was successfully added to the store (true or false)
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
            throw new IllegalArgumentException(Constants.STRING_ADDRESS + Constants.STRING_NOT_MORE_THAN_30);
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
     * Prints a given List<Client>
     * @param list
     */
    public static void printList(List<Client> list){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

}
