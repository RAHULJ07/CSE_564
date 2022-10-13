import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


public class GUI extends JFrame implements ActionListener{
	JButton button;
	JRadioButton fileTypeTsp;
	JRadioButton fileTypeAtsp;
	JPanel panel;

	String filename;
	
	GUI(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setSize(1000,1000);
		
		JLabel label = new JLabel("First choose file, followed by file type: ");

		
		button = new JButton("Select File...");
		button.addActionListener(this);
		
		fileTypeTsp = new JRadioButton("Tsp File");
		fileTypeAtsp = new JRadioButton("Atsp File");
		
		
		ButtonGroup group = new ButtonGroup();
		group.add(fileTypeAtsp);
		group.add(fileTypeTsp);
		
		fileTypeTsp.addActionListener(this);
		fileTypeAtsp.addActionListener(this);
		
		panel = new JPanel();
		
		this.add(label);
		this.add(button);
		this.add(fileTypeTsp);
		this.add(fileTypeAtsp);
		this.add(panel, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==fileTypeTsp) {
			ITsp iTsp= TspFactory.getTspObj(filename,TspType.Symmetric);
			iTsp.findMinRoute();

	        	panel.removeAll();
			PointPlotter pointplotter = new PointPlotter(iTsp);
			JLabel minDistance = new JLabel("Minimum Cost: ".concat(String.valueOf(((SymmetricTsp)iTsp).getSum())));
			JTextArea route = new JTextArea("Path->".concat(Arrays.toString(((SymmetricTsp)iTsp).getRoute())), 1, 10);
			JScrollPane scrollableTextArea = new JScrollPane(route);
	        	scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
	        	scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
			panel.add(pointplotter.getUI());
			panel.add(minDistance);
			panel.add(scrollableTextArea);
			panel.setSize(this.getSize());
			panel.revalidate();
			
		}
		
		if(e.getSource()==fileTypeAtsp) {
			ITsp iTsp= TspFactory.getTspObj(filename,TspType.Asymmetric);
			iTsp.findMinRoute();
			panel.removeAll();
			JLabel minDistance = new JLabel("Minimum Cost: ".concat(String.valueOf(((AsymmetricTsp)iTsp).getSum())));
			JTextArea route = new JTextArea("Path->".concat(Arrays.toString(((AsymmetricTsp)iTsp).getRoute())), 1, 10);
			JScrollPane scrollableTextArea = new JScrollPane(route);
			scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
			scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
			panel.add(minDistance);
			panel.add(scrollableTextArea);
			panel.setSize(this.getSize());
			panel.revalidate();
		}
		
		
		if(e.getSource()==button) {
			
			JFileChooser fileChooser = new JFileChooser();
			int response = fileChooser.showOpenDialog(null);
			
			if(response == JFileChooser.APPROVE_OPTION) {
					filename = fileChooser.getSelectedFile().getAbsolutePath();
	
				System.out.println(filename);
			}
		}
		
		
		
	}

}
