package app.ui.console;

import app.mappers.CalListMapper;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ReceptionistUI implements Runnable {

    @Override
    public void run() {
        String labID = selectLab();
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

    private String selectLab() {
        List<String> labs = CalListMapper.toDto();
        int option;
        if (labs != null) {
            do {
                option = Utils.showAndSelectIndex(labs, "\n\n Select the lab you are currently working from:");

                if ((option >= 0) && (option < labs.size())) {
                    return labs.get(option).substring(8, 13);
                }

            } while (option != -1);
        }
        return null;
    }

}
