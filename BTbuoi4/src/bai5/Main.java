package bai5;

import java.util.Scanner;

import bai1.MyException;

public class Main {

	public static void Menu() {
		DSNhanVien control = new DSNhanVien();
		Scanner o = new Scanner(System.in);
		int select;
		while (true) {
			System.out.println("---------------------------------------");
			System.out.println("             Nhập Thông Tin            ");
			System.out.println("---------------------------------------");
			System.out.println("1.> Thêm Danh Sách Nhân Viên");
			System.out.println("2.> Xuất Thông Tin Danh Sách Nhân Viên");
			System.out.print("Nhập Lựa Chọn: ");
			select = o.nextInt();

			switch (select) {
			case 1: {
				control.themDanhSachNhanVien();
				break;
			}
			case 2: {
				control.xuatThongTinNhanVien();
				break;
			}
			default:
				break;
			}
		}
	}

	public static void main(String[] args) {
		while (true) {
			try {
				Menu();
			} catch (Exception ex) {
				MyException e = new MyException();
				e.setError("LỖI NHẬP VÀO");
				System.out.println(e.getError());
			}
		}

	}

}
