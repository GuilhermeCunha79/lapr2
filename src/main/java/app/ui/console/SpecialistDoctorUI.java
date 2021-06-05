package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SpecialistDoctorUI implements Runnable{


    /**
     * Method that implements the options that appear in the specialist doctor UI
     */
    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Write reports", new WriteReportUI()));

        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nSpecialist Doctor Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
