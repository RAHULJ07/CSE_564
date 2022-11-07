package PlottingAssignment;

import java.awt.*;
import java.util.Queue;

/**
 * Line class to create the bar plot from the queue generated.
 * @version 1.0.0.
 */
public class Line implements Top {
    private Queue<Integer> queue ;
    private double prevX,prevY,unitX,unitY;

    /**
     * Constructor for assigning the distance.
     * @param queue containing the points to be plotted.
     */
    public Line(Queue<Integer> queue) {
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
        double x = (double) (chartWidth)/(queue.size());
        double max = 100;

        prevX = chartX;
        unitY = (chartHeight)/max;
        prevY = chartY- (queue.poll() * unitY);

        for (int element : queue){
            g2d.setColor(Color.BLUE);
            g2d.drawLine((int) prevX, (int) prevY, (int) (prevX += x), (int) (prevY = chartY - (element * unitY)));
        }
    }
}