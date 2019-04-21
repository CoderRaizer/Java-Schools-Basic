package bai4;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutput;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import java.awt.Font;

public class BaiTap4 extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private double result;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaiTap4 frame = new BaiTap4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public static Object doCalc(String str) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        return engine.eval(str);
    }
	
	public BaiTap4() throws ScriptException {
		
		/*-------------------------------------------------*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 316);
		setResizable(false);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelResult = new JPanel();
		panelResult.setBounds(0, 0, 382, 49);
		contentPane.add(panelResult);
		panelResult.setLayout(null);
		
		Label label = new Label("0");
		label.setFont(new Font("Calibri Light", Font.BOLD | Font.ITALIC, 20));
		label.setBackground(new Color(64, 224, 208));
		label.setBounds(0, 0, 382, 49);
		label.setAlignment(2);
		panelResult.add(label);
		
		Panel panelKey = new Panel();
		panelKey.setBounds(0, 49, 382, 238);
		panelKey.setLayout(new GridLayout(4,5));
		contentPane.add(panelKey);
		
		
		/*--------------------------------------*/
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		/*--------------------------------------*/
		
		
		/*-------------------------------------------------*/
		JButton number7 = new JButton("7");
		number7.setBackground(new Color(30, 144, 255));
		number7.setFont(new Font("Tahoma", Font.BOLD, 15));
		number7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(label.getText() == "0") {
					label.setText("7");
				} else {
					String newValue = label.getText()+"7";
					label.setText(newValue);
				}
			}
		});panelKey.add(number7);
		
		JButton number8 = new JButton("8");
		number8.setBackground(new Color(30, 144, 255));
		number8.setFont(new Font("Tahoma", Font.BOLD, 15));
		number8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(label.getText() == "0") {
					label.setText("8");
				} else {
					String newValue = label.getText()+"8";
					label.setText(newValue);
				}
			}
		});panelKey.add(number8);
		
		JButton number9 = new JButton("9");
		number9.setBackground(new Color(30, 144, 255));
		number9.setFont(new Font("Tahoma", Font.BOLD, 15));
		number9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(label.getText() == "0") {
					label.setText("9");
				} else {
					String newValue = label.getText()+"9";
					label.setText(newValue);
				}
			}
		});panelKey.add(number9);
		
		JButton buttonCong = new JButton("+");
		buttonCong.setBackground(new Color(147, 112, 219));
		buttonCong.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonCong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String calString =label.getText()+ "+";
				label.setText(calString);
			}
		});panelKey.add(buttonCong);
		
		JButton buttonClear = new JButton("C");
		buttonClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText("0");
			}
		});panelKey.add(buttonClear);
		
		JButton number4 = new JButton("4");
		number4.setBackground(new Color(30, 144, 255));
		number4.setFont(new Font("Tahoma", Font.BOLD, 15));
		number4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(label.getText() == "0") {
					label.setText("4");
				} else {
					String newValue = label.getText()+"4";
					label.setText(newValue);
				}
			}
		});panelKey.add(number4);
		
		JButton number5 = new JButton("5");
		number5.setBackground(new Color(30, 144, 255));
		number5.setFont(new Font("Tahoma", Font.BOLD, 15));
		number5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(label.getText() == "0") {
					label.setText("5");
				} else {
					String newValue = label.getText()+"5";
					label.setText(newValue);
				}
			}
		});panelKey.add(number5);
		
		JButton number6 = new JButton("6");
		number6.setBackground(new Color(30, 144, 255));
		number6.setFont(new Font("Tahoma", Font.BOLD, 15));
		number6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(label.getText() == "0") {
					label.setText("6");
				} else {
					String newValue = label.getText()+"6";
					label.setText(newValue);
				}
			}
		});panelKey.add(number6);
		
		JButton buttonTru = new JButton("-");
		buttonTru.setBackground(new Color(147, 112, 219));
		buttonTru.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonTru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String calString =label.getText()+ "-";
				label.setText(calString);
			}
		});panelKey.add(buttonTru);
		
		JButton buttonMu = new JButton("X^Y");
		buttonMu.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonMu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String calString =label.getText()+ "^";
				label.setText(calString);
			}
		});panelKey.add(buttonMu);
		
		JButton number1 = new JButton("1");
		number1.setBackground(new Color(30, 144, 255));
		number1.setFont(new Font("Tahoma", Font.BOLD, 15));
		number1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(label.getText() == "0") {
					label.setText("1");
				} else {
					String newValue = label.getText()+"1";
					label.setText(newValue);
				}
			}
		});panelKey.add(number1);
		
		JButton number2 = new JButton("2");
		number2.setBackground(new Color(30, 144, 255));
		number2.setFont(new Font("Tahoma", Font.BOLD, 15));
		number2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(label.getText() == "0") {
					label.setText("2");
				} else {
					String newValue = label.getText()+"2";
					label.setText(newValue);
				}
			}
		});panelKey.add(number2);
		
		JButton number3 = new JButton("3");
		number3.setBackground(new Color(30, 144, 255));
		number3.setFont(new Font("Tahoma", Font.BOLD, 15));
		number3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(label.getText() == "0") {
					label.setText("3");
				} else {
					String newValue = label.getText()+"3";
					label.setText(newValue);
				}
			}
		});panelKey.add(number3);
		
		JButton buttonNhan = new JButton("*");
		buttonNhan.setBackground(new Color(147, 112, 219));
		buttonNhan.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String calString =label.getText()+ "*";
				label.setText(calString);
			}
		});panelKey.add(buttonNhan);
		
		JButton buttonNghichDao = new JButton("1/X");//correctly
		buttonNghichDao.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonNghichDao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double number = Double.parseDouble(label.getText());
				if(number <= Double.MAX_VALUE && number >= Double.MIN_VALUE) {
					try {
						result = (double)(1/number);
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					
					label.setText(String.valueOf(result));
				}
			}
		});panelKey.add(buttonNghichDao);
		
		JButton number0 = new JButton("0");
		number0.setBackground(new Color(0, 250, 154));
		number0.setFont(new Font("Tahoma", Font.BOLD, 15));
		number0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String chuoi = label.getText();
					if(chuoi.length() == 1) {
						if(Double.parseDouble(chuoi) > 0) {
							String newValue = label.getText()+"0";
							label.setText(newValue);
						}
					} else if(chuoi.length() > 1) {
						String newValue = label.getText()+"0";
						label.setText(newValue);
					}
			}
		});panelKey.add(number0);
		
		JButton buttonCham = new JButton(".");//correctly
		buttonCham.setBackground(new Color(0, 250, 154));
		buttonCham.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonCham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String calString =label.getText()+ ".";
					label.setText(calString);
			}
		});panelKey.add(buttonCham);
		
		///////////////////////////////////////////////////////////////
		JButton buttonBang = new JButton("=");
		buttonBang.setBackground(new Color(0, 250, 154));
		buttonBang.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonBang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = label.getText();
				char []array = x.toCharArray();
				boolean dk = ((int)array[array.length-1] > 57 || (int)array[array.length-1] < 48);
				if(dk) {
					JOptionPane.showMessageDialog(null,"BIỂU THỨC KHÔNG HỢP LỆ");
				} 
				
				else {
					//code here
					String chuoibieuthuc = label.getText();
					boolean exitPow = false;
					int check = 0;
					int index = 0;
					char []testArr = chuoibieuthuc.toCharArray();
					int lenght = chuoibieuthuc.length();
					for(int i = 0; i < lenght; i++) {
						if(testArr[i] == '^') {
							exitPow = true;
							index = i;
							check += 1;
						}
					}if(check > 1) {
						JOptionPane.showMessageDialog(null,"BIỂU THỨC KHÔNG HỢP LỆ");
					} else if (check == 1){
						String backVal = "";
						String frontVal = "";
						for(int i = 0; i < index ; i++) {
							backVal += testArr[i];
						} for (int i = index+1; i < lenght ; i++) {
							frontVal += testArr[i];
						}
						label.setText(String.valueOf(Math.pow(Double.parseDouble(backVal),Double.parseDouble(frontVal))));
					}
					
					if(exitPow == false) {
						Object KetQua = null;
						try {
							KetQua = doCalc(chuoibieuthuc);
						} catch (ScriptException e1) {
							e1.printStackTrace();
						}
							label.setText(KetQua.toString());
					}
				}
			}
		});panelKey.add(buttonBang);

		JButton buttonChia = new JButton("/");
		buttonChia.setBackground(new Color(147, 112, 219));
		buttonChia.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonChia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String calString =label.getText()+ "/";
				label.setText(calString);
			}
		});panelKey.add(buttonChia);
		
		JButton buttonSqrt = new JButton("SQRT");
		buttonSqrt.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double number = Double.parseDouble(label.getText());
				if(number <= Double.MAX_VALUE && number >= Double.MIN_VALUE) {
					try {
						result = (double) Math.sqrt(number);
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					label.setText(String.valueOf(result));
				}
			}
		});panelKey.add(buttonSqrt);

		/*-------------------------------------------------*/
		
	}
}
