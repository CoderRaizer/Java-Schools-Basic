package bai1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TuDien control = new TuDien();
		Scanner sc = new Scanner(System.in);
		int select;
		while (true) {
			System.out.println("1. Nhập Từ Vào Từ Điển");
			System.out.println("2. Xuất Danh Sách Từ Điển");
			System.out.println("3. Tra Từ");
			System.out.println("4. Tìm Và Sửa Từ Điển Theo Từ");
			System.out.println("5. Tìm Và Xóa Từ Điển Theo Từ");
			System.out.println("6. Sắp Xếp Theo Từ");
			System.out.print("Nhập Lựa Chọn: ");
			select = sc.nextInt();

			switch (select) {
			case 1: {
				control.themTuVaoTuDien();
				break;
			}

			case 2: {
				control.xuatDanhSachTuDien();
				break;
			}

			case 3: {
				control.traTuDien();
				break;
			}

			case 4: {
				control.suaTuTrongTuDien();
				break;
			}

			case 5: {
				control.xoaTuTrongTuDien();
				break;
			}

			case 6: {
				control.sapXepTuTrongTuDien();
				break;
			}
			}
		}
	}

}
