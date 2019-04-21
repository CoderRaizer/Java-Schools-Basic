package mypackage;

/*---MEBER---*/
// Võ Duy Khánh : N16DCCN076
// Nguyễn Đông Nhật : N16DCCN111
// Phạm Văn Minh : N16DCCN094
// Tô Anh Tuấn : N15DCCN194

/*--------*/

import java.util.Scanner;

public class MainTest {

	static int giaithua(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	static int max(int x, int y) {
		if (x > y)
			return x;
		else
			return y;
	}

	static int min(int x, int y) {
		if (x < y)
			return x;
		else
			return y;
	}

	static public void show(boolean flag, int number) {
		if (flag == true) {
			System.out.println(number);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner o = new Scanner(System.in);

		/*--- Bài 1: Viết chương trình tính tổng các số chẵn nằm trong khoảng 1 đến 100 ---*/
		// int Sum = 0;
		// for(int i = 1; i <= 100 ; i++) {
		// Sum += i;
		// }
		// System.out.println("Sum = " +Sum);

		/*--- Bài 2: Viết chương trình hiển thị tổng các bội số của 7 nằm giữa 1 và 100 ---*/
		// int x = 7;
		// for(int i = 1; i < 100; i++) {
		// if(i % 7 == 0) {
		// System.out.println(i);
		// }
		// }

		/*--- Bài 3: Viết chương trình tìm giai thừa của n (n>0), n nhập từ bàn phím ---*/
		// int n;
		// do {
		// System.out.println("Nhap n: ");n = o.nextInt();
		// }while(n < 0);
		// System.out.println("Giai thua cua "+n +" la: " + giaithua(n));

		/*--- Bài 4: Viết chương trình tìm bội số chung nhỏ nhất của m và n (m, n>0), m và n được nhập từ bàn phím---*/
//		int m1;
//		int n1;
//		do {
//			System.out.println("Nhap m: ");
//			m1 = o.nextInt();
//			System.out.println("Nhap n: ");
//			n1 = o.nextInt();
//		} while (m1 == 0 || n1 == 0);
//
//		if (m1 % n1 == 0) {
//			System.out.println("BCNN : " + m1);
//		} else if (n1 % m1 == 0) {
//			System.out.println("BCNN: " + n1);
//		} else {
//			for (int i = max(m1, n1); i > 1; i++) {
//				if (i % n1 == 0 && i % m1 == 0) {
//					System.out.println("BCCN : " + i);
//					break;
//				}
//			}
//		}

		/*--- Bài 5: Viết chương trình tìm ước số chung lớn nhất của m và n (m, n>0), m và n được nhập từ bàn phím ---*/
//		int m2;
//		int n2;
//		do {
//			System.out.println("Nhap m: ");
//			m2 = o.nextInt();
//			System.out.println("Nhap n: ");
//			n2 = o.nextInt();
//		} while (m2 == 0 || n2 == 0);
//
//		if (m2 % n2 == 0) {
//			System.out.println("UCLN : " + n2);
//		} else if (n2 % m2 == 0) {
//			System.out.println("UCLN : " + m2);
//		} else {
//			for (int i = min(m2, n2); i >= 1; i--) {
//				if (n2 % i == 0 && m2 % i == 0) {
//					System.out.println("UCLN : " + i);
//					break;
//				}
//			}
//		}

		/*--- Bài 6: Viết chương trình in ra số chẵn từ 2 tới 10 bằng cách dùng
		- Một vòng lặp for và một câu lệnh continue
		- Một vòng lặp while và một biến làm cờ hiệu (variable as a flag).
		---*/

		// Use for loop:

		// for(int i = 2 ; i <= 10 ; i++) {
		// if(i%2 != 0) {
		// continue;
		// }System.out.println(i);
		// }

		// Use While loop:

		// int start = 2;
		// boolean flag;
		// while (start <= 10) {
		// if (start % 2 == 0) {
		// flag = true;
		// } else {
		// flag = false;
		// }
		// show(flag, start);
		// start++;
		// }

	}
}
