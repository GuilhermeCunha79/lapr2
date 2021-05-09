package app.ui.console;

import app.controller.SpecifieANewTypeOfTestController;
import app.domain.model.ParameterCategory;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class SpecifieANewTypeOfTestUI implements Runnable {

    private SpecifieANewTypeOfTestController ctrl;


    /**
     * First method to run when this UI is instantiated
     */
    @Override
    public void run() {
        ctrl = new SpecifieANewTypeOfTestController();

        boolean created = createTypeOfTest();
        if (created) {
            System.out.println("Type of test was created!");
        }
    }

    /**
     * This method enables user interaction to create a new type of test.
     * @return if the type of test was created or not
     */
    private boolean createTypeOfTest() {
        boolean done = false;
        do {
            try {
                String code = Utils.readLineFromConsole("Introduce type of test code: ");
                String description = Utils.readLineFromConsole("Introduce type of test description: ");
                String collectingMethod = Utils.readLineFromConsole("Introduce type of test colecting method: ");

                List<ParameterCategory> categoryList = ctrl.getCategoryList();
                if (categoryList.isEmpty()) {
                    System.out.println("\nThere is no parameter categories in the system.\nPlease create one first!");
                    return false;
                } else {
                    System.out.println();
                    List<String> displayCatList = new ArrayList<>();
                    for (ParameterCategory category : categoryList) {
                        displayCatList.add(category.getName());
                    }
                    ArrayList<ParameterCategory> listOfSelectedCategories = new ArrayList<ParameterCategory>();
                    int option = Utils.showAndSelectIndex(displayCatList, "Choose Category:");
                    while (option != -1) {

                        ParameterCategory selectedCategory;
                        selectedCategory = categoryList.get(option);

                        listOfSelectedCategories.add(selectedCategory);

                        displayCatList.remove(option);
                        if (Objects.requireNonNull(Utils.readLineFromConsole("Add another category: (Y or N)")).equalsIgnoreCase("y"))
                            option = Utils.showAndSelectIndex(displayCatList, "Choose Category:");
                        else
                            option =-1;
                    }

                    boolean created = ctrl.createANewTypeOfTest(code, description, collectingMethod, listOfSelectedCategories);
                    if (created) {
                        System.out.println("Confirm Type of test: ");
                        System.out.println(ctrl.getTot().toString());
                        if (Objects.requireNonNull(Utils.readLineFromConsole("Y or N:")).equalsIgnoreCase("y")) {
                            done = true;
                            return ctrl.saveTypeOfTest();
                        } else {
                            System.out.println("\nOperation cancelled");
                            return false;
                        }
                    }
                }
                System.out.println("Error: Duplicated Type of Test:");
                return false;
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        } while (!done);
        return false;
    }
}




