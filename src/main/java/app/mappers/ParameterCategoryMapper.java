package app.mappers;

import app.domain.model.ParameterCategory;

import java.util.ArrayList;
import java.util.List;

public class ParameterCategoryMapper {
    private ParameterCategoryMapper() {
        throw new IllegalStateException("Utility class");
    }


    public static List<String> toDTO (List<ParameterCategory> lPC){
        List<String> listPC = new ArrayList<>();
        for (ParameterCategory pc : lPC){
            listPC.add("("+pc.getCode()+") "+pc.getName());
        }
        return listPC;
    }
}
