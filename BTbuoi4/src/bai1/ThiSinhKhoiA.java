package bai1;

public class ThiSinhKhoiA extends ThiSinh {
	private double toan;
	private double ly;
	private double hoa;

	public ThiSinhKhoiA() {
		super();
		super.setKhoi("A");
	}

	public ThiSinhKhoiA(double toan, double ly, double hoa) {
		super();
		this.toan = toan;
		this.ly = ly;
		this.hoa = hoa;
	}

	public double getToan() {
		return toan;
	}

	public void setToan(double toan) {
		this.toan = toan;
	}

	public double getLy() {
		return ly;
	}

	public void setLy(double ly) {
		this.ly = ly;
	}

	public double getHoa() {
		return hoa;
	}

	public void setHoa(double hoa) {
		this.hoa = hoa;
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
		super.nhapThongTinThiSinh();
		this.toan = this.nhapDiem("Toán");
		this.ly = this.nhapDiem("Lý");
		this.hoa = this.nhapDiem("Hóa");
	}

	@Override
	public void ShowMe() {
		// TODO Auto-generated method stub
		super.ShowMe();
		System.out.println("Toán: " + this.toan + " Lý: " + this.ly + " Hóa: " + this.hoa);
	}
}
