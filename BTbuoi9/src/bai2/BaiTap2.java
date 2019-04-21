package bai2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BaiTap2 extends JFrame {

	private JPanel contentPane;
	
	JTextArea txtContent = new JTextArea();
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaiTap2 frame = new BaiTap2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void SaveFile() {
		try {
			PrintWriter out = new PrintWriter(new FileWriter("D:\\TestFile.txt"));
			txtContent.write(out);
		}catch(IOException e1) {
			System.err.println("Error occurred");
	        e1.printStackTrace();
		}
	}
	
	
	public BaiTap2() {
		/*------------------------------------------*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar myBar = new JMenuBar();
		myBar.setBackground(Color.WHITE);
		myBar.setBounds(0, 0, 509, 21);
		contentPane.add(myBar);
		
		/*------------------------------------------*/
		JMenu itemFile = new JMenu("File");
		JMenu itemEdit = new JMenu("Edit");
		JMenu itemFormat = new JMenu("Format");
		JMenu itemView = new JMenu("View");
		JMenu itemHelp = new JMenu("Help");
		myBar.add(itemFile);
		myBar.add(itemEdit);
		myBar.add(itemFormat);
		myBar.add(itemView);
		myBar.add(itemHelp);
		/*------------------------------------------*/
		
		
		itemFile.add(new JSeparator());
		JMenuItem NewFile = new JMenuItem("New                  Ctrl+N");
		JMenuItem OpenFile = new JMenuItem("Open               Ctrl+O");
		OpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			}
		});
		JMenuItem SaveFile = new JMenuItem("Save                 Ctrl+S");
		SaveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SaveFile();
			}
		});
		JMenuItem SaveAsFile = new JMenuItem("Save as");
		JMenuItem PageSetup = new JMenuItem("Page Setup...");
		JMenuItem Print = new JMenuItem("Print                 Ctrl+P");
		JMenuItem Exit = new JMenuItem("Exit");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		itemFile.add(NewFile);
		itemFile.add(OpenFile);
		itemFile.add(SaveFile);
		itemFile.add(SaveAsFile);
		itemFile.add(new JSeparator());
		itemFile.add(PageSetup);
		itemFile.add(Print);
		itemFile.add(new JSeparator());
		itemFile.add(Exit);
		/*------------------------------------------*/
		
		txtContent.setBounds(0, 23, 509, 270);
		contentPane.add(txtContent);
		
		
		/*------------------------------------------*/
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(txtContent, popupMenu);
		
		JMenuItem Undo = new JMenuItem("Undo");
		JMenuItem Cut = new JMenuItem("Cut");
		Cut.setEnabled(false);
		JMenuItem Copy = new JMenuItem("Copy");
		Copy.setEnabled(false);
		JMenuItem Paste = new JMenuItem("Paste");
		Paste.setEnabled(false);
		JMenuItem Delete = new JMenuItem("Delete");
		Delete.setEnabled(false);
		JMenuItem SelectedAll = new JMenuItem("Selected All");
		SelectedAll.setEnabled(false);
		JMenuItem RightToLeftReading = new JMenuItem("Right To Left Reading Order");
		JMenuItem ShowUnicode = new JMenuItem("Show Unicode Control Characters");
		JMenuItem InSertUnicode = new JMenuItem("InSert Unicode Control Characters");
		JMenuItem OpenIME = new JMenuItem("OpenIME");
		popupMenu.add(Undo);
		popupMenu.add(Cut);
		popupMenu.add(Copy);
		popupMenu.add(Paste);
		popupMenu.add(Delete);
		popupMenu.addSeparator();
		popupMenu.add(SelectedAll);
		popupMenu.addSeparator();
		popupMenu.add(RightToLeftReading);
		popupMenu.add(ShowUnicode);
		popupMenu.add(InSertUnicode);
		popupMenu.addSeparator();
		popupMenu.add(OpenIME);
		
		JMenuItem reconversion = new JMenuItem("Reconversion");
		reconversion.setEnabled(false);
		popupMenu.add(reconversion);
		
		this.repaint();
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
