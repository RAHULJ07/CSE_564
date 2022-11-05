import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Point extends Decorator{

    int[] yCoords;

    public Point(int[] yCoords) {
        this.yCoords = yCoords;
    }
    @Override
    public void draw(Graphics2D g2d, int chartWidth, int chartHeight, int chartX, int chartY, int AXIS_OFFSET){
        super.draw(g2d, chartWidth, chartHeight, chartX, chartY, AXIS_OFFSET);
        double max = 0.;

        for (Integer wrapper : yCoords) {
            if (max < wrapper)
                max = wrapper;
        }

        double x = (double)(chartWidth)/(yCoords.length-1);
        double unit = (double)(chartHeight)/max;
        g2d.setPaint(Color.RED);

        for(int i = 0; i< yCoords.length; i++){
            double x1 = chartX +i*x;
            double y1 = chartY-unit* yCoords[i];
            g2d.fill(new Ellipse2D.Double(x1-2, y1-2, 4, 4));
        }
    }
}