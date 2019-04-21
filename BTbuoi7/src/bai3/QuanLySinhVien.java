package bai3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class QuanLySinhVien {

	private static final String FILENAME = "D://Student_File2.txt";
	
	ArrayList<SinhVien> list_sv;
	File f;

	public QuanLySinhVien() {
		list_sv = new ArrayList<>();
		f = new File(FILENAME);
	}
	
	
	public boolean ExistFile() {
		if (f.exists()) {
			return true;
		} else return false;
	}

	@SuppressWarnings("unchecked")
	public void readListStudent() {
		try {
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream(FILENAME));
			list_sv = (ArrayList<SinhVien>) oos.readObject();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void writeListStudent() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME));
			oos.writeObject(list_sv);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void themSinhVien() {
		Scanner o = new Scanner(System.in);
		System.out.print("Nhập Họ Tên: ");
		String hoten = o.nextLine();
		o = new Scanner(System.in);
		System.out.print("Nhập Ngày Sinh: ");
		String ngaysinh = o.nextLine();
		o = new Scanner(System.in);
		System.out.print("Nhập Điểm TB: ");
		double diemtrungbinh = o.nextDouble();
		list_sv.add(new SinhVien(hoten, ngaysinh, diemtrungbinh));

	}

	public boolean checkDataInFile() {
		FileInputStream fis;
		boolean checkHaveData = true;
		try {
			fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			if (ois.readObject() == null) {
				checkHaveData = false;
			}
			ois.close();
		} catch (FileNotFoundException e) {
			checkHaveData = false;
		} catch (IOException e) {
			checkHaveData = false;
		} catch (ClassNotFoundException e) {
			checkHaveData = false;
			e.printStackTrace();
		}
		return checkHaveData;
	}

	public void copyFileToAnotherPlace(File fileNew) throws IOException {
		InputStream inStream = null;
		OutputStream outStream = null;
		try {
			inStream = new FileInputStream(f);
			outStream = new FileOutputStream(fileNew);

			int lenght;
			byte[] buffer = new byte[1024];
			// copy noi dung file kieu byte
			while ((lenght = inStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, lenght);
			}
			System.out.println("---Copy file thành công---");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			inStream.close();
			outStream.close();
		}
	}

	public void xuatDanhSachSinhVien() {
		for (SinhVien sv : list_sv) {
			System.out.println(sv);
		}
	}

}
