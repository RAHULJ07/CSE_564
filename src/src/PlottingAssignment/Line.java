package PlottingAssignment;

import java.awt.*;

public class Line implements Top {
    private int[] yCoords;
    private int prevX,prevY,unitX,unitY;

    public Line(int[] yCoords) {
        this.yCoords = yCoords;
    }

    @Override
    public void draw(Graphics2D g2d, int chartWidth, int chartHeight, int chartX, int chartY, int AXIS_OFFSET) {
        prevX = chartX;
        prevY = chartY;
        unitX =  (chartWidth)/10;
        unitY =  (chartHeight)/10;

        for (int value : yCoords) {
            g2d.setColor(Color.RED);
            g2d.drawLine(prevX, prevY, prevX += unitX, prevY = chartY - (value * unitY));
        }
    }
}