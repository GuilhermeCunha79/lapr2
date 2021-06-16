package app.ui.console;

import app.controller.ChangeClientDataController;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ClientChangesUI implements Runnable {
    private final ChangeClientDataController ctrl = new ChangeClientDataController();

    @Override
    public void run() {
        boolean repeat;
        do {
            repeat = clientChanges();
        } while (repeat && Utils.confirm("\nDo you want to do another changes? (Y/N)"));
        if (repeat)
            Utils.printToConsole("\n\nChanges saved successfully!");
    }

    public boolean clientChanges() {
        Utils.printToConsole(ctrl.showData(ctrl.getClientByEmail()));

        int option = dataOptions();
        try {
            switch (option) {
                case 0: {
                    String cltName = Utils.readLineFromConsole("Introduce the new name: ");
                    ctrl.changeName(ctrl.getClientByEmail(), cltName);
                    break;
                }

                case 1: {
                    String cltSex = Utils.readLineFromConsole("Introduce the Sex: ");
                    ctrl.changeSex(ctrl.getClientByEmail(), cltSex);
                    break;
                }

                case 2: {
                    String cltPhoneNumber = Utils.readLineFromConsole("Introduce the new Phone Number: ");
                    if (!ctrl.changePhoneNumber(ctrl.getClientByEmail(), cltPhoneNumber) || saveChanges())
                        Utils.printToConsole("\nINFO: Phone number belongs to another client!");

                    break;
                }

                case 3: {
                    String cltAddress = Utils.readLineFromConsole("Introduce the new Address: ");
                    ctrl.changeAddress(ctrl.getClientByEmail(), cltAddress);
                    break;
                }

            }

        } catch (Exception e) {
            Utils.printToConsole(e.getMessage());
        }
        return false;
    }


    private int dataOptions() {
        List<String> options = new ArrayList<>();
        options.add("Name");
        options.add("Birth Date");
        options.add("Sex");
        options.add("Phone Number");

        return Utils.showAndSelectIndex(options, "Select the data that you want to change:");
    }

    public boolean saveChanges() {
        Utils.printToConsole("\nDo you confirm this change?");
        if (Utils.confirm("Y or N")) {
            if (ctrl.saveChanges()) {
                System.out.println("Changes made");
                return true;
            }
        } else {
            Utils.printToConsole("Change aborted!");
            return false;
        }
        return false;
    }

}
