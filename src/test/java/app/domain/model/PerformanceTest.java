package app.domain.model;

import app.controller.ImportTestFromCsvController;
import app.domain.shared.DateTime;
import app.domain.store.ClinicalAnalysisLaboratoryStore;
import app.domain.store.ParameterStore;
import app.domain.store.TypeOfTestStore;
import org.junit.Test;
import static org.junit.Assert.*;

public class PerformanceTest {
/*
    @Test
    public void testGetStatistic() {
        ClinicalAnalysisLaboratory lab = new ClinicalAnalysisLaboratory("001LR", "Ola", "Address", "12345678911", "1234567891");
        ClinicalAnalysisLaboratory lab2 = new ClinicalAnalysisLaboratory("001WA", "Ola2", "Address", "12345678912", "1234567892");
        ClinicalAnalysisLaboratory lab3 = new ClinicalAnalysisLaboratory("001MA", "Ola3", "Address", "12345678913", "1234567893");
        ClinicalAnalysisLaboratory lab4 = new ClinicalAnalysisLaboratory("001LN", "Ola4", "Address", "12345678914", "1234567894");
        ClinicalAnalysisLaboratory lab5 = new ClinicalAnalysisLaboratory("001DO", "Ola5", "Address", "12345678951", "1234567895");
        ClinicalAnalysisLaboratory lab6 = new ClinicalAnalysisLaboratory("001SO", "Ola6", "Address", "12345678916", "1234567896");

        ClinicalAnalysisLaboratoryStore store = new ClinicalAnalysisLaboratoryStore();
        store.saveClinicalAnalysisLaboratory(lab);
        store.saveClinicalAnalysisLaboratory(lab2);
        store.saveClinicalAnalysisLaboratory(lab3);
        store.saveClinicalAnalysisLaboratory(lab4);
        store.saveClinicalAnalysisLaboratory(lab5);
        store.saveClinicalAnalysisLaboratory(lab6);

        TypeOfTest typeOfTest = new TypeOfTest("13423", "Blood","seringe", new ParameterCategory("13423","name"));
        TypeOfTestStore typeOfTestStore = new TypeOfTestStore();
        typeOfTestStore.saveTypeOfTest(typeOfTest);

        Parameter parameter = new Parameter("13423", "Hemogram", "blood", new ParameterCategory("13423", "blood"));
        ParameterStore parameterStore = new ParameterStore();
        parameterStore.saveParameter(parameter);

        ImportTestFromCsvController ctrl = new ImportTestFromCsvController();
        ctrl.createTestFromCsvFile("C:\\Users\\torre\\OneDrive\\Ambiente de Trabalho\\lei-21-s2-1dl-g53\\tests_BloodMDISCCSV.csv");

        var list = ctrl.getTestsAddedList();
        System.out.println("Adicionado : " + list.size());

        var list1 = ctrl.getTestsFailedList();
        System.out.println("Falhou : " + list1.size());

        Performance performance = new Performance();
        performance.bruteForceAlgorithm(new DateTime("16/04/2020","08:00"), new DateTime("17/06/2020", "20:00"));
        assertNotNull(performance.getStatistic());
    }*/

    @Test
    public void testIntervalTime() {
    }

    @Test
    public void testBruteForceAlgorithm() {
    }
}