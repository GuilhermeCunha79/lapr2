package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MedicalLabTechnicianUI implements Runnable {
    /**
     * Method that implements the options that appear in the medical lab technician UI
     */

    @Override
    public void run() {
        String labID = Utils.selectLab();
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Record samples", new RegisterSampleUI(labID)));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nMedical Lab Technician Menu");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        }
        while (option != -1);
    }
}
