package app.domain.shared;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class SendingEmailSMS {
    private SendingEmailSMS() {
        throw new IllegalStateException("Utility class");
    }
    /***
     * Method that sends a email with the password
     * @param name
     * @param password
     * @throws IOException
     */
    public static void sendEmailWithPassword(String name, String email, String password) {
        try {
            File emailBox = new File("emailAndSMSMessages.txt");
            PrintWriter out = new PrintWriter(emailBox);

            out.printf("Hello %s,%nYou now can use your email and the following password to access Many Labs app: %n%nLogin data: %nEmail: %s%nPassword: %s", name, email, password);
            out.close();
        }catch(Exception e){
            System.out.println("Email not send");
        }

    }
}


























