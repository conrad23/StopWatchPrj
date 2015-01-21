/**********************************************************************
Panel used in GUI for StopWatch

@author Conner Toney
@version GVSU Fall 2014
**********************************************************************/
package package1;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyTimerPanel extends JPanel {

	/** used to record time */
	private StopWatch stopWatchTimer;
	
	/** used to call timer ever millisecond */
	private Timer javaTimer;
	
	/** used to advance time on stopWatchTimer */
	private TimerListener timer;
	
	/** area used to show user the current time */
	private JTextArea timerText;
	
	/** allows user to start stopWatchTimer */
	private JButton startButton;
	
	/** allows user to stop stopWatchTimer */
	private JButton stopButton;
	
	/** allows user to reset stopWatchTimer */
	private JButton resetButton;
	
	/** used to control stopWatchTimer based on user input */
	private ButtonListener bListener;
	
	public MyTimerPanel() {
		stopWatchTimer = new StopWatch(0, 0, 0);
		timer = new TimerListener();
		
		//Calls the timer every millisecond
		javaTimer = new Timer(1, timer);
		bListener = new ButtonListener();	
		timerText = new JTextArea();
		timerText.setFont(new Font("Helvetica", Font.BOLD, 18));
		startButton = new JButton("START");
		startButton.addActionListener(bListener);
		stopButton = new JButton("STOP");
		stopButton.addActionListener(bListener);
		resetButton = new JButton("RESET");
		resetButton.addActionListener(bListener);
		setLayout (new GridLayout (2, 2));
		add(timerText);
		add(startButton);
		add(stopButton);
		add(resetButton);
	}
	
	/******************************************************************
	The Listener used to advance the time on the stopWatchTimer
	and display the information to the user through timerText
	******************************************************************/
	private class TimerListener implements ActionListener {
		
		/**************************************************************
		Advances the time on the stopWatchTimer and displays it
		**************************************************************/
		public void actionPerformed (ActionEvent e) {
			stopWatchTimer.inc();
			timerText.setText(stopWatchTimer.toString());
		}
	}
	
	/******************************************************************
	The Listener used to determine whether the stopWatchTimer should
	start, stop, or reset based on the buttons the user clicks
	******************************************************************/
	private class ButtonListener implements ActionListener {
		
		/**************************************************************
		Starts, stops, or resets the stopWatchTimer based on which
		button the user clicks
		**************************************************************/
		public void actionPerformed (ActionEvent e) {
			if (e.getSource() == startButton) {
				javaTimer.start();
			}
			if (e.getSource() == stopButton) {
				javaTimer.stop();
			}
			if (e.getSource() == resetButton) {
				javaTimer.stop();
				stopWatchTimer = new StopWatch(0, 0, 0);
				timerText.setText(stopWatchTimer.toString());
			}
		}
	}	
}
