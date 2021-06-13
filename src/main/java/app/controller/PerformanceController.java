package app.controller;

import app.domain.model.Performance;
import app.domain.shared.DateTime;
import app.domain.store.PerformanceStore;

public class PerformanceController {

    private Performance p = new Performance();
    private final PerformanceStore pStore = new PerformanceStore();


    public boolean newPerformance(DateTime inicialDate, DateTime endDate) {
        this.p = this.pStore.newPerformance(inicialDate, endDate);
        return this.pStore.validatePerformance(p);
    }

}
