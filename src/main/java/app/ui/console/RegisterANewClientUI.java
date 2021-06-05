package app.ui.console;

import app.controller.RegisterClientController;
import app.mappers.dto.ClientDTO;
import app.ui.console.utils.Utils;

public class RegisterANewClientUI implements Runnable {

    private RegisterClientController ctrl;


    @Override
    public void run() {
        ctrl = new RegisterClientController();

        boolean cltCreated = registerClient();
        if (cltCreated)
            Utils.printToConsole("\nClient successfully registered!");
    }

    public boolean registerClient() {
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
                ClientDTO dto = new ClientDTO(cltName, cltCitizenCardNumber, cltNhs, cltTin, cltDateOfBirth, cltSex, cltPhoneNumber, cltEmail);
                boolean created = ctrl.newClient(dto);
                if (created) {
                    Utils.printToConsole(String.format("\nConfirm the client data: %nName: %s%nCitizen Card Number: %s%nNHS Number: %s%nTIN Number: %s%nDate of Birth: %s%nSex: %s%nPhone Number: %s%nEmail: %s%n", cltName, cltCitizenCardNumber, cltNhs, cltTin, cltDateOfBirth, cltSex, cltPhoneNumber, cltEmail));

                    if (Utils.confirm("Y or N")) {
                        return ctrl.saveClient();

                    } else {
                        Utils.printToConsole("\nOperation cancelled");
                        return false;
                    }
                }
                Utils.printToConsole("Client already exists!");
                return false;

            } catch (Exception e) {
                Utils.printToConsole("");

                Utils.printToConsole("INFO: " + e.getLocalizedMessage());
            }
        } while (true);

    }
}
