package bai2;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Scanner o = new Scanner(System.in);
		QuanLySinhVien manager = new QuanLySinhVien();

		if (manager.ExistFile() == false) {
			JOptionPane.showMessageDialog(null, "File Chưa Tồn Tại - Thêm Sinh Viên");
			int soluong;
			System.out.println("-----WRITE FILE-----");
			System.out.print("Bạn muốn nhập bao nhiêu sinh viên: ");
			soluong = o.nextInt();
			for (int i = 0; i < soluong; i++) {
				manager.themSinhVien();
			}
			manager.writeListStudent();
			JOptionPane.showMessageDialog(null, "LƯU FILE THÀNH CÔNG");
		}
	}
}
