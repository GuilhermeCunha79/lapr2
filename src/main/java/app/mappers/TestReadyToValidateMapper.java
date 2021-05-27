package app.mappers;

import app.domain.model.Test;
import app.domain.model.TypeOfTest;
import app.domain.store.TestStore;

import java.util.ArrayList;
import java.util.List;

public class  TestReadyToValidateMapper {

    private static TestStore testStore;

    public TestReadyToValidateMapper() {
        throw new IllegalStateException("Utility class");
    }


    public static List<String> toDtoVal(List<Test>readyToValidate) {
        List<String> rtvListDto = new ArrayList<>();
        if (!readyToValidate.isEmpty()) {
            for (Test test : readyToValidate) {
                String code = test.getInternalCode();
                Test test1 = testStore.getTestByCode(code);
                rtvListDto.add(String.format("%s | Collected at: %s | Reported at: %s |",test1.toString(), test1.getChemicalAnalysisDate(), test1.getReportDate()));
            }
            return rtvListDto;
        }
        return null;
    }
}
