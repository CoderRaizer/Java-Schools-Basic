package bai1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TuDien {

	ArrayList<Word> list_word;
	Scanner sc = new Scanner(System.in);

	public TuDien() {
		list_word = new ArrayList<>();
	}

	public boolean kiemTraTrungTu(String tu) {
		for (int i = 0; i < list_word.size(); i++) {
			if (list_word.get(i).getTu().equalsIgnoreCase(tu)) {
				return true;
			}
		}
		return false;
	}

	public void themTuVaoTuDien() {
		System.out.print("Bạn Muốn Nhập Bao Nhiêu Từ: ");
		int count = sc.nextInt();
		for (int i = 0; i < count; i++) {
			Word x = new Word();
			x.inPut();
			if (kiemTraTrungTu(x.getTu()) == false) {
				list_word.add(x);
			} else {
				System.out.println("Từ Bạn Nhập Đã Tồn Tại Trong Từ Điển");
			}
		}
	}

	public void xuatDanhSachTuDien() {
		System.out.println("-----------------------------------------------------------------");
		for (Word x : list_word) {
			x.outPut();
			System.out.println("-----------------------------------------------------------------");
		}

	}

	public void traTuDien() {
		boolean flag = false;
		String searchWord;
		sc = new Scanner(System.in);
		System.out.print("Nhập Từ Cần Tìm Kiếm: ");
		searchWord = sc.nextLine();
		for (Word x : list_word) {
			if (x.getTu().equalsIgnoreCase(searchWord)) {
				System.out.print("Từ Bạn Cần Tìm Kiếm Là: ");
				x.outPut();
				flag = true;
				break;
			}
		}
		if (flag == false) {
			System.out.println("Từ Bạn Tìm Kiếm Không Tồn Tại Trong Từ Điển");
		}
	}

	public void suaTuTrongTuDien() {
		String searchWord;
		boolean flag = false;
		sc = new Scanner(System.in);
		System.out.print("Nhập Từ Bạn Cần Sửa: ");
		searchWord = sc.nextLine();
		for (Word x : list_word) {
			if (x.getTu().equalsIgnoreCase(searchWord)) {
				System.out.print("Nhập Thông Tin Cho Từ Mới ");
				x.inPut();
				System.out.print("Sửa Thành Công");
				flag = true;
				break;
			}
		}
		if (flag == false) {
			System.out.println("Từ Bạn Nhập Không Tồn Tại");
		}
	}

	public void xoaTuTrongTuDien() {
		boolean flag = false;
		String searchWord;
		System.out.print("Nhập Từ Cần Xóa: ");
		searchWord = sc.nextLine();
		for (Word x : list_word) {
			if (x.getTu().equalsIgnoreCase(searchWord)) {
				list_word.remove(x);
				System.out.println("Xóa Từ Thành Công");
				flag = true;
				break;
			}
		}
		if (flag == false) {
			System.out.println("Từ Bạn Nhập Không Tồn Tại");
		}
	}

	public void sapXepTuTrongTuDien() {
		Collections.sort(list_word);
		System.out.println("------------Từ Điển Đã Được Sắp Xếp-------------");
		xuatDanhSachTuDien();
	}

}
