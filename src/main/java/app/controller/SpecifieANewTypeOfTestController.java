package app.controller;

import app.domain.model.ParameterCategory;
import app.domain.model.TypeOfTest;
import app.domain.store.TypeOfTestStore;

public class SpecifieANewTypeOfTestController {

    private TypeOfTestStore totStore;

    private TypeOfTest tot;

    public SpecifieANewTypeOfTestController(TypeOfTestStore totStore){
        this.totStore = totStore;
        this.tot = null;
    }

    public boolean SpecifieANewTypeOfTest(String code, String description, String colectingmethod, ParameterCategory pc){
        this.tot = this.totStore.createTypeOfTest(code,description,colectingmethod,pc);
        return  this.totStore.validateTypeOfTest(tot);
    }

    public boolean saveTypeOfTest(){
        return this.totStore.saveTypeOfTest(tot);
    }
}
