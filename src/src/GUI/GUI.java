package GUI;

import Algorithm.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

/**
 * GUI class to define the layout of the Graphical User Interface using JFrame.
 * @version 1.0.0.
 */
public class GUI extends JFrame {
	
	private JButton button;
	private JRadioButton fileTypeTsp;
	private JRadioButton fileTypeAtsp;
	private JPanel panel;
	private String filename;
	
	/**
     * Constructor for initializing the layout of the GUI.
     */
	public GUI(){
		
		setLayout(new FlowLayout());

		JLabel label = new JLabel("First choose file, followed by file type: ");
		EventHandler handler = new EventHandler();
		
		button = new JButton("Select File...");
		button.addActionListener(handler);
		
		fileTypeTsp = new JRadioButton("Tsp File");
		fileTypeAtsp = new JRadioButton("Atsp File");
		ButtonGroup group = new ButtonGroup();
		group.add(fileTypeAtsp);
		group.add(fileTypeTsp);
		fileTypeTsp.addActionListener(handler);
		fileTypeAtsp.addActionListener(handler);
		
		panel = new JPanel();
		
		add(label);
		add(button);
		add(fileTypeTsp);
		add(fileTypeAtsp);
		add(panel, BorderLayout.CENTER);
		
	}
	
	/**
     * Class for listening to and handling events using ActionListener interface.
     */
	private class EventHandler implements ActionListener{
		
		/**
	     * Method for handling actions.
	     */
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==button)
			{
				
				JFileChooser fileChooser = new JFileChooser();
				int response = fileChooser.showOpenDialog(null);
				if(response == JFileChooser.APPROVE_OPTION) {
					filename = fileChooser.getSelectedFile().getAbsolutePath();
				}
				System.out.println(filename);
				
			}

			if(e.getSource()==fileTypeTsp) {
				
				ITsp iTsp= TspFactory.getTspObj(filename, TspType.Symmetric);
				iTsp.findMinRoute();
				
				PointPlotter pointplotter = new PointPlotter(iTsp);
				updateGUI(((SymmetricTsp)iTsp).getSum(), ((SymmetricTsp)iTsp).getRoute(), pointplotter);
				
			}
			else if(e.getSource()==fileTypeAtsp) {
				
				ITsp iTsp= TspFactory.getTspObj(filename, TspType.Asymmetric);
				iTsp.findMinRoute();
				
				updateGUI(((AsymmetricTsp)iTsp).getSum(), ((AsymmetricTsp)iTsp).getRoute());
			}
		}
	}
	
	/**
     * Method for displaying map, minimum path cost and route for symmetric data.
     * @param sum Minimum path cost calculated using our algorithm.
     * @param path Array containing the indexes of cities in order of optimal route.
     * @param p PointPlotter class object to plot the map.
     */
	public void updateGUI(int sum, int[] path, PointPlotter p) {
		
		panel.removeAll();
		JLabel minDistance = new JLabel("Minimum Cost: ".concat(String.valueOf(sum)));
		
		JTextArea route = new JTextArea("Path->".concat(Arrays.toString(path)), 1, 10);
		JScrollPane scrollableTextArea = new JScrollPane(route);
		scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		panel.add(p.getUI());
		panel.add(minDistance);
		panel.add(scrollableTextArea);
		panel.setSize(getSize());
		panel.revalidate();
	}
	
	/**
     * Method for displaying map, minimum path cost and route for asymmetric data.
     * @param sum Minimum path cost calculated using our algorithm.
     * @param path Array containing the indexes of cities in order of optimal route.
     */
	public void updateGUI(int sum, int[] path) {
		
		panel.removeAll();
		JLabel minDistance = new JLabel("Minimum Cost: ".concat(String.valueOf(sum)));
		
		JTextArea route = new JTextArea("Path->".concat(Arrays.toString(path)), 1, 10);
		JScrollPane scrollableTextArea = new JScrollPane(route);
    	scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
    	scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	
		panel.add(minDistance);
		panel.add(scrollableTextArea);
		panel.setSize(getSize());
		panel.revalidate();
	}
}
