package bai5;

import java.util.Scanner;

public class NhanVienVanPhong extends NhanVien {

	private int luongcoban;
	private int hesoluong;

	Scanner o = new Scanner(System.in);

	public NhanVienVanPhong() {
		super();
	}

	public NhanVienVanPhong(int luongcoban, int hesoluong) {
		super();
		this.luongcoban = luongcoban;
		this.hesoluong = hesoluong;
	}

	public int getLuongcoban() {
		return luongcoban;
	}

	public void setLuongcoban(int luongcoban) {
		this.luongcoban = luongcoban;
	}

	public int getHesoluong() {
		return hesoluong;
	}

	public void setHesoluong(int hesoluong) {
		this.hesoluong = hesoluong;
	}

	@Override
	public void nhapThongTin() {
		super.nhapThongTin();
		System.out.print("Lương cơ bản: ");
		this.luongcoban = o.nextInt();
		System.out.print("Hệ số lương: ");
		this.hesoluong = o.nextInt();
	}

	@Override
	public double tinhLuong() {
		if (coconduoi3tuoi == true) {
			double ret = ((this.luongcoban * this.hesoluong) * 5) / 100;
			return (ret + (double) (this.luongcoban * this.hesoluong));
		} else {
			return (double) (this.luongcoban * this.hesoluong);
		}
	}

	@Override
	public void xuatThongTin() {
		super.xuatThongTin();
		System.out.println("NVVP               " + tinhLuong());
	}

}
