package app.domain.model;

import app.domain.shared.DateTime;
import org.junit.Test;
import static org.junit.Assert.*;

public class PerformanceTest {

    @Test
    public void testGetStatistic() {
        Performance performance = new Performance();
        performance.bruteForceAlgorithm(new DateTime("10/06/2020","08:00"), new DateTime("15/06/2020", "20:00"));
        assertNotNull(performance.getStatistic());
    }

    @Test
    public void testIntervalTime() {
    }

    @Test
    public void testBruteForceAlgorithm() {
    }
}