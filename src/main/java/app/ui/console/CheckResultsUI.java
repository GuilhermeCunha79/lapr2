package app.ui.console;

import app.controller.CheckResultsController;


import app.ui.console.utils.Utils;

import java.util.List;

public class CheckResultsUI implements Runnable {

    private final CheckResultsController ctrl = new CheckResultsController();


    @Override
    public void run() {
        boolean repeat;
        do {
            repeat = checkProcess();
        } while (repeat && Utils.confirm("Check another client test details? (Y or N)"));
    }

    private boolean checkProcess() {
        while (true) {
            try {
                List<String> lClientDto = ctrl.showClients();
                if (lClientDto != null) {
                    int option = Utils.showAndSelectIndex(lClientDto, "Select one of the following clients:");
                    System.out.println(lClientDto);
                    String results = ctrl.getClientList(lClientDto.get(option).substring(lClientDto.get(option).lastIndexOf("TIN Number: ")+1,lClientDto.get(option).lastIndexOf("TIN Number: ")+10));
                    Utils.printToConsole(results);
                        return true;
                    }
                    return false;
            } catch (Exception e) {
                Utils.printToConsole("INFO: " + e.getMessage());
            }
        }
    }
}
