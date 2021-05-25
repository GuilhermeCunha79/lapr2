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
        File emailBox = new File("emailAndSMSMessages.txt");
        PrintWriter out = null;
        try {
            out = new PrintWriter(emailBox);

            out.printf("Hello %s,%nYou now can use your email and the following password to access Many Labs app: %n%nLogin data: %nEmail: %s%nPassword: %s", name, email, password);
        }catch(Exception e){
            System.out.println("Email not send");
        }finally {
            if(out != null)
                out.close();
        }

    }

    /***
     * Method that sends a email with the password
     * @param name
     * @param name
     * @throws IOException
     */
    public static void sendEmailWithNotification(String name) {
        File emailBox = new File("emailAndSMSMessages.txt");
        PrintWriter out = null;
        try {
            out = new PrintWriter(emailBox);

            out.printf("Hello %s,%nYou now can acess the application to check the results of your test!", name);
            out.close();
        }catch(Exception e){
            System.out.println("Email not send");
        }finally {
            if(out != null)
                out.close();
        }

    }


}


























