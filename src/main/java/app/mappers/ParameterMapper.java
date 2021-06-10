package app.mappers;

import app.domain.model.Parameter;

import java.util.ArrayList;
import java.util.List;

public class ParameterMapper {

    private ParameterMapper() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This method converts a list of parameters to a list of strings with the data from each parameter to be used in the UI
     * @param lP list of parameters
     * @return list of strings
     */
    public static List<String> toDto(List<Parameter>lP) {
        List<String> totListDto = new ArrayList<>();
        if(lP!=null && !lP.isEmpty()) {
            for (Parameter parameter : lP) {
                totListDto.add(parameter.toString());
            }
            return totListDto;
        }
        return null;
    }
}

