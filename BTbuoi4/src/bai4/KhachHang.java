package bai4;

import java.util.Scanner;

public class KhachHang {

	protected String hoten;
	protected String sonha;
	protected String masocongto;
	
	public KhachHang() {
	}

	public KhachHang(String hoten, String sonha, String masocongto) {
		super();
		this.hoten = hoten;
		this.sonha = sonha;
		this.masocongto = masocongto;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getSonha() {
		return sonha;
	}

	public void setSonha(String sonha) {
		this.sonha = sonha;
	}

	public String getMasocongto() {
		return masocongto;
	}

	public void setMasocongto(String masocongto) {
		this.masocongto = masocongto;
	}
	
	
	public void nhapThongTin() {
		Scanner o = new Scanner(System.in);
		System.out.println("Họ tên: ");
		this.hoten = o.nextLine();o = new Scanner(System.in);
		System.out.println("Số nhà: ");
		this.sonha = o.nextLine();o = new Scanner(System.in);
		System.out.println("Mã số công tơ: ");
		this.masocongto = o.nextLine();
	}
	
	public void xuatThongTin() {
		System.out.print(this.hoten);
		for(int i = 0 ; i < (19 - this.hoten.length()); i++) {
			System.out.print(" ");
		}System.out.print(this.sonha); 
		for(int i = 0 ; i < (10-this.sonha.length()); i++) {
			System.out.print(" ");
		}
		System.out.print(this.masocongto);
		for(int i = 0 ; i < (18-this.masocongto.length()); i++) {
			System.out.print(" ");
		}
	}
	
}
