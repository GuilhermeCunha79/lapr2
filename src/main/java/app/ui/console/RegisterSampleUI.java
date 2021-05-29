package app.ui.console;

import app.controller.RegisterSampleController;

import app.ui.console.utils.Utils;
import net.sourceforge.barbecue.Barcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



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
        } while (repeat && Objects.requireNonNull(Utils.readLineFromConsole("Register sample for another test? (Y/N)")).equalsIgnoreCase("y"));

    }

    /**
     * This method is responsible to guide the user through the test selection and sample registration process
     * @return false if its not possible to register a sample due to not having more tests
     * needing samples, return true when there are tests still needing samples
     */
    private boolean recordSample() {
        while (true){
            try {
                List<String> lTestDto = ctrl.getTestWithoutSample(labId);
                if (lTestDto != null) {
                    int option = Utils.showAndSelectIndex(lTestDto, "Select one of the following tests:");
                    String data = ctrl.getData(lTestDto.get(option).substring(15, 26));
                    System.out.println(data);
                    int n = Utils.readIntegerFromConsole("Write the number of samples below:");
                    List<Barcode> sampleList = new ArrayList<>(n);
                    while (sampleList.isEmpty()) {
                       Barcode barcode =ctrl.createUPCA(data);
                        sampleList.add(barcode);
                    }
                    System.out.printf("Confirm Sample for Test: %s%n%nYour samples: %n%s", lTestDto.get(option),sampleList);
                    if (Objects.requireNonNull(Utils.readLineFromConsole("Y or N:")).equalsIgnoreCase("y")) {
                        ctrl.createSample((ArrayList) sampleList);
                        if(ctrl.addSample())
                            System.out.println("INFO: Samples Saved.");
                        return true;
                    }
                } else {
                    System.out.println("\nINFO: No tests needing samples are available.");
                    return false;
                }
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
