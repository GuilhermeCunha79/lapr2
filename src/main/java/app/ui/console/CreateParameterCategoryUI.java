package app.ui.console;

import app.controller.CreateParameterCategoryController;
import app.ui.console.utils.Utils;

public class CreateParameterCategoryUI implements Runnable {


    private CreateParameterCategoryController ctrl;

    /**
     * First method to be called when this UI is instantiated
     */
    @Override
    public void run() {
        ctrl = new CreateParameterCategoryController();

        boolean catCreated = createParamCat();
        if (catCreated)
            Utils.printToConsole("\nNew category was created!");
    }

    /**
     * This method is responsible to interact with the user to guide him in the parameter category creation process
     * @return if the category was created or not
     */
    public boolean createParamCat(){
        boolean done = false;
        do {
            try {
                String catName = Utils.readLineFromConsole("Introduce parameter category name: ");
                String catCode = Utils.readLineFromConsole("Introduce parameter category code: ");

                boolean created = ctrl.createNewParameterCategory(catCode, catName);
                if (created) {
                    Utils.printToConsole(String.format("%nConfirm parameter category: %nName: %s%nCode: %s", catName, catCode));
                    if (Utils.confirm("Y or N")) {
                        done = true;
                        return ctrl.saveParameterCategory();
                    }else {
                        Utils.printToConsole("\nOperation cancelled");
                        return false;
                    }
                }
                Utils.printToConsole("Parameter category already exists");
                return false;
            }
            catch (Exception e){
                Utils.printToConsole("");
                System.out.println(e.getLocalizedMessage());
            }
        }while(!done);
        return false;
    }
}
