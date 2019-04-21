package mypackage;

import java.awt.Color;
import java.awt.EventQueue;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigInteger;
import java.awt.Font;

public class ManagerUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;

	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model = new DefaultTableModel();
	private int id = -1;

	private String lock;
	private String role;

	private JTextField textFullName;
	private JTextField textUsername;
	private JPasswordField textPassword;

	private JRadioButton rdbtnAdmin;
	private JRadioButton rdbtnStaff;
	private JRadioButton rdbtnCustomers;
	private ButtonGroup btnGroup;
	
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnLock;

	private Connection con;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerUser frame = new ManagerUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public int RadioButtonIsSelected() {
		if (rdbtnAdmin.isSelected()) {
			return 1;
		} else if (rdbtnStaff.isSelected()) {
			return 2;
		} else {
			return 3;
		}
	}

	public void loadTableUser() {
		this.con = new MyConnect().getConnection();
		if (this.con != null) {
			try {
				Object[] row = new Object[6];
				String sql = "SELECT * FROM USERS";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				model.setRowCount(0);
				while (rs.next()) {
					row[0] = rs.getInt(1);
					row[1] = rs.getString(2);
					row[2] = rs.getString(3);
					row[3] = rs.getString(4);
					row[4] = rs.getString(5);
					row[5] = rs.getString(6);
					model.addRow(row);
				}
				rs.close();
				ps.close();
			} catch (SQLException ex) {
				System.out.println(ex.toString());
			}
		}
	}

	@SuppressWarnings("deprecation")
	public boolean checkValueOfInfo() {
		if (!rdbtnAdmin.isSelected() && !rdbtnStaff.isSelected() && !rdbtnCustomers.isSelected()) {
			return false;
		}
		if (textFullName.getText().toString().length() == 0 || textUsername.getText().toString().length() == 0
				|| textPassword.getText().length() == 0) {
			return false;
		}
		String sampleGegex = "^[a-zA-Z]+";
		Pattern pt = Pattern.compile(sampleGegex, Pattern.CASE_INSENSITIVE);
		Matcher mt = pt.matcher(textUsername.getText());
		if (!mt.matches()) {
			return false;
		}

		return true;
	}

	public ManagerUser() {

		/*-----Check Connection-----*/
		con = null;
		con = new MyConnect().getConnection();
		if (con != null) {
			System.out.println("Connect success");
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		panel_1.setBounds(0, 0, 337, 333);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		/*------Crollpane and Table------*/
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 317, 322);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 215, 0));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				int i = table.getSelectedRow();
				id = (int) model.getValueAt(i, 0);
				textFullName.setText(model.getValueAt(i, 1).toString());
				textUsername.setText(model.getValueAt(i, 2).toString());
				textPassword.setText(model.getValueAt(i, 3).toString());
				lock = model.getValueAt(i, 4).toString();
				role = model.getValueAt(i, 5).toString();
				if (role.equalsIgnoreCase("1")) {
					rdbtnAdmin.setSelected(true);
				}
				if (role.equalsIgnoreCase("2")) {
					rdbtnStaff.setSelected(true);
				}
				if (role.equalsIgnoreCase("3")) {
					rdbtnCustomers.setSelected(true);
				}
				if(lock.equalsIgnoreCase("1")) {
					btnLock.setText("Unlock");
				}
				if(lock.equalsIgnoreCase("0")) {
					btnLock.setText("Lock");
				}
				System.out.println(" Row = " + id + " | Lock = " + lock + " | Role = " + role);
			}
		});
		scrollPane.setViewportView(table);

		String[] columns = { "Id", "FullName", "UserName", "PassWord", "Lock", "Role" };
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		// Ẩn cột Password
		table.removeColumn(table.getColumnModel().getColumn(3));
		/*------Crollpane and Table------*/

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(224, 255, 255));
		panel_2.setBounds(0, 339, 337, 42);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(25, 25, 112));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (id == -1) {
					JOptionPane.showMessageDialog(getParent(), "Bạn chưa chọn dòng dữ liệu nào");
				} else {
					try {
						String sql = "UPDATE USERS SET FullName=?,UserName=?,PassWord=?,LockStatus=?,IdRole=? Where Id=?";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, textFullName.getText());
						ps.setString(2, textUsername.getText());
						ps.setString(3, textPassword.getPassword().toString());
						int i = table.getSelectedRow();
						String lock = model.getValueAt(i, 4).toString();
						ps.setString(4, lock);
						ps.setInt(5, RadioButtonIsSelected());
						ps.setInt(6, id);

						int kq = ps.executeUpdate();
						if (kq == 1) {
							JOptionPane.showMessageDialog(getParent(), "UPDATE SUCCESS");
						} else {
							JOptionPane.showMessageDialog(getParent(), "UPDATE FAIL");
						}
					} catch (SQLException ex) {
						System.out.println(ex.toString());
					}
					loadTableUser();
					id = -1;
				}
			}
		});
		btnUpdate.setBounds(10, 10, 84, 22);
		panel_2.add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (id == -1) {
					JOptionPane.showMessageDialog(getParent(), "Bạn chưa chọn dòng dữ liệu nào");
				} else {
					int chon = JOptionPane.showConfirmDialog(getParent(), "Bạn có chắc muốn xóa dữ liệu không?");
					if (chon == JOptionPane.YES_OPTION) {
						try {
							String sql = "DELETE FROM USERS WHERE Id=?";
							PreparedStatement ps = con.prepareStatement(sql);
							ps.setInt(1, id);
							int kq = ps.executeUpdate();
							if (kq != 1) {
								JOptionPane.showMessageDialog(getParent(), "UPDATE FAIL");
							}
						} catch (SQLException ex) {
							System.out.println(ex.toString());
						}
						loadTableUser();
						id = -1;
					}
				}
			}
		});
		btnDelete.setBackground(new Color(0, 128, 0));
		btnDelete.setBounds(126, 10, 84, 22);
		panel_2.add(btnDelete);

		btnLock = new JButton("Lock");
		btnLock.setForeground(new Color(255, 255, 255));
		btnLock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (id == -1) {
					JOptionPane.showMessageDialog(getParent(), "Bạn chưa chọn dòng dữ liệu nào");
				} else {
					try {
						String sql = "UPDATE USERS SET LockStatus=? WHERE Id=?";
						PreparedStatement ps = con.prepareStatement(sql);
						if (lock.equalsIgnoreCase("0")) {
							ps.setString(1, "1");
							ps.setInt(2, id);
						} else if (lock.equalsIgnoreCase("1")) {
							ps.setString(1, "0");
							ps.setInt(2, id);
						}
						int kq = ps.executeUpdate();
						if (kq != 1) {
							JOptionPane.showMessageDialog(getParent(), "FAIL");
						}
					} catch (SQLException ex) {
						System.out.println(ex.toString());
					}
					loadTableUser();
					id = -1;
				}
			}
		});
		btnLock.setBackground(new Color(220, 20, 60));
		btnLock.setBounds(243, 10, 84, 22);
		panel_2.add(btnLock);

		panel_3 = new JPanel();
		panel_3.setBackground(new Color(224, 255, 255));
		panel_3.setBounds(337, 0, 235, 381);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setBounds(10, 81, 64, 28);
		panel_3.add(lblFullName);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 127, 64, 28);
		panel_3.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 179, 64, 26);
		panel_3.add(lblPassword);

		textFullName = new JTextField();
		textFullName.setToolTipText("Họ Và Tên đầy đủ");
		textFullName.setBackground(new Color(230, 230, 250));
		textFullName.setBounds(74, 79, 159, 30);
		panel_3.add(textFullName);
		textFullName.setColumns(10);

		textUsername = new JTextField();
		textUsername.setToolTipText("Username chỉ sử dụng chữ cái");
		textUsername.setBackground(new Color(230, 230, 250));
		textUsername.setBounds(74, 128, 159, 28);
		panel_3.add(textUsername);
		textUsername.setColumns(10);

		textPassword = new JPasswordField();
		textPassword.setBackground(new Color(230, 230, 250));
		textPassword.setBounds(74, 177, 159, 28);
		panel_3.add(textPassword);

		JButton btnCreate = new JButton("CREATE");
		btnCreate.setBackground(new Color(30, 144, 255));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkValueOfInfo() == true) {
					try {
						String sql = "INSERT INTO USERS VALUES (?,?,?,0,?)";// mac dinh lock bang 0
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, textFullName.getText());
						ps.setString(2, textUsername.getText());
						/*----Hashing for PassWord----*/
						MessageDigest md = MessageDigest.getInstance("MD5");
						byte[] messageDigest = md.digest(textPassword.getPassword().toString().getBytes());
						BigInteger no = new BigInteger(1, messageDigest);
						String hashPassWord = no.toString(16);
						while (hashPassWord.length() < 32) {
							hashPassWord += hashPassWord;
						}
						ps.setString(3, hashPassWord);
						ps.setInt(4, RadioButtonIsSelected());

						int kq = ps.executeUpdate();
						if (kq == 1) {
							JOptionPane.showMessageDialog(getParent(), "CREATE SUCCESS");
						} else {
							JOptionPane.showMessageDialog(getParent(), "CREATE FAIL");
						}
					} catch (SQLException ex) {
						System.out.println(ex.toString());
					} catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					loadTableUser();
					id = -1;
				} else {
					JOptionPane.showMessageDialog(getParent(), "Không được để trống dữ liệu");
				}
			}
		});
		btnCreate.setBounds(144, 277, 89, 41);
		panel_3.add(btnCreate);

		JButton btnReset = new JButton("RESET");
		btnReset.setBackground(new Color(95, 158, 160));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				textFullName.setText("");
				textUsername.setText("");
				textPassword.setText("");
				btnGroup.clearSelection();
				id = -1;
			}
		});
		btnReset.setBounds(144, 225, 89, 41);
		panel_3.add(btnReset);

		JButton btnClose = new JButton("CLOSE");
		btnClose.setBackground(new Color(189, 183, 107));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setBounds(144, 329, 89, 41);
		panel_3.add(btnClose);

		rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setBackground(new Color(143, 188, 143));
		rdbtnAdmin.setBounds(10, 234, 109, 23);
		panel_3.add(rdbtnAdmin);

		rdbtnStaff = new JRadioButton("Staff");
		rdbtnStaff.setBackground(new Color(143, 188, 143));
		rdbtnStaff.setBounds(10, 286, 109, 23);
		panel_3.add(rdbtnStaff);

		rdbtnCustomers = new JRadioButton("Customers");
		rdbtnCustomers.setBackground(new Color(143, 188, 143));
		rdbtnCustomers.setBounds(10, 338, 109, 23);
		panel_3.add(rdbtnCustomers);

		btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnAdmin);
		btnGroup.add(rdbtnStaff);
		btnGroup.add(rdbtnCustomers);
		
		ImageIcon unicon = new ImageIcon("src/mypackage/vongxoay.gif");
		JButton btnManagerUser = new JButton("");
		btnManagerUser.setBackground(new Color(0, 255, 153));
		btnManagerUser.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnManagerUser.setBounds(0, 0, 235, 70);
		panel_3.add(btnManagerUser);
		btnManagerUser.setIcon(unicon);

		loadTableUser();
	}
}
