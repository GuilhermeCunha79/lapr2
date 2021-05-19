package app.domain.shared;

import java.security.SecureRandom;

public class PasswordGenerator {
    private static SecureRandom random = new SecureRandom();
    /***
     * Method that generate RANDOM
     * @return result
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
}
