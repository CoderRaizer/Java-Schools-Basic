package bai1;

import java.util.Scanner;

public class Main {

	public static void Menu() {
		Scanner o = new Scanner(System.in);
		TuyenSinh control = new TuyenSinh();
		int select;
		while (true) {
			System.out.println("---------------------------------------");
			System.out.println(" Nhập Thông Tin Về Các Thí Sinh Dự Thi ");
			System.out.println("---------------------------------------");
			System.out.println("1.> Nhập Thí Sinh");
			System.out.println("2.> Hiển Thị Thông Tin Danh Sách Một Thí Sinh");
			System.out.println("3.> Tìm Kiếm Thí Sinh Theo Số Báo Danh");
			System.out.println("4.> Tìm Kiếm Thí Sinh Theo Khối Thi");
			System.out.println("5.> Sắp Xếp Danh Sách Thí Sinh Tăng Theo Số Báo Danh");
			System.out.println("6.> Tổng Số Sinh Viên Thi Theo Khối");
			System.out.println("7.> Thoát Chương Trình");
			System.out.print("Nhập Lựa Chọn: ");
			select = o.nextInt();

			switch (select) {
			case 1: {
				control.nhapThiSinh();
				break;
			}

			case 2: {
				control.hienThiDanhSachThiSinh();
				break;
			}

			case 3: {
				String sbdSearch;
				System.out.println("Nhập số báo danh cần tìm kiếm : ");
				o = new Scanner(System.in);
				sbdSearch = o.nextLine();
				control.timKiemThiSinhTheoSoBaoDanh(sbdSearch);
				break;
			}

			case 4: {
				String blocktype;
				System.out.println("Nhập khối thi cần tìm kiếm (A B C): ");
				o = new Scanner(System.in);
				blocktype = o.nextLine();
				control.timKiemThiSinhTheoKhoiThi(blocktype);
				break;
			}

			case 5: {
				control.sapXepDanhSachThiSinhTangDanTheoSoBaoDanh();
				break;
			}

			case 6: {
				String blockType;
				System.out.println("Nhập khối thi (A B C): ");
				o = new Scanner(System.in);
				blockType = o.nextLine();
				control.TongSoThiSinhTheoKhoi(blockType);
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
