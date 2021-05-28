package app.mappers;

import app.domain.model.ParameterCategory;

import java.util.ArrayList;
import java.util.List;

public class ParameterCategoryMapper {

    public ParameterCategoryMapper() {
        throw new IllegalStateException("Utility class");
    }


    public static List<String> toDTO (List<ParameterCategory> lPC){
        List<String> listPC = new ArrayList<>();
        for (ParameterCategory pc : lPC){
            listPC.add(pc.toString());
        }
        return listPC;
    }
}
