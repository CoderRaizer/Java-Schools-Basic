package bai4;

import java.util.Scanner;

public class DSBienLai {
	
	private BienLai[]list_bienlai;
	private int quantity;
	
	public DSBienLai() {
		this.list_bienlai = new BienLai[setQuantity()];
	}
	
	private int setQuantity() {
		Scanner o = new Scanner(System.in);
		System.out.print("Nhập Số Lượng Biên Lai Cua Cac Ho Gia Dinh : ");
		this.quantity = o.nextInt();
		return this.quantity;
	}
	
	public void themThongTinBienLai() {
		for(int i = 0 ; i < this.quantity ; i++) {
			BienLai a = new BienLai();
			a.nhapThongTin();
			this.list_bienlai[i] = a;
		}
	}
	
	
	public void hienThiDanhSachBienLai() {
		System.out.println("------------------------------------------------------------------");
		System.out.println("HỌ TÊN CHỦ HỘ      SỐ NHÀ    MÃ SỐ CÔNG TƠ     SỐ CŨ     SỐ MỚI   ");
		System.out.println("------------------------------------------------------------------");
		for(int i = 0; i < this.quantity; i++) {
			this.list_bienlai[i].xuatThongTin();
			System.out.println("------------------------------------------------------------------");
		}
	}
	
	public void hienThiChiTieuPhaiTraCuaTungHo() {
		System.out.println("------------------------------------------");
		System.out.println("HỌ TÊN CHỦ HỘ             SỐ TIỀN PHẢI TRẢ");
		System.out.println("------------------------------------------");
		for(int i = 0 ; i < this.quantity ; i++) {
			System.out.print(this.list_bienlai[i].hoten);
			for(int j = 0 ; j < (26 - this.list_bienlai[i].getHoten().length());j++) {
				System.out.print(" ");
			}
			this.list_bienlai[i].tinhTienDien();
		}
	}
	
}
