/**********************************************************************
JUnit testing of StopWatch class

@author Conner Toney
@version GVSU Fall 2014
**********************************************************************/
package package1;

import org.junit.Test;
import org.junit.Assert;

public class TestStopWatch {
	
	//tests setMutate() method
	@Test
	public void testMutate() {
		StopWatch s1 = new StopWatch(5, 10, 5);
		StopWatch s2 = new StopWatch(5, 10, 5);
		StopWatch.setMutate(false);
		s1.add(1000);
		StopWatch.setMutate(true);
		
		Assert.assertTrue(s1.equals(s2));
	}
	

	//tests neg min with 3 input values
	@Test (expected = IllegalArgumentException.class)
	public void testNeg1() {
		new StopWatch(-4, 2, 50);
	}
	
	//tests neg sec with 3 input values
	@Test (expected = IllegalArgumentException.class)
	public void testNeg2() {
		new StopWatch(4, -2, 50);
	}
	
	//tests neg msec with 3 input values
	@Test (expected = IllegalArgumentException.class)
	public void testNeg3() {
		new StopWatch(4, 2, -50);
	}
	
	//tests neg sec with 2 input values
	@Test (expected = IllegalArgumentException.class)
	public void testNeg4() {
		new StopWatch(-2, 20);
	}
	
	//tests neg msec with 2 input values
	@Test (expected = IllegalArgumentException.class)
	public void testNeg5() {
		new StopWatch(2, -20);
	}
	
	//tests neg msec with 1 input value
	@Test (expected = IllegalArgumentException.class)
	public void testNeg6() {
		new StopWatch(-20);
	}
	
	//tests input error with 3 input values for sec
	@Test (expected = IllegalArgumentException.class)
	public void testErrorInput1() {
		new StopWatch(5, 60, 4);
	}
	
	//tests input error with 3 input values for msec
	@Test (expected = IllegalArgumentException.class)
	public void testErrorInput2() {
		new StopWatch(5, 5, 1000);
	}
	
	//tests input error with 2 input values for sec
	@Test (expected = IllegalArgumentException.class)
	public void testErrorInput3() {
		new StopWatch(60, 5);
	}
	
	//tests input error with 2 input values for msec
	@Test (expected = IllegalArgumentException.class)
	public void testErrorInput4() {
		new StopWatch(4, 1000);
	}
	
	//tests input error with 1 input value for msec
	@Test (expected = IllegalArgumentException.class)
	public void testErrorInput5() {
		new StopWatch(1000);
	}
	
	//tests true equals() method with 3 input values
	@Test
	public void testTrueEquals1() {
		StopWatch s1 = new StopWatch(5, 4, 20);
		StopWatch s2 = new StopWatch(5, 4, 20);
		
		Assert.assertTrue(s1.equals(s2));
	}
	
	//tests true equals() method with 2 input values
	@Test
	public void testTrueEquals2() {
		StopWatch s1 = new StopWatch(4, 20);
		StopWatch s2 = new StopWatch(4, 20);
		
		Assert.assertTrue(s1.equals(s2));
	}
	
	//tests true equals() method with 1 input value
	@Test
	public void testTrueEquals3() {
		StopWatch s1 = new StopWatch(20);
		StopWatch s2 = new StopWatch(20);
		
		Assert.assertTrue(s1.equals(s2));
	}
	
	//tests false equals() method with 3 input values
	@Test
	public void testFalseEquals1() {
		StopWatch s1 = new StopWatch(5, 4, 20);
		StopWatch s2 = new StopWatch(6, 5, 21);
		
		Assert.assertFalse(s1.equals(s2));
	}
	
	//tests false equals() method with 2 input values
	@Test
	public void testFalseEquals2() {
		StopWatch s1 = new StopWatch(4, 20);
		StopWatch s2 = new StopWatch(5, 21);
		
		Assert.assertFalse(s1.equals(s2));
	}
	
	//tests false equals() method with 1 input value
	@Test
	public void testFalseEquals3() {
		StopWatch s1 = new StopWatch(20);
		StopWatch s2 = new StopWatch(21);
		
		Assert.assertFalse(s1.equals(s2));
	}
	
