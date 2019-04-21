package bai2;

import java.util.Scanner;

public class NhapXuatMang_Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int[] arr;
		arr = new int[5];
		for (int i = 0; i < 5; i++) {
			System.out.print("Nhap: ");
			arr[i] = input.nextInt();
		}

		try {
			for (int i = 0; i < 6; i++) {
				System.out.println(arr[i]);
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Bạn đã truy xuất vượt số phần tử của mảng");
		}

	}

}
