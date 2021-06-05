package app.ui.console;

import app.controller.RegisterSampleController;


import app.ui.console.utils.Utils;
import net.sourceforge.barbecue.Barcode;

import java.util.ArrayList;
import java.util.List;



public class RegisterSampleUI implements Runnable {

    private RegisterSampleController ctrl = new RegisterSampleController();
    private final String labId;

    public RegisterSampleUI(String labId) {
        this.labId = labId;
    }

    /**
     * This method initiates the register sample process
     */
    @Override
    public void run() {
        ctrl = new RegisterSampleController();
        boolean repeat;
        do {
            repeat = recordSample();
        } while (repeat && Utils.confirm("Register sample for another test? (Y/N)"));

    }

    /**
     * This method is responsible to guide the user through the test selection and sample registration process
     * @return false if its not possible to register a sample due to not having more tests
     * needing samples, return true when there are tests still needing samples
     */
    private boolean recordSample() {
        while (true){
            try {
                List<String> lTestDto = ctrl.getTestWithoutSample();
                if (lTestDto != null) {
                    int option = Utils.showAndSelectIndex(lTestDto, "Select one of the following tests:");
                    String data = ctrl.getData(lTestDto.get(option).substring(15, 27));
                    Utils.printToConsole(data);
                    int n = Utils.readIntegerFromConsole("Write the number of samples below:");
                    List<Barcode> sampleList = new ArrayList<>(n);
                    while (sampleList.isEmpty()) {
                        Barcode barcode =ctrl.createUPCA(data);
                        sampleList.add(barcode);
                    }
                    Utils.confirm(String.format("Confirm Sample for Test: %s%n%nYour samples: %n%s", lTestDto.get(option),sampleList));
                    if (Utils.confirm("Y or N")) {
                        ctrl.createSample((ArrayList) sampleList);
                        if(ctrl.addSample())
                            Utils.printToConsole("INFO: Samples Saved.");
                        return true;
                    }
                } else {
                    Utils.printToConsole("\nINFO: No tests needing samples are available.");
                    return false;
                }
                return true;
            } catch (Exception e) {
                Utils.printToConsole(e.getMessage());
            }
        }
    }
}
