package app.ui.console;

import app.controller.CreateNewParameterController;
import app.domain.model.ParameterCategory;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
                if(categoryList.isEmpty()) {
                    System.out.println("\nThere is no parameter categories in the system.\nPlease create one first!");
                }else {
                    System.out.println();
                    List<String> displayCatList = new ArrayList<>();
                    for (ParameterCategory category : categoryList) {
                        displayCatList.add(category.getName());
                    }
                    int option = Utils.showAndSelectIndex(displayCatList, "Choose Category");
                    String category;
                    if(option != -1)
                        category = categoryList.get(option).getName();
                    else
                        return false;
                    boolean created = ctrl.createNewParameter(code, name, description, category);
                    if (created) {
                        System.out.printf("\nConfirm parameter category: \nName: %s\nCode: %s\nDescription: %s\nCategory: %s", name, code, description, category);
                        if (Objects.requireNonNull(Utils.readLineFromConsole("Y or N:")).equalsIgnoreCase("y")) {
                            done = true;
                            return ctrl.saveParameter();
                        }else {
                            System.out.println("\nOperation cancelled");
                            return false;
                        }
                    }
                }
                return false;
            }catch(Exception e){
                System.out.println(e.getLocalizedMessage());
            }
        }while(!done);
        return false;
    }


}
