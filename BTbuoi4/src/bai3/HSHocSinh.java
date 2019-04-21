package bai3;

import java.util.Scanner;

public class HSHocSinh {
	
	protected String Lop;
	protected String khoahoc;
	protected int kyhoc;

	Scanner o = new Scanner(System.in);
	public HSHocSinh() {
	}

	public HSHocSinh(String lop, String khoahoc, int kyhoc) {
		Lop = lop;
		this.khoahoc = khoahoc;
		this.kyhoc = kyhoc;
	}

	public String getLop() {
		return Lop;
	}

	public void setLop(String lop) {
		Lop = lop;
	}

	public String getKhoahoc() {
		return khoahoc;
	}

	public void setKhoahoc(String khoahoc) {
		this.khoahoc = khoahoc;
	}

	public int getKyhoc() {
		return kyhoc;
	}

	public void setKyhoc(int kyhoc) {
		this.kyhoc = kyhoc;
	}
	
	
	public void nhapThongTin() {
		System.out.print("Nhập Lớp: ");
		this.Lop = o.nextLine();
		o = new Scanner(System.in);
		System.out.print("Nhập khóa học : ");
		this.khoahoc = o.nextLine();
		o = new Scanner(System.in);
		System.out.print("Nhập kỳ học: ");
		this.kyhoc = o.nextInt();
	}
	
	
	public void hienThiThongTin() {
		System.out.print(this.Lop + "   "+this.khoahoc+ "   "+this.kyhoc+"   ");
	}
	
	
	
	
	
	
}
