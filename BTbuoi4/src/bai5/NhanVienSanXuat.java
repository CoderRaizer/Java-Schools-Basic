package bai5;

import java.util.Scanner;

public class NhanVienSanXuat extends NhanVien {

	private int sosanpham;
	private int dongia;

	Scanner o = new Scanner(System.in);

	public NhanVienSanXuat() {
		super();
	}

	public NhanVienSanXuat(int sosanpham, int dongia) {
		super();
		this.sosanpham = sosanpham;
		this.dongia = dongia;
	}

	@Override
	public void nhapThongTin() {
		super.nhapThongTin();
		System.out.print("Số Sản Phẩm: ");
		this.sosanpham = o.nextInt();
		o = new Scanner(System.in);
		System.out.print("Đơn Giá: ");
		this.dongia = o.nextInt();
	}

	@Override
	public double tinhLuong() {
		if (coconduoi3tuoi == true) {
			double ret = ((this.sosanpham * this.dongia) * 5) / 100;
			return (ret + (double) (this.sosanpham * this.dongia));
		} else {
			return (double) (this.sosanpham * this.dongia);
		}
	}

	@Override
	public void xuatThongTin() {
		super.xuatThongTin();
		System.out.println("NVSX               " + tinhLuong());

	}

}
