package bai3;

import java.util.Scanner;

public class Nguoi extends HSHocSinh{
	
	private String hoten;
	private int tuoi;
	private int namsinh;
	private String quequan;
	
	public Nguoi() {
	}

	public Nguoi(String hoten, int tuoi, int namsinh, String quequan) {
		this.hoten = hoten;
		this.tuoi = tuoi;
		this.namsinh = namsinh;
		this.quequan = quequan;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public int getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(int namsinh) {
		this.namsinh = namsinh;
	}

	public String getQuequan() {
		return quequan;
	}

	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}
	
	
	@Override
	public void nhapThongTin() {
		super.nhapThongTin();
		Scanner o = new Scanner(System.in);
		System.out.print("Nhập họ tên: ");
		this.hoten = o.nextLine();o = new Scanner(System.in);
		System.out.print("Nhập tuổi: ");
		this.tuoi = o.nextInt();o = new Scanner(System.in);
		System.out.print("Nhập năm sinh: ");
		this.namsinh = o.nextInt();o = new Scanner(System.in);
		System.out.print("Nhập quê quán: ");
		this.quequan = o.nextLine();o = new Scanner(System.in);
	}
	
	
	@Override
	public void hienThiThongTin() {
		super.hienThiThongTin();
		System.out.println(this.hoten+"   "+this.tuoi+"   "+this.namsinh+"   "+this.quequan);
	}

}
