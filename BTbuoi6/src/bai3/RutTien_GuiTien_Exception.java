package bai3;

import java.util.Scanner;

public class RutTien_GuiTien_Exception {

	public static void main(String[] args) {
		long sotiengui = 0;
		long sotienrut = 0;
		double sodu = 0;
		Scanner o = new Scanner(System.in);
		int select = -1;

		while (true) {
			System.out.println("1. Gửi Tiền");
			System.out.println("2. Rút Tiền");
			System.out.println("Nhập lựa chọn: ");
			select = o.nextInt();

			switch (select) {

			case 1: {
				System.out.println("Số Dư Tài Khoản: " + sodu);
				boolean flag = true;
				try {
					System.out.print("Nhập số tiền cần gửi ( >= 50000đ ) : ");
					sotiengui = Long.parseLong(o.next());
				} catch (NumberFormatException e) {
					if (e != null) {
						flag = false;
						System.out.println("Định dạng số không đúng");
					}
				}
				if (flag == true) {
					if (sotiengui < 50000) {
						System.out.println("Số tiền gửi không hợp lệ");
					} else {
						sodu += Double.parseDouble(String.valueOf(sotiengui));
					}
				}
				o.reset();
				System.out.println("------------------------------------------");
				System.out.println("Số Dư Tài Khoản: " + sodu);
				System.out.println("------------------------------------------");
				break;
			}

			case 2: {
				System.out.println("Số Dư Tài Khoản: " + sodu);
				boolean flag = true;
				try {
					System.out.print("Nhập số tiền cần rút ( nhỏ hơn hoặc bằng số dư ) : ");
					sotienrut = Long.parseLong(o.next());
				} catch (NumberFormatException e) {
					if (e != null) {
						flag = false;
						System.out.println("Định dạng số không đúng");
					}
				}
				if (flag == true) {
					if (sotienrut > sodu) {
						System.out.println("Số tiền " + sotienrut + " lớn hơn sô dư trong tài khoản");
					} else {
						sodu -= Double.parseDouble(String.valueOf(sotienrut));
					}
				}
				o.reset();
				System.out.println("------------------------------------------");
				System.out.println("Số Dư Tài Khoản: " + sodu);
				System.out.println("------------------------------------------");
				break;
			}

			}

		}

	}

}
