package app.ui.console;

import app.controller.CreateParameterCategoryController;
import app.ui.console.utils.Utils;

import java.util.Objects;

public class CreateParameterCategoryUI implements Runnable {

    private CreateParameterCategoryController ctrl;

    @Override
    public void run() {
        ctrl = new CreateParameterCategoryController();

        boolean catCreated = createParamCat();
        if (catCreated)
            System.out.println("\n\nNew category was created!");
    }

    public boolean createParamCat(){
        boolean done = false;
        do {
            try {
                String catName = Utils.readLineFromConsole("Introduce parameter category name: ");
                String catCode = Utils.readLineFromConsole("Introduce parameter category code: ");

                boolean created = ctrl.createNewParameterCategory(catCode, catName);
                if (created) {
                    System.out.printf("\nConfirm parameter category: \nName: %s\nCode: %s\n", catName, catCode);
                    if (Objects.requireNonNull(Utils.readLineFromConsole("Y or N:")).equalsIgnoreCase("y")) {
                        done = true;
                        return ctrl.saveParameterCategory();
                    }else {
                        System.out.println("\nOperation cancelled");
                        return false;
                    }
                }
                System.out.println("Parameter category already exists");
                return false;
            }
            catch (Exception e){
                System.out.println();
                System.out.println(e.getLocalizedMessage());
            }
        }while(!done);
        return false;
    }
}
