package bai1;

import java.util.Scanner;

public class DemSoKyTu_Exception {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		boolean beSuccess = false;
		int number = 0;
		do {
			try {
				System.out.println("Nhap ky tu so: ");
				number = Integer.parseInt(input.next());
				// Convert số , nếu thành công thì thoát khỏi vòng do - while
				beSuccess = true;
			} catch (NumberFormatException e) {
				System.out.println("Bạn đã nhập sai định dạng - chỉ được nhập ký tự số");
				input.reset();
			}
		} while (beSuccess == false);
		int sokyso = 0;
		while (number > 0) {
			sokyso++;
			number /= 10;
		}
		System.out.println("Số bạn nhập có " + sokyso + " ký tự số");
	}
}
