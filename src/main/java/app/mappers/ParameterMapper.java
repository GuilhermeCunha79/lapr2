package app.mappers;

import app.domain.model.Parameter;
import app.domain.model.TypeOfTest;

import java.util.ArrayList;
import java.util.List;

public class ParameterMapper {

    /**
     * This method converts a list of parameters to a list of strings with the data from each test to be used in the UI
     * @param lP list of parameters
     * @return list of strings
     */

    public List<String> toDto(List<Parameter>lP) {
        List<String> totListDto = new ArrayList<>();
        for(Parameter parameter:lP){
            totListDto.add(parameter.toString());
        }
        return totListDto;
    }
}

