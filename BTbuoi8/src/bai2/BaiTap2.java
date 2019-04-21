package bai2;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class BaiTap2 extends Frame implements ItemListener{


	private static final long serialVersionUID = 1L;
	Checkbox checkboxRed, checkBoxBlue, checkboxGreen, checkboxBlack;
	private JTextField textField;

	ItemListener itemStateChanged;

	public BaiTap2() {
		
		super("Demo");
		textField = new JTextField("Hello");
		this.setLayout(new GridLayout(3, 1));
		
		CheckboxGroup myCheckbox = new CheckboxGroup();
		
		checkboxRed = new Checkbox("RED",myCheckbox, true);
		checkboxRed.addItemListener(this);
		this.add(checkboxRed);
		
		checkBoxBlue = new Checkbox("BLUE",myCheckbox, true);
		checkBoxBlue.addItemListener(this);
		this.add(checkBoxBlue);
		
		checkboxGreen = new Checkbox("GREEN",myCheckbox, true);
		checkboxGreen.addItemListener(this);
		this.add(checkboxGreen);
		
		checkboxBlack = new Checkbox("BLACK",myCheckbox, true);
		checkboxBlack.addItemListener(this);
		this.add(checkboxBlack);
		
		
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaiTap2 frame = new BaiTap2();
					frame.setSize(300,150);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void itemStateChanged(ItemEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getStateChange() == ItemEvent.SELECTED) {
			String item  = (String)evt.getItem();
			
			if(item.equalsIgnoreCase("Red")) {
				checkboxRed.setBackground(Color.RED);
				checkBoxBlue.setBackground(Color.WHITE);
				checkboxGreen.setBackground(Color.WHITE);
				checkboxBlack.setBackground(Color.WHITE);
			} else if (item.equalsIgnoreCase("Blue")) {
				checkboxRed.setBackground(Color.WHITE);
				checkBoxBlue.setBackground(Color.BLUE);
				checkboxGreen.setBackground(Color.WHITE);
				checkboxBlack.setBackground(Color.WHITE);
			} else if(item.equalsIgnoreCase("Green")) {
				checkboxRed.setBackground(Color.WHITE);
				checkBoxBlue.setBackground(Color.WHITE);
				checkboxGreen.setBackground(Color.GREEN);
				checkboxBlack.setBackground(Color.WHITE);
			} else {
				checkboxRed.setBackground(Color.WHITE);
				checkBoxBlue.setBackground(Color.WHITE);
				checkboxGreen.setBackground(Color.WHITE);
				checkboxBlack.setBackground(Color.BLACK);
			}
			
			this.repaint();
		}
	}


}
