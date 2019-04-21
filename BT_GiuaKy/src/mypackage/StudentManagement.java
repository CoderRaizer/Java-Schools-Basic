package mypackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentManagement<K, V> {

	HashMap<K, V> list_Student;

	public StudentManagement() {
		list_Student = new HashMap<>();
	}

	public boolean kiemTraTrungLap(String id) {
		if (!list_Student.containsKey(id)) {
			return false;
		} else {
			return true;
		}
	}

	public void replaceStudent(K key, V valueOld, V valueNew) {
		list_Student.replace(key, valueOld, valueNew);
	}

	public void addStudent(K key, V value) {
		list_Student.put(key, value);
	}

	public void hienThiDanhSachSinhVien() {
		System.out.println(
				"----------------------------------------------------------------------------------------------------");
		for (V i : list_Student.values()) {
			System.out.println(i);
			System.out.println(
					"----------------------------------------------------------------------------------------------------");
		}
	}

	public boolean timKiemSinhVien(String id) {
		if (!list_Student.containsKey(id)) {
			return false;
		} else {
			return true;
		}
	}

	public float inputScore() {
		Scanner o = new Scanner(System.in);
		String chuoi = "";
		boolean flag = true;
		String sampleGegex = "\\d{1,2}\\.\\d";
		do {
			System.out.print("Nhập diem: ");
			chuoi = o.nextLine();
			Pattern pt = Pattern.compile(sampleGegex, Pattern.CASE_INSENSITIVE);
			Matcher mt = pt.matcher(chuoi);
			if (!mt.matches()) {
				flag = false;
				System.out.println("Nhập Sai Định Dạng");
			} else if (mt.matches()) {
				float x = Float.parseFloat(chuoi);
				if (x >= 0 && x <= 10) {
					flag = true;
				} else {
					flag = false;
				}
			}
		} while (flag == false);

		float score = Float.parseFloat(chuoi);
		return score;
	}

	/*------Run APP------*/
	public static void main(String[] args) {
		
		StudentManagement<String, Student> manager = new StudentManagement<>();

		int select;
		Scanner o = new Scanner(System.in);
		while (true) {
			System.out.println("1. Nhập Danh Sách Sinh Viên và kiểm tra thông báo lỗi");
			System.out.println("2. In Danh Sách Sinh Viên");
			System.out.println("3. Tìm SV theo khoảng điểm mark");
			System.out.println("4. Sắp xếp DSSV theo mark và in ra màn hình");
			System.out.println("5. Sửa thông tin");
			System.out.print("Nhập Lựa Chọn: ");
			select = o.nextInt();

			switch (select) {
			case 1: {
				int quantity;
				System.out.print("Nhập Số Sinh Viên Muốn Thêm: ");
				quantity = o.nextInt();
				for (int i = 0; i < quantity; i++) {
					Student x = new Student();
					x.input();
					if (manager.kiemTraTrungLap(x.getId()) == true) {
						System.out.println("Mã sv đã tồn tại");
					} else {
						manager.addStudent(x.getId(), x);
						System.out.println("Thêm Thành Công");
						System.out.println("-----------------------");
					}
				}
				break;
			}

			case 2: {
				System.out.println("-------------------------------------------------------------");
				for (Entry<String, Student> s : manager.list_Student.entrySet()) {
					s.getValue().display();
				}
				System.out.println("-------------------------------------------------------------");
				break;
			}

			case 3: {
				float x = manager.inputScore();
				float y = manager.inputScore();
				for (Entry<String, Student> set : manager.list_Student.entrySet()) {
					if (set.getValue().getMark() >= x && set.getValue().getMark() <= y) {
						set.getValue().display();
					}
				}
				break;
			}

			case 4: {
				ArrayList<Student> list_temp = new ArrayList<>();
				for (Entry<String, Student> k : manager.list_Student.entrySet()) {
					list_temp.add(k.getValue());
				}
				Collections.sort(list_temp);
				for (Student sv : list_temp) {
					sv.display();
				}
				break;
			}

			case 5: {
				Student a = new Student();
				String idSearch;
				System.out.print("Nhap id can sua chua: ");
				o = new Scanner(System.in);
				idSearch = o.nextLine();
				for (Entry<String, Student> set : manager.list_Student.entrySet()) {
					if (set.getValue().getId().equals(idSearch))
						a.input();
					manager.replaceStudent(idSearch, set.getValue(), a);
					break;
				}
				for (Entry<String, Student> set : manager.list_Student.entrySet()) {
					set.getValue().display();
				}

				break;

			}
			}
		}
	}

}
