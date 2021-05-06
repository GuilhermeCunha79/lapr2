package app.domain.store;

import app.domain.model.TypeOfTest;

import java.util.ArrayList;
import java.util.List;

public class TypeOfTestStore {

    private List<TypeOfTest> typeOfTestList = new ArrayList();

    public TypeOfTest createTypeOfTest(String code, String description, String colectingmethod, String category){
        return new TypeOfTest(code, description, colectingmethod, category);
    }


    public boolean saveTypeOfTest(TypeOfTest tot){
        if(validateTypeOfTest(tot)){
           return addTypeOfTest(tot);
        }
        return false;
    }

    public boolean addTypeOfTest(TypeOfTest tot) {
        if (tot != null && validateTypeOfTest(tot)){
                return this.typeOfTestList.add(tot);
        }
        return false;
    }

    public boolean validateTypeOfTest(TypeOfTest tot) {
        for (TypeOfTest typeTe : typeOfTestList){
            if(typeTe.equals(tot)){
                return false;
            }
        }
        return true;
    }

    public List<TypeOfTest> getTypeOfTestList() {
        return new ArrayList<>(typeOfTestList);
    }
}
