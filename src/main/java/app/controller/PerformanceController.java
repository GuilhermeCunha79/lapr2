package app.controller;

import app.domain.model.ClinicalTest;
import app.domain.model.Performance;
import app.domain.shared.DateTime;
import app.domain.store.PerformanceStore;
import app.domain.store.TestStore;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.List;

public class PerformanceController {

    private Performance p = new Performance();
    private final PerformanceStore pStore = new PerformanceStore();


    public void newPerformance(DateTime inicialDate, DateTime endDate) {
        this.p = this.pStore.newPerformance(inicialDate, endDate);
        //return this.pStore.validatePerformance(p);
    }

    public LineChart getChart (){
        return p.getStatistic();
    }

}
