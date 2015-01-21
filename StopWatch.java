/**********************************************************************
A stop watch capable of recording the time
in minutes, seconds, and milliseconds.

@author Conner Toney
@version GVSU Fall 2014
**********************************************************************/
package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class StopWatch {
	
	/** number of minutes recorded on StopWatch */
	private int min;
	
	/** number of seconds recorded on StopWatch */
	private int sec;
	
	/** number of milliseconds recorded on StopWatch */
	private int msec;
	
	/** determines whether StopWatch can mutate, auto set to 'true' */
	private static boolean mutate = true;
	
	/******************************************************************
	Constructor used to set the StopWatch to zero
	******************************************************************/
	public StopWatch() {
		if (mutate) {
			min = 0;
			sec = 0;
			msec = 0;
		}
	}
	
	/******************************************************************
	Constructor used to initialize instance variables to a specific
	time when minutes, seconds, and milliseconds are provided
	@param minutes number of minutes that have passed
	@param seconds number of seconds that have passed
	@param milliseconds number of milliseconds that have passed
	@throws IllegalArgumentException invalid input argument
	******************************************************************/
	public StopWatch(int minutes, int seconds, int milliseconds) {
		if (mutate) {
			
			//Creates errors if input values aren't correct
			if (minutes < 0 || seconds < 0 || milliseconds < 0)
				throw new IllegalArgumentException("must be positive");
			if (seconds > 59) 
				throw new IllegalArgumentException("sec too high");
			if (milliseconds > 999)
				throw new IllegalArgumentException("msec too high");
			min = minutes;
			sec = seconds;
			msec = milliseconds;
		}
	}
	
	/******************************************************************
	Constructor used to initialize instance variables to a specific
	time when seconds, and milliseconds are provided
	@param seconds number of seconds that have passed
	@param milliseconds number of milliseconds that have passed
	@throws IllegalArgumentException invalid input argument
	******************************************************************/
	public StopWatch(int seconds, int milliseconds) {
		if (mutate) {
			
			//creates errors if input values aren't correct
			if (seconds < 0 || milliseconds < 0)
				throw new IllegalArgumentException("must be positive");
			if (seconds > 59)
				throw new IllegalArgumentException("sec too high");
			if (milliseconds > 999)
				throw new IllegalArgumentException("msec too high");
				sec = seconds;
				msec = milliseconds;
		}
	}
	
	/******************************************************************
	Constructor used to initialize instance variables to a specific
	time when milliseconds are provided
	@param milliseconds number of milliseconds that have passed
	@throws IllegalArgumentException invalid input argument
	******************************************************************/
	public StopWatch(int milliseconds) {
		if (mutate) {
			
			//creates errors if input values aren't correct
			if (milliseconds < 0)
				throw new IllegalArgumentException("must be positive");
			if (milliseconds > 999)
				throw new IllegalArgumentException("msec too high");
			msec = milliseconds;
		}
	}
	
	/******************************************************************
	Constructor used to initialize variables to a specific time
	when a string is provided
	@param startTime string in the format of "xx:xx:xxx"
	******************************************************************/
	public StopWatch(String startTime) {
		if (mutate) {
			
			//Splits starTime into an array based on locations of ':'
			String[] tokens = startTime.split(":");
			
			//Parsing is based upon size of the tokens array
			switch (tokens.length) {
			case 1: min = 0;
					sec = 0;
					msec = Integer.parseInt(tokens[0].trim());
					break;
			case 2: min = 0;
					sec = Integer.parseInt(tokens[0].trim());
					msec = Integer.parseInt(tokens[1].trim());
					break;
			case 3: min = Integer.parseInt(tokens[0].trim());
					sec = Integer.parseInt(tokens[1].trim());
					msec = Integer.parseInt(tokens[2].trim());
					break;
			}
		}
	}

	
	/******************************************************************
	Returns true if this StopWatch is the same as another
	@param other input StopWatch
	@return true if 'this' StopWatch equals 'other' StopWatch
	******************************************************************/
	public boolean equals (StopWatch other) {
		if (min != other.min || sec != other.sec || msec != other.msec) 
			return false;
		else
			return true;
	}
	
	/******************************************************************
	Returns true if 'this' StopWatch object is the same as the
	'other' StopWatch object
	@param other input StopWatch object
	@return true if this StopWatch Object equals other StopWatch object
	******************************************************************/
	public boolean equals (Object other) {
		if (min == ((StopWatch) other).min
				&& sec == ((StopWatch) other).sec
				&& msec == ((StopWatch) other).msec)
			return true;
		else
			return false;
	}
	
	/******************************************************************
	Returns true if one input StopWatch 's1' is equal to another input
	StopWatch 's2'
	@param s1 first input StopWatch
	@param s2 second input StopWatch
	@return true if StopWatch s1 equals StopWatch s2
	******************************************************************/
	public static boolean equals (StopWatch s1, StopWatch s2) {
		if (s1.min == s2.min
				&& s1.sec == s2.sec
				&& s1.msec == s2.msec)
			return true;
		else
			return false;
	}
	
	/******************************************************************
	Returns a value dependent on the comparison of the time of 'this'
	StopWatch object and 'other' StopWatch object
	@param other input StopWatch
	@return 1 if this Stopwatch is greater than other StopWatch, -1 if
	this StopWatch is less than other StopWatch, 0 if this StopWatch
	equals other StopWatch
	******************************************************************/
	public int compareTo(StopWatch other) {
		
		/** total used for this StopWatch */
		int total1;
		
		/** total used for other StopWatch */
		int total2;
		
		total1 = (min * 60000) + (sec * 1000) + msec;
		total2 = (other.min * 60000) + (other.sec * 1000) + other.msec;
		
		if (total1 > total2)
			return 1;
		else if (total1 < total2)
			return -1;
		else
			return 0;
	}
	
	/******************************************************************
	Adds the input milliseconds to this StopWatch
	@param milliseconds input milliseconds
	******************************************************************/
	public void add(int milliseconds) {
		if (mutate) {
			
			//increases msec until desired amount is added
			for (int i = 0 ; i < milliseconds ; i++) {
				inc();
			}
		}
	}
	
	/******************************************************************
	Adds the entire 'other' StopWatch time to 'this' StopWatch
	@param other input StopWatch
	******************************************************************/
	public void add(StopWatch other) {
		
		/** used to convert 'this' StopWatch */
		int total1;
		
		/**used to convert 'other' StopWatch */
		int total2;
		
		/** used to convert milliseconds to sec/msec */
		int totMsec;
		
		if (mutate) {
			total1 = (min * 60000) + (sec * 1000) + msec;
			total2 = (other.min * 60000);
			total2 += (other.sec * 1000) + other.msec;
			total1 += total2;			
			min = total1 / 60000;
			totMsec = total1 % 60000;
			sec = totMsec / 1000;
			msec = total1 % 1000;
		}
	}
	
	/******************************************************************
	Increases msec by a single millisecond
	******************************************************************/
	public void inc() {
		if (mutate) {
			if (msec == 999 && sec == 59) {
				min++;
				sec = 0;
				msec = 0;
			}
			else if (msec == 999 && sec < 59) {
				sec++;
				msec = 0;
			}
			else
				msec++;
		}
	}
	
	/******************************************************************
	Returns a string to represent the time of StopWatch
	@return a string representing the time of 'this' StopWatch
	******************************************************************/
	public String toString() {
		
		/** used to represent the int values of 'this' StopWatch */
		String time = "";
		
		time += ("" + min + ":");
		if (sec < 10)
			time += ("0" + sec + ":");
		else
			time += ("" + sec + ":");
		if (msec > 100)
			time += ("" + msec);
		if (msec < 100 && msec >= 10)
			time += ("0" + msec);
		if (msec < 10)
			time += ("00" + msec);
		return time;
	}
	
	/******************************************************************
	Saves the time on StopWatch by outputting to a file
	@param fileName the name of the input file
	******************************************************************/
	public void save(String fileName) {
		
		/** used to write time info to 'fileName' */
		PrintWriter out = null;
		
		try {
			out = new PrintWriter(new BufferedWriter(
					new FileWriter(fileName)));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		//Writes the time in "x:xx:xxx" format to 'fileName'
		out.println(min + ":" + sec + ":" + msec);
		out.close();
	}
	
	/******************************************************************
	Loads the time on a StopWatch by reading a file's input
	@param fileName the name of the output file
	******************************************************************/
	public void load(String fileName) {		
		try {
			/** used to read 'fileName' */
			FileReader inFile = new FileReader(fileName);
			
			/** used to read lines of 'fileName' */
			BufferedReader bufReader = new BufferedReader(inFile);
			
			/** the information kept on 'fileName' */
			String inputTime;
			
			//Reads the time on fileName, which is in format "x:xx:xxx"
			while ((inputTime = bufReader.readLine()) != null) {
				String[] tokens = inputTime.split(":");
				switch (tokens.length) {
				case 1: min = 0;
						sec = 0;
						msec = Integer.parseInt(tokens[0].trim());
						break;
				case 2: min = 0;
						sec = Integer.parseInt(tokens[0].trim());
						msec = Integer.parseInt(tokens[1].trim());
						break;
				case 3: min = Integer.parseInt(tokens[0].trim());
						sec = Integer.parseInt(tokens[1].trim());
						msec = Integer.parseInt(tokens[2].trim());
						break;
				}
			}
			bufReader.close();
		}
		catch (IOException e) {
			System.out.println("Something went wrong.");
		}
	}
	
	/******************************************************************
	Determines whether or not StopWatch objects are allowed to mutate
	@param mutate true allows StopWatch objects to change,
	false does not allow StopWatch objects to change
	******************************************************************/
	public static void setMutate (boolean mutate) {
		StopWatch.mutate = mutate;
	}
	
	/******************************************************************
	Main Method - used to test StopWatch
	******************************************************************/
	public static void main(String[] args) {
		
		//tests creation of blank StopWatch
		StopWatch s1 = new StopWatch();
		System.out.println("Time: " + s1);
		
		//tests creation of StopWatch with 3 input values
		s1 = new StopWatch(5, 24, 395);
		System.out.println("Time: " + s1);
		
		//tests leading zero for msec
		s1 = new StopWatch(5, 24, 39);
		System.out.println ("Time: " + s1);
		
		//tests leading zero for sec and msec
		s1 = new StopWatch(5, 2, 39);
		System.out.println ("Time: " + s1);
		
		//tests leading zero for sec, leading zeros for msec
		s1 = new StopWatch(5, 2, 3);
		System.out.println ("Time: " + s1);
		
		//tests creation of StopWatch with 2 input values
		s1 = new StopWatch(24, 395);
		System.out.println ("Time: " + s1);
		
		//tests leading zero for msec
		s1 = new StopWatch(24, 39);
		System.out.println ("Time: " + s1);
		
		//tests leading zero for sec and msec
		s1 = new StopWatch(2, 39);
		System.out.println ("Time: " + s1);
		
		//tests leading zero for sec, leading zeros for msec
		s1 = new StopWatch(2, 3);
		System.out.println ("Time: " + s1);
		
		//tests creation of StopWatch with single input value
		s1 = new StopWatch(395);
		System.out.println ("Time: " + s1);
		
		//tests leading zero for msec
		s1 = new StopWatch(39);
		System.out.println ("Time: " + s1);
		
		//tests leading zeros for msec
		s1 = new StopWatch(3);
		System.out.println ("Time: " + s1);
		
		//tests StopWatch creation with 3 values in String
		s1 = new StopWatch("5:24:395");
		System.out.println ("Time: " + s1);
		
		//tests leading zero msec
		s1 = new StopWatch("5:24:39");
		System.out.println ("Time: " + s1);
		
		//tests leading zero for sec and msec
		s1 = new StopWatch("5:2:39");
		System.out.println ("Time: " + s1);
		
		//tests leading zero for sec, leading zeros for msec
		s1 = new StopWatch("5:2:3");
		System.out.println ("Time: " + s1);
		
		//tests StopWatch creation with 2 values in String
		s1 = new StopWatch("24:395");
		System.out.println ("Time: " + s1);
		
		//tests StopWatch creation with 1 value in String
		s1 = new StopWatch("395");
		System.out.println ("Time: " + s1);
		
		//tests equals() method of different values
		StopWatch s2 = new StopWatch(19, 4, 55);
		if (StopWatch.equals(s1, s2))
			System.out.println("error - should not equal each other");
		else
			System.out.println("s != s2. " + s1 + " != " + s2);
		
		//tests equals() method of same values
		s1 = new StopWatch(19, 4, 55);
		if (StopWatch.equals(s1, s2))
			System.out.println("s = s2. " + s1 + " = " + s2);
		else
			System.out.println("error - should equal each other");
		
		//tests compareTo() method when s > s2
		s1 = new StopWatch(5, 24, 395);
		switch (s1.compareTo(s2)) {
		case 1: System.out.println("s > s2");
				break;
		case 0: System.out.println("s = s2");
				break;
		case -1: System.out.println("s < s2");
		}
		
		//tests compareTo() method when s < s2
		s1 = new StopWatch(24, 24, 395);
		switch (s1.compareTo(s2)) {
		case 1: System.out.println("s > s2");
				break;
		case 0: System.out.println("s = s2");
				break;
		case -1: System.out.println("s < s2");
		}
		
		//tests compareTo() method when s = s2
		s1 = new StopWatch(19, 4, 55);
		switch (s1.compareTo(s2)) {
		case 1: System.out.println("s > s2");
				break;
		case 0: System.out.println("s = s2");
				break;
		case -1: System.out.println("s < s2");
		}
		
		//tests add() method with value greater than 1000
		s1 = new StopWatch(10, 10, 10);
		s1.add(1001);
		System.out.println("Time: " + s1);
		
		//tests add() method using other StopWatch
		s1 = new StopWatch(5, 0, 0);
		s2 = new StopWatch(10, 5, 5);
		s1.add(s2);
		System.out.println("Time: " + s1);
		
		//tests inc() method once
		s1 = new StopWatch(10, 10, 10);
		s1.inc();
		System.out.println("Time: " + s1);
		
		//tests inc() method with value greater than 1000
		s1 = new StopWatch(10, 10, 10);
		for (int i = 0 ; i < 4000 ; i++) {
			s1.inc();
		}
		System.out.println("Time: " + s1);
	}
}
