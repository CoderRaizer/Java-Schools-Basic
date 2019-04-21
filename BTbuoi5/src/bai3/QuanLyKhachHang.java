package bai3;

import java.util.HashMap;

public class QuanLyKhachHang<K, V> {

	HashMap<K, V> list_KH;

	public QuanLyKhachHang() {
		list_KH = new HashMap<>();
	}

	public boolean kiemTraTonTai(String stk) {
		if (!list_KH.containsKey(stk)) {
			return false;// chua ton tai sotaikhoan da nhap
		} else {
			return true;// da ton tai sotaikhoan da nhap
		}
	}

	public void themKhachHang(K key, V value) {
		list_KH.put(key, value);
	}

	public void hienThiDanhSachHanhKhach() {
		// in cach 1
		System.out.println("----------------------------------------------------------------------------------------------------");
		for (V i : list_KH.values()) {
			System.out.println(i);
			System.out.println("----------------------------------------------------------------------------------------------------");
		}
	}

	public void timKiemKhachHang(K key) {
		if (!list_KH.containsKey(key)) {
			System.out.println("Không Tồn Tại Số Tài Khoản Này");
		} else {
			System.out.println("----------------------------------------------------------------------------------------------------");
			System.out.println(list_KH.get(key));
			System.out.println("----------------------------------------------------------------------------------------------------");
		}
	}
}

// in cach 2
// for (K key : list_KH.keySet()) {
// System.out.println("--------------------------------------------------------------------------------");
// System.out.println(list_KH.get(key));
// System.out.println("--------------------------------------------------------------------------------");
// }
