package app.mappers;

import app.domain.model.TypeOfTest;

import java.util.ArrayList;
import java.util.List;

public class TestTypeMapper {

    private TestTypeMapper() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This method converts a list of test types to a list of strings with the data from each test type to be presented in the UI
     * @param lTT list of test types
     * @return list of strings
     */

    public static List<String> toDto(List<TypeOfTest>lTT) {
        List<String> totListDto = new ArrayList<>();
        for(TypeOfTest typeOfTest:lTT){
            totListDto.add(String.format("(%s) %s", typeOfTest.getCode(), typeOfTest.getDescription()));
        }
        return totListDto;
    }
}
