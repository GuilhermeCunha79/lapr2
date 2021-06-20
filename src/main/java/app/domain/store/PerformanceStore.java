package app.domain.store;

import app.domain.model.ClinicalTest;
import app.domain.model.Performance;
import app.domain.shared.DateTime;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.LineChart;

import java.util.List;


public class PerformanceStore {

    /***
     * Method that receives parameters from the associated controller to create a new performance
     * @param inicialDate
     * @param endDate
     * @return
     */
    public Performance newPerformance(DateTime inicialDate, DateTime endDate) {
        return new Performance(inicialDate, endDate);
    }

    /***
     * Method that checks if the attribute from Performance is null, if not validates the performance
     * @param performance
     * @return
     */
    public boolean validatePerformance(Performance performance) {
        LineChart context = performance.getStatistic();
        return (context != null);
    }
}
