package bai3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner o = new Scanner(System.in);
		QuanLySinhVien manager = new QuanLySinhVien();

		if (manager.ExistFile() == false) {
			System.out.println("----THÊM THÔNG TIN VÀO FILE----");
			System.out.print("Bạn muốn nhập bao nhiêu sinh viên: ");
			int soluong; soluong = o.nextInt();
			for (int i = 0; i < soluong; i++) {
				manager.themSinhVien();
			}
			System.out.println("----LƯU VÀO FILE THÀNH CÔNG----");
		}

		if (manager.ExistFile()) {// đã tồn tại file
			
			/*------Chua co data------*/
			if (manager.checkDataInFile() == false) {// chưa có data -> ghi bình thường
				System.out.print(" Tồn Tại File Nhưng Chưa Có Data -> Thêm Data ");
				System.out.println("-----WRITE FILE-----");
				System.out.print("Bạn muốn nhập bao nhiêu sinh viên: ");
				int soluong;
				soluong = o.nextInt();
				for (int i = 0; i < soluong; i++) {
					manager.themSinhVien();
				}
				manager.writeListStudent();
				JOptionPane.showMessageDialog(null,"LƯU FILE THÀNH CÔNG");
			}
			
			/*------Da co data------*/
			else if (manager.checkDataInFile() == true) {// đã có data (show hoặc thêm vào)
				System.out.print(
						"File Đang Có Dữ Liệu \n (0)Xuất Danh Sách \n (any number)Thêm Tiếp Vào File \n Choice: ");
				int select = o.nextInt();
				if (select == 0) {
					manager.readListStudent();
					manager.xuatDanhSachSinhVien();
				} else {// thêm vào
					System.out.println("-----Ghi Thêm Vào Danh Sách-----");
					manager.readListStudent();//đưa data cũ từ file vào Arraylist
					System.out.print("Bạn muốn ghi thêm bao nhiêu Sinh Viên vào file: ");
					int soluong = o.nextInt();
					for (int i = 0; i < soluong; i++) {
						manager.themSinhVien();
						System.out.println("---------------------");
					}
					manager.writeListStudent();
					System.out.println("-----Ghi Thêm Vào Danh Sách Thành Công-----");
					manager.xuatDanhSachSinhVien();
				}
			}
		}
		
		
		System.out.print("Bạn có muốn copy file vào thư mục khác không \n (0)No \n (any number)Yes:  ");int choice = o.nextInt();
		if(choice != 0) {
			String newPathFile = "D://LTHDT//BaiTap3Copy.txt";
			manager.copyFileToAnotherPlace(new File(newPathFile));
		}
		
		
	}
}
