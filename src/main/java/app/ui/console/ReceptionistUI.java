package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ReceptionistUI implements Runnable {

    @Override
    public void run() {
        String labID = Utils.selectLab();
        if(labID != null) {
            List<MenuItem> options = new ArrayList<MenuItem>();
            options.add(new MenuItem("Add new client", new RegisterANewClientUI()));
            options.add(new MenuItem("Create new test", new CreateTestUI(labID)));

            int option = 0;
            do {
                option = Utils.showAndSelectIndex(options, "\n\nReceptionist Menu");

                if ((option >= 0) && (option < options.size())) {
                    options.get(option).run();
                }
            }
            while (option != -1);
        }
    }

}
