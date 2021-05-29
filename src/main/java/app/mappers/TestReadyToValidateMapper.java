package app.mappers;

import app.domain.model.CATest;
import app.domain.store.TestStore;
import java.util.ArrayList;
import java.util.List;

public class  TestReadyToValidateMapper {

    private TestStore testStore;

    private TestReadyToValidateMapper() {
        throw new IllegalStateException("Utility class");
    }


    public static List<String> toDtoVal(List<CATest> readyToValidate) {
        List<String> rtvListDto = new ArrayList<>();
        if (!readyToValidate.isEmpty()) {
            for (CATest test : readyToValidate) {
                rtvListDto.add(String.format("%s | Collected at: %s | Reported at: %s |",test.toString(), test.getChemicalAnalysisDate(), test.getReportDate()));
            }
            return rtvListDto;
        }
        return null;
    }
}
