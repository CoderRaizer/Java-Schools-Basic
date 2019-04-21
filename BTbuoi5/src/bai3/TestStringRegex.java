package bai3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestStringRegex {

	
	
	public static String checkRegexMatching(String typeRegex) {
		Scanner o = new Scanner(System.in);
		String chuoi = "";
		boolean flag = true;
		if (typeRegex.equalsIgnoreCase("SO TAI KHOAN")) {//correctly
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
		} else if (typeRegex.equalsIgnoreCase("PASSWORD")) {//correctly
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
		} else if (typeRegex.equalsIgnoreCase("HOTEN") || typeRegex.equalsIgnoreCase("DIACHI")) {//correctly
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
		} else if (typeRegex.equalsIgnoreCase("EMAIL")) {//correctly
			String sampleGegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String sotaikhoan;
		String password;
		String hoten;
		String diachi;
		String sodienthoai;
		String email;
		sotaikhoan = checkRegexMatching("SO TAI KHOAN");
		password = checkRegexMatching("PASSWORD");
		hoten = checkRegexMatching("HOTEN");
		diachi = checkRegexMatching("DIACHI");
		sodienthoai = checkRegexMatching("SDT");
		email = checkRegexMatching("EMAIL");
		

	}

}
