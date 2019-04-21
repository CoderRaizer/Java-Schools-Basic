package bai1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JTabbedPane;

public class BaiTap1 extends JFrame {

	String []ListColor = {"Blue","Cyan","Gray","Green","Magenta","Orange","Pink","Red","While","Yellow"};
	
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaiTap1 frame = new BaiTap1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*--------------*/
	/*--Create the frame.--*/
	
	
	public BaiTap1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		/*-------Text Input-------*/
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String color = textField.getText();

				if(color.equalsIgnoreCase("Blue")) {
					contentPane.setBackground(Color.BLUE);
				} else if(color.equalsIgnoreCase("Cyan")) {
					contentPane.setBackground(Color.CYAN);
				} else if(color.equalsIgnoreCase("Gray")) {
					contentPane.setBackground(Color.GRAY);
				} else if(color.equalsIgnoreCase("Green")) {
					contentPane.setBackground(Color.GREEN);
				} else if(color.equalsIgnoreCase("Magenta")) {
					contentPane.setBackground(Color.MAGENTA);
				} else if(color.equalsIgnoreCase("Orange")) {
					contentPane.setBackground(Color.ORANGE);
				} else if(color.equalsIgnoreCase("Pink")) {
					contentPane.setBackground(Color.PINK);
				} else if(color.equalsIgnoreCase("Red")) {
					contentPane.setBackground(Color.RED);
				} else if(color.equalsIgnoreCase("While")) {
					contentPane.setBackground(Color.WHITE);
				} else if(color.equalsIgnoreCase("Yellow")) {
					contentPane.setBackground(Color.YELLOW);
				} else {
					JOptionPane.showMessageDialog(contentPane, "Code Color is Invalid", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		textField.setBounds(10, 36, 100, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		/*--Label--*/
		JLabel mylabel = new JLabel("Nh\u1EADp v\u00E0o m\u00E0u");
		mylabel.setBounds(10, 11, 100, 14);
		contentPane.add(mylabel);
		
		
		
		

	}
}
