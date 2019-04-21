package mypackage;

import java.util.Scanner;

public class DSSinhVien {

	Scanner o = new Scanner(System.in);

	private int quantity;
	private SinhVien[] list_sv;

	public DSSinhVien() {
		this.list_sv = new SinhVien[SetQuantity()];
	}

	public int SetQuantity() {
		System.out.print("Nhap So Luong Luu Tru Sinh Vien: ");
		this.quantity = o.nextInt();
		return this.quantity;
	}

	public boolean CheckDumplicationCode(String mssv) {
		for (int i = 0; i < this.quantity; i++) {
			if (this.list_sv[i].getMssv().equalsIgnoreCase(mssv))
				return true;
		}
		return false;
	}


	/*------------------------ADD STUDENT-------------------------*/

	public int TotalStudentByRank(String nameRank) {
		int result = 0;
		for (int i = 0; i < this.quantity; i++) {
			if (this.list_sv[i].getXeploai().equalsIgnoreCase(nameRank)) {
				result += 1;
			}
		}
		return result;
	}
	/*------------------------SUM HOC LUC-------------------------*/

	/*------------------------SHOW DSSV-------------------------*/
	public void ShowDSSV() {
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		System.out.println(
				"HỌ VÀ TÊN          MSSV        ĐIỂM C++        ĐIỂM HĐH        ĐIỂM ANM        ĐIỂM TB        XẾP LOẠI ");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < this.quantity; i++) {
			this.list_sv[i].ShowInfoStudent();
			System.out.println(
					"--------------------------------------------------------------------------------------------------------");
		}
		System.out.println("Tong So Sinh Vien Xep Loai Gioi: " + TotalStudentByRank("GIOI"));
		System.out.println("Tong So Sinh Vien Xep Loai Kha: " + TotalStudentByRank("KHA"));
		System.out.println("Tong So Sinh Vien Xep Loai Trung Binh: " + TotalStudentByRank("TRUNG BINH"));
		System.out.println("Tong So Sinh Vien Khong Dat: " + TotalStudentByRank("KHONG DAT"));
		System.out.println("---------------END SHOW----------------");
		System.out.println("\n\n");

	}
	/*------------------------SHOW DSSV-------------------------*/

	/*------------------------SORT LIST-------------------------*/

	public boolean ConfirmSortAlready() {// Trả về true nếu như DS đã được sắp xếp tăng dần theo mã số sinh viên
		for (int i = 0; i < this.quantity - 1; i++) {
			for (int j = i + 1; j < this.quantity; j++) {
				if (this.list_sv[j].getMssv().compareTo(this.list_sv[i].getMssv()) < 0) {// Phần tử sau có mã nhỏ hơn
																							// phần tử trước
					return false;
				}
			}
		}
		return true;
	}

	public void SelectionSort() {
		if (ConfirmSortAlready() == true) {
			System.out.println("--------Danh Sách Đã Được Sắp Xếp Rồi-------");
			ShowDSSV();
		} else {
			int min;
			for (int i = 0; i < this.quantity - 1; i++) {
				min = i;
				for (int j = i + 1; j < this.quantity; j++) {
					if (this.list_sv[j].getMssv().compareTo(this.list_sv[min].getMssv()) < 0) {// so sánh mã phía sau là nhỏ hơn phía trước
						min = j;// gán vị trí min mới là j
					}
				}
				SinhVien temp = new SinhVien();
				temp = this.list_sv[min];
				this.list_sv[min] = this.list_sv[i];
				this.list_sv[i] = temp;
			}
			System.out.println("-------------------------DANH SÁCH SAU KHI SẮP XẾP--------------------------");
			ShowDSSV();
		}
	}

	/*------------------------SORT LIST-------------------------*/

	/*--------------------------SEARCH--------------------------*/
	public void SearchStudentByName(String search) {
		boolean existvalue = false;
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		System.out.println(
				"HỌ VÀ TÊN          MSSV        ĐIỂM C++        ĐIỂM HĐH        ĐIỂM ANM        ĐIỂM TB        XẾP LOẠI ");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < this.quantity; i++) {
			if (this.list_sv[i].getHoten().equalsIgnoreCase(search)) {
				existvalue = true;
				this.list_sv[i].ShowInfoStudent();
				System.out.println(
						"--------------------------------------------------------------------------------------------------------");
			}
		}
		if (existvalue == false) {
			System.out.println("---SEARCH OF YOU IS EMPTY IN LIST---\n\n\n");
		}
	}
	/*------------------------SORT LIST-------------------------*/

	/*------------------------QUANTITY GET HIGHT OR EQUAL MARKSCORE-------------------------*/
	public void ShowList_ScoresHigherOrEqual(double markScores) {
		int numget = 0;
		for (int i = 0; i < this.quantity; i++) {
			if (this.list_sv[i].getDiem_TB() >= markScores) {
				numget++;
			}
		}
		if (numget == 0) {
			System.out.println("Không Có Sinh Viên Nào Đạt Điểm TB Cao Hơn Hoặc Bằng " + markScores);
		} else {
			System.out.println("Có " + numget + " Sinh Viên Đạt điểm lớn hơn hoặc bằng " + markScores);
		}

	}
	/*------------------------QUANTITY GET HIGHT OR EQUAL MARKSCORE-------------------------*/

	/*------------------------GET LIST STUDENT GET THE BEST HIGHT SCORES-------------------------*/
	public void ShowStudentGetBestHightScore() {
		double maxScore = this.list_sv[0].getDiem_TB();
		for (int i = 0; i < this.quantity; i++) {
			if (this.list_sv[i].getDiem_TB() >= maxScore) {
				maxScore = this.list_sv[i].getDiem_TB();
			}
		}

		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		System.out.println(
				"HỌ VÀ TÊN          MSSV        ĐIỂM C++        ĐIỂM HĐH        ĐIỂM ANM        ĐIỂM TB        XẾP LOẠI ");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < this.quantity; i++) {
			if (this.list_sv[i].getDiem_TB() == maxScore) {
				this.list_sv[i].ShowInfoStudent();
				System.out.println(
						"--------------------------------------------------------------------------------------------------------");
			}
		}
	}
	/*------------------------GET LIST STUDENT GET THE BEST HIGHT SCORES-------------------------*/

}
