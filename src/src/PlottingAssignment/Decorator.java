package PlottingAssignment;

import java.awt.*;
import java.util.Queue;

/**
 * Decorator class to add up decorations to initial Line plot
 * @version 1.0.0.
 */
public abstract class Decorator implements ITop {
    protected ITop ITop;

    private Queue<Integer> queue ;

    /**
     * add method for adding up instance of decoration to current class
     * @param ITop instance of the decoration
     */
    public void add(ITop ITop){
        this.ITop = ITop;
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
        ITop.draw(g2d, chartWidth, chartHeight, chartX, chartY);
    }
}
