/*package app.domain.store;

import app.domain.model.Performance;
import app.domain.shared.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class PerformanceStoreTest {

    PerformanceStore performanceStore = new PerformanceStore();

    @Test
    public void testNewPerformance() {
        Performance performance = performanceStore.newPerformance(new DateTime("20/06/2021", "00:24"), new DateTime("20/06/2021", "00:24"));
        assertNotNull(performance);
    }

    @Test
    public void testValidatePerformance() {
        Performance performance = performanceStore.newPerformance(new DateTime("20/06/2021", "00:24"), new DateTime("20/06/2021", "00:24"));
        assertFalse(performanceStore.validatePerformance(performance));
    }
}*/