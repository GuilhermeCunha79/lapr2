package app.domain.store;

import app.domain.model.Performance;
import app.domain.shared.DateTime;
import javafx.scene.canvas.GraphicsContext;


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
        GraphicsContext context = performance.getStatistic();
        return (context != null);
    }
}
