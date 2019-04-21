package bai3;

import java.io.Serializable;


public class SinhVien implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String hoten;
	private String ngaysinh;
	private double diemtrungbinh;
	
	public SinhVien() {
		
	}

	public SinhVien(String hoten, String ngaysinh, double diemtrungbinh) {
		super();
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.diemtrungbinh = diemtrungbinh;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public double getDiemtrungbinh() {
		return diemtrungbinh;
	}

	public void setDiemtrungbinh(double diemtrungbinh) {
		this.diemtrungbinh = diemtrungbinh;
	}
	
	@Override
	public String toString() {
		return "Họ Tên: "+this.hoten+" Ngày Sinh: "+this.ngaysinh+" Điểm Trung Bình: "+this.diemtrungbinh;
	}

}
