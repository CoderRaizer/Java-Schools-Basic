package bai3;

import java.util.Scanner;

import bai1.MyException;

public class Main {

	
	public static void Menu() {
		Scanner o = new Scanner(System.in);
		DSHocSinh control = new DSHocSinh();
		int select;
		while (true) {
			System.out.println("---------------------------------------");
			System.out.println("             Nhập Thông Tin            ");
			System.out.println("---------------------------------------");
			System.out.println("1.> Nhập Danh Sách Học Sinh");
			System.out.println("2.> Hiển Thị Ra Màn Hình Tất Cả Các Học Sinh Sinh Năm 2000");
			System.out.println("3.> Cho Biết Có Bao Nhiêu Học Sinh Sinh Năm 2000 và quê ở Thái Nguyên");

			System.out.print("Nhập Lựa Chọn: ");
			select = o.nextInt();

			switch (select) {
			case 1: {
				control.themHoSoSinhVien();
				break;
			}
			case 2: {
				control.hienThiDanhSachHoSo();
				break;
			}
			case 3:{
				control.soLuongHocSinh_2k_ThaiNguyen();
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
