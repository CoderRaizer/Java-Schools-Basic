package quanlyxaukytu;

import java.util.Scanner;

public class Main {

	public static void Menu() {
		Scanner o = new Scanner(System.in);
		XauKyTu x = new XauKyTu();
		boolean flag = false;
		int choice;
		while (true) {
			System.out.println("1. Nhập Chuỗi (Làm Đầu Tiên) ");
			System.out.println("2. Đếm Số Lần Xuất Hiện Của 1 Ký Tự Trong Chuỗi ");
			System.out.println("3. Chuẩn Hóa Chuỗi");
			System.out.println("4. Đếm Số Từ Của Xâu");
			System.out.println("5. Đếm Số từ bắt đầu bằng H");
			System.out.println("6. Chuyển Các Ký Tự Đầu Tiên Của Mỗi Từ Thành Hoa");
			System.out.println("7. Tìm Từ Có Độ Dài Lớn Nhất, In ra từ đó và độ dài tương ứng");

			System.out.println("Nhập lựa chọn: ");
			choice = o.nextInt();

			switch (choice) {
			case 1: {
				x.Input();
				flag = true;
				break;
			}
			case 2: {
				if (flag == true) {
					x.CountQuantityCharacterInString();
				} else {
					System.out.println("Bạn Cần Nhập Chuỗi Trước");
				}
				break;
			}
			case 3: {
				if (flag == true) {
					x.StandardizeString();
				} else {
					System.out.println("Bạn Cần Nhập Chuỗi Trước");
				}
				break;
			}
			case 4: {
				if (flag == true) {
					x.CountQuantityWordInString();
				} else {
					System.out.println("Bạn Cần Nhập Chuỗi Trước");
				}
				break;
			}
			case 5: {
				if (flag == true) {
					x.CountNumberOfWordStartingWith_H();
				} else {
					System.out.println("Bạn Cần Nhập Chuỗi Trước");
				}
				break;
			}
			case 6: {
				if (flag == true) {
					x.ChangeFirstCharacterToCase();
				} else {
					System.out.println("Bạn Cần Nhập Chuỗi Trước");
				}
				break;
			}
			case 7: {
				if (flag == true) {
					x.FindWordMaxLength();
				} else {
					System.out.println("Bạn Cần Nhập Chuỗi Trước");
				}
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
