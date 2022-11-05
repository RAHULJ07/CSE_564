import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    private JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Main()::createAndShowGui);
    }

    private void createAndShowGui() {
        frame = new JFrame(getClass().getSimpleName());
        frame.add(new PlotPanel());
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}