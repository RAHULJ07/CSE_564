package PlottingAssignment;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * App class to instantiate the graphic user interface.
 * @version 1.0.0.
 */
public class App implements ActionListener {
    private static JFrame frame;
    private static Button button;
    private static PlotPanel plotPanel4 = new PlotPanel(4);

    /**
     * Main method to display window using JFrame.
     */
    public static void main(String[] args){

        frame = new JFrame(App.class.getSimpleName());
        frame.setLayout(new GridLayout(4, 1));
        createButton();
        frame.add(plotPanel4);
        frame.setVisible(true);
        frame.setSize(400,1200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * createButton method to create Run button.
     */
    public static void createButton(){
        App app = new App();
        button = new Button("Run");
        button.addActionListener( app);
        plotPanel4.add(button);
    }

    /**
     * Method for handling actions.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        PlotPanel plotPanel1 = new PlotPanel(1);
        PlotPanel plotPanel2 = new PlotPanel(2);
        PlotPanel plotPanel3 = new PlotPanel(3);
        if(e.getSource()==button){
            Source source =new Source();
            source.addObserver(plotPanel1);
            source.addObserver(plotPanel2);
            source.addObserver(plotPanel3);
            source.updateRandomNumber();
            try {
                Thread.sleep(14000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
        frame.add(plotPanel1);
        frame.add(plotPanel2);
        frame.add(plotPanel3);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400,1200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

