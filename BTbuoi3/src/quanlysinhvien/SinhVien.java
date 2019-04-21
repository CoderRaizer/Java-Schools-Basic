package quanlysinhvien;

import java.util.Scanner;

public class SinhVien {

	Scanner o = new Scanner(System.in);

	private String mssv;
	private String hoten;
	private double diem_CPlus;
	private double diem_HDT;
	private double diem_ANM;
	private double diem_TB;
	private String xeploai;

	public SinhVien() {

	}

	public SinhVien(String hoten, String mssv, double diem_CPlus, double diem_HDT, double diem_ANM, double diemTB,
			String xeploai) {
		this.mssv = mssv;
		this.hoten = hoten;
		this.diem_CPlus = diem_CPlus;
		this.diem_HDT = diem_HDT;
		this.diem_ANM = diem_ANM;
		this.diem_TB = diemTB;
		this.xeploai = xeploai;
	}

	public String getMssv() {
		return mssv;
	}

	public void setMssv(String mssv) {
		this.mssv = mssv;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public double getDiem_CPlus() {
		return diem_CPlus;
	}

	public void setDiem_CPlus(double diem_CPlus) {
		this.diem_CPlus = diem_CPlus;
	}

	public double getDiem_HDT() {
		return diem_HDT;
	}

	public void setDiem_HDT(double diem_HDT) {
		this.diem_HDT = diem_HDT;
	}

	public double getDiem_ANM() {
		return diem_ANM;
	}

	public void setDiem_ANM(double diem_ANM) {
		this.diem_ANM = diem_ANM;
	}

	public double getDiem_TB() {
		return diem_TB;
	}

	public void setDiem_TB(double diem_TB) {
		this.diem_TB = diem_TB;
	}

	public String getxeploai() {
		return xeploai;
	}

	public void setxeploai(String xeploai) {
		this.xeploai = xeploai;
	}

	public void TinhDiemTrungBinh() {
		double dtb = (this.diem_CPlus + this.diem_HDT + this.diem_ANM) / 3;
		this.diem_TB = (double) Math.floor(dtb * 10) / 10;
	}

	public void XepLoai() {
		if (this.diem_TB >= (double) 9 && this.diem_TB <= (double) 10) {
			this.xeploai = "GIOI";
		}
		if (this.diem_TB >= (double) 7 && this.diem_TB < (double) 9) {
			this.xeploai = "KHA";
		}
		if (this.diem_TB >= (double) 5 && this.diem_TB < (double) 7) {
			this.xeploai = "TRUNG BINH";
		}
		if (this.diem_TB < (double) 5) {
			this.xeploai = "KHONG DAT";
		}
	}

	private double InputScoresRegex(String typeScore) {
		double ret;
		do {
			o = new Scanner(System.in);
			System.out.print("Nhập Điểm( không sử dụng dấu phẩy) " + typeScore + " : ");
			ret = o.nextDouble();
			if (ret < 0d || ret > 10d) {
				System.out.println("Điểm Không Hợp Lệ");
			}
		} while (ret < 0d || ret > 10d);
		return ret;
	}

	private String InputMSSVRegex() {
		String sample;
		do {
			o = new Scanner(System.in);
			System.out.println("Nhập MSSV: ");
			sample = o.nextLine();
			if (sample.length() != 10) {
				System.out.println("Eror: Mã Số SV Phải Đủ 10 ký tự (Vd: N16dccn076)!!!");
			}
		} while (sample.length() != 10);
		return sample;
	}

	/*------------------------------------------*/

	public String ChangeFirstCharacterToCase(String sample) {
		int lenght = sample.length();
		char[] array = sample.toCharArray();
		sample = "";
		int i = 0;
		while (i < lenght) {
			if (i == 0) {
				if ((int) array[i] >= 65 && (int) array[i] <= 90) {
					sample += Character.toString(array[i]);
				} else if ((int) array[i] >= 97 && (int) array[i] <= 122) {
					sample += Character.toString((char) ((int) array[i] - 32));

				}
			} else {
				if ((int) array[i] == 32) {
					sample += Character.toString(array[i]);
					i++;
					if ((int) array[i] >= 65 && (int) array[i] <= 90) {
						sample += Character.toString((char) ((int) array[i]));
					} else if ((int) array[i] >= 97 && (int) array[i] <= 122) {
						sample += Character.toString((char) ((int) array[i] - 32));
					}

				} else {
					if ((int) array[i - 1] == 32) {// neu truoc no la khoang trang
						if ((int) array[i] >= 65 && (int) array[i] <= 90) {
							sample += Character.toString((char) ((int) array[i]));
						} else if ((int) array[i] >= 97 && (int) array[i] <= 122) {
							sample += Character.toString((char) ((int) array[i] - 32));
						}
					} else if ((int) array[i - 1] >= 65 && (int) array[i - 1] <= 90) {// neu chu dung truoc la hoa
						if ((int) array[i] >= 97 && (int) array[i] <= 122) {
							sample += Character.toString((char) ((int) array[i]));
						} else if ((int) array[i] >= 65 && (int) array[i] <= 90) {
							sample += Character.toString((char) ((int) array[i] + 32));
						}
					} else if ((int) array[i - 1] >= 97 && (int) array[i - 1] <= 122) {
						if ((int) array[i] >= 97 && (int) array[i] <= 122) {
							sample += Character.toString((char) ((int) array[i]));
						} else if ((int) array[i] >= 65 && (int) array[i] <= 90) {
							sample += Character.toString((char) ((int) array[i] + 32));
						}
					}
				}
			}
			i++;
		}
		return sample;
	}

	public int HowManySpace(int index, String temp) {
		int count = 0;
		int z = index;
		char[] array = temp.toCharArray();
		while ((int) array[z] == 32) {
			count++;
			z++;
		}
		return count;
	}

	public String ChuanHoaChuoi(String sample) {
		sample = sample.trim();
		char[] array = sample.toCharArray();
		for (int i = 0; i < sample.length(); i++) {
			if ((int) array[i] == 32) {
				int del = 0;
				del = HowManySpace(i, sample);
				if (del > 1) {
					String space = "";
					for (int j = 0; j < del; j++) {
						space += " ";
					}
					while (sample.indexOf(space) != -1) {
						sample = sample.replaceAll(space, " ");
					}
				}
			}
		}
		return ChangeFirstCharacterToCase(sample);
	}

	private String InputHoTenRegex() {
		String sample;
		boolean check = true;
		do {
			o = new Scanner(System.in);
			System.out.print("Nhập Họ Tên (Không Dấu): ");
			sample = o.nextLine();
			char[] array = sample.toCharArray();
			for (int i = 0; i < sample.length(); i++) {
				if (((int) array[i] >= 65 && (int) array[i] <= 90) || ((int) array[i] >= 97 && (int) array[i] <= 122)
						|| ((int) array[i] == 32))
					check = true;
				else {
					check = false;
					System.out.println("Error: Nhập Tên Không Hợp Lệ!!!");
					break;
				}
			}
		} while (check == false);
		return ChuanHoaChuoi(sample);
	}
	/*------------------------------------------*/

	public void SetInfoStudent() {
		this.mssv = this.InputMSSVRegex();
		this.hoten = this.InputHoTenRegex();
		this.diem_CPlus = this.InputScoresRegex("C++");
		this.diem_HDT = this.InputScoresRegex("HĐT");
		this.diem_ANM = this.InputScoresRegex("ANM");
		TinhDiemTrungBinh();
		XepLoai();
	}

	public void ShowInfoStudent() {
		System.out.print(this.hoten);
		for (int i = 0; i < (19 - this.hoten.length()); i++) {
			System.out.print(" ");
		}
		System.out.println(this.mssv + "  " + this.diem_CPlus + "             " + this.diem_HDT + "             "
				+ this.diem_ANM + "               " + this.diem_TB + "          " + this.xeploai);
	}

}
