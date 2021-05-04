package app.ui.console;

import app.controller.CreateNewParameterController;
import app.domain.model.ParameterCategory;
import app.ui.console.utils.Utils;
import auth.domain.store.ParameterCategoryStore;
import auth.domain.store.ParameterStore;

import java.util.List;

public class CreateNewParameterUI implements Runnable{

    private CreateNewParameterController ctrl;

    private ParameterStore ps = new ParameterStore();
    @Override
    public void run() {
        ctrl = new CreateNewParameterController(ps);

        boolean created = createParameter();
    }

    private boolean createParameter() {
        String name = Utils.readLineFromConsole("Introduce parameter's name: ");
        String code = Utils.readLineFromConsole("Introduce parameter's code: ");
        String description = Utils.readLineFromConsole("Introduce parameter's description: ");

        return true;
    }


}
