package mypackage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Array;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsername;
	private Connection con;
	private JPasswordField textPassword;
	private ArrayList<String> listpass = new ArrayList<>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public String getMD5String(String passHash) throws NoSuchAlgorithmException {
		String PassMD5="";
		try {
			byte[] bytePlainText = passHash.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] byteDigest = md.digest(bytePlainText);
			
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < byteDigest.length; i++) {
				sb.append(Integer.toHexString((byteDigest[i]&0xFF) | 0x100).substring(1,3));
			}
			PassMD5 = sb.toString();
		}catch(UnsupportedEncodingException ex) {
			System.out.println(ex.toString());
		}
		return PassMD5;
	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 279, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Calibri Light", Font.BOLD, 15));
		lblUsername.setBounds(92, 64, 84, 26);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Calibri Light", Font.BOLD, 15));
		lblPassword.setBounds(92, 123, 84, 26);
		contentPane.add(lblPassword);

		textUsername = new JTextField();
		textUsername.setBounds(10, 89, 243, 31);
		contentPane.add(textUsername);
		textUsername.setColumns(10);

		JButton btnHeader = new JButton("LOGIN");
		btnHeader.setFont(new Font("Calibri Light", Font.BOLD, 30));
		btnHeader.setBackground(new Color(192, 192, 192));
		btnHeader.setBounds(0, 0, 263, 38);
		contentPane.add(btnHeader);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String passInput = textPassword.getText();
				System.out.println("Password User Input : " + passInput);
				try {
					con = new MyConnect().getConnection();
					String sql = "Select PassWord From USERS Where UserName = ? and LockStatus = 0";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, textUsername.getText());

					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
							String pass = rs.getString("PassWord");
							listpass.add(pass);
					}

				} catch (SQLException ex) {
					System.out.println(ex.toString());
				}
				for (String x : listpass) {
					System.out.println(x);
					try { 
						System.out.println(getMD5String(x));
						if(getMD5String(x).equalsIgnoreCase(passInput)) {
							System.out.println("Thanh Cong");
						}
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btnLogin.setBackground(new Color(0, 191, 255));
		btnLogin.setBounds(10, 212, 243, 38);
		contentPane.add(btnLogin);

		textPassword = new JPasswordField();
		textPassword.setBounds(10, 150, 243, 31);
		contentPane.add(textPassword);
	}
}
