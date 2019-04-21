package bai2;

import java.util.Scanner;

import bai1.MyException;

public class Main {
	public static void Menu() {
		Scanner o = new Scanner(System.in);
		KhuPho control = new KhuPho();
		int select;
		while (true) {
			System.out.println("---------------------------------------");
			System.out.println("             Nhập Thông Tin            ");
			System.out.println("---------------------------------------");
			System.out.println("1.> Thêm Hộ Dân");
			System.out.println("2.> Hiển Thị Thông Tin Hộ Dân");

			System.out.print("Nhập Lựa Chọn: ");
			select = o.nextInt();

			switch (select) {
			case 1: {
				control.themHoDan();
				break;
			}

			case 2: {
				control.hienThiDanhSachHoDanChiTiet();
				break;
			}

			default:
				break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
