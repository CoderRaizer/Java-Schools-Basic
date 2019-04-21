package javaSwing_JDBC1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Kidzone_School extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtParentName;
	private JTextField txtContactNo;
	private JTable table;

	String regID;
	JComboBox<String> cbStandard = new JComboBox<String>();
	JComboBox<String> cbFee = new JComboBox<String>();

	Vector<String> v1 = new Vector<String>();
	Vector<String> v2 = new Vector<String>();

	DefaultTableModel model = new DefaultTableModel();// day la phuong thuc de lam viec voi table trong Java Swing
	Connection connect;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kidzone_School frame = new Kidzone_School();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*-----Load data into ComboBox-----*/
	public void loadComboBox() {
		// Thực hiện đổ dữ liệu từ bảng Standards trong database lên ComboBox Standard
		// và ComboBox Fee
		try {
			String sql = "Select * From Standards";
			PreparedStatement ps = connect.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				v1.addElement(rs.getString(1));// standard
				v2.addElement(rs.getString(2));// fee
			}

			// Đổ dữ liệu từ vector lên combobox
			cbStandard.setModel(new DefaultComboBoxModel<>(v1));
			cbFee.setModel(new DefaultComboBoxModel<>(v2));

			rs.close();
			ps.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void loadTable() {
		connect = new MyConnect().getcn();
		Object[] row = new Object[7];// element of Object
		try {
			String sql = "Select * From Student";
			PreparedStatement ps = connect.prepareStatement(sql);
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
			connect.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public Kidzone_School() {
		connect = new MyConnect().getcn();
		if (connect == null) {
			JOptionPane.showMessageDialog(getParent(), "Kết nối Database thất bại");
			return;
		} else {
			JOptionPane.showMessageDialog(getParent(), "Connect Database success", "Thông Báo",
					JOptionPane.INFORMATION_MESSAGE);
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 554, 186);
		contentPane.add(panel1);
		panel1.setLayout(null);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 11, 91, 22);
		panel1.add(lblName);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 44, 91, 22);
		panel1.add(lblAddress);

		JLabel lblParentsName = new JLabel("Parent's Name");
		lblParentsName.setBounds(10, 77, 91, 22);
		panel1.add(lblParentsName);

		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setBounds(10, 110, 91, 22);
		panel1.add(lblContactNo);

		txtName = new JTextField();// Khai báo đã đưa lên trên
		txtName.setBounds(111, 11, 337, 22);
		panel1.add(txtName);
		txtName.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setBounds(111, 45, 337, 22);
		panel1.add(txtAddress);
		txtAddress.setColumns(10);

		txtParentName = new JTextField();
		txtParentName.setBounds(111, 78, 337, 22);
		panel1.add(txtParentName);
		txtParentName.setColumns(10);

		txtContactNo = new JTextField();
		txtContactNo.setBounds(111, 110, 337, 22);
		panel1.add(txtContactNo);
		txtContactNo.setColumns(10);

		JLabel lblStandard = new JLabel("Standard");
		lblStandard.setBounds(10, 143, 91, 22);
		panel1.add(lblStandard);

		// Khai báo đã đưa lên trên
		cbStandard.setBounds(111, 143, 122, 22);
		panel1.add(cbStandard);
		cbStandard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cbFee.setSelectedIndex(cbStandard.getSelectedIndex());
			}
		});

		JLabel lblFee = new JLabel("Fee");
		lblFee.setBounds(300, 143, 40, 22);
		panel1.add(lblFee);

		// Khai báo đã đưa lên trên
		cbFee.setBounds(359, 143, 89, 20);
		panel1.add(cbFee);

		cbFee.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cbStandard.setSelectedIndex(cbFee.getSelectedIndex());
			}
		});

		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 186, 554, 45);
		contentPane.add(panel2);
		panel2.setLayout(null);

		JButton btnSave = new JButton("SAVE");
		btnSave.setBackground(new Color(65, 105, 225));
		btnSave.setBounds(10, 11, 122, 23);
		panel2.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Kiểm tra điều kiện sai sẽ không thực hiện tiếp được
				if (!checkValidInput())
					return;

				String name = txtName.getText();
				String address = txtAddress.getText();
				String parentName = txtParentName.getText();
				String phone = txtContactNo.getText();
				String standard = (String) cbStandard.getSelectedItem();

				Calendar c = Calendar.getInstance();
				SimpleDateFormat sf = new SimpleDateFormat("MM/dd/yyyy");
				String regDate = sf.format(c.getTime());

				connect = new MyConnect().getcn();
				try {
					String sql = "Insert Student Values (?,?,?,?,?,?)";
					PreparedStatement ps = connect.prepareStatement(sql);

					ps.setString(1, name);
					ps.setString(2, address);
					ps.setString(3, parentName);
					ps.setString(4, phone);
					ps.setString(5, standard);
					ps.setString(6, regDate);

					int kq = ps.executeUpdate();
					if (kq == 1) {
						JOptionPane.showMessageDialog(getParent(), "INSERT SUCCESS", "Thông Báo",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(getParent(), "INSERT FAIL", "Thông Báo",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				loadTable();
			}
		});

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(new Color(60, 179, 113));
		btnUpdate.setBounds(142, 11, 134, 23);
		panel2.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!checkValidInput())
					return;

				String name = txtName.getText();
				String address = txtAddress.getText();
				String parentName = txtParentName.getText();
				String phone = txtContactNo.getText();
				String standard = (String) cbStandard.getSelectedItem();

				connect = new MyConnect().getcn();
				try {
					String sql = "Update Student Set Name=?,Address=?,parentName=?,phone=?,standard=? Where RegID = ?";
					PreparedStatement ps = connect.prepareStatement(sql);
					ps.setString(1, name);
					ps.setString(2, address);
					ps.setString(3, parentName);
					ps.setString(4, phone);
					ps.setString(5, standard);
					ps.setString(6, regID);// regID của dòng được chọn

					int kq = ps.executeUpdate();
					if (kq == 1) {
						JOptionPane.showMessageDialog(getParent(), "UPDATE SUCCESS", "Thông Báo",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(getParent(), "UPDATE FAIL", "Thông Báo",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
				loadTable();
			}
		});

		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBackground(new Color(220, 20, 60));
		btnDelete.setBounds(286, 11, 124, 23);
		panel2.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int chon = JOptionPane.showConfirmDialog(getParent(), "Bạn có thực sự muốn xoá dữ liệu hay không",
						"Asking", JOptionPane.ERROR_MESSAGE);

				if (chon == JOptionPane.YES_OPTION)// Nếu nhấp vào OK
				{
					connect = new MyConnect().getcn();
					try {
						String sql = "Delete From Student Where RegID=?";

						PreparedStatement ps = connect.prepareStatement(sql);
						ps.setString(1, regID);
						int kq = ps.executeUpdate();
						if (kq == 1) {
							JOptionPane.showMessageDialog(getParent(), "DELETE SUCCESS", "Thông Báo",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(getParent(), "DELETE FAIL", "Thông Báo",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (SQLException ex) {
						System.out.println(ex.getMessage());
					}
					JOptionPane.showMessageDialog(getParent(), "Delete success", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
				}

				if (chon == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(getParent(), "Tiếp tục thao tác", "Thông Báo",
							JOptionPane.INFORMATION_MESSAGE);
				}
				loadTable();
			}
		});

		JButton btnReset = new JButton("RESET");
		btnReset.setBackground(new Color(169, 169, 169));
		btnReset.setBounds(420, 11, 124, 23);
		panel2.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAddress.setText("");
				txtParentName.setText("");
				txtContactNo.setText("");
				cbStandard.setSelectedIndex(0);
				cbFee.setSelectedIndex(0);
			}
		});

		JPanel panel3 = new JPanel();
		panel3.setBounds(0, 231, 554, 153);
		contentPane.add(panel3);
		panel3.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 554, 142);
		panel3.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				regID = model.getValueAt(i, 0).toString();
				String name = model.getValueAt(i, 1).toString();
				String address = model.getValueAt(i, 2).toString();
				String parent = model.getValueAt(i, 3).toString();
				String contact = model.getValueAt(i, 4).toString();
				String standard = model.getValueAt(i, 5).toString();

				txtName.setText(name);
				txtAddress.setText(address);
				txtContactNo.setText(contact);
				txtParentName.setText(parent);
				cbStandard.setSelectedItem(standard);
			}
		});
		scrollPane.setViewportView(table);
		// Khai báo tên các cột của table
		Object[] columns = { "RegID", "Name", "Address", "Parent", "Contact", "Standard", "RegDate" };
		model.setColumnIdentifiers(columns);// set lên table các cột theo thứ tự tự tăng dần
		table.setModel(model);

		// Ẩn cột đầu tiên (RegID) không cho hiện trên table
		table.removeColumn(table.getColumnModel().getColumn(0));// getColumn(0)->0 la cot dau tien

		loadComboBox();
		loadTable();
	}

	public boolean checkValidInput() {
		String namehs = txtName.getText();
		String diachi = txtAddress.getText();
		String phuhuynh = txtParentName.getText();
		String lienhe = txtContactNo.getText();

		if (namehs.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(getParent(), "Vui lòng điền Họ Tên", "Thông Báo", JOptionPane.ERROR_MESSAGE);
			txtName.requestFocus();
			return false;
		}
		if (diachi.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(getParent(), "Vui lòng điền Địa Chỉ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
			txtAddress.requestFocus();
			return false;
		}
		if (phuhuynh.equalsIgnoreCase("")) {
			txtParentName.requestFocus();
			JOptionPane.showMessageDialog(getParent(), "Vui lòng điền cha mẹ học viên", "Thông Báo",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (lienhe.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(getParent(), "Vui lòng điền số liên hệ", "Thông Báo",
					JOptionPane.ERROR_MESSAGE);
			txtContactNo.requestFocus();
			return false;
		}
		// Kiểm tra mẫu liên hệ
		String mau = "^[a-zA-Z0-9]{7,12}$";
		Pattern p = Pattern.compile(mau);
		Matcher m = p.matcher(lienhe);
		if (!m.matches()) {
			JOptionPane.showMessageDialog(getParent(), "Liên hệ không xác thực", "Thông Báo",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		int chon = cbStandard.getSelectedIndex();
		if (chon < 0) {
			JOptionPane.showMessageDialog(getParent(), "Vui lòng chọn standard", "Thông Báo",
					JOptionPane.ERROR_MESSAGE);
			cbStandard.requestFocus();
			return false;
		}
		return true;
	}

}
