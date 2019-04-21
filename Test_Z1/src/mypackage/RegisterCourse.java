package mypackage;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class RegisterCourse extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	
	JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel modelTable = new DefaultTableModel();


	private JTextField textName;
	private JTextField textAddress;
	private JTextField textPhone;

	private JComboBox<String> comboboxStandard;
	private JComboBox<String> comboboxFee;

	private Vector<String> v1 = new Vector<String>();
	private Vector<String> v2 = new Vector<String>();

	private Connection con;
	private String regID;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterCourse frame = new RegisterCourse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public boolean checkValidData(String name, String address, String phone) {
		if (name.length() == 0 || address.length() == 0) {
			return false;
		}
		String phonenumber = "[\\d]{10,12}";
		Pattern pt = Pattern.compile(phonenumber, Pattern.CASE_INSENSITIVE);
		Matcher mt = pt.matcher(phone);
		if (!mt.matches()) {
			return false;
		}
		return true;
	}

	public void loadComboBox() {
		try {
			String sql = "SELECT * FROM STANDARDS";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				v1.addElement(rs.getString(1)); // standard
				v2.addElement(rs.getString(2)); // fee
			}
			rs.close();
			ps.close();
			comboboxStandard.setModel(new DefaultComboBoxModel<>(v1));
			comboboxFee.setModel(new DefaultComboBoxModel<>(v2));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void loadTableStudent() {
		con = new MyConnect().getConnect();
		Object[] row = new Object[6]; // element of Object
		try {
			String sql = "SELECT * FROM STUDENT";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			modelTable.setRowCount(0); // Để khi load table sẽ load lại từ dòng 0
			while (rs.next()) {
				for (int i = 0; i < 6; i++) {
					if (i == 0) {
						row[i] = rs.getInt(i + 1);
					} else {
						row[i] = rs.getString(i + 1);
					}
				}
				System.out.println("Object: " + row[1]);
				modelTable.addRow(row);
			}
			rs.close();
			ps.close();
		} catch (SQLException Ex) {
			System.out.println(Ex.toString());
		}
	}

	public RegisterCourse() {

		/*-----Connect DataBase-----*/
		con = new MyConnect().getConnect();

		if (con == null) {
			JOptionPane.showMessageDialog(getParent(), "Kết nối Database thất bại");
			return;
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 584, 116);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textName = new JTextField();
		textName.setBackground(new Color(240, 255, 240));
		textName.setBounds(57, 14, 237, 22);
		panel_1.add(textName);
		textName.setColumns(10);

		textAddress = new JTextField();
		textAddress.setBackground(new Color(240, 255, 240));
		textAddress.setBounds(57, 47, 237, 22);
		panel_1.add(textAddress);
		textAddress.setColumns(10);

		textPhone = new JTextField();
		textPhone.setBackground(new Color(240, 255, 240));
		textPhone.setBounds(57, 80, 237, 22);
		panel_1.add(textPhone);
		textPhone.setColumns(10);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 11, 55, 29);
		panel_1.add(lblName);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 44, 55, 29);
		panel_1.add(lblAddress);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(10, 78, 55, 29);
		panel_1.add(lblPhone);

		comboboxStandard = new JComboBox<String>();
		comboboxStandard.setBackground(new Color(0, 206, 209));
		comboboxStandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboboxFee.setSelectedIndex(comboboxStandard.getSelectedIndex());
			}
		});
		comboboxStandard.setBounds(304, 80, 60, 22);
		panel_1.add(comboboxStandard);

		comboboxFee = new JComboBox<String>();
		comboboxFee.setBackground(new Color(0, 255, 127));
		comboboxFee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboboxStandard.setSelectedIndex(comboboxFee.getSelectedIndex());
			}
		});
		comboboxFee.setBounds(374, 80, 67, 22);
		panel_1.add(comboboxFee);

		panel_2 = new JPanel();
		panel_2.setBounds(0, 120, 584, 31);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		/*-------------SAVE-------------*/
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(new Color(0, 191, 255));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkValidData(textName.getText(), textAddress.getText(), textPhone.getText()) == true) {
					Calendar c = Calendar.getInstance();
					SimpleDateFormat sf = new SimpleDateFormat("MM/dd/yyyy");
					String registerDate = sf.format(c.getTime());
					try {
						String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?)";
						PreparedStatement ps = con.prepareStatement(sql);

						ps.setString(1, ChuanHoaChuoi(textName.getText()));
						ps.setString(2, textAddress.getText());
						ps.setString(3, textPhone.getText());
						ps.setString(4, (String) comboboxStandard.getSelectedItem());
						ps.setString(5, registerDate);

						int result = ps.executeUpdate();
						if (result == 1) {
							JOptionPane.showMessageDialog(getParent(), "THÊM THÀNH CÔNG", "Thông Báo",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(getParent(), "THÊM THẤT BẠI", "Thông Báo",
									JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException ex) {
						System.out.println(ex.getMessage());
					}
					loadTableStudent();
				} else {
					JOptionPane.showMessageDialog(getParent(), "DATA KHÔNG HỢP LỆ", "Thông Báo",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnSave.setBounds(23, 0, 131, 31);
		panel_2.add(btnSave);

		/*-------------UPDATE-------------*/
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(0, 255, 127));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "UPDATE STUDENT SET Name=?,Address=?,phone=?,codeStandard=? WHERE idReg = ?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, textName.getText());
					ps.setString(2, textAddress.getText());
					ps.setString(3, textPhone.getText());
					ps.setString(4, (String) comboboxStandard.getSelectedItem());
					ps.setString(5, regID);

					int result = ps.executeUpdate();
					if (result == 1) {
						JOptionPane.showMessageDialog(getParent(), "SỬA THÀNH CÔNG", "Thông Báo",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(getParent(), "SỬA THẤT BẠI", "Thông Báo",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException ex) {
					System.out.println(ex.toString());
				}
				loadTableStudent();
			}
		});
		btnUpdate.setBounds(164, 0, 131, 31);
		panel_2.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(220, 20, 60));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int chon = JOptionPane.showConfirmDialog(getParent(), "Bạn có thực sự muốn xoá dữ liệu hay không",
						"Asking", JOptionPane.ERROR_MESSAGE);
				if (chon == JOptionPane.YES_OPTION) {
					try {
						String sql = "DELETE FROM STUDENT WHERE idReg = ?";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, regID);
						int result = ps.executeUpdate();
						if (result == 1) {
							JOptionPane.showMessageDialog(getParent(), "XÓA THÀNH CÔNG", "Thông Báo",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(getParent(), "XÓA THẤT BẠI", "Thông Báo",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (SQLException ex) {
						System.out.println(ex.toString());
					}
					loadTableStudent();
				}
			}
		});
		btnDelete.setBounds(305, 0, 138, 31);
		panel_2.add(btnDelete);

		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(169, 169, 169));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				textName.setText("");
				textAddress.setText("");
				textPhone.setText("");
				comboboxStandard.setSelectedIndex(0);
				comboboxFee.setSelectedIndex(0);
			}
		});
		btnReset.setBounds(453, 0, 121, 31);
		panel_2.add(btnReset);

		panel_3 = new JPanel();
		panel_3.setBounds(0, 162, 584, 207);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 584, 142);
		panel_3.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(154, 205, 50));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				regID = modelTable.getValueAt(i, 0).toString();
				textName.setText(modelTable.getValueAt(i, 1).toString());
				textAddress.setText(modelTable.getValueAt(i, 2).toString());
				textPhone.setText(modelTable.getValueAt(i, 3).toString());
				comboboxStandard.setSelectedItem(modelTable.getValueAt(i, 4));
			}
		});
		scrollPane.setViewportView(table);
		Object[] columns = { "ID", "NAME", "ADDRESS", "PHONE", "STANDARD", "REGDATE" };
		modelTable.setColumnIdentifiers(columns);// set lên table các cột theo thứ tự tự tăng dần
		table.setModel(modelTable);

