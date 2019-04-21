package bai3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BaiTap3 extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textHoTen;
	private JTextField textEmail;
	private JPasswordField textPass;
	private JPasswordField textRepass;


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

	public int CheckValidPass(String passWord) {
		if (passWord.length() < 6) {
			return -1;// khong du do dai
		}
		String sampleGegex = "\\w{6,30}";
		Pattern pt = Pattern.compile(sampleGegex, Pattern.CASE_INSENSITIVE);
		Matcher mt = pt.matcher(passWord);
		if (!mt.matches()) {
			return -2;// khong khop
		} else {
			return 1;
		}
	}
	
	
	public boolean checkValidEmail(String email) {
		String sampleGegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pt = Pattern.compile(sampleGegex, Pattern.CASE_INSENSITIVE);
		Matcher mt = pt.matcher(email);
		if (!mt.matches()) return false;
		else return true;
	}

	public BaiTap3() {
		setBackground(new Color(176, 224, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 436);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 0, 5, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon unicon = new ImageIcon("src/bai3/anh2.png");
		JLabel lblDangKy = new JLabel("ĐĂNG KÝ TÀI KHOẢN");
		lblDangKy.setForeground(new Color(25, 25, 112));
		lblDangKy.setBackground(new Color(255, 255, 255));
		lblDangKy.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblDangKy.setBounds(125, 0, 287, 45);
		contentPane.add(lblDangKy);
		lblDangKy.setIcon(unicon);

		JLabel lblName = new JLabel("H\u1ECD V\u00E0 T\u00EAn");
		lblName.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblName.setBounds(10, 32, 115, 25);
		contentPane.add(lblName);

		textHoTen = new JTextField();
		textHoTen.setBounds(10, 56, 379, 25);
		contentPane.add(textHoTen);
		textHoTen.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEmail.setBounds(10, 92, 115, 25);
		contentPane.add(lblEmail);

		textEmail = new JTextField();
		textEmail.setBounds(10, 114, 379, 25);
		contentPane.add(textEmail);
		textEmail.setColumns(10);

		JLabel lblPass = new JLabel("M\u1EADt Kh\u1EA9u");
		lblPass.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPass.setBounds(10, 150, 115, 25);
		contentPane.add(lblPass);

		textPass = new JPasswordField();
		textPass.setBounds(10, 177, 379, 25);
		contentPane.add(textPass);

		JLabel lblRePass = new JLabel("Nh\u1EADp l\u1EA1i m\u1EADt kh\u1EA9u");
		lblRePass.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblRePass.setBounds(10, 208, 155, 25);
		contentPane.add(lblRePass);

		ImageIcon iconCorect = new ImageIcon("src/bai3/iconCorrect.png");
		JLabel labelCorect = new JLabel("");
		labelCorect.setBounds(388, 231, 24, 25);
		contentPane.add(labelCorect);
		textRepass = new JPasswordField();
		textRepass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (Arrays.equals(textPass.getPassword(), textRepass.getPassword())) {
					labelCorect.show();
					labelCorect.setIcon(iconCorect);
				} else {
					labelCorect.hide();
				}
			}
		});
		textRepass.setBounds(10, 231, 379, 25);
		contentPane.add(textRepass);

		JButton buttonContinue = new JButton("Ti\u1EBFp T\u1EE5c");
		buttonContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (textHoTen.getText().length() != 0) {
					if(checkValidEmail(textEmail.getText()) == true) {
						if (textPass.getPassword().length != 0) {
							String Pass = textPass.getText();
							System.out.println("Pass: " + Pass);
							if (CheckValidPass(Pass) == -1) {
								JOptionPane.showMessageDialog(null, "Password tối thiểu 6 ký tự");
							}
							if (CheckValidPass(Pass) == -2) {
								JOptionPane.showMessageDialog(null, "Password chỉ gồm chữ và số");
							}
							if (CheckValidPass(Pass) == 1) {
								if (Arrays.equals(textPass.getPassword(), textRepass.getPassword())) {
									JOptionPane.showMessageDialog(null, "ĐĂNG KÝ THÀNH CÔNG");
									textHoTen.setText("");
									textEmail.setText("");
									textPass.setText("");
									textRepass.setText("");
									labelCorect.hide();
								} else {
									JOptionPane.showMessageDialog(null, "Mật khẩu phải trùng khớp");
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "Password là bắt buộc");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Định dạng email không hợp lệ");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Họ Tên & Email không được bỏ trống");
				}
			}
		});

		buttonContinue.setBackground(new Color(0, 206, 209));
		buttonContinue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonContinue.setForeground(new Color(0, 0, 0));
		buttonContinue.setBounds(10, 267, 379, 35);
		contentPane.add(buttonContinue);

		ImageIcon iconFacebook = new ImageIcon("src/bai3/facemini.png");
		JButton btnFacebook = new JButton("FACEBOOK");
		btnFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (textHoTen.getText().length() != 0) {
					if(checkValidEmail(textEmail.getText()) == true) {
						if (textPass.getPassword().length != 0) {
							String Pass = textPass.getText();
							System.out.println("Pass: " + Pass);
							if (CheckValidPass(Pass) == -1) {
								JOptionPane.showMessageDialog(null, "Password tối thiểu 6 ký tự");
							}
							if (CheckValidPass(Pass) == -2) {
								JOptionPane.showMessageDialog(null, "Password chỉ gồm chữ và số");
							}
							if (CheckValidPass(Pass) == 1) {
								if (Arrays.equals(textPass.getPassword(), textRepass.getPassword())) {
									JOptionPane.showMessageDialog(null, "ĐĂNG KÝ THÀNH CÔNG");
									textHoTen.setText("");
									textEmail.setText("");
									textPass.setText("");
									textRepass.setText("");
									labelCorect.hide();
								} else {
									JOptionPane.showMessageDialog(null, "Mật khẩu phải trùng khớp");
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "Password là bắt buộc");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Định dạng email không hợp lệ");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Họ Tên & Email không được bỏ trống");
				}
			
			}
		});
		btnFacebook.setBackground(new Color(65, 105, 225));
		btnFacebook.setForeground(new Color(255, 255, 255));
		btnFacebook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFacebook.setBounds(10, 347, 190, 39);
		contentPane.add(btnFacebook);
		btnFacebook.setIcon(iconFacebook);

		ImageIcon iconGoogle = new ImageIcon("src/bai3/googlemini.png");
		JButton btnGoogle = new JButton("GOOGLE+");
		btnGoogle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (textHoTen.getText().length() != 0) {
					if(checkValidEmail(textEmail.getText()) == true) {
						if (textPass.getPassword().length != 0) {
							String Pass = textPass.getText();
							System.out.println("Pass: " + Pass);
							if (CheckValidPass(Pass) == -1) {
								JOptionPane.showMessageDialog(null, "Password tối thiểu 6 ký tự");
							}
							if (CheckValidPass(Pass) == -2) {
								JOptionPane.showMessageDialog(null, "Password chỉ gồm chữ và số");
							}
							if (CheckValidPass(Pass) == 1) {
								if (Arrays.equals(textPass.getPassword(), textRepass.getPassword())) {
									JOptionPane.showMessageDialog(null, "ĐĂNG KÝ THÀNH CÔNG");
									textHoTen.setText("");
									textEmail.setText("");
									textPass.setText("");
									textRepass.setText("");
									labelCorect.hide();
								} else {
									JOptionPane.showMessageDialog(null, "Mật khẩu phải trùng khớp");
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "Password là bắt buộc");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Định dạng email không hợp lệ");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Họ Tên & Email không được bỏ trống");
				}
			}
		});
		btnGoogle.setBackground(new Color(255, 0, 0));
		btnGoogle.setForeground(new Color(255, 255, 255));
		btnGoogle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGoogle.setBounds(210, 347, 179, 39);
		contentPane.add(btnGoogle);
		btnGoogle.setIcon(iconGoogle);

		JLabel sep = new JLabel("---------------------------------Hoặc đăng nhập bằng-------------------------------");
		sep.setEnabled(false);
		sep.setBounds(10, 307, 379, 29);
		contentPane.add(sep);

		ImageIcon iconTooltip = new ImageIcon("src/bai3/chamhoi.png");
		JLabel labelTooltip = new JLabel("");
		labelTooltip.setToolTipText("Mật khẩu từ 6 đến 30 ký tự, bao gồm cả số và chữ!!!");
		labelTooltip.setBounds(388, 177, 24, 25);
		contentPane.add(labelTooltip);
		labelTooltip.setIcon(iconTooltip);

	}
}
