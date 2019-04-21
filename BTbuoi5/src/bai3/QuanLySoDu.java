package bai3;

import java.util.HashMap;

public class QuanLySoDu<K, V> {

	HashMap<K, V> list_SDTK;

	public QuanLySoDu() {
		list_SDTK = new HashMap<>();
	}

	public void themTaiKhoan(K key, V value) {
		list_SDTK.put(key, value);
	}

	public void thayDoiSoDuTaiKhoan(K key, V newvalue) {
		list_SDTK.replace(key, newvalue);
	}

	public void hienThiSoDuCuaMotTaiKhoan(K key) {
		System.out.println("------------------------------");
		System.out.println(list_SDTK.get(key));
		System.out.println("------------------------------");
	}

	public void hienThiDanhSachSoDu() {
		System.out.println("--------------------------------------------------------------------------------");
		for (V x : list_SDTK.values()) {
			System.out.println(x);
			System.out.println("--------------------------------------------------------------------------------");
		}
	}

}
