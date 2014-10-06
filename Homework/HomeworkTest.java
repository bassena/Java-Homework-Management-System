package Homework;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

public class HomeworkTest {
	
	/*
	 * Test Cases for: equals() method  
	 */
@Test
	public void equalsTest1() {
		Homework hw1 = new Homework("420-A11", "assignment", 1);
		Homework hw2 = new Homework("420-A11", "assignment", 1);
		assertTrue("Test Case 1 -- Successful equals()", hw1.equals(hw2));
	}//equalsTest1()
	
	@Test
	public void equalsTest2(){
		Homework hw1 = new Homework("420-A11", "assignment", 1);
		Homework hw3 = new Homework("420-A11", "assignment", 2);
		assertFalse("Test Case 2 -- Not same assignment number", hw1.equals(hw3));
	}//equalsTest2()
	
	@Test
	public void equalsTest3(){
		Homework hw1 = new Homework("420-A11", "assignment", 1);
		Homework hw4 = new Homework("420-A11", "lab", 1);
		assertFalse("Test Case 3 -- Not same assignment type", hw1.equals(hw4));
	}//equalsTest3()
	
	@Test
	public void equalsTest4() {
		Homework hw1 = new Homework("420-A11", "assignment", 1);
		Homework hw5 = new Homework("420-B31", "assignment", 1);
		assertFalse("Test Case 4 -- Not same course number", hw1.equals(hw5));
	}//equalsTest4()
	
	@Test
	public void equalsTest5() {
		Homework hw1 = new Homework("420-A11", "assignment", 1);
		Homework hw6 = new Homework();
		assertFalse("Test Case 5 -- Instantiation without attributes", hw1.equals(hw6));
	}//equalsTest5()
	
	
	/*
	 * Test Cases for: compareTo() method
	 */
	
	@Test
	public void compareToTest1(){
		Homework hw1 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 8, 10), new GregorianCalendar(2014, 9, 10));
		Homework hw2 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 8, 20), new GregorianCalendar(2014, 9, 10));
		assertEquals("Test Case 1 -- Successful Compare of Dates", 0, hw1.compareTo(hw2));
	}//compareToTest1()
	
	@Test
	public void compareToTest2(){
		Homework hw1 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 8, 10), new GregorianCalendar(2014, 9, 10));
		Homework hw3 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 8, 20), new GregorianCalendar(2014, 9, 11));
		assertEquals("Test Case 2 -- First date earlier than compared date", -1, hw1.compareTo(hw3));
	}//compareToTest2()
	
	@Test
	public void compareToTest3(){
		Homework hw1 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 8, 10), new GregorianCalendar(2014, 9, 11));
		Homework hw4 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 8, 20), new GregorianCalendar(2014, 9, 10));
		assertEquals("Test Case 3 -- First date later than compared date", 1, hw1.compareTo(hw4));
	}//compareToTest2()
	
	
	/*
	 * Simple test case to test the display of the returned
	 * value of the Homework toString() method.
	 */
	
	@Test
	public void toStringTest(){
		Homework hw1 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 8, 10), new GregorianCalendar(2014, 9, 21));
		System.out.println(hw1.toString());
		assertTrue(true);
	}
}//HomeworkTest JUnit class
