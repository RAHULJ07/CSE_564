package PlottingAssignment;

import java.awt.*;
import java.util.Queue;

/**
 * Average Line class to create the bar plot from the queue generated.
 * @version 1.0.0.
 */
public class AverageLine extends Decorator{

    private Queue<Integer> queue ;

    /**
     * Constructor for assigning the distance.
     * @param queue containing the points to be plotted.
     */
    public AverageLine(Queue<Integer> queue) {
        this.queue = queue;
    }

    /**
     * Draw method to add the plots to the Graphics2D object
     * @param g2d Graphics2D instance
     * @param chartWidth Width of the chart to be plotted
     * @param chartHeight Height of the chart to be plotted
     * @param chartX starting X coordinate of the chart
     * @param chartY starting Y coordinate of the chart
     */
    @Override
    public void draw(Graphics2D g2d, int chartWidth, int chartHeight, int chartX, int chartY) {
        super.draw(g2d, chartWidth, chartHeight, chartX, chartY);
        int max = 100;
        int unitY = (chartHeight)/max;

        int[] arr = queue.stream().mapToInt(Integer::intValue).toArray();
        double avg = Evaluator.getInstance().getAverage(arr);

        g2d.setColor(Color.RED);
        g2d.drawLine(chartX, (int) (chartY - (avg * unitY)), (chartWidth), (int) (chartY - (avg * unitY)));
    }
}
