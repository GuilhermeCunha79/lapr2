package app.ui.console;

import app.controller.RegisterSampleController;

import app.ui.console.utils.Utils;
import net.sourceforge.barbecue.Barcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class RegisterSampleUI {
    private RegisterSampleController ctrl = new RegisterSampleController();
    static Scanner ler = new Scanner(System.in);

    public void run() {
        this.ctrl = new RegisterSampleController();
        if(recordSample())
            System.out.println("Sample was succesfully registered!");
    }


    private boolean recordSample() {
        while (true){
            try {
                List<String> lTestDto = ctrl.getTestWithoutSample();
                if (lTestDto != null) {
                    int option = Utils.showAndSelectIndex(lTestDto, "Select one of the following tests:");
                    String data = ctrl.getData(lTestDto.get(option).substring(15, 26));
                    System.out.println(data);
                    System.out.println("Write the number of samples below:");
                    int n= ler.nextInt();
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