	//tests true equals() method with String input of 3 values
	@Test 
	public void testTrueEquals4() {
		StopWatch s1 = new StopWatch("5:4:20");
		StopWatch s2 = new StopWatch(5, 4, 20);
		
		Assert.assertTrue(s1.equals(s2));
	}
	
	//tests false equals() method with String input of 3 values
	@Test
	public void testFalseEquals4() {
		StopWatch s1 = new StopWatch("5:4:20");
		StopWatch s2 = new StopWatch(6, 5, 21);
		
		Assert.assertFalse(s1.equals(s2));
	}
	
	//tests true equals() method with String input of 2 values
	@Test
	public void testTrueEquals5() {
		StopWatch s1 = new StopWatch("4:20");
		StopWatch s2 = new StopWatch(4, 20);
		
		Assert.assertTrue(s1.equals(s2));
	}
	
	//tests false equals() method with String input of 2 values
	@Test
	public void testFalseEquals5() {
		StopWatch s1 = new StopWatch("4:20");
		StopWatch s2 = new StopWatch(5, 21);
		
		Assert.assertFalse(s1.equals(s2));
	}
	
	//tests true equals() method with String input of 1 value
	@Test
	public void testTrueEquals6() {
		StopWatch s1 = new StopWatch("20");
		StopWatch s2 = new StopWatch(20);
		
		Assert.assertTrue(s1.equals(s2));
	}
	
	//tests false equals() method with String input of 1 value
	@Test
	public void testFalseEquals6() {
		StopWatch s1 = new StopWatch("20");
		StopWatch s2 = new StopWatch(21);
		
		Assert.assertFalse(s1.equals(s2));
	}
	
	//tests true equals() method for blank StopWatch constructor
	@Test
	public void testBlank() {
		StopWatch s1 = new StopWatch();
		StopWatch s2 = new StopWatch(0, 0, 0);
		
		Assert.assertTrue(s1.equals(s2));
	}
	
	//tests compareTo() method for s1 < s2 --> -1
	@Test
	public void testCompareTo1() {
		StopWatch s1 = new StopWatch(5, 4, 20);
		StopWatch s2 = new StopWatch(6, 5, 21);
		
		Assert.assertEquals(s1.compareTo(s2), -1);
	}
	
	//tests compareTo() method for s2 > s1 --> 1
	@Test
	public void testCompareTo2() {
		StopWatch s1 = new StopWatch(5, 4, 20);
		StopWatch s2 = new StopWatch(6, 5, 21);
		
		Assert.assertEquals(s2.compareTo(s1), 1);
	}
	
	//tests compareTo() method for s1 = s2 --> 0
	@Test
	public void testCompareTo3() {
		StopWatch s1 = new StopWatch(5, 4, 20);
		StopWatch s2 = new StopWatch(5, 4, 20);
		
		Assert.assertEquals(s1.compareTo(s2), 0);
	}
	
	//tests add()/inc() method for an added second
	@Test
	public void testAdd1() {
		StopWatch s1 = new StopWatch(5, 0, 0);
		StopWatch s2 = new StopWatch(5, 1, 0);
		s1.add(1000);
		
		Assert.assertTrue(s2.equals(s1));
	}
	
	//tests add()/inc() method for an added minute
	@Test
	public void testAdd2() {
		StopWatch s1 = new StopWatch(5, 0, 0);
		StopWatch s2 = new StopWatch(6, 0, 0);
		s1.add(60000);
		
		Assert.assertTrue(s2.equals(s1));
	}
	
	//tests add()/inc() method for an added StopWatch object
	@Test
	public void testAdd3() {
		StopWatch s1 = new StopWatch(5, 0, 0);
		StopWatch s2 = new StopWatch(5, 0, 0);
		StopWatch s3 = new StopWatch(10, 0, 0);
		s1.add(s2);
		
		Assert.assertTrue(s3.equals(s1));
	}
	
	//tests save() and load() method
	@Test
	public void testSaveLoad() {
		StopWatch s1 = new StopWatch(5, 4, 20);
		StopWatch s2 = new StopWatch(5, 4, 20);
		s1.save("timeForTest.txt");
		s1 = new StopWatch(2, 5, 3);
		s1.load("timeForTest.txt");
		
		Assert.assertTrue(s1.equals(s2));
	}
}
