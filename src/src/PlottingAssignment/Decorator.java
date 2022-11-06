package PlottingAssignment;

import java.awt.*;

public class Decorator implements Top{
    protected Top top ;

    public void add(Top top){
        this.top = top;
    }

    @Override
    public void draw(Graphics2D g2d, int chartWidth, int chartHeight, int chartX, int chartY, int AXIS_OFFSET) {
        top.draw(g2d, chartWidth, chartHeight, chartX, chartY, AXIS_OFFSET);
    }
}
