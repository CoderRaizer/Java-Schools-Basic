package mainpackage;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connection.MyConnect;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class ManagerStore extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	JPanel panel_1;
	JPanel panel_2;
	JPanel panel_3;
	JPanel panel_4;
	
	ArrayList<String> codeCategory = new ArrayList<>();
	ArrayList<String> codeBrand = new ArrayList<>();
	ArrayList<String> codeSale = new ArrayList<>();
	
	JComboBox<String> comboBoxCategory;
	JComboBox<String> comboBoxBrand;
	JComboBox<String> comboBoxSale;
	
	Vector<String> v1 = new Vector<String>();
	Vector<String> v2 = new Vector<String>();
	Vector<String> v3 = new Vector<String>();
	
	HashMap<String,String> list_category  = new HashMap<>();
	HashMap<String,String> list_brand  = new HashMap<>();
	HashMap<String,String> list_sale  = new HashMap<>();
	
	Connection con = null;
	
	JTextField txtCodeProduct;
	JTextField txtNameProduct;
	JTextField txtTimeWaranty;
	JTextField txtPriceImport;
	JTextField txtPrice;
	JTextField txtInventory;
	
	JButton btnSave;
	JButton btnUpdate;
	JButton btnDelete;
	JButton btnReset;
	JButton btnShowcode;
	
	
	JTextArea txtInfoProduct;
	
	private String CodeProduct;
	
	JScrollPane scrollPane;
	JTable table;
	DefaultTableModel model = new DefaultTableModel();
	private JButton btnSearch;
	private JTextField txtSearch;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerStore frame = new ManagerStore();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void loadCategory() {
		try {
			String sql = "select * From DANHMUC";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			model.setRowCount(0);
			while(rs.next()) {
				list_category.put(rs.getString(1), rs.getString(2));
				codeCategory.add(rs.getString(1));
				v1.addElement(rs.getString(2));
			}
			comboBoxCategory.setModel(new DefaultComboBoxModel<>(v1));
		}catch(SQLException ex) {
			System.out.println(ex.toString());
		}
	}
	
	public void loadBrand() {
		try {
			String sql = "select * from THUONGHIEU";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list_brand.put(rs.getString(1), rs.getString(2));
				codeBrand.add(rs.getString(1));
				v2.addElement(rs.getString(2));
			}
			comboBoxBrand.setModel(new DefaultComboBoxModel<>(v2));
		}catch(SQLException ex) {
			System.out.println(ex.toString());
		}
	}
	
	public void loadSale() {
		try {
			String sql = "select * from GIAMGIA";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list_sale.put(rs.getString(1), rs.getString(2));
				codeSale.add(rs.getString(1));
				v3.addElement(rs.getString(2));
			}
			comboBoxSale.setModel(new DefaultComboBoxModel<>(v3));
		}catch(SQLException ex) {
			System.out.println(ex.toString());
		}
	}

	public void loadDataProduct() {
		Object []row = new Object[10];
		try {
			String sql = "SELECT * FROM SANPHAM";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			model.setRowCount(0);
			while(rs.next()) {
				row[0] = rs.getString(1);
				row[1] = rs.getString(2);
				row[2] = rs.getInt(3);
				row[3] = rs.getInt(4);
				row[4] = rs.getInt(5);
				row[5] = rs.getInt(6);
				row[6] = rs.getString(7);
				row[7] = rs.getString(8);
				row[8] = rs.getString(9);
				row[9] = rs.getString(10);
				
				System.out.println("Object readed: "+ row[0]);
				model.addRow(row);
			}
			rs.close();
			ps.close();
		}catch(SQLException ex) {
			System.out.println(ex.toString());
		}
	}
	
	
	public ManagerStore() {
		
		con = new MyConnect().getConnect();
		if(con != null) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 204));
		panel_1.setBounds(0, 0, 454, 417);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCodeProduct = new JLabel("Code Product");
		lblCodeProduct.setFont(new Font("Calibri Light", Font.BOLD, 12));
		lblCodeProduct.setBounds(0, 11, 84, 22);
		panel_1.add(lblCodeProduct);
		
		txtCodeProduct = new JTextField();
		txtCodeProduct.setBackground(new Color(240, 255, 240));
		txtCodeProduct.setBounds(94, 12, 350, 21);
		panel_1.add(txtCodeProduct);
		txtCodeProduct.setColumns(10);
		
		JLabel lblNameProduct = new JLabel("Name Product");
		lblNameProduct.setFont(new Font("Calibri Light", Font.BOLD, 12));
		lblNameProduct.setBounds(0, 40, 84, 22);
		panel_1.add(lblNameProduct);
		
		txtNameProduct = new JTextField();
		txtNameProduct.setBackground(new Color(240, 255, 240));
		txtNameProduct.setColumns(10);
		txtNameProduct.setBounds(94, 41, 350, 21);
		panel_1.add(txtNameProduct);
		
		JLabel lblTimeWaranty = new JLabel("Time Waranty");
		lblTimeWaranty.setFont(new Font("Calibri Light", Font.BOLD, 12));
		lblTimeWaranty.setBounds(0, 69, 84, 22);
		panel_1.add(lblTimeWaranty);
		
		txtTimeWaranty = new JTextField();
		txtTimeWaranty.setBackground(new Color(240, 255, 240));
		txtTimeWaranty.setColumns(10);
		txtTimeWaranty.setBounds(94, 69, 350, 21);
		panel_1.add(txtTimeWaranty);
		
		JLabel lblPriceImport = new JLabel("Price Import");
		lblPriceImport.setFont(new Font("Calibri Light", Font.BOLD, 12));
		lblPriceImport.setBounds(0, 95, 84, 22);
		panel_1.add(lblPriceImport);
		
		txtPriceImport = new JTextField();
		txtPriceImport.setBackground(new Color(240, 255, 240));
		txtPriceImport.setColumns(10);
		txtPriceImport.setBounds(94, 96, 350, 21);
		panel_1.add(txtPriceImport);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Calibri Light", Font.BOLD, 12));
		lblPrice.setBounds(0, 122, 84, 22);
		panel_1.add(lblPrice);
		
		txtPrice = new JTextField();
		txtPrice.setBackground(new Color(240, 255, 240));
		txtPrice.setColumns(10);
		txtPrice.setBounds(94, 123, 350, 21);
		panel_1.add(txtPrice);
		
		JLabel lblInventory = new JLabel("Inventory");
		lblInventory.setFont(new Font("Calibri Light", Font.BOLD, 12));
		lblInventory.setBounds(0, 150, 84, 22);
		panel_1.add(lblInventory);
		
		txtInventory = new JTextField();
		txtInventory.setBackground(new Color(240, 255, 240));
		txtInventory.setColumns(10);
		txtInventory.setBounds(94, 151, 350, 21);
		panel_1.add(txtInventory);
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(413, 183, 31, 22);
		panel_1.add(lblInfo);
		
		txtInfoProduct = new JTextArea();
		txtInfoProduct.setBounds(0, 211, 444, 128);
		panel_1.add(txtInfoProduct);
		
		comboBoxCategory = new JComboBox<String>();
		comboBoxCategory.setBackground(new Color(102, 204, 0));
		comboBoxCategory.setBounds(10, 380, 119, 37);
		panel_1.add(comboBoxCategory);
		
		comboBoxBrand = new JComboBox<String>();
		comboBoxBrand.setBackground(new Color(102, 204, 0));
		comboBoxBrand.setBounds(160, 380, 129, 37);
		panel_1.add(comboBoxBrand);
		
		comboBoxSale = new JComboBox<String>();
		comboBoxSale.setBackground(new Color(102, 204, 0));
		comboBoxSale.setBounds(319, 380, 125, 37);
		panel_1.add(comboBoxSale);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(10, 345, 119, 37);
		panel_1.add(lblCategory);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setBounds(160, 345, 129, 37);
		panel_1.add(lblBrand);
		
		JLabel lblSale = new JLabel("Sale");
		lblSale.setBounds(319, 345, 129, 37);
		panel_1.add(lblSale);
		
		panel_2 = new JPanel();
		panel_2.setBounds(0, 417, 454, 144);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					String sql = "INSERT INTO dbo.SANPHAM VALUES(? ,? ,? ,? ,? ,? ,? ,? ,? ,?)";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1,txtCodeProduct.getText().toString());
					ps.setString(2,txtNameProduct.getText().toString());
					ps.setInt(3,Integer.parseInt(txtTimeWaranty.getText().toString()));
					ps.setInt(4,Integer.parseInt(txtPriceImport.getText().toString()));
					ps.setInt(5,Integer.parseInt(txtPrice.getText().toString()));
					ps.setInt(6,Integer.parseInt(txtInventory.getText().toString()));
					ps.setString(7,txtInfoProduct.getText());
					ps.setString(8,codeCategory.get(comboBoxCategory.getSelectedIndex()).toString());
					ps.setString(9,codeBrand.get(comboBoxBrand.getSelectedIndex()).toString());
					ps.setString(10,codeSale.get(comboBoxSale.getSelectedIndex()).toString());
					
					int result = ps.executeUpdate();
					if(result == 1) {
						JOptionPane.showMessageDialog(getParent(),"Add Success");
					} else {
						JOptionPane.showMessageDialog(getParent(),"Add Fail");
					}
				}catch(SQLException ex) {
					System.out.println(ex.toString());
				}
				loadDataProduct();
			}
		});
		btnSave.setBounds(10, 11, 89, 23);
		panel_2.add(btnSave);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					String sql = "Update SANPHAM SET MaSP=?,TenSP=?,ThoiGianBH=?,GiaNhap=?,GiaBan=?,TonKho=?,ThongSoSP=?,MaDM=?,MaTH=?,MaGG=? WHERE MaSP = ?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1,txtCodeProduct.getText().toString());
					ps.setString(2,txtNameProduct.getText().toString());
					ps.setInt(3,Integer.parseInt(txtTimeWaranty.getText().toString()));
					ps.setInt(4,Integer.parseInt(txtPriceImport.getText().toString()));
					ps.setInt(5,Integer.parseInt(txtPrice.getText().toString()));
					ps.setInt(6,Integer.parseInt(txtInventory.getText().toString()));
					ps.setString(7,txtInfoProduct.getText());
					ps.setString(8,codeCategory.get(comboBoxCategory.getSelectedIndex()).toString());
					ps.setString(9,codeBrand.get(comboBoxBrand.getSelectedIndex()).toString());
					ps.setString(10,codeSale.get(comboBoxSale.getSelectedIndex()).toString());
					ps.setString(11,CodeProduct);
					
					int result = ps.executeUpdate();
					if(result == 1) {
						JOptionPane.showMessageDialog(getParent(),"success");
					} else {
						JOptionPane.showMessageDialog(getParent(),"fail");
					}
					
				}catch(SQLException ex) {
					System.out.println(ex.toString());
				}
				loadDataProduct();
			}
		});
		btnUpdate.setBounds(122, 11, 89, 23);
		panel_2.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					String sql = "Delete From SANPHAM Where MaSP = ?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1,CodeProduct);
					int result = ps.executeUpdate();
					if(result == 1) {
						JOptionPane.showMessageDialog(getParent(),"Delete success");
					} else {
						JOptionPane.showMessageDialog(getParent(),"Delete Fail");
					}
				}catch(SQLException ex) {
					System.out.println(ex.toString());
				}
				loadDataProduct();
			}
		});
		btnDelete.setBounds(239, 11, 89, 23);
		panel_2.add(btnDelete);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCodeProduct.setText("");
				txtNameProduct.setText("");
				txtTimeWaranty.setText("");
				txtPriceImport.setText("");
				txtPrice.setText("");
				txtInventory.setText("");
				txtInfoProduct.setText("");
				comboBoxCategory.setSelectedIndex(0);
				comboBoxBrand.setSelectedIndex(0);
				comboBoxSale.setSelectedIndex(0);
			}
		});
		btnReset.setBounds(355, 11, 89, 23);
		panel_2.add(btnReset);
		
		btnShowcode = new JButton("ShowCode");
		btnShowcode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.out.println("Code Category - Brand - Sale: " + codeCategory.get(comboBoxCategory.getSelectedIndex()) + " - " + codeBrand.get(comboBoxBrand.getSelectedIndex()) + " - " + codeSale.get(comboBoxSale.getSelectedIndex()));
			}
		});
		btnShowcode.setBounds(10, 110, 112, 23);
		panel_2.add(btnShowcode);
		
		panel_3 = new JPanel();
		panel_3.setBounds(458, 41, 626, 520);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 626, 561);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(153, 204, 204));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				int i = table.getSelectedRow();
				CodeProduct = model.getValueAt(i,0).toString();
				System.out.println("Code Product Now: " + CodeProduct);
				txtCodeProduct.setText(model.getValueAt(i,0).toString());
				txtNameProduct.setText(model.getValueAt(i,1).toString());
				txtTimeWaranty.setText(model.getValueAt(i,2).toString());
				txtPriceImport.setText(model.getValueAt(i,3).toString());
				txtPrice.setText(model.getValueAt(i,4).toString());
				txtInventory.setText(model.getValueAt(i,5).toString());
				txtInfoProduct.setText(model.getValueAt(i,6).toString());
				comboBoxCategory.setSelectedItem(list_category.get(model.getValueAt(i,7).toString()));
				comboBoxBrand.setSelectedItem(list_brand.get(model.getValueAt(i,8).toString()));
				comboBoxSale.setSelectedItem(list_sale.get(model.getValueAt(i,9).toString()));
			}
		});
		scrollPane.setViewportView(table);
		Object []column = {"Code Product", "Name Product", "Time Waranty","Price Inport", "Price", "Inventory","Info Product","Code Category","Code Brand","Code Sale"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		/*---- Hide Column ----*/
		table.removeColumn(table.getColumnModel().getColumn(7));
		table.removeColumn(table.getColumnModel().getColumn(8));
		
		panel_4 = new JPanel();
		panel_4.setBounds(458, 0, 626, 30);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Calibri Light", Font.BOLD, 14));
		btnSearch.setBackground(new Color(204, 51, 102));
		btnSearch.setBounds(0, 0, 85, 30);
		panel_4.add(btnSearch);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(85, 0, 285, 30);
		panel_4.add(txtSearch);
		txtSearch.setColumns(10);
		
		loadCategory();
		loadBrand();
		loadSale();
		loadDataProduct();
	}
}
