package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ClientUI implements Runnable {

    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
       // options.add(new MenuItem("Check tests results", new ()));
        options.add(new MenuItem("Change personal data", new ClientChangesUI()));

        int option;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nClient Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        }
        while (option != -1);
    }
}
