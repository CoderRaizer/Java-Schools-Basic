package bai2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner o = new Scanner(System.in);
		DanhSachNhanVien control = new DanhSachNhanVien();
		int select;
		while (true) {
			System.out.println("1. Nhập Danh Sách Nhân Viên");
			System.out.println("2. Xuất Danh Sách Danh Viên");
			System.out.println("3. Chọn Các Chế Độ Sắp Xếp: ");
			System.out.println("Nhập Lựa Chọn: ");
			select = o.nextInt();

			switch (select) {
			case 1: {
				control.nhapDanhSachNhanVien();
				break;
			}

			case 2: {
				control.xuatDanhSachNhanVien();
				break;
			}

			case 3: {
				int choice = -1;
				do {
					System.out.println("1. Sắp Xếp Theo Tên (Nếu Trùng Tên Thì Sắp Xếp Theo H�? Tên Lót)");
					System.out.println("2. Sắp Xếp Giảm Dần Theo Mức Lương");
					System.out.println("3. Sắp Xếp Tăng Dần Theo Ngày Sinh");
					System.out.println("0. Exit");
					System.out.print("Nhập lựa ch�?n: ");
					choice = o.nextInt();

					switch (choice) {
					case 1: {
						control.sapXepTheoTenNhanVien();
						break;
					}

					case 2: {
						control.sapXepTheoMucLuongNhanVien();
						break;
					}
					case 3: {
						control.sapXepTheoNgaySinh();
						break;
					}

					default:
						break;

					}
				} while (choice != 0);
				break;
			}
			}

		}

	}

}
