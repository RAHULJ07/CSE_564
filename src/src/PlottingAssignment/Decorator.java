package PlottingAssignment;

import java.awt.*;

/**
 * Decorator class to add up decorations to initial Line plot
 * @version 1.0.0.
 */
public class Decorator implements Top{
    protected Top top ;

    /**
     * add method for adding up instance of decoration to current class
     * @param top instance of the decoration
     */
    public void add(Top top){
        this.top = top;
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
        top.draw(g2d, chartWidth, chartHeight, chartX, chartY);
    }
}
