package bai5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DSNhanVien {

	ArrayList<NhanVien> list_nv;

	Scanner o = new Scanner(System.in);

	public DSNhanVien() {
		list_nv = new ArrayList<>();
	}

	public void themDanhSachNhanVien() {
		System.out.print("Bạn muốn nhập bao nhiêu nhân viên: ");
		int quantity = o.nextInt();
		int dex;
		for (int i = 0; i < quantity; i++) {
			dex = i;
			int select;
			System.out.println("Nhập Nhân Viên (1. Văn Phòng - 2. Sản Xuất) : ");
			select = o.nextInt();
			if (select == 1) {
				NhanVienVanPhong nvvp = new NhanVienVanPhong();
				nvvp.nhapThongTin();
				list_nv.add(nvvp);
			} else if (select == 2) {
				NhanVienSanXuat nvsx = new NhanVienSanXuat();
				nvsx.nhapThongTin();
				list_nv.add(nvsx);
			} else {
				System.out.println("Bạn vừa nhập số không hợp lệ ( nhập lại )");
				i = dex;
			}
		}
	}

	public void xuatThongTinNhanVien() {
		System.out.println(
				"---------------------------------------------------------------------------------------------------");
		System.out.println(
				"NHÂN VIÊN      HỌ TÊN              NGÀY SINH       NGÀY VÀO LÀM     LOẠI NHÂN VIÊN       LƯƠNG     ");
		System.out.println(
				"---------------------------------------------------------------------------------------------------");

		Collections.sort(list_nv);
		for (NhanVien a : list_nv) {
			a.xuatThongTin();
		}

	}

}
