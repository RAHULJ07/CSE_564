package PlottingAssignment;

import javax.swing.*;
import java.awt.*;

public class PlotPanel extends JPanel {

    int arr[] = new int[]{1, 3, 4, 7, 5, 10, 3};
    private int chartWidth, chartHeight, chartX, chartY;
    public static final int AXIS_OFFSET = 20;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        computeSize();
        Graphics2D g2 = (Graphics2D) g;
        Bar bar = new Bar(arr);
        Line line = new Line(arr);
        Point point = new Point(arr);
        bar.add(line);
        point.add(bar);
        point.draw(g2,chartWidth,chartHeight,chartX,chartY,AXIS_OFFSET);

    }

    private void computeSize() {

        int width = this.getWidth();
        int height = this.getHeight();
        chartWidth = width - 2*AXIS_OFFSET;
        chartHeight = height - 2*AXIS_OFFSET;
        chartX = AXIS_OFFSET;
        chartY = height - AXIS_OFFSET;
    }
}
