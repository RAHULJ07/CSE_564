package PlottingAssignment;

import java.awt.*;

public class Bar extends Decorator{

    private int[] yCoords;

    public Bar(int[] yCoords) {
        this.yCoords = yCoords;
    }
    @Override
    public void draw(Graphics2D g2, int chartWidth, int chartHeight, int chartX, int chartY, int AXIS_OFFSET) {
        super.draw(g2, chartWidth, chartHeight, chartX, chartY, AXIS_OFFSET);
        Color original = g2.getColor();

        double numBars = yCoords.length;
        double max = 0.;

        for (Integer wrapper : yCoords) {
            if (max < wrapper)
                max = wrapper;
        }
        int barWidth = (int) (chartWidth / (numBars*2));

        int height, xLeft, yTopLeft;
        int counter = 0;

        for (int value : yCoords) {

            double height2 = (value / max) * chartHeight;
            height = (int) height2;
            xLeft = AXIS_OFFSET + counter * 2*barWidth;
            yTopLeft = chartY - height;
            Rectangle rec = new Rectangle((xLeft), yTopLeft, barWidth, height);
            g2.setColor(Color.RED);
            g2.fill(rec);
            counter++;
        }
        g2.setColor(original);
    }
}