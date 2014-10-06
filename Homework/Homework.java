package Homework;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Homework {
	private String courseNumber, assignmentType, assignmentDescription;
	private int assignmentNumber;
	private GregorianCalendar dateAssigned, dateDue;
	
	public Homework(){
		courseNumber = "";
		assignmentType = "";
		assignmentDescription = "";
		assignmentNumber = 0;
		dateAssigned = new GregorianCalendar();
		dateDue = new GregorianCalendar();;
	}//Homework()
	
	public Homework(String cNum, String asmtType, int asmtNum){
		courseNumber = cNum;
		assignmentType = asmtType;
		assignmentDescription = "";
		assignmentNumber = asmtNum;
		dateAssigned = new GregorianCalendar();;
		dateDue = new GregorianCalendar();;
	}//Homework(String, String, int)
	
	public Homework(String cNum, String asmtType, int asmtNum, String asmtDesc, GregorianCalendar dAss, GregorianCalendar dDue){
		courseNumber = cNum;
		assignmentType = asmtType;
		assignmentDescription = asmtDesc;
		assignmentNumber = asmtNum;
		dateAssigned = dAss;
		dateDue = dDue;
	}//Homework(String, String, int, String, GregorianCalendar, GregorianCalendar)
	
	public boolean equals(Object hw){
		if(((Homework)hw).getCourseNumber().equals(this.courseNumber) && ((Homework)hw).getAssignmentType().equals(this.assignmentType) && ((Homework)hw).getAssignmentNumber() == this.assignmentNumber){
			return true;
		}else{
			return false;
		}
	}//equals(Homework)
	
	
	/*
	 * GregorianCalendars displayed as mm/dd/yyyy
	 */
	public String toString(){
		String result = "Course Number: " + courseNumber +
						"\nAssignment Type: " + assignmentType +
						(!assignmentDescription.equals("") ? "\nAssignment Description: " + assignmentDescription : "") +
						"\nAssignment Number: " + assignmentNumber +
						"\nDate Assigned: " + (dateAssigned.get(Calendar.MONTH) + 1) + "/" + dateAssigned.get(Calendar.DAY_OF_MONTH) + "/" + dateAssigned.get(Calendar.YEAR) +
						"\nDate Due: " + (dateDue.get(Calendar.MONTH) + 1) + "/" + dateDue.get(Calendar.DAY_OF_MONTH) + "/" + dateDue.get(Calendar.YEAR);
		return result;
	}
	
	public int compareTo(Homework obj){
		return this.dateDue.compareTo(obj.getDateDue());
	}//compareTo(Homework)

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getAssignmentType() {
		return assignmentType;
	}

	public void setAssignmentType(String assignmentType) {
		this.assignmentType = assignmentType;
	}

	public String getAssignmentDescription() {
		return assignmentDescription;
	}

	public void setAssignmentDescription(String assignmentDescription) {
		this.assignmentDescription = assignmentDescription;
	}

	public int getAssignmentNumber() {
		return assignmentNumber;
	}

	public void setAssignmentNumber(int assignmentNumber) {
		this.assignmentNumber = assignmentNumber;
	}

	public GregorianCalendar getDateAssigned() {
		return dateAssigned;
	}

	public void setDateAssigned(GregorianCalendar dateAssigned) {
		this.dateAssigned = dateAssigned;
	}

	public GregorianCalendar getDateDue() {
		return dateDue;
	}

	public void setDateDue(GregorianCalendar dateDue) {
		this.dateDue = dateDue;
	}
}//Homework class
