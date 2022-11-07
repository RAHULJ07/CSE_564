package PlottingAssignment;

import java.awt.*;
import java.util.Queue;

/**
 * Bar class to create the bar plot from the queue generated.
 * @version 1.0.0.
 */
public class Bar extends Decorator{

    private Queue<Integer> queue ;

    /**
     * Constructor for assigning the distance.
     * @param queue containing the points to be plotted.
     */
    public Bar(Queue<Integer> queue) {
        this.queue = queue;
    }

    /**
     * Draw method to add the plots to the Graphics2D object
     * @param g2 Graphics2D instance
     * @param chartWidth Width of the chart to be plotted
     * @param chartHeight Height of the chart to be plotted
     * @param chartX starting X coordinate of the chart
     * @param chartY starting Y coordinate of the chart
     */
    @Override
    public void draw(Graphics2D g2, int chartWidth, int chartHeight, int chartX, int chartY) {
        super.draw(g2, chartWidth, chartHeight, chartX, chartY);
        Color original = g2.getColor();

        double numBars = queue.size();
        double max = 100;
        int barWidth = (int) (chartWidth / (numBars*2));
        int height, xLeft, yTopLeft;
        int counter = 0;

        for (int value : queue) {

            double height2 = (value / max) * chartHeight;
            height = (int) height2;
            xLeft = chartX + counter * 2*barWidth;
            yTopLeft = chartY - height;
            Rectangle rec = new Rectangle((xLeft), yTopLeft, barWidth, height);
            g2.setColor(Color.GRAY);
            g2.fill(rec);
            counter++;
        }
        g2.setColor(original);
    }
}