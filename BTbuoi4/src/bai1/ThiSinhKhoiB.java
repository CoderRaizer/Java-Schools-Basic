package bai1;

public class ThiSinhKhoiB extends ThiSinh {
	private double toan;
	private double hoa;
	private double sinh;

	public ThiSinhKhoiB() {
		super();
		super.setKhoi("B");
	}

	public ThiSinhKhoiB(double toan, double hoa, double sinh) {
		super();
		this.toan = toan;
		this.hoa = hoa;
		this.sinh = sinh;
	}

	public double getToan() {
		return toan;
	}

	public void setToan(double toan) {
		this.toan = toan;
	}

	public double getHoa() {
		return hoa;
	}

	public void setHoa(double hoa) {
		this.hoa = hoa;
	}

	public double getSinh() {
		return sinh;
	}

	public void setSinh(double sinh) {
		this.sinh = sinh;
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
		this.toan = this.nhapDiem("Toán");
		this.hoa = this.nhapDiem("Hóa");
		this.hoa = this.nhapDiem("Sinh");
	}

	@Override
	public void ShowMe() {
		// TODO Auto-generated method stub
		super.ShowMe();
		System.out.println("Toán: " + this.toan + " Hóa: " + this.hoa + " Sinh: " + this.sinh);
	}

}
