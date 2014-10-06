package Homework;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;

public class AsmtsByDateAssignedFrame extends JFrame {

	private JPanel contentPane;
	JEditorPane content;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsmtsByDateAssignedFrame frame = new AsmtsByDateAssignedFrame();
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
	public AsmtsByDateAssignedFrame() {
		setTitle("Assigments by Date Assigned");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 334, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 298, 419);
		contentPane.add(scrollPane);
		
		content = new JEditorPane();
		scrollPane.setViewportView(content);
	}
	
	public void write(String text){
		content.setText(text);
	}//write(String)
}
