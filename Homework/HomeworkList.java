package Homework;
import java.util.Date;
import java.util.GregorianCalendar;

import linkedList.*;

public class HomeworkList {
	private SinglyLinkedList<Homework> HWList = new SinglyLinkedList<Homework>();
	
	public SinglyLinkedList<Homework> getHomeworkList(){
		return HWList;
	}
	
	
	public void addAssignment(Homework hw){
		HWList.add(hw, HWList.getLength());
	}//addAssignment(Homework)
	
	
	public void removeAssignment(Homework hw){
		boolean removed = false;
		for(int i = 0; i < HWList.getLength(); i++){
			if(hw.equals(HWList.getElementAt(i))){
				HWList.remove(i);
				removed = true;
			}//if
		}//for
		if(!removed){
			throw new IllegalArgumentException("Homework was not found and could not be removed.");
		}//if
	}//removeAssignment(Homework)
	
	
	public SinglyLinkedList<Homework> findNextDueAssignments(){
		
		if(HWList.getLength() == 0){
			throw new IndexOutOfBoundsException("Could not find assignments, none were added to the list.");
		}
		
		GregorianCalendar keptDate = HWList.getElementAt(0).getDateDue();
		SinglyLinkedList<Homework> nextDueAssignments = new SinglyLinkedList<Homework>();
		for(int i = 0; i < HWList.getLength(); i++){
			if(keptDate.after(HWList.getElementAt(i).getDateDue())){
				keptDate = HWList.getElementAt(i).getDateDue();
			}
		}//for
		
		if(keptDate != null){
			
			for(int i = 0; i <HWList.getLength(); i++){
				if(keptDate.compareTo(HWList.getElementAt(i).getDateDue()) == 0){
					nextDueAssignments.add(HWList.getElementAt(i), nextDueAssignments.getLength());
				}//if
			}//for
		}//if
		return nextDueAssignments;
	}//findNextDueAssignment()
	
	
	public SinglyLinkedList<Homework> showAssignmentsByAssignedDate(){
		
		if(HWList.getLength() == 0){
			throw new IndexOutOfBoundsException("Could not sort assignments, none were added to the list.");
		}
		
		SinglyLinkedList<Homework> assignedAsmts = new SinglyLinkedList<Homework>();
		Homework[] asmts = new Homework[HWList.getLength()];
		Homework temp;
		
		for(int i = 0; i < asmts.length; i++){
			asmts[i] = HWList.getElementAt(i);
		}
		
		
		//Bubble sort of the asmts array based on the assigned date.
		for(int i = 0; i < asmts.length; i++){
			for(int j = 1; j < asmts.length; j++){
				if(asmts[j-1].getDateAssigned().compareTo(asmts[j].getDateAssigned()) > 0){
					temp = asmts[j-1];
					asmts[j-1] = asmts[j];
					asmts[j] = temp;
				}//if
			}//for
		}//for
		
		
		//With the newly sorted array, reassign the assignments to the the SinglyLinkedList assignedAsmts.
		for(int i = 0; i < asmts.length; i++){
			assignedAsmts.add(asmts[i], assignedAsmts.getLength());
		}
		
		return assignedAsmts;
	}//showAssignmentsByAssignedDate()
	
	
	public SinglyLinkedList<Homework> showAssignmentsByDueDate(){
		if(HWList.getLength() == 0){
			throw new IndexOutOfBoundsException("Could not sort assignments, none were added to the list.");
		}
		
		SinglyLinkedList<Homework> assignedAsmts = new SinglyLinkedList<Homework>();
		Homework[] asmts = new Homework[HWList.getLength()];
		Homework temp;
		
		for(int i = 0; i < asmts.length; i++){
			asmts[i] = HWList.getElementAt(i);
		}
		
		
		//Bubble sort of the asmts array based on the due date.
		for(int i = 0; i < asmts.length; i++){
			for(int j = 1; j < asmts.length; j++){
				if(asmts[j-1].getDateDue().compareTo(asmts[j].getDateDue()) > 0){
					temp = asmts[j-1];
					asmts[j-1] = asmts[j];
					asmts[j] = temp;
				}//if
			}//for
		}//for
		
		
		//With the newly sorted array, reassign the assignments to the the SinglyLinkedList assignedAsmts.
		for(int i = 0; i < asmts.length; i++){
			assignedAsmts.add(asmts[i], assignedAsmts.getLength());
		}
		
		return assignedAsmts;
	}//showAssignmentsByDueDate()
}//HomeworkList class
