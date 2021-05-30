package app.mappers;

import app.domain.model.CATest;
import java.util.ArrayList;
import java.util.List;

public class  TestReadyToValidateMapper {

    /***
     * This method converts a list of test types to a list of strings with the data from each test to be presented in the UI
     * @param readyToValidate
     * @return
     */
    public static List<String> toDtoVal(List<CATest> readyToValidate) {
        List<String> rtvListDto = new ArrayList<>();

            for (CATest test : readyToValidate) {
                rtvListDto.add(String.format("%s Collected at: %s | Reported at: %s |",test.toString(), test.getChemicalAnalysisDate(), test.getReportDate()));
            }
            return rtvListDto;
        }
    }

