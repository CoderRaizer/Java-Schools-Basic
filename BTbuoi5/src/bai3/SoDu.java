package bai3;

public class SoDu implements Comparable<SoDu> {
	private String sotaikhoan;
	private double sotien;

	public SoDu() {
	}

	public SoDu(String sotaikhoan, double sotien) {
		super();
		this.sotaikhoan = sotaikhoan;
		this.sotien = sotien;
	}

	public String getSotaikhoan() {
		return sotaikhoan;
	}

	public void setSotaikhoan(String sotaikhoan) {
		this.sotaikhoan = sotaikhoan;
	}

	public double getSotien() {
		return sotien;
	}

	public void setSotien(double sotien) {
		this.sotien = sotien;
	}

	@Override
	public String toString() {
		return "Số Tài Khoản: " + this.sotaikhoan + "   Số Dư: " + this.sotien;
	}

	@Override
	public int compareTo(SoDu o) {
		if (this.getSotien() > o.getSotien()) {
			return 1;
		} else
			return -1;
	}
}
