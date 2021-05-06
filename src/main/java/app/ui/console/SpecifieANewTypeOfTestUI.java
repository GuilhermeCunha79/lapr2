package app.ui.console;

import app.controller.SpecifieANewTypeOfTestController;
import app.domain.model.ParameterCategory;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;


public class SpecifieANewTypeOfTestUI implements Runnable {

    private SpecifieANewTypeOfTestController ctrl;

    @Override
    public void run(){
        ctrl = new SpecifieANewTypeOfTestController();

        boolean created = createTypeOfTest();

        if(created){
            System.out.println("Type of test was created!");
        }
    }

    private boolean createTypeOfTest(){
        boolean done=false;
        do{
            try {

                String code = Utils.readLineFromConsole("Introduce type of test code: ");
                String description = Utils.readLineFromConsole("Introduce type of test description: ");
                String colectingMethod = Utils.readLineFromConsole("Introduce type of test colecting method: ");

                List<ParameterCategory> categoryList = ctrl.getCategoryList();
                System.out.println();
                List<String> displayCatList = new ArrayList<>();
                for (ParameterCategory category : categoryList) {
                    displayCatList.add(category.getName());
                }
                int option = Utils.showAndSelectIndex(displayCatList, "Choose Category");

                String category = categoryList.get(option).getName();

                return ctrl.createANewTypeOfTest(code, description, colectingMethod,category);
            }catch(Exception e){
                System.out.println(e.getLocalizedMessage());
            }
        }while(!done);
        return false;
    }
}
