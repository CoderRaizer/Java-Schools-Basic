package bai3;

import java.util.Scanner;


public class DSHocSinh {
	
	private Nguoi[] list_hoso;
	private int quantity;
	
	
	Scanner o = new Scanner(System.in);
	public DSHocSinh() {
		this.list_hoso = new Nguoi[setQuantity()];
	}
	
	private int setQuantity() {
		System.out.print("Nhập Số Lượng Sinh Viên Cần Lưu Trữ Hồ Sơ : ");
		this.quantity = o.nextInt();
		return this.quantity;
	}
	
	
	public void themHoSoSinhVien() {
		for(int i = 0 ; i < this.quantity ; i++) {
			Nguoi person = new Nguoi();
			person.nhapThongTin();
			this.list_hoso[i] = person;
		}
	}
	
	
	public void hienThiDanhSachHoSo() {
		for(int i = 0 ; i < this.quantity; i++) {
			this.list_hoso[i].hienThiThongTin();
		}
	}
	
	
	public void soLuongHocSinh_2k_ThaiNguyen() {
		int sum = 0;
		for(int i = 0 ; i < this.quantity ; i++) {
			if(this.list_hoso[i].getQuequan().equalsIgnoreCase("Thai Nguyen") && this.list_hoso[i].getNamsinh() == 2000) {
				sum++;
			}
		}
		System.out.println("Số học sinh quê ở Thái Nguyên Và Sinh năm 2000 là: "+sum);
	}

}
