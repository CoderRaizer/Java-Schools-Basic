package bai1;

public class ThiSinhKhoiC extends ThiSinh {
	private double van;
	private double su;
	private double dia;

	public ThiSinhKhoiC() {
		super();
		super.setKhoi("C");
	}

	public ThiSinhKhoiC(double van, double su, double dia) {
		super();
		this.van = van;
		this.su = su;
		this.dia = dia;
	}

	public double getVan() {
		return van;
	}

	public void setVan(double van) {
		this.van = van;
	}

	public double getSu() {
		return su;
	}

	public void setSu(double su) {
		this.su = su;
	}

	public double getDia() {
		return dia;
	}

	public void setDia(double dia) {
		this.dia = dia;
	}

	/*---------------------------------------*/
	private double nhapDiem(String typescore) {
		double ret;
		do {
			System.out.print("Nhập điểm " + typescore + ": ");
			ret = o.nextDouble();
			if (ret < 0 || ret > 10) {
				System.out.println("Không hợp lệ");
			}
		} while (ret < 0 || ret > 10);
		return ret;
	}

	@Override
	public void nhapThongTinThiSinh() {
		// TODO Auto-generated method stub
		super.nhapThongTinThiSinh();
		this.van = this.nhapDiem("Văn");
		this.su = this.nhapDiem("Sử");
		this.dia = this.nhapDiem("Địa");
	}

	@Override
	public void ShowMe() {
		// TODO Auto-generated method stub
		super.ShowMe();
		System.out.println("Văn: " + this.van + " Sử: " + this.su + " Địa: " + this.dia);
	}
}
