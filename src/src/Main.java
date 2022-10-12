import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String args[]) {
        String filename;
        filename = "../lu980.tsp";
        //filename = "../atsptw.all/br17a.05.tw";


        ITsp iTsp= TspFactory.getTspObj(filename,TspType.Symmetric);
        iTsp.findMinRoute();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                PointPlotter pointplotter = new PointPlotter(iTsp);

                JFrame jFrame = new JFrame(pointplotter.getClass().getSimpleName());
                jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jFrame.setLocationByPlatform(true);

                //jFrame.setContentPane(pointplotter.getUI());
                jFrame.getContentPane().add(pointplotter.getUI(), BorderLayout.EAST);
                jFrame.pack();
                jFrame.setMinimumSize(jFrame.getSize());

                jFrame.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);

    }
}
