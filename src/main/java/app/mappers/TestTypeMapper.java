package app.mappers;

import app.domain.model.TypeOfTest;

import java.util.ArrayList;
import java.util.List;

public class TestTypeMapper {

    private TestTypeMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static List<String> toDto(List<TypeOfTest>lTT) {
        List<String> totListDto = new ArrayList<>();
        for(TypeOfTest typeOfTest:lTT){
            totListDto.add(String.format("(%s) %s", typeOfTest.getCode(), typeOfTest.getDescription()));
        }
        return totListDto;
    }
}
