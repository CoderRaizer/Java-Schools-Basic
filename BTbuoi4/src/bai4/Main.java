package bai4;

import java.util.Scanner;

import bai1.MyException;


public class Main {

	
	public static void Menu() {
		Scanner o = new Scanner(System.in);
		DSBienLai control = new DSBienLai();
		int select;
		while (true) {
			System.out.println("---------------------------------------");
			System.out.println("             Nhập Thông Tin            ");
			System.out.println("---------------------------------------");
			System.out.println("1.> Nhập thông tin biên lai cho các hộ sử dụng.");
			System.out.println("2.> Hiển thị thông tin các biên lai đã nhập");
			System.out.println("3.> Chi tiêu tiền điện mà mỗi hộ gia đình phải trả");
			System.out.print("Nhập Lựa Chọn: ");
			select = o.nextInt();

			switch (select) {
			case 1: {
				control.themThongTinBienLai();
				break;
			}
			case 2: {
				control.hienThiDanhSachBienLai();
				break;
			}
			case 3:{
				control.hienThiChiTieuPhaiTraCuaTungHo();
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
