package app.domain.shared;

import java.util.regex.Pattern;

public class CommonMethods {
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
     */
    public static boolean stringHaveAlphanumerical(String name) {
        for (int i = 0; i < name.length(); i++) {
            String c = String.valueOf(name.charAt(i));
            if (!c.matches("[A-Za-z0-9]")) {
                return false;
            }
        }
        return true;
    }
}
