package PlottingAssignment;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Queue;

/**
 * Point class to create the bar plot from the queue generated.
 * @version 1.0.0.
 */
public class Point extends Decorator{

    private Queue<Integer> queue ;

    /**
     * Constructor for assigning the distance.
     * @param queue containing the points to be plotted.
     */
    public Point(Queue<Integer> queue) {
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
    public void draw(Graphics2D g2d, int chartWidth, int chartHeight, int chartX, int chartY){
        super.draw(g2d, chartWidth, chartHeight, chartX, chartY);
        double max = 100;


        double x = (double)(chartWidth)/(queue.size());
        double unit = (double)(chartHeight)/max;
        g2d.setPaint(Color.BLUE);

        int i=0;
        for(int element : queue){
            double x1 = chartX + x/4 +i*x - x/8;
            double y1 = chartY-unit* element;
            g2d.fill(new Ellipse2D.Float((float) (x1), (float) (y1), 8, 8));
            i++;
        }
    }
}