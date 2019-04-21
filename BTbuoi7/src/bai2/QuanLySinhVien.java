package bai2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class QuanLySinhVien {

	private static final String FILENAME = "D://Student_File1.txt";

	ArrayList<SinhVien> list_sv;
	File f;

	public QuanLySinhVien() {
		list_sv = new ArrayList<>();
		f = new File(FILENAME);

	}
	
	public boolean ExistFile() {
		if (f.exists()) {
			JOptionPane.showMessageDialog(null, "FILE CÓ DỮ LIỆU - SHOW DANH SÁCH SINH VIÊN");
			readListStudent();
			xuatDanhSachSinhVien();
			return true;
		} else return false;
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

	public void xuatDanhSachSinhVien() {
		for (SinhVien sv : list_sv) {
			System.out.println(sv);
		}
	}

	@SuppressWarnings("unchecked")
	public void readListStudent() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));
			list_sv = (ArrayList<SinhVien>) ois.readObject();
			ois.close();
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

}
