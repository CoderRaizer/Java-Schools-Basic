package bai3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		Scanner o = new Scanner(System.in);
		QuanLyKhachHang<String, KhachHang> managerKH = new QuanLyKhachHang<>();
		QuanLySoDu<String, SoDu> managerSD = new QuanLySoDu<>();

		int select;
		while (true) {
			System.out.println("1. Nhập Danh Sách Khách Hàng Và In Ra Danh Sách Khách Hàng");
			System.out.println("2. Tìm Khách Hàng Theo Số Tài Khoản");
			System.out.println("3. Nạp Tiền Vào Một Tài Khoản");
			System.out.println("4. Rút Tiền Từ Một Tài Khoản");
			System.out.println("5. In Ra Số Dư Của 1 Tài Khoản");
			System.out.println("6. Danh Sách Khách Hàng Có Số Dư Lớn Hơn Hoặc Bằng Số Tiền X (Sắp Xếp Tăng Dần Theo Số Tiền Và In Ra)");
			System.out.print("Nhập Lựa Chọn: ");
			select = o.nextInt();

			switch (select) {
			case 1: {
				int quantity;
				System.out.print("Nhập Số Lượng Tài Khoản Muốn Thêm: ");
				quantity = o.nextInt();
				for (int i = 0; i < quantity; i++) {
					KhachHang x = new KhachHang();
					x.nhapThongTin();
					if (managerKH.kiemTraTonTai(x.getSotaikhoan()) == true) {
						System.out.println("Số Tài Khoản Đã Tồn Tại - Không Thêm Được");
					} else if (managerKH.kiemTraTonTai(x.getSotaikhoan()) == false) {
						managerKH.themKhachHang(x.getSotaikhoan(), x);
						//SoDu y = new SoDu(x.getSotaikhoan(), 0);// Mặc định khi khởi tạo một tài khoản mới thì khởi tạo
																// luôn số dư cho tài khoản đó và khởi tạo số dư là 0;
						managerSD.themTaiKhoan(x.getSotaikhoan(),new SoDu(x.getSotaikhoan(), 0));
						System.out.println("Thêm Thành Công");
						System.out.println("-----------------------");
					}
				}
				managerKH.hienThiDanhSachHanhKhach();
				break;
			}

			case 2: {
				String sotaikhoan;
				System.out.print("Nhập Số TK Cần Tìm: ");
				o = new Scanner(System.in);
				sotaikhoan = o.nextLine();
				managerKH.timKiemKhachHang(sotaikhoan);
				break;
			}

			case 3: {
				o = new Scanner(System.in);
				String sotaikhoan;
				System.out.print("Nhập Số Tài Khoản Muốn Nạp Tiền: ");
				sotaikhoan = o.nextLine();

				if (managerKH.kiemTraTonTai(sotaikhoan) == true) {
					System.out.print("Nhập Số Tiền Cần Nạp: ");
					double sotienNapVao = o.nextDouble();
					double sotienMoi = 0;

					for (Entry<String, SoDu> set : managerSD.list_SDTK.entrySet()) {
						if (set.getValue().getSotaikhoan().equalsIgnoreCase(sotaikhoan)) {
							sotienMoi = (sotienNapVao + set.getValue().getSotien());
							break;
						}
					}
					managerSD.thayDoiSoDuTaiKhoan(sotaikhoan, new SoDu(sotaikhoan, sotienMoi));
					System.out.println("Nạp Tiền Vào Tài Khoản Thành Công");
				} else {
					System.out.println("Số Tài Khoản Không Tồn Tại");
				}
				break;
			}

			case 4: {
				o = new Scanner(System.in);
				String sotaikhoan;
				System.out.print("Nhập Số Tài Khoản Muốn Rút Tiền: ");
				sotaikhoan = o.nextLine();
				if (managerKH.kiemTraTonTai(sotaikhoan) == true) {
					System.out.print("Nhập Số Tiền Cần Rút: ");
					double sotienRutRa = o.nextDouble();
					double sotienMoi = 0;
					boolean flag = false;
					for (Entry<String, SoDu> s : managerSD.list_SDTK.entrySet()) {
						if (s.getValue().getSotaikhoan().equalsIgnoreCase(sotaikhoan)) {
							if (sotienRutRa <= s.getValue().getSotien()) {
								sotienMoi = (s.getValue().getSotien() - sotienRutRa);
								managerSD.thayDoiSoDuTaiKhoan(sotaikhoan, new SoDu(sotaikhoan, sotienMoi));
								System.out.println("Rút Tiền Vào Tài Khoản Thành Công");
							} else if (sotienRutRa > s.getValue().getSotien()) {
								flag = false;
							}
							break;
						}
					}
					if (flag == false) {
						System.out.println("Số Tiền Rút Không Hợp Lệ (Lớn Hơn Số Dư) ");
					}

				} else {
					System.out.println("Số Tài Khoản Không Tồn Tại");
				}
				break;
			}

			case 5: {
				o = new Scanner(System.in);
				String sotaikhoan;
				System.out.print("Nhập Số Tài Khoản Muốn Kiểm Tra Số Dư: ");
				sotaikhoan = o.nextLine();
				if (managerKH.kiemTraTonTai(sotaikhoan) == true) {
					managerSD.hienThiSoDuCuaMotTaiKhoan(sotaikhoan);
				} else {
					System.out.print("Số Tài Khoản Không Hợp Lệ");
				}
				break;
			}

			case 6: {
				ArrayList<SoDu> list_temp = new ArrayList<>();
				for (Entry<String, SoDu> k : managerSD.list_SDTK.entrySet()) {
					list_temp.add(k.getValue());
				}
				Collections.sort(list_temp);

				System.out.print("Nhập Số Tiền X: ");
				double X = o.nextDouble();
				System.out.println("----------------------------------------------------------------------------------------------------");
				for (int i = 0; i < list_temp.size(); i++) {
						if (list_temp.get(i).getSotien()>=X) {
						System.out.println(managerKH.list_KH.get(list_temp.get(i).getSotaikhoan()));
						System.out.println("----------------------------------------------------------------------------------------------------");
						}
					}
					break;
				}
			}
		}

	}

}
