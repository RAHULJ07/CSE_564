package GUI;

import Algorithm.ITsp;
import Algorithm.SymmetricTsp;
import DataStructure.Coordinate;
import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Plotter class to plot all the city points in a JPanel for Symmetric type.
 * @version 1.0.0.
 */
public class PointPlotter {
    private final ITsp iTsp;
    public static int SIZE = 400;
    BufferedImage image = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_RGB);

    private JComponent ui = null;

    /**
     * Constructor for fetching the ITsp object for further use
     * @param iTsp ITsp object
     */
    PointPlotter(ITsp iTsp) {
        this.iTsp = iTsp;
        initUI();
    }

    /**
     * Method to draw the coordinates as a plot in a JPanel.
     */
    private void drawImage() {
        Graphics2D g = image.createGraphics();
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, SIZE, SIZE);

        Area area = new Area();
        double r = 10;
        SymmetricTsp symmetricTsp = (SymmetricTsp) iTsp;
        Coordinate[] points = symmetricTsp.getCoordinates();
        for (Coordinate point : points) {
            Ellipse2D.Double e = new Ellipse2D.Double(
                    point.getX() - r, point.getY() + r, 2*r, 2*r);
            area.add(new Area(e));
        }
        Rectangle2D rect = area.getBounds2D();
        double w = rect.getWidth();
        double h = rect.getHeight();
        double max = w>h ? w : h;
        double s = SIZE/max;
        AffineTransform scale = AffineTransform.getScaleInstance(s, s);
        double tX = -rect.getMinX();
        double tY = -rect.getMinY();
        AffineTransform translate = AffineTransform.getTranslateInstance(tX, tY);
        AffineTransform transform = scale;
        transform.concatenate(translate);
        area = new Area(transform.createTransformedShape(area));
        g.setColor(Color.RED);
        g.draw(area);
        g.dispose();
    }

    /**
     * Method to initialize the GUI components
     */
    public void initUI() {
        if (ui != null) {
            return;
        }
        drawImage();
        ui = new JPanel(new BorderLayout(4, 4));
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));
        ui.add(new JLabel(new ImageIcon(image)));
    }

    /**
     * Method to fetch the JComponent
     * @return JComponent ui
     */
    public JComponent getUI() {
        return ui;
    }
}