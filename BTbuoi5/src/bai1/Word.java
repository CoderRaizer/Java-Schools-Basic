package bai1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word implements Comparable<Word>{
	private String tu;
	private String nghia;
	
	Scanner sc = new Scanner(System.in);
	
	public Word() {
	}

	public String getTu() {
		return tu;
	}

	public void setTu(String tu) {
		this.tu = tu;
	}

	public String getNghia() {
		return nghia;
	}

	public void setNghia(String nghia) {
		this.nghia = nghia;
	}
	
	
	
	public String checkRegexMatching(String typeRegex) {
		Scanner o = new Scanner(System.in);
		String chuoi="";
		boolean flag = true;
		String sampleGegex = "^*[A-Za-z]*$";
			do {
				System.out.print("Nhập "+typeRegex+" : ");
				chuoi = o.nextLine();
				Pattern pt = Pattern.compile(sampleGegex, Pattern.CASE_INSENSITIVE);Matcher mt = pt.matcher(chuoi);
				if (!mt.matches()) {flag = false;System.out.println("Nhập Sai Định Dạng");
				} else if(mt.matches()) {flag = true;}
			} while (flag == false);
		return chuoi;
	}
	
	public void inPut() {
		this.tu = checkRegexMatching("TU");
		this.nghia = checkRegexMatching("NGHIA");
	}
	
	
	public void outPut() {
		System.out.println("tu: "+this.tu + " nghia: "+this.nghia);
	}
	
	
	@Override
	public int compareTo(Word o) {
		if(this.tu.compareTo(o.tu) > 0) {
			return 1;
		}
		return -1;
	}
	
	

}
