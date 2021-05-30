package app.domain.shared;

import java.security.SecureRandom;

public class PasswordGenerator {
    private static SecureRandom random = new SecureRandom();

    private PasswordGenerator() {
        throw new IllegalStateException("Utility class");
    }
    /***
     * Method that generate RANDOM passwords
     * @return a password
     */
    public static String generatePassword() {
        int len = 10;
        String alphanumericChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int index = random.nextInt(alphanumericChars.length());
            result.append(alphanumericChars.charAt(index));
        }
        return result.toString();
    }
}
