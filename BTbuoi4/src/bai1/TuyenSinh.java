package bai1;

import java.util.Scanner;

public class TuyenSinh {
	Scanner o = new Scanner(System.in);

	private int quantity;
	private ThiSinh[] list_ThiSinh;

	public TuyenSinh() {
		this.list_ThiSinh = new ThiSinh[setQuantity()];
	}

	private int setQuantity() {
		System.out.print("Nhập Số Lượng Lưu Trữ Thí Sinh: ");
		this.quantity = o.nextInt();
		return this.quantity;
	}

	/*---------------------------------------------------*/

	public boolean kiemTraSoBaoDanh(String sbd) {
		for (int i = 0; i < this.quantity; i++) {
			if (this.list_ThiSinh[i].getSbd().equalsIgnoreCase(sbd))
				return true;
		}
		return false;
	}
	
	public boolean checkBlockValid(String typeBlock) {
		if(!typeBlock.equalsIgnoreCase("A") && !typeBlock.equalsIgnoreCase("B") && !typeBlock.equalsIgnoreCase("C")) {
			return false;
		} else return true;
	}

	public void nhapThiSinh() {
		System.out.println("-------------------ADD THI SINH---------------------");
		
		for(int i = 0 ; i < this.quantity ; i++) {
			String typeBlock = "";
			do {
				System.out.print("Nhập Khối của thí sinh : ");
				o = new Scanner(System.in);
				typeBlock = o.nextLine();
				if(!checkBlockValid(typeBlock)) {
					System.out.println("Nhập khối không hợp lệ");
				}
			}while(!checkBlockValid(typeBlock));
			
			boolean dupli = false;
			if (typeBlock.equalsIgnoreCase("A")) {
				ThiSinhKhoiA newts = new ThiSinhKhoiA();
				do {
					newts.nhapThongTinThiSinh();
					if (kiemTraSoBaoDanh(newts.getSbd()) == true) {
						System.out.println("Số Báo Danh Bị Trùng");
						dupli = false;
					} else {
						dupli = true;
					}
				} while (dupli == false);

				this.list_ThiSinh[i] = newts;

				System.out.println("------------THÊM THÍ SINH KHỐI " + typeBlock + " THANH CONG------------");

			} else if (typeBlock.equalsIgnoreCase("B")) {
				ThiSinhKhoiB newts = new ThiSinhKhoiB();
				do {
					newts.nhapThongTinThiSinh();
					if (kiemTraSoBaoDanh(newts.getSbd()) == true) {
						System.out.println("Số Báo Danh Bị Trùng");
						dupli = false;
					} else {
						dupli = true;
					}
				} while (dupli == false);
				this.list_ThiSinh[i] = newts;
				System.out.println("------------THÊM THÍ SINH KHỐI " + typeBlock + " THANH CONG------------");

			} else if (typeBlock.equalsIgnoreCase("C")) {
				ThiSinhKhoiC newts = new ThiSinhKhoiC();
				do {
					newts.nhapThongTinThiSinh();
					if (kiemTraSoBaoDanh(newts.getSbd()) == true) {
						System.out.println("Số Báo Danh Bị Trùng");
						dupli = false;
					} else {
						dupli = true;
					}
				} while (dupli == false);

				this.list_ThiSinh[i] = newts;
				System.out.println("------------THÊM THÍ SINH KHỐI " + typeBlock + " THANH CONG------------");
			}
		}
	}

	
	/*--------------------------------------------------------------------------------------------*/
	public void hienThiDanhSachThiSinh() {
		System.out.println(
				"------------------------------------------------------------------------------------------------");
		System.out.println(
				"HỌ VÀ TÊN          SBD         ĐỊA CHỈ        ĐIỂM ƯU TIÊN        ĐIỂM                          ");
		System.out.println(
				"------------------------------------------------------------------------------------------------");
		for (int i = 0; i < this.quantity; i++) {
			this.list_ThiSinh[i].ShowMe();
			System.out.println(
					"------------------------------------------------------------------------------------------------");
		}
	}
	/*--------------------------------------------------------------------------------------------*/

	
	/*--------------------------------------------------------------------------------------------*/
	public void timKiemThiSinhTheoSoBaoDanh(String sbdSearch) {
		boolean exist = false;
		int i = 0;
		while (i < this.quantity && exist == false) {
			if (this.list_ThiSinh[i].getSbd().equalsIgnoreCase(sbdSearch)) {
				System.out.println(
						"------------------------------------------------------------------------------------------------");
				System.out.println(
						"HỌ VÀ TÊN          SBD         ĐỊA CHỈ        ĐIỂM ƯU TIÊN        ĐIỂM                          ");
				System.out.println(
						"------------------------------------------------------------------------------------------------");
				this.list_ThiSinh[i].ShowMe();
				exist = true;
			}
			i++;
		}
		if (exist == false) {
			System.out.println("Không Tồn Tại Thí Sinh Này");
		}
	}
	/*--------------------------------------------------------------------------------------------*/

	
	public void timKiemThiSinhTheoKhoiThi(String blockType) {
		if (this.quantity > 0) {
			System.out.println(
					"------------------------------------------------------------------------------------------------");
			System.out.println(
					"HỌ VÀ TÊN          SBD         ĐỊA CHỈ        ĐIỂM ƯU TIÊN        ĐIỂM                          ");
			System.out.println(
					"------------------------------------------------------------------------------------------------");
			for (int i = 0; i < this.quantity; i++) {
				if (this.list_ThiSinh[i].getKhoi().equalsIgnoreCase(blockType)) {
					this.list_ThiSinh[i].ShowMe();
				}
			}
		} else {
			System.out.println("Chưa có thí sinh nào được thêm vào danh sách");
		}
	}

	
	public boolean ConfirmSortAlready() {
		for (int i = 0; i < this.quantity - 1; i++) {
			for (int j = i + 1; j < this.quantity; j++) {
				if (this.list_ThiSinh[j].getSbd().compareTo(this.list_ThiSinh[i].getSbd()) < 0) {
					return false;
				}
			}
		}
		return true;
	}

	
	public void sapXepDanhSachThiSinhTangDanTheoSoBaoDanh() {
		if (ConfirmSortAlready() == true) {
			System.out.println("--------Danh Sách Đã Được Sắp Xếp Rồi-------");
			hienThiDanhSachThiSinh();
		} else {
			int min;
			for (int i = 0; i < this.quantity - 1; i++) {
				min = i;
				for (int j = i + 1; j < this.quantity; j++) {
					if (this.list_ThiSinh[j].getSbd().compareTo(this.list_ThiSinh[min].getSbd()) < 0) {
						min = j;
					}
				}

				ThiSinh temp = new ThiSinh();
				temp = this.list_ThiSinh[min];
				this.list_ThiSinh[min] = this.list_ThiSinh[i];
				this.list_ThiSinh[i] = temp;
			}
			System.out.println("-------------------------DANH SÁCH SAU KHI SẮP XẾP--------------------------");

			hienThiDanhSachThiSinh();
		}
	}

	
	public void TongSoThiSinhTheoKhoi(String blockType) {
		int sum = 0;
		for (int i = 0; i < this.quantity; i++) {
			if (this.list_ThiSinh[i].getKhoi().equalsIgnoreCase(blockType)) {
				sum++;
			}
		}
		System.out.println("Tổng Số Thí Sinh Của Khối " + blockType + " Là: " + sum);
	}

}
