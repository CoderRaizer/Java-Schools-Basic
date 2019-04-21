package bai2;

import java.util.Scanner;

public class HoDan {
	private int sothanhvien;
	private String sonha;
	private Nguoi[] list_thanhvien;

	Scanner o = new Scanner(System.in);

	public HoDan() {
	}

	public HoDan(int sothanhvien, String sonha, Nguoi[] list_thanhvien) {
		this.sothanhvien = sothanhvien;
		this.sonha = sonha;
		this.list_thanhvien = list_thanhvien;
	}

	public int getSothanhvien() {
		return sothanhvien;
	}

	public void setSothanhvien(int sothanhvien) {
		this.sothanhvien = sothanhvien;
	}

	public String getSonha() {
		return sonha;
	}

	public void setSonha(String sonha) {
		this.sonha = sonha;
	}

	public Nguoi[] getList_thanhvien() {
		return list_thanhvien;
	}

	public void setList_thanhvien(Nguoi[] list_thanhvien) {
		this.list_thanhvien = list_thanhvien;
	}

	public void setList_thanhvienmoi(Nguoi a, int i) {
		this.list_thanhvien[i] = a;
	}

	public void nhapThongTinHoDan() {
		System.out.print("Nhập số thành viên: ");
		this.sothanhvien = o.nextInt();
		o = new Scanner(System.in);
		System.out.print("Nhập số nhà: ");
		this.sonha = o.nextLine();
		o = new Scanner(System.in);
		this.list_thanhvien = new Nguoi[this.sothanhvien];
		for (int i = 0; i < this.sothanhvien; i++) {
			System.out.println("Nhập thành viên thứ " + (i + 1) + ": ");
			Nguoi b = new Nguoi();
			b.NhapThongTinCaNhan();
			this.list_thanhvien[i] = b;
		}
	}
	
	public void hienThiHoDan() {
		System.out.print(this.sonha + "         " + this.sothanhvien + "                 ");
		for (int i = 0; i < this.sothanhvien; i++) {
			this.list_thanhvien[i].hienThiThongTinCaNhan(i);
		}
	}

}
