package bai5;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BaiTap5 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFullName;
	private JComboBox comboBoxCourse;
	JTextArea textResult = null;
	JScrollPane scrollPane;
	String time = "";
	String course = "";

	ArrayList<Integer> listIndexOfCourse = new ArrayList<>();

	public boolean checkChoiceCourseDuplication(int newValue) {
		for (Integer x : listIndexOfCourse) {
			if (newValue == x) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaiTap5 frame = new BaiTap5();
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
	public BaiTap5() {
		setForeground(SystemColor.desktop);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFullname = new JLabel("FullName");
		lblFullname.setBounds(10, 11, 61, 14);
		contentPane.add(lblFullname);

		textFullName = new JTextField();
		textFullName.setBounds(71, 8, 200, 20);
		contentPane.add(textFullName);
		textFullName.setColumns(10);

		JLabel lblCourse = new JLabel("Course");
		lblCourse.setBounds(10, 39, 61, 14);
		contentPane.add(lblCourse);

		comboBoxCourse = new JComboBox();
		comboBoxCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkChoiceCourseDuplication(comboBoxCourse.getSelectedIndex()) == false) {
					JOptionPane.showMessageDialog(null, "Bạn đã ch�?n khóa h�?c này rồi");
				} else {
					listIndexOfCourse.add(comboBoxCourse.getSelectedIndex());
					course += comboBoxCourse.getSelectedItem().toString() + "\n";
					textResult.setText(course);
				}

			}
		});
		comboBoxCourse.setBounds(71, 36, 200, 20);
		contentPane.add(comboBoxCourse);
		comboBoxCourse.setModel(new DefaultComboBoxModel(
				new String[] { "C\u1EA5u Tr\u00FAc D\u1EEF Li\u1EC7u", "C\u01A1 S\u1EDF D\u1EEF Li\u1EC7u",
						"H\u1EC7 \u0110i\u1EC1u H\u00E0nh", "To\u00E1n R\u1EDDi R\u1EA1c" }));

		JRadioButton radioButton246 = new JRadioButton("(2-4-6)");
		radioButton246.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioButton246.isSelected()) {
					time += "(2-4-6)";
				}
			}
		});
		radioButton246.setBounds(71, 78, 69, 23);
		contentPane.add(radioButton246);

		JRadioButton radioButton357 = new JRadioButton("(3-5-7)");
		radioButton357.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioButton357.isSelected()) {
					time += "(3-5-7)";
				}
			}
		});
		radioButton357.setBounds(142, 78, 74, 23);
		contentPane.add(radioButton357);

		ButtonGroup groupTime = new ButtonGroup();
		groupTime.add(radioButton246);
		groupTime.add(radioButton357);

		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(10, 112, 46, 14);
		contentPane.add(lblResult);

		textResult = new JTextArea();
		textResult.setBackground(new Color(230, 230, 250));
		textResult.setBounds(71, 108, 353, 108);
		contentPane.add(textResult);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 108, 353, 108);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(textResult);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(335, 227, 89, 23);
		contentPane.add(btnExit);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int chon = JOptionPane.showConfirmDialog(getParent(), "Do you want to reset the data?", "Asking",
						JOptionPane.ERROR_MESSAGE);
				if (chon == JOptionPane.YES_OPTION) {
					textFullName.setText(null);
					groupTime.clearSelection();
					System.out.println(textResult.getText());
					textResult.setText(null);
					listIndexOfCourse.clear();
					course = "";
					time = "";
				}
			}
		});
		btnReset.setBounds(236, 227, 89, 23);
		contentPane.add(btnReset);

		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String info = textFullName.getText() + "\t" + time + "\n" + course;
				textResult.setText(info);

			}
		});
		btnDisplay.setBounds(137, 227, 89, 23);
		contentPane.add(btnDisplay);

	}
}
