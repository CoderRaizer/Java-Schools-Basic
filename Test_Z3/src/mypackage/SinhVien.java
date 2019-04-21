package mypackage;

import java.util.Scanner;

public class SinhVien {

	Scanner o = new Scanner(System.in);

	private String mssv;
	private String hoten;
	private float diem_Toan;
	private float diem_Ly;
	private float diem_Hoa;
	private float diem_TB;
	private String xeploai;

	public SinhVien() {

	}

	public SinhVien(String mssv, String hoten,  float diem_Toan, float diem_Ly, float diem_Hoa, float diemTB,String xeploai) {
		this.mssv = mssv;
		this.hoten = hoten;
		this.diem_Toan = diem_Toan;
		this.diem_Ly = diem_Ly;
		this.diem_Hoa = diem_Hoa;
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

	public float getDiem_Toan() {
		return diem_Toan;
	}

	public void setDiem_Toan(float diem_Toan) {
		this.diem_Toan = diem_Toan;
	}

	public float getDiem_Ly() {
		return diem_Ly;
	}

	public void setDiem_Ly(float diem_Ly) {
		this.diem_Ly = diem_Ly;
	}

	public float getDiem_Hoa() {
		return diem_Hoa;
	}

	public void setDiem_Hoa(float diem_Hoa) {
		this.diem_Hoa = diem_Hoa;
	}

	public float getDiem_TB() {
		return diem_TB;
	}

	public void setDiem_TB(float diem_TB) {
		this.diem_TB = diem_TB;
	}

	public String getXeploai() {
		return xeploai;
	}

	public void setXeploai(String xeploai) {
		this.xeploai = xeploai;
	}

	
	
	public void TinhDiemTrungBinh() {
		float dtb = (this.diem_Toan + this.diem_Ly + this.diem_Hoa) / 3;
		this.diem_TB = (float) Math.floor(dtb * 10) / 10;
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

	public String StandardizeString(String sample) {
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
		return StandardizeString(sample);
	}
	/*------------------------------------------*/

	public void ShowInfoStudent() {
		System.out.print(this.hoten);
		for (int i = 0; i < (19 - this.hoten.length()); i++) {
			System.out.print(" ");
		}
		System.out.println(this.mssv + "  " + this.diem_Toan + "             " + this.diem_Ly + "             "
				+ this.diem_Hoa+ "               " + this.diem_TB + "          " + this.xeploai);
	}

}
