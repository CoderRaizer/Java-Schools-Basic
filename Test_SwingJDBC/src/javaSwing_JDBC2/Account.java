package javaSwing_JDBC2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Account extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtfullname;
	private JTextField txtcontact;
	private JTextField txtusername;
	private JTextField txtpassword;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;

	DefaultTableModel model = new DefaultTableModel();
	Connection con;
	String IDAcc;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account frame = new Account();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JRadioButton rdbemployeecall = new JRadioButton("Employee Call");
	JRadioButton rdbemployeesale = new JRadioButton("Employee Sale");
	JRadioButton rdbadmin = new JRadioButton("Admin");
	JButton btnLock = new JButton("Lock");
	int role;
	String lock;
	int xnlock;

	public void loadTable()// do du lieu tu bang trong database len table cua JFrame
	{
		con = new MyConnect().getcn();
		Object[] row = new Object[7];
		try {
			String sql = "Select * From Account";

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			model.setRowCount(0);
			while (rs.next()) {
				row[0] = rs.getString(1);
				row[1] = rs.getString(2);
				row[2] = rs.getString(3);
				row[3] = rs.getString(4);
				row[4] = rs.getString(5);
				row[5] = rs.getString(6);
				row[6] = rs.getString(7);
				model.addRow(row);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public Account() {

		con = new MyConnect().getcn();
		if (con == null) {
			JOptionPane.showMessageDialog(getParent(), "CONNECT FAIL", "Thông Báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBounds(294, 0, 230, 187);
		contentPane.add(panel1);
		panel1.setLayout(null);

		JLabel lblAD = new JLabel("ACCOUNT DETAILS");
		lblAD.setHorizontalAlignment(SwingConstants.CENTER);
		lblAD.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAD.setBounds(10, 11, 210, 31);
		panel1.add(lblAD);

		JLabel lblFullname = new JLabel("Fullname");
		lblFullname.setBounds(10, 54, 62, 20);
		panel1.add(lblFullname);

		JLabel lblContact = new JLabel("Contact");
		lblContact.setBounds(10, 85, 62, 20);
		panel1.add(lblContact);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 116, 62, 20);
		panel1.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 147, 62, 20);
		panel1.add(lblPassword);

		txtfullname = new JTextField();
		txtfullname.setBounds(71, 54, 149, 20);
		panel1.add(txtfullname);
		txtfullname.setColumns(10);

		txtcontact = new JTextField();
		txtcontact.setBounds(71, 85, 149, 20);
		panel1.add(txtcontact);
		txtcontact.setColumns(10);

		txtusername = new JTextField();
		txtusername.setBounds(71, 116, 149, 20);
		panel1.add(txtusername);
		txtusername.setColumns(10);

		txtpassword = new JTextField();
		txtpassword.setBounds(71, 147, 149, 20);
		panel1.add(txtpassword);
		txtpassword.setColumns(10);

		JPanel panel2 = new JPanel();
		panel2.setBounds(294, 188, 230, 143);
		contentPane.add(panel2);
		panel2.setLayout(null);

		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(10, 11, 37, 22);
		panel2.add(lblRole);

		// Khai bao chuyen len tren
		buttonGroup.add(rdbemployeecall);
		rdbemployeecall.setSelected(true);
		rdbemployeecall.setBounds(10, 42, 112, 23);
		panel2.add(rdbemployeecall);

		// Khai bao chuyen len tren
		buttonGroup.add(rdbemployeesale);
		rdbemployeesale.setBounds(10, 68, 112, 23);
		panel2.add(rdbemployeesale);

		// Khai bao chuyen len tren
		buttonGroup.add(rdbadmin);
		rdbadmin.setBounds(10, 94, 112, 23);
		panel2.add(rdbadmin);

		// su kien nut create
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(128, 26, 89, 23);
		panel2.add(btnCreate);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!valid())return;
				String fullname = txtfullname.getText();
				String contact = txtcontact.getText();
				String username = txtusername.getText();
				String password = txtpassword.getText();
				// role
				if (rdbemployeecall.isSelected()) {
					role = 1;
				}
				if (rdbemployeesale.isSelected()) {
					role = 2;
				}
				if (rdbadmin.isSelected()) {
					role = 3;
				}
				// test thu xem co lay duoc chuoi tu tostring hay khong
				System.out.println(role);

				con = new MyConnect().getcn();
				try {
					String sql = "Insert into Account values (?,?,?,0,?,?)";// 0 la mac dinh khong khoa
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, fullname);
					ps.setString(2, username);
					ps.setInt(3, role);
					ps.setString(4, password);
					ps.setString(5, contact);

					int kq = ps.executeUpdate();
					if (kq == 1) {
						JOptionPane.showMessageDialog(getParent(), "CREATE SUCCESS");
					} else {
						JOptionPane.showMessageDialog(getParent(), "CREATE FAIL");
					}
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
				loadTable();

			}
		});

		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(128, 68, 89, 23);
		panel2.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtfullname.setText("");
				txtcontact.setText("");
				txtusername.setText("");
				txtpassword.setText("");
			}
		});

		JButton btnClose = new JButton("Close");
		btnClose.setBounds(128, 109, 89, 23);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				Login.main();
			}
		});
		panel2.add(btnClose);

		JPanel panel3 = new JPanel();
		panel3.setBounds(0, 0, 295, 331);
		contentPane.add(panel3);
		panel3.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 295, 272);
		panel3.add(scrollPane);

		table = new JTable();
		// chon dong hien thi du lieu nguoc lai from
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				IDAcc = model.getValueAt(i, 0).toString();
				String fullname = model.getValueAt(i, 1).toString();
				String username = model.getValueAt(i, 2).toString();
				String role = model.getValueAt(i, 3).toString();
				// lock duoc khai bao o tren roi
				lock = model.getValueAt(i, 4).toString();
				String password = model.getValueAt(i, 5).toString();
				String contact = model.getValueAt(i, 6).toString();

				txtfullname.setText(fullname);
				txtusername.setText(username);
				txtcontact.setText(contact);
				txtpassword.setText(password);
				// them loa chon role
				role = model.getValueAt(i, 3).toString();
				if (role.equalsIgnoreCase("1")) {
					rdbemployeecall.setSelected(true);
				}
				if (role.equalsIgnoreCase("2")) {
					rdbemployeesale.setSelected(true);
				}
				if (role.equalsIgnoreCase("3")) {
					rdbadmin.setSelected(true);
				}

				xnlock = i;

				if (lock.equalsIgnoreCase("1")) {
					btnLock.setText("UNLOCK");
				}
				if (lock.equalsIgnoreCase("0")) {
					btnLock.setText("LOCK");
				}
			}
		});

		scrollPane.setViewportView(table);
		Object[] columns = { "IDAcc", "Fullname", "Username", "Role", "Lock", "password", "contact" };
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		// ẩn theo thứ tự lui để tránh bị thụt cột
		table.removeColumn(table.getColumnModel().getColumn(6));
		table.removeColumn(table.getColumnModel().getColumn(5));
		table.removeColumn(table.getColumnModel().getColumn(0));

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(10, 283, 81, 23);
		panel3.add(btnUpdate);

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!valid())
					return;
				int i = table.getSelectedRow();
				String fullname = txtfullname.getText();
				String username = txtusername.getText();
				// String role = model.getValueAt(i,3).toString();
				if (rdbemployeecall.isSelected()) {
					role = 1;
				}
				if (rdbemployeesale.isSelected()) {
					role = 2;
				}
				if (rdbadmin.isSelected()) {
					role = 3;
				}
				String lock = model.getValueAt(i, 4).toString();
				String password = txtpassword.getText();
				String contact = txtcontact.getText();

				con = new MyConnect().getcn();
				try {
					String sql = "Update Account Set fullname=?,username=?,role=?,lock=?,password=?,contact=? where IDAcc=?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, fullname);
					ps.setString(2, username);
					ps.setInt(3, role);
					ps.setString(4, lock);
					ps.setString(5, password);
					ps.setString(6, contact);
					ps.setString(7, IDAcc);

					int kq = ps.executeUpdate();
					if (kq == 1) {
						JOptionPane.showMessageDialog(getParent(), "Update Success");
					} else {
						JOptionPane.showMessageDialog(getParent(), "Update Fail");
					}
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
				loadTable();
			}
		});

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(101, 283, 81, 23);
		panel3.add(btnDelete);

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con = new MyConnect().getcn();

				try {
					String sql = "delete from Account where IDAcc=?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, IDAcc);
					int kq = ps.executeUpdate();
					if (kq == 1) {
						JOptionPane.showMessageDialog(getParent(), "Delete success");
					} else {
						JOptionPane.showMessageDialog(getParent(), "delete Fail");
					}
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}

				loadTable();
			}
		});

		// khai bao dua len tren
		btnLock.setBounds(192, 283, 81, 23);
		panel3.add(btnLock);
		btnLock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lock.equalsIgnoreCase("1")) {
					lock = "0";
					// btnLock.setText("UNLOCK");
					con = new MyConnect().getcn();
					try {
						String sql = "Update Account set lock = ? where lock = 1 and IDAcc = ?";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, lock);
						ps.setInt(2, xnlock + 1);/////// nguyen nhan chac la do day
						int kq = ps.executeUpdate();
						if (kq == 1) {
							JOptionPane.showMessageDialog(getParent(), "UNLOCK THANH CONG");
						}
					} catch (SQLException ex) {
						System.out.println(ex.getMessage());
					}
					loadTable();
					return;
				}

				if (lock.equalsIgnoreCase("0")) {
					lock = "1";
					// btnLock.setText("LOCK");
					con = new MyConnect().getcn();
					try {
						String sql = "Update Account set lock = ? where lock = 0 and IDAcc = ?";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, lock);
						ps.setInt(2, xnlock + 1);
						int kq = ps.executeUpdate();
						if (kq == 1) {
							JOptionPane.showMessageDialog(getParent(), "LOCK THANH CONG");
						}
					} catch (SQLException ex) {
						System.out.println(ex.getMessage());
					}
					loadTable();
					return;
				} 
			}
		});

		loadTable();
	}

	// valid
	public boolean valid() {
		String fullname = txtfullname.getText();
		String contact = txtcontact.getText();
		String username = txtusername.getText();
		String password = txtpassword.getText();

		// Kiem tra ten không duoc bo trong
		if (fullname.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(getParent(), "Vui lòng dien fullname", "Thông Báo",
					JOptionPane.ERROR_MESSAGE);
			txtfullname.requestFocus();
			return false;
		}
		// Kiem tra dia chi không duoc bo trong
		if (contact.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(getParent(), "Vui lòng dien contact", "Thông Báo", JOptionPane.ERROR_MESSAGE);
			txtcontact.requestFocus();
			return false;
		}
		// Kiem tra parent student không duoc bo trong
		if (username.equalsIgnoreCase("")) {
			txtusername.requestFocus();
			JOptionPane.showMessageDialog(getParent(), "Vui lòng dien username", "Thông Báo",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		// Kiem tra liên he không duoc bo trong
		if (password.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(getParent(), "Vui lòng dien password", "Thông Báo",
					JOptionPane.ERROR_MESSAGE);
			txtpassword.requestFocus();
			return false;
		}

		// Kiem tra radiobutton khong duoc chon
		if (!(rdbemployeecall.isSelected() || rdbemployeesale.isSelected() || rdbadmin.isSelected())) {
			JOptionPane.showMessageDialog(getParent(), "Vui lòng chon standard", "Thông Báo",
					JOptionPane.ERROR_MESSAGE);
			rdbemployeecall.requestFocus();
			return false;
		}
		return true;
	}

}
