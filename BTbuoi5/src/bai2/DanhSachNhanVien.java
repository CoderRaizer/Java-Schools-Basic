package bai2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DanhSachNhanVien {

	private ArrayList<NhanVien> list_nv;
	Scanner sc = new Scanner(System.in);

	public DanhSachNhanVien() {
		list_nv = new ArrayList<>();
	}

	public String checkRegexMatching(String typeRegex) {

		Scanner o = new Scanner(System.in);
		String chuoi="";
		boolean flag = true;
		if (typeRegex.equalsIgnoreCase("HO") || typeRegex.equalsIgnoreCase("TENLOT")|| typeRegex.equalsIgnoreCase("TEN")) {
			String sampleGegex = "^*[A-Za-z]*$";
			do {
				System.out.print("Nhập "+typeRegex+" : ");
				chuoi = o.nextLine();
				Pattern pt = Pattern.compile(sampleGegex, Pattern.CASE_INSENSITIVE);Matcher mt = pt.matcher(chuoi);
				if (!mt.matches()) {flag = false;System.out.println("Nhập Sai Định Dạng");
				} else if(mt.matches()) {flag = true;}
			} while (flag == false);
		} else if(typeRegex.equalsIgnoreCase("NGAYSINH") || typeRegex.equalsIgnoreCase("THANGSINH") || typeRegex.equalsIgnoreCase("NAMSINH")) {
			String sampleGegex = "\\d+{1,4}";
			do {
				System.out.print("Nhập "+typeRegex+" : ");chuoi = o.nextLine();
				Pattern pt = Pattern.compile(sampleGegex, Pattern.CASE_INSENSITIVE);Matcher mt = pt.matcher(chuoi);
				if (!mt.matches()) {flag = false;
					System.out.println("Nhập Sai Định Dạng");
				} else if(mt.matches()) {flag = true;}
			} while (flag == false);
		} else if(typeRegex.equalsIgnoreCase("LUONG")) {
			String sampleGegex = "\\d+{3,10}";
			do {
				System.out.print("Nhập "+typeRegex+" : ");chuoi = o.nextLine();
				Pattern pt = Pattern.compile(sampleGegex, Pattern.CASE_INSENSITIVE);Matcher mt = pt.matcher(chuoi);
				if (!mt.matches()) {flag = false;
					System.out.println("Nhập Sai Định Dạng");
				} else if(mt.matches()) {flag = true;}
			} while (flag == false);
		}
		return chuoi;
	}
	
	public void nhapDanhSachNhanVien() {
		System.out.print("Nhập Số Nhân Viên Muốn Thêm Vào Danh Sách: ");
		int count = sc.nextInt();
		for (int i = 0; i < count; i++) {

			String ho;
			String tenlot;
			String ten;
			int ngaysinh;
			int thangsinh;
			int namsinh;
			int luong;

			ho = checkRegexMatching("HO");
			tenlot = checkRegexMatching("TENLOT");
			ten = checkRegexMatching("TEN");
			ngaysinh = Integer.parseInt(checkRegexMatching("NGAYSINH"));
			thangsinh = Integer.parseInt(checkRegexMatching("THANGSINH"));
			namsinh = Integer.parseInt(checkRegexMatching("NAMSINH"));
			luong = Integer.parseInt(checkRegexMatching("LUONG"));

			list_nv.add(new NhanVien(new HoTen(ho, tenlot, ten), new SinhNhat(ngaysinh, thangsinh, namsinh), luong));
		}
		System.out.println("THÊM NHÂN VIÊN THÀNH CÔNG");
	}

	public void xuatDanhSachNhanVien() {
		System.out.println("DANH SÁCH NHÂN VIÊN");
		System.out.println("-------------------------------------------------------------");
		System.out.println("TÊN         HỌ TÊN LÓT          NGÀY SINH           MỨC LƯƠNG");
		System.out.println("-------------------------------------------------------------");
		for (NhanVien x : list_nv) {
			x.xuatNhanVien();
			System.out.println("-------------------------------------------------------------");
		}
	}

	public void sapXepTheoTenNhanVien() {
		Collections.sort(list_nv);
		System.out.println("SẮP XẾP THEO HỌ TÊN THÀNH CÔNG");
		xuatDanhSachNhanVien();
	}

	public void sapXepTheoMucLuongNhanVien() {
		int max;
		int length = list_nv.size();
		for (int i = 0; i < (length - 1); i++) {
			max = i;
			for (int j = i + 1; j < list_nv.size(); j++) {
				if (list_nv.get(j).getLuong() > list_nv.get(max).getLuong()) {
					max = j;
				}
			}
			NhanVien temp = new NhanVien();
			temp = list_nv.get(i);
			list_nv.set(i, list_nv.get(max));
			list_nv.set(max, temp);
		}
		System.out.println("------------------SẮP XẾP THEO MỨC LƯƠNG THÀNH CÔNG-------------------");
		xuatDanhSachNhanVien();
	}


	public boolean soSanhSinhNhat(SinhNhat sn1, SinhNhat sn2) {
		if (sn1.getNam() < sn2.getNam()) {
			return true;
		} else if (sn1.getNam() == sn2.getNam()) {
			if (sn1.getThang() < sn2.getThang()) {
				return true;
			}
		} else if (sn1.getNam() == sn2.getNam() && sn1.getThang() < sn2.getThang()) {
			if (sn1.getNgay() < sn2.getNgay()) {
				return true;
			}
		}
		return false;
	}

	public void sapXepTheoNgaySinh() {
		int min;
		int length = list_nv.size();
		for (int i = 0; i < (length - 1); i++) {
			min = i;
			for (int j = i + 1; j < list_nv.size(); j++) {
				if (soSanhSinhNhat(list_nv.get(j).getSinhnhat(), list_nv.get(min).getSinhnhat()) == true) {//dung la cai sau nho hon cai truoc
					min = j;
				}
			}
			NhanVien temp = new NhanVien();
			temp = list_nv.get(i);
			list_nv.set(i, list_nv.get(min));
			list_nv.set(min, temp);
		}
		System.out.println("-----------------SẮP XẾP THEO NGÀY SINH THÀNH CÔNG-------------------");
		xuatDanhSachNhanVien();
	}

}































// public boolean SoSanhNgaySinh(String ngaysinh1 , String ngaysinh2) {
// char []array1 = ngaysinh1.toCharArray();
// char []array2 = ngaysinh2.toCharArray();
//
// String convert1 = "";
// String convert2 = "";
//
// for(int i = 6 ; i < 10 ; i++) {
// convert1 += Character.toString((char)((int)array1[i]));
// convert2 += Character.toString((char)((int)array2[i]));
// }
// for(int i = 3 ; i <= 4; i++) {
// convert1 += Character.toString((char)((int)array1[i]));
// convert2 += Character.toString((char)((int)array2[i]));
// }
// for(int i = 0; i <= 1; i++) {
// convert1 += Character.toString((char)((int)array1[i]));
// convert2 += Character.toString((char)((int)array2[i]));
// }
//
// if(Integer.parseInt(convert1) < Integer.parseInt(convert2)) {
// return true;//neu thang truoc lon hon thang sau thi tra ve true -> true la
// cho phep hoan doi o ham ben duoi
// } else {
// return false;
// }
// }
