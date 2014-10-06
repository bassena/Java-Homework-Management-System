package Homework;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import linkedList.SinglyLinkedList;

import org.junit.Test;

public class HomeworkListTest {

	/*
	 * Test Cases for: addAssignment()
	 */
	@Test
	public void addAssignmentTest1() {
		HomeworkList HWList = new HomeworkList();
		Homework hw = new Homework("420-B10", "assignment", 1);
		Homework hw1 = new Homework("420-C10", "assignment", 2);
		HWList.addAssignment(hw);
		HWList.addAssignment(hw1);
		assertEquals("Test Case 1 -- Successful add of a Homework to list", 2, HWList.getHomeworkList().getLength());
	}//addAssignmentTest1()
	
	
	@Test
	public void addAssignmentTest2(){
		HomeworkList HWList = new HomeworkList();
		Homework hw2 = new Homework("420-B10", "assignment", 1, "", new GregorianCalendar(2014, 8, 10), new GregorianCalendar(2014, 9, 10));
		HWList.addAssignment(hw2);
		assertEquals("Test Case 2 -- Successful add of an empty Homework to list", 1, HWList.getHomeworkList().getLength());
	}//addAssignmentTest2()
	
	
	@Test
	public void addAssignmentTest3(){
		HomeworkList HWList = new HomeworkList();
		Homework hw3 = new Homework();
		HWList.addAssignment(hw3);
		assertEquals("Test Case 3 -- Successful add of an empty Homework to list", 1, HWList.getHomeworkList().getLength());
	}//addAssignmentTest3()
	
	
	/*
	 * Test Cases for: removeAssignment()
	 */
	@Test
	public void removeAssignmentTest1(){
		HomeworkList HWList = new HomeworkList();
		Homework hw1 = new Homework("420-A11", "assignment", 1);
		Homework hw2 = new Homework("420-B10", "assignment", 1);
		HWList.addAssignment(hw1);
		HWList.addAssignment(hw2);
		assertEquals("Test Case 1 -- Check to see if the assignments were added.", 2, HWList.getHomeworkList().getLength());
		try{
			HWList.removeAssignment(new Homework("420-A11", "assignment", 1));
			assertEquals("Test Case 1 -- Make sure that the assignment was removed.", 1, HWList.getHomeworkList().getLength());
		}catch(IllegalArgumentException e){
			fail(e.getMessage());
		}//catch
	}//removeAssignmentTest1()
	
	
	@Test
	public void removeAssignmentTest2(){
		HomeworkList HWList = new HomeworkList();
		Homework hw1 = new Homework("420-A11", "assignment", 1);
		Homework hw2 = new Homework("420-B10", "assignment", 1);
		HWList.addAssignment(hw1);
		HWList.addAssignment(hw2);
		assertEquals("Test Case 2 -- Check to see if the assignments were added.", 2, HWList.getHomeworkList().getLength());
		try{
			HWList.removeAssignment(new Homework("430-B11", "assignment", 1));
			assertEquals("Test Case 2 -- Homework should not be found.", 1, HWList.getHomeworkList().getLength());
			fail();
		}catch(IllegalArgumentException e){
			assertTrue("Test Case 2 -- " + e.getMessage(), true);
		}//catch
	}//removeAssignmentTest2()
	
	
	/*
	 * Test Cases for: findNextDueAssignments()
	 */
	@Test
	public void findNextAssignmentsTest1(){
		HomeworkList HWList = new HomeworkList();
		
		Homework hw1 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 5, 10), new GregorianCalendar(2014, 5, 20));
		Homework hw2 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 5, 10), new GregorianCalendar(2014, 6, 10));
		Homework hw3 = new Homework("420-B10", "assignment", 1, "", new GregorianCalendar(2014, 5, 10), new GregorianCalendar(2014, 5, 20));
		Homework hw4 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 5, 10), new GregorianCalendar(2014, 6, 13));
		HWList.addAssignment(hw1);
		HWList.addAssignment(hw2);
		HWList.addAssignment(hw3);
		HWList.addAssignment(hw4);
		
		SinglyLinkedList<Homework> dueAsmts = HWList.findNextDueAssignments();
		assertTrue("Test Case 1 -- Check to see if hw1 was included.", dueAsmts.getElementAt(0).equals(hw1));
		assertTrue("Test Case 1 -- Check to see if hw3 was included.", dueAsmts.getElementAt(1).equals(hw3));
	}//findNextAssignmentsTest1()
	
	
	public void findNextAssignmentsTest2(){
		HomeworkList HWList = new HomeworkList();
		
		Homework hw1 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 5, 10), new GregorianCalendar(2014, 5, 20));
		Homework hw2 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 5, 15), new GregorianCalendar(2014, 6, 10));
		Homework hw3 = new Homework("420-B10", "assignment", 1, "", new GregorianCalendar(2014, 5, 20), new GregorianCalendar(2014, 5, 20));
		Homework hw4 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 5, 25), new GregorianCalendar(2014, 6, 13));
		
		SinglyLinkedList<Homework> dueAsmts = HWList.findNextDueAssignments();
		assertFalse("Test Case 2 -- No Homework objects added thus cannot be retrieved.", dueAsmts.getElementAt(0).equals(hw1));
	}//findNextAssignmentsTest2()
	
	
	/*
	 * Test cases for: showAssignmentsByAssignedDate()
	 */
	@Test
	public void showByAssignedDateTest1(){
		HomeworkList HWList = new HomeworkList();
		
		Homework hw1 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 5, 20), new GregorianCalendar(2014, 5, 20));
		Homework hw2 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 5, 15), new GregorianCalendar(2014, 6, 10));
		Homework hw3 = new Homework("420-B10", "assignment", 1, "", new GregorianCalendar(2014, 5, 25), new GregorianCalendar(2014, 5, 20));
		Homework hw4 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 5, 10), new GregorianCalendar(2014, 6, 13));
		HWList.addAssignment(hw1);
		HWList.addAssignment(hw2);
		HWList.addAssignment(hw3);
		HWList.addAssignment(hw4);
		
		SinglyLinkedList<Homework> sortedAsmts = HWList.showAssignmentsByAssignedDate();
		
		assertEquals("Test Case 1 -- See if the first element is correct.", hw4, sortedAsmts.getElementAt(0));
		assertEquals("Test Case 1 -- See if the second element is correct.", hw2, sortedAsmts.getElementAt(1));
		assertEquals("Test Case 1 -- See if the third element is correct.", hw1, sortedAsmts.getElementAt(2));
		assertEquals("Test Case 1 -- See if the last element is correct.", hw3, sortedAsmts.getElementAt(3));
	}//showByAssignedDateTest1()
	
	
	@Test
	public void showByAssignedDateTest2(){
		HomeworkList HWList = new HomeworkList();
		
		Homework hw1 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 5, 20), new GregorianCalendar(2014, 5, 20));
		Homework hw2 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 5, 15), new GregorianCalendar(2014, 6, 10));
		
		try{
			SinglyLinkedList<Homework> sortedAsmts = HWList.showAssignmentsByAssignedDate();
			fail("Test Case 2 -- IndexOutOfBoundsException was not thrown.");
		}catch(IndexOutOfBoundsException e){
			assertTrue("Test Case 2 -- " + e.getMessage(), true);
		}
	}//showByAssignedDateTest2()
	
	
	/*
	 * Test Cases for: showAssignmentsByDueDate()
	 */
	@Test
	public void showAsmtsByDueDateTest1(){
		HomeworkList HWList = new HomeworkList();
		
		Homework hw1 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 5, 20), new GregorianCalendar(2014, 5, 23));
		Homework hw2 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 5, 15), new GregorianCalendar(2014, 6, 6));
		Homework hw3 = new Homework("420-B10", "assignment", 1, "", new GregorianCalendar(2014, 5, 25), new GregorianCalendar(2014, 5, 20));
		Homework hw4 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 5, 10), new GregorianCalendar(2014, 6, 13));
		HWList.addAssignment(hw1);
		HWList.addAssignment(hw2);
		HWList.addAssignment(hw3);
		HWList.addAssignment(hw4);
		
		SinglyLinkedList<Homework> sortedAsmts = HWList.showAssignmentsByDueDate();
		
		assertEquals("Test Case 1 -- See if the first element is correct.", hw3, sortedAsmts.getElementAt(0));
		assertEquals("Test Case 1 -- See if the second element is correct.", hw1, sortedAsmts.getElementAt(1));
		assertEquals("Test Case 1 -- See if the third element is correct.", hw2, sortedAsmts.getElementAt(2));
		assertEquals("Test Case 1 -- See if the last element is correct.", hw4, sortedAsmts.getElementAt(3));
	}//showAsmtsByDueDateTest1()
	
	
	@Test
	public void showAsmtsByDueDateTest2(){
		HomeworkList HWList = new HomeworkList();
		
		Homework hw1 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 5, 20), new GregorianCalendar(2014, 5, 20));
		Homework hw2 = new Homework("420-A11", "assignment", 1, "", new GregorianCalendar(2014, 5, 15), new GregorianCalendar(2014, 6, 10));
		
		try{
			SinglyLinkedList<Homework> sortedAsmts = HWList.showAssignmentsByDueDate();
			fail("Test Case 2 -- IndexOutOfBoundsException was not thrown.");
		}catch(IndexOutOfBoundsException e){
			assertTrue("Test Case 2 -- " + e.getMessage(), true);
		}
	}
	
}//HomeworkListTest class