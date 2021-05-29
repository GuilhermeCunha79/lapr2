package app.mappers;

import app.domain.model.ParameterCategory;

import java.util.ArrayList;
import java.util.List;

public class ParameterCategoryMapper {

    public ParameterCategoryMapper() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This method converts a list of parameter categories into a list of strings with the data from each parameter category to be used in the UI
     * @param lPC list of parameter categories
     * @return list of strings
     */
    public static List<String> toDTO (List<ParameterCategory> lPC){
        List<String> listPC = new ArrayList<>();
        for (ParameterCategory pc : lPC){
            listPC.add(pc.toString());
        }
        return listPC;
    }
}
