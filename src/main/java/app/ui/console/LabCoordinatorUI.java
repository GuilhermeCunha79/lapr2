package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class LabCoordinatorUI implements Runnable{


    /**
     * Method that implements the options that appear in the lab coordinator UI
     */
    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Test Validation", new ValidationUI()));
        options.add(new MenuItem("Import Tests from CSV file", new ImportTestFromCsvUI()));


        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nLab Coordinator Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
