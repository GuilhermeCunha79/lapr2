package app.ui.console;

import app.controller.CreateNewParameterController;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CreateNewParameterUI implements Runnable{

    private CreateNewParameterController ctrl;

    /**
     * First method to run when this UI is instantiated
     */
    @Override
    public void run() {
        ctrl = new CreateNewParameterController();

        boolean created = createParameter();

        if (created){
            System.out.println("Parameter Created!");
        }
    }

    /**
     * This method enables user interaction to create a new parameter.
     * @return if the parameter was created or not
     */
    private boolean createParameter() {
        boolean done=false;
        do {
            try {
                String name = Utils.readLineFromConsole("Introduce parameter's name: ");
                String code = Utils.readLineFromConsole("Introduce parameter's code: ");
                String description = Utils.readLineFromConsole("Introduce parameter's description: ");

                List<String> categoryList = ctrl.getAllParameterCategories();
                if(categoryList.isEmpty()) {
                    System.out.println("%nThere is no parameter categories in the system.%nPlease create one first!");
                }else {
                    System.out.println();
                    List<String> displayCatList = new ArrayList<>(categoryList);
                    int option = Utils.showAndSelectIndex(displayCatList, "Choose Category");
                    String categoryId;
                    if(option != -1)
                        categoryId = categoryList.get(option).substring(1,6);
                    else
                        return false;
                    boolean created = ctrl.createNewParameter(code, name, description, categoryId);
                    if (created) {
                        System.out.printf("\nConfirm parameter category: \nName: %s\nCode: %s\nDescription: %s\nCategory: %s", name, code, description, categoryId);
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
