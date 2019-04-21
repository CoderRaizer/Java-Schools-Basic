package mypackage;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class QuanLySinhVien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;

	private DefaultTableModel model = new DefaultTableModel();
	private JTable table;

	private JTextField textMSSV;
	private JTextField textHoTen;
	private JTextField textDiemToan;
	private JTextField textDiemLy;
	private JTextField textDiemHoa;
	private JLabel labelDiemLy;
	private JTextField textSearch;

	private String mssv = "";

	private ArrayList<SinhVien> list = new ArrayList<SinhVien>();

	private Connection con;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLySinhVien frame = new QuanLySinhVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String XepLoai(float diem_TB) {
		if (diem_TB >= (float) 9 && diem_TB <= (float) 10) {
			return "GIOI";
		}
		if (diem_TB >= (float) 7 && diem_TB < (float) 9) {
			return "KHA";
		}
		if (diem_TB >= (float) 5 && diem_TB < (float) 7) {
			return "TRUNG BINH";
		}
		if (diem_TB < (float) 5) {
			return "KHONG DAT";
		}
		return "";
	}

	public void loadTable() {
		con = new MyConnect().GetConnection();
		Object[] row = new Object[7];
		try {
			String sql = "Select * From SinhVien";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			model.setRowCount(0);

			while (rs.next()) {
				row[0] = rs.getString(1);
				row[1] = rs.getString(2);
				row[2] = rs.getFloat(3);
				row[3] = rs.getFloat(4);
				row[4] = rs.getFloat(5);
				float tb = (float) ((float) row[2] + (float) row[3] + (float) row[4]) / 3;
				tb = (float) Math.floor(tb * 10) / 10;
				row[5] = String.valueOf(tb);
				row[6] = XepLoai(tb);

				model.addRow(row);
			}
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
	}

	public void loadTableBySearch() {
		Object[] row = new Object[7];
		model.setRowCount(0);
		for (SinhVien sv : list) {
			row[0] = sv.getMssv();
			row[1] = sv.getHoten();
			row[2] = sv.getDiem_Toan();
			row[3] = sv.getDiem_Ly();
			row[4] = sv.getDiem_Hoa();
			float tb = (float) ((float) row[2] + (float) row[3] + (float) row[4]) / 3;
			tb = (float) Math.floor(tb * 10) / 10;
			row[5] = String.valueOf(tb);
			row[6] = XepLoai(tb);
			model.addRow(row);
		}
	}

	public QuanLySinhVien() {

		con = new MyConnect().GetConnection();
		if (con == null) {
			JOptionPane.showMessageDialog(getParent(), "Kết nối Database thất bại");
			return;
		} else {
			System.out.println("Thanh Cong");
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setBounds(0, 0, 440, 240);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel labelMSSV = new JLabel("M\u00E3 Sinh Vi\u00EAn");
		labelMSSV.setFont(new Font("Calibri Light", Font.BOLD, 15));
		labelMSSV.setBounds(10, 67, 101, 24);
		panel_1.add(labelMSSV);

		textMSSV = new JTextField();
		textMSSV.setBounds(121, 67, 296, 24);
		panel_1.add(textMSSV);
		textMSSV.setColumns(10);

		JLabel labelHoTen = new JLabel("H\u1ECD T\u00EAn");
		labelHoTen.setFont(new Font("Calibri Light", Font.BOLD, 15));
		labelHoTen.setBounds(10, 102, 101, 24);
		panel_1.add(labelHoTen);

		textHoTen = new JTextField();
		textHoTen.setBounds(121, 102, 296, 24);
		panel_1.add(textHoTen);
		textHoTen.setColumns(10);

		JLabel labelDiemToan = new JLabel("\u0110i\u1EC3m To\u00E1n");
		labelDiemToan.setFont(new Font("Calibri Light", Font.BOLD, 15));
		labelDiemToan.setBounds(10, 137, 101, 24);
		panel_1.add(labelDiemToan);

		textDiemToan = new JTextField();
		textDiemToan.setBounds(121, 137, 296, 24);
		panel_1.add(textDiemToan);
		textDiemToan.setColumns(10);

		labelDiemLy = new JLabel("\u0110i\u1EC3m l\u00FD");
		labelDiemLy.setFont(new Font("Calibri Light", Font.BOLD, 15));
		labelDiemLy.setBounds(10, 171, 101, 24);
		panel_1.add(labelDiemLy);

		textDiemLy = new JTextField();
		textDiemLy.setBounds(121, 172, 296, 22);
		panel_1.add(textDiemLy);
		textDiemLy.setColumns(10);

		JLabel labelDiemHoa = new JLabel("\u0110i\u1EC3m H\u00F3a");
		labelDiemHoa.setFont(new Font("Calibri Light", Font.BOLD, 15));
		labelDiemHoa.setBounds(10, 206, 101, 22);
		panel_1.add(labelDiemHoa);

		textDiemHoa = new JTextField();
		textDiemHoa.setBounds(121, 205, 296, 24);
		panel_1.add(textDiemHoa);
		textDiemHoa.setColumns(10);

		JButton btnInfo = new JButton("THÔNG TIN SINH VIÊN");
		btnInfo.setFont(new Font("Calibri Light", Font.BOLD, 25));
		btnInfo.setForeground(new Color(255, 255, 255));
		btnInfo.setBackground(new Color(51, 51, 51));
		btnInfo.setBounds(0, 0, 440, 53);
		panel_1.add(btnInfo);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(230, 230, 250));
		panel_2.setBounds(439, 0, 139, 240);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					String sql = "Insert into SinhVien values(?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, textMSSV.getText());
					ps.setString(2, textHoTen.getText());
					float diemtoan = Float.parseFloat(textDiemToan.getText());
					float diemly = Float.parseFloat(textDiemLy.getText());
					float diemhoa = Float.parseFloat(textDiemHoa.getText());
					ps.setFloat(3, diemtoan);
					ps.setFloat(4, diemly);
					ps.setFloat(5, diemhoa);
					int result = ps.executeUpdate();
					if (result == 1) {
						JOptionPane.showMessageDialog(getParent(), "CREATE SUCCESS");
					} else {
						JOptionPane.showMessageDialog(getParent(), "CREATE FAIL");
					}
				} catch (SQLException ex) {
					System.out.println(ex.toString());
				}
				loadTable();
				mssv = "";
			}
		});
		btnAdd.setBackground(new Color(0, 250, 154));
		btnAdd.setFont(new Font("Calibri Light", Font.BOLD, 14));
		btnAdd.setBounds(10, 11, 119, 32);
		panel_2.add(btnAdd);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (mssv == "") {
					JOptionPane.showMessageDialog(getParent(), "Bạn chưa chọn dòng dữ liệu nào");
				} else {
					try {
						String sql = "Update SinhVien Set mssv=?,HoTen=?,DiemToan=?,DiemLy=?,DiemHoa=? Where mssv = ?";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, textMSSV.getText());
						ps.setString(2, textHoTen.getText());
						float diemtoan = Float.parseFloat(textDiemToan.getText().toString());
						float diemlt = Float.parseFloat(textDiemLy.getText().toString());
						float diemhoa = Float.parseFloat(textDiemHoa.getText().toString());

						ps.setFloat(3, diemtoan);
						ps.setFloat(4, diemlt);
						ps.setFloat(5, diemhoa);
						ps.setString(6, mssv);

						int kq = ps.executeUpdate();
						if (kq == 1) {
							JOptionPane.showMessageDialog(getParent(), "Update Success");
						} else {
							JOptionPane.showMessageDialog(getParent(), "Update Fail");
						}
					} catch (SQLException ex) {
						System.out.println(ex.toString());
					}
					mssv = "";
					loadTable();
				}
			}
		});
		btnUpdate.setBackground(new Color(100, 149, 237));
		btnUpdate.setFont(new Font("Calibri Light", Font.BOLD, 14));
		btnUpdate.setBounds(10, 54, 119, 32);
		panel_2.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mssv == "") {
					JOptionPane.showMessageDialog(getParent(), "Bạn Chưa Chọn Dòng Dữ Liệu Nào");
				} else {
					try {
						String sql = "Delete from SinhVien Where mssv = ?";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, mssv);
						int kq = ps.executeUpdate();
						if (kq == 1) {
							JOptionPane.showMessageDialog(getParent(), "Delete success");
						} else {
							JOptionPane.showMessageDialog(getParent(), "Delete fail");
						}
					} catch (SQLException ex) {
						System.out.println(ex.toString());
					}
					loadTable();
					mssv = "";
				}
			}
		});
		btnDelete.setBackground(new Color(204, 51, 102));
		btnDelete.setFont(new Font("Calibri Light", Font.BOLD, 14));
		btnDelete.setBounds(10, 97, 119, 32);
		panel_2.add(btnDelete);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				textMSSV.setText("");
				textHoTen.setText("");
				textDiemToan.setText("");
				textDiemLy.setText("");
				textDiemHoa.setText("");
				textSearch.setText("");
				loadTable();
				mssv = "";
			}
		});
		btnReset.setBackground(new Color(221, 160, 221));
		btnReset.setFont(new Font("Calibri Light", Font.BOLD, 14));
		btnReset.setBounds(10, 140, 119, 32);
		panel_2.add(btnReset);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setBackground(new Color(255, 255, 0));
		btnClose.setFont(new Font("Calibri Light", Font.BOLD, 15));
		btnClose.setBounds(10, 183, 119, 32);
		panel_2.add(btnClose);

		panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 51, 102));
		panel_3.setBounds(579, 0, 305, 240);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		textSearch = new JTextField();
		textSearch.setBackground(new Color(255, 250, 250));
		textSearch.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent evt) {
				System.out.println("MSSV: " + textSearch.getText().toString());
				try {
					if (textSearch.getText() == "") {
						textSearch.setText("");
					}
					list.clear();
					String sql = "select * from SinhVien where mssv like ?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, "%" + textSearch.getText().toString() + "%");

					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						String mssv = rs.getString(1);
						String hoten = rs.getString(2);
						float diemtoan = rs.getFloat(3);
						float diemly = rs.getFloat(4);
						float diemhoa = rs.getFloat(5);
						float tb = (float) (diemtoan + diemly + (float) diemhoa) / 3;
						tb = (float) Math.floor(tb * 10) / 10;
						String xeploai = XepLoai(tb);

						list.add(new SinhVien(mssv, hoten, diemtoan, diemly, diemhoa, tb, xeploai));
					}
					System.out.println(
							"----------------------------------NEW LIST--------------------------------------");
					for (SinhVien sv : list) {
						sv.ShowInfoStudent();
					}
					rs.close();
					ps.close();
				} catch (SQLException ex) {
					System.out.println(ex.toString());
				}
				loadTableBySearch();
			}
		});
		textSearch.setBounds(86, 11, 209, 32);
		panel_3.add(textSearch);
		textSearch.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setBackground(new Color(255, 51, 102));
		btnSearch.setBounds(10, 11, 79, 32);
		panel_3.add(btnSearch);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 242, 884, 219);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 884, 219);
		panel_4.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				int i = table.getSelectedRow(); // i = row on click table
				mssv = String.valueOf(model.getValueAt(i, 0));
				System.out.println("mssv : " + mssv);
				textMSSV.setText(model.getValueAt(i, 0).toString());
				textHoTen.setText(model.getValueAt(i, 1).toString());
				textDiemToan.setText(model.getValueAt(i, 2).toString());
				textDiemLy.setText(model.getValueAt(i, 3).toString());
				textDiemHoa.setText(model.getValueAt(i, 4).toString());
			}
		});
		table.setBackground(new Color(51, 255, 153));
		scrollPane.setViewportView(table);
		Object[] columns = { "MSSV", "Họ Tên", "Điểm Toán", "Điểm Lý", "Điểm Hóa", "Trung Bình", "Xếp Loại" };
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		loadTable();
	}
}
