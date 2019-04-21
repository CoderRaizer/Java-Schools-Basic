package quanlysinhvien;

import java.util.Scanner;

import quanlyxaukytu.MyException;

public class MainGUI {

	public static void Menu() {
		Scanner o = new Scanner(System.in);
		DSSinhVien control = new DSSinhVien();
		int select;
		while (true) {
			System.out.println("1. Thêm Sinh Viên.");
			System.out.println("2. In DSSV.");
			System.out.println("3. Sắp xếp DSSV tăng dần theo MSSV.");
			System.out.println("4. Tìm kiếm Sinh Viên theo họ tên(không phân biệt hoa thường).");
			System.out.println("5. Số lượng sinh viên có điểm trung bình lớn hơn hoặc bằng điểm X.");
			System.out.println("6. Hiển thị thông tin chi tiết của các SV có điểm TB cao nhất (Các sinh viên cùng điểm TB cao nhất vẫn được in ra).");
			System.out.print("Nhập Lựa Chọn: ");
			select = o.nextInt();

			switch (select) {
			case 1: {
				control.AddStudent();
				break;
			}
			case 2: {
				control.ShowDSSV();
				break;
			}

			case 3: {
				control.SelectionSort();
				break;
			}

			case 4: {
				String search;
				System.out.println("Nhập Tên Sinh Viên Cần Tìm Kiếm: ");
				o = new Scanner(System.in);
				search = o.nextLine();
				control.SearchStudentByName(search);
				break;
			}

			case 5: {
				double markScores;
				do {
					System.out.println("Nhập điểm cần Truy Vấn: ");
					markScores = o.nextDouble();
				} while (markScores < 0 || markScores > 10);
				control.ShowList_ScoresHigherOrEqual(markScores);
				break;
			}

			case 6: {
				control.ShowStudentGetBestHightScore();
				break;
			}

			default:
				break;
			}
		}
	}
	
	
	public static void main(String[] args) {
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
