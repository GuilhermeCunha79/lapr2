package app.domain.store;

import app.domain.model.Performance;
import app.domain.shared.DateTime;
import junit.framework.TestCase;

public class PerformanceStoreTest extends TestCase {
    PerformanceStore performanceStore = new PerformanceStore();
/*
    public void testNewPerformance() {
        Performance performance = performanceStore.newPerformance(new DateTime("20/06/2021", "00:24"), new DateTime("20/06/2021", "00:24"));
        assertNotNull(performance);
    }

    public void testValidatePerformance() {
        Performance performance = performanceStore.newPerformance(new DateTime("20/06/2021", "00:24"), new DateTime("20/06/2021", "00:24"));
        assertFalse(performanceStore.validatePerformance(performance));
    }*/
}