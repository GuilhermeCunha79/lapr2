package app.controller;

import app.domain.model.ParameterCategory;
import app.domain.model.TypeOfTest;
import app.domain.store.TypeOfTestStore;

import java.util.List;

public class SpecifieANewTypeOfTestController {

    private TypeOfTestStore tots;

    private TypeOfTest tot;



    public SpecifieANewTypeOfTestController(TypeOfTestStore totStore){
        this.tots = totStore;
        this.tot = null;
    }

    public SpecifieANewTypeOfTestController() {
        this(App.getInstance().getCompany().getTypeOfTestStore());
    }

    public boolean createANewTypeOfTest(String code, String description, String colectingmethod,  String category){
        this.tot = this.tots.createTypeOfTest(code,description,colectingmethod,category);
        return saveTypeOfTest();
    }

    public boolean saveTypeOfTest(){
        return this.tots.saveTypeOfTest(tot);
    }

    public List<ParameterCategory> getCategoryList(){
        return App.getInstance().getCompany().getParameterCategoryStore().getParameterCategoryList();
    }

}
