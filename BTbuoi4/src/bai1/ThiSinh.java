package bai1;

import java.util.Scanner;

public class ThiSinh {
	private String sbd;
	private String hoTen;
	private String diaChi;
	private int uuTien;
	private String khoi;

	Scanner o = new Scanner(System.in);

	public ThiSinh() {
	}

	public ThiSinh(String sbd, String hoten, String diachi, int uutien, String khoi) {
		this.sbd = sbd;
		this.hoTen = hoten;
		this.diaChi = diachi;
		this.uuTien = uutien;
		this.khoi = khoi;
	}

	public String getSbd() {
		return sbd;
	}

	public void setSbd(String sbd) {
		this.sbd = sbd;
	}

	public String getHoten() {
		return hoTen;
	}

	public void setHoten(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiachi() {
		return diaChi;
	}

	public void setDiachi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getUutien() {
		return uuTien;
	}

	public void setUutien(int uuTien) {
		this.uuTien = uuTien;
	}

	public String getKhoi() {
		return khoi;
	}

	public void setKhoi(String khoi) {
		this.khoi = khoi;
	}

	/*---------------------------------------------------------------------*/

	private String nhapSoBaoDanh() {
		String sample;
		do {
			o = new Scanner(System.in);
			System.out.println("Nhập số báo danh: ");
			sample = o.nextLine();
			if (sample.length() != 10) {
				System.out.println("Eror: Số Báo Danh Phải Đủ 10 ký tự (Vd: SBD0110678)!!!");
			}

		} while (sample.length() != 10);
		return sample;
	}

	public int howManySpace(int index, String temp) {
		int count = 0;
		int z = index;
		char[] array = temp.toCharArray();
		while ((int) array[z] == 32) {
			count++;
			z++;
		}
		return count;
	}

	public String inHoaKyTuDau(String sample) {
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

	public String ChuanHoaChuoi(String sample) {
		sample = sample.trim();
		char[] array = sample.toCharArray();
		for (int i = 0; i < sample.length(); i++) {
			if ((int) array[i] == 32) {
				int del = 0;
				del = howManySpace(i, sample);
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
		return inHoaKyTuDau(sample);
	}

	private String NhapHoTen() {
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

	private String NhapDiaChi() {
		String sample;
		boolean check = true;
		do {
			o = new Scanner(System.in);
			System.out.print("Nhập Địa Chỉ (Không Dấu): ");
			sample = o.nextLine();
			char[] array = sample.toCharArray();
			for (int i = 0; i < sample.length(); i++) {
				if (((int) array[i] >= 65 && (int) array[i] <= 90) || ((int) array[i] >= 97 && (int) array[i] <= 122)
						|| ((int) array[i] == 32))
					check = true;
				else {
					check = false;
					System.out.println("Error: Nhập Địa Chỉ Không Hợp Lệ!!!");
					break;
				}
			}
		} while (check == false);
		return ChuanHoaChuoi(sample);
	}

	private int NhapDiemUuTien() {
		int ret;
		do {
			System.out.print("Nhập điểm ưu tiên của vùng (0 - 2) : ");
			ret = o.nextInt();
			if (ret < 0 || ret > 2) {
				System.out.println("Không hợp lệ");
			}
		} while (ret < 0 || ret > 2);
		return ret;
	}

	public void nhapThongTinThiSinh() {
		this.sbd = this.nhapSoBaoDanh();
		this.hoTen = this.NhapHoTen();
		this.diaChi = this.NhapDiaChi();
		this.uuTien = this.NhapDiemUuTien();
	}

	public void ShowMe() {
		System.out.print(this.hoTen);
		for (int i = 0; i < (19 - this.hoTen.length()); i++) {
			System.out.print(" ");
		}
		System.out.print(this.sbd + "  ");
		System.out.print(this.diaChi);
		for (int i = 0; i < (15 - this.diaChi.length()); i++) {
			System.out.print(" ");
		}
		System.out.print(this.uuTien + "             ");
	}
	

}
