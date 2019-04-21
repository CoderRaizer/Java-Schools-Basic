package bai3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KhachHang {
	private String sotaikhoan;
	private String matkhau;
	private String hoten;
	private String diachi;
	private String sodienthoai;
	private String email;

	public KhachHang() {
	}

	public KhachHang(String sotaikhoan, String matkhau, String hoten, String diachi, String sodienthoai, String email) {
		super();
		this.sotaikhoan = sotaikhoan;
		this.matkhau = matkhau;
		this.hoten = hoten;
		this.diachi = diachi;
		this.sodienthoai = sodienthoai;
		this.email = email;
	}

	public String getSotaikhoan() {
		return sotaikhoan;
	}

	public void setSotaikhoan(String sotaikhoan) {
		this.sotaikhoan = sotaikhoan;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String checkRegexMatching(String typeRegex) {
		Scanner o = new Scanner(System.in);
		String chuoi = "";
		boolean flag = true;
		if (typeRegex.equalsIgnoreCase("SO TAI KHOAN")) {//correct
			String sampleGegex = "\\d{6}";
			do {
				System.out.print("Nhập " + typeRegex + " (Gồm 6 Chữ Số): ");
				chuoi = o.nextLine();
				Pattern pt = Pattern.compile(sampleGegex, Pattern.CASE_INSENSITIVE);
				Matcher mt = pt.matcher(chuoi);
				if (!mt.matches()) {
					flag = false;
					System.out.println("Nhập Sai Định Dạng");
				} else if (mt.matches()) {
					flag = true;
				}
			} while (flag == false);
		} else if (typeRegex.equalsIgnoreCase("PASSWORD")) {//correct
			String sampleGegex = "\\d{4}";
			do {
				System.out.print("Nhập " + typeRegex + " (Gồm 4 Chữ Số): ");
				chuoi = o.nextLine();
				Pattern pt = Pattern.compile(sampleGegex, Pattern.CASE_INSENSITIVE);
				Matcher mt = pt.matcher(chuoi);
				if (!mt.matches()) {
					flag = false;
					System.out.println("Nhập Sai Định Dạng");
				} else if (mt.matches()) {
					flag = true;
				}
			} while (flag == false);
		} else if (typeRegex.equalsIgnoreCase("HOTEN") || typeRegex.equalsIgnoreCase("DIACHI")) {
			String sampleGegex = "^[a-zA-Z\\s]+";
			do {
				System.out.print("Nhập " + typeRegex + " : ");
				chuoi = o.nextLine();
				Pattern pt = Pattern.compile(sampleGegex, Pattern.CASE_INSENSITIVE);
				Matcher mt = pt.matcher(chuoi);
				if (!mt.matches()) {
					flag = false;
					System.out.println("Nhập Sai Định Dạng");
				} else if (mt.matches()) {
					flag = true;
				}
			} while (flag == false);
		} else if (typeRegex.equalsIgnoreCase("SDT")) {
			String sampleGegex = "[\\d]{10,12}";
			do {
				System.out.print("Nhập " + typeRegex + " (Tối thiểu 10 số - Tối Đa 12 số) : ");
				chuoi = o.nextLine();
				Pattern pt = Pattern.compile(sampleGegex, Pattern.CASE_INSENSITIVE);
				Matcher mt = pt.matcher(chuoi);
				if (!mt.matches()) {
					flag = false;
					System.out.println("Nhập Sai Định Dạng");
				} else if (mt.matches()) {
					flag = true;
				}
			} while (flag == false);
		} else if (typeRegex.equalsIgnoreCase("EMAIL")) {
			String sampleGegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			do {
				System.out.print("Nhập " + typeRegex + " : ");
				chuoi = o.nextLine();
				Pattern pt = Pattern.compile(sampleGegex, Pattern.CASE_INSENSITIVE);
				Matcher mt = pt.matcher(chuoi);
				if (!mt.matches()) {
					flag = false;
					System.out.println("Nhập Sai Định Dạng");
				} else if (mt.matches()) {
					flag = true;
				}
			} while (flag == false);
		}
		return chuoi;
	}

	public void nhapThongTin() {
		this.sotaikhoan = checkRegexMatching("SO TAI KHOAN");
		this.matkhau = checkRegexMatching("PASSWORD");
		this.hoten = checkRegexMatching("HOTEN");
		this.diachi = checkRegexMatching("DIACHI");
		this.sodienthoai = checkRegexMatching("SDT");
		this.email = checkRegexMatching("EMAIL");
	}

	@Override
	public String toString() {
		return "Họ Tên : " + this.hoten + "  Địa Chỉ: " + this.diachi + "  SĐT: " + this.sodienthoai + "  Email: "
				+ this.email;
	}

}
