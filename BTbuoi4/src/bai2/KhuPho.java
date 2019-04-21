package bai2;

import java.util.Scanner;

public class KhuPho {

	Scanner o = new Scanner(System.in);

	private HoDan[] list_hodan;
	private int count;
	private int quantity;

	public KhuPho() {
		this.count = 0;
		this.list_hodan = new HoDan[setQuantity()];
	}

	private int setQuantity() {
		System.out.print("Nhập Số Lượng Lưu Trữ Hộ Dân Trong Khu Phố: ");
		this.quantity = o.nextInt();
		return this.quantity;
	}

	public void themHoDan() {
		if (this.count < this.quantity) {
			HoDan a = new HoDan();
			a.nhapThongTinHoDan();
			this.list_hodan[this.count] = a;
			this.count++;
		}
	}

	public void hienThiDanhSachHoDanChiTiet() {
		System.out.println(
				"--------------------------------------------------------------------------------------------------");
		System.out.println(
				"SỐ NHÀ     SỐ THÀNH VIÊN     HỌ TÊN              TUỔI     NĂM SINH     NGHỀ NGHIỆP                ");
		System.out.println(
				"--------------------------------------------------------------------------------------------------");
		for (int i = 0; i < this.count; i++) {
			this.list_hodan[i].hienThiHoDan();
			System.out.println(
					"--------------------------------------------------------------------------------------------------");
		}
	}

}
