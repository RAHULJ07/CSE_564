package PlottingAssignment;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;

/**
 * PlotPanel class for plotting all the individual charts.
 * It implements Observer class and inherits from JPanel class
 * @version 1.0.0.
 */
public class PlotPanel extends JPanel implements Observer {

    private int plotNumber;
    private int randomNumber;
    private Queue<Integer> queue = new LinkedList<>();
    private int chartWidth, chartHeight, chartX, chartY;
    public static final int AXIS_OFFSET = 20;

    /**
     * Constructor for assigning the plot number of plots.
     * @param plotNumber plot Number of plots
     */
    PlotPanel(int plotNumber){
        this.plotNumber = plotNumber;
    }

    /**
     * paintComponent for adding plots to the panels.
     * @param g Graphics instance
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        computeSize();
        Graphics2D g2 = (Graphics2D) g;
        Decorator bar = new Bar(queue);
        ITop line = new Line(queue);
        Decorator point = new Point(queue);
        Decorator avgLine = new AverageLine(queue);
        if(plotNumber ==1) {
            point.add(bar);
            bar.add(avgLine);
            avgLine.add(line);
            point.draw(g2, chartWidth, chartHeight, chartX, chartY);
        }
        else if(plotNumber ==2){
            point.add(avgLine);
            avgLine.add(line);
            point.draw(g2, chartWidth, chartHeight, chartX, chartY);

        }
        else if(plotNumber == 3){
            avgLine.add(line);
            avgLine.draw(g2, chartWidth, chartHeight, chartX, chartY);
        }
    }

    /**
     * computeSize for computing the sizes of the individual charts.
     */
    private void computeSize() {

        int width = this.getWidth();
        int height = this.getHeight();
        chartWidth = width - 2*AXIS_OFFSET;
        chartHeight = height - 2*AXIS_OFFSET;
        chartX = AXIS_OFFSET;
        chartY = height - AXIS_OFFSET;
    }

    /**
     * update method for the Observer PlotPanel class.
     * @param o Observable class instance
     * @param arg Object type of the Observable class
     */
    @Override
    public void update(Observable o, Object arg) {
        randomNumber = ((Source)o).getRandomNumber();
        if(queue.size()<10)
            queue.add(randomNumber);
        else {
            queue.remove();
            queue.add(randomNumber);
        }
        repaint();
    }
}