//		 table.removeColumn(table.getColumnModel().getColumn(0));// getColumn(0)->0 la
		// cot dau tien
		/*------------------LOAD DATA------------------*/
		loadComboBox();
		loadTableStudent();

	}

	/*---------------------------------------CHECK VALUE--------------------------------------------------*/
	public String InHoaKyTuDau(String sample) {
		int lenght = sample.length();
		char[] array = sample.toCharArray();
		sample = "";
		int i = 0;
		while (i < lenght) {
			if (i == 0) {
				if ((int) array[i] >= 65 && (int) array[i] <= 90) {
					sample += Character.toString(array[i]);
				} else if ((int) array[i] >= 97 && (int) array[i] <= 122) {
					sample += Character.toString((char) ((int) array[i] - 32));

				}
			} else {
				if ((int) array[i] == 32) {
					sample += Character.toString(array[i]);
					i++;
					if ((int) array[i] >= 65 && (int) array[i] <= 90) {
						sample += Character.toString((char) ((int) array[i]));
					} else if ((int) array[i] >= 97 && (int) array[i] <= 122) {
						sample += Character.toString((char) ((int) array[i] - 32));
					}

				} else {
					if ((int) array[i - 1] == 32) {// neu truoc no la khoang trang
						if ((int) array[i] >= 65 && (int) array[i] <= 90) {
							sample += Character.toString((char) ((int) array[i]));
						} else if ((int) array[i] >= 97 && (int) array[i] <= 122) {
							sample += Character.toString((char) ((int) array[i] - 32));
						}
					} else if ((int) array[i - 1] >= 65 && (int) array[i - 1] <= 90) {// neu chu dung truoc la hoa
						if ((int) array[i] >= 97 && (int) array[i] <= 122) {
							sample += Character.toString((char) ((int) array[i]));
						} else if ((int) array[i] >= 65 && (int) array[i] <= 90) {
							sample += Character.toString((char) ((int) array[i] + 32));
						}
					} else if ((int) array[i - 1] >= 97 && (int) array[i - 1] <= 122) {
						if ((int) array[i] >= 97 && (int) array[i] <= 122) {
							sample += Character.toString((char) ((int) array[i]));
						} else if ((int) array[i] >= 65 && (int) array[i] <= 90) {
							sample += Character.toString((char) ((int) array[i] + 32));
						}
					}
				}
			}
			i++;
		}
		return sample;
	}

	public int HowManySpace(int index, String temp) {
		int count = 0;
		int z = index;
		char[] array = temp.toCharArray();
		while ((int) array[z] == 32) {
			count++;
			z++;
		}
		return count;
	}

	public String ChuanHoaChuoi(String sample) {
		sample = sample.trim();
		char[] array = sample.toCharArray();
		for (int i = 0; i < sample.length(); i++) {
			if ((int) array[i] == 32) {
				int del = 0;
				del = HowManySpace(i, sample);
				if (del > 1) {
					String space = "";
					for (int j = 0; j < del; j++) {
						space += " ";
					}
					while (sample.indexOf(space) != -1) {
						sample = sample.replaceAll(space, " ");
					}
				}
			}
		}
		return InHoaKyTuDau(sample);
	}
	/*---------------------------------------CHECK VALUE--------------------------------------------------*/

}
