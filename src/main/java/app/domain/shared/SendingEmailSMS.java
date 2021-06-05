package app.domain.shared;

import java.io.File;
import java.io.PrintWriter;

public class SendingEmailSMS {


    private static final String EMAIL_NOT_SENT_MESSAGE = "Email not sent";

    private SendingEmailSMS() {
        throw new IllegalStateException("Utility class");
    }
    /***
     * Method that sends a email with the password
     * @param name
     * @param password
     */
    public static void sendEmailWithPassword(String name, String email, String password) {
        File emailBox = new File("emailAndSMSMessages.txt");
        try (PrintWriter out = new PrintWriter(emailBox)) {
            out.printf("Hello %s,%nYou now can use your email and the following password to access Many Labs app: %n%nLogin data: %nEmail: %s%nPassword: %s", name, email, password);
        } catch (Exception e) {
            System.out.println(EMAIL_NOT_SENT_MESSAGE);
        }

    }

    /***
     * Method that sends an email informing that the test results are available
     * @param name
     * @param validatedAt
     */
    public static void sendEmailWithNotification(String name, DateTime validatedAt) {
        File emailBox = new File("emailAndSMSMessages.txt");
        try (PrintWriter out = new PrintWriter(emailBox)) {
            out.printf("Hello %s,%nYou can now access the application to check the results of your test! %s", name, validatedAt);
        } catch (Exception e) {
            System.out.println(EMAIL_NOT_SENT_MESSAGE);
        }

    }


    /***
     * Method that sends a email informing that the changes done to the client's profile have been saved successfully
     * @param name
     */
    public static void sendEmailWithChanges(String name) {
        File emailBox = new File("emailAndSMSMessages.txt");
        try (PrintWriter out = new PrintWriter(emailBox)) {
            out.printf("Hello %s,%n Your personal data has been changed with success!", name);
        } catch (Exception e) {
            System.out.println(EMAIL_NOT_SENT_MESSAGE);
        }

    }
}


























