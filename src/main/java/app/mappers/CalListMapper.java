package app.mappers;

import app.controller.App;
import app.domain.model.ClinicalAnalysisLaboratory;

import java.util.ArrayList;
import java.util.List;

public class CalListMapper {

    public static List<String> toDto(){
        List<ClinicalAnalysisLaboratory> calList = new ArrayList<>(App.getInstance().getCompany().getClinicalAnalysisLaboratoryStore().getClinicalAnalysisLaboratoryList());
        List<String> calListDto = new ArrayList<>();
        if(!calList.isEmpty()) {
            for (ClinicalAnalysisLaboratory cal : calList) {
                calListDto.add(String.format("Lab ID: %s | Name: %s | Address: %s", cal.getLaboratoryID(), cal.getName(), cal.getAddress()));
            }
            return calListDto;
        }
        return null;
    }
}
