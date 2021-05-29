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
            System.out.println("Type of test was created!");
        } else {
            System.out.println("Operation failed");
        }
    }

    /**
     * This method enables user interaction to create a new type of test.
     *
     * @return if the type of test was created or not
     */
    private boolean createTypeOfTest() {
        boolean done = false;
        do {
            try {
                String code = Utils.readLineFromConsole("Introduce type of test code: ");
                String description = Utils.readLineFromConsole("Introduce type of test description: ");
                String collectingMethod = Utils.readLineFromConsole("Introduce type of test colecting method: ");

                List<String> categoryDisplayList = ctrl.getCategoryList();
                if (categoryDisplayList.isEmpty()) {
                    System.out.println("\nThere is no parameter categories in the system.\nPlease create one first!");
                    return false;
                } else {
                    System.out.println();
                    int option = Utils.showAndSelectIndex(categoryDisplayList, "Choose Category:");
                    if (option != -1) {
                        String selectedCategory = categoryDisplayList.get(option);
                        ctrl.createANewTypeOfTest(code, description, collectingMethod, selectedCategory.substring(42, 47));
                        categoryDisplayList.remove(option);
                    }
                    String addMorePC = Utils.readLineFromConsole("Add another category? (Y/N)");
                    while (addMorePC != null && addMorePC.equalsIgnoreCase("y") && !categoryDisplayList.isEmpty()) {
                        option = Utils.showAndSelectIndex(categoryDisplayList, "Choose Category:");
                        if (option != -1) {
                            String selectedCategory = categoryDisplayList.get(option);
                            ctrl.addCategory(selectedCategory.substring(1, 6));
                            categoryDisplayList.remove(option);
                        }
                    }
                    done = true;
                    return ctrl.saveTypeOfTest();
                }
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        } while (!done);
        return false;
    }
}




