package PlottingAssignment;

import java.awt.*;

/**
 * Interface for drawing individual charts
 * @version 1.0.0.
 */
public interface Top {
     void draw(Graphics2D g2d, int chartWidth, int chartHeight, int chartX, int chartY);
}
