package app.ui.console;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */

public class AdminUI implements Runnable{
    public AdminUI()
    {
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Add new parameter category", new CreateParameterCategoryUI()));
        options.add(new MenuItem("Add new parameter and categorize it", new CreateNewParameterUI()));
        options.add(new MenuItem("Add new employee", new RegisterEmployeeUI()));
        options.add(new MenuItem("Add a new type of test and its collecting methods", new SpecifyANewTypeOfTestUI()));
        options.add(new MenuItem("Add a new clinical analysis laboratory", new RegisterNewClinicalAnalysisUI()));


        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
