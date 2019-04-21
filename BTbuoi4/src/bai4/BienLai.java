package bai4;

import java.util.Scanner;

public class BienLai extends KhachHang{
	private int chisocu;
	private int chisomoi;
	private int sotienphaitra;
	
	public BienLai() {
		super();
	}

	public BienLai(int chisocu, int chisomoi, int sotienphaitra) {
		super();
		this.chisocu = chisocu;
		this.chisomoi = chisomoi;
		this.sotienphaitra = sotienphaitra;
	}

	public int getChisocu() {
		return chisocu;
	}

	public void setChisocu(int chisocu) {
		this.chisocu = chisocu;
	}

	public int getChisomoi() {
		return chisomoi;
	}

	public void setChisomoi(int chisomoi) {
		this.chisomoi = chisomoi;
	}

	public int getSotienphaitra() {
		return sotienphaitra;
	}

	public void setSotienphaitra(int sotienphaitra) {
		this.sotienphaitra = sotienphaitra;
	}
	
	
	@Override
	public void nhapThongTin() {
		super.nhapThongTin();
		Scanner o = new Scanner(System.in);
		System.out.println("Chỉ số cũ: ");
		this.chisocu = o.nextInt();o = new Scanner(System.in);
		System.out.println("Chỉ số mới: ");
		this.chisomoi = o.nextInt();o = new Scanner(System.in);
	}
	
	@Override
	public void xuatThongTin() {
		super.xuatThongTin();
		System.out.println(this.chisocu + "        " + this.chisomoi);
	}
	
	public void tinhTienDien() {
		this.sotienphaitra = (this.chisomoi-this.chisocu)*1500;
		System.out.println(this.sotienphaitra);
	}
}
