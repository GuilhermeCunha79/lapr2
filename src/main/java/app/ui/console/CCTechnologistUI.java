package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class CCTechnologistUI implements Runnable {

    @Override
    public void run() {
        String labID = Utils.selectLab();
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Record test results", new RecordResultUI(labID)));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nClinical Chemistry Technologist Menu");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        }
        while (option != -1);
    }



}
