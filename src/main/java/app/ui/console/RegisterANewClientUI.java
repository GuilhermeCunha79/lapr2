package app.ui.console;


import app.controller.RegisterClientController;
import app.ui.console.utils.Utils;
import java.util.Objects;

public class RegisterANewClientUI implements Runnable {

    private RegisterClientController ctrl;

    @Override
    public void run() {
        ctrl = new RegisterClientController();

        boolean cltCreated = registerClient();
        if (cltCreated)
            System.out.println("\n\nClient successfully registered!");
    }

    public boolean registerClient() {
        boolean done = false;
        do {
            try {
                String cltName = Utils.readLineFromConsole("Introduce the client's name: ");
                String cltCitizenCardNumber = Utils.readLineFromConsole("Introduce client's citizen card number: ");
                String cltNhs = Utils.readLineFromConsole("Introduce client's NHS number: ");
                String cltTin = Utils.readLineFromConsole("Introduce client's TIN number: ");
                String cltDateOfBirth = Utils.readLineFromConsole("Introduce client's birth date: ");
                String cltSex = Utils.readLineFromConsole("Introduce client's sex: ");
                String cltPhoneNumber = Utils.readLineFromConsole("Introduce client's phone number: ");
                String cltEmail = Utils.readLineFromConsole("Introduce client's email: ");

                boolean created = ctrl.newClient(cltName, cltCitizenCardNumber, cltNhs, cltTin, cltDateOfBirth, cltSex, cltPhoneNumber, cltEmail);
                if (created) {
                    System.out.printf("\nConfirm the client data: %nName: %s%nCitizen Card Number: %s%nNHS Number: %s%nTIN Number: %s%nDate of Birth: %s%nSex: %s%nPhone Number: %s%nEmail: %s%n", cltName, cltCitizenCardNumber, cltNhs, cltTin, cltDateOfBirth, cltSex, cltPhoneNumber, cltEmail);

                    if (Objects.requireNonNull(Utils.readLineFromConsole("Y or N:")).equalsIgnoreCase("y")) {
                        return ctrl.saveClient();

                    } else {
                        System.out.println("\nOperation cancelled");
                        return false;
                    }
                }

                System.out.println("Client already exists!");
                return false;

            } catch (Exception e) {
                System.out.println();

                System.out.println(e.getLocalizedMessage());
            }
        } while (true);

    }
}
