package bai2;

import java.util.Scanner;

public class Nguoi extends HoDan {
	private String hoTen;
	private int tuoi;
	private int namSinh;
	private String ngheNghiep;

	Scanner o = new Scanner(System.in);

	public Nguoi() {
		super();
	}


	public Nguoi(String hoTen, int tuoi, int namSinh, String ngheNghiep) {
		super();
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.namSinh = namSinh;
		this.ngheNghiep = ngheNghiep;
	}


	public String getHoTen() {
		return hoTen;
	}


	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}


	public int getTuoi() {
		return tuoi;
	}


	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}


	public int getNamSinh() {
		return namSinh;
	}


	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}


	public String getNgheNghiep() {
		return ngheNghiep;
	}


	public void setNgheNghiep(String ngheNghiep) {
		this.ngheNghiep = ngheNghiep;
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

	public String InHoaKyTuDau(String sample) {
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
		return InHoaKyTuDau(sample);
	}

	private String nhapHoTen() {
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

	public void NhapThongTinCaNhan() {
		this.hoTen = nhapHoTen();
		System.out.print("Tuổi (Vui Lòng Nhập Số) : ");
		o = new Scanner(System.in);this.tuoi = o.nextInt();
		System.out.print("Năm sinh (Vui Lòng Nhập Số) : ");
		o = new Scanner(System.in);this.namSinh = o.nextInt();
		System.out.print("Nghề nghiệp: ");
		o = new Scanner(System.in);this.ngheNghiep = o.nextLine();
	}

	public void hienThiThongTinCaNhan(int index) {
		if (index == 0) {
			System.out.print(this.hoTen);
			for (int i = 0; i < (20 - this.hoTen.length()); i++) {
				System.out.print(" ");
			}
			System.out.println(this.tuoi + "       " + this.namSinh + "         " + this.ngheNghiep);
		} else {
			System.out.print("                             " + this.hoTen);
			for (int i = 0; i < (20 - this.hoTen.length()); i++) {
				System.out.print(" ");
			}
			System.out.println(this.tuoi + "       " + this.namSinh + "         " + this.ngheNghiep);
		}

	}

}
