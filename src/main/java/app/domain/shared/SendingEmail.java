package app.domain.shared;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class SendingEmail {
    /***
     * Method that sends a email with the password
     * @param name
     * @param password
     * @throws IOException
     */
    public static void sendEmailWithPassword(String name, String password) {
        try {
            File email = new File("email.txt");
            PrintWriter out = new PrintWriter(email);

            out.printf("Hello %s,%nYou now can use your email and the following password to access Many Labs app: %n%n%s", name, password);
            out.close();
        }catch(Exception e){
            System.out.println("Email not send");
        }

    }
}
