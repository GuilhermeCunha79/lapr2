package auth.domain.store;

import app.domain.model.ParameterCategory;
import app.domain.model.TypeOfTest;

import java.util.ArrayList;
import java.util.List;

public class TypeOfTestStore {
    private List<TypeOfTest> typeOfTestList = new ArrayList();

    public TypeOfTest createTypeOfTest(String code, String description, String colectingmethod, String SelectedCategory){
        return new TypeOfTest(code,description,colectingmethod,SelectedCategory);
    }


    public boolean saveTypeOfTest(TypeOfTest tot){
        if(validateTypeOfTest(tot)){
            addTypeOfTest(tot);
            return true;
        }
        return false;
    }

    public boolean addTypeOfTest(TypeOfTest tot)
    {
        if (tot != null) {
            if (!validateTypeOfTest(tot))
                return this.typeOfTestList.add(tot);
        }
        return false;
    }

    public boolean validateTypeOfTest(TypeOfTest tot) {
        for (TypeOfTest typeTe : typeOfTestList){
            if(typeTe.equals(tot)){
                return true;
            }
        }
        return false;
    }

    public List<TypeOfTest> getTypeOfTestList() {
        return typeOfTestList;
    }
}
