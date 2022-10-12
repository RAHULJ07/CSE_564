import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUI extends JFrame implements ActionListener{
	JButton button;
	JRadioButton fileTypeTsp;
	JRadioButton fileTypeAtsp;

	String filename;
	
	GUI(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		button = new JButton("Select File...");
		button.addActionListener(this);
		
		fileTypeTsp = new JRadioButton("Tsp File");
		fileTypeAtsp = new JRadioButton("Atsp File");
		
		
		ButtonGroup group = new ButtonGroup();
		group.add(fileTypeAtsp);
		group.add(fileTypeTsp);
		
		fileTypeTsp.addActionListener(this);
		fileTypeAtsp.addActionListener(this);
		
		this.add(button);
		this.add(fileTypeTsp);
		this.add(fileTypeAtsp);
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==fileTypeTsp) {
			ITsp iTsp= TspFactory.getTspObj(filename,TspType.Symmetric);
			iTsp.findMinRoute();

	        PointPlotter pointplotter = new PointPlotter(iTsp);
	        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        this.getContentPane().add(pointplotter.getUI(), BorderLayout.EAST);
	        this.pack();
            this.setMinimumSize(this.getSize());

            this.setVisible(true);
			
		}
		
		if(e.getSource()==fileTypeAtsp) {
			ITsp iTsp= TspFactory.getTspObj(filename,TspType.Asymmetric);
			iTsp.findMinRoute();
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
