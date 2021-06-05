package app.ui.console;

import app.controller.SpecifyANewTypeOfTestController;
import app.ui.console.utils.Utils;


import java.util.List;


public class SpecifyANewTypeOfTestUI implements Runnable {

    private SpecifyANewTypeOfTestController ctrl;



    /**
     * First method to run when this UI is instantiated
     */
    @Override
    public void run() {
        ctrl = new SpecifyANewTypeOfTestController();

        boolean created = createTypeOfTest();

        if (created) {
            Utils.printToConsole("Type of test was created!");
        } else {
            Utils.printToConsole("Operation failed");
        }
    }

    /**
     * This method enables user interaction to create a new type of test.
     *
     * @return if the type of test was created or not
     */
    private boolean createTypeOfTest() {
        do {
            try {
                String code = Utils.readLineFromConsole("Introduce type of test code: ");
                String description = Utils.readLineFromConsole("Introduce type of test description: ");
                String collectingMethod = Utils.readLineFromConsole("Introduce type of test colecting method: ");

                List<String> categoryDisplayList = ctrl.getCategoryList();
                if (categoryDisplayList.isEmpty()) {
                    Utils.printToConsole("\nThere is no parameter categories in the system.\nPlease create one first!");
                    return false;
                } else {
                    Utils.printToConsole("");
                    int option = Utils.showAndSelectIndex(categoryDisplayList, "Choose Category:");
                    if (option != -1) {
                        String selectedCategory = categoryDisplayList.get(option);
                        ctrl.createANewTypeOfTest(code, description, collectingMethod, selectedCategory.substring(42, 47));
                        categoryDisplayList.remove(option);
                    }
                    while (Utils.confirm("Add another category? (Y or N)")) {
                        option = Utils.showAndSelectIndex(categoryDisplayList, "Choose Category:");
                        if (option != -1) {
                            String selectedCategory = categoryDisplayList.get(option);
                            ctrl.addCategory(selectedCategory.substring(1, 6));
                            categoryDisplayList.remove(option);
                        }
                    }
                    return ctrl.saveTypeOfTest();
                }
            } catch (Exception e) {
                Utils.printToConsole(e.getLocalizedMessage());
            }
        } while (true);
    }
}




