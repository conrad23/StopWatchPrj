/**********************************************************************
Frame used in GUI for StopWatch class

@author Conner Toney
@version GVSU Fall 2014
**********************************************************************/

package package1;

import javax.swing.JFrame;

public class MyTimerFrame {
	
	/******************************************************************
	Main method - used to display GUI
	******************************************************************/
	public static void main(String[] args) {
		JFrame frame = new JFrame("StopWatch");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.getContentPane().add(new MyTimerPanel());		
		frame.setSize(215, 115);
		frame.setVisible(true);
	}
}
