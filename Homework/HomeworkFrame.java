package Homework;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.*;

import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JButton;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.GregorianCalendar;

import javax.swing.JSpinner;
import javax.swing.JComboBox;

import linkedList.SinglyLinkedList;

public class HomeworkFrame extends JFrame implements ActionListener, FocusListener{

	private JPanel contentPane;
	private JTextField courseNumFld;
	private JTextField hwTypeFld;
	private JLabel lblHomework, lblCourseNumber, lblHomeworkType, lblHomeworkNumber, lblHomeworkDescription, lblDateAssigned, lblDateDue, lblRemoveHomework;
	private JEditorPane hwDescFld;
	private JDateChooser dateAssigned, dateDue;
	private JButton btnAddHomework, btnRemove;
	private JSpinner hwNumFld;
	private JComboBox homeworkList;
	
	private HomeworkList homework = new HomeworkList();
	private int hwCounter = 1;
	private JButton btnShowNextAssignments;
	private JButton btnShowAssignmentsByDateAssigned;
	private JButton btnShowAssignmentsByDateDue;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeworkFrame frame = new HomeworkFrame();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomeworkFrame() {
		setTitle("Homework Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblHomework = new JLabel("Homework");
		lblHomework.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblHomework.setBounds(239, 11, 115, 50);
		contentPane.add(lblHomework);
		
		lblCourseNumber = new JLabel("Course number:");
		lblCourseNumber.setBounds(81, 74, 113, 14);
		contentPane.add(lblCourseNumber);
		
		lblHomeworkType = new JLabel("Homework type:");
		lblHomeworkType.setBounds(239, 74, 115, 14);
		contentPane.add(lblHomeworkType);
		
		courseNumFld = new JTextField();
		courseNumFld.setBounds(81, 90, 86, 20);
		contentPane.add(courseNumFld);
		courseNumFld.setColumns(10);
		courseNumFld.addFocusListener(this);
		
		hwTypeFld = new JTextField();
		hwTypeFld.setColumns(10);
		hwTypeFld.setBounds(239, 90, 86, 20);
		contentPane.add(hwTypeFld);
		hwTypeFld.addFocusListener(this);
		
		lblHomeworkNumber = new JLabel("Homework number:");
		lblHomeworkNumber.setBounds(401, 74, 115, 14);
		contentPane.add(lblHomeworkNumber);
		
		lblHomeworkDescription = new JLabel("Homework description:");
		lblHomeworkDescription.setBounds(56, 148, 149, 14);
		contentPane.add(lblHomeworkDescription);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 168, 200, 92);
		contentPane.add(scrollPane);
		
		hwDescFld = new JEditorPane();
		scrollPane.setViewportView(hwDescFld);
		
		lblDateAssigned = new JLabel("Date assigned:");
		lblDateAssigned.setBounds(280, 148, 100, 14);
		contentPane.add(lblDateAssigned);
		
		dateAssigned = new JDateChooser();
		dateAssigned.setDateFormatString("dd-MMM-yyyy");
		dateAssigned.setBounds(280, 168, 101, 20);
		contentPane.add(dateAssigned);
		
		lblDateDue = new JLabel("Date due:");
		lblDateDue.setBounds(405, 148, 89, 14);
		contentPane.add(lblDateDue);
		
		dateDue = new JDateChooser();
		dateDue.setBounds(405, 168, 100, 20);
		contentPane.add(dateDue);
		
		btnAddHomework = new JButton("Add Homework");
		btnAddHomework.setBounds(56, 271, 138, 23);
		contentPane.add(btnAddHomework);
		btnAddHomework.addActionListener(this);
		btnAddHomework.setEnabled(false);
		
		hwNumFld = new JSpinner();
		hwNumFld.setBounds(427, 90, 29, 20);
		contentPane.add(hwNumFld);
		
		homeworkList = new JComboBox();
		homeworkList.setEnabled(false);
		homeworkList.setBounds(56, 337, 165, 20);
		contentPane.add(homeworkList);
		homeworkList.addItem("--Choose Homework--");
		homeworkList.addActionListener(this);
		
		lblRemoveHomework = new JLabel("Remove Homework");
		lblRemoveHomework.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRemoveHomework.setBounds(56, 314, 181, 23);
		contentPane.add(lblRemoveHomework);
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(this);
		btnRemove.setBounds(236, 336, 89, 23);
		contentPane.add(btnRemove);
		btnRemove.setEnabled(false);
		
		btnShowNextAssignments = new JButton("Show Next Assignments Due");
		btnShowNextAssignments.setBounds(56, 391, 200, 23);
		contentPane.add(btnShowNextAssignments);
		btnShowNextAssignments.setEnabled(false);
		btnShowNextAssignments.addActionListener(this);
		
		btnShowAssignmentsByDateAssigned = new JButton("Show Assignments by Date Assigned");
		btnShowAssignmentsByDateAssigned.setBounds(56, 425, 254, 23);
		contentPane.add(btnShowAssignmentsByDateAssigned);
		btnShowAssignmentsByDateAssigned.setEnabled(false);
		btnShowAssignmentsByDateAssigned.addActionListener(this);
		
		btnShowAssignmentsByDateDue = new JButton("Show Assignments by Date Due");
		btnShowAssignmentsByDateDue.setBounds(56, 459, 223, 23);
		contentPane.add(btnShowAssignmentsByDateDue);
		btnShowAssignmentsByDateDue.setEnabled(false);
		btnShowAssignmentsByDateDue.addActionListener(this);
		
		((JSpinner.DefaultEditor)hwNumFld.getEditor()).getTextField().addFocusListener(this);
		((JSpinner.DefaultEditor)hwNumFld.getEditor()).getTextField().setEditable(false);
		
	}//HomeworkFrame()

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAddHomework){
			String courseNum = courseNumFld.getText(), hwType = hwTypeFld.getText(), hwDetails = hwDescFld.getText();
			int hwNum = (Integer)hwNumFld.getValue();
			
			if(dateAssigned.getDate() != null && dateDue.getDate() != null){
				GregorianCalendar dAssigned = new GregorianCalendar();
				GregorianCalendar dDue = new GregorianCalendar();
				
				dAssigned.setTime(dateAssigned.getDate());
				dDue.setTime(dateDue.getDate());
				
				homework.addAssignment(new Homework(courseNum, hwType, hwNum, hwDetails, dAssigned, dDue));
				homeworkList.addItem(courseNum  + " " + hwType + " " + hwNum);
				homeworkList.setEnabled(true);
				btnShowNextAssignments.setEnabled(true);
				btnShowAssignmentsByDateAssigned.setEnabled(true);
				btnShowAssignmentsByDateDue.setEnabled(true);
				hwCounter++;
			}else{
				homework.addAssignment(new Homework(courseNum, hwType, hwNum));
				homeworkList.addItem(courseNum + " " + hwType + " " + hwNum);
				homeworkList.setEnabled(true);
				btnShowNextAssignments.setEnabled(true);
				btnShowAssignmentsByDateAssigned.setEnabled(true);
				btnShowAssignmentsByDateDue.setEnabled(true);
				hwCounter++;
			}//else
		}//if
		
		else if(e.getSource() == homeworkList){
			if(!homeworkList.getSelectedItem().equals("--Choose Homework--")){
				btnRemove.setEnabled(true);
			}else{
				btnRemove.setEnabled(false);
			}
		}//elif
		
		else if(e.getSource() == btnRemove){
			homework.removeAssignment(homework.getHomeworkList().getElementAt(homeworkList.getSelectedIndex() - 1));
			homeworkList.removeItemAt(homeworkList.getSelectedIndex());
			
			if(homework.getHomeworkList().getLength() == 0){
				homeworkList.setEnabled(false);
				btnShowNextAssignments.setEnabled(false);
				btnShowAssignmentsByDateAssigned.setEnabled(false);
				btnShowAssignmentsByDateDue.setEnabled(false);
			}
		}//elif
		
		else if(e.getSource() == btnShowNextAssignments){
			NextDueAsmts frame = new NextDueAsmts();
			frame.setVisible(true);
			
			SinglyLinkedList<Homework> nextAsmts = homework.findNextDueAssignments();
			String hwVals = "Next Due Assignments\n"
						  + "====================\n";
			
			for(int i = 0; i < nextAsmts.getLength(); i++){
				Homework temp = nextAsmts.getElementAt(i);
				hwVals += "- " + temp.getCourseNumber() + " " + temp.getAssignmentType() + " " + temp.getAssignmentNumber() + temp.getAssignmentDescription() + " "
						+ "due: " + (temp.getDateDue().equals(new GregorianCalendar()) ? "" : temp.getDateDue().getTime()) + "\n";
				
				frame.write(hwVals);
			}
			
		}//elif
		
		else if(e.getSource() == btnShowAssignmentsByDateAssigned){
			AsmtsByDateAssignedFrame frame = new AsmtsByDateAssignedFrame();
			frame.setVisible(true);
			
			SinglyLinkedList<Homework> asmtsByDateAssigned = homework.showAssignmentsByAssignedDate();
			String hwVals = "Assignments by Date Assigned\n"
					      + "============================\n";
			
			for(int i = 0; i < asmtsByDateAssigned.getLength(); i++){
				Homework temp = asmtsByDateAssigned.getElementAt(i);
				hwVals += "- " + temp.getCourseNumber() + " " + temp.getAssignmentType() + " " + temp.getAssignmentNumber() + temp.getAssignmentDescription() + " "
						+ "assigned: " + (temp.getDateAssigned().equals(new GregorianCalendar()) ? "" : temp.getDateAssigned().getTime() + "\n");
				
				
				frame.write(hwVals);
			}
		}//elif
		
		else if(e.getSource() == btnShowAssignmentsByDateDue){
			AsmtsByDateDueFrame frame = new AsmtsByDateDueFrame();
			frame.setVisible(true);
			
			SinglyLinkedList<Homework> asmtsByDateDue = homework.showAssignmentsByDueDate();
			String hwVals = "Assignments by Date Due\n"
					      + "============================\n";
			
			for(int i = 0; i < asmtsByDateDue.getLength(); i++){
				Homework temp = asmtsByDateDue.getElementAt(i);
				
				hwVals += "- " + temp.getCourseNumber() + " " + temp.getAssignmentType() + " " + temp.getAssignmentNumber() + temp.getAssignmentDescription() + " "
						+ "due: " + (temp.getDateDue().equals(new GregorianCalendar()) ? "" : temp.getDateDue().getTime()) + "\n";
				
				frame.write(hwVals);
			}
		}//elif
	}//actonPerformed(ActionEvent e)

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void focusLost(FocusEvent e) {
		String courseNum = courseNumFld.getText(), hwType = hwTypeFld.getText();
		int hwNum = (Integer)hwNumFld.getValue();
		
		if(!courseNum.equals("") && !hwType.equals("") && hwNum > 0){
			btnAddHomework.setEnabled(true);
		}else{
			btnAddHomework.setEnabled(false);
		}
	}//focusLost(FocusEvent)
}//HomeworkFrame class
