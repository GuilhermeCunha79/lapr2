package app.mappers;

import app.domain.model.CATest;
import app.domain.store.TestStore;

import java.util.ArrayList;
import java.util.List;

public class  TestReadyToValidateMapper {

    private static TestStore testStore;

    public TestReadyToValidateMapper() {
        throw new IllegalStateException("Utility class");
    }


    public static List<String> toDtoVal(List<CATest>readyToValidate) {
        List<String> rtvListDto = new ArrayList<>();
        if (!readyToValidate.isEmpty()) {
            for (CATest test : readyToValidate) {
                String code = test.getInternalCode();
                CATest test1 = testStore.getTestByCode(code);
                rtvListDto.add(String.format("%s | Collected at: %s | Reported at: %s |",test1.toString(), test1.getChemicalAnalysisDate(), test1.getReportDate()));
            }
            return rtvListDto;
        }
        return null;
    }
}
