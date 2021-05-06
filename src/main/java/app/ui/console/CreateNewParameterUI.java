package app.ui.console;

import app.controller.CreateNewParameterController;
import app.domain.model.ParameterCategory;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class CreateNewParameterUI implements Runnable{

    private CreateNewParameterController ctrl;

    @Override
    public void run() {
        ctrl = new CreateNewParameterController();

        boolean created = createParameter();

        if (created){
            System.out.println("Parameter Created!");
        }
    }

    private boolean createParameter() {
        boolean done=false;
        do {
            try {
                String name = Utils.readLineFromConsole("Introduce parameter's name: ");
                String code = Utils.readLineFromConsole("Introduce parameter's code: ");
                String description = Utils.readLineFromConsole("Introduce parameter's description: ");

                List<ParameterCategory> categoryList = ctrl.getCategoryList();
                System.out.println();
                List<String> displayCatList = new ArrayList<>();
                for (ParameterCategory category : categoryList) {
                    displayCatList.add(category.getName());
                }
                int option = Utils.showAndSelectIndex(displayCatList, "Choose Category");

                String category = categoryList.get(option).getName();

                return ctrl.createNewParameter(code, name, description, category);
            }catch(Exception e){
                System.out.println(e.getLocalizedMessage());
            }
        }while(!done);
        return false;
    }


}
