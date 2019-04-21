package bai3;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BaiTap3 extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textName;
	private JTextField textBirth;
	private JTextField textAddress;
	private JTextField textResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaiTap3 frame = new BaiTap3();
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
	public BaiTap3() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 22, 55, 14);
		contentPane.add(lblName);
		
		JLabel lblBirth = new JLabel("Birth");
		lblBirth.setBounds(10, 64, 55, 14);
		contentPane.add(lblBirth);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 105, 55, 14);
		contentPane.add(lblAddress);
		
		textName = new JTextField();
		textName.setBounds(75, 19, 257, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textBirth = new JTextField();
		textBirth.setBounds(75, 61, 257, 20);
		contentPane.add(textBirth);
		textBirth.setColumns(10);
		
		textAddress = new JTextField();
		textAddress.setBounds(75, 102, 257, 20);
		contentPane.add(textAddress);
		textAddress.setColumns(10);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(10, 138, 46, 14);
		contentPane.add(lblSex);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(75, 134, 55, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(156, 134, 74, 23);
		contentPane.add(rdbtnFemale);
		
		ButtonGroup sexGroupButton = new ButtonGroup();
		sexGroupButton.add(rdbtnMale);
		sexGroupButton.add(rdbtnFemale);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(10, 171, 46, 14);
		contentPane.add(lblResult);
		
		textResult = new JTextField();
		textResult.setBounds(75, 168, 257, 41);
		contentPane.add(textResult);
		textResult.setColumns(10);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender;
				if(rdbtnMale.isSelected()) {
					gender = "Male";
				}else {
					gender = "Female";
				}
				
				textResult.setText(textName.getText() + " " + textBirth.getText() + " " + textAddress.getText() + " " + gender ); 
			}
		});
		btnDisplay.setBounds(75, 227, 81, 23);
		contentPane.add(btnDisplay);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textName.setText(null);
				textBirth.setText(null);
				textAddress.setText(null);
				sexGroupButton.clearSelection();
			}
		});
		btnReset.setBounds(163, 227, 78, 23);
		contentPane.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(251, 227, 81, 23);
		contentPane.add(btnExit);
	}
}
