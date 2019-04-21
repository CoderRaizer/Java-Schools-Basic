package javaSwing_JDBC2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtusername;
	private JTextField txtpassword;
	Connection conn;

	
	public static void main() {
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


	public Login() {
		conn = new MyConnect().getcn();
		if (conn == null) {
			JOptionPane.showMessageDialog(getParent(), "CONNECT FAIL");
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsername = new JLabel("username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblUsername.setBounds(10, 57, 97, 34);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblPassword.setBounds(10, 110, 97, 34);
		contentPane.add(lblPassword);

		txtusername = new JTextField();
		txtusername.setBounds(133, 57, 259, 34);
		contentPane.add(txtusername);
		txtusername.setColumns(10);

		txtpassword = new JTextField();
		txtpassword.setBounds(133, 118, 259, 34);
		contentPane.add(txtpassword);
		txtpassword.setColumns(10);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String username;
					String password;

					username = txtusername.getText();
					password = txtpassword.getText();

					// String kt = "Select lock From Account where username like ? and password like
					// ? ";
					// PreparedStatement ps1 = conn.prepareStatement(kt);
					// ps1.setString(1,username);
					// ps1.setString(2,password);
					// ResultSet rs1 = ps1.executeQuery();
					// if(rs1.next())
					// {
					// JOptionPane.showMessageDialog(getParent(),"TAI KHOAN DA BI KHOA","Thong
					// Bao",JOptionPane.ERROR_MESSAGE);
					// return;
					// }

					String sql = "Select * From Account where username like ? and password = ? and lock = 0";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, username);
					ps.setString(2, password);
					ResultSet rs = ps.executeQuery();
					if (!rs.next()) {
						JOptionPane.showMessageDialog(getParent(), "FAIL,Vui long kiem tra lai");
						return;
					}

					else {
						JOptionPane.showMessageDialog(getParent(), "LOGIN SUCCESS");
					}

				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		btnLogin.setBackground(Color.PINK);
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBounds(133, 198, 141, 34);
		contentPane.add(btnLogin);

		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBackground(Color.LIGHT_GRAY);
		btnExit.setBounds(284, 198, 107, 34);
		contentPane.add(btnExit);
	}
}
