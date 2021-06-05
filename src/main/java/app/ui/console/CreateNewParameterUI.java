package app.ui.console;

import app.controller.CreateNewParameterController;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

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
            Utils.printToConsole("Parameter Created!");
        }
    }

    /**
     * This method enables user interaction to create a new parameter.
     * @return if the parameter was created or not
     */
    private boolean createParameter() {
        do {
            try {
                String name = Utils.readLineFromConsole("Introduce parameter's name: ");
                String code = Utils.readLineFromConsole("Introduce parameter's code: ");
                String description = Utils.readLineFromConsole("Introduce parameter's description: ");

                List<String> categoryList = ctrl.getAllParameterCategories();
                if(categoryList.isEmpty()) {
                    Utils.printToConsole("\nThere is no parameter categories in the system.%nPlease create one first!");
                }else {
                    Utils.printToConsole("");
                    List<String> displayCatList = new ArrayList<>(categoryList);
                    int option = Utils.showAndSelectIndex(displayCatList, "Choose Category");
                    String categoryId;
                    if(option != -1)
                        categoryId = categoryList.get(option).substring(42,47);
                    else
                        return false;
                    boolean created = ctrl.createNewParameter(code, name, description, categoryId);
                    if (created) {
                        Utils.printToConsole(String.format("%nConfirm parameter: %nName: %s%nCode: %s%nDescription: %s%nCategory: %s", name, code, description, categoryId));
                        if (Utils.confirm("Y or N")) {
                            return ctrl.saveParameter();
                        }else {
                            Utils.printToConsole("\nOperation cancelled");
                            return false;
                        }
                    }
                }
                return false;
            }catch(Exception e){
                Utils.printToConsole("INFO: "+e.getLocalizedMessage());
            }
        }while(true);
    }


}
