package app.ui.console;

import app.controller.RegisterSampleController;


import app.domain.model.CATest;
import app.domain.model.CodeAdapter;
import app.domain.model.Sample;
import app.domain.model.TestParameter;
import app.ui.console.utils.Utils;
import net.sourceforge.barbecue.Barcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class RegisterSampleUI implements Runnable {

    private CodeAdapter adapter = new CodeAdapter();
    private RegisterSampleController ctrl = new RegisterSampleController();
    private final String labId;
    private int defaultNumberOfSamples  = 1;
    private int numberOfSamples;
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
                List<String> lTestDto = ctrl.getTestWithoutSample();
                if (lTestDto != null) {
                    int option = Utils.showAndSelectIndex(lTestDto, "Select one of the following tests:");
                    String data = ctrl.getData(lTestDto.get(option).substring(15, 27));
                    System.out.println(data);
                    numberOfSamples = Utils.readIntegerFromConsole("Write the number of samples below:");
                    while (numberOfSamples>=defaultNumberOfSamples) {
                        String code = adapter.getCode(data,defaultNumberOfSamples);
                        String barcode=ctrl.createUPCA(code);
                        ctrl.createSample(barcode);
                        System.out.printf("Confirm Sample for Test: %s%n%nYour samples: %n%s", lTestDto.get(option), barcode );
                        if (Objects.requireNonNull(Utils.readLineFromConsole("Y or N:")).equalsIgnoreCase("y")) {
                            if(ctrl.addSample())
                                System.out.println("INFO: Sample Saved.");
                        }
                        defaultNumberOfSamples++;
                    }
                    System.out.println("INFO: Samples Saved.");
                    return true;

                } else {
                    System.out.println("\nINFO: No tests needing samples are available.");
                    return false;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
