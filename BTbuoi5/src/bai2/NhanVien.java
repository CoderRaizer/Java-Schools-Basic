package bai2;

import java.util.Scanner;

public class NhanVien implements Comparable<NhanVien>{
	
	private HoTen hoten;
	private SinhNhat sinhnhat;
	private int luong;
	
	
	Scanner o = new Scanner(System.in);
	public NhanVien() {
	}

	public NhanVien(HoTen hoten, SinhNhat sinhnhat, int luong) {
		super();
		this.hoten = hoten;
		this.sinhnhat = sinhnhat;
		this.luong = luong;
	}
	
	public HoTen getHoten() {
		return hoten;
	}

	public void setHoten(HoTen hoten) {
		this.hoten = hoten;
	}

	public SinhNhat getSinhnhat() {
		return sinhnhat;
	}

	public void setSinhnhat(SinhNhat sinhnhat) {
		this.sinhnhat = sinhnhat;
	}

	public int getLuong() {
		return luong;
	}

	public void setLuong(int luong) {
		this.luong = luong;
	}

	public void xuatNhanVien() {
		System.out.print(this.hoten.getTen());
		for(int i = 0 ; i < (12 - this.hoten.getTen().length()) ; i++) {
			System.out.print(" ");
		}
		System.out.print(this.hoten.getHo() + " " + this.hoten.getTenlot());
		for(int i = 0 ; i < (20 - (this.hoten.getHo().length() + this.hoten.getTenlot().length())) ; i++) {
			System.out.print(" ");
		}
		System.out.print(this.sinhnhat.getNgay()+"/"+this.sinhnhat.getThang()+"/"+this.sinhnhat.getNam());
		for(int i = 0 ; i < 10; i++) {
			System.out.print(" ");
		}
		System.out.println(this.luong);
	}
	
	
	@Override
	public int compareTo(NhanVien o) {
		String hovatenlot1 ="";//cho class hien tai
		String hovatenlot2 ="";//cho class tham chieu so sanh
		if(this.hoten.getTen().compareTo(o.hoten.getTen()) == 0) {
			hovatenlot1 = this.hoten.getHo() + this.hoten.getTenlot();
			hovatenlot2 = o.hoten.getHo() + o.hoten.getTenlot();
			if(hovatenlot1.compareTo(hovatenlot2) > 0) {
				return 1;
			}
			return -1;
		} else if(this.hoten.getTen().compareTo(o.hoten.getTen()) > 0){
			return 1;
		}
		return -1;
	}
}
