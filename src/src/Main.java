import GUI.GUI;

import javax.swing.JFrame;

/**
 * Main class to instantiate the graphic user interface.
 * @version 1.0.0.
 */
public class Main {

	/**
    * Main method to display window using JFrame.
    */
	public static void main(String args[]) {
       
    	GUI myGUI = new GUI();
    	myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	myGUI.setSize(1000,1000);
    	myGUI.setVisible(true);
				
    }
}
